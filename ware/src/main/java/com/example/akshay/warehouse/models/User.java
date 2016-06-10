package com.example.akshay.warehouse.models;

/**
 * Created by akshay on 14/12/15.
 */
public class User {
    private int UserID;
    private String UserName;
    private int ClientMasterID;
    private int putaway;
    private int predelivery;
    private int picking;
    private int cyclecount;

    public User() {
    }

    public User(int userID, String userName, int clientMasterID, int putaway, int predelivery, int picking, int cyclecount) {
        UserID = userID;
        UserName = userName;
        ClientMasterID = clientMasterID;
        this.putaway = putaway;
        this.predelivery = predelivery;
        this.picking = picking;
        this.cyclecount = cyclecount;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getClientMasterID() {
        return ClientMasterID;
    }

    public void setClientMasterID(int clientMasterID) {
        ClientMasterID = clientMasterID;
    }

    public int getPutaway() {
        return putaway;
    }

    public void setPutaway(int putaway) {
        this.putaway = putaway;
    }

    public int getPredelivery() {
        return predelivery;
    }

    public void setPredelivery(int predelivery) {
        this.predelivery = predelivery;
    }

    public int getPicking() {
        return picking;
    }

    public void setPicking(int picking) {
        this.picking = picking;
    }

    public int getCyclecount() {
        return cyclecount;
    }

    public void setCyclecount(int cyclecount) {
        this.cyclecount = cyclecount;
    }
}
