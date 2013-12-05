package com.tapestry.app.pages.session;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class MyPersist {

	//直接把hello存储到session
	@Persist
	@Property
	private String hello;
}
