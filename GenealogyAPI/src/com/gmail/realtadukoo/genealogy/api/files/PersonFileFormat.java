package com.gmail.realtadukoo.genealogy.api.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.gmail.realtadukoo.util.fileformat.FileFormat;
import com.gmail.realtadukoo.util.fileformat.FileFormatSchema;
import com.gmail.realtadukoo.util.fileformat.FormatNode;
import com.gmail.realtadukoo.util.fileformat.Node;

public class PersonFileFormat extends FileFormat{
	
	public PersonFileFormat(Logger logger){
		super(logger, "Person");
	}
	
	@Override
	protected Map<String, FileFormatSchema> createSchemas(Logger logger){
		// Create Map to store the schemas
		Map<String, FileFormatSchema> schemas = new HashMap<>();
		
		String IDs = "IDs";
		String DBID = "DBID";
		String LDBID = "LDBID";
		String ID = "ID";
		String OID = "OID";
		String name = "Name";
		String firstName = "First";
		String middleName = "Middle";
		String lastName = "Last";
		String alive = "Alive";
		
		/*
		 * Create the PersonFileFormat Schema Version 1.0
		 */
		String version1 = "Version 1.0";
		List<FormatNode> v1Nodes = new ArrayList<>();
		
		v1Nodes.add(FormatNode.builder()
								.name(FormatNode.HEAD_NODE)
								.titleRegex("Person")
								.dataRegex("")
								.level(0)
								.childName(IDs)
								.build());
		v1Nodes.add(FormatNode.builder()
								.name(IDs)
								.titleRegex(IDs)
								.dataRegex("")
								.level(1)
								.parentName(FormatNode.HEAD_NODE)
								.childName(DBID)
								.childName(LDBID)
								.childName(ID)
								.nextSiblingName(name)
								.build());
		{
			v1Nodes.add(FormatNode.builder()
									.name(DBID)
									.titleRegex(DBID)
									.dataFormat("[<#>]")
									.level(2)
									.parentName(IDs)
									.nextSiblingName(LDBID)
									.nextSiblingName(ID)
									.build());
			v1Nodes.add(FormatNode.builder()
									.name(LDBID)
									.titleRegex(LDBID)
									.dataFormat("[<#>]")
									.level(2)
									.parentName(IDs)
									.nullParentName()
									.prevSiblingName(DBID)
									.nullPrevSiblingName()
									.nextSiblingName(ID)
									.build());
			v1Nodes.add(FormatNode.builder()
									.name(ID)
									.titleRegex(ID)
									.dataFormat("<text>")
									.level(2)
									.parentName(IDs)
									.nullParentName()
									.prevSiblingName(DBID)
									.prevSiblingName(LDBID)
									.nullPrevSiblingName()
									.nextSiblingName(OID)
									.nullNextSiblingName()
									.build());
			v1Nodes.add(FormatNode.builder()
									.name(OID)
									.titleRegex(OID)
									.dataFormat("[<text>]")
									.level(2)
									.prevSiblingName(ID)
									.build());
		}
		v1Nodes.add(FormatNode.builder()
								.name(name)
								.titleRegex(name)
								.dataRegex("")
								.level(1)
								.childName(firstName)
								.prevSiblingName(IDs)
								.nextSiblingName(alive)
								.build());
		{
			v1Nodes.add(FormatNode.builder()
									.name(firstName)
									.titleRegex(firstName)
									.dataRegex("[<text>]")
									.level(2)
									.parentName(name)
									.nextSiblingName(middleName)
									.nextSiblingName(lastName)
									.build());
			v1Nodes.add(FormatNode.builder()
									.name(middleName)
									.titleRegex(middleName)
									.dataRegex("[<text>]")
									.level(2)
									.prevSiblingName(firstName)
									.nextSiblingName(lastName)
									.build());
			v1Nodes.add(FormatNode.builder()
									.name(lastName)
									.titleRegex(lastName)
									.dataRegex("[<text>]")
									.level(2)
									.prevSiblingName(firstName)
									.prevSiblingName(middleName)
									.build());
		}
		v1Nodes.add(FormatNode.builder()
								.name(alive)
								.titleRegex(alive)
								.dataRegex("[<boolean>]")
								.level(1)
								.prevSiblingName(name)
								.build());
		
		// Add the Schema for Version 1.0 to the Map
		schemas.put(version1, new FileFormatSchema(version1, 1, ".", v1Nodes));
		
		// Return the created schema
		return schemas;
	}
	
	@Override
	public Node updateFile(Node oldFile, String oldVersion, String newVersion){
		// Currently no old versions to convert from
		return oldFile;
	}
}
