package com.rrWebservices.RRWebservices.Validation;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.RoomAVList;
import com.rrWebservices.RRWebservices.Entity.RetiringroomRoommaster;
import com.rrWebservices.RRWebservices.Repository.RetiringroomRoommasterRepo;
import com.rrWebservices.RRWebservices.Response.BedCheckingValidationResponse;
import com.rrWebservices.RRWebservices.Services.TestServices;
import com.rrWebservices.RRWebservices.servicesImpl.ServicesImpl;

@Service
public class BedCheckingValidation implements TestServices {
	DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	@Autowired
	ServicesImpl servicesImpl;
	@Autowired
	RetiringroomRoommasterRepo roomRoommasterRepo;
	// @Autowired
	// private RetiringroomBookingReservationRepo rbrRepo;
	SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<BedCheckingValidationResponse> bedroomAvailability(int noOfGuests, int roomId[]) {
		String bedType = null;
		// int noOfGuests = 1;
		// int roomId = 1273;
		// int roomId[]={1273,1275,1276,1278};
		int singleBed = 0, doubleBed = 0, dormitory = 0, familyBed = 0;
		int countselection = roomId.length;
		System.out.println(countselection + " countselection");
		String msg = "";
		List<BedCheckingValidationResponse> listroom = new ArrayList<BedCheckingValidationResponse>();

		if (countselection > 0) {
			BedCheckingValidationResponse dto = new BedCheckingValidationResponse();
			if (noOfGuests == 1) {
				if (noOfGuests == countselection) {
					for (int roomid : roomId) {
						Optional<RetiringroomRoommaster> roomlist = roomRoommasterRepo.findById(roomid);
						bedType = roomlist.get().getBedType();
						System.out.println(bedType + " ---------------------------------------BeyType");
						if (bedType.equals("Single")) {
							singleBed = singleBed + 1;
							dto.setRoomId(roomId);
							dto.setSelectioncount(singleBed);
							
						} else if (bedType.equals("Double")) {
							doubleBed = doubleBed + 1;
							dto.setRoomId(roomId);
							dto.setSelectioncount(doubleBed);
							
						} else if (bedType.equals("Dormitory")) {
							dormitory = dormitory + 1;
							dto.setRoomId(roomId);
							dto.setSelectioncount(dormitory);
							
						} else {
							msg = "Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
							dto.setMsg(msg);
							
						}
						listroom.add(dto);
					}
				} else {
					msg = "Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
					System.out.println(msg);
					dto.setMsg(msg + "  countselection" + countselection);
					listroom.add(dto);
				}
				
				System.out.println("bed count:::  1-- " + "singleBed: " + singleBed + "doubleBed: " + doubleBed
						+ "Dormitory: " + dormitory);

			} else if (noOfGuests == 2) {
				if (noOfGuests == countselection || countselection == 1) {
					for (int roomid : roomId) {
						Optional<RetiringroomRoommaster> roomlist = roomRoommasterRepo.findById(roomid);
						bedType = roomlist.get().getBedType();
						
					if (bedType.equals("Double"))
					{
						doubleBed = doubleBed + 1;
						dto.setRoomId(roomId);
						dto.setSelectioncount(doubleBed);
						
					}
					else if (bedType.equals("Dormitory"))
					{
						dormitory = dormitory + 2;
						dto.setRoomId(roomId);
						dto.setSelectioncount(dormitory);
					
					}
					else
					{
						msg = "Can be allotted one DB Room or 2 bed in dormitory";
						dto.setMsg(msg);
						
					}
					listroom.add(dto);
					}
					} 
				   else {
					msg = "Can be allotted one DB Room or 2 bed in dormitory";
					dto.setMsg(msg);
					listroom.add(dto);
				}
				System.out.println("bed count:::  2-- " + "singleBed: " + singleBed + "doubleBed: " + doubleBed
						+ "Dormitory: " + dormitory);

			} else if (noOfGuests == 3) {
				if (noOfGuests == countselection || countselection > 1) {
					for (int roomid : roomId) {
						
						Optional<RetiringroomRoommaster> roomlist = roomRoommasterRepo.findById(roomid);
						bedType = roomlist.get().getBedType();
						System.out.println(bedType + "  "+roomlist.get().getId()+" ------------BedType");
						
					if (bedType.equals("Single") || bedType.equals("Double")) {
						singleBed = singleBed + 1;
						doubleBed = doubleBed + 1;
						int totalbed=singleBed+doubleBed;
						dto.setRoomId(roomId);
						dto.setSelectioncount(totalbed);
						
					} else if (bedType.equals("Family"))
					{
						familyBed = familyBed + 1;
						dto.setRoomId(roomId);
						dto.setSelectioncount(familyBed);
					
					}
					else if (bedType.equals("Dormitory"))
					{
						dormitory = dormitory + 1;
						dto.setRoomId(roomId);
						dto.setSelectioncount(dormitory);
						
					}
					else
					{
						msg = "Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
						dto.setMsg(msg);
						
					}
					
				}
					listroom.add(dto);
				}
				else {
					msg = "Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
					dto.setMsg(msg);
					listroom.add(dto);
					
				}
				System.out.println("bed count::: 3-- " + "singleBed: " + singleBed + "doubleBed: " + doubleBed
						+ "Dormitory: " + dormitory + "Family: " + familyBed);

			} else if (noOfGuests == 4) {
				if (noOfGuests == countselection || countselection > 1) {
					if (bedType.equals("Double"))
						doubleBed = doubleBed + 2;
					else if (bedType.equals("Family"))
						familyBed = familyBed + 1;
					else if (bedType.equals("Dormitory"))
						dormitory = dormitory + noOfGuests;
					else
						msg = "Two DB Rooms or up to " + noOfGuests
								+ " beds in dormitory or 1 Family room subject to availability";
				} else {
					msg = "Two DB Rooms or up to " + noOfGuests
							+ " beds in dormitory or 1 Family room subject to availability";
				}
				System.out.println("bed count::: 4-- " + singleBed + "singleBed: " + "doubleBed: " + doubleBed
						+ "Dormitory: " + dormitory + "Family: " + familyBed);

			} else if (noOfGuests == 5 || noOfGuests == 6) {
				if (noOfGuests == countselection || countselection > 2) {
					if (bedType.equals("Double")) {
						doubleBed = doubleBed + 2;
						doubleBed = doubleBed + 3;
					} else if (bedType.equals("Dormitory"))
						dormitory = dormitory + noOfGuests;
					else
						msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
				} else {
					msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
				}
				System.out.println("bed count::: " + noOfGuests + "--  " + singleBed + "singleBed: " + "doubleBed: "
						+ doubleBed + "Dormitory: " + dormitory + "Family: " + familyBed);

			}

		} else {
			msg = "Please select the room!....";
		}
		return listroom;
	}
}
