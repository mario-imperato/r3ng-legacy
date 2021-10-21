//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.carddescr;

public class CardDescrDTO extends CardDescrDTOBase
{
    public CardDescrDTO()
    {
        super();
    }

    public CardDescrDTO(CardDescrDTO another)
    {
        super(another);
    }

    public boolean hasPendingChanges()
    {
    	if (this.isSummaryDirty() || this.isTextbodyDirty() || this.isTitleDirty())
    		return true;
    	
    	return false;
    }
}
