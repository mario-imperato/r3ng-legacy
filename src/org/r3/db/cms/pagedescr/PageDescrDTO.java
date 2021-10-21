//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

public class PageDescrDTO extends PageDescrDTOBase
{
    public PageDescrDTO()
    {
        super();
    }

    public PageDescrDTO(PageDescrDTO another)
    {
        super(another);
    }

	public boolean hasPendingChanges()
	{
    	if (this.isSummaryDirty() || this.isPagetitleDirty())
    		return true;
	    	
    	return false;
	}

}
