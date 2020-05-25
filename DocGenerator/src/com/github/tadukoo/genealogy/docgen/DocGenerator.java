package com.github.tadukoo.genealogy.docgen;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import com.github.tadukoo.genealogy.api.Defaults;
import com.github.tadukoo.genealogy.api.files.PersonFileFormat;
import com.github.tadukoo.genealogy.api.pojos.ChildRelationship;
import com.github.tadukoo.genealogy.api.pojos.City;
import com.github.tadukoo.genealogy.api.pojos.Country;
import com.github.tadukoo.genealogy.api.pojos.County;
import com.github.tadukoo.genealogy.api.pojos.Date;
import com.github.tadukoo.genealogy.api.pojos.Date.DateStyle;
import com.github.tadukoo.genealogy.api.pojos.Date.Month;
import com.github.tadukoo.genealogy.api.pojos.Date.YearEra;
import com.github.tadukoo.genealogy.api.pojos.Denomination;
import com.github.tadukoo.genealogy.api.pojos.Event;
import com.github.tadukoo.genealogy.api.pojos.Job;
import com.github.tadukoo.genealogy.api.pojos.Location;
import com.github.tadukoo.genealogy.api.pojos.Marriage;
import com.github.tadukoo.genealogy.api.pojos.Person;
import com.github.tadukoo.genealogy.api.pojos.PoliticalBelief;
import com.github.tadukoo.genealogy.api.pojos.PoliticalParty;
import com.github.tadukoo.genealogy.api.pojos.Religion;
import com.github.tadukoo.genealogy.api.pojos.ReligiousBelief;
import com.github.tadukoo.genealogy.api.pojos.State;
import com.github.tadukoo.util.BooleanUtil;

public class DocGenerator{
	private static Person person;
	private static Person personWife;
	private static Person personChild;
	
	private static void setup(){
		Location yorkCity = Location.builder()
									.city(City.builder()
												.name("York")
												.build()
									)
									.county(County.builder()
													.name("York")
													.build()
									)
									.state(State.builder()
												.name("Pennsylvania")
												.abbreviation("PA")
												.build()
									)
									.country(Country.builder()
													.name("United States")
													.abbreviation("US")
													.build()
									)
									.build();
		
		person = Person.builder()
						.ID("5.3.1")
						.OID("235A")
						.firstName("John")
						.middleName("Jacob")
						.lastName("Smith")
						.birthDate(Date.builder()
									.month(Month.SEPTEMBER)
									.day(2)
									.year(1995)
									.yearEra(YearEra.A_D)
									.style(DateStyle.NEW_STYLE)
									.build()
								)
						.birthLocation(yorkCity)
						.deathDate(Date.builder()
									.month(Month.APRIL)
									.day(1)
									.year(1029)
									.yearEra(YearEra.A_D)
									.style(DateStyle.NEW_STYLE)
									.build()
								)
						.job(Job.builder()
								.title("Programmer")
								.location(yorkCity)
								.startDate(Date.builder()
												.month(Month.JULY)
												.day(5)
												.year(2013)
												.build()
										)
								.endDate(Date.builder()
												.month(Month.AUGUST)
												.day(29)
												.year(2020)
												.build()
										)
								.build()
							)
						.religiousBelief(ReligiousBelief.builder()
														.denomination(Denomination.builder()
																					.name("Catholic")
																					.build()
														)
														.religion(Religion.builder()
																			.name("Christian")
																			.build()
														)
														.startDate(Date.builder()
																		.month(Month.MAY)
																		.day(25)
																		.year(2004)
																		.build()
														)
														.endDate(Date.builder()
																		.month(Month.JANUARY)
																		.day(31)
																		.year(2005)
																		.build()
														)
														.event(Event.builder()
																	.name("Baptized")
																	.date(Date.builder()
																				.month(Month.MAY)
																				.day(25)
																				.year(2004)
																				.build()
																	)
																	.location(yorkCity)
																	.build()
														)
														.build()
							)
						.politicalBelief(PoliticalBelief.builder()
														.politicalParty(PoliticalParty.builder()
																						.name("Republican Party")
																						.build()
														)
														.startDate(Date.builder()
																		.month(Month.AUGUST)
																		.day(19)
																		.year(2003)
																		.build()
														)
														.endDate(Date.builder()
																		.month(Month.AUGUST)
																		.day(20)
																		.year(2003)
																		.build()
														)
														.build()
							)
						.detail("This was a guy who lived in the world. He didn't do much, but boy did he live. "
								+ "He just lived and lived and lived and lived, and lived some more. What he did, "
								+ "no one really knows, but he sure lived. Yes he did. Okay, are we done recording? "
								+ "No? Okay, so he lived in some place in the world and just lived there doing "
								+ "who knows what with all his time. But he lived, that's for sure.")
						.detail("This was a guy who lived in the world. He didn't do much, but boy did he live. "
								+ "He just lived and lived and lived and lived, and lived some more. What he did, "
								+ "no one really knows, but he sure lived. Yes he did. Okay, are we done recording? "
								+ "No? Okay, so he lived in some place in the world and just lived there doing "
								+ "who knows what with all his time. But he lived, that's for sure. 2 Electric Booagloo")
						.build();
		
		personWife = Person.builder()
							.firstName("Jane")
							.middleName("Jimmy")
							.lastName("Do")
							.build();
		
		Marriage marriage = Marriage.builder()
									.spouse1(person)
									.spouse2(personWife)
									.date(Date.builder()
												.month(Month.FEBRUARY)
												.day(23)
												.year(2004)
												.build()
										)
									.location(yorkCity)
									.build();
		
		person.addMarriage(marriage);
		
		personChild = Person.builder()
							.firstName("Jimmy")
							.middleName("John")
							.build();
		
		ChildRelationship childRel = ChildRelationship.builder()
														.father(person)
														.mother(personWife)
														.child(personChild)
														.build();
		
		person.addChild(childRel);
	}
	
