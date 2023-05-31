package com.rrWebservices.RRWebservices.Validation;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.PnrResponse;
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

	SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<BedCheckingValidationResponse> bedroomAvailability(int noOfGuests, int roomId[]) {
		String bedType = null;
		int singleBed = 0, doubleBed = 0, dormitory = 0, familyBed = 0;
		int roomSelectionid[] = new int[noOfGuests];
		int singlebedSelection[] = new int[2];
		int doubleBedSelection[] = new int[3];
		int dormitorySelection[] = new int[7];
		int familyBedSelection[] = new int[2];

		int countselection = roomId.length;
		System.out.println(countselection + " countselection");
		String msg = "";
		List<BedCheckingValidationResponse> listroom = new ArrayList<BedCheckingValidationResponse>();
		BedCheckingValidationResponse dto = new BedCheckingValidationResponse();
		if (countselection > 0) {
			int singalebedindex = 0;
			int doubleBedindex = 0;
			int dormitorybedindex = 0;
			int familyBedindex = 0;
			for (int roomid : roomId) {
				List<RetiringroomRoommaster> roomlist11 = roomRoommasterRepo.getRoom(roomid);
				bedType = roomlist11.get(0).getBedType();
				if (bedType.equals("Single")) {
					singalebedindex++;
					singleBed = singleBed + 1;
					singlebedSelection[singalebedindex] = roomid;
				} else if (bedType.equals("Double")) {
					doubleBedindex++;
					doubleBed = doubleBed + 1;
					doubleBedSelection[doubleBedindex] = roomid;
				} else if (bedType.equals("Dormitory")) {
					dormitorybedindex++;
					dormitory = dormitory + 1;
					dormitorySelection[dormitorybedindex] = roomid;
				} else if (bedType.equals("Family")) {
					familyBedindex++;
					familyBed = familyBed + 1;
					familyBedSelection[familyBedindex] = roomid;
				}

			}
			if (noOfGuests == 1) {
				if (noOfGuests == countselection) {
					if (singleBed == 1) {
						msg = "valid singleBed";
						dto.setRoomId(singlebedSelection);

					} else if (doubleBed == 1) {
						msg = "valid doubleBed ";
						dto.setRoomId(doubleBedSelection);
					} else if (dormitory == 1) {
						msg = "valid dormitory";
						dto.setRoomId(dormitorySelection);
					} else {
						msg = "..Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
					}
				} else {
					msg = "Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
				}
			} else if (noOfGuests == 2) {
				if (noOfGuests >= countselection && countselection > 1) {

					if (doubleBed == 1) {
						msg = "valid doubleBed";
						dto.setRoomId(doubleBedSelection);
					} else if (dormitory == 2) {
						msg = "valid dormitory";
						dto.setRoomId(dormitorySelection);
					} else {
						msg = "..Can be allotted one DB Room or 2 bed in dormitory";
					}
				} else {
					msg = "Can be allotted one DB Room or 2 bed in dormitory";
				}
			}

			else if (noOfGuests == 3) {
				if (countselection <= noOfGuests && countselection > 1) {

					if (doubleBed == 1 && singleBed == 1) {
						msg = "valid doubleBed + singleBed";
						roomSelectionid[0] = singlebedSelection[singalebedindex];
						roomSelectionid[1] = doubleBedSelection[doubleBedindex];
						dto.setRoomId(roomSelectionid);

					} else if (dormitory == 3) {
						msg = "valid dormitory";
						roomSelectionid[0] = dormitorySelection[dormitorybedindex];
						dto.setRoomId(dormitorySelection);
					} else if (familyBed == 1) {
						msg = "valid familyBed";
						roomSelectionid[0] = familyBedSelection[familyBedindex];
						dto.setRoomId(familyBedSelection);
					} else {
						msg = "..Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
					}
				} else {
					msg = "Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
				}
			} else if (noOfGuests == 4) {
				if (countselection <= noOfGuests && countselection > 1) {

					if (doubleBed == 2) {
						msg = "valid doubleBed";
						dto.setRoomId(doubleBedSelection);
					} else if (dormitory == noOfGuests) {
						msg = "valid dormitory";
						dto.setRoomId(dormitorySelection);
					} else if (familyBed == 1) {
						msg = "valid familyBed";
						dto.setRoomId(familyBedSelection);

					} else {
						msg = "...Two DB Rooms or up to " + noOfGuests
								+ " beds in dormitory or 1 Family room subject to availability";
					}
				} else {
					msg = "Two DB Rooms or up to " + noOfGuests
							+ " beds in dormitory or 1 Family room subject to availability";
				}
			}

			else if (noOfGuests == 5 || noOfGuests == 6) {
				if (noOfGuests >= countselection && countselection >= 2) {

					if (doubleBed == 2) {
						msg = "valid doubleBed";
						dto.setRoomId(doubleBedSelection);
					} else if (dormitory == noOfGuests) {
						msg = "valid dormitory";
						dto.setRoomId(dormitorySelection);
					}

					else {
						msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
					}
				} else {
					msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
				}
			}
			dto.setMsg(msg);
			dto.setSelectioncount(countselection);

		} else {
			msg = "Please select the room!....";
			dto.setMsg(msg);
		}
		listroom.add(dto);
		return listroom;
	}

	public List<BedCheckingValidationResponse> bedroomAvailabilityProposedInfuture(int noOfGuests, int roomId[]) {
		checkPassengerAge();
		 System.out.println("----------------------------------------------------------");
		String bedType = null;
		int singleBed = 0, doubleBed = 0, dormitory = 0, familyBed = 0;
		int roomSelectionid[] = new int[noOfGuests];
		int singlebedSelection[] = new int[2];
		int doubleBedSelection[] = new int[3];
		int dormitorySelection[] = new int[7];
		int familyBedSelection[] = new int[2];

		int countselection = roomId.length;
		System.out.println(countselection + " countselection");
		String msg = "";
		List<BedCheckingValidationResponse> listroom = new ArrayList<BedCheckingValidationResponse>();
		BedCheckingValidationResponse dto = new BedCheckingValidationResponse();
		try {
			if (countselection > 0) {
				int singalebedindex = 0;
				int doubleBedindex = 0;
				int dormitorybedindex = 0;
				int familyBedindex = 0;
				for (int roomid : roomId) {
					List<RetiringroomRoommaster> roomlist11 = roomRoommasterRepo.getRoom(roomid);
					bedType = roomlist11.get(0).getBedType();
					if (bedType.equals("Single")) {
						singalebedindex++;
						singleBed = singleBed + 1;
						singlebedSelection[singalebedindex] = roomid;
					} else if (bedType.equals("Double")) {
						doubleBedindex++;
						doubleBed = doubleBed + 1;
						doubleBedSelection[doubleBedindex] = roomid;
					} else if (bedType.equals("Dormitory")) {
						dormitorybedindex++;
						dormitory = dormitory + 1;
						dormitorySelection[dormitorybedindex] = roomid;
					} else if (bedType.equals("Family")) {
						familyBedindex++;
						familyBed = familyBed + 1;
						familyBedSelection[familyBedindex] = roomid;
					}

				}
				if (noOfGuests == 1) {
					if (noOfGuests == countselection) {
						if (dormitory == 1) // if(doubleBed==1)
						{
							msg = "valid dormitory";
							dto.setRoomId(dormitorySelection);

						} else if (singleBed == 1) {
							msg = "valid singleBed";
							dto.setRoomId(singlebedSelection);
						} else if (doubleBed == 1) {
							msg = "valid doubleBed ";
							dto.setRoomId(doubleBedSelection);
						} else {
							msg = "..Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
						}
					} else {
						msg = "Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
					}
				} else if (noOfGuests == 2) {
					if (noOfGuests >= countselection && countselection >= 1) {
						if (doubleBed == 1) {
							msg = "valid doubleBed";
							dto.setRoomId(doubleBedSelection);
						} else if (dormitory == 2) {
							msg = "valid dormitory";
							dto.setRoomId(dormitorySelection);
						} else if (singleBed == 1) // 1 extra PSGN
						{
							msg = "valid singleBed 1 extra PSGN";
							dto.setRoomId(singlebedSelection);
						}

						else {
							msg = "..Can be allotted one DB Room or 2 bed in dormitory";
						}
					} else {
						msg = "Can be allotted one DB Room or 2 bed in dormitory";
					}
				}

				else if (noOfGuests == 3) {
					if (countselection <= noOfGuests && countselection >= 1) {
						if (dormitory == 3) {
							msg = "valid dormitory";
							roomSelectionid[0] = dormitorySelection[dormitorybedindex];
							dto.setRoomId(dormitorySelection);
						} else if (doubleBed == 1 && singleBed == 1) {
							msg = "valid doubleBed + singleBed";
							roomSelectionid[0] = singlebedSelection[singalebedindex];
							roomSelectionid[1] = doubleBedSelection[doubleBedindex];
							dto.setRoomId(roomSelectionid);
						} else if (familyBed == 1) {
							msg = "valid familyBed";
							roomSelectionid[0] = familyBedSelection[familyBedindex];
							dto.setRoomId(familyBedSelection);
						} else if (doubleBed == 2) {
							msg = "valid doubleBed ";
							dto.setRoomId(doubleBedSelection);
						} else if (doubleBed == 1) // 1 extra psgn
						{
							msg = "valid doubleBed 1 extra psgn";
							dto.setRoomId(doubleBedSelection);
						} else {
							msg = "..Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
						}
					} else {
						msg = "Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
					}
				} else if (noOfGuests == 4) {
					if (countselection <= noOfGuests) {
						if (dormitory == noOfGuests) {
							msg = "valid dormitory";
							dto.setRoomId(dormitorySelection);
						} else if (doubleBed == 2) {
							msg = "valid doubleBed";
							dto.setRoomId(doubleBedSelection);
						}

						else if (familyBed == 1) {
							msg = "valid familyBed";
							dto.setRoomId(familyBedSelection);

						} else if (doubleBed == 1)// 2 extra psgn
						{
							msg = "valid doubleBed 2 extra psgn";
							dto.setRoomId(doubleBedSelection);
						} else {
							msg = "...Two DB Rooms or up to " + noOfGuests
									+ " beds in dormitory or 1 Family room subject to availability";
						}
					} else {
						msg = "Two DB Rooms or up to " + noOfGuests
								+ " beds in dormitory or 1 Family room subject to availability";
					}
				}

				else if (noOfGuests == 5) {
					if (noOfGuests >= countselection && countselection >= 1) {
						if (dormitory == noOfGuests) {
							msg = "valid dormitory";
							dto.setRoomId(dormitorySelection);
						} else if (doubleBed == 2) // one double bed room having extra psgn
						{
							msg = "valid doubleBed , one double bed room having 1 extra psgn";
							dto.setRoomId(doubleBedSelection);
						} else if (familyBed == 1) // 1 extra psgn
						{
							msg = "valid familyBed 1 extra psgn";
							dto.setRoomId(familyBedSelection);
						}

						else {
							msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
						}
					} else {
						msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
					}
				} else if (noOfGuests == 6) {
					if (noOfGuests >= countselection && countselection >= 1) {

						if (doubleBed == 2) // each double bed room having 1 Extra PSGN
						{
							msg = "valid doubleBed , each double bed room having 1 Extra PSGN";
							dto.setRoomId(doubleBedSelection);
						} else if (dormitory == noOfGuests) {
							msg = "valid dormitory";
							dto.setRoomId(dormitorySelection);
						}

						else {
							msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
						}
					} else {
						msg = "Two DB Rooms or up to " + noOfGuests + " beds in dormitory subject to availability";
					}
				}
				dto.setMsg(msg);
				dto.setSelectioncount(countselection);

			} else {
				msg = "Please select the room!....";
				dto.setMsg(msg);
			}

		} catch (Exception e) {
			msg = "please, Select valid Bed Room ";
			dto.setMsg(msg);
		}
		listroom.add(dto);
		return listroom;
	}
	
	public String checkPassengerAge()
	{
		String pnr="2836180355";
		PnrResponse obj=servicesImpl.getPnrenquery1(pnr);
		int noOfPassenger=obj.getNoOfPassengers();
		int validPassenger=0;
		int guestAge=0;
		System.out.println("noOfPassenger  ::  "+noOfPassenger);
		try {
		for(int i=0;i<noOfPassenger;i++)
		{
		 System.out.println(obj.getGuestsInfo().get(i).getAge());
		 guestAge=obj.getGuestsInfo().get(i).getAge();
		if(guestAge>=12)
		{
			validPassenger=validPassenger+1;
			System.out.println("validPassenger ::: "+validPassenger);
		}
		
	/*	if(guestAge>=5)
		{
			validPassenger=validPassenger+1;
			System.out.println("validPassenger ::: "+validPassenger);
		}  */
		
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

}
