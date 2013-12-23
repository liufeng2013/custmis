package com.tapestry.app.pages.inputcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.internal.services.StringValueEncoder;

public class InputCore {

	@Property
	private StringValueEncoder stringEncoder = new StringValueEncoder();
	
	// Checkbox
	@Property
	@Persist
	private boolean checkboxValue;
	
	// Checklist
	@Property
	@Persist
	private List<String> checklistSelectedValues;
	
	@Property
	private final String[] STATIONERY = {"Pens", "Pencils", "Paper"};
	
	// DateField
	@Property
	@Persist
	private Date dateValue;
	
	/**
	 *  We could return a DateFormat, but instead we'll return a String which 
	 *  DataField will coerce into a DateFormat.
	 */
	public String getDateFieldFormat() {
		return "dd/MM/yyyy";
	}
	
	// Palette
	@Property
	@Persist
	private List<String> paletteSelectedValues;
	
	@Property
	private final String[] PETS = {"Dog", "Cat", "Parrot", "Mouse"};
	
	// Password
	@Property
	@Persist
	private String passwordValue;
	
	// RadioGroup and Radio
	@Property
	@Persist
	private String radioSelectedValue;
	
	// Select
	@Property
	@Persist
	private String selectedValue;
	
	// TextArea
	@Property
	@Persist
	private String textAreaValue;
	
	// TextField
	@Property
	@Persist
	private String textValue;
	
	/**
	 * Life-cycle stuff.Fields that are marked @Persist must be initialized
	 * here rather than where they are declared.
	 */
	void setupRender() {
		if(dateValue == null) {
			dateValue = new Date();
		}
		
		if(paletteSelectedValues == null) {
			paletteSelectedValues = new ArrayList<String>();
		}
	}
}
