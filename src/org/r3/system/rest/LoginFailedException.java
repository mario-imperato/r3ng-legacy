package org.r3.system.rest;

import org.r3.system.ServicePatternException;

public class LoginFailedException extends ServicePatternException
{

	public LoginFailedException()
	{
		super();
	}

	public LoginFailedException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LoginFailedException(String message)
	{
		super(message);
	}

	public LoginFailedException(Throwable cause)
	{
		super(cause);
	}

}
