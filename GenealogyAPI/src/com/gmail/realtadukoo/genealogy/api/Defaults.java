package com.gmail.realtadukoo.genealogy.api;

import com.gmail.realtadukoo.genealogy.api.pojos.City;
import com.gmail.realtadukoo.genealogy.api.pojos.Country;
import com.gmail.realtadukoo.genealogy.api.pojos.County;
import com.gmail.realtadukoo.genealogy.api.pojos.Date;
import com.gmail.realtadukoo.genealogy.api.pojos.Denomination;
import com.gmail.realtadukoo.genealogy.api.pojos.Job;
import com.gmail.realtadukoo.genealogy.api.pojos.Location;
import com.gmail.realtadukoo.genealogy.api.pojos.Person;
import com.gmail.realtadukoo.genealogy.api.pojos.PoliticalBelief;
import com.gmail.realtadukoo.genealogy.api.pojos.PoliticalParty;
import com.gmail.realtadukoo.genealogy.api.pojos.Religion;
import com.gmail.realtadukoo.genealogy.api.pojos.ReligiousBelief;
import com.gmail.realtadukoo.genealogy.api.pojos.State;
import com.gmail.realtadukoo.genealogy.api.pojos.Date.DateStyle;
import com.gmail.realtadukoo.genealogy.api.pojos.Date.Month;
import com.gmail.realtadukoo.genealogy.api.pojos.Date.YearEra;

/**
 * A list of defaults for the various pojos in the project.
 * 
 * Note: A lot of the defaults are simply copies of others (e.g. 
 * {@link #UNKNOWN_BIRTH_DATE} is the same as {@link #UNKNOWN_DEATH_DATE}). 
 * This is so that if at any point in the future, it's made more granular, 
 * it won't cause any compatibility issues for those who properly distinguish 
 * them now.
 * 
 * @author Logan Ferree (Tadukoo)
 * @version 0.1-Alpha-SNAPSHOT
 */
public class Defaults{
	// Default unknowns
	private static final String UNKNOWN = "<Unknown>";
	private static final String UNKNOWN_ABBREVIATED = "<UNK>";
	private static final int UNKNOWN_NUM = -1;
	private static final Date UNKNOWN_DATE = null;
	private static final Location UNKNOWN_LOCATION = null;
	
	// Unknown Person IDs
	public static final int UNKNOWN_PERSON_DBID = UNKNOWN_NUM;
	public static final int UNKNOWN_PERSON_LDBID = UNKNOWN_NUM;
	public static final String UNKNOWN_PERSON_ID = UNKNOWN;
	public static final String UNKNOWN_PERSON_OID = UNKNOWN;
	
	// Sex Info
	public static final String UNKNOWN_SEX = UNKNOWN;
	public static final String MALE = "male";
	public static final String FEMALE = "female";
	
	// Unknown Names
	public static final String UNKNOWN_FIRST_NAME = UNKNOWN;
	public static final String UNKNOWN_MIDDLE_NAME = UNKNOWN;
	public static final String UNKNOWN_LAST_NAME = UNKNOWN;
	
	// Unknown Dates
	public static final Date UNKNOWN_BIRTH_DATE = UNKNOWN_DATE;
	public static final Date UNKNOWN_DEATH_DATE = UNKNOWN_DATE;
	
	// Unknown Date pieces
	public static final Month UNKNOWN_MONTH = Month.UNKNOWN;
	public static final int UNKNOWN_DAY = UNKNOWN_NUM;
	public static final int UNKNOWN_YEAR = UNKNOWN_NUM;
	public static final YearEra DEFAULT_YEAR_ERA = YearEra.A_D;
	public static final DateStyle DEFAULT_DATE_STYLE = DateStyle.NEW_STYLE;
	
	// Unknown Locations
	public static final Location UNKNOWN_BIRTH_LOCATION = UNKNOWN_LOCATION;
	public static final Location UNKNOWN_DEATH_LOCATION = UNKNOWN_LOCATION;
	public static final Location UNKNOWN_JOB_LOCATION = UNKNOWN_LOCATION;
	
	// Unknown Country info
	public static final String UNKNOWN_COUNTRY_NAME = UNKNOWN;
	public static final String UNKNOWN_COUNTRY_ABBREVIATION = UNKNOWN_ABBREVIATED;
	public static final Country UNKNOWN_COUNTRY = Country.builder()
															.name(UNKNOWN_COUNTRY_NAME)
															.build();
	
