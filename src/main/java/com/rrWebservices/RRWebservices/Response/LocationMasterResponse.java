package com.rrWebservices.RRWebservices.Response;

public class LocationMasterResponse {
private int id;
private String locationCode;
private String effectiveDate;
private String terminationDate;
private String errormsg;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLocationCode() {
	return locationCode;
}
public void setLocationCode(String locationCode) {
	this.locationCode = locationCode;
}
public String getEffectiveDate() {
	return effectiveDate;
}
public void setEffectiveDate(String effectiveDate) {
	this.effectiveDate = effectiveDate;
}
public String getTerminationDate() {
	return terminationDate;
}
public void setTerminationDate(String terminationDate) {
	this.terminationDate = terminationDate;
}
public String getErrormsg() {
	return errormsg;
}
public void setErrormsg(String errormsg) {
	this.errormsg = errormsg;
}

}
