//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.site;

public class SiteCriteria extends SiteFilter.SiteCriteriaBase{
	
	// private static final String SITEISCHILD_OF = 
	//	"((refsite = '%s' and refsitetype = 'site_internal') or (admrefsite = '%s' and admrefsitetype = 'site_internal'))";		

	private static final String SITEISCHILD_OF = 
			"(parentsite = '%s' and site in ("
			    + " select site from r3_siteproperty where propertyscope = 'site.config' and propertykey = 'refsitetype' and propertyvalue = 'site_internal' "
				+ " UNION ALL "
			    + " select site from r3_siteproperty where propertyscope = 'site.config' and propertykey = 'admrefsitetype' and propertyvalue = 'site_internal' "
			    + ")"
			    + ")";	
	
	public SiteCriteria andSiteIsChildOf(String aSite)
	{
		if (aSite != null)
		{
			String q = String.format(SITEISCHILD_OF, aSite);
			addCriterion(q);
		}
		
		return (SiteCriteria)this;
		
	}
	
	private static final String HASOPTION = 
			"(site in (select site from r3_siteproperty where propertyscope = 'site.config' and propertykey = 'options' and propertyvalue like '%%%s%%'))";	
	
	public SiteCriteria andHasOption(String anOption)
	{
		if (anOption != null)
		{
			String q = String.format(HASOPTION, anOption);
			addCriterion(q);
		}
		
		return (SiteCriteria)this;
		
	}
}
