package org.r3.ws.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GETTest extends ServicePattern
{    
	public GETTest(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
    	MongoDatabase database = pcfg.getMongoDbClient().getDatabase("students");
    	MongoCollection<org.bson.Document> collection = database.getCollection("grades");

    	
    	
    	List<org.bson.Document> listOf = collection.find().into(new ArrayList<org.bson.Document>());
    	
    	List<Client> typedList = null;
    	if (listOf != null)
    	{
    		typedList = new ArrayList<Client>();
        	for(org.bson.Document d : listOf)
        	{
        		System.out.println(d.toJson());
        		typedList.add(new Client(d.getObjectId("_id"), d.getInteger("student_id")));
        	}    		
    	}    	
		
		return listOf;
	}

}