	private static String formatDate(Date unknown, Date date){
		String text = "";
		if(unknown == date){
			text += "?";
		}else{
			Month month = date.getMonth();
			int day = date.getDay();
			int year = date.getYear();
			if(Defaults.UNKNOWN_MONTH != month){
				text += date.getMonth().toString();
				if(Defaults.UNKNOWN_DAY != day){
					text += " " + day + ", ";
				}
			}
			if(Defaults.UNKNOWN_YEAR != year){
				text += year;
			}else{
				text += "?";
			}
		}
		return text;
	}
	
	private static String formatLocation(Location unknown, Location location){
		String text = "";
		if(unknown != location){
			text += " at ";
			City city = location.getCity();
			County county = location.getCounty();
			State state = location.getState();
			Country country = location.getCountry();
			if(Defaults.UNKNOWN_CITY != city){
				text += city.getName() + ", ";
			}
			if(Defaults.UNKNOWN_COUNTY != county){
				text += county.getName() + " County, ";
			}
			if(Defaults.UNKNOWN_STATE != state){
				text += state.getAbbreviation() + ", ";
			}
			if(Defaults.UNKNOWN_COUNTRY != country){
				text += country.getAbbreviation();
			}
		}
		
		return text;
	}
	
	private static String formatReligiousBelief(ReligiousBelief religiousBelief){
		String text = "";
		Denomination denomination = religiousBelief.getDenomination();
		Religion religion = religiousBelief.getReligion();
		Date startDate = religiousBelief.getStartDate();
		Date endDate = religiousBelief.getEndDate();
		if(religiousBelief.getDenomination() != Defaults.UNKNOWN_DENOMINATION){
			text += denomination.getName() + " (" + religion.getName() + ")";
		}else{
			text += religion.getName();
		}
		if(startDate != Defaults.UNKNOWN_RELIGIOUS_BELIEF_START_DATE || 
				endDate != Defaults.UNKNOWN_RELIGIOUS_BELIEF_END_DATE){
			text += " " + formatDate(Defaults.UNKNOWN_RELIGIOUS_BELIEF_START_DATE, startDate) + 
					" - " + 
					(BooleanUtil.isTrue(religiousBelief.isCurrent())?
							"present":
							formatDate(Defaults.UNKNOWN_RELIGIOUS_BELIEF_END_DATE, endDate)
					);
		}
		
		return text;
	}
	
	private static String formatPoliticalBelief(PoliticalBelief politicalBelief){
		String text = "";
		PoliticalParty politicalParty = politicalBelief.getPoliticalParty();
		Date startDate = politicalBelief.getStartDate();
		Date endDate = politicalBelief.getEndDate();
		text += politicalParty.getName();
		if(startDate != Defaults.UNKNOWN_POLITICAL_BELIEF_START_DATE || 
				endDate != Defaults.UNKNOWN_POLITICAL_BELIEF_END_DATE){
			text += " " + formatDate(Defaults.UNKNOWN_POLITICAL_BELIEF_START_DATE, startDate) + 
					" - " + 
					(BooleanUtil.isTrue(politicalBelief.isCurrent())?
							"present":
							formatDate(Defaults.UNKNOWN_POLITICAL_BELIEF_END_DATE, endDate)
					);
		}
		
		return text;
	}
	
