package com.rrWebservices.RRWebservices.Dto;

import org.springframework.stereotype.Component;

@Component
public class ErrorMsg {
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public String setMsg(String msg) {
		return this.msg = msg;
	}

}
