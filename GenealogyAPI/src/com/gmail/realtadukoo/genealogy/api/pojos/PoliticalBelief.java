package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class PoliticalBelief{
	private PoliticalParty politicalParty;
	private Boolean current;
	private Date startDate;
	private Date endDate;
	
	public static class PoliticalBeliefBuilder{
		private PoliticalParty politicalParty = Defaults.UNKNOWN_POLITICAL_PARTY;
		private Boolean current = null;
		private Date startDate = Defaults.UNKNOWN_POLITICAL_BELIEF_START_DATE;
		private Date endDate = Defaults.UNKNOWN_POLITICAL_BELIEF_END_DATE;
		
		private PoliticalBeliefBuilder(){ }
		
		public PoliticalBeliefBuilder politicalParty(PoliticalParty politicalParty){
			this.politicalParty = politicalParty;
			return this;
		}
		
		public PoliticalBeliefBuilder current(Boolean current){
			this.current = current;
			return this;
		}
		
		public PoliticalBeliefBuilder startDate(Date startDate){
			this.startDate = startDate;
			return this;
		}
		
		public PoliticalBeliefBuilder endDate(Date endDate){
			this.endDate = endDate;
			return this;
		}
		
		public PoliticalBelief build(){
			return new PoliticalBelief(politicalParty, current, startDate, endDate);
		}
	}
	
	private PoliticalBelief(PoliticalParty politicalParty, Boolean current, Date startDate, Date endDate){
		this.politicalParty = politicalParty;
		this.current = current;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public static final PoliticalBeliefBuilder builder(){
		return new PoliticalBeliefBuilder();
	}
	
	public PoliticalParty getPoliticalParty(){
		return politicalParty;
	}
	
	public void setPoliticalParty(PoliticalParty politicalParty){
		this.politicalParty = politicalParty;
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
}
