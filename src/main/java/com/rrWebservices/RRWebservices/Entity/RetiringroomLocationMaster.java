package com.rrWebservices.RRWebservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
@Entity
@Table(name = "retiringroom_location_master")
public class RetiringroomLocationMaster {
	
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private int id;
	  @Column(name = "hourly_booking_yn")
	  private String  bookingType;
}
