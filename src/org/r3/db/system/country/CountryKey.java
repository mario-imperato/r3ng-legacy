//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.country;

public class CountryKey
{
    protected java.lang.String  iso3166_a3;


    /**
      * DataBean constructor.
      */
    public CountryKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public CountryKey(CountryKey another) 
    {    	
       iso3166_a3 = another.getIso3166_a3();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getIso3166_a3()         { return iso3166_a3; }
    
    public void setIso3166_a3(String  p)
    {
         iso3166_a3 = p;
    }
}
