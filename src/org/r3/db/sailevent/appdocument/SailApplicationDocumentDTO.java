//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appdocument;

public class SailApplicationDocumentDTO extends SailApplicationDocumentDTOBase
{
	public enum DocumentType { r3ea_dtircstd, r3ea_dtorcintl, r3ea_dtircclub, r3ea_dtorcclub, r3ea_dtinsur, r3ea_dtadv, r3ea_dtboatimg, r3ea_doc, r3ea_dtreqprovrate, r3ea_dtcovidowner, r3ea_dtcovidcrew };
	
    public SailApplicationDocumentDTO()
    {
        super();
    }

    public SailApplicationDocumentDTO(SailApplicationDocumentDTO another)
    {
        super(another);
    }

    public static DocumentType getDocumenttypecodeAsEnum(String s)
    {
    	if (s != null)
    	{
    		try
    		{
    			return DocumentType.valueOf(s);	
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    		    	
    	return DocumentType.r3ea_doc;
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public DocumentType getDocumenttypecodeAsEnum()
    {
    	return getDocumenttypecodeAsEnum(getDocumenttypecode());
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImage()
    {
    	DocumentType c = getDocumenttypecodeAsEnum();
    	return c != null && c == DocumentType.r3ea_dtboatimg;
    }

}