	private static void writePerson(XWPFDocument document, Person person, boolean isSpouse){
		XWPFParagraph basicInfoParagraph = document.createParagraph();
		basicInfoParagraph.setAlignment(ParagraphAlignment.LEFT);
		basicInfoParagraph.setSpacingAfter(0);
		basicInfoParagraph.setSpacingBefore(0);
		basicInfoParagraph.setSpacingBetween(1.0);
		if(isSpouse){
			basicInfoParagraph.setIndentationFirstLine(720); // half-inch indent
		}
		
		XWPFRun basicInfo = basicInfoParagraph.createRun();
		basicInfo.setBold(true);
		basicInfo.setFontFamily("Arial");
		basicInfo.setFontSize(12);
		
		basicInfo.setText(
							person.getID() + ". " + 
							person.getFirstName() + " " + 
							person.getMiddleName() + " " + 
							person.getLastName() + 
							(person.getOID() != null?
									" (O#" + person.getOID() + ")":
									""
							)
							);
		
		XWPFParagraph birthDeathParagraph = document.createParagraph();
		birthDeathParagraph.setAlignment(ParagraphAlignment.LEFT);
		birthDeathParagraph.setSpacingAfter(0);
		birthDeathParagraph.setSpacingBefore(0);
		birthDeathParagraph.setSpacingBetween(1.0);
		birthDeathParagraph.setIndentationFirstLine(720); // half-inch indent
		
		XWPFRun birthDeath = birthDeathParagraph.createRun();
		birthDeath.setBold(true);
		birthDeath.setFontFamily("Arial");
		birthDeath.setFontSize(12);
		
		birthDeath.setText(
							formatDate(Defaults.UNKNOWN_BIRTH_DATE, person.getBirthDate()) + 
							formatLocation(Defaults.UNKNOWN_BIRTH_LOCATION, person.getBirthLocation()) + 
							" - " + 
							(BooleanUtil.isTrue(person.isAlive())?
									"present":
									formatDate(Defaults.UNKNOWN_DEATH_DATE, person.getDeathDate()) + 
									formatLocation(Defaults.UNKNOWN_DEATH_LOCATION, person.getDeathLocation()))
						);
		
		List<Job> jobs = person.getJobs();
		if(jobs.size() != 1 || jobs.get(0) != Defaults.UNKNOWN_JOB){
			XWPFParagraph jobsParagraph = document.createParagraph();
			jobsParagraph.setAlignment(ParagraphAlignment.LEFT);
			jobsParagraph.setSpacingAfter(0);
			jobsParagraph.setSpacingBefore(0);
			jobsParagraph.setSpacingBetween(1.0);
			jobsParagraph.setIndentationFirstLine(720); // half-inch indent
			
			XWPFRun jobsText = jobsParagraph.createRun();
			jobsText.setBold(true);
			jobsText.setFontFamily("Arial");
			jobsText.setFontSize(12);
			jobsText.setText("Occupations:");
			
			for(Job job: jobs){
				XWPFParagraph jobParagraph = document.createParagraph();
				jobParagraph.setAlignment(ParagraphAlignment.LEFT);
				jobParagraph.setSpacingAfter(0);
				jobParagraph.setSpacingBefore(0);
				jobParagraph.setSpacingBetween(1.0);
				jobParagraph.setIndentationFirstLine(1440); // 1-inch indent
				
				XWPFRun jobText = jobParagraph.createRun();
				jobText.setBold(true);
				jobText.setFontFamily("Arial");
				jobText.setFontSize(12);
				
				jobText.setText(
									job.getTitle() + 
									formatLocation(Defaults.UNKNOWN_JOB_LOCATION, job.getLocation()) + " " + 
									formatDate(Defaults.UNKNOWN_JOB_START_DATE, job.getStartDate()) + 
									" - " + 
									(BooleanUtil.isTrue(job.isCurrent())?
											"present":
											formatDate(Defaults.UNKNOWN_JOB_END_DATE, job.getEndDate())
									)
							);
			}
		}
		
		List<ReligiousBelief> religiousBeliefs = person.getReligiousBeliefs();
		if(religiousBeliefs.size() != 1 || religiousBeliefs.get(0) != Defaults.UNKNOWN_RELIGIOUS_BELIEF){
			XWPFParagraph religiousBeliefsParagraph = document.createParagraph();
			religiousBeliefsParagraph.setAlignment(ParagraphAlignment.LEFT);
			religiousBeliefsParagraph.setSpacingAfter(0);
			religiousBeliefsParagraph.setSpacingBefore(0);
			religiousBeliefsParagraph.setSpacingBetween(1.0);
			religiousBeliefsParagraph.setIndentationFirstLine(720); // half-inch indent
			
			XWPFRun religiousBeliefsText = religiousBeliefsParagraph.createRun();
			religiousBeliefsText.setBold(true);
			religiousBeliefsText.setFontFamily("Arial");
			religiousBeliefsText.setFontSize(12);
			religiousBeliefsText.setText("Religious Beliefs:");
			
			for(ReligiousBelief religiousBelief: religiousBeliefs){
				XWPFParagraph religiousBeliefParagraph = document.createParagraph();
				religiousBeliefParagraph.setAlignment(ParagraphAlignment.LEFT);
				religiousBeliefParagraph.setSpacingAfter(0);
				religiousBeliefParagraph.setSpacingBefore(0);
				religiousBeliefParagraph.setSpacingBetween(1.0);
				religiousBeliefParagraph.setIndentationFirstLine(1440); // 1-inch indent
				
				XWPFRun religiousBeliefText = religiousBeliefParagraph.createRun();
				religiousBeliefText.setBold(true);
				religiousBeliefText.setFontFamily("Arial");
				religiousBeliefText.setFontSize(12);
				
				religiousBeliefText.setText(formatReligiousBelief(religiousBelief));
				
				List<Event> events = religiousBelief.getEvents();
				if(!events.isEmpty()){
					for(Event event: events){
						XWPFParagraph eventParagraph = document.createParagraph();
						eventParagraph.setAlignment(ParagraphAlignment.LEFT);
						eventParagraph.setSpacingAfter(0);
						eventParagraph.setSpacingBefore(0);
						eventParagraph.setSpacingBetween(1.0);
						eventParagraph.setIndentationFirstLine(1440); // 1-inch indent
						
						XWPFRun eventText = eventParagraph.createRun();
						eventText.setBold(true);
						eventText.setFontFamily("Arial");
						eventText.setFontSize(12);
						
						eventText.setText(
											"- " + event.getName() + " " +
											formatDate(Defaults.UNKNOWN_EVENT_DATE, event.getDate()) + 
											formatLocation(Defaults.UNKNOWN_EVENT_LOCATION, event.getLocation())
										);
					}
				}
			}
		}
		
		List<PoliticalBelief> politicalBeliefs = person.getPoliticalBeliefs();
		if(politicalBeliefs.size() != 1 || politicalBeliefs.get(0) != Defaults.UNKNOWN_POLITICAL_BELIEF){
			XWPFParagraph politicalBeliefsParagraph = document.createParagraph();
			politicalBeliefsParagraph.setAlignment(ParagraphAlignment.LEFT);
			politicalBeliefsParagraph.setSpacingAfter(0);
			politicalBeliefsParagraph.setSpacingBefore(0);
			politicalBeliefsParagraph.setSpacingBetween(1.0);
			politicalBeliefsParagraph.setIndentationFirstLine(720); // half-inch indent
			
			XWPFRun politicalBeliefsText = politicalBeliefsParagraph.createRun();
			politicalBeliefsText.setBold(true);
			politicalBeliefsText.setFontFamily("Arial");
			politicalBeliefsText.setFontSize(12);
			politicalBeliefsText.setText("Political Beliefs:");
			
			for(PoliticalBelief politicalBelief: politicalBeliefs){
				XWPFParagraph politicalBeliefParagraph = document.createParagraph();
				politicalBeliefParagraph.setAlignment(ParagraphAlignment.LEFT);
				politicalBeliefParagraph.setSpacingAfter(0);
				politicalBeliefParagraph.setSpacingBefore(0);
				politicalBeliefParagraph.setSpacingBetween(1.0);
				politicalBeliefParagraph.setIndentationFirstLine(1440); // 1-inch indent
				
				XWPFRun politicalBeliefText = politicalBeliefParagraph.createRun();
				politicalBeliefText.setBold(true);
				politicalBeliefText.setFontFamily("Arial");
				politicalBeliefText.setFontSize(12);
				
				politicalBeliefText.setText(formatPoliticalBelief(politicalBelief));
			}
		}
		
		if(!isSpouse){
			List<Marriage> marriages = person.getMarriages();
			if(!marriages.isEmpty()){
				for(Marriage marriage: marriages){
					Person spouse;
					if(marriage.getSpouse1() == person){
						spouse = marriage.getSpouse2();
					}else{
						spouse = marriage.getSpouse1();
					}
					
					XWPFParagraph extraSpace = document.createParagraph();
					extraSpace.setAlignment(ParagraphAlignment.LEFT);
					extraSpace.setSpacingAfter(0);
					extraSpace.setSpacingBefore(0);
					extraSpace.setSpacingBetween(1.0);
					extraSpace.setIndentationFirstLine(720); // half-inch indent
					
					writePerson(document, spouse, true);
					Date date = marriage.getDate();
					Location location = marriage.getLocation();
					
					XWPFParagraph marriageParagraph = document.createParagraph();
					marriageParagraph.setAlignment(ParagraphAlignment.LEFT);
					marriageParagraph.setSpacingAfter(0);
					marriageParagraph.setSpacingBefore(0);
					marriageParagraph.setSpacingBetween(1.0);
					marriageParagraph.setIndentationFirstLine(720); // half-inch indent
					
					XWPFRun marriageText = marriageParagraph.createRun();
					marriageText.setBold(true);
					marriageText.setFontFamily("Arial");
					marriageText.setFontSize(12);
					
					marriageText.setText(
											"Married: " + 
											formatDate(Defaults.UNKNOWN_MARRIAGE_DATE, date) + 
											formatLocation(Defaults.UNKNOWN_MARRIAGE_LOCATION, location)
							);
				}
			}
		
			List<String> details = person.getDetails();
			if(!details.isEmpty()){
				for(String detail: details){
					XWPFParagraph detailParagraph = document.createParagraph();
					detailParagraph.setAlignment(ParagraphAlignment.LEFT);
					detailParagraph.setSpacingAfter(0);
					detailParagraph.setSpacingBefore(0);
					detailParagraph.setSpacingBetween(1.0);
					detailParagraph.setIndentationFirstLine(720); // half-inch indent
					
					XWPFRun detailText = detailParagraph.createRun();
					detailText.setBold(false);
					detailText.setFontFamily("Arial");
					detailText.setFontSize(12);
					
					detailText.setText(detail);
				}
			}
			
			List<ChildRelationship> children = person.getChildren();
			if(!children.isEmpty()){
				XWPFParagraph childrenParagraph = document.createParagraph();
				childrenParagraph.setAlignment(ParagraphAlignment.LEFT);
				childrenParagraph.setSpacingAfter(0);
				childrenParagraph.setSpacingBefore(0);
				childrenParagraph.setSpacingBetween(1.0);
				childrenParagraph.setIndentationFirstLine(720); // half-inch indent
				
				XWPFRun childrenText = childrenParagraph.createRun();
				childrenText.setBold(false);
				childrenText.setFontFamily("Arial");
				childrenText.setFontSize(12);
				
				childrenText.setText("Children:");
				
				for(ChildRelationship childRel: children){
					Person child = childRel.getChild();
					
					XWPFParagraph childParagraph = document.createParagraph();
					childParagraph.setAlignment(ParagraphAlignment.LEFT);
					childParagraph.setSpacingAfter(0);
					childParagraph.setSpacingBefore(0);
					childParagraph.setSpacingBetween(1.0);
					childParagraph.setIndentationFirstLine(720); // half-inch indent
					
					XWPFRun childText = childParagraph.createRun();
					childText.setBold(false);
					childText.setFontFamily("Arial");
					childText.setFontSize(11);
					
					childText.setText(
										"- " + child.getID() + ". " + child.getFirstName() + " " + child.getMiddleName() + 
										" " + formatDate(Defaults.UNKNOWN_BIRTH_DATE, child.getBirthDate()) + 
										" - " + (BooleanUtil.isTrue(child.isAlive())?
													"present":
													formatDate(Defaults.UNKNOWN_DEATH_DATE, child.getDeathDate())
												)
							);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Throwable{
		setup();
		
		XWPFDocument document = new XWPFDocument();
		
		// Set 1-inch margins (Defaults to this, but just in case)
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		CTPageMar pageMar = sectPr.addNewPgMar();
		pageMar.setTop(BigInteger.valueOf(1440));
		pageMar.setBottom(BigInteger.valueOf(1440));
		pageMar.setLeft(BigInteger.valueOf(1440));
		pageMar.setRight(BigInteger.valueOf(1440));
		
		writePerson(document, person, false);
		
		File file = new File("derp.docx");
		FileOutputStream out = new FileOutputStream(file);
		document.write(out);
		out.close();
		document.close();
		
		System.out.println("Document Done");
		
		// Setup the dumb logger
		File file2 = new File("log.txt");
		FileHandler fh = new FileHandler("log.txt");
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		file2.createNewFile();
		Logger logger = Logger.getLogger("log.txt");
		logger.setLevel(Level.FINEST);
		logger.addHandler(fh);
		
		PersonFileFormat personFormat = new PersonFileFormat(logger);
		personFormat.saveFile(logger, person);
		
		System.out.println("Person File Done");
	}
}
