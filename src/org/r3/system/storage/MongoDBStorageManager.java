package org.r3.system.storage;

import java.nio.file.Path;

import org.apache.ibatis.session.SqlSession;
import org.bson.BsonBinarySubType;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;

public class MongoDBStorageManager extends StorageManager
{
	private MongoPersistenceContext mctx;
	public MongoDBStorageManager(PersistenceContext pcfg, SqlSession aSession, StorageManagerConfig aConfig)
	{
		mctx = pcfg.getMongoPersistenceContext();
		setStorageManagerConfig(aConfig);
	}

	@Override
	public StorageObject newStorageObjectInstance()
	{
		return new MongoDBStorageObject();
	}

	@Override
	public StorageObject put(Path aFolderPath, StorageObject anObject)
	{
		FileCollectionDTO doc = new FileCollectionDTO();

		doc.setContenttype(anObject.getContenttype());
		doc.setName(anObject.getName());
		doc.setWidth(anObject.getWidth());
		doc.setHeight(anObject.getHeight());

		doc.setMajorrole(anObject.getMajorrole());
		doc.setMinorrole(anObject.getMinorrole());

		doc.setSite(anObject.getSite());
		doc.setLanguage(anObject.getLanguage());
		doc.setStatus(anObject.getStatus());
		
		byte[] bdata = anObject.getData();
		org.bson.types.Binary bin = new org.bson.types.Binary(BsonBinarySubType.BINARY, bdata);
		doc.setData(bin);
		doc.setSize(bdata.length);

		FileCollectionPersistence dp = FileCollectionPersistence.createPersistenceObject(mctx);
		dp.insert(doc, mctx.getDatastore(MongoDbSchemaInfo.MongoDbName));
		
		anObject.setObjectid(doc.getFileid().toHexString());
		return anObject;
	}

	@Override
	public StorageObject get(StorageUrl aUrl)
	{
		return null;
	}

}
