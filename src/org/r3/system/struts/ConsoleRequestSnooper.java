package org.r3.system.struts;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

public class ConsoleRequestSnooper extends RequestSnooperBase
{    
    public void snoop(ServletConfig servletCfg, HttpServletRequest request)
    {
    	StringBuilder stb = null;    	
   		stb = prepareSnoopBuffer(servletCfg, request, snoopType);    	
        System.out.print(stb.toString());        
    }

    private RequestSnooperInfo snoopType;
    
    public ConsoleRequestSnooper(RequestSnooperType rst)
    {
    	snoopType = RequestSnooperInfo.full;
    	if (rst == RequestSnooperType.console_address)
    		snoopType = RequestSnooperInfo.address;
    }
    

}
