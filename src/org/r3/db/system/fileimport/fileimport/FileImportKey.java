//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

public class FileImportKey
{
    protected java.lang.String  site;
    protected java.lang.String  importid;


    /**
      * DataBean constructor.
      */
    public FileImportKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public FileImportKey(FileImportKey another) 
    {    	
       site = another.getSite();
       importid = another.getImportid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getImportid()         { return importid; }
    
    public void setImportid(String  p)
    {
         importid = p;
    }
}
