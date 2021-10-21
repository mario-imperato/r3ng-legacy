//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardfullview;

import java.util.List;

import org.r3.db.cms.cardproperty.CardPropertyDTO;

public class CardFullViewDTO extends CardFullViewDTOBase
{
    public CardFullViewDTO()
    {
        super();
    }

    public CardFullViewDTO(CardFullViewDTO another)
    {
        super(another);
    }

    private List<CardPropertyDTO> properties;

	public List<CardPropertyDTO> getProperties()
	{
		return properties;
	}

	public void setProperties(List<CardPropertyDTO> properties)
	{
		this.properties = properties;
	}
    
}
