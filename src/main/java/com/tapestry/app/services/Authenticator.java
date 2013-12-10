package com.tapestry.app.services;

import javax.security.sasl.AuthenticationException;

import com.tapestry.app.entities.User;



public interface Authenticator  {

	User getLoggedUser();

	boolean isLoggedIn();

	void login(String username, String password) throws AuthenticationException;

	void logout();
}

