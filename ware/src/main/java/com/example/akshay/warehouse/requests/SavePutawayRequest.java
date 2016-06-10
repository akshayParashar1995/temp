package com.example.akshay.warehouse.requests;

/**
 * Created by akshay on 20/12/15.
 */
public class SavePutawayRequest extends BaseRequest{
    private int detailid;
    private int productclass;
    private String barcode;
    private String location;

    public SavePutawayRequest(String username,String password,int detailid, int productclass, String barcode, String location) {
        super(username,password);
        this.detailid = detailid;
        this.productclass = productclass;
        this.barcode = barcode;
        this.location = location;
    }

    public int getDetailid() {
        return detailid;
    }

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public int getProductclass() {
        return productclass;
    }

    public void setProductclass(int productclass) {
        this.productclass = productclass;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
