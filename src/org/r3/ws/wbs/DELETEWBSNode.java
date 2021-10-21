package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEWBSNode extends ServicePattern
{
    private String wbsId;
    private String nodeId;
    
	public DELETEWBSNode(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, String aNodeId)
	{
		super(ctx, serviceEnvironment);
		wbsId = aWbsId;
		nodeId = aNodeId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);        		
		int numberOfRows = p.deleteByWbsnodeid(nodeId, pcfg.getPersistenceConfigInfo());
		
		return RestServiceDTO.SuccessDTO;
	}

}
