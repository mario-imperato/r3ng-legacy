package org.r3.db.mongo.script;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.MongoDbSchemaInfo;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoDatabase;

public class MongoSimpleImport
{

private static Logger logger = LoggerFactory.getLogger(MongoSimpleImport.class);   
	
	public static MongoSimpleImport createPersistenceObject(
					VelocityTemplateModel m, String aTemplateName)
	{
		MongoSimpleImport p = new MongoSimpleImport(m, aTemplateName, ";");
		return p;
	}

	protected String statementSeparator = ";";	
	
	protected String templateName = null;
    protected VelocityTemplateRenderer renderer     = null;

    public MongoSimpleImport(VelocityTemplateModel m, String aTemplateName, String aStatementSeparator)
    {
    	templateName = aTemplateName;
        renderer = m.newRendererInstance(aTemplateName, null);
        statementSeparator = aStatementSeparator;
        // addParameter("jdbcSQLHelper", cn.getJDBCSQLHelper());
    }

    public void addParameter(String paramName, Object paramValue)
    {
        renderer.add(paramName, paramValue);    
    }
    
    public void setStatementSeparator(String s)
    {
    	statementSeparator = s;
    }
    
    public int[] execute(org.r3.db.MongoPersistenceContext pcfg)
    {
    	    logger.debug("Executing: " + templateName);
    	    
    	    MongoDatabase db = pcfg.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
    	    
    	    List<MongoStatement> listOfStatements = getSQLStatements();
            if (listOfStatements != null && listOfStatements.size() > 0)
            {
            	int[] numberOfAffectedRows = new int[listOfStatements.size()];
                int statementNumber = 0;
            	for (MongoStatement statement : listOfStatements)
                {            		  
                     numberOfAffectedRows[statementNumber] = statement.execute(db);          
                     statementNumber++;
                }
            	
            	return numberOfAffectedRows;
            }
            
            return null;
    }

    
    protected List<MongoStatement> getSQLStatements() 
    {
    	MongoDirective activeDirective = null;
    	
    	String batchStatement;
		try
		{
			batchStatement = renderer.mergeTemplate();
	        String[] statements = batchStatement.split(statementSeparator);
	        if (statements == null || statements.length == 0)
	            return null;

	        List<MongoStatement> retStatements = new ArrayList<MongoStatement>(); 
	        for(int i = 0; i < statements.length; i++)
	        {
	        	String s = statements[i].replace('\n', ' ').replace('\r', ' ').trim();
	        	if (s.length() > 0)
	        	{	        	
	        		MongoDirective directive = (MongoDirective.getMongoDirective(s));
	        		if (directive != null)
	        		{
	        			activeDirective = directive;
	        		}
	        		else retStatements.add(new MongoStatement(activeDirective, s)); 
	        	}
	        }
	        
	        return retStatements;        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
    }
    
}
