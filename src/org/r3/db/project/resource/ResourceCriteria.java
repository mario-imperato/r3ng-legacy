//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;

public class ResourceCriteria extends ResourceFilter.ResourceCriteriaBase
{
	private static final String NAME_OR_EMAIL_LIKE = 
			"(firstname like '%%%s' or lastname like '%%%s' or email like '%%%s')";	
	
	public ResourceCriteria andMailOrNameLike(String s)
	{
		if (s != null && s.length() > 0)
		{
			s = SQLStringUtils.escapeSingleQuotes(s);
		    s = SQLStringUtils.getStringForLikeMode(s, LikeMode.FullLike);		
		    addCriterion(String.format(NAME_OR_EMAIL_LIKE, s, s, s));
		}
		
		return (ResourceCriteria)this;				
	}
	
	private static final String REFERENCED_BY_SITE = 
			"(resourceid in (select resourceid from prj_teamresource where site = '%s') or sitedomain = '%s')";	
	
	public ResourceCriteria andSiteEqualTo(String s)
	{
		if (s != null && s.length() > 0)
		{			
		    addCriterion(String.format(REFERENCED_BY_SITE, s, s));
		}
		
		return (ResourceCriteria)this;				
	}
	
}
