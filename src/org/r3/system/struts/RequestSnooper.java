package org.r3.system.struts;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

public abstract class RequestSnooper
{
	public enum RequestSnooperInfo     { full, address };
    public enum RequestSnooperType     { none, console, console_address };
    
    public abstract void snoop(ServletConfig servletCfg, HttpServletRequest request);
    
    public static RequestSnooper getRequestSnooper(RequestSnooperType rst)
    {
        RequestSnooper rs = null;
        
        switch(rst)
        {
            case console: rs = new ConsoleRequestSnooper(rst); break;
            case console_address:    rs = new ConsoleRequestSnooper(rst); break;
        }
        return rs;
    }
}
