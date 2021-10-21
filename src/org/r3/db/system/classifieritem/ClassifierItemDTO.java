//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifieritem;

import java.util.List;

public class ClassifierItemDTO extends ClassifierItemDTOBase
{
    public ClassifierItemDTO()
    {
        super();
    }

    public ClassifierItemDTO(ClassifierItemDTO another)
    {
        super(another);
    }

    private int numberofchildren;

	public int getNumberofchildren()
	{
		return numberofchildren;
	}

	public void setNumberofchildren(int numberofchildren)
	{
		this.numberofchildren = numberofchildren;
	}

	private List<ClassifierItemDTO> children;
	
	public void setChildren(List<ClassifierItemDTO> aListOfChildren)
	{
		children = aListOfChildren;		
	}

	public List<ClassifierItemDTO> getChildren()
	{
		return children;		
	}

	public String getBusinesskey()
	{
		return getClsitembusid();
	}
}
