package org.r3.ws.cms.channel;

import javax.ws.rs.FormParam;

public class ChannelActionForm
{
	@FormParam("channelid_site_cardid")
    private String[] channelid_site_cardid;
	
	public String[] getChannelid_site_cardid()
	{
	    return channelid_site_cardid;	
	}
	
	public int getNumberOfChannelid_site_cardid()
	{
		if (channelid_site_cardid != null)
			return channelid_site_cardid.length;
		
		return 0;
	}
	
	public String[] getChannelid_site_cardid(int fieldIndex)
	{
		if (channelid_site_cardid != null && channelid_site_cardid.length > fieldIndex)
		{
			String[] ids = channelid_site_cardid[fieldIndex].split("_");
			if (ids != null && ids.length > 3)
			{
				// Nel caso in cui il vettore sia piu' lungo di tre suppongo che gli extra '_' appartengano al site.
				StringBuilder stb = new StringBuilder();
				for(int j = 1; j < (ids.length - 1); j++)
				{
					if (j > 1)
						stb.append('_');
					
					stb.append(ids[j]);
				}
				
				ids[1] = stb.toString();
				ids[2] = ids[ids.length - 1];
			}
			return ids;
		}
		
		return null;
	}
}
