//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

public class FileImportDTO extends FileImportDTOBase
{
	public enum FileImportContext 
	{
		actor;
		
		public static FileImportContext getValueFor(String s, FileImportContext defaultContext)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultContext;
		}
	}
	
	public enum FileImportMajorType 
	{
		csv;
		
		public static FileImportMajorType getValueFor(String s, FileImportMajorType defaultMajorType)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultMajorType;
		}
	}
	
	public enum FileImportMinorType 
	{
		comma, semicolon, tab;
		
		public static FileImportMinorType getValueFor(String s, FileImportMinorType defaultMinorType)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultMinorType;
		}
	}

	public enum FileImportOptions 
	{
		none, withheader;
		
		public static FileImportOptions getValueFor(String s, FileImportOptions defaultOptions)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultOptions;
		}
	}

	public enum FileImportFields
	{
		fimp_none, fimp_firstname, fimp_lastname, fimp_firstlast, fimp_lastfirst, fimp_phone, fimp_cellphone, fimp_email,
		fimp_state, fimp_district, fimp_county, fimp_town, fimp_zipcode, fimp_address, fimp_membershipid;
		
		public static FileImportFields getValueFor(String s, FileImportFields defaultOptions)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultOptions;
		}		
	}		
	
	public enum FileImportProcessingOptions 
	{
		none, mail_required, checkduplicates;
		
		public static FileImportProcessingOptions getValueFor(String s, FileImportProcessingOptions defaultOptions)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultOptions;
		}
	}
	
    public FileImportDTO()
    {
        super();
    }

    public FileImportDTO(FileImportDTO another)
    {
        super(another);
    }

}
