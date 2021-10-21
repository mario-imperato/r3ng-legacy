package org.r3.ws.sailevent.sailevent;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.event.SailEventDTO;
import org.r3.db.sailevent.event.SailEventPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailEventDetail extends ServicePattern
{
    private String regattaId;
    
	public GETSailEventDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRegattaId)
	{
		super(ctx, serviceEnvironment);
		regattaId = aRegattaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailEventPersistence p = SailEventPersistence.createPersistenceObject(pcfg, aSession);
						
		SailEventDTO dto1 = p.selectByEventid(regattaId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
