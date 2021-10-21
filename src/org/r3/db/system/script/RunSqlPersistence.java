package org.r3.db.system.script;

import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RunSqlPersistence
{	
	private static Logger logger = LoggerFactory.getLogger(RunSqlPersistence.class);
	
	public static RunSqlPersistence createPersistenceObject(
					org.apache.ibatis.session.SqlSession aSession,
					VelocityTemplateModel m, String aTemplateName)
	{
		RunSqlPersistence p = new RunSqlPersistence(m, aTemplateName, ";");
		return p;
	}

	protected String statementSeparator = ";";
	
	protected String templateName = null;
    protected VelocityTemplateRenderer renderer     = null;

    public RunSqlPersistence(VelocityTemplateModel m, String aTemplateName, String aStatementSeparator)
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
    
    public int[] execute(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
    {
    	    logger.debug("Executing: " + templateName);
    	    
    	    boolean autoCommit = false;
            SQLStatement[] listOfStatements = getSQLStatements();
            if (listOfStatements != null && listOfStatements.length > 0)
            {
            	int[] numberOfAffectedRows = new int[listOfStatements.length];

            	for (int i = 0; i < listOfStatements.length; i++)
                {            		  
                     numberOfAffectedRows[i] = listOfStatements[i].execute(pcfg, aSession);
                     if (listOfStatements[i].isAutoCommitOn())
                     {
                    	 autoCommit = true;	 
                     }
                     else if (listOfStatements[i].isAutoCommitOff())
                     {
                    	 autoCommit = false;	 
                     }
                     else
                     {
                         if (autoCommit)
                        	 aSession.commit();                    	 
                     }
 
                }
            	
            	return numberOfAffectedRows;
            }
            
            return null;
    }

    
    protected SQLStatement[] getSQLStatements() 
    {
    	String batchStatement;
		try
		{
			batchStatement = renderer.mergeTemplate();
	        String[] statements = batchStatement.split(statementSeparator);
	        if (statements == null || statements.length == 0)
	            return null;

	        SQLStatement[] retStatements = new SQLStatement[statements.length]; 
	        for(int i = 0; i < statements.length; i++)
	        {
	        	retStatements[i] = new SQLStatement(statements[i]);
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
