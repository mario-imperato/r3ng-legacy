package org.r3.ws.user.usercollection;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.bson.BsonBinarySubType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionDTOBase.PhotoDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
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

public class POSTUserCollectionPhotoUpload extends FileInputPattern
{
	private String userId;

	public POSTUserCollectionPhotoUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId,
			MultipartFormDataInput input, String fileDataPart, String anAttachmentType, ResponseType responseType)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory(), true, anAttachmentType, responseType);
		userId = aUserId;
	}

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
		
		UserCollectionPersistence up = UserCollectionPersistence.createPersistenceObject(mctx);
		UserCollectionDTO u = up.selectByUserid(mongoDatastore, userId);

		boolean isUserInsert = false;
		if (u == null)
		{
			u = new UserCollectionDTO();
			u.setUserid(userId);

			isUserInsert = true;
			// throw new ServicePatternException("User not found for: " +
			// userId);
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

		for (int i = 0; i < numberOfFiles; i++)
		{
			FileUploadDTO f = files.get(i);

			if (!f.isImage())
				throw new ServicePatternException("File Type Not Allowed in this context");

			PhotoDTO userPhoto = null, userPhotoIcon = null;			
			FileUploadDTO imageDTO =  f;
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

				restServiceFileDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), imageDTO, senv.getRequestSiteId(),
						senv.getRequestLanguage(), userId, FileUploadDTO.FileUploadDTO_FileRole.image, cmsAttachType.getAttachtypeid(),
						null, actionForm.getFields());

				userPhoto = new PhotoDTO();
				userPhoto.setHeight(imageDTO.getImageHeight());
				userPhoto.setWidth(imageDTO.getImageWidth());
				userPhoto.setRole("image");
				userPhoto.setUrl(restServiceFileDTO.getFileurl());
				
				if (iconDTO != null)
				{
					restServiceFileIconDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), iconDTO, senv.getRequestSiteId(),
							senv.getRequestLanguage(), userId, FileUploadDTO.FileUploadDTO_FileRole.icon, cmsAttachType.getAttachtypeid(),
							restServiceFileDTO.getFileId(), actionForm.getFields());
					
					userPhotoIcon = new PhotoDTO();
					userPhotoIcon.setHeight(iconDTO.getImageHeight());
					userPhotoIcon.setWidth(iconDTO.getImageWidth());
					userPhotoIcon.setRole("icon");
					userPhotoIcon.setUrl(restServiceFileIconDTO.getFileurl());					
				}

				System.out.println("RestServiceFileDTO: " + restServiceFileDTO.getFileurl());
				response.addRestServiceFileDTO(restServiceFileDTO);

				PhotoDTO currentPhoto = u.getPhotoByRole(MongoImageRole.image);
				if (currentPhoto != null)
				{
					FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(mctx);
					int numberOfRemovals = dp.removeByUrl(currentPhoto.getUrl(), mongoDatastore);
					System.out.println("Number Of Removals..." + numberOfRemovals);
				}

				if (isUserInsert)
				{
					u.addPhoto(userPhoto);
					if (userPhotoIcon != null)
						u.addPhoto(userPhotoIcon);
					
					u.setLastmodified(new java.util.Date());
					u.addSections("photo");
					up.insert(u, mctx.getDatastore(MongoDbSchemaInfo.MongoDbName));
				}
				else
				{
					UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
					if (userPhotoIcon != null)
					      u.setPhoto4UpdateV(uop, userPhoto, userPhotoIcon);
					else  u.setPhoto4UpdateV(uop, userPhoto);
					u.setLastmodified4Update(uop, new java.util.Date());
					u.add2setSections4Update(uop, "photo");
					
					Datastore ds = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
					up.updateByUserid(ds, uop, userId, true);
				}
			
				LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);

			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				throw new ServicePatternException(ex.getMessage());
			}
		}

		if (isIE())
			return serializeFiles(files);

		return response;
	}

	private RestServiceFileDTO mongoStoreFile(MongoPersistenceContext pcfg, FileUploadDTO aFile, String site, String aLanguage,
			String refEntity, FileUploadDTO_FileRole documentMajorRole, String documentMinorRole, String masterFileId,
			Collection<FileUploadField> collection) throws Exception
	{
		// MongoClient c = pcfg.getMongoDbClient();
		// MongoDatabase db = c.getDatabase("regatta3");
		// MongoCollection<BsonDocument> coll = db.getCollection("userphoto",
		// BsonDocument.class);
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
		// BsonBinary bin = new BsonBinary(BsonBinarySubType.BINARY, filedata);
		org.bson.types.Binary bin = new org.bson.types.Binary(BsonBinarySubType.BINARY, filedata);
		doc.setData(bin);
		doc.setSize(filedata.length);

		FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(pcfg);
		dp.insert(doc, pcfg.getDatastore(MongoDbSchemaInfo.MongoDbName));

		restServiceFileDTO.setFileId(doc.getFileid().toString());
		restServiceFileDTO.setFileurl(doc.getUrl());

		return restServiceFileDTO;
	}

}
