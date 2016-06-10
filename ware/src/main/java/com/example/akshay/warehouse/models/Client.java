package com.example.akshay.warehouse.models;

/**
 * Created by akshay on 14/12/15.
 */
public class Client {
    private int ClientMasterID;
    private String ClientCode;
    private int status;

    public Client(int clientMasterID, String clientCode, int status) {
        ClientMasterID = clientMasterID;
        ClientCode = clientCode;
        this.status = status;
    }

    public int getClientMasterID() {
        return ClientMasterID;
    }

    public void setClientMasterID(int ClientMasterID) {
        this.ClientMasterID = ClientMasterID;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String ClientCode) {
        this.ClientCode = ClientCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
