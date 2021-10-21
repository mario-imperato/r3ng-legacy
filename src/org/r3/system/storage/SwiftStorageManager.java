package org.r3.system.storage;

import java.nio.file.Path;
import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import org.r3.db.PersistenceContext;

public class SwiftStorageManager extends StorageManager
{
	private Account account;
	
	public SwiftStorageManager(PersistenceContext pcfg, SqlSession aSession)
	{
	    AccountConfig config = new AccountConfig();
	    config.setUsername("g2wtN9sG9tCw");
        config.setPassword("SX9kKEeX6gzT4Uf2ZdfPmzjYQHphxYNp");
        config.setAuthUrl("https://auth.cloud.ovh.net:443/v2.0/tokens");
        config.setTenantId("9d330e4c0c664a29ba2af18c85c3643f");
        // config.setTenantName("7199807864697207");
        config.setPreferredRegion("GRA3");
        config.setAuthenticationMethod(AuthenticationMethod.KEYSTONE);
        
        account = new AccountFactory(config).createAccount();
        
	}

	@Override
	public StorageObject newStorageObjectInstance()
	{
		return new OpenStackStorageObject();
	}

	@Override
	public StorageObject put(Path aFolderPath, StorageObject anObject) throws StorageException
	{
		Collection<Container> containers = account.list();
	    for (Container currentContainer : containers) {
	        System.out.println(currentContainer.getName());
	    }
	    
		OpenStackStorageObject storageObject = (OpenStackStorageObject)anObject;
		
		Container container = account.getContainer("c1");
		StoredObject object = container.getObject(aFolderPath.resolve(anObject.getName()).toString());
	    object.uploadObject(anObject.getData());
	    System.out.println("Public URL: "+object.getPublicURL());
	    storageObject.setPublicUrl(object.getPublicURL());
		return null;
	}

	@Override
	public StorageObject get(StorageUrl aUrl) throws StorageException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
