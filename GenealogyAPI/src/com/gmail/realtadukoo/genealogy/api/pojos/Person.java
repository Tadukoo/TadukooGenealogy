package com.gmail.realtadukoo.genealogy.api.pojos;

import java.util.ArrayList;
import java.util.List;

import com.gmail.realtadukoo.genealogy.api.Defaults;

/**
 * Represents a person. Contains all the genealogical information 
 * about him/her.
 * 
 * @author Logan Ferree (Tadukoo)
 * @version 0.1-Alpha-SNAPSHOT
 */
public class Person{
	/** The database id for the official database */
	private int DBID;
	/** The database id for the local database */
	private int LDBID;
	/** Also called N#, his/her official ID # */
	private String ID;
	/** Also called O#, his/her ID # from an outside source */
	private String OID;
	/** His/her sex: male or female (intersex + others could be used too since it's a string) */
	private String sex;
	/** His/her first/given name */
	private String firstName;
	/** His/her middle name(s) */
	private String middleName;
	/** His/her last (maiden) name */
	private String lastName;
	/** Whether he/she is alive or not (or null if unknown) */
	private Boolean alive;
	/** The {@link Date} he/she was born */
	private Date birthDate;
	/** The {@link Location} he/she was born */
	private Location birthLocation;
	/** The {@link Date} he/she died */
	private Date deathDate;
	/** The {@link Location} he/she died */
	private Location deathLocation;
	/** The {@link Job}s he/she worked (and any current jobs) */
	private List<Job> jobs;
	/** The {@link ReligiousBelief}s he/she held (and any currently held) */
	private List<ReligiousBelief> religiousBeliefs;
	/** The {@link PoliticalBelief}s he/she held (and any currently held) */
	private List<PoliticalBelief> politicalBeliefs;
	/** Any current or past {@link Marriage}s */
	private List<Marriage> marriages;
	/** Any details about his/her life to be in paragraph form outside of other info */
	private List<String> details;
	/** Any {@link ChildRelationship children} he/she had */
	private List<ChildRelationship> children;
	
	public static class PersonBuilder{
		private int DBID = -1;
		private int LDBID = -1;
		private String ID = null;
		private String OID = null;
		private String sex = Defaults.UNKNOWN_SEX;
		private String firstName = Defaults.UNKNOWN_FIRST_NAME;
		private String middleName = Defaults.UNKNOWN_MIDDLE_NAME;
		private String lastName = Defaults.UNKNOWN_LAST_NAME;
		private Boolean alive = null;
		private Date birthDate = Defaults.UNKNOWN_BIRTH_DATE;
		private Location birthLocation = Defaults.UNKNOWN_BIRTH_LOCATION;
		private Date deathDate = Defaults.UNKNOWN_DEATH_DATE;
		private Location deathLocation = Defaults.UNKNOWN_DEATH_LOCATION;
		private List<Job> jobs = new ArrayList<>();
		private List<ReligiousBelief> religiousBeliefs = new ArrayList<>();
		private List<PoliticalBelief> politicalBeliefs = new ArrayList<>();
		private List<Marriage> marriages = new ArrayList<>();
		private List<String> details = new ArrayList<>();
		private List<ChildRelationship> children = new ArrayList<>();
		
		private PersonBuilder(){ }
		
		public PersonBuilder DBID(int DBID){
			this.DBID = DBID;
			return this;
		}
		
		public PersonBuilder LDBID(int LDBID){
			this.LDBID = LDBID;
			return this;
		}
		
		public PersonBuilder ID(String ID){
			this.ID = ID;
			return this;
		}
		
		public PersonBuilder OID(String OID){
			this.OID = OID;
			return this;
		}
		
		public PersonBuilder male(){
			sex = Defaults.MALE;
			return this;
		}
		
		public PersonBuilder female(){
			sex = Defaults.FEMALE;
			return this;
		}
		
		public PersonBuilder firstName(String firstName){
			this.firstName = firstName;
			return this;
		}
		
		public PersonBuilder middleName(String middleName){
			this.middleName = middleName;
			return this;
		}
		
		public PersonBuilder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}
		
		public PersonBuilder alive(Boolean alive){
			this.alive = alive;
			return this;
		}
		
		public PersonBuilder birthDate(Date birthDate){
			this.birthDate = birthDate;
			return this;
		}
		
		public PersonBuilder birthLocation(Location birthLocation){
			this.birthLocation = birthLocation;
			return this;
		}
		
		public PersonBuilder deathDate(Date deathDate){
			this.deathDate = deathDate;
			return this;
		}
		
		public PersonBuilder deathLocation(Location deathLocation){
			this.deathLocation = deathLocation;
			return this;
		}
		
		public PersonBuilder jobs(List<Job> jobs){
			this.jobs = jobs;
			return this;
		}
		
		public PersonBuilder job(Job job){
			jobs.add(job);
			return this;
		}
		
		public PersonBuilder religiousBeliefs(List<ReligiousBelief> religiousBeliefs){
			this.religiousBeliefs = religiousBeliefs;
			return this;
		}
		
		public PersonBuilder religiousBelief(ReligiousBelief religiousBelief){
			religiousBeliefs.add(religiousBelief);
			return this;
		}
		
		public PersonBuilder politicalBeliefs(List<PoliticalBelief> politicalBeliefs){
			this.politicalBeliefs = politicalBeliefs;
			return this;
		}
		
		public PersonBuilder politicalBelief(PoliticalBelief politicalBelief){
			politicalBeliefs.add(politicalBelief);
			return this;
		}
		
		public PersonBuilder marriages(List<Marriage> marriages){
			this.marriages = marriages;
			return this;
		}
		
