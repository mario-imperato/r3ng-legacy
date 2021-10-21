package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopicview.BBSTopicViewDataTableAdapter;
import org.r3.db.bbs.bbstopicview.BBSTopicViewFilter;
import org.r3.db.bbs.bbstopicview.BBSTopicViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSTopics extends ServicePattern
{
    private BBSTopicQueryActionForm queryForm;
    private boolean fetchThreads;
    
	public GETBBSTopics(ServletContext ctx,  ServiceEnvironment serviceEnvironment, BBSTopicQueryActionForm aQueryForm, boolean fetchThreadsFlag)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		fetchThreads = fetchThreadsFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		BBSTopicViewPersistence p = BBSTopicViewPersistence.createPersistenceObject(pcfg, aSession);				
		BBSTopicViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		BBSTopicViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		if (dt.getiTotalRecords() > 0 && fetchThreads)
		{
//			BBSThreadPersistence np = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);							
//		    for(BBSTopicViewDTO dto : dt.getAaData())
//		    {
//		    	List<BBSThreadDTO> listOfThreads = np.selectBySiteTopicid(dto.getSite(), dto.getTopicid(), pcfg.getPersistenceConfigInfo());		    	
//		    }
		}
				
		return dt;
	}

}
