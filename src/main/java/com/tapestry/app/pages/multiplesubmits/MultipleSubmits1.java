package com.tapestry.app.pages.multiplesubmits;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

import com.tapestry.app.pages.multiplesubmits.MultipleSubmits2.SearchType;

public class MultipleSubmits1 {

	@Property
	private String name;
	
	@InjectPage
	private MultipleSubmits2 page2;
	
	private SearchType searchType;
	
	void onActivate() {
		searchType = SearchType.CUSTOMERS;
	}
	
	void onSelectedFromSuppliers() {
		searchType = SearchType.SUPPLIERS;
	}
	
	Object onSuccess() {
		page2.set(searchType, name);
		return page2;
	}
}
