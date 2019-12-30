package com.gmail.realtadukoo.genealogy.api.pojos;

public class Event{
	private String name;
	private Date date;
	private Location location;
	
	public static class EventBuilder{
		private String name;
		private Date date;
		private Location location;
		
		private EventBuilder(){ }
		
		public EventBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public EventBuilder date(Date date){
			this.date = date;
			return this;
		}
		
		public EventBuilder location(Location location){
			this.location = location;
			return this;
		}
		
		public Event build(){
			return new Event(name, date, location);
		}
	}
	
	private Event(String name, Date date, Location location){
		this.name = name;
		this.date = date;
		this.location = location;
	}
	
	public static final EventBuilder builder(){
		return new EventBuilder();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
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
