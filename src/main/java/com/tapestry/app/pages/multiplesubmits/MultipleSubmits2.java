package com.tapestry.app.pages.multiplesubmits;

public class MultipleSubmits2 {

	private SearchType searchType;
	private String name;
	
	public enum SearchType {
		CUSTOMERS, SUPPLIERS;
	}
	
	public void set(SearchType searchType, String lastName) {
		this.searchType = searchType;
		this.name = lastName;
	}
	
	Object[] onPassivate() {
		return new Object[]{searchType, name};
	}
	
	void onActivate(SearchType searchType, String name) {
		this.searchType = searchType;
		this.name = name;
	}
	
	public String getYourSearch() {
		if(searchType == SearchType.CUSTOMERS) {
			return "你选择 Customers 名字\"" + name + "\".";
		}
		else {
			return "你选择Suppliers名字\"" + name + "\".";
		}
	}
}
