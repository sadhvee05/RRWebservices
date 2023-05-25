package com.rrWebservices.RRWebservices.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Entity.RetiringroomMaintenanceInfo;
import com.rrWebservices.RRWebservices.Entity.RetiringroomRoommaster;
import com.rrWebservices.RRWebservices.Repository.RetiringroomMaintenanceInfoRepo;
import com.rrWebservices.RRWebservices.Repository.RetiringroomRoommasterRepo;
import com.rrWebservices.RRWebservices.Services.RommMasterServices;

@Service
public class RoommasterServicesImpl  implements RommMasterServices{

	@Autowired 
	private RetiringroomRoommasterRepo roommasterRepo;
	@Autowired 
	private RetiringroomMaintenanceInfoRepo roomMaintenanceInfoRepo;
	
	@Override 
	 public List<RetiringroomRoommaster> getRoomId(int locationId)
	 {
		List< RetiringroomRoommaster> list =roommasterRepo.findByLocationid(locationId);
		System.out.println("room size in RetiringroomRoommaster :: "+list.size());
		return list;
	}
	@Override 
	public List<RetiringroomMaintenanceInfo> getRoommMaintenanceInfo(int roomId){
		List<RetiringroomMaintenanceInfo> roomMaintenaccelist=roomMaintenanceInfoRepo.findByroomid(roomId);
		System.out.println("room size in RetiringroomMaintenanceInfo :: "+roomMaintenaccelist.size());
		return roomMaintenaccelist;
	}


	
	
	
	
}
