//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardfullview;

public class CardFullViewCriteria extends CardFullViewFilter.CardFullViewCriteriaBase{

	public CardFullViewCriteria andGroupidEqualTo(String aSite, String groupid)
	{		
		if (groupid != null)
		   addSubSelectCriterion("cardid in (select cardid from r3_cmscardgroup where site = '" + aSite + "' and groupid = ", groupid, ")", "cardid");
		
		return (CardFullViewCriteria)this;		
	}
	
	@Override
    public CardFullViewCriteria andLanguagecodeEqualTo(java.lang.String value) 
	{
        if (value != null)
        {
        	addSubSelectCriterion("(languagecode is null or languagecode = ", value, ")", "languagecode");
        }
        return (CardFullViewCriteria) this;
    }
	
    public CardFullViewCriteria andChannelidEqualTo(java.lang.String value) {
        if (value != null)
          addCriterion("channelid =", value, "channelid");
        return (CardFullViewCriteria) this;
    }
    
}
