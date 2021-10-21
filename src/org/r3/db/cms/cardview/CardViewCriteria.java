//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardview;

public class CardViewCriteria extends CardViewFilter.CardViewCriteriaBase{

	public CardViewCriteria andGroupidEqualTo(String aSite, String groupid)
	{
		addSubSelectCriterion("cardid in (select cardid from r3_cmscardgroup where site = '" + aSite + "' and groupid = ", groupid, ")", "cardid");		
		return (CardViewCriteria)this;		
	}
	
	@Override
    public CardViewCriteria andLanguagecodeEqualTo(java.lang.String value) 
	{
        if (value != null)
        {
        	addSubSelectCriterion("(languagecode is null or languagecode = ", value, ")", "languagecode");
        }
        return (CardViewCriteria) this;
    }

}
