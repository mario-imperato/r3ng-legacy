package org.r3.db.system.lut;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LUT
{
	private static Logger logger = LoggerFactory.getLogger(LUTManager.class);
	
	protected static final long DEFAULT_VALIDITY_1HOUR = 3600000; 
	protected static final long DEFAULT_VALIDITY_1DAY = 86400000;
	protected static final long DEFAULT_VALIDITY = DEFAULT_VALIDITY_1HOUR;

	protected String lutLanguage;
		
	public String getLutLanguage()
	{
		return lutLanguage;
	}

	public void setLutLanguage(String lutLanguage)
	{
		this.lutLanguage = lutLanguage;
	}

	private LUTTable instance = null;
	private LUTReader reader = null;
	
	protected java.util.Date expirationTimeStamp;
	protected java.util.Date loadTimestamp;
	
	private String lutName = "Undefined";

	private Object synchObject = new Object();
	
	// Values with values <=0 makes the LUT not timed.
	private long timeout = 0;

	public LUT(long aTimeout)
	{
		timeout = aTimeout;
	}

	public LUT(String n, long aTimeout)
	{
		this(aTimeout);
		lutName = n;
	}

	public LUT()
	{
		this(DEFAULT_VALIDITY);
	}

	public LUT(String n)
	{
		lutName = n;
	}

	public void setReader(LUTReader aReader) throws LUTException
	{
		setReader(aReader, timeout);
	}

	public void setReader(LUTReader aReader, long aTimeout) throws LUTException
	{
		if (aReader == null)
			throw new LUTException("LUTSet::setReader: invalid parameters");

		reader = aReader;
		instance = reader.readLUT();
		loadTimestamp = new java.util.Date();
		if (aTimeout > 0)
		{
			setExpiration(timeout);
		}
	}

	public LUTTable getInstance() throws LUTException
	{
		if (instance == null)
			throw new LUTException("LUTSet::getInstance: StringTable not loaded for " + lutName);

		if (expired())
		{
			logger.info("LUTSet::getInstance: Lut Table Expired " + lutName);
			synchronized (synchObject)
			{				
				if (expired())
				{
					instance = reader.readLUT();
					loadTimestamp = new java.util.Date();
					setExpiration(timeout);
				}
			}
		}
				
		return instance;
	}

	// In setting the timeout I need to visit the instances already loaded.
	// Otherwise they are
	// not properly flagged.
	// public void setTimeout(int msecs) throws LUTException
	// {
	// boolean isTimed = (msecs > 0) ? true : false;
	//
	// timeout = msecs;
	// instance.setIsTimed(isTimed);
	// instance.setTimeStamp(timeout);
	// }



	public LUTTable reload() throws LUTException
	{
		setExpired();
		return getInstance();
	}

	private boolean isTimed()
	{
		logger.debug("LUT::isTimed - " + lutName + ": " + timeout);
		return timeout > 0;
	}

	public boolean expired()
	{
		// System.out.println("ISTimed: " + _isTimed + " IsExpired from " +
		// timeStamp);
		if (!isTimed())
			return false;

		java.util.Date now = new java.util.Date();

		return now.after(expirationTimeStamp);
	}

	public boolean hasBeenLoadedSince(java.sql.Timestamp ts)
	{
		return loadTimestamp.after(ts);
	}

	public void setExpiration(long validity)
	{
		java.util.Date now = new java.util.Date();

		if (validity > 0)
		{
			long millis = now.getTime();
			now.setTime(millis + validity);
		}

		expirationTimeStamp = now;
	}

	// Setto l'expiration nel passato. Circa 5 Minuti.
	public void setExpired()
	{
		java.util.Date now = new java.util.Date();

		long millis = now.getTime();
		now.setTime(millis - 60000);

		expirationTimeStamp = now;
	}

}
