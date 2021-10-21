package org.r3.system;


public class UnauthorizedException extends ServicePatternException
{
    public enum UnauthorizedExceptionReason { userunknown, ipaddressmismatch, usernotfound, notinrole, loginfailed };
    
	public UnauthorizedException()
	{
		super();
	}

	public UnauthorizedException(UnauthorizedExceptionReason aReason, String message)
	{
		super(message);
		exceptionReason = aReason;
	}

    private UnauthorizedExceptionReason exceptionReason;

	public UnauthorizedExceptionReason getExceptionReason()
	{
		return exceptionReason;
	} 
    
}
