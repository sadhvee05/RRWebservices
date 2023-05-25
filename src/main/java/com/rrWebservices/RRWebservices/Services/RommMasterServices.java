package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Entity.RetiringroomMaintenanceInfo;
import com.rrWebservices.RRWebservices.Entity.RetiringroomRoommaster;

public interface RommMasterServices {

	List<RetiringroomRoommaster> getRoomId(int locationId);
	 List<RetiringroomMaintenanceInfo> getRoommMaintenanceInfo(int roomId);
}
