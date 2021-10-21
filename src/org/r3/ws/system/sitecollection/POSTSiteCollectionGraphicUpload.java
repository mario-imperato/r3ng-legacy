package org.r3.ws.system.sitecollection;

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
import org.r3.db.mongo.MongoImageDTO;
import org.r3.db.mongo.MongoImageDTO.MongoImageRole;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO.SiteImageRole;
import org.r3.db.mongo.sitecollection.SiteCollectionPersistence;
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

public class POSTSiteCollectionGraphicUpload extends FileInputPattern
{
    private String theSite;

	public POSTSiteCollectionGraphicUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aTheSite,
			MultipartFormDataInput input, String fileDataPart, String anAttachmentType, ResponseType aResponseType)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory(), true, anAttachmentType, aResponseType);
		theSite = aTheSite;
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
		
		SiteCollectionPersistence sitePersistence = SiteCollectionPersistence.createPersistenceObject(mctx);
		SiteCollectionDTO siteDTO = sitePersistence.selectBySite(mongoDatastore, theSite);

		boolean isSiteInsert = false;
		if (siteDTO == null)
		{
			siteDTO = new SiteCollectionDTO();
			siteDTO.setSite(theSite);

			isSiteInsert = true;
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

		AttachmentTypeDTO cmsAttachType = actionForm.retrieveAttachmentTypeDTO(theSite);
		if (cmsAttachType == null)
		{
			throw new ServicePatternException("Type Of File Expected...");
		}

		SiteImageRole imageMinorRole = SiteImageRole.getValue4(cmsAttachType.getAttachtypeid(), SiteImageRole.sitesquared);
		
		ArrayOfRestServiceFileDTO response = new ArrayOfRestServiceFileDTO();
		RestServiceFileDTO restServiceFileDTO = null;
		RestServiceFileDTO restServiceFileIconDTO = null;

		for (int i = 0; i < numberOfFiles; i++)
		{
			FileUploadDTO f = files.get(i);

			if (!f.isImage())
				throw new ServicePatternException("File Type Not Allowed in this context");

			MongoImageDTO siteGraphicImageDTO = null, siteGraphicIconDTO = null;			
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

				restServiceFileDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), imageDTO, theSite,
						senv.getRequestLanguage(), theSite, FileUploadDTO.FileUploadDTO_FileRole.image, cmsAttachType.getAttachtypeid(),
						null, actionForm.getFields());

				siteGraphicImageDTO = new MongoImageDTO();
				siteGraphicImageDTO.setImageid(restServiceFileDTO.getFileId());
				siteGraphicImageDTO.setHeight(imageDTO.getImageHeight());
				siteGraphicImageDTO.setWidth(imageDTO.getImageWidth());
				siteGraphicImageDTO.setMajorRole(MongoImageRole.image.toString());
				siteGraphicImageDTO.setMinorRole(SiteImageRole.getValue4(cmsAttachType.getAttachtypeid(), SiteImageRole.sitesquared).toString());
				siteGraphicImageDTO.setUrl(restServiceFileDTO.getFileurl());
				
				if (iconDTO != null)
				{
					restServiceFileIconDTO = mongoStoreFile(pcfg.getMongoPersistenceContext(), iconDTO, theSite,
							senv.getRequestLanguage(), theSite, FileUploadDTO.FileUploadDTO_FileRole.icon, cmsAttachType.getAttachtypeid(),
							restServiceFileDTO.getFileId(), actionForm.getFields());
					
					siteGraphicIconDTO = new MongoImageDTO();
					siteGraphicIconDTO.setImageid(restServiceFileIconDTO.getFileId());
					siteGraphicIconDTO.setHeight(iconDTO.getImageHeight());
					siteGraphicIconDTO.setWidth(iconDTO.getImageWidth());
					siteGraphicIconDTO.setMajorRole(MongoImageRole.icon.toString());
					siteGraphicIconDTO.setMinorRole(imageMinorRole.toString());
					siteGraphicIconDTO.setUrl(restServiceFileIconDTO.getFileurl());					
				}

				System.out.println("RestServiceFileDTO: " + restServiceFileDTO.getFileurl());
				response.addRestServiceFileDTO(restServiceFileDTO);

				MongoImageDTO currentPhoto = siteDTO.getPhotoByRole(MongoImageRole.image, imageMinorRole);
				if (currentPhoto != null)
				{
					FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(mctx);
					int numberOfRemovals = dp.removeByUrl(currentPhoto.getUrl(), mongoDatastore);
					System.out.println("Number Of Removals..." + numberOfRemovals);
					
					siteDTO.removePhotoByMinorRole(imageMinorRole);
				}
				
				MongoImageIconDTO imageIconDTO = new MongoImageIconDTO();
				imageIconDTO.setImageiconid(siteGraphicImageDTO.getImageid());					
				imageIconDTO.setImagerole(siteGraphicImageDTO.getMinorRole());
				imageIconDTO.setImage(siteGraphicImageDTO);
				imageIconDTO.setIcon(siteGraphicIconDTO);				
				siteDTO.addGraphics(imageIconDTO);
				
				if (isSiteInsert)
				{									
					siteDTO.setLastmodified(new java.util.Date());
					sitePersistence.insert(siteDTO, mctx.getDatastore(MongoDbSchemaInfo.MongoDbName));
				}
				else
				{
					UpdateOperations<SiteCollectionDTO> uop = mongoDatastore.createUpdateOperations(SiteCollectionDTO.class);

					uop.set(SiteCollectionDTO.GRAPHICS, siteDTO.getGraphics());
					
//					if (siteGraphicIconDTO != null)
//					      siteDTO.setGraphics4UpdateV(uop, siteGraphicImageDTO, siteGraphicIconDTO);
//					else  siteDTO.setGraphics4UpdateV(uop, siteGraphicImageDTO);
					
					
					siteDTO.setLastmodified4Update(uop, new java.util.Date());
					siteDTO.add2setSections4Update(uop, "photo");
					
					Datastore ds = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
					sitePersistence.updateBySite(ds, uop, theSite, true);
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
