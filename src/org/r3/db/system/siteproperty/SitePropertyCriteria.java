//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

import org.r3.db.system.siteproperty.SitePropertyDTO.SiteIdentifier;

public class SitePropertyCriteria extends SitePropertyFilter.SitePropertyCriteriaBase{

	public SitePropertyCriteria andSiteEqualTo(String aSite, boolean b)
	{
		if (aSite == null)
			return (SitePropertyCriteria)this;

		if (b)
		       addSubSelectCriterion("(site = '" + SiteIdentifier.__any__ + "' or site =", aSite, ")", "site");
		else   addCriterion("site =", aSite, "site");
		return (SitePropertyCriteria)this;
		
	}
}
