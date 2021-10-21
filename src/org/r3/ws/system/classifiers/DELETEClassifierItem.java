package org.r3.ws.system.classifiers;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifieritem.ClassifierItemPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEClassifierItem extends ServicePattern
{
    private String classifierId;
    private String classifierItemId;
    
	public DELETEClassifierItem(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClsId, String aClsItemId)
	{
		super(ctx, serviceEnvironment);
		classifierId = aClsId;
		classifierItemId = aClsItemId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, aSession);
        p.deleteBySiteClsidClsitemid(senv.getRequestSiteId(), classifierId, classifierItemId, pcfg.getPersistenceConfigInfo());
        
		return RestServiceDTO.SuccessDTO;
	}

}
