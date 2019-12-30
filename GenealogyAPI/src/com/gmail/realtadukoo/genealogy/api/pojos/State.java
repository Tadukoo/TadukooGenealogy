package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class State{
	private String name;
	private String abbreviation;
	private Country country;
	
	public static class StateBuilder{
		private String name = Defaults.UNKNOWN_STATE_NAME;
		private String abbreviation = Defaults.UNKNOWN_STATE_ABBREVIATION;
		private Country country = Defaults.UNKNOWN_COUNTRY;
		
		private StateBuilder(){ }
		
		public StateBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public StateBuilder abbreviation(String abbreviation){
			this.abbreviation = abbreviation;
			return this;
		}
		
		public StateBuilder country(Country country){
			this.country = country;
			return this;
		}
		
		public State build(){
			return new State(name, abbreviation, country);
		}
	}
	
	private State(String name, String abbreviation, Country country){
		this.name = name;
		this.abbreviation = abbreviation;
		this.country = country;
	}
	
	public static final StateBuilder builder(){
		return new StateBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}
	
	public Country getCountry(){
		return country;
	}
	
	public void setCountry(Country country){
		this.country = country;
	}
}
