package org.r3.ws.system.classifiers.lut;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifier.ClassifierDataTableAdapter;
import org.r3.db.system.classifier.ClassifierFilter;
import org.r3.db.system.classifier.ClassifierPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class ConditionallyGETClassifiers extends LUTConditionalGetPattern
{
    
    public ConditionallyGETClassifiers(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment, LUTName.classifiers.toString());
	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		ClassifierDataTableAdapter dt = getData(pcfg, aSession);
		return dt;
	}

	private ClassifierDataTableAdapter getData(PersistenceContext pcfg, SqlSession sqlSession)
	{
		ClassifierPersistence p = ClassifierPersistence.createPersistenceObject(pcfg, sqlSession);

		ClassifierFilter filter = new ClassifierFilter();
		filter.or().andSiteEqualTo(getServiceEnvironment().getRequestSiteId());
		return p.query(filter, pcfg.getPersistenceConfigInfo());		
	}

}
