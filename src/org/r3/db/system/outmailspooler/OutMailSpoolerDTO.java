//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspooler;

public class OutMailSpoolerDTO extends OutMailSpoolerDTOBase
{
	// Questi campi servono solamente nel query e in visualizzazione. Non hanno il supporto usuale degli altri campi. Per questo motivo non è stata
	// fatta una vista che sarebbe stata overkill.
	private int numprocessed;
	private int numerr;
	private int numactive;
		
	public int getNumprocessed()
	{
		return numprocessed;
	}

	public void setNumprocessed(int numprocessed)
	{
		this.numprocessed = numprocessed;
	}

	public int getNumerr()
	{
		return numerr;
	}

	public void setNumerr(int numerr)
	{
		this.numerr = numerr;
	}

	public int getNumactive()
	{
		return numactive;
	}

	public void setNumactive(int numactive)
	{
		this.numactive = numactive;
	}

	public enum MessageMode { 
		
		msg_regular, msg_undisclosed;
	
		public static MessageMode getValueOf(String s, MessageMode defaultValue)
		{			
			if (s != null && s.length() > 0)
				return MessageMode.valueOf(s);
			
			return defaultValue;
		}
	};
	
    public OutMailSpoolerDTO()
    {
        super();
    }

    public OutMailSpoolerDTO(OutMailSpoolerDTO another)
    {
        super(another);
    }

    public String[] getMsgbccRecipients()
    {
    	return getRecipientsFromSemicolonSeparatedValues(getMsgbcc());
    }

    public String[] getMsgccRecipients()
    {
    	return getRecipientsFromSemicolonSeparatedValues(getMsgcc());
    }

    public String[] getRecipientsFromSemicolonSeparatedValues(String aListOfMailAddress)
    {
    	String[] marr = null;
        String m = aListOfMailAddress;getMsgbcc();
        
        if (aListOfMailAddress != null && aListOfMailAddress.length() == 0)
        {
        	marr = aListOfMailAddress.split(";");
        }
        
        return marr;        
    }
    
    public boolean areRecipientsUndisclosed()
    {
    	return MessageMode.getValueOf(getMsgmode(), MessageMode.msg_regular) == MessageMode.msg_undisclosed;
    }
}
