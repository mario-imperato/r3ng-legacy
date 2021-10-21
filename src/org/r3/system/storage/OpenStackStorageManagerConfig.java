package org.r3.system.storage;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.system.storage.StorageManager.StorageManagerType;

public class OpenStackStorageManagerConfig extends StorageManagerConfig
{
	private static final String SWIFT_TENANTNAME = "tenantname";
	private static final String SWIFT_TENANTID = "tenantid";
	private static final String SWIFT_REGION = "region";
	private static final String SWIFT_CONTAINER = "container";
	private static final String SWIFT_AUTHURL = "authurl"; 
	private static final String SWIFT_AUTHUSER = "authuser";
	private static final String SWIFT_AUTHPASSWORD = "authpassword";
	private static final String SWIFT_PUBLICURLPATTERN = "publicurlpattern";
	
	
	public OpenStackStorageManagerConfig()
	{
		setStorageManagerType(StorageManagerType.swift);
	}

	@Override
	public void readStorageManagerConfig(PersistenceContext pcfg, SqlSession aSession, String aSite)
	{		
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null); 
		
		setTenantName(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_TENANTNAME));
		setTenantId(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_TENANTID));
		setRegion(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_REGION));
		setContainer(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_CONTAINER));
		setAuthUrl(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_AUTHURL));
		setAuthUser(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_AUTHUSER));
		setAuthPassword(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_AUTHPASSWORD));
		setPublicUrlPattern(sitePropertyLut.getDtodescr(aSite, PropertyScope.storage.toString() + ".swift", SWIFT_PUBLICURLPATTERN));		
	}

	public String getPublicUrl4(String fileName)
	{
		// https://storage.gra3.cloud.ovh.net/v1/AUTH_9d330e4c0c664a29ba2af18c85c3643f/c1/MWDSP_Installazione_2.0.docx
		String s = String.format(getPublicUrlPattern(), getTenantId(), getContainer(), fileName);
		return s;
	}
}
