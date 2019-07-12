package com.invernadero.springsocket.model;

public class UserResponse {
	private String temp="0",humidity="0";	
	public UserResponse(String t, String h) {
		this.temp = t;
		this.humidity=h;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
}
