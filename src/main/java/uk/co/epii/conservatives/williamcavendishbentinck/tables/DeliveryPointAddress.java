package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class DeliveryPointAddress {

    private int recordIdentifier;
    private String changeType;
    private long proOrder;
    private long uprn;
    private Long parentAddressableUprn;
    private int rmUdprn;
    private String organisationName;
    private String departmentName;
    private String subBuildingName;
    private String buildingName;
    private Integer buildingNumber;
    private String dependentThoroughfareName;
    private String thoroughfareName;
    private String doubleDependentLocality;
    private String dependentLocality;
    private String postTown;
    private String postcode;
    private String postcodeType;
    private String welshDependentThoroughfareName;
    private String welshThoroughfareName;
    private String welshDoubleDependentLocality;
    private String welshDependentLocality;
    private String welshPostTown;
    private String poBoxNumber;
    private Date processDate;
    private Date startDate;
    private Date endDate;
    private Date lastUpdateDate;
    private Date entryDate;

    public DeliveryPointAddress () {}
    public DeliveryPointAddress (int recordIdentifier, String changeType, long proOrder, long uprn, Long parentAddressableUprn, int rmUdprn, String organisationName, String departmentName, String subBuildingName, String buildingName, Integer buildingNumber, String dependentThoroughfareName, String thoroughfareName, String doubleDependentLocality, String dependentLocality, String postTown, String postcode, String postcodeType, String welshDependentThoroughfareName, String welshThoroughfareName, String welshDoubleDependentLocality, String welshDependentLocality, String welshPostTown, String poBoxNumber, Date processDate, Date startDate, Date endDate, Date lastUpdateDate, Date entryDate) {
        this.recordIdentifier = recordIdentifier;
        this.changeType = changeType;
        this.proOrder = proOrder;
        this.uprn = uprn;
        this.parentAddressableUprn = parentAddressableUprn;
        this.rmUdprn = rmUdprn;
        this.organisationName = organisationName;
        this.departmentName = departmentName;
        this.subBuildingName = subBuildingName;
        this.buildingName = buildingName;
        this.buildingNumber = buildingNumber;
        this.dependentThoroughfareName = dependentThoroughfareName;
        this.thoroughfareName = thoroughfareName;
        this.doubleDependentLocality = doubleDependentLocality;
        this.dependentLocality = dependentLocality;
        this.postTown = postTown;
        this.postcode = postcode;
        this.postcodeType = postcodeType;
        this.welshDependentThoroughfareName = welshDependentThoroughfareName;
        this.welshThoroughfareName = welshThoroughfareName;
        this.welshDoubleDependentLocality = welshDoubleDependentLocality;
        this.welshDependentLocality = welshDependentLocality;
        this.welshPostTown = welshPostTown;
        this.poBoxNumber = poBoxNumber;
        this.processDate = processDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdateDate = lastUpdateDate;
        this.entryDate = entryDate;
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

    public Long getParentAddressableUprn() {
        return parentAddressableUprn;
    }

    public void setParentAddressableUprn(Long parentAddressableUprn) {
        this.parentAddressableUprn = parentAddressableUprn;
    }

    public int getRmUdprn() {
        return rmUdprn;
    }

    public void setRmUdprn(int rmUdprn) {
        this.rmUdprn = rmUdprn;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSubBuildingName() {
        return subBuildingName;
    }

    public void setSubBuildingName(String subBuildingName) {
        this.subBuildingName = subBuildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getDependentThoroughfareName() {
        return dependentThoroughfareName;
    }

    public void setDependentThoroughfareName(String dependentThoroughfareName) {
        this.dependentThoroughfareName = dependentThoroughfareName;
    }

    public String getThoroughfareName() {
        return thoroughfareName;
    }

    public void setThoroughfareName(String thoroughfareName) {
        this.thoroughfareName = thoroughfareName;
    }

    public String getDoubleDependentLocality() {
        return doubleDependentLocality;
    }

    public void setDoubleDependentLocality(String doubleDependentLocality) {
        this.doubleDependentLocality = doubleDependentLocality;
    }

    public String getDependentLocality() {
        return dependentLocality;
    }

    public void setDependentLocality(String dependentLocality) {
        this.dependentLocality = dependentLocality;
    }

    public String getPostTown() {
        return postTown;
    }

    public void setPostTown(String postTown) {
        this.postTown = postTown;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcodeType() {
        return postcodeType;
    }

    public void setPostcodeType(String postcodeType) {
        this.postcodeType = postcodeType;
    }

    public String getWelshDependentThoroughfareName() {
        return welshDependentThoroughfareName;
    }

    public void setWelshDependentThoroughfareName(String welshDependentThoroughfareName) {
        this.welshDependentThoroughfareName = welshDependentThoroughfareName;
    }

    public String getWelshThoroughfareName() {
        return welshThoroughfareName;
    }

    public void setWelshThoroughfareName(String welshThoroughfareName) {
        this.welshThoroughfareName = welshThoroughfareName;
    }

    public String getWelshDoubleDependentLocality() {
        return welshDoubleDependentLocality;
    }

    public void setWelshDoubleDependentLocality(String welshDoubleDependentLocality) {
        this.welshDoubleDependentLocality = welshDoubleDependentLocality;
    }

    public String getWelshDependentLocality() {
        return welshDependentLocality;
    }

    public void setWelshDependentLocality(String welshDependentLocality) {
        this.welshDependentLocality = welshDependentLocality;
    }

    public String getWelshPostTown() {
        return welshPostTown;
    }

    public void setWelshPostTown(String welshPostTown) {
        this.welshPostTown = welshPostTown;
    }

    public String getPoBoxNumber() {
        return poBoxNumber;
    }

    public void setPoBoxNumber(String poBoxNumber) {
        this.poBoxNumber = poBoxNumber;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
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

}
