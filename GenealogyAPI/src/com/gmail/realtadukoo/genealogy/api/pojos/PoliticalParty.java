package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class PoliticalParty{
	private String name;
	private Country country;
	
	public static class PoliticalPartyBuilder{
		private String name = Defaults.UNKNOWN_POLITICAL_PARTY_NAME;
		private Country country = Defaults.UNKNOWN_POLITICAL_PARTY_COUNTRY;
		
		private PoliticalPartyBuilder(){ }
		
		public PoliticalPartyBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public PoliticalPartyBuilder country(Country country){
			this.country = country;
			return this;
		}
		
		public PoliticalParty build(){
			return new PoliticalParty(name, country);
		}
	}
	
	private PoliticalParty(String name, Country country){
		this.name = name;
		this.country = country;
	}
	
	public static final PoliticalPartyBuilder builder(){
		return new PoliticalPartyBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Country getCountry(){
		return country;
	}
	
	public void setCountry(Country country){
		this.country = country;
	}
}
