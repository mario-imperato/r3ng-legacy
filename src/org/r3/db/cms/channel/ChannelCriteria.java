//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.channel;

public class ChannelCriteria extends ChannelFilter.ChannelCriteriaBase 
{

	public ChannelCriteria andSiteCardidEqualTo(String aSite, String aCardid) 
	{
		addSubSelectCriterion("channelid in (select channelid from r3_cmscardchannel where site = '" + aSite + "' and cardid = ", aCardid, ")", "channelid");
		return (ChannelCriteria) this;
	}
}
