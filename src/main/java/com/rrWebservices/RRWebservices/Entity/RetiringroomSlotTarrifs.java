package com.rrWebservices.RRWebservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "retiringroom_slot_tarrifs")
public class RetiringroomSlotTarrifs {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private int id;
	  @Column(name = "tarrif_id")
	  private String  tarrifid;
	  
	  @Column(name = "location_id")
	  private String  location_id;
	  
	  @Column(name = "slot_id")
	  private String  slot_id;
	  @Column(name = "effective_until")
	  private String  effective_until;
	  @Column(name = "no_of_rooms")
	  private String  no_of_rooms;
	  @Column(name = "effective_from")
	  private String  effective_from;
	  @Column(name = "room_id")
	  private String  room_id;
	  @Column(name = "extra_bed_charge")
	  private String  extra_bed_charge;
	  @Column(name = "future_effective_date")
	  private String  future_effective_date;
	  @Column(name = "future_effective_until")
	  private String  future_effective_until;
	  @Column(name = "future_tariff_rates")
	  private String  future_tariff_rates;
	  @Column(name = "future_extra_bed_charge")
	  private String  future_extra_bed_charge;
	  @Column(name = "created_by")
	  private String  created_by;
	  @Column(name = "created_ts")
	  private String  created_ts;
	  @Column(name = "last_modified_by")
	  private String  last_modified_by;
	  @Column(name = "last_modified_ts")
	  private String  last_modified_ts;
	  @Column(name = "version")
	  private String  version;
	  @Column(name = "available")
	  private String  available;
	  @Column(name = "location_slot_id")
	  private String  location_slot_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarrifid() {
		return tarrifid;
	}
	public void setTarrifid(String tarrifid) {
		this.tarrifid = tarrifid;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(String slot_id) {
		this.slot_id = slot_id;
	}
	public String getEffective_until() {
		return effective_until;
	}
	public void setEffective_until(String effective_until) {
		this.effective_until = effective_until;
	}
	public String getNo_of_rooms() {
		return no_of_rooms;
	}
	public void setNo_of_rooms(String no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}
	public String getEffective_from() {
		return effective_from;
	}
	public void setEffective_from(String effective_from) {
		this.effective_from = effective_from;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getExtra_bed_charge() {
		return extra_bed_charge;
	}
	public void setExtra_bed_charge(String extra_bed_charge) {
		this.extra_bed_charge = extra_bed_charge;
	}
	public String getFuture_effective_date() {
		return future_effective_date;
	}
	public void setFuture_effective_date(String future_effective_date) {
		this.future_effective_date = future_effective_date;
	}
	public String getFuture_effective_until() {
		return future_effective_until;
	}
	public void setFuture_effective_until(String future_effective_until) {
		this.future_effective_until = future_effective_until;
	}
	public String getFuture_tariff_rates() {
		return future_tariff_rates;
	}
	public void setFuture_tariff_rates(String future_tariff_rates) {
		this.future_tariff_rates = future_tariff_rates;
	}
	public String getFuture_extra_bed_charge() {
		return future_extra_bed_charge;
	}
	public void setFuture_extra_bed_charge(String future_extra_bed_charge) {
		this.future_extra_bed_charge = future_extra_bed_charge;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_ts() {
		return created_ts;
	}
	public void setCreated_ts(String created_ts) {
		this.created_ts = created_ts;
	}
	public String getLast_modified_by() {
		return last_modified_by;
	}
	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	public String getLast_modified_ts() {
		return last_modified_ts;
	}
	public void setLast_modified_ts(String last_modified_ts) {
		this.last_modified_ts = last_modified_ts;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getLocation_slot_id() {
		return location_slot_id;
	}
	public void setLocation_slot_id(String location_slot_id) {
		this.location_slot_id = location_slot_id;
	} 
		
}
