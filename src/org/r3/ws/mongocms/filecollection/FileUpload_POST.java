package org.r3.ws.mongocms.filecollection;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.bson.BsonBinarySubType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.mongo.MongoFileAttachmentDTO;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileinput.FileInputPattern;
import org.r3.system.rest.fileinput.FileUploadActionForm;
import org.r3.system.rest.fileinput.FileUploadDTO;
import org.r3.system.rest.fileinput.FileUploadDTO.FileUploadDTO_FileRole;
import org.r3.system.rest.fileinput.FileUploadDTOFactory;
import org.r3.system.rest.fileinput.FileUploadField;
import org.r3.system.rest.fileinput.FileUploadProcessingImageConfig;

public class FileUpload_POST extends FileInputPattern
{
	public enum ResponseType 
	{
		uploaded_file, array_of_persistedfiles, mongoimage_fileattachment, ckeditor;
		
		public static ResponseType getValue4(String s, ResponseType defaultStatus)
		{
			if (s != null && s.trim().length() > 0)
			{
				try
				{
					return valueOf(s);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			return defaultStatus;
		}
	}
	
	protected ResponseType responseType;
	
	protected String mainEntityId;
	protected String ambitId;
	protected String subambitId;
	protected FileCollectionDTO.FileStatus fileStatus;

	public FileUpload_POST(ServletContext ctx, ServiceEnvironment serviceEnvironment, FileCollectionDTO.FileStatus aFileStatus, String aMainEntityId, String anAmbitId, String aSubambitId,
			MultipartFormDataInput input, String fileDataPart, String attachmentType, ResponseType aResponseType)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory(), true, attachmentType, aResponseType);
		mainEntityId = aMainEntityId;
		ambitId = anAmbitId;
		subambitId = aSubambitId;
		fileStatus = aFileStatus;
		
		responseType = aResponseType;
	}

	protected void applyUpdates(MongoPersistenceContext mctx, Datastore mongoDatastore, FileCollectionDTO r0, FileCollectionDTO r1)
	{
		
	}
		
	// protected abstract UpdateOperations<TimelineCollectionDTO> getPostUpdateOperation(Datastore mongoDatastore, TimelineCollectionDTO postDTO);
	
	// @Override
	// protected FileUploadActionForm newFileUploadActionFormInstance()
	// {
	// return new CyberAlturaFileUploadActionForm();
	// }

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
				
		FileUploadActionForm actionForm = getFileUploadActionForm();

		List<FileUploadDTO> files = actionForm.getFiles();

		int numberOfFiles = files.size();
		if (files == null || numberOfFiles == 0)
			throw new ServicePatternException("No Files Have Been Uploaded");

		if (numberOfFiles != 1)
			throw new ServicePatternException("Single File Expected...");

		AttachmentTypeDTO cmsAttachType = actionForm.retrieveAttachmentTypeDTO(senv.getRequestSiteId());
		if (cmsAttachType == null)
		{
			throw new ServicePatternException("Type Of File Expected...");
		}
		
		FileCollectionDTO[] arrayOfFileCollectionDTO = null;
		FileCollectionDTO restServiceFileDTO = null;
		FileCollectionDTO restServiceFileIconDTO = null;

		for (int i = 0; i < numberOfFiles; i++)
		{
			FileUploadDTO f = files.get(i);
			
			try
			{
				if (f.isImage())
				    arrayOfFileCollectionDTO = processImageUpload(pcfg, cmsAttachType, f, actionForm.getFields());
				else
				{
				    arrayOfFileCollectionDTO = processFileUpload(pcfg, cmsAttachType, f, actionForm.getFields());					
				}
				
				if (arrayOfFileCollectionDTO != null)
				{
					FileCollectionDTO r0 = arrayOfFileCollectionDTO[0];
					f.setFileId(r0.getFileid().toHexString());
					f.setSize(r0.getSize());
					f.setFileName(r0.getName());
					
					FileCollectionDTO r1 = null;
					if (arrayOfFileCollectionDTO.length > 1)
					{
						r1 = arrayOfFileCollectionDTO[1];
					}					
					
					applyUpdates(mctx, mongoDatastore, r0, r1);
					
					// Faccio anche un loop maprendo solo il primo..... e dovrebbe essercene solo uno.
					break;
				}
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				throw new ServicePatternException(ex.getMessage());
			}
		}

		Object responseObject = null;
		switch(responseType)
		{
		case uploaded_file:
			responseObject = new ArrayOfFileUploadDTO(files);
			break;
		case array_of_persistedfiles:
			responseObject = arrayOfFileCollectionDTO;
			break;
		case mongoimage_fileattachment:
			if (files.get(0).isImage())
			{
				MongoImageIconDTO mimg = new MongoImageIconDTO();
				mimg.populate(arrayOfFileCollectionDTO[0], arrayOfFileCollectionDTO.length > 1 ? arrayOfFileCollectionDTO[1] : null);
				responseObject = mimg;
			}
			else
			{
				MongoFileAttachmentDTO fa = new MongoFileAttachmentDTO();
				fa.populate(arrayOfFileCollectionDTO[0], arrayOfFileCollectionDTO.length > 1 ? arrayOfFileCollectionDTO[1] : null);
				responseObject = fa;
			}
			break;
		}
				
