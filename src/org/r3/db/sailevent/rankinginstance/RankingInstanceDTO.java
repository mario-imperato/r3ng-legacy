//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstance;

public class RankingInstanceDTO extends RankingInstanceDTOBase 
{
	public enum InstanceType { rank_race, rank_overall };
	
    public static final int GENERAL_RACENUMBER = 99;
    public static final int GENERAL_MAXRACENUMBER = 20;    

	public RankingInstanceDTO()
    {
        super();
    }

    public RankingInstanceDTO(RankingInstanceDTO another)
    {
        super(another);
    }

	public boolean isOverallRankingInstance()
	{
		return instancetype != null && InstanceType.valueOf(instancetype) == InstanceType.rank_overall;
	}


}
