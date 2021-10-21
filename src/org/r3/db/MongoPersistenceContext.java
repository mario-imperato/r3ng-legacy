package org.r3.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoPersistenceContext
{
    private HashMap<String, org.mongodb.morphia.Datastore> dataStoreMaps = new HashMap<String, org.mongodb.morphia.Datastore>();
    private Properties mongoProperties = null;
    private MongoClient mongoClient;
    private Morphia morphia = null;
    
    public MongoPersistenceContext(String mongoPropertiesFileName) throws IOException
    {    	
    	mongoProperties = loadProperties(mongoPropertiesFileName);
    	mongoClient = getClient();	
    	
    	initializeDatastores();
    }    

	public void shutdownMongoDb()
	{
		if (mongoClient != null)
		    mongoClient.close();
	}
	
	public MongoClient getMongoDbClient()
	{
		return mongoClient;
	}
	
	public boolean isMongoDbAvailable()
	{
		return mongoClient != null;
	}
	
	public Datastore getDatastore(String aDatastoreName) throws RuntimeException
	{
		Datastore ds = dataStoreMaps.get(aDatastoreName);
		if (ds == null)
			throw new RuntimeException(String.format("Morphia: DataStore %s Not Configured", aDatastoreName));
		
		return ds;
	}
	
	private MongoClient getClient()
	{
		try
		{
			String murl = mongoProperties.getProperty("mongoDBUrl");
			if (murl != null)
			{
			    MongoClientURI curi = new MongoClientURI(murl);	
			    return new MongoClient(curi);
			}
						
		}
		catch (Exception uh)
		{
			uh.printStackTrace();
		}
		
		return null;
	}

    private Properties loadProperties(String aResourceFile) throws IOException 
    {
        Properties properties = new Properties();        
        Reader r = CascadingClassLoadHelper.getInstance().getFileOrResourceAsReader(aResourceFile);  
      
        if (r == null) 
        {
            throw new FileNotFoundException(String.format("Mongo Resource File %s Not Loaded!", aResourceFile));
        }
        
        properties.load(r);       
        return properties;
    }
    
    private int initializeDatastores()
    {
    	int numberOfInitializedDataStores = 0;
    	
    	if (mongoProperties != null)
    	{
    		String ds = mongoProperties.getProperty("morphiaDatastores");
    		if (ds != null)
    		{
    			morphia = new Morphia();
    			String[] datastores = ds.split(" ");
    			if (datastores != null && datastores.length > 0)
    			{
    				for(String n : datastores)
    				{
    					Datastore d = morphia.createDatastore(mongoClient, n);
    					dataStoreMaps.put(n, d);
    					
    					numberOfInitializedDataStores++;
    				}
    			}
    		}    		
    	}
    	
    	return numberOfInitializedDataStores;    	    	
    }
    

}
