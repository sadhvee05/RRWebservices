package com.rrWebservices.RRWebservices.Repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import
  org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;

@Repository 
  public interface RetiringroomBookingReservationRepo extends JpaRepository<RetiringroomBookingReservationEntity,Integer>{
	public List<RetiringroomBookingReservationEntity> findByPnr(String pnr);
	   
	@Query(value = "SELECT mst_prncpl_stns.*, mst_stns.STN_CD, retiringroom_location_master.location_code, retiringroom_location_master.id AS location_id\r\n"
			+ "FROM mst_prncpl_stns\r\n"
			+ "JOIN mst_stns ON mst_prncpl_stns.STN_ID = mst_stns.STN_ID\r\n"
			+ "JOIN retiringroom_location_master ON mst_stns.STN_CD = retiringroom_location_master.location_code\r\n"
			+ "WHERE mst_prncpl_stns.AREA_ID = (SELECT AREA_ID FROM mst_prncpl_stns JOIN mst_stns ON mst_prncpl_stns.STN_ID = mst_stns.STN_ID WHERE mst_stns.STN_CD = ? )\r\n"
			+ "ORDER BY mst_prncpl_stns.STN_ID;", nativeQuery = true)
	   public List<Object> principalStation(String stationCd);
	   
	  @Query(value = "SELECT `checkin_time`,`checkout_time` FROM `retiringroom_location_slots` WHERE `location_id`= ? ", nativeQuery = true)
	   public List<Object> getCheckInCheckOut(int locationId);
	
	
	@Query(value = "SELECT \r\n"
			+ "    rbr.id, \r\n"
			+ "    rbr.guest_id, \r\n"
			+ "    rbr.total_amount, \r\n"
			+ "    rbr.booking_ref_nbr, \r\n"
			+ "    rbr.transaction_id, \r\n"
			+ "    rbr.pnr_nbr, \r\n"
			+ "    rbr.travel_authority, \r\n"
			+ "    rbr.created_ts,\r\n"
			+ "    rbr.terminal_location, \r\n"
			+ "    rbr.reservation_station, \r\n"
			+ "    rbr.mode_of_booking, \r\n"
			+ "    rbr.booking_status,\r\n"
			+ "    rbt.room_booking_id, \r\n"
			+ "    rbt.room_id, \r\n"
			+ "    rbt.date_time_reserve_from, \r\n"
			+ "    rbt.date_time_reserve_to, \r\n"
			+ "    rbt.checkin_date_time,\r\n"
			+ "    rbt.txn_type, \r\n"
			+ "    rbt.transaction_date, \r\n"
			+ "    rbt.tarriff_charge, \r\n"
			+ "    rbt.refund_amount, \r\n"
			+ "    rbt.total_gst_amnt,\r\n"
			+ "    rbt.total_refund_gst_amnt,\r\n"
			+ "    rrm.id AS room_id,\r\n"
			+ "    rrm.room_number AS room_number,\r\n"
			+ "    rrm.room_type AS room_type,\r\n"
			+ "    rrm.bed_type AS bed_type,\r\n"
			+ "    gm.name AS NAME,\r\n"
			+ "    gm.age AS age,\r\n"
			+ "    gm.sex AS sex,\r\n"
			+ "    gm.room_number AS room_number,\r\n"
			+ "    gm.guestinfo_id AS guestinfo_id,\r\n"
			+ "    rgi.mobile_numebr AS mobile_numeber,\r\n"
			+ "    rgi.identity_proof AS identity_proof,\r\n"
			+ "    rgi.number AS identiproof_NUMBER\r\n"
			+ "FROM retiringroom_booking_reservation AS rbr\r\n"
			+ "JOIN retiringroom_booking_txn AS rbt ON (rbr.id = rbt.room_booking_id)\r\n"
			+ "JOIN retiringroom_roommaster AS rrm ON (rbt.room_id = rrm.id)\r\n"
			+ "JOIN guestinfo_map AS gm ON (gm.booking_reservation_id = rbr.id)\r\n"
			+ "JOIN retiringroom_guestinfo AS rgi ON (gm.guestinfo_id =rgi.id)\r\n"
			+ "WHERE (rbr.booking_ref_nbr = ? AND ? REGEXP '[a-zA-Z]') OR (rbr.transaction_id = ? AND NOT ? REGEXP '[a-zA-Z]') ", nativeQuery = true)
	   public List<Object> getBookingSearch(String bookingId1,String bookingId2,String bookingId3,String bookingId4);


	  @Query(value = "SELECT COUNT(*) FROM   `retiringroom_location_master` WHERE id= ? ", nativeQuery = true)
	  public int checkLocationId(int locationId);
	  @Query(value = "SELECT r.id\r\n"
	  		+ "FROM mst_stns m\r\n"
	  		+ "JOIN retiringroom_location_master r\r\n"
	  		+ "ON m.STN_CD = r.location_code\r\n"
	  		+ "WHERE m.STN_ID = ? ", nativeQuery = true)
	   public List<Object> checkStationId(int stationId);
	  
	  
	  
	
	 @Query(value = "SELECT\r\n"
	 		+ "    CASE\r\n"
	 		+ "        WHEN EXISTS (\r\n"
	 		+ "            SELECT *\r\n"
	 		+ "            FROM retiringroom_location_master\r\n"
	 		+ "            WHERE retiringroom_location_master.id = ?\r\n"
	 		+ "            AND ? < effective_date\r\n"
	 		+ "            AND ? > termination_date\r\n"
	 		+ "        )\r\n"
	 		+ "        THEN 'Location Terminated'\r\n"
	 		+ "        WHEN EXISTS (\r\n"
	 		+ "            SELECT *\r\n"
	 		+ "            FROM retiring_location_maintenance_info\r\n"
	 		+ "            WHERE location_available = 0\r\n"
	 		+ "            AND location_id = ?\r\n"
	 		+ "            AND planned_start_date <= ?\r\n"
	 		+ "            AND planned_finish_date >= ?\r\n"
	 		+ "        )\r\n"
	 		+ "        THEN 'Location Under Maintenance'\r\n"
	 		+ "        ELSE 'Available'\r\n"
	 		+ "    END AS LocationStatus", nativeQuery = true)
	   public String checkloctionMaintenanceStatus(int locationId,Date CheckInDate ,Date CheckOutDate,int locationId2, Date CheckOutDate1,Date CheckInDate1);
	// SELECT COUNT(location_id) FROM`retiring_location_maintenance_info` WHERE  location_id=1186 AND `planned_start_date` = "2018-01-23 00:00:00" AND `planned_finish_date` = "2018-01-24 00:00:00"
	 @Query(value = "SELECT * FROM   `retiringroom_location_master` WHERE id= ? ", nativeQuery = true)
	  public int getLocation(int locationid);
	 
	   
  }
 