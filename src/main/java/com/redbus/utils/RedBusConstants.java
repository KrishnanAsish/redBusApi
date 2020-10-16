package com.redbus.utils;

public interface RedBusConstants {
	
	enum SeatStatus{
		AVAILABLE,
		LOCKED,
		BOOKED
	}
	
	enum BusType {
		NON_AC,
		AC,
		SITTING,
		SEMI_SLEEPER,
		SLEEPER
	}
	
	enum SeatType {
		SITTING,
		SLEEPER;

	}
	
	enum AgeCategory{
		SUITABLE_FOR_ALL("ALL"),
		GUIDANCE_ADVICED("GUIDANCE"),
		ADULTS("ADULTS");
		
		private String ageCategory;
		
		AgeCategory(String ageCategory){
			this.ageCategory=ageCategory;
		}
		
		public String getAgeCategory() {
			return ageCategory;
		}
	}
	
	enum BookingStatus{
		BOOKED,CANCELLED;
	}
}
