//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.fileproperty;

public class DMSFilePropertyCriteria extends DMSFilePropertyFilter.DMSFilePropertyCriteriaBase{
	public DMSFilePropertyCriteria andFilephysicalpathEqualTo(java.lang.String value)
	{
		addSubSelectCriterion("fileid in (select fileid from unep.unep_dmsfile where filephysicalpath = ", value, ")", "fileid");		
		return (DMSFilePropertyCriteria) this;
	}
	
}
