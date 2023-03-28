package com.rrWebservices.RRWebservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;
@Repository 
public interface RetiringroomLocationMasterRepo extends JpaRepository<RetiringroomLocationMaster,Integer>{
	public List<RetiringroomLocationMaster> findById(int id);

}

