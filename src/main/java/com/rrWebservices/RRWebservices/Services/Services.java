package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;
import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;


public interface Services {
	List<RetiringroomBookingReservationEntity> getPnrenquery(String pnr);
	List<RetiringroomLocationMaster> getRoomType(int id);

}
