package org.r3.db;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.system.sequence.SequencePersistence;
import org.r3.db.system.transaction.SqlManagedSessionManager;
import org.r3.system.SystemLogger;

import com.mongodb.MongoClient;

public class PersistenceContext
{		
	public static SystemLogger persistenceContextLogger = new SystemLogger(PersistenceContext.class);

	private PersistenceConfigInfo contextInfo;
	
	public PersistenceConfigInfo getPersistenceConfigInfo()
	{
		return contextInfo;
	}

	public PersistenceConfigInfo getPersistenceConfigInfo(boolean cloned)
	{
		if (cloned)
		{
			try
			{
				PersistenceConfigInfo newCfgInfo = (PersistenceConfigInfo)contextInfo.clone();
				newCfgInfo.setClonedFlag(true);
				return newCfgInfo; 				
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			} 	
		}
		
		return contextInfo;
	}
	
	public void setPersistenceConfigInfo(PersistenceConfigInfo contextInfo)
	{
		this.contextInfo = contextInfo;
	}
	
	private PersistenceDTOValidator persistenceDTOValidator;
	
	public PersistenceDTOValidator getPersisteceDTOValidator()
	{
		return persistenceDTOValidator;
	}

	public void  setPersisteceDTOValidator(PersistenceDTOValidator aValidator)
	{
		persistenceDTOValidator = aValidator;
	}

	// MARIO 20130419 -- Cambiata la signature. Usato SqlSessionManager al posto SqlSessionFactory
	// MARIO 20130419 -- Cambiata la signature. Usato SqlManagedSessionManager al posto SqlSessionManager
	private SqlManagedSessionManager sqlSessionFactory;
	private SequencePersistence sequencePersistence;

	public void logTrace(Class<?> objectClass, String aLoggedString)
	{
		persistenceContextLogger.trace(objectClass, aLoggedString, 1);
	}

	public void logDebug(Class<?> objectClass, String aLoggedString)
	{
		persistenceContextLogger.debug(objectClass, aLoggedString, 1);
	}

	public void logInfo(Class<?> objectClass, String aLoggedString)
	{
		persistenceContextLogger.info(objectClass, aLoggedString, 1);
	}

	public void logWarn(Class<?> objectClass, String aLoggedString)
	{
		persistenceContextLogger.warn(objectClass, aLoggedString, 1);
	}

	public void logError(Class<?> objectClass, String aLoggedString)
	{
		persistenceContextLogger.error(objectClass, aLoggedString, 1);
	}


	public SequencePersistence getSequencePersistence()
	{
		return sequencePersistence;
	}

	private void setSequencePersistence(SequencePersistence sequencePersistence)
	{
		this.sequencePersistence = sequencePersistence;
	}

    public String generateId(String aPrefix)
    {    	
    	String seqId = sequencePersistence.getSequence(aPrefix);
    	return seqId;
    }

    public int generateIntegerId(String aPrefix)
    {    	
    	int seqId = sequencePersistence.getIntSequence(aPrefix);
    	return seqId;
    }

    // MARIO 20130419 -- Commentato
//	private SqlSessionFactory getSqlSessionFactory()
//	{
//		return sqlSessionFactory;
//	}

	public SqlSession openSession()
	{
	    return 	sqlSessionFactory.openSession();
	}

	public SqlSession startManagedSession()
	{
	    sqlSessionFactory.startManagedSession();
	    return sqlSessionFactory;
	}

	public boolean isManagedSessionStarted()
	{
	    return sqlSessionFactory.isManagedSessionStarted();	    
	}

	public Connection getManagedConnection()
	{
	    return sqlSessionFactory.getConnection();	    
	}

	// MARIO 20130419 -- Cambiata la signature. Usato SqlSessionManager al posto SqlSessionFactory
	// MARIO 20130419 -- Cambiata la signature. Usato SqlManagedSessionManager al posto SqlSessionManager	
	private void setSqlSessionFactory(SqlManagedSessionManager sqlSessionFactory)
	{
		this.sqlSessionFactory = sqlSessionFactory;
	}

	// public SqlSession getNewSession()
	// {
	// return getSqlSessionFactory().openSession();
	// }
	//

	private static PersistenceContext theContext;

	public static PersistenceContext getPersistenceContext()
	{
		return theContext;
	}

	// MARIO 20130419 -- Cambiata la signature. Usato SqlSessionManager
	// MARIO 20130419 -- Cambiata la signature. Usato SqlManagedSessionManager
	public static PersistenceContext initPersistenceContext(SqlManagedSessionManager sessionFactory, MongoPersistenceContext aMongoContext)
	{
		PersistenceContext pcfg = new PersistenceContext();
		pcfg.setPersistenceConfigInfo(new PersistenceConfigInfo());
		
		pcfg.setSqlSessionFactory(sessionFactory);

		SequencePersistence seqp = new SequencePersistence();
		// MARIO 20130419
		// seqp.setSqlSessionFactory(sessionFactory);
		pcfg.setSequencePersistence(seqp);
		
		pcfg.mongoContext = aMongoContext;
		
		theContext = pcfg;
		return theContext;
	}

	private MongoPersistenceContext mongoContext;
	
	public void shutdownMongoDb()
	{
		if (mongoContext != null)
			mongoContext.shutdownMongoDb();
	}
	
	public MongoClient getMongoDbClient()
	{
		return (mongoContext != null) ? mongoContext.getMongoDbClient() : null;
	}
	
	public boolean isMongoDbAvailable()
	{
		return mongoContext != null;
	}
		
	public MongoPersistenceContext getMongoPersistenceContext()
	{
		return mongoContext;
	}
}
