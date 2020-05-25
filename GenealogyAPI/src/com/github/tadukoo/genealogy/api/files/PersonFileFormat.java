package com.github.tadukoo.genealogy.api.files;

import java.util.*;
import java.util.logging.Logger;

import com.github.tadukoo.genealogy.api.Defaults;
import com.github.tadukoo.genealogy.api.pojos.Person;
import com.github.tadukoo.util.fileformat.FileFormat;
import com.github.tadukoo.util.fileformat.FileFormatSchema;
import com.github.tadukoo.util.fileformat.FormatNode;
import com.github.tadukoo.util.fileformat.Node;
import com.github.tadukoo.util.fileformat.TadFormatNodeHeader;

public class PersonFileFormat extends FileFormat{
	private static final String PERSON = "Person";
	private static final String IDS = "IDs";
	private static final String DBID = "DBID";
	private static final String LDBID = "LDBID";
	private static final String ID = "ID";
	private static final String OID = "OID";
	private static final String NAME = "Name";
	private static final String FIRST_NAME = "First";
	private static final String MIDDLE_NAME = "Middle";
	private static final String LAST_NAME = "Last";
	private static final String ALIVE = "Alive";
	private static final String CURRENT_VERSION = "Version 1.0";
	private static final String FILE_EXTENSION = "tadgenperson";
	
	public PersonFileFormat(Logger logger){
		super(logger, "Person");
	}
	
	@Override
	protected Map<String, FileFormatSchema> createSchemas(Logger logger){
		// Create Map to store the schemas
		Map<String, FileFormatSchema> schemas = new HashMap<>();
		
		/*
		 * Create the PersonFileFormat Schema Version 1.0
		 */
		String version1 = CURRENT_VERSION;
		List<FormatNode> v1Nodes = new ArrayList<>();
		
		// Create the head Node Format
		v1Nodes.add(FormatNode.builder()
								.logger(logger)
								.name(PERSON)
								.titleRegex("Person")
								.dataRegex("")
								.level(0)
								.childName(IDS)
								.prevSiblingName(TadFormatNodeHeader.HEAD_NAME)
								.build());
		
		// Create the IDs Node Format
		v1Nodes.add(FormatNode.builder()
								.logger(logger)
								.name(IDS)
								.titleRegex(IDS)
								.dataRegex("")
								.level(1)
								.parentName(PERSON)
								.childName(DBID)
								.childName(LDBID)
								.childName(ID)
								.nextSiblingName(NAME)
								.build());
		{
			// Create the DBID Node Format (Optional)
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(DBID)
									.titleRegex(DBID)
									.dataFormat("[<#>]")
									.level(2)
									.parentName(IDS)
									.nextSiblingName(LDBID)
									.nextSiblingName(ID)
									.build());
			
			// Create the LDBID Node Format (Optional)
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(LDBID)
									.titleRegex(LDBID)
									.dataFormat("[<#>]")
									.level(2)
									.parentName(IDS)
									.nullParentName()
									.prevSiblingName(DBID)
									.nullPrevSiblingName()
									.nextSiblingName(ID)
									.build());
			
