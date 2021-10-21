package org.r3.ws.user.user;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.bson.BsonBinarySubType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFileHelper;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceFileDTO;
import org.r3.system.rest.RestServiceFileDTO.ArrayOfRestServiceFileDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileinput.FileInputPattern;
import org.r3.system.rest.fileinput.FileUploadActionForm;
import org.r3.system.rest.fileinput.FileUploadDTO;
import org.r3.system.rest.fileinput.FileUploadDTO.FileUploadDTO_FileRole;
import org.r3.system.rest.fileinput.FileUploadDTOFactory;
import org.r3.system.rest.fileinput.FileUploadField;
import org.r3.system.rest.fileinput.FileUploadProcessingImageConfig;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;



public class POSTUserPhotoUpload extends FileInputPattern
{
	private String userId;
	
	public POSTUserPhotoUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, MultipartFormDataInput input, String fileDataPart, String anAttachmentType, ResponseType responseType)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory(), true,  anAttachmentType, responseType);		
		userId = aUserId;
	}

//	@Override
//	protected FileUploadActionForm newFileUploadActionFormInstance()
//	{
//		return new CyberAlturaFileUploadActionForm();
//	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		
		UserPersistence up = UserPersistence.createPersistenceObject(pcfg, aSession);
		UserDTO u = up.selectByUserid(userId, pcfg.getPersistenceConfigInfo());
		if (u == null)
			throw new ServicePatternException("User not found for: " + userId);
		
		DMSContext dmsContext = null;
		if (!pcfg.isMongoDbAvailable())
		{
			dmsContext = new DMSContext(pcfg, aSession);
		}
		
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
		
		ArrayOfRestServiceFileDTO response = new ArrayOfRestServiceFileDTO();
		RestServiceFileDTO restServiceFileDTO = null;
		RestServiceFileDTO restServiceFileIconDTO = null;
		
		for(int i = 0; i < numberOfFiles; i++)
		{
			FileUploadDTO f = files.get(i);
					
		    if (!f.isImage())
				throw new ServicePatternException("File Type Not Allowed in this context");	
		    
		    FileUploadDTO imageDTO = f;
		    try
		    {		    	
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
		    			
		    	if (pcfg.isMongoDbAvailable())
		    	{
		    		restServiceFileDTO = mongoStoreFile(
		    				    pcfg.getMongoPersistenceContext(), imageDTO, 
		    				    senv.getRequestSiteId(), senv.getRequestLanguage(), userId,
		    				    FileUploadDTO.FileUploadDTO_FileRole.image, cmsAttachType.getAttachtypeid(), null, actionForm.getFields());	
		    		if (iconDTO != null)
		    		{
		    			restServiceFileIconDTO = mongoStoreFile(
		    					pcfg.getMongoPersistenceContext(), iconDTO,
		    					senv.getRequestSiteId(), senv.getRequestLanguage(), userId,
		    					FileUploadDTO.FileUploadDTO_FileRole.icon, cmsAttachType.getAttachtypeid(), restServiceFileDTO.getFileId(), actionForm.getFields());
		    		}
		    	}
				else
				{
					restServiceFileDTO = dmsStoreFile(dmsContext, imageDTO, actionForm.getFields());
					if (iconDTO != null)
		    		{
						restServiceFileIconDTO = dmsStoreFile(dmsContext, iconDTO, actionForm.getFields());
		    		}
				}
				    
		    	System.out.println("RestServiceFileDTO: " + restServiceFileDTO.getFileurl());		    	
		    	response.addRestServiceFileDTO(restServiceFileDTO);
		    			    	
		    	if (u.getUserphoto() != null)
		    	{
		    		if (pcfg.isMongoDbAvailable())
			    	{
		    			FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(mctx);
		    			int numberOfRemovals = dp.removeByUrl(u.getUserphoto(), mctx.getDatastore(MongoDbSchemaInfo.MongoDbName));
		    			System.out.println("Number Of Removals..." + numberOfRemovals);
			    	}
		    		else
		    		{
		    			DMSFileHelper.deleteDMSFile(dmsContext, u.getUserphoto());
		    		}
		    	}
		    	
		    	u.setUserphoto(restServiceFileDTO.getFileurl());
		    	up.updateByPrimaryKey(u, pcfg.getPersistenceConfigInfo());

		    	LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);

//		    	UserCollectionPersistence ucp = new UserCollectionPersistence();
//		    	UserCollectionDTO ucd = new UserCollectionDTO();
//		    	ucd.setUserid(userId);
//		    	
//		    	UserPictureDTO updto = new UserPictureDTO();
//		    	updto.setImageurl(restServiceFileDTO.getFileurl());
//		    	ucd.setPicture(updto);
//		    	
//		    	ucp.updateByUserid(pcfg.getMongoPersistenceContext(), ucd, true);
		    }
		    catch(Exception ex)
		    {
		    	ex.printStackTrace();
		    	throw new ServicePatternException(ex.getMessage());
		    }		    
		}
		
		if (isIE())
			return serializeFiles(files);

		return response;
	}

	private RestServiceFileDTO dmsStoreFile(DMSContext dmsContext, FileUploadDTO aFile, Collection<FileUploadField> collection) throws DMSException
	{
		RestServiceFileDTO restServiceFileDTO = null;
    	
		

		DMSFileSystemUrl url;

		DMSFolder docFolder = getFolder(dmsContext);


			if (docFolder != null && aFile != null)
			{
				restServiceFileDTO = storeFile(dmsContext, docFolder, aFile, true);
			}

		return restServiceFileDTO;
	}

	private DMSFolder getFolder(DMSContext dmsContext) throws DMSException
	{
		return DMSFolderHelper.getUserPhotoUploadFolder(dmsContext, userId);
	}

	private RestServiceFileDTO mongoStoreFile(
			MongoPersistenceContext pcfg, 
			FileUploadDTO aFile, 
			String site, String aLanguage, String refEntity,
			FileUploadDTO_FileRole documentMajorRole, String documentMinorRole, String masterFileId,
			Collection<FileUploadField> collection) throws Exception 
	{
//		MongoClient c = pcfg.getMongoDbClient();
//	    MongoDatabase db = c.getDatabase("regatta3");
//	    MongoCollection<BsonDocument> coll = db.getCollection("userphoto", BsonDocument.class);
		RestServiceFileDTO restServiceFileDTO = new RestServiceFileDTO();
		restServiceFileDTO.setContentType(aFile.getContentType());
    	restServiceFileDTO.setSize(aFile.getSize());

			FileCollectionDTO doc = new FileCollectionDTO();
			doc.setContenttype(aFile.getContentType());
			doc.setName(aFile.getUploadFileName());
			doc.setWidth(aFile.getImageWidth());
			doc.setHeight(aFile.getImageHeight());
	        
			doc.setMajorrole(documentMajorRole.toString());
			doc.setMinorrole(documentMinorRole);
			
			doc.setSite(site);
			doc.setLanguage(aLanguage);
			doc.setRefmainentity(refEntity);
			
			doc.setMasterfile(masterFileId);
	        byte[] filedata = aFile.getFileInputStreamAsByteArray();
//	        BsonBinary bin = new BsonBinary(BsonBinarySubType.BINARY, filedata);
	        org.bson.types.Binary bin = new org.bson.types.Binary(BsonBinarySubType.BINARY, filedata);
	        doc.setData(bin);
	        doc.setSize(filedata.length);
	        
	        
	        FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(pcfg);
	        dp.insert(doc, pcfg.getDatastore(MongoDbSchemaInfo.MongoDbName));
	        
	        restServiceFileDTO.setFileId(doc.getFileid().toString());
	        restServiceFileDTO.setFileurl(doc.getUrl());
	        
//	        BsonDocument d = newBsonDocument(uploadedFile);
//	        if (cmsAttachType != null)
//		        d.append("filerole", new BsonString(cmsAttachType.getAttachtypeid()));
//	        	        	       
//	        
//	        Map<String, FileUploadDTO> refFiles = uploadedFile.getRefFiles();
//	        if (refFiles != null && refFiles.size() > 0)
//	        {
//	        	List<BsonDocument> listOfRefFiles = new ArrayList<BsonDocument>();
//	        	for(String r : refFiles.keySet())
//	        	{
//	        		BsonDocument d1 = new BsonDocument(r, newBsonDocument(refFiles.get(r)));
//	        		listOfRefFiles.add(d1);
//	        	}
//	        	
//	        	d.append("files", new BsonArray(listOfRefFiles));
//	        }
//	        
//	        coll.insertOne(d);
//	        
//	        System.out.println("Added File to DB. With Id: " + ((BsonObjectId)d.get("_id")).getValue());	        	        
//	        String fileId = ((BsonObjectId)d.get("_id")).getValue().toString();
//	        uploadedFile.setFileId(fileId);
//	        uploadedFile.setFileurl("repo://regatta3/userphoto/" + fileId + "." + ContentTypeUtil.findExtensionByMimeType(contentType));		        
		
		return restServiceFileDTO;
	}

//	private BsonDocument newBsonDocument(FileUploadDTO uploadedFile) throws IOException
//	{
//		String contentType = uploadedFile.getContentType();
//		
//        BsonDocument d = new BsonDocument();       
//        	
//        d.append("contenttype", new BsonString(contentType));
//        d.append("name", new BsonString(uploadedFile.getUploadFileName()));
//        d.append("width", new BsonInt32(uploadedFile.getImageWidth()));
//        d.append("height", new BsonInt32(uploadedFile.getImageHeight()));
//        
//        byte[] filedata = uploadedFile.getFileInputStreamAsByteArray();
//        BsonBinary bin = new BsonBinary(BsonBinarySubType.BINARY, filedata);
//        d.append("data", bin);
//        d.append("filesize", new BsonInt32(filedata.length));
//        	       
//        return d;
//	}
}
