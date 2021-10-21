package org.r3.struts.sev;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.system.struts.GWFMappingDispatchAction;

public class SailEventManager extends GWFMappingDispatchAction
{
    protected String getRequestParameter(HttpServletRequest request, String pName)
    {
    	String pValue = request.getParameter(pName);
    	return pValue;
    }
    
    protected SailApplicationDTO retrieveApplicationById(
    				HttpServletRequest request, SqlSession aSession, PersistenceContext pcfg, 
    				String anEventId, String anApplicationId)
    {   	     	 
    	SailApplicationPersistence companyPersistence = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
    	SailApplicationDTO sailApplicationDTO = companyPersistence.selectByEventidApplicationid(anEventId, anApplicationId, pcfg.getPersistenceConfigInfo()); 

   	    return sailApplicationDTO;
    }
    
}
