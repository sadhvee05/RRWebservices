package com.rrWebservices.RRWebservices.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.Dto.LocationSlotMStDTO;
import com.rrWebservices.RRWebservices.Entity.RetiringroomSlotTarrifs;

@Repository 
public interface RetiringroomSlotTarrifsRepo  extends JpaRepository<RetiringroomSlotTarrifs,Integer> {
//
	@Query(value = "SELECT * FROM `retiringroom_slot_master`", nativeQuery = true)
	   public List<Object> getAllSlot();
	
	@Query(value = "SELECT * FROM `retiringroom_roommaster` WHERE location_id =? ", nativeQuery = true)
	   public List<Object> getRoomList(int locationId);
	
	//SELECT * FROM `retiringroom_booking_txn` WHERE `date_time_reserve_from` = '2014-01-03 08:00:00' AND `date_time_reserve_to` = '2014-04-11 08:00:00'
 //;

	@Query(value = "SELECT rm.room_number,\r\n"
			+ "       rm.`id`,\r\n"
			+ "       rm.`floor_type`,\r\n"
			+ "       rm.`room_type`,\r\n"
			+ "       rm.`bed_type`,\r\n"
			+ "       rm.`tariff`,\r\n"
			+ "       rm.`ac_status`,\r\n"
			+ "       rm.quota,\r\n"
			+ "       CASE\r\n"
			+ "           WHEN rm.effective_from <= ? AND rm.teminated_on >= ? THEN 'A'\r\n"
			+ "           ELSE 'T'\r\n"
			+ "       END AS room_status\r\n"
			+ "FROM retiringroom_roommaster rm\r\n"
			+ "WHERE NOT EXISTS (\r\n"
			+ "    SELECT 1\r\n"
			+ "    FROM retiringroom_exists re\r\n"
			+ "    WHERE rm.room_number = re.room_number\r\n"
			+ "      AND rm.station_name = re.reservation_location\r\n"
			+ "      AND re.from_date <= ? \r\n"
			+ "      AND re.to_date >= ? \r\n"
			+ "      AND re.booking_status = 'NB'\r\n"
			+ ")\r\n"
			+ "  AND rm.location_id = ? \r\n"
			+ " ", nativeQuery = true)
	   public List<Object> getAvaRoomList(LocalDateTime effectivefrom,LocalDateTime teminnatedOn,LocalDateTime checkIndate,LocalDateTime CheckOutDate, int locationId);
	
	@Query(value = "SELECT * FROM retiringroom_slot_tarrifs WHERE location_id =? AND location_slot_id=1243 AND room_id= ? ", nativeQuery = true)
	   public List<Object> getAvaRoomListWithBaseTraiff(int locationId,int roomId);
	//SELECT * FROM retiringroom_slot_tarrifs WHERE slot_id=1021 AND location_id =1064 AND location_slot_id=1243 AND room_id=1234
	  @Query(value = "SELECT id,location_id,slot_id,checkin_time,checkout_time FROM retiringroom_location_slots WHERE location_id =? AND checkin_time=? AND checkout_time=? ", nativeQuery = true)
	   public List<Object> getloctionSlotId(int locationId,String checkIndate,String CheckOutDate);
	  
	  @Query(value = "SELECT rr.room_id, rrm.room_number, CONCAT(UPPER(rrm.floor_type), ' Floor ', ', ', GROUP_CONCAT(ram.description SEPARATOR ', ')) AS amenities\r\n"
	  		+ "FROM retiringroom_amenities rr\r\n"
	  		+ "JOIN retiringroom_roommaster rrm ON rr.room_id = rrm.id\r\n"
	  		+ "JOIN retiringroom_amenity_master ram ON ram.id = rr.amenity_id\r\n"
	  		+ "WHERE rrm.location_id =  ? \r\n"
	  		+ "GROUP BY rr.room_id;", nativeQuery = true)
	   public List<Object> getRoomAmenities(int locationId);
	  
	  @Query(value = "SELECT * FROM retiringroom_location_slots WHERE slot_id IN(1021) AND location_id = ? ", nativeQuery = true)
	   public List<Object> getslot12hr(int locationId);
	  
	  @Query(value = "SELECT * FROM retiringroom_location_slots WHERE slot_id IN(1021,1022) AND location_id = ? ", nativeQuery = true)
	   public List<Object> getslot12hrAnd24hr(int locationId);
	  
	  
	  
	  
}
