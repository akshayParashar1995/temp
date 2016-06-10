package com.example.akshay.warehouse.models;

import java.util.Date;
import java.util.UUID;

/**
 * Created by akshay on 29/10/15.
 */
public class Product {


    private int ReceiveProductDetailsID;
    private String ClientCode;
    private String RTagNo;
    private int ReceiveDetailsID;
    private int ProductMasterID;
    private String BatchNo;
    private String LotNo;
    private String BarcodeNo;
    private String MFGDate;
    private String EXPDate;
    private int QuantitytoReceive;
    private int QuantityReceived;
    private String BarcodeNo1;
    private String CreatedBy;
    private String CreatedDate;
    private String ProductCode;
    private String ColdStorage;
    private String ProductClassCode;
    private int ProductClassID;
    private String ReceiveStatus;
    private String QualityStatus;
    private String location;
    private boolean isCompleted;
    private String mTitle;

    public Product(int receiveProductDetailsID, String clientCode, String RTagNo, int receiveDetailsID, int productMasterID, String batchNo, String lotNo, String barcodeNo, String MFGDate, String EXPDate, int quantitytoReceive, int quantityReceived, String barcodeNo1, String createdBy, String createdDate, String productCode, String coldStorage, String productClassCode, int productClassID, String receiveStatus, String location, boolean isCompleted, String mTitle) {
        ReceiveProductDetailsID = receiveProductDetailsID;
        ClientCode = clientCode;
        this.RTagNo = RTagNo;
        ReceiveDetailsID = receiveDetailsID;
        ProductMasterID = productMasterID;
        BatchNo = batchNo;
        LotNo = lotNo;
        BarcodeNo = barcodeNo;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        QuantitytoReceive = quantitytoReceive;
        QuantityReceived = quantityReceived;
        BarcodeNo1 = barcodeNo1;
        CreatedBy = createdBy;
        CreatedDate = createdDate;
        ProductCode = productCode;
        ColdStorage = coldStorage;
        ProductClassCode = productClassCode;
        ProductClassID = productClassID;
        ReceiveStatus = receiveStatus;
        this.location = location;
        this.isCompleted = isCompleted;
        this.mTitle = mTitle;
    }

    public int getReceiveProductDetailsID() {
        return ReceiveProductDetailsID;
    }

    public void setReceiveProductDetailsID(int receiveProductDetailsID) {
        ReceiveProductDetailsID = receiveProductDetailsID;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getRTagNo() {
        return RTagNo;
    }

    public void setRTagNo(String RTagNo) {
        this.RTagNo = RTagNo;
    }

    public int getReceiveDetailsID() {
        return ReceiveDetailsID;
    }

    public void setReceiveDetailsID(int receiveDetailsID) {
        ReceiveDetailsID = receiveDetailsID;
    }

    public int getProductMasterID() {
        return ProductMasterID;
    }

    public void setProductMasterID(int productMasterID) {
        ProductMasterID = productMasterID;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public String getLotNo() {
        return LotNo;
    }

    public void setLotNo(String lotNo) {
        LotNo = lotNo;
    }

    public String getBarcodeNo() {
        return BarcodeNo;
    }

    public void setBarcodeNo(String barcodeNo) {
        BarcodeNo = barcodeNo;
    }

    public String getMFGDate() {
        return MFGDate;
    }

    public void setMFGDate(String MFGDate) {
        this.MFGDate = MFGDate;
    }

    public String getEXPDate() {
        return EXPDate;
    }

    public void setEXPDate(String EXPDate) {
        this.EXPDate = EXPDate;
    }

    public int getQuantitytoReceive() {
        return QuantitytoReceive;
    }

    public void setQuantitytoReceive(int quantitytoReceive) {
        QuantitytoReceive = quantitytoReceive;
    }

    public int getQuantityReceived() {
        return QuantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        QuantityReceived = quantityReceived;
    }

    public String getBarcodeNo1() {
        return BarcodeNo1;
    }

    public void setBarcodeNo1(String barcodeNo1) {
        BarcodeNo1 = barcodeNo1;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getColdStorage() {
        return ColdStorage;
    }

    public void setColdStorage(String coldStorage) {
        ColdStorage = coldStorage;
    }

    public String getProductClassCode() {
        return ProductClassCode;
    }

    public void setProductClassCode(String productClassCode) {
        ProductClassCode = productClassCode;
    }

    public int getProductClassID() {
        return ProductClassID;
    }

    public void setProductClassID(int productClassID) {
        ProductClassID = productClassID;
    }

    public String getReceiveStatus() {
        return ReceiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        ReceiveStatus = receiveStatus;
    }

    public String getQualityStatus() {
        return QualityStatus;
    }

    public void setQualityStatus(String qualityStatus) {
        QualityStatus = qualityStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
