package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class City{
	private String name;
	private County county;
	
	public static class CityBuilder{
		private String name = Defaults.UNKNOWN_CITY_NAME;
		private County county = Defaults.UNKNOWN_COUNTY;
		
		private CityBuilder(){ }
		
		public CityBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public CityBuilder county(County county){
			this.county = county;
			return this;
		}
		
		public City build(){
			return new City(name, county);
		}
	}
	
	private City(String name, County county){
		this.name = name;
		this.county = county;
	}
	
	public static CityBuilder builder(){
		return new CityBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public County getCounty(){
		return county;
	}
	
	public void setCounty(County county){
		this.county = county;
	}
}
