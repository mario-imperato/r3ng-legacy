package org.r3.system.rest;

public class RestServiceDTO
{
	public static RestServiceDTO SuccessDTO = new RestServiceDTO(Status.ok, "RESTDTO_OK", "Success");
	public static RestServiceDTO FailDTO = new RestServiceDTO(Status.fail, "RESTDTO_FAIL", "Errore");
	
	public enum Status { ok, fail, warning };
	private Status        status;
	private String        reason;
	private String        reasoncode;
	private String        correlationid;

	private int           counter1;
	private int           counter2;
	
	public RestServiceDTO()
	{
		this(Status.fail, "_NO_CODE_", "Undef");		
	}

	public RestServiceDTO(Status aStatus, String aReasonCode, String aReason)
	{
		status = aStatus;
		reason = aReason;
		reasoncode = aReasonCode;

		counter1 = 0;
		counter2 = 0;		
	}

	public RestServiceDTO(Status aStatus, String aReason)
	{
		this(aStatus, "_NO_CODE_", aReason);
	}

	
	public String getReasoncode()
	{
		return reasoncode;
	}

	public Status getStatus()
	{
		return status;
	}

	public String getReason()
	{
		return reason;
	}

	public String getCorrelationid()
	{
		return correlationid;
	}

	public void setCorrelationid(String operationId)
	{
		this.correlationid = operationId;
	}

	public int getCounter1()
	{
		return counter1;
	}

	public void setCounter1(int counter1)
	{
		this.counter1 = counter1;
	}

	public int getCounter2()
	{
		return counter2;
	}

	public void setCounter2(int counter2)
	{
		this.counter2 = counter2;
	}
	
	
}