			// Create the ID Node Format
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(ID)
									.titleRegex(ID)
									.dataFormat("<text>")
									.level(2)
									.parentName(IDS)
									.nullParentName()
									.prevSiblingName(DBID)
									.prevSiblingName(LDBID)
									.nullPrevSiblingName()
									.nextSiblingName(OID)
									.nullNextSiblingName()
									.build());
			
			// Create the OID Node Format (Optional)
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(OID)
									.titleRegex(OID)
									.dataFormat("[<text>]")
									.level(2)
									.prevSiblingName(ID)
									.build());
		}
		
		// Create the Name Node Format
		v1Nodes.add(FormatNode.builder()
								.logger(logger)
								.name(NAME)
								.titleRegex(NAME)
								.dataRegex("")
								.level(1)
								.childName(FIRST_NAME)
								.prevSiblingName(IDS)
								.nextSiblingName(ALIVE)
								.build());
		{
			// Create the First Name Node Format
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(FIRST_NAME)
									.titleRegex(FIRST_NAME)
									.dataFormat("[<text>]")
									.level(2)
									.parentName(NAME)
									.nextSiblingName(MIDDLE_NAME)
									.nextSiblingName(LAST_NAME)
									.build());
			
			// Create the Middle Name Node Format (Optional)
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(MIDDLE_NAME)
									.titleRegex(MIDDLE_NAME)
									.dataFormat("[<text>]")
									.level(2)
									.prevSiblingName(FIRST_NAME)
									.nextSiblingName(LAST_NAME)
									.build());
			
			// Create the Last Name Node Format
			v1Nodes.add(FormatNode.builder()
									.logger(logger)
									.name(LAST_NAME)
									.titleRegex(LAST_NAME)
									.dataFormat("[<text>]")
									.level(2)
									.prevSiblingName(FIRST_NAME)
									.prevSiblingName(MIDDLE_NAME)
									.build());
		}
		
		// Create the Alive Node Format
		v1Nodes.add(FormatNode.builder()
								.logger(logger)
								.name(ALIVE)
								.titleRegex(ALIVE)
								.dataFormat("[<Boolean>]")
								.level(1)
								.prevSiblingName(NAME)
								.build());
		
		// Add the Schema for Version 1.0 to the Map
		schemas.put(version1, new FileFormatSchema(version1, 1, FILE_EXTENSION, v1Nodes));
		
		// Return the created schema
		return schemas;
	}
	
	@Override
	public Node updateFile(Node oldFile, String oldVersion, String newVersion){
		// Currently no old versions to convert from
		return oldFile;
	}
	
	/**
	 * Saves a file for the given {@link Person}.
	 * 
	 * @param logger The Logger to use in logging any messages
	 * @param person The Person to be saved
	 */
	public void saveFile(Logger logger, Person person){
		// Create the person Node
		Node personNode = new Node(PERSON, "", 0, null, null, null, null);
		
		// Create the IDs Node
		Node idsNode = new Node(IDS, "", 1, personNode, null, null, null);
		personNode.setChild(idsNode);
		
		// Create the DBID Node (if not unknown)
		int DBIDVal = person.getDBID();
		Node DBIDNode = null;
		if(DBIDVal != Defaults.UNKNOWN_PERSON_DBID){
			DBIDNode = new Node(DBID, String.valueOf(DBIDVal), 2, idsNode, null, null, null);
		}
		
		// Create the LDBID Node (if not unknown)
		int LDBIDVal = person.getLDBID();
		Node LDBIDNode = null;
		if(LDBIDVal != Defaults.UNKNOWN_PERSON_LDBID){
			LDBIDNode = new Node(LDBID, String.valueOf(LDBIDVal), 2, null, null, DBIDNode, null);
			if(DBIDNode != null){
				DBIDNode.setNextSibling(LDBIDNode);
			}
		}
		
		// Create the ID Node
		Node IDNode = new Node(ID, person.getID(), 2, null, null, LDBIDNode != null?LDBIDNode:DBIDNode, null);
		idsNode.setChild(DBIDNode != null?DBIDNode:
							LDBIDNode != null?LDBIDNode:
								IDNode);
		if(LDBIDNode != null){
			LDBIDNode.setNextSibling(IDNode);
		}else if(DBIDNode != null){
			DBIDNode.setNextSibling(IDNode);
		}
		
		// Create the OID Node (if not unknown)
		String OIDVal = person.getOID();
		if(!OIDVal.equals(Defaults.UNKNOWN_PERSON_OID)){
			Node OIDNode = new Node(OID, OIDVal, 2, null, null, IDNode, null);
			IDNode.setNextSibling(OIDNode);
		}
		
		// Create the Name Node
		Node nameNode = new Node(NAME, "", 1, null, null, idsNode, null);
		idsNode.setNextSibling(nameNode);
		
		// Create the First Name Node
		String firstName = person.getFirstName();
		Node firstNameNode = new Node(FIRST_NAME, firstName, 2, nameNode, null, null, null);
		nameNode.setChild(firstNameNode);
		
		// Create the Middle Name Node (if not unknown)
		String middleName = person.getMiddleName();
		Node middleNameNode = null;
		if(!middleName.equals(Defaults.UNKNOWN_MIDDLE_NAME)){
			middleNameNode = new Node(MIDDLE_NAME, middleName, 2, null, null, firstNameNode, null);
			firstNameNode.setNextSibling(middleNameNode);
		}
		
		// Create the Last Name Node
		String lastName = person.getLastName();
		Node lastNameNode = new Node(LAST_NAME, lastName, 2, null, null, 
				middleNameNode != null?middleNameNode:firstNameNode, null);
		Objects.requireNonNullElse(middleNameNode, firstNameNode).setNextSibling(lastNameNode);
		
		// Create the Alive Node
		Node aliveNode = new Node(ALIVE, String.valueOf(person.isAlive()), 1, null, null, nameNode, null);
		nameNode.setNextSibling(aliveNode);
		
		/**/
		System.out.println("Person File: \n" + personNode.fullToString());
		System.out.println("Person Node Title: " + personNode.getTitle());
		System.out.println("Person Node Data: " + personNode.getData());
		/**/
		
		// Build the filepath string
		String filepath = "person/" + person.getID() + "." + 
							(firstName.equals(Defaults.UNKNOWN_FIRST_NAME)?"":" " + firstName) + 
							(middleName.equals(Defaults.UNKNOWN_MIDDLE_NAME)?"":" " + middleName) + 
							(lastName.equals(Defaults.UNKNOWN_LAST_NAME)?"":" " + lastName) + 
							"." + FILE_EXTENSION;
		
		// Actually save the file using File Format's method
		saveFile(logger, filepath, personNode, getSchema(CURRENT_VERSION));
	}
}
