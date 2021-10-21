//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.racegroupview;

public class SailRaceGroupViewDTO extends SailRaceGroupViewDTOBase
{
	public SailRaceGroupViewDTO()
	{
		super();
	}

	public SailRaceGroupViewDTO(SailRaceGroupViewDTO another)
	{
		super(another);
	}

	public String getDtokey()
	{
		StringBuilder stb = new StringBuilder();
		stb.append(parentitemid);
		
		if (childitemid != null)
		{
		stb.append(";");
		stb.append(childitemid);
		}
		
		return stb.toString();
	}

	public String getDtodescr()
	{
		boolean notNull = false;
		StringBuilder stb = new StringBuilder();
		if (parentitemdescr != null)
		{
			stb.append(parentitemdescr);
			notNull = true;
		}
		if (childitemdescr != null)
		{
			stb.append(" ");
			stb.append(childitemdescr);
			notNull = true;
		}
		if (notNull)
			return stb.toString();

		return null;
	}

}
