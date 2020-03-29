package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Religion{
	private String name;
	
	public static class ReligionBuilder{
		private String name = Defaults.UNKNOWN_RELIGION_NAME;
		
		private ReligionBuilder(){ }
		
		public ReligionBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public Religion build(){
			return new Religion(name);
		}
	}
	
	private Religion(String name){
		this.name = name;
	}
	
	public static ReligionBuilder builder(){
		return new ReligionBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
