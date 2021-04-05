package com.sample.healthtrainingapp;

public class UserData {
    private String userId;
    private String userPassword;
    private String userAuthority;
    private static UserData userData = null;

    private UserData(){}

    public static UserData getInstance(){
        if (userData == null){
            userData = new UserData();
        }
        return userData;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAuthority() {
        return userAuthority;
    }
    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }
}
