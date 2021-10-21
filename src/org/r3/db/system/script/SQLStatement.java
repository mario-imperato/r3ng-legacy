package org.r3.db.system.script;


import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;


public class SQLStatement
{
	public enum StatementType { unknown, insert, update, delete, autocommiton, autocommitoff, sessioncommit };
	
    private String statement;
    
    public SQLStatement(String aStatement)
    {
    	statement = aStatement.replace('\n', ' ').replace('\r', ' ').trim();
    }
    
    public StatementType getType()
    {

    	StatementType t = StatementType.unknown;
    	
    	if (statement != null)
    	{
    		String s = statement.toUpperCase();
    		if (s.equalsIgnoreCase(StatementType.autocommiton.toString()))
    			t = StatementType.autocommiton;
    		else  if (s.equalsIgnoreCase(StatementType.autocommitoff.toString()))
    			t = StatementType.autocommitoff;
    		else  if (s.equalsIgnoreCase(StatementType.sessioncommit.toString()))
    			t = StatementType.sessioncommit;
    		else if (s.startsWith("INSERT"))
    			t = StatementType.insert;
    		else if (s.startsWith("UPDATE"))
    			t = StatementType.update;
    		else if (s.startsWith("DELETE"))
    			t = StatementType.delete;    		     		
    	}
    	
    	return t;
    }

	public int execute(PersistenceContext pcfg, SqlSession aSession)
	{
		int numberOfAffectedRows = 0;
		
        if (statement != null && statement.length() > 0)
        {
        	SQLStatementMapper mapper = aSession.getMapper(SQLStatementMapper.class);
        	
        	switch(getType())
        	{
        	case insert:
        		numberOfAffectedRows = mapper.insert(statement);
        		break;

        	case update:
        		numberOfAffectedRows = mapper.update(statement);        		
        		break;

        	case delete:
        		numberOfAffectedRows = mapper.delete(statement);        		
        		break;     
        		
        	case sessioncommit:
        		aSession.commit();
        		break;

        	case autocommiton:
        		break;

        	case autocommitoff:
        		break;        	
        	}           
        }
        
        return numberOfAffectedRows;		
	}
	
	public boolean isAutoCommitOn()
	{
		return getType() == StatementType.autocommiton; 
	}

	public boolean isAutoCommitOff()
	{
		return getType() == StatementType.autocommitoff; 
	}

}
