package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Marriage{
	private Person spouse1;
	private Person spouse2;
	private Date date;
	private Location location;
	
	public static class MarriageBuilder{
		private Person spouse1 = Defaults.UNKNOWN_SPOUSE;
		private Person spouse2 = Defaults.UNKNOWN_SPOUSE;
		private Date date = Defaults.UNKNOWN_MARRIAGE_DATE;
		private Location location = Defaults.UNKNOWN_MARRIAGE_LOCATION;
		
		private MarriageBuilder(){ }
		
		public MarriageBuilder spouse1(Person spouse1){
			this.spouse1 = spouse1;
			return this;
		}
		
		public MarriageBuilder spouse2(Person spouse2){
			this.spouse2 = spouse2;
			return this;
		}
		
		public MarriageBuilder date(Date date){
			this.date = date;
			return this;
		}
		
		public MarriageBuilder location(Location location){
			this.location = location;
			return this;
		}
		
		public Marriage build(){
			return new Marriage(spouse1, spouse2, date, location);
		}
	}
	
	private Marriage(Person spouse1, Person spouse2, Date date, Location location){
		this.spouse1 = spouse1;
		this.spouse2 = spouse2;
		this.date = date;
		this.location = location;
	}
	
	public static MarriageBuilder builder(){
		return new MarriageBuilder();
	}
	
	public Person getSpouse1(){
		return spouse1;
	}
	
	public void setSpouse1(Person spouse1){
		this.spouse1 = spouse1;
	}
	
	public Person getSpouse2(){
		return spouse2;
	}
	
	public void setSpouse2(Person spouse2){
		this.spouse2 = spouse2;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location location){
		this.location = location;
	}
}
