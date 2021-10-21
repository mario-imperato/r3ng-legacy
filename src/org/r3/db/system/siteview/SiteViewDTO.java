//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteview;

public class SiteViewDTO extends SiteViewDTOBase
{
    public SiteViewDTO()
    {
        super();
    }

    public SiteViewDTO(SiteViewDTO another)
    {
        super(another);
    }



    protected java.lang.String  sitelayout;
    protected java.lang.String  siteresourcepath;
    protected java.lang.String  sitecss;
    protected java.lang.String  siteconsolecss;
    protected java.lang.String  sitetheme;
    protected java.lang.String  refsitetype;
    protected java.lang.String  refsite;
    protected java.lang.String  refsitevisible;
    protected java.lang.String  refsitedescr;
    protected java.lang.String  admrefsitetype;
    protected java.lang.String  admrefsite;
    protected java.lang.String  admrefsitevisible;
    protected java.lang.String  admrefsitedescr;
    protected java.lang.String  cardid;
    protected java.lang.String  options;
	public java.lang.String getSitelayout()
	{
		return sitelayout;
	}

	public void setSitelayout(java.lang.String sitelayout)
	{
		this.sitelayout = sitelayout;
	}

	public java.lang.String getSitecss()
	{
		return sitecss;
	}

	public void setSitecss(java.lang.String sitecss)
	{
		this.sitecss = sitecss;
	}

	public java.lang.String getSiteconsolecss()
	{
		return siteconsolecss;
	}

	public void setSiteconsolecss(java.lang.String siteconsolecss)
	{
		this.siteconsolecss = siteconsolecss;
	}

	public java.lang.String getSitetheme()
	{
		return sitetheme;
	}

	public void setSitetheme(java.lang.String sitetheme)
	{
		this.sitetheme = sitetheme;
	}

	public java.lang.String getRefsitetype()
	{
		return refsitetype;
	}

	public void setRefsitetype(java.lang.String refsitetype)
	{
		this.refsitetype = refsitetype;
	}

	public java.lang.String getRefsite()
	{
		return refsite;
	}

	public void setRefsite(java.lang.String refsite)
	{
		this.refsite = refsite;
	}

	public java.lang.String getRefsitevisible()
	{
		return refsitevisible;
	}

	public void setRefsitevisible(java.lang.String refsitevisible)
	{
		this.refsitevisible = refsitevisible;
	}

	public java.lang.String getRefsitedescr()
	{
		return refsitedescr;
	}

	public void setRefsitedescr(java.lang.String refsitedescr)
	{
		this.refsitedescr = refsitedescr;
	}

	public java.lang.String getAdmrefsitetype()
	{
		return admrefsitetype;
	}

	public void setAdmrefsitetype(java.lang.String admrefsitetype)
	{
		this.admrefsitetype = admrefsitetype;
	}

	public java.lang.String getAdmrefsite()
	{
		return admrefsite;
	}

	public void setAdmrefsite(java.lang.String admrefsite)
	{
		this.admrefsite = admrefsite;
	}

	public java.lang.String getAdmrefsitevisible()
	{
		return admrefsitevisible;
	}

	public void setAdmrefsitevisible(java.lang.String admrefsitevisible)
	{
		this.admrefsitevisible = admrefsitevisible;
	}

	public java.lang.String getAdmrefsitedescr()
	{
		return admrefsitedescr;
	}

	public void setAdmrefsitedescr(java.lang.String admrefsitedescr)
	{
		this.admrefsitedescr = admrefsitedescr;
	}

	public java.lang.String getCardid()
	{
		return cardid;
	}

	public void setCardid(java.lang.String cardid)
	{
		this.cardid = cardid;
	}

	public java.lang.String getOptions()
	{
		return options;
	}

	public void setOptions(java.lang.String options)
	{
		this.options = options;
	}

	public void setSiteresourcepath(java.lang.String siteresourcepath)
	{
		this.siteresourcepath = siteresourcepath;
	}

	public String getSiteresourcepath()
	{
        String p = siteresourcepath;
        if (p == null)
        {
        	return "default";
        }
        
        return p;
	}
}
