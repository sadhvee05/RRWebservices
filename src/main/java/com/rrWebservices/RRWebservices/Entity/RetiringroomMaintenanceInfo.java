package com.rrWebservices.RRWebservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "retiringroom_maintenance_info", schema = "cris")
public class RetiringroomMaintenanceInfo {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private int id;
	  @Column(name = "room_id")
	  private int roomid;
	  @Column(name = "planned_start_date")
	  private String  plannedstartdate;
	  @Column(name = "planned_finish_date")
	  private String  plannedfinishdate;
	  @Column(name = "created_date")
	  private String  createddate;
	  @Column(name = "nature_of_job")
	  private String  natureofjob;
	  @Column(name = "created_by")
	  private String  createdby;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getPlannedstartdate() {
		return plannedstartdate;
	}
	public void setPlannedstartdate(String plannedstartdate) {
		this.plannedstartdate = plannedstartdate;
	}
	public String getPlannedfinishdate() {
		return plannedfinishdate;
	}
	public void setPlannedfinishdate(String plannedfinishdate) {
		this.plannedfinishdate = plannedfinishdate;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getNatureofjob() {
		return natureofjob;
	}
	public void setNatureofjob(String natureofjob) {
		this.natureofjob = natureofjob;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	

}
