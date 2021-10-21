package org.r3.ws.system.classifiers;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifier.ClassifierDTO;
import org.r3.db.system.classifier.ClassifierPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETClassifierDetail extends ServicePattern
{
	private String classifierId;

    
	public GETClassifierDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aClassifierId)
	{
		super(ctx, serviceEnvironment);
		classifierId = aClassifierId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{			
		
		ClassifierPersistence p = ClassifierPersistence.createPersistenceObject(pcfg, aSession);
		ClassifierDTO dto = p.selectBySiteClsid(senv.getRequestSiteId(), classifierId, pcfg.getPersistenceConfigInfo());

		return dto;
	}

}
