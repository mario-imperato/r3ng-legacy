package org.r3.ws.system.classifiers;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifieritem.ClassifierItemDTO;
import org.r3.db.system.classifieritem.ClassifierItemPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETClassifierItemDetail extends ServicePattern
{
    private String classifierId;
    private String classifierItemId;
    
	public GETClassifierItemDetail(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClsId, String aClsItemId)
	{
		super(ctx, serviceEnvironment);
		classifierId = aClsId;
		classifierItemId = aClsItemId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, aSession);
		ClassifierItemDTO dto2 = p.selectByClsitemid(classifierItemId, pcfg.getPersistenceConfigInfo());

		if (dto2 != null)
		{
			List<ClassifierItemDTO> listOfChildren = p.selectChildrenOfClassifieritemid(senv.getRequestSiteId(), classifierId, classifierItemId, (String)null, pcfg.getPersistenceConfigInfo());
			dto2.setChildren(listOfChildren);
		}
		return dto2;
	}

}
