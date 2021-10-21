package org.r3.ws.system.mail;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.db.cms.cardproperty.CardPropertyDTO.CardPropertyRole;
import org.r3.db.cms.cardproperty.CardPropertyPersistence;
import org.r3.db.system.outmailattachment.OutMailAttachmentDTO;
import org.r3.db.system.outmailattachment.OutMailAttachmentPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.CreateSequenceServicePattern;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;

public class CreateAttachmentGroup extends CreateSequenceServicePattern
{

	public CreateAttachmentGroup(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSequencePrefix)
	{
		super(ctx, serviceEnvironment, aSequencePrefix);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		
		RestServiceDTO rdto = (RestServiceDTO)super.process(pcfg, aSession);

		String sid = rdto.getCorrelationid();
		CardPropertyPersistence cardPersistence = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);
		List<CardPropertyDTO> listOfSystemAttachment = cardPersistence.selectBySiteCardidPropertyrole(senv.getRequestSiteId(), "OUTMAIL", CardPropertyRole.mail_sysattach.toString(), pcfg.getPersistenceConfigInfo());
		if (listOfSystemAttachment != null)
		{
			OutMailAttachmentPersistence op = OutMailAttachmentPersistence.createPersistenceObject(pcfg,  aSession);
			OutMailAttachmentDTO dto = new OutMailAttachmentDTO();
			
			for(CardPropertyDTO cpdto : listOfSystemAttachment)
			{
				dto.setAttachmentid(getSequence(pcfg, aSession, "MAT"));
				dto.setAttachmentgroupid(sid);
				dto.setSite(senv.getRequestSiteId());
				dto.setAttachmenturl(cpdto.getPropertyvalue());
				dto.setRecstatus(RecordStatus.sys_recact.toString());
				
				op.insert(dto, pcfg.getPersistenceConfigInfo());
			}
		}
		
		return rdto;
	}
	
	
}
