package com.rrWebservices.RRWebservices.Request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rrWebservices.RRWebservices.Constant.RrConstEnum;



public class AvailabilityRequest {
	Long bedTypeId;
	Long locationId;
	Long quotaId;
	Long acStatusId;
	@JsonFormat(pattern=RrConstEnum.DATE_FORMATTER)
	LocalDate fromDate;
	@JsonFormat(pattern=RrConstEnum.DATE_FORMATTER)
	LocalDate toDate;
	
	public Long getBedTypeId() {
		return bedTypeId;
	}
	public void setBedTypeId(Long bedTypeId) {
		this.bedTypeId = bedTypeId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public Long getQuotaId() {
		return quotaId;
	}
	public void setQuotaId(Long quotaId) {
		this.quotaId = quotaId;
	}
	public Long getAcStatusId() {
		return acStatusId;
	}
	public void setAcStatusId(Long acStatusId) {
		this.acStatusId = acStatusId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acStatusId == null) ? 0 : acStatusId.hashCode());
		result = prime * result + ((bedTypeId == null) ? 0 : bedTypeId.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((quotaId == null) ? 0 : quotaId.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailabilityRequest other = (AvailabilityRequest) obj;
		if (acStatusId == null) {
			if (other.acStatusId != null)
				return false;
		} else if (!acStatusId.equals(other.acStatusId))
			return false;
		if (bedTypeId == null) {
			if (other.bedTypeId != null)
				return false;
		} else if (!bedTypeId.equals(other.bedTypeId))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (quotaId == null) {
			if (other.quotaId != null)
				return false;
		} else if (!quotaId.equals(other.quotaId))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AvailabilityRequest [bedTypeId=" + bedTypeId + ", locationId=" + locationId + ", quotaId=" + quotaId
				+ ", acStatusId=" + acStatusId + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	public AvailabilityRequest(Long bedTypeId, Long locationId, Long quotaId, Long acStatusId, LocalDate fromDate,
			LocalDate toDate) {
		super();
		this.bedTypeId = bedTypeId;
		this.locationId = locationId;
		this.quotaId = quotaId;
		this.acStatusId = acStatusId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public AvailabilityRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
