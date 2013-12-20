package com.tapestry.app.pages.trans;

import org.apache.tapestry5.annotations.Property;

public class Translators2 {

	@Property(write=false)
	private Integer integerField;
	
	@Property(write=false)
	private Long longField;
	
	@Property(write=false)
	private Double doubleField;
	
	@Property(write=false)
	private String stringField;
	
	public void set(Integer integerField, Long longField, Double doubleField, String stringField) {
		this.integerField = integerField;
		this.longField = longField;
		this.doubleField = doubleField;
		this.stringField = stringField;
	}
	
	Object[] onPassivate() {
		return new Object[] {
				integerField,
				longField,
				doubleField,
				stringField
		};
	}
	
	void onActivate(Integer integerField, Long longField, Double doubleField, String stringField) {
		this.integerField = integerField;
		this.longField = longField;
		this.doubleField = doubleField;
		this.stringField = stringField;
	}
}
