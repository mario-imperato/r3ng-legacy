package org.r3.ws.system.classifiers;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifieritem.ClassifierItemDTO;
import org.r3.db.system.classifieritem.ClassifierItemPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTClassifierItem extends ServicePattern
{
	private ClassifierItemActionForm actionForm;
    private String classifierId;
    
	public POSTClassifierItem(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClsId, ClassifierItemActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		classifierId = aClsId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		ClassifierItemDTO dto2 = null;
		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, aSession);

		if (actionForm.getClsitemid() != null)
		{
			dto2 = p.selectByClsitemid(actionForm.getClsitemid(), pcfg.getPersistenceConfigInfo());
			if (dto2 != null)
			{
				RestServiceDTO srvDTO = new RestServiceDTO(Status.fail, "CLSF_0001", "Elemento di Classificazione gia' presente");
				return srvDTO;
			}
		}
		
		dto2 = actionForm.getDTO4Insert(senv.getRequestSiteId(), classifierId);
		p.insert(dto2, pcfg.getPersistenceConfigInfo());

		String[] subgroups = actionForm.getSubgroupsAsArray();
		if (subgroups != null && subgroups.length > 0)
		{
		    for(int i = 0; i < subgroups.length; i++)
		    {
		    	ClassifierItemDTO dto3 = actionForm.getDTO4SubgroupInsert(i, null, subgroups[i], senv.getRequestSiteId(), classifierId, dto2.getClsitemid());
				p.insert(dto3, pcfg.getPersistenceConfigInfo());		    	
		    }
		}
		
		LUTManager.getLUTManager().invalidateLUT(classifierId);
		return dto2;
	}

}
