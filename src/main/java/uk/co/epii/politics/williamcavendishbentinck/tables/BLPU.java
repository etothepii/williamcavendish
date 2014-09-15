package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class BLPU {

    private int recordIdentifier;
    private String changeType;
    private long proOrder;
    private long uprn;
    private int logicalStatus;
    private Integer blpuState;
    private Date blpuStateDate;
    private Long parentUprn;
    private float XCoordinate;
    private float YCoordinate;
    private int rpc;
    private int localCustodianCode;
    private Date startDate;
    private Date endDate;
    private Date lastUpdateDate;
    private Date entryDate;
    private String postalAddress;
    private String postcodeLocator;
    private int multiOccCount;

    public BLPU () {}
    public BLPU (int recordIdentifier, String changeType, long proOrder, long uprn, int logicalStatus, Integer blpuState, Date blpuStateDate, Long parentUprn, float XCoordinate, float YCoordinate, int rpc, int localCustodianCode, Date startDate, Date endDate, Date lastUpdateDate, Date entryDate, String postalAddress, String postcodeLocator, int multiOccCount) {
        this.recordIdentifier = recordIdentifier;
        this.changeType = changeType;
        this.proOrder = proOrder;
        this.uprn = uprn;
        this.logicalStatus = logicalStatus;
        this.blpuState = blpuState;
        this.blpuStateDate = blpuStateDate;
        this.parentUprn = parentUprn;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.rpc = rpc;
        this.localCustodianCode = localCustodianCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdateDate = lastUpdateDate;
        this.entryDate = entryDate;
        this.postalAddress = postalAddress;
        this.postcodeLocator = postcodeLocator;
        this.multiOccCount = multiOccCount;
    }

    public int getRecordIdentifier() {
        return recordIdentifier;
    }

    public void setRecordIdentifier(int recordIdentifier) {
        this.recordIdentifier = recordIdentifier;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public long getProOrder() {
        return proOrder;
    }

    public void setProOrder(long proOrder) {
        this.proOrder = proOrder;
    }

    public long getUprn() {
        return uprn;
    }

    public void setUprn(long uprn) {
        this.uprn = uprn;
    }

    public int getLogicalStatus() {
        return logicalStatus;
    }

    public void setLogicalStatus(int logicalStatus) {
        this.logicalStatus = logicalStatus;
    }

    public Integer getBlpuState() {
        return blpuState;
    }

    public void setBlpuState(Integer blpuState) {
        this.blpuState = blpuState;
    }

    public Date getBlpuStateDate() {
        return blpuStateDate;
    }

    public void setBlpuStateDate(Date blpuStateDate) {
        this.blpuStateDate = blpuStateDate;
    }

    public Long getParentUprn() {
        return parentUprn;
    }

    public void setParentUprn(Long parentUprn) {
        this.parentUprn = parentUprn;
    }

    public float getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(float XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public float getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(float YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public int getRpc() {
        return rpc;
    }

    public void setRpc(int rpc) {
        this.rpc = rpc;
    }

    public int getLocalCustodianCode() {
        return localCustodianCode;
    }

    public void setLocalCustodianCode(int localCustodianCode) {
        this.localCustodianCode = localCustodianCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostcodeLocator() {
        return postcodeLocator;
    }

    public void setPostcodeLocator(String postcodeLocator) {
        this.postcodeLocator = postcodeLocator;
    }

    public int getMultiOccCount() {
        return multiOccCount;
    }

    public void setMultiOccCount(int multiOccCount) {
        this.multiOccCount = multiOccCount;
    }

}
