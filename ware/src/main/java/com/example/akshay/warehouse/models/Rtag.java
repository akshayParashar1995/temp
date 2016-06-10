package com.example.akshay.warehouse.models;

/**
 * Created by Administrator on 28/05/2015.
 */
public class Rtag {

    private String ReferenceNo;
    private String DateClosed;
    private String DateOpened;
    private int VersionNo;
    private int ReceiveDetailsID;
    private String Status;
    private String OrderType;
    private String PutAwayStatus;
    private String rtagstarttime;
    private String rtagendtime;
    private int RTagMins;
    private String putawaystarttime;
    private String putawayendtime;
    private int PutAwayDuration;
    private int TotalRTagDuration;
    private String PutAwayDoneBy;
    private String PutAwaySelectionDoneBy;
    private String PutAwayDate;
    private int AdvanceShippingNotificationID;
    private String RTagNo;
    private int ClientMasterID;
    private int WarehouseMasterID;
    private String ETD;
    private String ETA;
    private String ReceivedDate;
    private String ClosedBy;
    private String OpenedBy;
    private String CreatedBy;
    private String ModifiedBy;
    private String CreatedOn;
    private String WarehouseCode;
    private String ClientCode;
    private int ServicesAppliedID;
    private int TotalRows;
    private int RowNos;

    public Rtag(String referenceNo, String dateClosed, String dateOpened, int versionNo, int receiveDetailsID, String status, String orderType, String putAwayStatus, String rtagstarttime, String rtagendtime, int RTagMins, String putawaystarttime, String putawayendtime, int putAwayDuration, int totalRTagDuration, String putAwayDoneBy, String putAwaySelectionDoneBy, String putAwayDate, int advanceShippingNotificationID, String RTagNo, int clientMasterID, int warehouseMasterID, String ETD, String ETA, String receivedDate, String closedBy, String openedBy, String createdBy, String modifiedBy, String createdOn, String warehouseCode, String clientCode, int servicesAppliedID, int totalRows, int rowNos) {
        ReferenceNo = referenceNo;
        DateClosed = dateClosed;
        DateOpened = dateOpened;
        VersionNo = versionNo;
        ReceiveDetailsID = receiveDetailsID;
        Status = status;
        OrderType = orderType;
        PutAwayStatus = putAwayStatus;
        this.rtagstarttime = rtagstarttime;
        rtagendtime = rtagendtime;
        this.RTagMins = RTagMins;
        this.putawaystarttime = putawaystarttime;
        this.putawayendtime = putawayendtime;
        PutAwayDuration = putAwayDuration;
        TotalRTagDuration = totalRTagDuration;
        PutAwayDoneBy = putAwayDoneBy;
        PutAwaySelectionDoneBy = putAwaySelectionDoneBy;
        PutAwayDate = putAwayDate;
        AdvanceShippingNotificationID = advanceShippingNotificationID;
        this.RTagNo = RTagNo;
        ClientMasterID = clientMasterID;
        WarehouseMasterID = warehouseMasterID;
        this.ETD = ETD;
        this.ETA = ETA;
        ReceivedDate = receivedDate;
        ClosedBy = closedBy;
        OpenedBy = openedBy;
        CreatedBy = createdBy;
        ModifiedBy = modifiedBy;
        CreatedOn = createdOn;
        WarehouseCode = warehouseCode;
        ClientCode = clientCode;
        ServicesAppliedID = servicesAppliedID;
        TotalRows = totalRows;
        RowNos = rowNos;
    }

    public String getReferenceNo() {
        return ReferenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        ReferenceNo = referenceNo;
    }

    public String getDateClosed() {
        return DateClosed;
    }

    public void setDateClosed(String dateClosed) {
        DateClosed = dateClosed;
    }

    public String getDateOpened() {
        return DateOpened;
    }

    public void setDateOpened(String dateOpened) {
        DateOpened = dateOpened;
    }

    public int getVersionNo() {
        return VersionNo;
    }

    public void setVersionNo(int versionNo) {
        VersionNo = versionNo;
    }

    public int getReceiveDetailsID() {
        return ReceiveDetailsID;
    }

