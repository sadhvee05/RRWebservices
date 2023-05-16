package com.rrWebservices.RRWebservices.EntitySldb;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "tb_terminal_display_master", schema = "sldb")
	public class TbTerminalDisplayMaster {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "terminal_line_id")
	    private String terminalLineId;
	    
	    @Column(name = "booking_location_id")
	    private String bookLocationId;
	    
	    @Column(name = "division_cd")
	    private String divCd;
	    
	    @Column(name = "zone_cd")
	    private String zoneCd;
	    
	    @Column(name = "terminal_ip")
	    private String terminalIp;
	    
	    @ManyToOne @JoinColumn(name= "application_id")
	    private TbPrivilegeMaster tbPrivilegeMaster;
	    
	    @Column(name = "status")
	    private String status;
	    
	    @Column(name = "created_by")
	    private Long createdBy;
	    
	    @Column(name = "created_ts")
	    private String createdTs;
	    
	    @Column(name = "last_modified_by")
	    private Long lastModifiedBy;
	    
	    @Column(name = "last_modified_ts")
	    private String lastModifiedTs;
	    
	    @Column(name = "version")
	    private Long version;
	    
	    @Column(name = "old_booking_location_id")
	    private String oldBookLocationId;
	    
	    @Column(name = "room_id")
	    private Long roomId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTerminalLineId() {
			return terminalLineId;
		}

		public void setTerminalLineId(String terminalLineId) {
			this.terminalLineId = terminalLineId;
		}

		public String getBookLocationId() {
			return bookLocationId;
		}

		public void setBookLocationId(String bookLocationId) {
			this.bookLocationId = bookLocationId;
		}

		public String getDivCd() {
			return divCd;
		}

		public void setDivCd(String divCd) {
			this.divCd = divCd;
		}

		public String getZoneCd() {
			return zoneCd;
		}

		public void setZoneCd(String zoneCd) {
			this.zoneCd = zoneCd;
		}

		public String getTerminalIp() {
			return terminalIp;
		}

		public void setTerminalIp(String terminalIp) {
			this.terminalIp = terminalIp;
		}

		public TbPrivilegeMaster getTbPrivilegeMaster() {
			return tbPrivilegeMaster;
		}

		public void setTbPrivilegeMaster(TbPrivilegeMaster tbPrivilegeMaster) {
			this.tbPrivilegeMaster = tbPrivilegeMaster;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(Long createdBy) {
			this.createdBy = createdBy;
		}

		public String getCreatedTs() {
			return createdTs;
		}

		public void setCreatedTs(String createdTs) {
			this.createdTs = createdTs;
		}

		public Long getLastModifiedBy() {
			return lastModifiedBy;
		}

		public void setLastModifiedBy(Long lastModifiedBy) {
			this.lastModifiedBy = lastModifiedBy;
		}

		public String getLastModifiedTs() {
			return lastModifiedTs;
		}

		public void setLastModifiedTs(String lastModifiedTs) {
			this.lastModifiedTs = lastModifiedTs;
		}

		public Long getVersion() {
			return version;
		}

		public void setVersion(Long version) {
			this.version = version;
		}

		public String getOldBookLocationId() {
			return oldBookLocationId;
		}

		public void setOldBookLocationId(String oldBookLocationId) {
			this.oldBookLocationId = oldBookLocationId;
		}

		public Long getRoomId() {
			return roomId;
		}

		public void setRoomId(Long roomId) {
			this.roomId = roomId;
		}

		@Override
		public String toString() {
			return "TbTerminalDisplayMaster [id=" + id + ", terminalLineId=" + terminalLineId + ", bookLocationId="
					+ bookLocationId + ", divCd=" + divCd + ", zoneCd=" + zoneCd + ", terminalIp=" + terminalIp
					+ ", tbPrivilegeMaster=" + tbPrivilegeMaster + ", status=" + status + ", createdBy=" + createdBy
					+ ", createdTs=" + createdTs + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedTs="
					+ lastModifiedTs + ", version=" + version + ", oldBookLocationId=" + oldBookLocationId + ", roomId="
					+ roomId + "]";
		}
	    
	    
}
	

