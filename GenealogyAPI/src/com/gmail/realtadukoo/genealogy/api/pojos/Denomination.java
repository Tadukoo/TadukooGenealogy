package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Denomination{
	private String name;
	private Religion religion;
	
	public static class DenominationBuilder{
		private String name = Defaults.UNKNOWN_DENOMINATION_NAME;
		private Religion religion = Defaults.UNKNOWN_RELIGION;
		
		private DenominationBuilder(){ }
		
		public DenominationBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public DenominationBuilder religion(Religion religion){
			this.religion = religion;
			return this;
		}
		
		public Denomination build(){
			return new Denomination(name, religion);
		}
	}
	
	private Denomination(String name, Religion religion){
		this.name = name;
		this.religion = religion;
	}
	
	public static DenominationBuilder builder(){
		return new DenominationBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Religion getReligion(){
		return religion;
	}
	
	public void setReligion(Religion religion){
		this.religion = religion;
	}
}
