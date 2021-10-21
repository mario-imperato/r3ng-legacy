//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

import org.r3.db.DTOBase;
import org.r3.system.util.Codecs;

public class OTPDTO extends OTPDTOBase
{
    public OTPDTO()
    {
        super();
    }

    public OTPDTO(OTPDTO another)
    {
        super(another);
    }

    public void setOTPInfo(String aUserId, int numberOfDays) 
    { 
    	setUserid(aUserId);
    	setExpirytime(DTOBase.currentTimestamp(SHIFT_TIME_ADAY * numberOfDays));
   	    digest  = Codecs.digestAsString(createString4UniqueDigest(userid, expirytime));
    } 
    
    private String createString4UniqueDigest(String aUserId, java.sql.Timestamp  anExpiryTime)
    {
    	StringBuilder stb = new StringBuilder();
    	stb.append(aUserId)
    		.append(anExpiryTime.toString())
    		.append(DTOBase.currentTimestamp().toString());
    	
    	return stb.toString();
    }

}
