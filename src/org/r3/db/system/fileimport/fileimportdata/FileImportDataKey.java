//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimportdata;

public class FileImportDataKey
{
    protected java.lang.Integer  importdataid;


    /**
      * DataBean constructor.
      */
    public FileImportDataKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public FileImportDataKey(FileImportDataKey another) 
    {    	
       importdataid = another.getImportdataid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.Integer   getImportdataid() { return importdataid; }
    
    public void setImportdataid(java.lang.Integer  p)
    {
    	importdataid = p;
    }
    public void setImportdataid(int p)
    {
    	setImportdataid(new java.lang.Integer(p));
    }
    public void setImportdataid()
    {
    	setImportdataid(0);
    }
}