	// Unknown State info
	public static final String UNKNOWN_STATE_NAME = UNKNOWN;
	public static final String UNKNOWN_STATE_ABBREVIATION = UNKNOWN_ABBREVIATED;
	public static final State UNKNOWN_STATE = State.builder()
													.name(UNKNOWN_STATE_NAME)
													.country(UNKNOWN_COUNTRY)
													.build();
	
	// Unknown County Info
	public static final String UNKNOWN_COUNTY_NAME = UNKNOWN;
	public static final County UNKNOWN_COUNTY = County.builder()
														.name(UNKNOWN_COUNTY_NAME)
														.state(UNKNOWN_STATE)
														.build();
	
	// Unknown City Info
	public static final String UNKNOWN_CITY_NAME = UNKNOWN;
	public static final City UNKNOWN_CITY = City.builder()
												.name(UNKNOWN_CITY_NAME)
												.county(UNKNOWN_COUNTY)
												.build();
	
	// Unknown Job Info
	public static final String UNKNOWN_JOB_TITLE = UNKNOWN;
	public static final Date UNKNOWN_JOB_START_DATE = UNKNOWN_DATE;
	public static final Date UNKNOWN_JOB_END_DATE = UNKNOWN_DATE;
	public static final Job UNKNOWN_JOB = Job.builder()
												.title(UNKNOWN_JOB_TITLE)
												.location(UNKNOWN_JOB_LOCATION)
												.startDate(UNKNOWN_JOB_START_DATE)
												.endDate(UNKNOWN_JOB_END_DATE)
												.build();
	// Unknown Religion Info
	public static final String UNKNOWN_RELIGION_NAME = UNKNOWN;
	public static final Religion UNKNOWN_RELIGION = Religion.builder()
															.name(UNKNOWN_RELIGION_NAME)
															.build();
	
	// Unknown Denomination Info
	public static final String UNKNOWN_DENOMINATION_NAME = UNKNOWN;
	public static final Denomination UNKNOWN_DENOMINATION = Denomination.builder()
																		.name(UNKNOWN_DENOMINATION_NAME)
																		.religion(UNKNOWN_RELIGION)
																		.build();
	
	// Unknown Religious Belief Info
	public static final Date UNKNOWN_RELIGIOUS_BELIEF_START_DATE = UNKNOWN_DATE;
	public static final Date UNKNOWN_RELIGIOUS_BELIEF_END_DATE = UNKNOWN_DATE;
	public static final ReligiousBelief UNKNOWN_RELIGIOUS_BELIEF = ReligiousBelief.builder()
																					.denomination(UNKNOWN_DENOMINATION)
																					.startDate(UNKNOWN_RELIGIOUS_BELIEF_START_DATE)
																					.endDate(UNKNOWN_RELIGIOUS_BELIEF_END_DATE)
																					.religion(UNKNOWN_RELIGION)
																					.build();
	
	// Unknown Event Info
	public static final Date UNKNOWN_EVENT_DATE = UNKNOWN_DATE;
	public static final Location UNKNOWN_EVENT_LOCATION = UNKNOWN_LOCATION;
	
	// Unknown Political Party Info
	public static final String UNKNOWN_POLITICAL_PARTY_NAME = UNKNOWN;
	public static final Country UNKNOWN_POLITICAL_PARTY_COUNTRY = UNKNOWN_COUNTRY;
	public static final PoliticalParty UNKNOWN_POLITICAL_PARTY = PoliticalParty.builder()
																				.name(UNKNOWN_POLITICAL_PARTY_NAME)
																				.country(UNKNOWN_POLITICAL_PARTY_COUNTRY)
																				.build();
	
	// Unknown Political Belief Info
	public static final Date UNKNOWN_POLITICAL_BELIEF_START_DATE = UNKNOWN_DATE;
	public static final Date UNKNOWN_POLITICAL_BELIEF_END_DATE = UNKNOWN_DATE;
	public static final PoliticalBelief UNKNOWN_POLITICAL_BELIEF = PoliticalBelief.builder()
																					.politicalParty(UNKNOWN_POLITICAL_PARTY)
																					.startDate(UNKNOWN_POLITICAL_BELIEF_START_DATE)
																					.endDate(UNKNOWN_POLITICAL_BELIEF_END_DATE)
																					.build();
	
	// Unknown Marriage Info
	public static final Person UNKNOWN_SPOUSE = null;
	public static final Date UNKNOWN_MARRIAGE_DATE = UNKNOWN_DATE;
	public static final Location UNKNOWN_MARRIAGE_LOCATION = UNKNOWN_LOCATION;
	
	// Unknown Child Relationship Info
	public static final Person UNKNOWN_FATHER = null;
	public static final Person UNKNOWN_MOTHER = null;
	
}
