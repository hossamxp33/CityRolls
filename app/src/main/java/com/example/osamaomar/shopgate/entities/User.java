package com.example.osamaomar.shopgate.entities;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class User {

    private String mobile;
    private  String username;
    private String password;
    private String repassword;

    private int active =1,usergroup=2,emailverified = 1;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(int usergroup) {
        this.usergroup = usergroup;
    }

    public int getEmailverified() {
        return emailverified;
    }

    public void setEmailverified(int emailverified) {
        this.emailverified = emailverified;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
