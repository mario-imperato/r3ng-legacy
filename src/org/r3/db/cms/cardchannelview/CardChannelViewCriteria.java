//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannelview;

public class CardChannelViewCriteria extends CardChannelViewFilter.CardChannelViewCriteriaBase
{
	private static final String BELONGS_2_SITE_OR_DOMAIN = "site = '%s' or site in (select site from r3_site where sitedomain = '%s')";

	public CardChannelViewCriteria andSiteEqualToOrSiteInDomain(String aDomain, String aSite)
	{
		if (aDomain != null || aSite != null)
		{
			String q = String.format(BELONGS_2_SITE_OR_DOMAIN, aSite, aDomain);
			addCriterion(q);
		}

		return (CardChannelViewCriteria) this;

	}
}
