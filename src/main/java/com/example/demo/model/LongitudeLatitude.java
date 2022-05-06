package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LongitudeLatitude {
	
	public LongitudeLatitude(){
		
	}
	
	@JsonProperty("latitude")
	private Float latitude;
	
	@JsonProperty("longitude")
	private Float longitude;
	
	public Float getLatitude() {
		return this.latitude;
	}
	
	public Float getLongitude() {
		return this.longitude;
	}
	
	public void setLatitude(Float latitude){
		this.latitude = latitude;
	}
	
	public void setLongitude(Float longitude){
		this.longitude = longitude;
	}
	
}
