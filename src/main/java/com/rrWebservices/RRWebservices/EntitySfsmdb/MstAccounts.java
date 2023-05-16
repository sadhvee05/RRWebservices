package com.rrWebservices.RRWebservices.EntitySfsmdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_accnts", schema = "sfsmdb")
public class MstAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCNT_ID")
    private Long accntId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "USR_ID")
    private String username;
    
    @Column(name = "USR_PSSWD")
    private String password;

	@Column(name = "ACCNT_FRST_NM")
    private String accntFrstNm;
	
	@Column(name = "ACCNT_MDL_NM")
    private String accntMdlNm;
	
	@Column(name = "ACCNT_LST_NM")
    private String accntLstNm;
	
	@Column(name = "GNDR_CD")
    private String gndrCd;
	
	@Column(name = "accnt_email_id")
    private String email;
	
	@Column(name = "CREATED_BY")
    private Long createdBy;
	
	@Column(name = "CREATED_ON")
    private String createdOn;

	public Long getAccntId() {
		return accntId;
	}

	public void setAccntId(Long accntId) {
		this.accntId = accntId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccntFrstNm() {
		return accntFrstNm;
	}

	public void setAccntFrstNm(String accntFrstNm) {
		this.accntFrstNm = accntFrstNm;
	}

	public String getAccntMdlNm() {
		return accntMdlNm;
	}

	public void setAccntMdlNm(String accntMdlNm) {
		this.accntMdlNm = accntMdlNm;
	}

	public String getAccntLstNm() {
		return accntLstNm;
	}

	public void setAccntLstNm(String accntLstNm) {
		this.accntLstNm = accntLstNm;
	}

	public String getGndrCd() {
		return gndrCd;
	}

	public void setGndrCd(String gndrCd) {
		this.gndrCd = gndrCd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "User [accntId=" + accntId + ", roleId=" + roleId + ", username=" + username + ", password=" + password
				+ ", accntFrstNm=" + accntFrstNm + ", accntMdlNm=" + accntMdlNm + ", accntLstNm=" + accntLstNm
				+ ", gndrCd=" + gndrCd + ", email=" + email + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ "]";
	}
	
	



    // Getters and setters
	
	

}
