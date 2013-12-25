package com.tapestry.app.pages.ajax;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class AJAXSelect2 {

	@Persist(PersistenceConstants.FLASH)
	@Property
	@SuppressWarnings("unused")
	private String areaMake;
	@Persist(PersistenceConstants.FLASH)
	@Property
	@SuppressWarnings("unused")
	private String cithModel;
	@Persist(PersistenceConstants.FLASH)
	@Property
	@SuppressWarnings("unused")
	private String keyWords;

	public void set(String areaMake, String cithModel, String keyWords) {
		this.areaMake = areaMake;
		this.cithModel = cithModel;
		this.keyWords = keyWords;
	}
}
