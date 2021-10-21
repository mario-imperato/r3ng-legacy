package org.r3.ws.orc.sailorservices.certificates;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileinput.FileInputPattern;
import org.r3.system.rest.fileinput.FileUploadActionForm;
import org.r3.system.rest.fileinput.FileUploadDTO;
import org.r3.system.rest.fileinput.FileUploadDTO.FileUploadDTO_FileRole;
import org.r3.system.rest.fileinput.FileUploadDTOFactory;
import org.r3.system.rest.fileinput.FileUploadField;
import org.r3.system.storage.StorageFactory;
import org.r3.system.storage.StorageManager;
import org.r3.system.storage.StorageObject;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;

public class RMSFileUpload_POST extends FileInputPattern
{

	public RMSFileUpload_POST(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String fileDataPart,
			String anAttachmentType, ResponseType aResponseType)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new FileUploadDTOFactory(), true, anAttachmentType, aResponseType);
	}

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

		StorageObject[] response = null;
		StorageObject restServiceFileDTO = null;
		StorageObject restServiceFileIconDTO = null;

		// for (int i = 0; i < numberOfFiles; i++)
		// {
		FileUploadDTO f = files.get(0);
		StorageObject r0 = null;
		try
		{
			response = processFileUpload(pcfg, aSession, f, actionForm.getFields());

			if (response != null)
			{
				r0 = response[0];
				f.setFileId(r0.getObjectid());
				f.setSize(r0.getSize());
				f.setFileName(r0.getName());

				StorageObject r1 = null;
				if (response.length > 1)
				{
					r1 = response[1];
				}
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new ServicePatternException(ex.getMessage());
		}
		// }

		switch (getResponseType())
		{
		case ckeditor:
			return new CKEditorOfFileUploadDTO(r0.getName(), r0.getRestUrl());

		default:
			// return files;
			ArrayOfFileUploadDTO arr = new ArrayOfFileUploadDTO();
			arr.setFiles(files);
			return arr;
		}
	}

	private StorageObject[] processFileUpload(PersistenceContext pcfg, SqlSession aSession, FileUploadDTO imageDTO, Collection<FileUploadField> extraFields)
			throws IOException, Exception
	{
		StorageObject[] response;
		StorageObject restServiceFileDTO;

		restServiceFileDTO = storeFile(pcfg, aSession, imageDTO, senv.getRequestSiteDomain(), senv.getRequestSiteId(), senv.getRequestLanguage(),
				FileCollectionDTO.FileStatus.permanent, FileUploadDTO.FileUploadDTO_FileRole.file, "orc_rms", extraFields);

		response = new StorageObject[1];
		response[0] = restServiceFileDTO;

		return response;
	}

	// private FileCollectionDTO mongoStoreFile(
	// MongoPersistenceContext pcfg, FileUploadDTO aFile,
	// String site, String aLanguage,
	// FileCollectionDTO.FileStatus aFileStatus,
	// FileUploadDTO_FileRole documentMajorRole, String documentMinorRole,
	//
	// Collection<FileUploadField> collection) throws Exception
	// {
	// FileCollectionDTO doc = new FileCollectionDTO();
	// doc.setContenttype(aFile.getContentType());
	// doc.setName(aFile.getUploadFileName());
	// doc.setWidth(aFile.getImageWidth());
	// doc.setHeight(aFile.getImageHeight());
	//
	// doc.setMajorrole(documentMajorRole.toString());
	// doc.setMinorrole(documentMinorRole);
	//
	// doc.setSite(site);
	// doc.setLanguage(aLanguage);
	//
	// doc.setStatus(aFileStatus.toString());
	//
	// byte[] filedata = aFile.getFileInputStreamAsByteArray();
	// // BsonBinary bin = new BsonBinary(BsonBinarySubType.BINARY, filedata);
	// org.bson.types.Binary bin = new
	// org.bson.types.Binary(BsonBinarySubType.BINARY, filedata);
	// doc.setData(bin);
	// doc.setSize(filedata.length);
	//
	// FileCollectionPersistence dp =
	// FileCollectionPersistence.createPersistenceObject(pcfg);
	// dp.insert(doc, pcfg.getDatastore(MongoDbSchemaInfo.MongoDbName));
	//
	// return doc;
	// }

	private StorageObject storeFile(PersistenceContext pcfg, SqlSession aSession, FileUploadDTO aFile, 
			String siteDomain, String site, String aLanguage,
			FileCollectionDTO.FileStatus aFileStatus, FileUploadDTO_FileRole documentMajorRole, String documentMinorRole,

			Collection<FileUploadField> collection) throws Exception
	{
		StorageManager storageManager = StorageFactory.newDefaultStorageManagerInstance(pcfg, aSession, siteDomain);
		StorageObject storageObject = storageManager.newStorageObjectInstance();

		storageObject.setContenttype(aFile.getContentType());
		storageObject.setName(aFile.getUploadFileName());
		storageObject.setWidth(aFile.getImageWidth());
		storageObject.setHeight(aFile.getImageHeight());

		storageObject.setMajorrole(documentMajorRole.toString());
		storageObject.setMinorrole(documentMinorRole);

		storageObject.setSite(site);
		storageObject.setLanguage(aLanguage);

		storageObject.setStatus(aFileStatus.toString());

		byte[] filedata = aFile.getFileInputStreamAsByteArray();

		storageObject.setData(filedata);
		storageObject.setSize(filedata.length);
		storageObject = storageManager.put(Paths.get(site, "RMS"), storageObject);

		return storageObject;
	}


}
