package org.r3.system;

public class AuthFunction 
{	
	public static final String FunctionPub = "pub";
	public static final AuthFunction PublicAuthorization = new AuthFunction();

	private boolean identified;
	private String functionId;
	
	public AuthFunction(String f)
	{
		this(true, f);
	}
		
	public AuthFunction()
	{
		functionId = "pub";
		identified = false;
	}
	
	public AuthFunction(boolean anIdentifiedFlag, String f)
	{
		functionId = f;
		identified = anIdentifiedFlag;
	}
	
	public boolean isIdentified()
	{
		return identified;
	}
	
	public boolean isPublic()
	{
		return functionId != null && functionId.equalsIgnoreCase("pub");
	}
	
	public String toString()
	{
		return functionId;
	}
}
