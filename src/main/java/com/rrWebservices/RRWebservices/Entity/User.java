package com.rrWebservices.RRWebservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_accnts" , schema = "cris")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCNT_ID")
    private Long id;

    @Column(name = "USR_ID")
    private String username;

    @Column(name = "USR_PSSWD")
    private String password;
    
    @Column(name = "ROLE_ID")
    private String roleId;

	@Column(name = "CREATED_ON")
    private String createdOn;
	
	 @Column(name = "ACCNT_FRST_NM")
	    private String accfirstname;
	    
	    @Column(name = "ACCNT_MDL_NM")
	    private String accmdlname;

		@Column(name = "ACCNT_LST_NM")
	    private String acclastname;
	    
		@Column(name = "GNDR_CD")
	    private String gender;
	    
	    @Column(name = "accnt_email_id")
	    private String emailid;

		@Column(name = "CREATED_BY")
	    private String createdby;
    
    public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAccfirstname() {
		return accfirstname;
	}

	public void setAccfirstname(String accfirstname) {
		this.accfirstname = accfirstname;
	}

	public String getAccmdlname() {
		return accmdlname;
	}

	public void setAccmdlname(String accmdlname) {
		this.accmdlname = accmdlname;
	}

	public String getAcclastname() {
		return acclastname;
	}

	public void setAcclastname(String acclastname) {
		this.acclastname = acclastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", createdOn=" + createdOn + ", accfirstname=" + accfirstname + ", accmdlname=" + accmdlname
				+ ", acclastname=" + acclastname + ", gender=" + gender + ", emailid=" + emailid + ", createdby="
				+ createdby + "]";
	}


	
    // Getters and setters
	
	

}
