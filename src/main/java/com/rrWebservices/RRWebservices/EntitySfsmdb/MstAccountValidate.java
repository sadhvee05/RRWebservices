package com.rrWebservices.RRWebservices.EntitySfsmdb;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "mst_accnt_validate", schema = "sfsmdb")
public class MstAccountValidate {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ACCNT_ID")
	    private Long accntId;

	    @Column(name = "LOGIN_DT")
	    private Date loginDt;

	    @Column(name = "ACCNT_STATUS")
	    private String accntStatus;
	    
	    @Column(name = "CHN_STTS_DT")
	    private Date chnStatusDt;

		public Long getAccntId() {
			return accntId;
		}

		public void setAccntId(Long accntId) {
			this.accntId = accntId;
		}

		public Date getLoginDt() {
			return loginDt;
		}

		public void setLoginDt(Date loginDt) {
			this.loginDt = loginDt;
		}

		public String getAccntStatus() {
			return accntStatus;
		}

		public void setAccntStatus(String accntStatus) {
			this.accntStatus = accntStatus;
		}

		public Date getChnStatusDt() {
			return chnStatusDt;
		}

		public void setChnStatusDt(Date chnStatusDt) {
			this.chnStatusDt = chnStatusDt;
		}

		@Override
		public String toString() {
			return "MstAccountValidate [accntId=" + accntId + ", loginDt=" + loginDt + ", accntStatus=" + accntStatus
					+ ", chnStatusDt=" + chnStatusDt + "]";
		}
	    
}
