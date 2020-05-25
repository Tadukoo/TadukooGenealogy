package com.github.tadukoo.genealogy.api.pojos;

import com.github.tadukoo.genealogy.api.Defaults;

public class ChildRelationship{
	private Person father;
	private Person mother;
	private Person child;
	
	public static class ChildRelationshipBuilder{
		private Person father = Defaults.UNKNOWN_FATHER;
		private Person mother = Defaults.UNKNOWN_MOTHER;
		private Person child = null;
		
		private ChildRelationshipBuilder(){ }
		
		public ChildRelationshipBuilder father(Person father){
			this.father = father;
			return this;
		}
		
		public ChildRelationshipBuilder mother(Person mother){
			this.mother = mother;
			return this;
		}
		
		public ChildRelationshipBuilder child(Person child){
			this.child = child;
			return this;
		}
		
		// TODO: Make child required
		
		public ChildRelationship build(){
			return new ChildRelationship(father, mother, child);
		}
	}
	
	private ChildRelationship(Person father, Person mother, Person child){
		this.father = father;
		this.mother = mother;
		this.child = child;
	}
	
	public static ChildRelationshipBuilder builder(){
		return new ChildRelationshipBuilder();
	}
	
	public Person getFather(){
		return father;
	}
	
	public void setFather(Person father){
		this.father = father;
	}
	
	public Person getMother(){
		return mother;
	}
	
	public void setMother(Person mother){
		this.mother = mother;
	}
	
	public Person getChild(){
		return child;
	}
	
	public void setChild(Person child){
		this.child = child;
	}
}
