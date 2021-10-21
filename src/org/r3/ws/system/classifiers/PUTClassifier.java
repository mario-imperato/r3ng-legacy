package org.r3.ws.system.classifiers;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifier.ClassifierDTO;
import org.r3.db.system.classifier.ClassifierPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTClassifier extends ServicePattern
{
	private ClassifierActionForm actionForm;
    private String classifierId;
    
	public PUTClassifier(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClsId, ClassifierActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		classifierId = aClsId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
		ClassifierPersistence p = ClassifierPersistence.createPersistenceObject(pcfg, aSession);
		ClassifierDTO dto2 = p.selectBySiteClsid(senv.getRequestSiteId(), classifierId, pcfg.getPersistenceConfigInfo());

		if (dto2 != null)
		{
			dto2 = actionForm.getDTO4Update(dto2);
			p.updateByPrimaryKey(dto2, pcfg.getPersistenceConfigInfo());	
			
			LUTManager.getLUTManager().invalidateLUT(LUTName.classifiers);
			LUTManager.getLUTManager().invalidateLUT(classifierId);
			
			return dto2;			
		}
		
		rc = new RestServiceDTO(Status.fail, "CLSF_0002", "Elemento di Classificazione non presente");
		return rc;
	}

}
