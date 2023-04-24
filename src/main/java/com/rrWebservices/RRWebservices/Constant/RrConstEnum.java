package com.rrWebservices.RRWebservices.Constant;



public interface RrConstEnum {
	
	public static final boolean DEFAULT_USER_ACTIVE_FLAG	= false;
	public static final int MIN_USERNAME_LENGTH				= 3;
	public static final int MAX_USERNAME_LENGTH				= 75;
	public static final int MIN_FIRST_NAME_LENGTH			= 1;
	public static final int MAX_FIRST_NAME_LENGTH			= 50;
	public static final int MIN_MIDDLE_NAME_LENGTH			= 1;
	public static final int MAX_MIDDLE_NAME_LENGTH			= 50;
	public static final int MIN_LAST_NAME_LENGTH			= 1;
	public static final int MAX_LAST_NAME_LENGTH			= 50;
	public static final int MOBILE_NUMBER_LENGTH			= 10;
	public static final int MIN_EMAIL_ID_LENGTH				= 5;
	public static final int MAX_EMAIL_ID_LENGTH				= 75;
	public static final String DATETIME_FORMATTER 			= "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMATTER 				= "yyyy-MM-dd";
	public static final String TIME_FORMATTER 				= "HH:mm:ss";
	public static final String PnrEnquiryDevURL 			= "http://10.64.28.106:9090/service/pnrenquiry/";
	
	public static final String PnrEnquiryDevUser 				= "cris";//"rroom";
	public static final String PnrEnquiryDevPassword 			= "cris@123";//"123@rr";
	
	public static final String PnrEnquiryProdURL 				= "http://10.64.28.114/service/pnrenquiry/";
	public static final String PnrEnquiryProdUser 				= "cris";
	public static final String PnrEnquiryProdPassword 			= "0b0abp1bi6mexri2pjn2kymev53s1p8v";
	
	public static final String PnrEnquiryWithCaptchaProdURL 	= "http://10.64.28.114/pnrenquiry/";
	public static final String PnrEnquiryWithCaptchaProdUser 	= "rroom";
	public static final String PnrEnquiryWithCaptchaProdPassword = "406d921d6d5a46379d45ff0d2ae5b6ce";
	
	public static final String PnrEnquiryURL 					= PnrEnquiryProdURL;
	public static final String PnrEnquiryUser 					= PnrEnquiryProdUser;
	public static final String PnrEnquiryPassword 				= PnrEnquiryProdPassword;
	
	public static final boolean sendSMS 						= true;
	public static final int MORE_THAN_24_HR_CHARGE_PERCENTAGE	= 25;
	public static final int EXTEND_BOOKING_PERCENTAGE			= 25;
	public static final int INTERNET_DISCOUNT_PERCENTAGE		= 5;
	
	public static final String guestGstDetailURL 			= "http://10.64.35.63:80/GSTWebService/taxpayerApi/getGSTINDetails?GSTIN=";
		//	"http://10.64.26.143:8090/GSTWebService/taxpayerApi/getGSTINDetails?GSTIN=";
			//"https://gst.indianrail.gov.in/GSTWebService/taxpayerApi/getGSTINDetails?GSTIN=";
	
	String[] finalTxns = {LoginRollTxnType.CONFIRM_BOOKING.getSymbol(),LoginRollTxnType.CONFIRM_CANCELLATION.getSymbol(),LoginRollTxnType.CONFIRM_CHECKOUT.getSymbol(),
			LoginRollTxnType.CONFIRM_CASH_LOGOUT.getSymbol(),LoginRollTxnType.NON_ISSUE_BOOKING.getSymbol(),
			LoginRollTxnType.NON_ISSUE_CANCEL.getSymbol(),LoginRollTxnType.NON_ISSUE_CHECKOUT.getSymbol(), LoginRollTxnType.NON_ISSUE_CASH_LOGOUT.getSymbol()};
	
	public enum UserType {
		Railway_User,
		Internet_User,
		Agent
	}
	
	
	//PL - Partial Login, N-Normal Login Logout, FL-ForcedLogout, 
	//System.out.println(LoginType.Partial_Login.getLoginTypeCode());
	public enum LoginType {
		Partial_Login("PL"), Normal_Login("LI"),Normal_Logout("LO"), Forced_Logout("FL"), Supervisor_Login("SL"), Supervisor_Logout("SO");
	    String loginTypeCode;
	    LoginType(String loginTypeCode) {
	        this.loginTypeCode = loginTypeCode;
	    }
	    public String getSymbol() {
	        return loginTypeCode;
	    }
	}
	
	public enum RollStatus {
		Active("A"), End("E");
	    String rollStatus;
	    RollStatus(String rollStatus) {
	        this.rollStatus = rollStatus;
	    }
	    public String getSymbol() {
	        return rollStatus;
	    }
	}
	
	//B-ROOM BOOKED, C-ROOM CANCELLED, E-ROOM EXTENDED, U-ROOM UPGRADED, O-ROOM CHECKOUT, F-NON ISSUE, I-ROOM CHECKIN, SC-Special Cancellation, BI - Booked and Checkedin, S/CC-success cash close(S in old RR/CC in new RR)
	
