//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannelview;

public class CardChannelViewDTO extends CardChannelViewDTOBase
{
    public CardChannelViewDTO()
    {
        super();
    }

    public CardChannelViewDTO(CardChannelViewDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(channelid);
        stb.append("_");
        stb.append(site);
        stb.append("_");
        stb.append(cardid);
        return stb.toString();
    }
}
