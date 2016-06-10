package com.example.akshay.warehouse.requests;

import com.example.akshay.warehouse.extras.Globals;

/**
 * Created by akshay on 15/12/15.
 */
public class RtagRequest extends BaseRequest{
    private int client;
    private int warehouse;
    private String rtagno;
    private String etd;
    private String eta;
    private int totalrows;
    private int createddate;

    public RtagRequest(int client, int warehouse, String rtagno, String etd, String eta, int totalrows, int createddate) {
        super(Globals.baseRequest.getUser(),Globals.baseRequest.getPwd());
        this.client = client;
        this.warehouse = warehouse;
        this.rtagno = rtagno;
        this.etd = etd;
        this.eta = eta;
        this.totalrows = totalrows;
        this.createddate = createddate;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public String getRtagno() {
        return rtagno;
    }

    public void setRtagno(String rtagno) {
        this.rtagno = rtagno;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public int getTotalrows() {
        return totalrows;
    }

    public void setTotalrows(int totalrows) {
        this.totalrows = totalrows;
    }

    public int getCreateddate() {
        return createddate;
    }

    public void setCreateddate(int createddate) {
        this.createddate = createddate;
    }
}
