package com.rrWebservices.RRWebservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rrWebservices.RRWebservices.Entity.RetiringroomMaintenanceInfo;

@Repository 
public interface RetiringroomMaintenanceInfoRepo extends JpaRepository<RetiringroomMaintenanceInfo,Integer> {

	public List<RetiringroomMaintenanceInfo> findByroomid(int roomId);
}
