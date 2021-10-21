package org.r3.ws.system.fileimport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.fileimport.fileimport.FileImportDTO;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportContext;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportMajorType;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportMinorType;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportOptions;
import org.r3.db.system.fileimport.fileimport.FileImportPersistence;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO.FileImportRecordType;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadDTOFactory;
import org.r3.system.rest.fileupload.FileUploadField;
import org.r3.system.rest.fileupload.FileUploadPattern;
import org.r3.ws.actors.actor.csv.CSVFileUploadDTO;
import org.r3.ws.actors.actor.csv.CSVFileUploadDTOFactory;

public class POSTCSVFileUpload extends FileUploadPattern
{
	public POSTCSVFileUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment, input, filePartName, new CSVFileUploadDTOFactory(), true, isIEFlag);
	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		List<FileUploadDTO> files = getFileUploadActionForm().getFiles();


		try
		{
			FileUploadField field = getFileUploadActionForm().getField("fileimport_minortype");			
			FileImportMinorType minorType = FileImportMinorType.getValueFor(field.getValue(), FileImportMinorType.comma); 
			
			field = getFileUploadActionForm().getField("fileimport_majortype");			
			FileImportMajorType majorType = FileImportMajorType.getValueFor(field.getValue(), FileImportMajorType.csv); 

			field = getFileUploadActionForm().getField("fileimport_importcontext");			
			FileImportContext importContext = FileImportContext.getValueFor(field.getValue(), FileImportContext.actor); 

			field = getFileUploadActionForm().getField("fileimport_importoptions");	
			FileImportOptions importOptions = FileImportOptions.getValueFor(field.getValue(), FileImportOptions.none); 
			
			CSVFileUploadDTO uploadedFile = (CSVFileUploadDTO)getFileUploadActionForm().getUploadedFile();
			if (uploadedFile != null)
			{
				CSVParser p = uploadedFile.processFile(importContext, majorType, minorType, importOptions);
				persistFileImportData(pcfg, aSession, senv.getRequestSiteId(), uploadedFile.getUploadFileName(), importContext, majorType, minorType, importOptions, p);			
			}
			
			uploadedFile.setValid(true);
			uploadedFile.setFileName(uploadedFile.getUploadFileName());
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
        finally
        {
        	
        }
		
		if (isIE())
			return serializeFiles(files);

		return new ArrayOfFileUploadDTO(files);
	}

	private void persistFileImportData(PersistenceContext pcfg,
			SqlSession aSession, String aSite, String uploadFileName, FileImportContext importContext,
			FileImportMajorType majorType, FileImportMinorType minorType,
			FileImportOptions importOptions, CSVParser p) throws IOException
	{
		List<CSVRecord> listOfRecords = p.getRecords();
	    int numRec = (listOfRecords != null) ? listOfRecords.size() : 0;
        
        FileImportPersistence fileImportPersistence = FileImportPersistence.createPersistenceObject(pcfg, aSession);
        FileImportDTO fileImportDTO = new FileImportDTO();
        fileImportDTO.setSite(aSite);
        fileImportDTO.setImportcontext(importContext.toString());
        fileImportDTO.setMajortype(majorType.toString());
        fileImportDTO.setMinortype(minorType.toString());
        fileImportDTO.setRecstatus(RecordStatus.sys_recact.toString());
        if (importOptions == FileImportOptions.withheader)
        	  fileImportDTO.setWithheader("btrue");
        else  fileImportDTO.setWithheader("bfalse");        
        fileImportDTO.setUploaddate(DTOBase.currentTimestamp());
        fileImportDTO.setImportname(uploadFileName);
        fileImportDTO.setNumberofrecords(numRec);               
        fileImportDTO.setNumberofcolumns(0);
        
        fileImportPersistence.insert(fileImportDTO, pcfg.getPersistenceConfigInfo());
        
        FileImportDataPersistence fileImportDataPersistence = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);
        FileImportDataDTO dataDTO = new FileImportDataDTO();
        dataDTO.setSite(aSite);
        dataDTO.setImportid(fileImportDTO.getImportid());
        
	    int numCols = 0;
        if (importOptions == FileImportOptions.withheader)
        {
        	Map<String, Integer> hmap = p.getHeaderMap();
        	if (hmap != null && hmap.size() > 0)
        	{
        		dataDTO.setRecordtype(FileImportRecordType.header.toString());
        		dataDTO.setRecordnumber(0);
        		int index = 1;
        		numCols = hmap.size();
        		
        		// Le chiavi debbono iterare per colonna. Pare cosi' dire dal javadoc
        		for(String colname : hmap.keySet())
        		{        			
        			if (!dataDTO.setColumn(index, colname))
        				break;
        			
        			index++;
        		}
        		
        		fileImportDataPersistence.insert(dataDTO, pcfg.getPersistenceConfigInfo());
        	}
        }
            
        dataDTO.setRecordtype(FileImportRecordType.datarecord.toString());
        for(CSVRecord r : listOfRecords)
        {
        	if (r.size() > numCols)
        		numCols = r.size();
        	
        	dataDTO.setImportdataid((Integer)null);
    		dataDTO.clearColumns();
    		        	
            dataDTO.setRecordnumber((int)(r.getRecordNumber()));
            for(int colIndex = 0; colIndex < r.size(); colIndex++)
            {
    			if (!dataDTO.setColumn(colIndex + 1, r.get(colIndex)))
    				break;            	
            }

    		fileImportDataPersistence.insert(dataDTO, pcfg.getPersistenceConfigInfo());
        }
        
        if (numCols > 0)
        {
        	fileImportDTO.setNumberofcolumns(numCols);
        	fileImportPersistence.updateByPrimaryKey(fileImportDTO, pcfg.getPersistenceConfigInfo());
        }
                
	}

}
