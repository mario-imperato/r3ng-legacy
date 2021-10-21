package org.r3.ws.system.mail;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.outmailattachment.OutMailAttachmentDTO;
import org.r3.db.system.outmailattachment.OutMailAttachmentPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.ws.cms.cardproperty.POSTCMSCardPropertyFileUpload;

public class POSTMailAttachmentFile extends POSTCMSCardPropertyFileUpload
{
    private String attachmentGroupId;
    
	public POSTMailAttachmentFile(
			ServletContext ctx,  ServiceEnvironment serviceEnvironment, 
			String aSite, String aCardId, String anAttachmentGroupId, MultipartFormDataInput input, String fileDataPart, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment, aSite, aCardId, input, fileDataPart, isIEFlag);
		attachmentGroupId = anAttachmentGroupId;
	}

	@Override
	protected void processUploadedFile(PersistenceContext pcfg, SqlSession aSession,
			String cms_attach_propertyrole, FileUploadDTO f)
	{
		super.processUploadedFile(pcfg, aSession, cms_attach_propertyrole, f);		
		OutMailAttachmentPersistence op = OutMailAttachmentPersistence.createPersistenceObject(pcfg,  aSession);
		OutMailAttachmentDTO dto = new OutMailAttachmentDTO();
		dto.setAttachmentid(f.getFileId());
		dto.setAttachmentgroupid(attachmentGroupId);
		dto.setSite(senv.getRequestSiteId());
		dto.setAttachmenturl(f.getFileurl());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		op.insert(dto, pcfg.getPersistenceConfigInfo());
		
		f.setDeleteUrl(f.getFileId());
	}
	
	
}
