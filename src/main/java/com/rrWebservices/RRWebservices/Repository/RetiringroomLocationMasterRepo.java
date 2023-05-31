package com.rrWebservices.RRWebservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;
@Repository 
public interface RetiringroomLocationMasterRepo extends JpaRepository<RetiringroomLocationMaster,Integer>{
	public List<RetiringroomLocationMaster> findById(int id);
	
	@Query(value = "SELECT STN_ID FROM `mst_stns` WHERE STN_CD = ? ", nativeQuery = true)
	public int getStationId(String  stncode);
	
	@Query(value = "SELECT id,location_code,description, CONCAT(description,' (',location_code,')') AS 'stationname' FROM retiringroom_location_master ", nativeQuery = true)
	public List<Object> getStationName();

	
	@Query(value = "SELECT id,`location_code`,`effective_date`,`termination_date` FROM `retiringroom_location_master`", nativeQuery = true)
	public List<Object> getlocation();

}

