//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.bbs.bbsthreadnode;

public class BBSThreadNodeCriteria extends
		BBSThreadNodeFilter.BBSThreadNodeCriteriaBase
{

	private static final String BELONGS_2_SITE_TOPICID = "threadid in (select threadid from r3_bbsthread where site = '%s' and topicid = '%s')";

	public BBSThreadNodeCriteria andTopicidEqualTo(String aSite, String aTopicId)
	{
		if (aTopicId != null)
		{
			String q = String.format(BELONGS_2_SITE_TOPICID, aSite, aTopicId);
			addCriterion(q);
		}

		return (BBSThreadNodeCriteria) this;

	}

}
