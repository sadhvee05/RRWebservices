package com.rrWebservices.RRWebservices.servicesImpl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.StationNameResponse;
import com.rrWebservices.RRWebservices.Repository.RetiringroomLocationMasterRepo;
import com.rrWebservices.RRWebservices.Services.LocationServices;
@Service


public class LocationServicesImpl  implements LocationServices{
	@Autowired 
	 private RetiringroomLocationMasterRepo rrLocationMasterRepo;
	 public List<StationNameResponse> getStationName()
	{
		
		List<StationNameResponse> list= new ArrayList<StationNameResponse>();
		List<Object> objetList=   rrLocationMasterRepo.getStationName();
		if (!objetList.isEmpty() && objetList.size() > 0)
		{
			for (Object itr : objetList) {
				Object[] obj = (Object[]) itr;
				StationNameResponse dto = new StationNameResponse();
				dto.setId(Integer.valueOf(String.valueOf(obj[0])));
				dto.setLocationCode(String.valueOf(obj[1]));
				dto.setDescription(String.valueOf(obj[2]));
				dto.setStationname(String.valueOf(obj[3]));
				list.add(dto);
	         }
		}
		return list;
    }
	 
	
	 
	 
}
