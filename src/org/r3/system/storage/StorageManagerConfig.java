package org.r3.system.storage;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.system.storage.StorageManager.StorageManagerType;

public abstract class StorageManagerConfig
{
	private static final String DEFAULT_STORAGE = "default_storage";
	
	private StorageManagerType storageManagerType;
    private String tenantName;
    private String tenantId;
	private String region;
	private String container;
	
	private String authUrl;
	private String authUser;
	private String authPassword;
	
	private String publicUrlPattern;
	
	public StorageManagerConfig()
	{

	}

	public StorageManagerType getStorageManagerType()
	{
		return storageManagerType;
	}

	public void setStorageManagerType(StorageManagerType storageManagerType)
	{
		this.storageManagerType = storageManagerType;
	}

	public String getTenantName()
	{
		return tenantName;
	}

	public void setTenantName(String tenantName)
	{
		this.tenantName = tenantName;
	}

	public String getTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String tenantId)
	{
		this.tenantId = tenantId;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public String getContainer()
	{
		return container;
	}

	public void setContainer(String container)
	{
		this.container = container;
	}

	public String getAuthUrl()
	{
		return authUrl;
	}

	public void setAuthUrl(String authUrl)
	{
		this.authUrl = authUrl;
	}

	public String getAuthUser()
	{
		return authUser;
	}

	public void setAuthUser(String authUser)
	{
		this.authUser = authUser;
	}

	public String getAuthPassword()
	{
		return authPassword;
	}

	public void setAuthPassword(String authPassword)
	{
		this.authPassword = authPassword;
	}

	public String getPublicUrlPattern()
	{
		return publicUrlPattern;
	}

	public void setPublicUrlPattern(String publicUrlPattern)
	{
		this.publicUrlPattern = publicUrlPattern;
	}

	public static StorageManagerConfig readStorageManagerConfigFor(PersistenceContext pcfg, SqlSession aSession, String aSite, StorageManagerType aStorageManagerType)
	{
		StorageManagerConfig config = null;
		
		switch(aStorageManagerType)
		{
		case dms:
			config = new DMSStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		case mongo:
			config = new MongoStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		case swift:
			config = new OpenStackStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		}
		
		return config;
	}
	
	public static StorageManagerConfig readStorageManagerConfigFor(PersistenceContext pcfg, SqlSession aSession, String aSite)
	{
		StorageManagerConfig config = null;
		
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null); 
		
		// Mantengo il default a dms per evitare regressioni.
		StorageManagerType smt = StorageManagerType.getStorageManagerType4(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage, DEFAULT_STORAGE), StorageManagerType.dms);
		switch(smt)
		{
		case dms:
			config = new DMSStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		case mongo:
			config = new MongoStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		case swift:
			config = new OpenStackStorageManagerConfig();
			config.readStorageManagerConfig(pcfg, aSession, aSite);
			break;
		}
		
		return config;
	}
	
	public abstract void readStorageManagerConfig(PersistenceContext pcfg, SqlSession aSession, String aSite);
	
}
