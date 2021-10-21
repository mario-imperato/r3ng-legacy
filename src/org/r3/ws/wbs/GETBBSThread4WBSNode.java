package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.wbs.wbs.WBSDTO;
import org.r3.db.wbs.wbs.WBSPersistence;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSThread4WBSNode extends ServicePattern
{
    private String wbsNodeId;
    private String wbsId;
    
	public GETBBSThread4WBSNode(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aWbsId, String aWbsNodeId)
	{
		super(ctx, serviceEnvironment);
		wbsNodeId = aWbsNodeId;
		wbsId =aWbsId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		WBSPersistence wbsPersistence = WBSPersistence.createPersistenceObject(pcfg, aSession);
		WBSDTO wbsDTO = wbsPersistence.selectBySiteWbsid(senv.getRequestSiteId(), wbsId, pcfg.getPersistenceConfigInfo());
		if (wbsDTO == null)
			return RestServiceDTO.FailDTO;
		
		BBSThreadDTO dto1 = null;
		if (wbsDTO.getBbstopicid() != null)
		{
			BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
			
			dto1 = p.selectBySiteThreadid(senv.getRequestSiteId(), wbsNodeId, pcfg.getPersistenceConfigInfo());	
			if (dto1 == null)
			{
				WBSNodePersistence wbsNodePersistence = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
				WBSNodeDTO wbsNodeDTO = wbsNodePersistence.selectByWbsnodeid(wbsNodeId, pcfg.getPersistenceConfigInfo());
				if (wbsNodeDTO != null)
				{
				dto1 = getDefaultDTO4Insert(senv.getRequestSiteId(), wbsId, wbsNodeId, wbsNodeDTO.getNodename());
				p.insert(dto1, pcfg.getPersistenceConfigInfo());
				}
			}
		}
				
		return dto1;
	}

	public static BBSThreadDTO getDefaultDTO4Insert(String aSite, String aTopicId, String aThreadId, String aThreadTitle)
	{
		BBSThreadDTO dto = new BBSThreadDTO();
		dto.setSite(aSite);
		dto.setThreadid(aThreadId);
		dto.setTopicid(aTopicId);
		dto.setThreadtitle(aThreadTitle);
		
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}
}
