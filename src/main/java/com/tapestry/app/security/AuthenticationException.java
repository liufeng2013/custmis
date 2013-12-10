package com.tapestry.app.security;

public class AuthenticationException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 7740628210842909239L;

    public AuthenticationException()
    {
        super();
    }

    public AuthenticationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AuthenticationException(String message)
    {
        super(message);
    }

    public AuthenticationException(Throwable cause)
    {
        super(cause);
    }

}
