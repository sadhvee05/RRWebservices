package com.rrWebservices.RRWebservices.EntitySldb;

import java.util.Date;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "tb_privilege_master", schema = "sldb")
public class TbPrivilegeMaster {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_code")
    private String classCode;
    
    @Column(name = "class_name")
    private String className;
    
    @Column(name = "created_by")
    private Long createdBy;
    
    @Column(name = "created_ts")
    private Date createdTs;
    
    @Column(name = "last_modified_by")
    private Long lastModBy;
    
    @Column(name = "last_modified_ts")
    private Date lastModTs;
    
    @Column(name = "version")
    private Long version;
    
    @OneToMany(mappedBy = "tbPrivilegeMaster", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<TbTerminalDisplayMaster> tbTerminalDisplayMaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public Long getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(Long lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Date getLastModTs() {
		return lastModTs;
	}

	public void setLastModTs(Date lastModTs) {
		this.lastModTs = lastModTs;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "TbPrivilegeMaster [id=" + id + ", classCode=" + classCode + ", className=" + className + ", createdBy="
				+ createdBy + ", createdTs=" + createdTs + ", lastModBy=" + lastModBy + ", lastModTs=" + lastModTs
				+ ", version=" + version + "]";
	}
    
    
}