    public void setReceiveDetailsID(int receiveDetailsID) {
        ReceiveDetailsID = receiveDetailsID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getPutAwayStatus() {
        return PutAwayStatus;
    }

    public void setPutAwayStatus(String putAwayStatus) {
        PutAwayStatus = putAwayStatus;
    }

    public String getRtagstarttime() {
        return rtagstarttime;
    }

    public void setRtagstarttime(String rtagstarttime) {
        this.rtagstarttime = rtagstarttime;
    }

    public String getRtagendtime() {
        return rtagendtime;
    }

    public void setRtagendtime(String rtagendtime) {
        this.rtagendtime = rtagendtime;
    }

    public int getRTagMins() {
        return RTagMins;
    }

    public void setRTagMins(int RTagMins) {
        this.RTagMins = RTagMins;
    }

    public String getPutawaystarttime() {
        return putawaystarttime;
    }

    public void setPutawaystarttime(String putawaystarttime) {
        this.putawaystarttime = putawaystarttime;
    }

    public String getPutawayendtime() {
        return putawayendtime;
    }

    public void setPutawayendtime(String putawayendtime) {
        this.putawayendtime = putawayendtime;
    }

    public int getPutAwayDuration() {
        return PutAwayDuration;
    }

    public void setPutAwayDuration(int putAwayDuration) {
        PutAwayDuration = putAwayDuration;
    }

    public int getTotalRTagDuration() {
        return TotalRTagDuration;
    }

    public void setTotalRTagDuration(int totalRTagDuration) {
        TotalRTagDuration = totalRTagDuration;
    }

    public String getPutAwayDoneBy() {
        return PutAwayDoneBy;
    }

    public void setPutAwayDoneBy(String putAwayDoneBy) {
        PutAwayDoneBy = putAwayDoneBy;
    }

    public String getPutAwaySelectionDoneBy() {
        return PutAwaySelectionDoneBy;
    }

    public void setPutAwaySelectionDoneBy(String putAwaySelectionDoneBy) {
        PutAwaySelectionDoneBy = putAwaySelectionDoneBy;
    }

    public String getPutAwayDate() {
        return PutAwayDate;
    }

    public void setPutAwayDate(String putAwayDate) {
        PutAwayDate = putAwayDate;
    }

    public int getAdvanceShippingNotificationID() {
        return AdvanceShippingNotificationID;
    }

    public void setAdvanceShippingNotificationID(int advanceShippingNotificationID) {
        AdvanceShippingNotificationID = advanceShippingNotificationID;
    }

    public String getRTagNo() {
        return RTagNo;
    }

    public void setRTagNo(String RTagNo) {
        this.RTagNo = RTagNo;
    }

    public int getClientMasterID() {
        return ClientMasterID;
    }

    public void setClientMasterID(int clientMasterID) {
        ClientMasterID = clientMasterID;
    }

    public int getWarehouseMasterID() {
        return WarehouseMasterID;
    }

    public void setWarehouseMasterID(int warehouseMasterID) {
        WarehouseMasterID = warehouseMasterID;
    }

    public String getETD() {
        return ETD;
    }

    public void setETD(String ETD) {
        this.ETD = ETD;
    }

    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    public String getReceivedDate() {
        return ReceivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        ReceivedDate = receivedDate;
    }

    public String getClosedBy() {
        return ClosedBy;
    }

    public void setClosedBy(String closedBy) {
        ClosedBy = closedBy;
    }

    public String getOpenedBy() {
        return OpenedBy;
    }

    public void setOpenedBy(String openedBy) {
        OpenedBy = openedBy;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        WarehouseCode = warehouseCode;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public int getServicesAppliedID() {
        return ServicesAppliedID;
    }

    public void setServicesAppliedID(int servicesAppliedID) {
        ServicesAppliedID = servicesAppliedID;
    }

    public int getTotalRows() {
        return TotalRows;
    }

    public void setTotalRows(int totalRows) {
        TotalRows = totalRows;
    }

    public int getRowNos() {
        return RowNos;
    }

    public void setRowNos(int rowNos) {
        RowNos = rowNos;
    }
}
