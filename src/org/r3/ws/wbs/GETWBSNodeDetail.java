package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSNodeDetail extends ServicePattern
{
	private String wbsid;
    private String wbsNodeId;
    
	public GETWBSNodeDetail(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, String aWbsNodeId)
	{
		super(ctx, serviceEnvironment);
		wbsid = aWbsId;
		wbsNodeId = aWbsNodeId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{		
	   WBSNodePersistence np = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
	   WBSNodeDTO dto = np.selectByWbsnodeid(wbsNodeId, pcfg.getPersistenceConfigInfo());
		
       return dto;
	}

}
