package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Location{
	private City city;
	private County county;
	private State state;
	private Country country;
	
	public static class LocationBuilder{
		private City city = Defaults.UNKNOWN_CITY;
		private County county = Defaults.UNKNOWN_COUNTY;
		private State state = Defaults.UNKNOWN_STATE;
		private Country country = Defaults.UNKNOWN_COUNTRY;
		
		private LocationBuilder(){ }
		
		public LocationBuilder city(City city){
			this.city = city;
			return this;
		}
		
		public LocationBuilder county(County county){
			this.county = county;
			return this;
		}
		
		public LocationBuilder state(State state){
			this.state = state;
			return this;
		}
		
		public LocationBuilder country(Country country){
			this.country = country;
			return this;
		}
		
		public Location build(){
			return new Location(city, county, state, country);
		}
	}
	
	private Location(City city, County county, State state, Country country){
		this.city = city;
		this.county = county;
		this.state = state;
		this.country = country;
	}
	
	public static final LocationBuilder builder(){
		return new LocationBuilder();
	}
	
	public City getCity(){
		return city;
	}
	
	public void setCity(City city){
		this.city = city;
	}
	
	public County getCounty(){
		return county;
	}
	
	public void setCounty(County county){
		this.county = county;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public Country getCountry(){
		return country;
	}
	
	public void setCountry(Country country){
		this.country = country;
	}
}
