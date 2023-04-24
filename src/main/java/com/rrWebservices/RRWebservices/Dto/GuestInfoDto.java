package com.rrWebservices.RRWebservices.Dto;

public class GuestInfoDto {
	String name;
	String sex;
	
	//@Min(5)
	Short age;
	Long roomId;
	String roomNo;
	String roomType;
	String status;//booking status
	String address;
	String city;
	String state;
	String pin;
	String mobileNo;
	String email;
	String passengerIcardFlag;
	String passengerCardType;
	String passengerCardNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassengerIcardFlag() {
		return passengerIcardFlag;
	}
	public void setPassengerIcardFlag(String passengerIcardFlag) {
		this.passengerIcardFlag = passengerIcardFlag;
	}
	public String getPassengerCardType() {
		return passengerCardType;
	}
	public void setPassengerCardType(String passengerCardType) {
		this.passengerCardType = passengerCardType;
	}
	public String getPassengerCardNumber() {
		return passengerCardNumber;
	}
	public void setPassengerCardNumber(String passengerCardNumber) {
		this.passengerCardNumber = passengerCardNumber;
	}
	
	
	public GuestInfoDto(String name, String sex, Short age, Long roomId, String roomNo, String roomType, String status,
			String address, String city, String state, String pin, String mobileNo, String email,
			String passengerIcardFlag, String passengerCardType, String passengerCardNumber) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.status = status;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.mobileNo = mobileNo;
		this.email = email;
		this.passengerIcardFlag = passengerIcardFlag;
		this.passengerCardType = passengerCardType;
		this.passengerCardNumber = passengerCardNumber;
	}
	public GuestInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
