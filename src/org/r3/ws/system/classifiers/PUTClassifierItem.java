package org.r3.ws.system.classifiers;

import java.util.List;

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

public class PUTClassifierItem extends ServicePattern
{
	private ClassifierItemActionForm actionForm;
    private String classifierId;
    private String classifierItemId;
    
	public PUTClassifierItem(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClsId, String aClsItemId, ClassifierItemActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		classifierId = aClsId;
		classifierItemId = aClsItemId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, aSession);
		ClassifierItemDTO dto2 = p.selectByClsitemid(classifierItemId, pcfg.getPersistenceConfigInfo());

		if (dto2 != null)
		{
			if (dto2.getSite().equalsIgnoreCase(senv.getRequestSiteId()) && dto2.getClsid().equalsIgnoreCase(classifierId))
			{
				dto2 = actionForm.getDTO4Update(dto2);
				p.updateByPrimaryKey(dto2, pcfg.getPersistenceConfigInfo());

				// Mi salvo gli Id pre-esistenti.
				List<ClassifierItemDTO> listOf = p.selectChildrenOfClassifieritemid(senv.getRequestSiteId(), classifierId, dto2.getClsitemid(), null, pcfg.getPersistenceConfigInfo());
                int numberOfDBItems = -1;
				if (listOf != null)
					numberOfDBItems = listOf.size();
				
				// Cancello i valori dal DB.
				p.deleteBySiteClsidParentclsitemid(senv.getRequestSiteId(), classifierId, dto2.getClsitemid(), pcfg.getPersistenceConfigInfo());

				String[] subgroups = actionForm.getSubgroupsAsArray();
				if (subgroups != null && subgroups.length > 0)
				{					
				    for(int i = 0; i < subgroups.length; i++)
				    {				
				    	String assignedId = null;
				    	
				    	if (numberOfDBItems > i)
				    		assignedId = listOf.get(i).getClsitemid();
				    	
				    	ClassifierItemDTO dto3 = actionForm.getDTO4SubgroupInsert(i + 1, assignedId, subgroups[i], senv.getRequestSiteId(), classifierId, dto2.getClsitemid());
						p.insert(dto3, pcfg.getPersistenceConfigInfo());		    	
				    }
				}

				LUTManager.getLUTManager().invalidateLUT(classifierId);
				return dto2;
			}
		}
		
		rc = new RestServiceDTO(Status.fail, "CLSF_0002", "Elemento di Classificazione non presente");
		return rc;
		
	}

}
