package com.tapestry.app.pages.session;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

public class Signin {

	@Property
	private String userName;
	@Property
	private String password;
	@SessionState
	private String user;
	
	Object onSuccess(){
		if("test".equals(userName) && "123".equals(password)){
			user = userName;
			return Welcom.class;
		}
		
		return null;
	}
}
