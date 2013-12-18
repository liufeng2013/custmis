package com.tapestry.app.services;

import javax.security.sasl.AuthenticationException;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;

import com.tapestry.app.entities.User;



public class BasicAuthenticator implements Authenticator{

	public static final String AUTH_TOKEN = "authToken";
	
	@Inject
	private MisDAO dao;
	
	@Inject
	private Request request;
	
	public void login(String username, String password) throws AuthenticationException{
		
		User user = (User)dao.findWithQuery(username);

        if (user == null) { throw new AuthenticationException("The user doesn't exist"); }

        request.getSession(true).setAttribute(AUTH_TOKEN, user);
	}
	
	public boolean isLoggedIn()
    {
        Session session = request.getSession(false);
        if (session != null) { return session.getAttribute(AUTH_TOKEN) != null; }
        return false;
    }

    public void logout()
    {
        Session session = request.getSession(false);
        if (session != null)
        {
            session.setAttribute(AUTH_TOKEN, null);
            session.invalidate();
        }
    }

    public User getLoggedUser()
    {
        User user = null;

        if (isLoggedIn())
        {
            user = (User) request.getSession(true).getAttribute(AUTH_TOKEN);
        }
        else
        {
            throw new IllegalStateException("用户名已经登录 ! ");
        }
        return user;
    }
}
