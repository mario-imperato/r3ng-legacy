package org.r3.ws.system.mail;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.outmailattachment.OutMailAttachmentPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.cardproperty.DeleteCardProperty;

public class DeleteMailAttachment extends DeleteCardProperty
{

	public DeleteMailAttachment(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aPropertyId)
	{
          super(ctx, serviceEnvironment, aSite, aCardId, aPropertyId);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RestServiceDTO retCode = (RestServiceDTO)super.process(pcfg, aSession);
        if (retCode.getStatus() == Status.ok)
        {
        	OutMailAttachmentPersistence p = OutMailAttachmentPersistence.createPersistenceObject(pcfg, aSession);
        	p.deleteByAttachmentid(propertyId, pcfg.getPersistenceConfigInfo());
        }
		return retCode;
	}

	
}
