package org.r3.db;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.r3.db.system.lut.ILUTItem;
import org.r3.system.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@XmlRootElement(name = "dtobase")
public class DTOBase implements java.io.Serializable, ILUTItem
{
	public enum RecordStatus {
		sys_recact, sys_recblock, sys_recdeleted, sys_recprocessed, sys_recerr;

		public static RecordStatus getEnum(String s)
		{
			if (s != null)
			{
				return valueOf(s);
			}

			return null;
		}
	};

	public enum DTOCasingStyle { none, uppercase, lowercase };
	
	public static final int SHIFT_TIME_ADAY     = 3600 * 24 * 1000;
	public static final int SHIFT_TIME_5Minutes = 5 * 60 * 1000;
		
	public    static DateFormat  shortSysDateFormat = new SimpleDateFormat("yyyyMM");
	public    static DateFormat       sysDateFormat = new SimpleDateFormat("yyyyMMdd");
	public    static DateFormat sysFileTimestampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SS");
    public    static DateFormat  sysTimestampFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    public    static DateFormat  calendarTimestampFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    public    static DateFormat     printDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public    static DateFormat  ISO8601TimestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public    static DateFormat  ISO8601DateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
	private DateFormat  dateFormat;
    private DateFormat  timestampFormat;

    public DTOBase() 
    {
        dateFormat = sysDateFormat;
        timestampFormat = sysTimestampFormat;
    }
    
    @JsonIgnore
	public PersistenceDTO getPersistenceDTOAnnotation()
	{
		return (PersistenceDTO)this.getClass().getAnnotation(PersistenceDTO.class);
	}
	
	public String validateField(String aColumnName, String aValue, boolean trimmable)
	{
		PersistenceDTO dtoAnnotation = getPersistenceDTOAnnotation();
		if (dtoAnnotation != null)
		{
			PersistenceDTOValidator validator = PersistenceContext.getPersistenceContext().getPersisteceDTOValidator();
			if (validator != null)
				aValue = validator.validate(dtoAnnotation.table_name(), aColumnName, aValue);
		}
		
		return aValue;
	}
	

    @XmlElement
    public String getDtokey()
    {
        return "NOKEY_PROVIDED";	
    }
    
    public String getDtodescr()
    {
        return "NODESCR_PROVIDED";    	
    }
    
    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(DateFormat dateFormat)
    {
        this.dateFormat = dateFormat;
    }
    
    public static boolean isEmpty(String s)
    {
    	if (s == null || s.length() == 0)
            return true;
    	
    	return false;
    }

    public static String nullOnEmpty(String s)
    {
    	if (s == null || s.length() == 0)
            return null;
    	
    	return s;
    }
    
    public static String[] nullOnEmpty(String[] s)
    {
    	if (s == null || s.length == 0)
            return null;
    	
    	return s;
    }
    
    public static boolean getBTrueFalseAsBoolean(String truthyValue)
    {
        if (truthyValue != null && truthyValue.equalsIgnoreCase("btrue"))
        	return true;
        
        return false;
    }
    
    /**
     * @return the dateFormat
     */
    @JsonIgnore
    @XmlTransient 
    public DateFormat getDateFormat()
    {
        return dateFormat;
    }
    
    /**
     * @param timestampFormat the timestampFormat to set
     */
    public void setTimestampFormat(DateFormat timestampFormat)
    {
        this.timestampFormat = timestampFormat;
    }
    
    /**
     * @return the timestampFormat
     */
    @JsonIgnore
    @XmlTransient 
    public DateFormat getTimestampFormat()
    {
        return timestampFormat;
    }

	public boolean equalsBigDecimal(java.math.BigDecimal firstElement, java.math.BigDecimal secondElement)
    {
        if ((firstElement == null && secondElement != null) || 
            (firstElement != null && secondElement == null) ||
            (firstElement == null && secondElement == null) ||            
            (firstElement != null && firstElement.compareTo(secondElement) != 0))  return false;
        
        return true;   
    }

    public boolean equalsObject(Object firstElement, Object secondElement)
    {
        if ((firstElement == null && secondElement != null) || 
            (firstElement != null && secondElement == null) ||
            (firstElement == null && secondElement == null) ||            
            (firstElement != null && !firstElement.equals(secondElement)))  return false;
        
        return true;   
    }

    public static java.util.Date parseDate(String s)
    {
        if (s == null || s.length() == 0)
            return null;

        try
        {
            if (s.indexOf("/") >= 0)
            	return printDateFormat.parse(s);
            
            return sysDateFormat.parse(s);            
        }
        catch (java.text.ParseException exc)
        {
            exc.printStackTrace();
        }

        return null;
    }
    
    public static java.sql.Date stringAsDate(String s)
    {
    	return stringAsDate(s, null);
    }
    
    public static java.sql.Date stringAsDate(String s, DateFormat dateFormat)
    {
        if (s == null || s.length() == 0)
            return null;

        java.sql.Date res = null;
        try
        {
        	if (dateFormat == null)
        	{
        	    if (s.indexOf('/') >= 0)
        	    	 dateFormat = printDateFormat;
        	    else dateFormat = sysDateFormat;
        	}
        	
            res = new java.sql.Date(dateFormat.parse(s).getTime());
        }
        catch (java.text.ParseException exc)
        {
            exc.printStackTrace();
            res = null;
        }

        return res;
    }

