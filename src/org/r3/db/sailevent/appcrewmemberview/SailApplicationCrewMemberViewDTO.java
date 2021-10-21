//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmemberview;

import org.r3.db.DTOBase;

public class SailApplicationCrewMemberViewDTO extends SailApplicationCrewMemberViewDTOBase
{
    public SailApplicationCrewMemberViewDTO()
    {
        super();
    }

    public SailApplicationCrewMemberViewDTO(SailApplicationCrewMemberViewDTO another)
    {
        super(another);
    }

    public String getMedexamexpirationdateAsPrintDateFormat()
    {
    	return getMedexamexpirationdateAsString(DTOBase.printDateFormat);
    }

    public String getRenewaldateAsPrintDateFormat()
    {
    	return getRenewaldateAsString(DTOBase.printDateFormat);
    }

    public String getSystemcheckdateAsPrintDateFormat()
    {
    	return getSystemcheckdateAsString(DTOBase.printDateFormat);
    }

}
