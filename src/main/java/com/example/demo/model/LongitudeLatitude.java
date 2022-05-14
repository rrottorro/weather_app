package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class LongitudeLatitude {
	
	public LongitudeLatitude(){
		
	}
	
    @Getter
    @Setter
	private Float latitude;
	
    @Getter
    @Setter
	private Float longitude;
    
    @Getter
    @Setter
	private String place;
	
}
