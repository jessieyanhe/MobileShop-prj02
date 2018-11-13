package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;

public class MemberEntity implements Serializable{
    private int member_id;
    private String uname;
    private String passward;
    private String email;
    private int sex;
    private String mobile;
    private Object regtime;
    private Object lastLogin;
    private String image;
    private Object memberAddresses;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getRegtime() {
        return regtime;
    }

    public void setRegtime(Object regtime) {
        this.regtime = regtime;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getMemberAddresses() {
        return memberAddresses;
    }

    public void setMemberAddresses(Object memberAddresses) {
        this.memberAddresses = memberAddresses;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", passward='" + passward + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastLogin=" + lastLogin +
                ", image='" + image + '\'' +
                ", memberAddresses=" + memberAddresses +
                '}';
    }
}
