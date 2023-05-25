package com.rrWebservices.RRWebservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rrWebservices.RRWebservices.Entity.RetiringroomRoommaster;

@Repository 
public interface RetiringroomRoommasterRepo extends JpaRepository<RetiringroomRoommaster,Integer>{
	public List< RetiringroomRoommaster> findByLocationid(int locationId) ;
}
