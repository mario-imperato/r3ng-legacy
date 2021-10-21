//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

public class DMSFolderKey
{
    protected java.lang.String  folderid;


    /**
      * DataBean constructor.
      */
    public DMSFolderKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public DMSFolderKey(DMSFolderKey another) 
    {    	
       folderid = another.getFolderid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getFolderid()         { return folderid; }
    
    public void setFolderid(String  p)
    {
         folderid = p;
    }
}
