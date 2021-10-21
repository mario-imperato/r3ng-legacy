//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopic;

public class BBSTopicDTO extends BBSTopicDTOBase
{
    public BBSTopicDTO()
    {
        super();
    }

    public BBSTopicDTO(BBSTopicDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder(); 
        stb.append(site).append('_');
        stb.append(topicid);
        return stb.toString();
    }
}
