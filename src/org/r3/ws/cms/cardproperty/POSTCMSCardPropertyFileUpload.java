package org.r3.ws.cms.cardproperty;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.cms.attachmenttype.AttachmentTypeLUT;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.db.cms.cardproperty.CardPropertyDTO.CardPropertyType;
import org.r3.db.cms.cardproperty.CardPropertyPersistence;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
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

public class POSTCMSCardPropertyFileUpload extends FileUploadPattern
{
		private String cardId;
		private String site;
		
		public POSTCMSCardPropertyFileUpload(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, MultipartFormDataInput input, String fileDataPart, boolean isIEFlag)
		{
			super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory("cms_attachtype"), true, isIEFlag);
			site = aSite;
			cardId = aCardId;
			
			if (CardDTO.isDomainScope(aCardId))
			{
				site = senv.getRequestSite().getSitedomain();
			}
		}

		@Override
		protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
		{
			List<FileUploadDTO> files = null;
			DMSContext dmsContext = new DMSContext(pcfg, aSession);

			DMSFileSystemUrl url;
			try
			{
				CardPropertyPersistence pf = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);
				
				FileUploadField field = getFileUploadActionForm().getField(LUTName.cms_attachtype.toString());
				String cms_attachtype = (field != null) ? DTOBase.nullOnEmpty(field.getValue()) : null;
				String cms_attach_propertyrole = null;
				
				if (cms_attachtype != null)
				{
					AttachmentTypeLUT attachmentTypeLUT = (AttachmentTypeLUT)LUTManager.getLUTManager().getLUT(LUTName.cms_attachtype, this.getServiceEnvironment().getRequestLanguage());
					AttachmentTypeDTO lutItem = attachmentTypeLUT.getItem(cms_attachtype);
					if (lutItem != null)
					{
						if (lutItem.getImagescaling() != null)
						   getFileUploadActionForm().addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.image, "imagescaling", lutItem.getImagescaling()));
						
						if (lutItem.getIconscaling() != null)							
						   getFileUploadActionForm().addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.icon, "iconscaling", lutItem.getIconscaling()));
						
						cms_attachtype = lutItem.getDtokey(true);
						cms_attach_propertyrole = lutItem.getPropertyrole();
						
						if (lutItem.isSiteAttachment())
							LUTManager.getLUTManager().invalidateLUT(LUTName.sitecmsproperties);
					}										
					else cms_attachtype = null;
				}
				
				CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);
				CardDTO dto = p.selectBySiteCardid(site, cardId, pcfg.getPersistenceConfigInfo());
				if (dto != null)
				{
					DMSFolder docFolder = DMSFolderHelper.getCMSCardFolder(dmsContext, dto.getSite(), dto.getCardid(), true);

					if (docFolder != null)
					{						
						files = getFileUploadActionForm().getFiles();
						
						// Pezzettino di codice per generare un exception a piacere...
						int numberOfValidFiles = 0;
						for(FileUploadDTO f : files)
						{
//				            if ( ... )
//				            {
//				            	f.setValid(false);
//				            	f.setError("Nome File Duplicato");
//				            }
//				            else 
//				            {
				            	f.setValid(true);
				            	numberOfValidFiles++;
//				            }
						}
						
						if (numberOfValidFiles > 0)
						{													
							for(FileUploadDTO f : files)
							{						
								if (f.isValid())
								{																								
									storeFile(dmsContext, docFolder, f, true);								
									processUploadedFile(pcfg, aSession, cms_attach_propertyrole, f);							
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

		protected void processUploadedFile(PersistenceContext pcfg, SqlSession aSession, String cms_attach_propertyrole, FileUploadDTO f)
		{
			CardPropertyPersistence pf = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);
			
			CardPropertyDTO fileDto = new CardPropertyDTO();							
			fileDto.setSite(site);
			fileDto.setCardid(cardId);
			fileDto.setLanguagecode("*");
			
			fileDto.setContenttype(f.getContentType());
			fileDto.setPropertytypecode(CardPropertyDTO.getCardPropertyTypeByContentType(f.getContentType(), CardPropertyType.file).toString());
			fileDto.setPropertyrole(cms_attach_propertyrole);
			
			fileDto.setPropertyname(f.getUploadFileName());
			fileDto.setPropertyvalue(f.getFileurl());
			fileDto.setPropertysize((int)f.getSize());

			fileDto.setImagewidth(f.getImageWidth());
			fileDto.setImageheight(f.getImageHeight());
			if (f.isImage())
			{
				fileDto.setImageurl(f.getFileurl());
			}
			
			fileDto.setIconwidth(f.getIconWidth());
			fileDto.setIconheight(f.getIconHeight());
			fileDto.setIconurl(f.getIconurl());			
			fileDto.setRecstatus(RecordStatus.sys_recact.toString());
																						
			pf.insert(fileDto, pcfg.getPersistenceConfigInfo());
			
			f.setFileId(fileDto.getPropertyid());
			f.setValid(true);
		}

	}
