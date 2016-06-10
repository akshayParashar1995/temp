package com.example.akshay.warehouse.requests;

/**
 * Created by akshay on 14/12/15.
 */
public class BaseRequest {
    private String user;
    private String pwd;

    public BaseRequest(){

    }
    public BaseRequest(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
