package org.r3.ws.wbs;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbs.WBSDTO;
import org.r3.db.wbs.wbs.WBSDataTableAdapter;
import org.r3.db.wbs.wbs.WBSFilter;
import org.r3.db.wbs.wbs.WBSPersistence;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSes extends ServicePattern
{
    private WBSQueryActionForm queryForm;
    private boolean fetchTreeNodes;
    
	public GETWBSes(ServletContext ctx,  ServiceEnvironment serviceEnvironment, WBSQueryActionForm aQueryForm, boolean fetchTreeNodesFlag)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		fetchTreeNodes = fetchTreeNodesFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSPersistence p = WBSPersistence.createPersistenceObject(pcfg, aSession);				
		WBSFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		WBSDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		if (dt.getiTotalRecords() > 0 && fetchTreeNodes)
		{
			WBSNodePersistence np = WBSNodePersistence.createPersistenceObject(pcfg, aSession);							
		    for(WBSDTO dto : dt.getAaData())
		    {
		    	List<WBSNodeDTO> listOfNodes = np.selectBySiteWbsid(dto.getSite(), dto.getWbsid(), pcfg.getPersistenceConfigInfo());
		    	WBSNodeDTO rootNode = dto.buildTree(listOfNodes);
		    	dto.setRootnode(rootNode);
		    }
		}
		
		return dt;
	}



}
