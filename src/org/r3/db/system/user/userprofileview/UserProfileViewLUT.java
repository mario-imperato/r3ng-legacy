package org.r3.db.system.user.userprofileview;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;



public class UserProfileViewLUT extends LUT
{
	public UserProfileViewLUT() 
	{
		try
		{
	    setReader(new UserProfileViewLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		UserProfileViewDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public UserProfileViewDTO getItem(String aDtokey)
	{
		return getItem(aDtokey, false);
	}
	
	public UserProfileViewDTO getItem(String aDtokey, boolean duplicate)
	{
	    try
		{		    
		    UserProfileViewDTO dto = (UserProfileViewDTO)getInstance().getItem(aDtokey);
		    if (dto != null && duplicate)
		    {
		    	dto = new UserProfileViewDTO(dto);
		    }
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
