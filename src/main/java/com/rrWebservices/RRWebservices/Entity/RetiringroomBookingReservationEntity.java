package com.rrWebservices.RRWebservices.Entity;




import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "retiringroom_booking_reservation", schema = "cris")


public class RetiringroomBookingReservationEntity {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private int id;
	  @Column(name = "pnr_nbr")
	  private String  pnr;
	  @Column(name = "guest_id")
	  private int  guestid;
	  @Column(name = "booking_ref_nbr")
	  private String  bookingrefnbr;
	  @Column(name = "booking_status")
	  private String  bookingstatus;
	  @Column(name = "total_amount")
	  private long totalamount;
	  @Column(name = "created_ts")
	  private Date  createdts;
	 
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuestid() {
		return guestid;
	}
	public void setGuestid(int guestid) {
		this.guestid = guestid;
	}
	public String getBookingrefnbr() {
		return bookingrefnbr;
	}
	public void setBookingrefnbr(String bookingrefnbr) {
		this.bookingrefnbr = bookingrefnbr;
	}
	public String getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	public long getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(long totalamount) {
		this.totalamount = totalamount;
	}
	public Date getCreatedts() {
		return createdts;
	}
	public void setCreatedts(Date createdts) {
		this.createdts = createdts;
	}
	
	
	public RetiringroomBookingReservationEntity(int id, String pnr, int guestid, String bookingrefnbr,
			String bookingstatus, long totalamount, Date createdts) {
		super();
		this.id = id;
		this.pnr = pnr;
		this.guestid = guestid;
		this.bookingrefnbr = bookingrefnbr;
		this.bookingstatus = bookingstatus;
		this.totalamount = totalamount;
		this.createdts = createdts;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public RetiringroomBookingReservationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  

}
