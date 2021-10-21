package org.r3.system.storage;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;

import org.apache.ibatis.session.SqlSession;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Payloads;
import org.openstack4j.model.storage.object.SwiftAccount;
import org.openstack4j.openstack.OSFactory;
import org.r3.db.PersistenceContext;

public class OpenStackStorageManager extends StorageManager
{
	private static final String OPENSTACK_PREFERREDREGION = "GRA3";
	private static final String OPENSTACK_TENANTNAME = "7199807864697207";
	private static final String OPENSTACK_TENANTID = "9d330e4c0c664a29ba2af18c85c3643f";
	private static final String OPENSTACK_AUTHURL = "https://auth.cloud.ovh.net:443/v2.0";
	private static final String OPENSTACK_PASSWORD = "SX9kKEeX6gzT4Uf2ZdfPmzjYQHphxYNp";
	private static final String OPENSTACK_USERNAME = "g2wtN9sG9tCw";
	

	private OSClient os;
	private SwiftAccount account;
	
	public OpenStackStorageManager(PersistenceContext pcfg, SqlSession aSession, StorageManagerConfig aConfig)
	{
		setStorageManagerConfig(aConfig);
		
        os = OSFactory.builderV2()
                .endpoint(aConfig.getAuthUrl())
                .credentials(aConfig.getAuthUser(), aConfig.getAuthPassword())
                .tenantName(aConfig.getTenantName())
                .authenticate();                
        
        SwiftAccount account = os.objectStorage().account().get();

        if (aConfig.getRegion() != null)
             os.useRegion(aConfig.getRegion());
        
//        List<? extends SwiftContainer> containers = os.objectStorage().containers().list();
//        for(SwiftContainer sw : containers)
//        {
//        	System.out.println("Container: " + sw.toString());
//        }
	}

	@Override
	public OpenStackStorageManagerConfig getStorageManagerConfig()
	{
		return (OpenStackStorageManagerConfig)super.getStorageManagerConfig();
	}
	
	@Override
	public StorageObject newStorageObjectInstance()
	{
		return new OpenStackStorageObject();
	}

	@Override
	public StorageObject put(Path aFolderPath, StorageObject anObject) throws StorageException
	{			    
		OpenStackStorageObject storageObject = (OpenStackStorageObject)anObject;
		
		String fileName = wellFormFileName(aFolderPath.resolve(anObject.getName()).toString(), true);
		String etag = os.objectStorage().objects().put(getStorageManagerConfig().getContainer(), fileName, Payloads.create(new ByteArrayInputStream(anObject.getData())));
		System.out.println("ETag: "+etag);
		
		storageObject.setPublicUrl(getStorageManagerConfig().getPublicUrl4(fileName));

//	    
//	    System.out.println("Public URL: "+object.getPublicURL());
//	    storageObject.setPublicUrl(object.getPublicURL());
		return storageObject;
	}

	@Override
	public StorageObject get(StorageUrl aUrl) throws StorageException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
