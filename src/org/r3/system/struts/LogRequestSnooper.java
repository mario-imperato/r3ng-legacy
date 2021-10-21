package org.r3.system.struts;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class LogRequestSnooper extends RequestSnooperBase
{
    private Logger logger = null;
    
    public void snoop(ServletConfig servletCfg, HttpServletRequest request)
    {
        StringBuilder stb = prepareSnoopBuffer(servletCfg, request, snoopType);
        logger.info(stb.toString());        
    }

    private RequestSnooperInfo snoopType;
    
    public LogRequestSnooper(Logger aLog, RequestSnooperType rst)
    {
        logger = aLog;        
        snoopType = RequestSnooperInfo.full;
    	if (rst == RequestSnooperType.console_address)
    		snoopType = RequestSnooperInfo.address;
    }

}
