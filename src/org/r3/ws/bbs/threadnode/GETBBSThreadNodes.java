package org.r3.ws.bbs.threadnode;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDataTableAdapter;
import org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter;
import org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSThreadNodes extends ServicePattern
{
	public enum RetrieveMode 
	{ 
		 normal, timeline; 
	
		 public static RetrieveMode getValue4(String s, RetrieveMode defaultValue)
		 {			 
			 if (s != null)
			 {
				 try
				 {
					 RetrieveMode r = RetrieveMode.valueOf(s);
					 return r;
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			 }
			 
			 return defaultValue;
		 }
	};
	
    private BBSThreadNodeQueryActionForm queryForm;
    private String topicId;
    private String threadId;
    private RetrieveMode retrieveMode;
    
	public GETBBSThreadNodes(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId, String aMode, BBSThreadNodeQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		topicId = aTopicId;
		threadId = aThreadId;
		
		retrieveMode = RetrieveMode.getValue4(aMode, RetrieveMode.normal);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		BBSThreadNodeViewPersistence p = BBSThreadNodeViewPersistence.createPersistenceObject(pcfg, aSession);				
		BBSThreadNodeViewFilter filter = null;
		List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> listOfNodes = null;
		BBSThreadNodeViewDataTableAdapter dt = null;
		
		switch(retrieveMode)
		{
		case normal:
			filter = queryForm.getSearchCondition(senv.getRequestSiteId(), topicId, threadId);			
			dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
			break;
			
		case timeline:
			filter = queryForm.getTimelinePrimaryNodesSearchCondition(senv.getRequestSiteId(), topicId, threadId);			
			listOfNodes = p.select(filter, pcfg.getPersistenceConfigInfo());
			if (listOfNodes != null && listOfNodes.size() > 0)
			{
				filter = queryForm.getTimelineChildNodesSearchCondition(
						senv.getRequestSiteId(), topicId, threadId, listOfNodes.get(listOfNodes.size() - 1).getThreadnodeid(), listOfNodes.get(0).getThreadnodeid());
				
				List<org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO> listOfChildNodes = p.select(filter, pcfg.getPersistenceConfigInfo());
				if (listOfChildNodes != null)
					listOfNodes.addAll(listOfChildNodes);
			}
			
			dt = new BBSThreadNodeViewDataTableAdapter(listOfNodes, queryForm.getsEcho());
			break;			
		}
		
				
		return dt;
	}

}
