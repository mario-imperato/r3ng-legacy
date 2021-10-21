package org.r3.db.dms.model;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;

public class DMSContext
{
	private PersistenceContext pcfg;
	private SqlSession         dmsSession;
	
	public DMSContext(PersistenceContext aPcfg, SqlSession aDmsSession)
	{
		pcfg = aPcfg;
		dmsSession = aDmsSession; 
	}
	
    public PersistenceContext getPersistenceContext()
    {
    	return pcfg;
    }
    
    public SqlSession getSession()
    {
    	return dmsSession;
    }

    public String generateFileId()
    {    	
    	return pcfg.generateId("DFL");
    }
}
