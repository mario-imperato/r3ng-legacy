package org.r3.ws.sailevent.application;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.cms.attachmenttype.AttachmentTypeLUT;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentDTO;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentDTO.DocumentType;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadDTOFactory;
import org.r3.system.rest.fileupload.FileUploadField;
import org.r3.system.rest.fileupload.FileUploadPattern;
import org.r3.system.rest.fileupload.FileUploadProcessingConfig.ConfigParamClass;
import org.r3.system.rest.fileupload.FileUploadProcessingImageConfig;

public class POSTFileUpload extends FileUploadPattern
{
	private String cardId;
	private String site;

	public POSTFileUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String anApplicationId,
					MultipartFormDataInput input, String fileDataPart, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory("documenttype"), true, isIEFlag);
		site = aSite;
		cardId = anApplicationId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		List<FileUploadDTO> files = null;
		DMSContext dmsContext = new DMSContext(pcfg, aSession);

		DMSFileSystemUrl url;
		try
		{
			SailApplicationDocumentPersistence pf = SailApplicationDocumentPersistence.createPersistenceObject(pcfg, aSession);
			EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
			
			SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
			SailApplicationDTO dto = p.selectByEventidApplicationid(site, cardId, pcfg.getPersistenceConfigInfo());
			if (dto != null)
			{
				DMSFolder docFolder = DMSFolderHelper.getSailApplicationFolder(dmsContext, dto.getEventid(), dto.getApplicationid(), true);

				if (docFolder != null)
				{
					DocumentType documentType = DocumentType.r3ea_doc;
					FileUploadField documentTypeField = getFileUploadActionForm().getField("documenttype");
					if (documentTypeField != null)
						documentType = SailApplicationDocumentDTO.getDocumenttypecodeAsEnum(documentTypeField.getValue());

					FileUploadField crewMemberIdField = getFileUploadActionForm().getField("crewmemberid");
					String crewMemberId = null;
					if (crewMemberIdField != null)
					{
						crewMemberId = crewMemberIdField.getValue();
					}
					
					// Eseguo la scalatura per tutte le immagini indipendentemente dal fatto sia stata dichiarata immagine barca o meno.
					// All'interno dell'actionForm la scalatura viene fatta solo per immagini Internet.
//					getFileUploadActionForm().setImageOptions("cms_imgboat");
//					getFileUploadActionForm().setIconOptions("cms_iconboat");
					
					AttachmentTypeLUT attachmentTypeLUT = (AttachmentTypeLUT)LUTManager.getLUTManager().getLUT(LUTName.cms_attachtype, this.getServiceEnvironment().getRequestLanguage());
					AttachmentTypeDTO lutItem = attachmentTypeLUT.getItem(senv.getRequestSiteId(), "cms_boatimage");
					if (lutItem != null)
					{
						if (lutItem.getImagescaling() != null)
						   getFileUploadActionForm().addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.image, "imagescaling", lutItem.getImagescaling()));
						
						if (lutItem.getIconscaling() != null)							
						   getFileUploadActionForm().addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.icon, "iconscaling", lutItem.getIconscaling()));						
					}
					
					
//					if (documentType == DocumentType.r3ea_dtboatimg)
//					{
//						getFileUploadActionForm().setImageOptions("cms_imgboat");
//						getFileUploadActionForm().setIconOptions("cms_iconboat");
//					}
//					else
//					{
//						getFileUploadActionForm().setImageOptions(null);
//						getFileUploadActionForm().setIconOptions(null);
//					}

					files = getFileUploadActionForm().getFiles();

					// Pezzettino di codice per generare un exception a
					// piacere...
					int numberOfValidFiles = 0;
					for (FileUploadDTO f : files)
					{
						// if ( ... )
						// {
						// f.setValid(false);
						// f.setError("Nome File Duplicato");
						// }
						// else
						// {
						f.setValid(true);
						numberOfValidFiles++;
						// }
					}

					if (numberOfValidFiles > 0)
					{
						for (FileUploadDTO f : files)
						{
							if (f.isValid())
							{
								storeFile(dmsContext, docFolder, f, true);

								SailApplicationDocumentDTO fileDto = new SailApplicationDocumentDTO();
								fileDto.setEventid(site);
								fileDto.setApplicationid(cardId);
								fileDto.setCrewmemberid(crewMemberId);
								fileDto.setContenttype(f.getContentType());
								fileDto.setDocumentname(f.getUploadFileName());
								fileDto.setDocumenttypecode(documentType.toString());
								fileDto.setDocumenturl(f.getFileurl());
								fileDto.setFilesize((long) f.getSize());

								if (documentType == DocumentType.r3ea_dtboatimg)
								{
									// Nel caso sia stata battezzata come immagine verifico che sia un formato immagine. In caso contrario 
									// modifico il tipo del dato.
									if (f.isImage())
									{
									fileDto.setImagewidth(f.getImageWidth());
									fileDto.setImageheight(f.getImageHeight());
									fileDto.setImageurl(f.getFileurl());

									fileDto.setIconwidth(f.getIconWidth());
									fileDto.setIconheight(f.getIconHeight());
									fileDto.setIconurl(f.getIconurl());
									}
									else fileDto.setDocumenttypecode(DocumentType.r3ea_doc.toString());
								}

								pf.insert(fileDto, pcfg.getPersistenceConfigInfo());
								
								ep.logEventAddDocInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), cardId, fileDto.getDocumentid(), senv.getUserProfile().getUserid());
								
								f.setValid(true);

								if (documentType == DocumentType.r3ea_dtboatimg && f.isImage())
								{
									dto.setAddtohomeentrylist("btrue");
									dto.setBoatimageid(fileDto.getDocumentid());
									dto.setBoatimagewidth(f.getImageWidth());
									dto.setBoatimageheight(f.getImageHeight());
									dto.setBoatimageurl(f.getFileurl());

									dto.setBoaticonwidth(f.getIconWidth());
									dto.setBoaticonheight(f.getIconHeight());
									dto.setBoaticonurl(f.getIconurl());
									p.updateByPrimaryKey(dto, pcfg.getPersistenceConfigInfo());
								}

							}
						}
					}
				}
			}
		}
		catch (DMSException e)
		{
			e.printStackTrace();
			if (isIE())
				return serializeFiles(files);
			else
				throw new ServicePatternException(e.getMessage());
		}

		if (isIE())
			return serializeFiles(files);

		return new ArrayOfFileUploadDTO(files);
	}

}
