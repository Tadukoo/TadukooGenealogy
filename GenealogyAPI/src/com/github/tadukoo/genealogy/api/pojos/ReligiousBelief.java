package com.github.tadukoo.genealogy.api.pojos;

import java.util.ArrayList;
import java.util.List;

import com.github.tadukoo.genealogy.api.Defaults;

public class ReligiousBelief{
	private Denomination denomination;
	private Religion religion;
	private Boolean current;
	private Date startDate;
	private Date endDate;
	private List<Event> events;
	
	public static class ReligiousBeliefBuilder{
		private Denomination denomination = Defaults.UNKNOWN_DENOMINATION;
		private Religion religion = Defaults.UNKNOWN_RELIGION;
		private Boolean current = null;
		private Date startDate = Defaults.UNKNOWN_RELIGIOUS_BELIEF_START_DATE;
		private Date endDate = Defaults.UNKNOWN_RELIGIOUS_BELIEF_END_DATE;
		private List<Event> events = new ArrayList<>();
		
		private ReligiousBeliefBuilder(){ }
		
		public ReligiousBeliefBuilder denomination(Denomination denomination){
			this.denomination = denomination;
			return this;
		}
		
		public ReligiousBeliefBuilder religion(Religion religion){
			this.religion = religion;
			return this;
		}
		
		public ReligiousBeliefBuilder current(Boolean current){
			this.current = current;
			return this;
		}
		
		public ReligiousBeliefBuilder startDate(Date startDate){
			this.startDate = startDate;
			return this;
		}
		
		public ReligiousBeliefBuilder endDate(Date endDate){
			this.endDate = endDate;
			return this;
		}
		
		public ReligiousBeliefBuilder events(List<Event> events){
			this.events = events;
			return this;
		}
		
		public ReligiousBeliefBuilder event(Event event){
			events.add(event);
			return this;
		}
		
		public ReligiousBelief build(){
			return new ReligiousBelief(denomination, religion, current, startDate, endDate, events);
		}
	}
	
	private ReligiousBelief(Denomination denomination, Religion religion, Boolean current, 
			Date startDate, Date endDate, List<Event> events){
		this.denomination = denomination;
		this.religion = religion;
		this.current = current;
		this.startDate = startDate;
		this.endDate = endDate;
		this.events = events;
	}
	
	public static ReligiousBeliefBuilder builder(){
		return new ReligiousBeliefBuilder();
	}
	
	public Denomination getDenomination(){
		return denomination;
	}
	
	public void setDenomination(Denomination denomination){
		this.denomination = denomination;
	}
	
	public Religion getReligion(){
		return religion;
	}
	
	public void setReligion(Religion religion){
		this.religion = religion;
	}
	
	public Boolean isCurrent(){
		return current;
	}
	
	public void setCurrent(Boolean current){
		this.current = current;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	
	public List<Event> getEvents(){
		return events;
	}
	
	public void setEvents(List<Event> events){
		this.events = events;
	}
	
	public boolean addEvent(Event event){
		return events.add(event);
	}
	
	public boolean removeEvent(Event event){
		return events.remove(event);
	}
}
