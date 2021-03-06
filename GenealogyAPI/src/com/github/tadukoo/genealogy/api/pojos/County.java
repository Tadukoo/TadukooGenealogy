package com.github.tadukoo.genealogy.api.pojos;

import com.github.tadukoo.genealogy.api.Defaults;

public class County{
	private String name;
	private State state;
	
	public static class CountyBuilder{
		private String name = Defaults.UNKNOWN_COUNTY_NAME;
		private State state = Defaults.UNKNOWN_STATE;
		
		private CountyBuilder(){ }
		
		public CountyBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public CountyBuilder state(State state){
			this.state = state;
			return this;
		}
		
		public County build(){
			return new County(name, state);
		}
	}
	
	private County(String name, State state){
		this.name = name;
		this.state = state;
	}
	
	public static CountyBuilder builder(){
		return new CountyBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
}
