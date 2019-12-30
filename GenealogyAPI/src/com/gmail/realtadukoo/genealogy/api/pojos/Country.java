package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Country{
	private String name;
	private String abbreviation;
	
	public static class CountryBuilder{
		private String name = Defaults.UNKNOWN_COUNTRY_NAME;
		private String abbreviation = Defaults.UNKNOWN_COUNTRY_ABBREVIATION;
		
		private CountryBuilder(){ }
		
		public CountryBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public CountryBuilder abbreviation(String abbreviation){
			this.abbreviation = abbreviation;
			return this;
		}
		
		public Country build(){
			return new Country(name, abbreviation);
		}
	}
	
	private Country(String name, String abbreviation){
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	public static final CountryBuilder builder(){
		return new CountryBuilder();
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
}
