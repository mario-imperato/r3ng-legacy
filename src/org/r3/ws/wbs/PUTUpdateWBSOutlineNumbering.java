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

public class PUTUpdateWBSOutlineNumbering extends ServicePattern
{
	private String wbsid;
    
	public PUTUpdateWBSOutlineNumbering(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId)
	{
		super(ctx, serviceEnvironment);
		wbsid = aWbsId;
		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSPersistence p = WBSPersistence.createPersistenceObject(pcfg, aSession);

		WBSDTO dto1 = p.selectBySiteWbsid(senv.getRequestSiteId(), wbsid, pcfg.getPersistenceConfigInfo());
		
		
		WBSNodePersistence np = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
		List<WBSNodeDTO> l = np.selectBySiteWbsid(senv.getRequestSiteId(), wbsid, pcfg.getPersistenceConfigInfo());

		WBSNodeDTO rootNode = dto1.buildTree(l);
		dto1.setRootnode(rootNode);
		
		if (l != null)
		{
			for(WBSNodeDTO nodeDto : l)
			{
				if (nodeDto.isNodesectDirty())
					np.updateByPrimaryKey(nodeDto, pcfg.getPersistenceConfigInfo());
				
				nodeDto.clearDirtyFlags();
			}
		}
		
		return dto1;
	}

}
