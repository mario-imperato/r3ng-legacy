//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetail;

public class RankingInstanceDetailDTO extends RankingInstanceDetailDTOBase
{
    public RankingInstanceDetailDTO()
    {
        super();
    }

    public RankingInstanceDetailDTO(RankingInstanceDetailDTO another)
    {
        super(another);
    }

	public void setRaceScore(int raceNumber, float aScore, String anAnnotation)
	{
        switch(raceNumber)
        {
        case  1: setScorer01(aScore); setScorern01(anAnnotation); break;
        case  2: setScorer02(aScore); setScorern02(anAnnotation); break;
        case  3: setScorer03(aScore); setScorern03(anAnnotation); break;
        case  4: setScorer04(aScore); setScorern04(anAnnotation); break;
        case  5: setScorer05(aScore); setScorern05(anAnnotation); break;
        case  6: setScorer06(aScore); setScorern06(anAnnotation); break;
        case  7: setScorer07(aScore); setScorern07(anAnnotation); break;
        case  8: setScorer08(aScore); setScorern08(anAnnotation); break;
        case  9: setScorer09(aScore); setScorern09(anAnnotation); break;
        case 10: setScorer10(aScore); setScorern10(anAnnotation); break;
        case 11: setScorer11(aScore); setScorern11(anAnnotation); break;
        case 12: setScorer12(aScore); setScorern12(anAnnotation); break;
        case 13: setScorer13(aScore); setScorern13(anAnnotation); break;
        case 14: setScorer14(aScore); setScorern14(anAnnotation); break;
        case 15: setScorer15(aScore); setScorern15(anAnnotation); break;
        default: 
        	System.err.println("Unexpected Race Number " + raceNumber);
        }
		
	}

}
