package com.tapestry.app.pages.session;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

public class Welcom {

	@Property
	@SessionState
	private String userName;
	
	Object onLogout(){
		userName = null;
		return Signin.class;
	}
}
