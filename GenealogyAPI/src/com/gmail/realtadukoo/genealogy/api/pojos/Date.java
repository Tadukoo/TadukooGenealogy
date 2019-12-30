package com.gmail.realtadukoo.genealogy.api.pojos;

import com.gmail.realtadukoo.genealogy.api.Defaults;

public class Date{
	private Month month;
	private int day;
	private int year;
	private YearEra yearEra;
	private DateStyle style;
	
	public static enum Month{
		UNKNOWN("?"),
		JANUARY("January"),
		FEBRUARY("February"),
		MARCH("March"),
		APRIL("April"),
		MAY("May"),
		JUNE("June"),
		JULY("July"),
		AUGUST("August"),
		SEPTEMBER("September"),
		OCTOBER("October"),
		NOVEMBER("November"),
		DECEMBER("December");
		
		private String asText;
		
		private Month(String asText){
			this.asText = asText;
		}
		
		@Override
		public String toString(){
			return asText;
		}
	}
	
	public static enum DateStyle{
		OLD_STYLE,
		NEW_STYLE;
	}
	
	public static enum YearEra{
		B_C,
		A_D;
	}
	
	public static class DateBuilder{
		private Month month = Defaults.UNKNOWN_MONTH;
		private int day = Defaults.UNKNOWN_DAY;
		private int year = Defaults.UNKNOWN_YEAR;
		private YearEra yearEra = Defaults.DEFAULT_YEAR_ERA;
		private DateStyle style = Defaults.DEFAULT_DATE_STYLE;
		
		private DateBuilder(){ }
		
		public DateBuilder month(Month month){
			this.month = month;
			return this;
		}
		
		public DateBuilder day(int day){
			this.day = day;
			return this;
		}
		
		public DateBuilder year(int year){
			this.year = year;
			return this;
		}
		
		public DateBuilder yearEra(YearEra yearEra){
			this.yearEra = yearEra;
			return this;
		}
		
		public DateBuilder style(DateStyle style){
			this.style = style;
			return this;
		}
		
		public Date build(){
			return new Date(month, day, year, yearEra, style);
		}
	}
	
	private Date(Month month, int day, int year, YearEra yearEra, DateStyle style){
		this.month = month;
		this.day = day;
		this.year = year;
		this.yearEra = yearEra;
		this.style = style;
	}
	
	public static DateBuilder builder(){
		return new DateBuilder();
	}
	
	public Month getMonth(){
		return month;
	}
	
	public void setMonth(Month month){
		this.month = month;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public YearEra getYearEra(){
		return yearEra;
	}
	
	public void setYearEra(YearEra yearEra){
		this.yearEra = yearEra;
	}
	
	public DateStyle getStyle(){
		return style;
	}
	
	public void setStyle(DateStyle style){
		this.style = style;
	}
}