		public PersonBuilder marriage(Marriage marriage){
			marriages.add(marriage);
			return this;
		}
		
		public PersonBuilder details(List<String> details){
			this.details = details;
			return this;
		}
		
		public PersonBuilder detail(String detail){
			details.add(detail);
			return this;
		}
		
		public PersonBuilder children(List<ChildRelationship> children){
			this.children = children;
			return this;
		}
		
		public PersonBuilder child(ChildRelationship child){
			children.add(child);
			return this;
		}
		
		// TODO: Make ID not optional
		
		public Person build(){
			if(jobs.isEmpty()){
				jobs.add(Defaults.UNKNOWN_JOB);
			}
			if(religiousBeliefs.isEmpty()){
				religiousBeliefs.add(Defaults.UNKNOWN_RELIGIOUS_BELIEF);
			}
			if(politicalBeliefs.isEmpty()){
				politicalBeliefs.add(Defaults.UNKNOWN_POLITICAL_BELIEF);
			}
			return new Person(DBID, LDBID, ID, OID, sex, firstName, middleName, lastName,
					alive, birthDate, birthLocation, deathDate, deathLocation,
					jobs, religiousBeliefs, politicalBeliefs, 
					marriages, details, children);
		}
	}
	
	private Person(int DBID, int LDBID, String ID, String OID, 
			String sex, String firstName, String middleName, String lastName,
			Boolean alive, Date birthDate, Location birthLocation, Date deathDate, Location deathLocation,
			List<Job> jobs, List<ReligiousBelief> religiousBeliefs, List<PoliticalBelief> politicalBeliefs,
			List<Marriage> marriages, List<String> details, List<ChildRelationship> children){
		this.DBID = DBID;
		this.LDBID = LDBID;
		this.ID = ID;
		this.OID = OID;
		this.sex = sex;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.alive = alive;
		this.birthDate = birthDate;
		this.birthLocation = birthLocation;
		this.deathDate = deathDate;
		this.deathLocation = deathLocation;
		this.jobs = jobs;
		this.religiousBeliefs = religiousBeliefs;
		this.politicalBeliefs = politicalBeliefs;
		this.marriages = marriages;
		this.details = details;
		this.children = children;
	}
	
	public static PersonBuilder builder(){
		return new PersonBuilder();
	}
	
	public int getDBID(){
		return DBID;
	}
	
	public int getLDBID(){
		return LDBID;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public String getOID(){
		return OID;
	}
	
	public void setOID(String OID){
		this.OID = OID;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getMiddleName(){
		return middleName;
	}
	
	public void setMiddleName(String middleName){
		this.middleName = middleName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Boolean isAlive(){
		return alive;
	}
	
	public void setAlive(Boolean alive){
		this.alive = alive;
	}
	
	public Date getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	
	public Location getBirthLocation(){
		return birthLocation;
	}
	
	public void setBirthLocation(Location birthLocation){
		this.birthLocation = birthLocation;
	}
	
	public Date getDeathDate(){
		return deathDate;
	}
	
	public void setDeathDate(Date deathDate){
		this.deathDate = deathDate;
	}
	
	public Location getDeathLocation(){
		return deathLocation;
	}
	
	public void setDeathLocation(Location deathLocation){
		this.deathLocation = deathLocation;
	}
	
	public List<Job> getJobs(){
		return jobs;
	}
	
	public void setJobs(List<Job> jobs){
		this.jobs = jobs;
	}
	
	public boolean addJob(Job job){
		return jobs.add(job);
	}
	
	public boolean removeJob(Job job){
		return jobs.remove(job);
	}
	
	public List<ReligiousBelief> getReligiousBeliefs(){
		return religiousBeliefs;
	}
	
	public void setReligiousBeliefs(List<ReligiousBelief> religiousBeliefs){
		this.religiousBeliefs = religiousBeliefs;
	}
	
	public boolean addReligiousBelief(ReligiousBelief religiousBelief){
		return religiousBeliefs.add(religiousBelief);
	}
	
	public boolean removeReligiousBelief(ReligiousBelief religiousBelief){
		return religiousBeliefs.remove(religiousBelief);
	}
	
	public List<PoliticalBelief> getPoliticalBeliefs(){
		return politicalBeliefs;
	}
	
	public void setPoliticalBeliefs(List<PoliticalBelief> politicalBeliefs){
		this.politicalBeliefs = politicalBeliefs;
	}
	
	public boolean addPoliticalBelief(PoliticalBelief politicalBelief){
		return politicalBeliefs.add(politicalBelief);
	}
	
	public boolean removePoliticalBelief(PoliticalBelief politicalBelief){
		return politicalBeliefs.remove(politicalBelief);
	}
	
	public List<Marriage> getMarriages(){
		return marriages;
	}
	
	public void setMarriages(List<Marriage> marriages){
		this.marriages = marriages;
	}
	
	public boolean addMarriage(Marriage marriage){
		return marriages.add(marriage);
	}
	
	public boolean removeMarriage(Marriage marriage){
		return marriages.remove(marriage);
	}
	
	public List<String> getDetails(){
		return details;
	}
	
	public void setDetails(List<String> details){
		this.details = details;
	}
	
	public boolean addDetail(String detail){
		return details.add(detail);
	}
	
	public boolean removeDetail(String detail){
		return details.remove(detail);
	}
	
	public List<ChildRelationship> getChildren(){
		return children;
	}
	
	public void setChildren(List<ChildRelationship> children){
		this.children = children;
	}
	
	public boolean addChild(ChildRelationship child){
		return children.add(child);
	}
	
	public boolean removeChild(ChildRelationship child){
		return children.remove(child);
	}
}