    public static java.sql.Timestamp stringAsTimestamp(String p, DateFormat dateFormat)
    {
        if (p == null || p.length() == 0)
            return null;

        
        // p =  p.replaceAll("\\s+", " ");
        
        java.sql.Timestamp res = null;
        try
        {
             res = new java.sql.Timestamp(dateFormat.parse(p).getTime());
        }
        catch (java.text.ParseException exc)
        {
            exc.printStackTrace();
            res = null;
        }

        return res;
    }

    public static java.lang.Integer stringAsInteger(String p)
    {
        if (p == null || p.length() == 0)
            return null;

        java.lang.Integer res = null;
        try
        {
            res = new Integer(p);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }

    public static java.lang.Long stringAsLong(String p)
    {
        if (p == null || p.length() == 0)
            return null;

        java.lang.Long res = null;
        try
        {
            res = new Long(p);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }

    public static java.lang.Boolean stringAsBoolean(String p)
    {
        if (p == null || p.length() == 0)
            return null;

        java.lang.Boolean res = null;
        try
        {
            res = new Boolean(p);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }
    
    public static java.lang.Double stringAsDouble(String p)
    {
        if (p == null || p.length() == 0)
            return null;

        java.lang.Double res = null;
        try
        {
            res = new Double(p);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }

    public static java.lang.Float stringAsFloat(String p)
    {
        if (p == null || p.length() == 0)
            return null;

        java.lang.Float res = null;
        try
        {
            res = new Float(p);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }
    
    public  static java.math.BigDecimal stringAsBigDecimal(String p, int scale)
    {
        if (p == null || p.length() == 0)
            return null;

        java.math.BigDecimal res = null;
        try
        {
            res = new java.math.BigDecimal(p).setScale(scale, java.math.BigDecimal.ROUND_HALF_DOWN);
        }
        catch (java.lang.NumberFormatException exc)
        {
            exc.printStackTrace(System.err);
            res = null;
        }

        return res;
    }

    // Conversions to String.
    public static String dateAsString(java.util.Date aDate, DateFormat aDateFormat)
    {
        if (aDate == null)
            return "";
        
        return aDateFormat.format(aDate);
    }

    public static String timestampAsString(java.sql.Timestamp aTimestamp, DateFormat aDateFormat)
    {
        if (aTimestamp == null)
            return "";
        
        return aDateFormat.format(aTimestamp);
    }

    public static String decimalAsString(java.math.BigDecimal anAmount)
    {
        if (anAmount == null)
            return "";
        return String.valueOf(anAmount);
    }

    public static String decimalAsJSONString(java.math.BigDecimal anAmount)
    {
        if (anAmount == null)
            return null;
        
        return String.valueOf(anAmount);
    }

    public static String currencyAsString(java.math.BigDecimal anAmount, NumberFormat numberFormat)
    {
        if (anAmount == null)
            return "";
        return numberFormat.format(anAmount);
    }

    public static String currencyAsJSONString(java.math.BigDecimal anAmount, NumberFormat numberFormat)
    {
        if (anAmount == null)
            return null;
        return numberFormat.format(anAmount);
    }

    public static String integerAsString(java.lang.Integer anInteger)
    {
        if (anInteger == null)
            return "";
        return String.valueOf(anInteger);
    }

    public static String integerAsJSONString(java.lang.Integer anInteger)
    {
        if (anInteger == null)
            return null;
        return String.valueOf(anInteger);
    }

    public static String longAsString(java.lang.Long aLong)
    {
        if (aLong == null)
            return "";
        return String.valueOf(aLong);
    }

    public static String longAsJSONString(java.lang.Long aLong)
    {
        if (aLong == null)
            return null;
        
        return longAsString(aLong);
    }

    public static String doubleAsString(java.lang.Double aDouble)
    {
        if (aDouble == null)
            return "";
        return String.valueOf(aDouble);
    }

    public static String doubleAsJSONString(java.lang.Double aDouble)
    {
        if (aDouble == null)
            return null;
        return String.valueOf(aDouble);
    }

    public static String floatAsString(java.lang.Float aFloat)
    {
        if (aFloat == null)
            return "";
        return String.valueOf(aFloat);
    }

    public static String floatAsJSONString(java.lang.Float aFloat)
    {
        if (aFloat == null)
            return null;
        return String.valueOf(aFloat);
    }

    public static String booleanAsString(java.lang.Boolean aBoolean)
    {
        if (aBoolean == null)
            return "";
        return String.valueOf(aBoolean);
    }

    public static String booleanAsJSONString(java.lang.Boolean aBoolean)
    {
        if (aBoolean == null)
            return null;
        return String.valueOf(aBoolean);
    }

    public static boolean booleanValue(String s)
    {
    	if (s != null && (s.equalsIgnoreCase("btrue") || s.equalsIgnoreCase("true")))
    		return true;
    	
        return false;
    }

    public static Timestamp currentTimestamp()
    {
        return currentTimestamp(0L);
    }

    public static Timestamp currentTimestamp(long shiftTime)
    {
        return new Timestamp((new java.util.Date()).getTime() + shiftTime);
    }

    public static String currentTimestampAsFileStampString()
    {
    	String s = timestampAsString(currentTimestamp(), sysFileTimestampFormat);
    	return s;
    }
    
    public static Timestamp currentTimestamp(String setTime)
    {
    	java.sql.Timestamp ts = null;
    	if (setTime != null)
    	{
    		StringBuilder stb = new StringBuilder(); 	   
    	 	stb.append(currentDate(DTOBase.sysDateFormat)).append(" ").append(setTime);
    	 	ts = stringAsTimestamp(stb.toString(), DTOBase.sysTimestampFormat);
    	}
    	else ts = new Timestamp((new java.util.Date()).getTime());
    	
    	return ts;
    }

    public static Calendar getCalendarCurrentDate(int numberOfDays, int numberOfMonths, int numberOfYears)
    {
    	Calendar c = Calendar.getInstance();
    	
    	if (numberOfDays > 0)
    	   c.add(Calendar.DATE, numberOfDays);
    	
    	if (numberOfMonths > 0)
    		c.add(Calendar.MONTH, numberOfMonths);

    	if (numberOfYears > 0)
    		c.add(Calendar.YEAR, numberOfYears);

        return c;
    }

    public static java.sql.Date currentDate(int numberOfDays, int numberOfMonths, int numberOfYears)
    {
    	Calendar c = getCalendarCurrentDate(numberOfDays, numberOfMonths, numberOfYears);
    	return new java.sql.Date(c.getTimeInMillis());
    }

    public static String currentDate(int numberOfDays, int numberOfMonths, int numberOfYears, DateFormat aDateFormat)
    {
    	Calendar c = getCalendarCurrentDate(numberOfDays, numberOfMonths, numberOfYears);
    	return aDateFormat.format(c.getTime());
    }
    
    public static java.sql.Date currentDate()
    {
        return new java.sql.Date((new java.util.Date()).getTime());
    }

    public static String currentDate(DateFormat df)
    {    	
        return df.format(currentDate());
    }

    public static String currentDate(String aFormat)
    {
    	DateFormat df = new SimpleDateFormat(aFormat);    	
        return df.format(currentDate());
    }
    
	public static int getCurrentYear()
	{       
        return getYear(null);
	}

	public static int getYear(java.util.Date referenceDate)
	{				
        Calendar c = Calendar.getInstance();
        if (referenceDate != null)
			c.setTime(referenceDate);
        
		return c.get(Calendar.YEAR);
	}

    /*
     * Questa funzione ritorna la parte numerica presente in un sequenceId del thip {ALPHA}?{DIGIT}?
     * (es. DOK000000000027)
     */
    public static int getNumberFromGWFSequenceId(String aSequenceId)
    {
    	if (aSequenceId != null && aSequenceId.length() > 3)
    	{
    		// Considero comunque i primi 3 caratteri riservati.
    		List<Integer> numbersFromSeqId = StringUtils.findNumbers(aSequenceId.substring(3));
    		if (numbersFromSeqId != null)
    			return numbersFromSeqId.get(0);
    	}
    	
    	return 0;
    }
    
    public static String[] string2Array(String s, String separator)
    {
    	if (s == null || s.length() == 0)
    		return null;
    	
    	String[] sArr = s.split(separator);
    	if (sArr != null && sArr.length > 0)
    		return sArr;
    	
    	return sArr;
    }
    
    public static List<String> string2List(String s, String separator)
    {
    	if (s == null || s.length() == 0)
    		return null;

    	String[] sArr = s.split(separator);
    	if (sArr != null && sArr.length > 0)
    	{
        	ArrayList<String> listOf = new ArrayList<String>();  
        	for(String s1 : sArr)
        		listOf.add(s1);
        	
    		return listOf;    		
    	}
    	
    	return null;
    }
    
	public static String stringArray2CSV(String[] sArray)
	{
		if (sArray == null || sArray.length == 0)
			return null;
		
		StringBuilder stb = new StringBuilder();
		
		int numberOfItems = 0;
        for(int i = 0; i < sArray.length; i++)
        {
        	String s = sArray[i];
        	if (s == null || s.length() == 0)
        		continue;
        	
        	if (i > 0)
        		stb.append(',');
        	
        	numberOfItems++;
        	stb.append(sArray[i]);
        }
        
        if (numberOfItems > 0)
		   return stb.toString();
        
        return null;
	}

	public static String stringList2CSV(List<String> sArray)
	{
		if (sArray == null || sArray.size() == 0)
			return null;
		
		StringBuilder stb = new StringBuilder();
		
		int numberOfItems = 0;
        for(String s : sArray)
        {
        	if (s == null || s.length() == 0)
        		continue;
        	
        	if (numberOfItems > 0)
        		stb.append(',');
        	
        	numberOfItems++;
        	stb.append(s);
        }
        
        if (numberOfItems > 0)
		   return stb.toString();
        
        return null;
	}

}
