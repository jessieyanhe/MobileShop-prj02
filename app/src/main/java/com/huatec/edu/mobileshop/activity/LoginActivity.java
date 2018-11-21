package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.Constants;
import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.http.ProgressDialogSubscriber;
import com.huatec.edu.mobileshop.http.presenter.MemberPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.SMSSDK;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.login_input_name)
    EditText loginInputName;
    @BindView(R.id.login_input_password)
    EditText loginInputPassword;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.register_link)
    TextView registerLink;
    @BindView(R.id.find_password_text)
    TextView findPasswordText;

    private final int REQUEST_CODE_REGISTER = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //SMSSDK.initSDK(this, Constants.API_KEY_FOR_MOB_SMS,Constants.API_SECRET_FOR_MOB_SMS);
    }

    @OnClick({R.id.title_back, R.id.login_button, R.id.register_link, R.id.find_password_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back: //返回
                finish();
                break;
            case R.id.login_button://登录
                login();
                break;
            case R.id.register_link://快速注册
                startActivityForResult(new Intent(LoginActivity.this,RegisterActivity.class),REQUEST_CODE_REGISTER);
                break;
            case R.id.find_password_text://找回密码
                startActivity(new Intent(LoginActivity.this,FindPWDActivity.class));
                break;
        }
    }

    private void login(){
        final String username = loginInputName.getText().toString().trim();
        final String password = loginInputPassword.getText().toString().trim();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();;
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();;
            return;
        }

        //联网请求
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                //登录成功后返回用户信息
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
               //使用sharedPreferences将用户信息保存到本地
                SharedPreferences.Editor localEditor = getSharedPreferences("user",0).edit();
                localEditor.putInt("member_id",memberEntity.getMember_id());
                localEditor.putString("uname",memberEntity.getUname());
                localEditor.putString("email",memberEntity.getEmail());
                localEditor.putString("image",memberEntity.getImage());
                localEditor.commit();

                //登录成功后返回到之前的页面，并回传数据
                Intent returnIntent = new Intent();
                returnIntent.putExtra("logined",true);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        },username,password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE_REGISTER){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("logined",true);
            setResult(RESULT_OK,returnIntent);
            finish();
        }
    }
}
