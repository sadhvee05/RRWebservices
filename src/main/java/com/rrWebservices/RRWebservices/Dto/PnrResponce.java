package com.rrWebservices.RRWebservices.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class PnrResponce {
	private int id;
 private String quotacode;
 private String psgnname;
 private String tktType;
 private String tktlost_flag;
 private String totalFare;
public String getQuotacode() {
	return quotacode;
}
public void setQuotacode(String quotacode) {
	this.quotacode = quotacode;
}
public String getPsgnname() {
	return psgnname;
}
public void setPsgnname(String psgnname) {
	this.psgnname = psgnname;
}
public String getTktType() {
	return tktType;
}
public void setTktType(String tktType) {
	this.tktType = tktType;
}
public String getTktlost_flag() {
	return tktlost_flag;
}
public void setTktlost_flag(String tktlost_flag) {
	this.tktlost_flag = tktlost_flag;
}
public String getTotalFare() {
	return totalFare;
}
public void setTotalFare(String totalFare) {
	this.totalFare = totalFare;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

 
}
