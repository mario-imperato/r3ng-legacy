package org.r3.ws.actors.actor.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportContext;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportMajorType;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportMinorType;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportOptions;
import org.r3.system.rest.fileupload.FileUploadDTO;

public class CSVFileUploadDTO extends FileUploadDTO
{	
    
	public CSVFileUploadDTO()
	{
	}

	public CSVParser processFile(FileImportContext importContext, FileImportMajorType majorType, FileImportMinorType minorType, FileImportOptions importOptions) throws IOException
	{
		
		InputStream uploadInputStream = getFileInputStream();
		uploadInputStream.reset();

		BufferedReader br = new BufferedReader(new InputStreamReader(uploadInputStream));
		
		CSVFormat csvFormat = getCSVFormat(minorType, importOptions);		
		CSVParser csvParser = csvFormat.parse(br);
		
		return csvParser;
	}

	private CSVFormat getCSVFormat(FileImportMinorType minorType,
			FileImportOptions importOptions)
	{
		CSVFormat format = null;
		
		switch(minorType)
		{
		case comma:
			format = CSVFormat.DEFAULT.withDelimiter(',');
			break;
		case semicolon:
			format = CSVFormat.DEFAULT.withDelimiter(';');
			break;
		case tab:
			format = CSVFormat.TDF;
			break;			
		}
		
		if (format != null)
		{
		switch(importOptions)
		{
		case none:
			break;
			
		case withheader:
			format = format.withHeader();
			break;
		}
		}
				
		return format;
	}	
	
	
}
