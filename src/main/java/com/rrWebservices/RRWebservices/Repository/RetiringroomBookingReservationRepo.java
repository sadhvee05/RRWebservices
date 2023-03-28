package com.rrWebservices.RRWebservices.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import
  org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;

@Repository 
  public interface RetiringroomBookingReservationRepo extends JpaRepository<RetiringroomBookingReservationEntity,Integer>{
	 //@Query(value = "select id, pnr_nbr, guest_id, booking_ref_nbr, booking_status, total_amount, created_ts FROM retiringroom_booking_reservation WHERE pnr_nbr = ? ", nativeQuery = true)
	   public List<RetiringroomBookingReservationEntity> findByPnr(String pnr);
  }
 