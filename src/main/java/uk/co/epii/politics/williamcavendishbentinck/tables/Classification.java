package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;


public class Classification {

    private int recordIdentifier;
    private char changeType;
    private long proOrder;
    private long uprn;
    private String classKey;
    private String classificationCode;
    private String classScheme;
    private float schemaVersion;
    private Date startDate;
    private Date endDate;
    private Date lastUpdateDate;

    public Classification () {}
    public Classification (int recordIdentifier, char changeType, long proOrder, long uprn, String classKey, String classificationCode, String classScheme, float schemaVersion, Date startDate, Date endDate, Date lastUpdateDate) {
        this.recordIdentifier = recordIdentifier;
        this.changeType = changeType;
        this.proOrder = proOrder;
        this.uprn = uprn;
        this.classKey = classKey;
        this.classificationCode = classificationCode;
        this.classScheme = classScheme;
        this.schemaVersion = schemaVersion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getRecordIdentifier() {
        return recordIdentifier;
    }

    public void setRecordIdentifier(int recordIdentifier) {
        this.recordIdentifier = recordIdentifier;
    }

    public char getChangeType() {
        return changeType;
    }

    public void setChangeType(char changeType) {
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

    public String getClassKey() {
        return classKey;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassScheme() {
        return classScheme;
    }

    public void setClassScheme(String classScheme) {
        this.classScheme = classScheme;
    }

    public float getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(float schemaVersion) {
        this.schemaVersion = schemaVersion;
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

}
