package org.r3.db.mongo;

public class MongoCalendarDTO
{	
	public static class BusinessHours
	{
		public BusinessHours()
		{
			
		}
		
		private int     dayOfWeek;		
		
		private String  businessHoursType; 
		private String  annotation;
		
		private String  timeStart1;
		private String  timeEnd1;		
		
		private String  timeStart2;
		private String  timeEnd2;
		
		public int getDayOfWeek()
		{
			return dayOfWeek;
		}
		
		public void setDayOfWeek(int dayOfWeek)
		{
			this.dayOfWeek = dayOfWeek;
		}
		
		public String getBusinessHoursType()
		{
			return businessHoursType;
		}
		
		public void setBusinessHoursType(String businessHoursType)
		{
			this.businessHoursType = businessHoursType;
		}
		
		public String getAnnotation()
		{
			return annotation;
		}
		
		public void setAnnotation(String annotation)
		{
			this.annotation = annotation;
		}
		
		public String getTimeStart1()
		{
			return timeStart1;
		}
		
		public void setTimeStart1(String timeStart1)
		{
			this.timeStart1 = timeStart1;
		}
		
		public String getTimeEnd1()
		{
			return timeEnd1;
		}
		
		public void setTimeEnd1(String timeEnd1)
		{
			this.timeEnd1 = timeEnd1;
		}
		
		public String getTimeStart2()
		{
			return timeStart2;
		}
		
		public void setTimeStart2(String timeStart2)
		{
			this.timeStart2 = timeStart2;
		}
		
		public String getTimeEnd2()
		{
			return timeEnd2;
		}
		
		public void setTimeEnd2(String timeEnd2)
		{
			this.timeEnd2 = timeEnd2;
		}				
		
	}
	
	public MongoCalendarDTO()
	{

	}

  	private String  calendarid;
  
  	public String   getCalendarid()         
  	{ 
  		return calendarid; 
  	}

  	public void setCalendarid(org.bson.types.ObjectId  p)         
  	{ 
  		calendarid = p.toHexString(); 
  	}

  	public void setCalendarid(java.lang.String  p)         
  	{ 
  		calendarid = p; 
  	}
  	
  	
	private java.util.Date  validFrom;
		
	public java.util.Date getValidFrom()
	{
		return validFrom;
	}
	
	public void setValidFrom(java.util.Date validFrom)
	{
		this.validFrom = validFrom;
	}

	private java.util.Date  validTo;
		
	public java.util.Date getValidTo()
	{
		return validTo;
	}

	public void setValidTo(java.util.Date validTo)
	{
		this.validTo = validTo;
	}

	private String  annotation;	
		
	public String getAnnotation()
	{
		return annotation;
	}

	public void setAnnotation(String annotation)
	{
		this.annotation = annotation;
	}

	private BusinessHours[] businessHours;

	public BusinessHours[] getBusinessHours()
	{
		return businessHours;
	}

	public void setBusinessHours(BusinessHours[] businessHours)
	{
		this.businessHours = businessHours;
	}
	
}