		return responseObject;		
	}

		
	private FileCollectionDTO[] 
			processImageUpload(PersistenceContext pcfg, AttachmentTypeDTO cmsAttachType, FileUploadDTO imageDTO, Collection<FileUploadField> extraFields) 
					throws IOException, Exception
	{
		FileCollectionDTO[] response;
		FileCollectionDTO restServiceFileDTO;
		FileCollectionDTO restServiceFileIconDTO;
		FileUploadDTO iconDTO = null;
		if (cmsAttachType.getIconscaling() != null)
		{
			FileUploadProcessingImageConfig cfg = new FileUploadProcessingImageConfig(cmsAttachType.getIconscaling());
			iconDTO = imageDTO.getIcon(cfg.getMaxWidth(), cfg.getMaxHeight());					
		}

		if (cmsAttachType.getImagescaling() != null)
		{
			FileUploadProcessingImageConfig cfg = new FileUploadProcessingImageConfig(cmsAttachType.getImagescaling());
			imageDTO.scale(cfg.getMaxWidth(), cfg.getMaxHeight());
		}

		restServiceFileDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), imageDTO, senv.getRequestSiteId(),
				senv.getRequestLanguage(),  mainEntityId, ambitId, subambitId, fileStatus, FileUploadDTO.FileUploadDTO_FileRole.image, cmsAttachType.getAttachtypeid(),
				null, extraFields);
		
		if (iconDTO != null)
		{
			restServiceFileIconDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), iconDTO, senv.getRequestSiteId(),
					senv.getRequestLanguage(),  mainEntityId, ambitId, subambitId, fileStatus, FileUploadDTO.FileUploadDTO_FileRole.icon, cmsAttachType.getAttachtypeid(),
					restServiceFileDTO.getFileid().toString(), extraFields);
			
			response = new FileCollectionDTO[2];
			response[0] = restServiceFileDTO;
			response[1] = restServiceFileIconDTO;
		}
		else
		{
			response = new FileCollectionDTO[1];
			response[0] = restServiceFileDTO;
		}
		return response;
	}

	private FileCollectionDTO[] 
			processFileUpload(PersistenceContext pcfg, AttachmentTypeDTO cmsAttachType, FileUploadDTO imageDTO, Collection<FileUploadField> extraFields) 
					throws IOException, Exception
	{
		FileCollectionDTO[] response;
		FileCollectionDTO restServiceFileDTO;
		
		restServiceFileDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), imageDTO, senv.getRequestSiteId(),
				senv.getRequestLanguage(),  mainEntityId, ambitId, subambitId, fileStatus, FileUploadDTO.FileUploadDTO_FileRole.file, cmsAttachType.getAttachtypeid(),
				null, extraFields);
		
		response = new FileCollectionDTO[1];
		response[0] = restServiceFileDTO;

		return response;
	}

	private FileCollectionDTO mongoStoreFile(
			MongoPersistenceContext pcfg, FileUploadDTO aFile, 
			String site, String aLanguage,  String aMainEntityId, String anAmbitId, String aSubAmbitId,
			FileCollectionDTO.FileStatus aFileStatus, 
			FileUploadDTO_FileRole documentMajorRole, String documentMinorRole, String masterFileId, 			
			Collection<FileUploadField> collection) throws Exception
	{
		FileCollectionDTO doc = new FileCollectionDTO();
		doc.setContenttype(aFile.getContentType());
		doc.setName(aFile.getUploadFileName());
		doc.setWidth(aFile.getImageWidth());
		doc.setHeight(aFile.getImageHeight());

		doc.setMajorrole(documentMajorRole.toString());
		doc.setMinorrole(documentMinorRole);

		doc.setSite(site);
		doc.setLanguage(aLanguage);
		doc.setRefmainentity(aMainEntityId);
		
		doc.setRefambit(anAmbitId);
		doc.setRefsubambit(aSubAmbitId);

		doc.setStatus(aFileStatus.toString());
		
		doc.setMasterfile(masterFileId);
		byte[] filedata = aFile.getFileInputStreamAsByteArray();
		// BsonBinary bin = new BsonBinary(BsonBinarySubType.BINARY, filedata);
		org.bson.types.Binary bin = new org.bson.types.Binary(BsonBinarySubType.BINARY, filedata);
		doc.setData(bin);
		doc.setSize(filedata.length);

		FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(pcfg);
		dp.insert(doc, pcfg.getDatastore(MongoDbSchemaInfo.MongoDbName));

		return doc;
	}

}
