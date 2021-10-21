package org.r3.ws.wbs;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbs.WBSDTO;
import org.r3.db.wbs.wbs.WBSPersistence;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSDetail extends ServicePattern
{
	private String wbsid;
    private boolean includeTreeNodes;
    
	public GETWBSDetail(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, boolean aIncludeTreeNodesFlag)
	{
		super(ctx, serviceEnvironment);
		wbsid = aWbsId;
		includeTreeNodes = aIncludeTreeNodesFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSPersistence p = WBSPersistence.createPersistenceObject(pcfg, aSession);

		WBSDTO dto1 = p.selectBySiteWbsid(senv.getRequestSiteId(), wbsid, pcfg.getPersistenceConfigInfo());
		
		if (includeTreeNodes)
		{
		   WBSNodePersistence np = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
		   List<WBSNodeDTO> l = np.selectBySiteWbsid(senv.getRequestSiteId(), wbsid, pcfg.getPersistenceConfigInfo());

		   WBSNodeDTO rootNode = dto1.buildTree(l);
		   dto1.setRootnode(rootNode);
		}
		
		return dto1;
	}

}
