package com.huatec.edu.mobileshop.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.LoginActivity;
import com.huatec.edu.mobileshop.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PersonFragment extends BaseFragment {


    @BindView(R.id.user_img_view)
    ImageView userImgView;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_level)
    TextView userLevel;
    @BindView(R.id.personal_for_login)
    RelativeLayout personalForLogin;
    @BindView(R.id.personal_login)
    Button personalLogin;
    @BindView(R.id.personal_for_not_login)
    RelativeLayout personalForNotLogin;
    @BindView(R.id.person_my_order)
    RelativeLayout personMyOrder;
    @BindView(R.id.my_collect)
    RelativeLayout myCollect;
    @BindView(R.id.my_address)
    RelativeLayout myAddress;
    @BindView(R.id.my_account)
    RelativeLayout myAccount;
    @BindView(R.id.person_logout_layout)
    RelativeLayout personLogoutLayout;
    Unbinder unbinder;

    private MainActivity mainActivity;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.personal_login, R.id.person_my_order, R.id.my_collect,
            R.id.my_address, R.id.my_account, R.id.person_logout_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_login:
                startActivity(new Intent(mainActivity,LoginActivity.class));
                break;
            case R.id.person_my_order:
                if(mainActivity.isLogin()){
                    //startActivity(new Intent(mainActivity,MyOrderActivity.class));
                    return;
                }
                //startActivityForResult(new Intent(mainActivity,LoginActivity.class),MY_ORDER);
                break;
            case R.id.my_collect:
                break;
            case R.id.my_address:
                break;
            case R.id.my_account:
                break;
            case R.id.person_logout_layout:
                break;
        }
    }
}
