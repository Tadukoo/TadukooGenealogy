package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Job{
	private String title;
	private Location location;
	private Boolean current;
	private Date startDate;
	private Date endDate;
	
	public static class JobBuilder{
		private String title = Defaults.UNKNOWN_JOB_TITLE;
		private Location location = Defaults.UNKNOWN_JOB_LOCATION;
		private Boolean current = null;
		private Date startDate = Defaults.UNKNOWN_JOB_START_DATE;
		private Date endDate = Defaults.UNKNOWN_JOB_END_DATE;
		
		private JobBuilder(){ }
		
		public JobBuilder title(String title){
			this.title = title;
			return this;
		}
		
		public JobBuilder location(Location location){
			this.location = location;
			return this;
		}
		
		public JobBuilder current(Boolean current){
			this.current = current;
			return this;
		}
		
		public JobBuilder startDate(Date startDate){
			this.startDate = startDate;
			return this;
		}
		
		public JobBuilder endDate(Date endDate){
			this.endDate = endDate;
			return this;
		}
		
		public Job build(){
			return new Job(title, location, current, startDate, endDate);
		}
	}
	
	private Job(String title, Location location, Boolean current, Date startDate, Date endDate){
		this.title = title;
		this.location = location;
		this.current = current;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public static JobBuilder builder(){
		return new JobBuilder();
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location location){
		this.location = location;
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
