package com.tapestry.app.pages.trans;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

public class Translators1 {

	@Property
	private Integer integerField;
	@Property
	private Long longField;
	@Property
	private Double doubleField;
	@Property
	private String stringField;
	
	@InjectPage
	private Translators2 page2;
	
	Object onSuccess(){
		page2.set(integerField, longField, doubleField, stringField);
		return page2;
	}
}
