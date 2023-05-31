package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Dto.StationNameResponse;
import com.rrWebservices.RRWebservices.Response.LocationMasterResponse;

public interface LocationServices {
	public List<StationNameResponse> getStationName();
	 public List<LocationMasterResponse> getlocation();

}