	public enum LoginRollTxnType {
		ROOM_BOOKED("B"), ROOM_CANCELLED("C"), ROOM_EXTENDED("E"), ROOM_UPGRADED("U"), ROOM_CHECKOUT("O"), ROOM_CHECKIN("I"), NON_ISSUE_BOOKING("FB"), 
		CASH_LOGOUT("CL"),NON_ISSUE_CANCEL("FC"), NON_ISSUE_CHECKOUT("FH"), NON_ISSUE_CASH_LOGOUT("FO"),
		SPECIAL_CANCELLATION("SC"), BOOKED_AND_CHECKEDIN("BI"), SUCCESS_CASH_CLOSE("CC"), PARTIAL_LOGIN("PL"), NORMAL_LOGIN("LI"), FORCED_LOGOUT("FL"), 
		SUPERVISOR_LOGIN("SL"), SUPERVISOR_LOGOUT("SO"), ROLL_RELOADED("RR"),
		CONFIRM_BOOKING("CB"), CONFIRM_CANCELLATION("CC"), CONFIRM_CHECKOUT("CH"), CONFIRM_CASH_LOGOUT("CO");
	    String loginRollTxnType;
	    LoginRollTxnType(String loginRollTxnType) {
	        this.loginRollTxnType = loginRollTxnType;
	    }
	    public String getSymbol() {
	        return loginRollTxnType;
	    }
	}
	
	public enum ShiftDuty {
		Night,
		Morning,
		Evening
	}
	
	public enum RoleName {
		ROLE_Admin,
		ROLE_Agent,
		ROLE_Supervisor,
		ROLE_Booking_Operator,
		ROLE_Report_Viewer,
		ROLE_Helpdesk,
		ROLE_Booking_Agent,
		ROLE_Maintenance,
		ROLE_RDS
	}
	
	
	public enum IntermediateStatus {
		//BEFORE_BOOK,
		AFTER_BOOK,
		BEFORE_BOOK_REPRINT,
		AFTER_BOOK_REPRINT,
		BEFORE_BOOK_CNF,
		AFTER_BOOK_CNF,
		BEFORE_CANCEL,
		AFTER_CANCEL,
		BEFORE_CANCEL_REPRINT,
		AFTER_CANCEL_REPRINT,
		BEFORE_CANCEL_CNF,
		AFTER_CANCEL_CNF,
		BEFORE_CHECKOUT,
		AFTER_CHECKOUT,
		BEFORE_CHECKOUT_REPRINT,
		AFTER_CHECKOUT_REPRINT,
		BEFORE_CHECKOUT_CNF,
		AFTER_CHECKOUT_CNF
	}
	
	
	//1-special cancel, 2-revert booking, 3-rever booking manual, 4-revert cancel, 5-revert cancel manual
	public enum SpecialCancelTxnType {
		NORMAL_CANCEL,
		SPECIAL_CANCEL,
		REVERT_BOOKING,
		REVERT_BOOKING_OPERATOR,
		REVERT_CANCEL,
		REVERT_CANCEL_OPERATOR,
		REVERT_CHECKOUT,
		REVERT_CHECKOUT_OPERATOR,
		ROOM_RELEASE
	}
	
	public enum SearchTask{
		CHECKIN,
		CHECKOUT
	}
	
	
	public enum Status {
		SUCCESS,
		FAIL,
		ERROR
	}
	public enum MessageType {
		MESSAGE,
		INFO,
		TOKEN
	}
	public enum BookingStatus {
		BOOKED,
		CANCELLED,
		PARTIAL_CANCELLED,
		CHECKIN,
		CHECKOUT
	}
	public enum BookingMode{
		I,//Internet
		S//System
	}
	public enum Quota{
		GN,//General Quata
		LD,//Ladies Quata
		HQ,//HQ/VIP Quata
		GM,//General Male Quata
		HP//Specially Ablid Quat
	}
	
	public enum Sex{
		M,//Male
		F//Female
	}
	
	public enum BedType{
		DOUBLE,
		SINGLE,
		FAMILY,
		DORMITORY,
		DSR
	}
	
	public enum Authority{
		PNR_TICKET,
		RAILWAY_PASS,
		UTS_TICKET,
		FREE_PASS,
		OTHERS
	}
	
	public enum TypeOfBooking{
		BOOKING,
		EXTEND_BOOKING,
		HOURLY_BOOKING,
		EXTEND_HOURLY_BOOKING
	}
	
	public enum GstnSourceType {
		PASSENGER("P"), SYSTEM("S"),NO_GST("N");
	    String gstnSourceType;
	    GstnSourceType(String gstnSourceType) {
	        this.gstnSourceType = gstnSourceType;
	    }
	    public String getSymbol() {
	        return gstnSourceType;
	    }
	}
	
	public enum MaxLimit {
		MaxPsgn(6), DoubleRoom(2), SingleRoom(6), FamilyRoom(1), Dormitory(6);
	    int max;
	    MaxLimit(int max) {
	        this.max = max;
	    }
	    public int getMaxLimit() {
	        return max;
	    }
	}
}
