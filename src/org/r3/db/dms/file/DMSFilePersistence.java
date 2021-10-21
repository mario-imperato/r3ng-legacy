//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.dms.model.DMSContext;

public class DMSFilePersistence extends DMSFilePersistenceBase
{
  public static DMSFilePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  DMSFilePersistence p = new DMSFilePersistence();
	    p.setMapper(aSession.getMapper(DMSFileMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

	public DMSFileDTO selectByFilenameFolderphysicalpath(String aFileName, String physicalName, PersistenceConfigInfo persistenceContext)
	{
      DMSFileFilter filter = new DMSFileFilter();
      filter.or().andFilenameEqualTo(aFileName).andFilephysicalpathEqualTo(physicalName);
		
      List<DMSFileDTO> listOf = select(filter, persistenceContext);
      if (listOf != null && listOf.size() > 0)
      	return listOf.get(0);
          
		return null;
	}

	public int streamFilebodyByFileid(OutputStream anOutputStream, String fileid, DMSContext aDmsContext) throws IOException
	{
		byte[] stream = selectFilebodyByFileid(fileid, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
		
		int written = 0;
		if (stream.length > 0)
		{
			anOutputStream.write(stream, 0, stream.length);
			written = stream.length;
		}
		
		return written;
	}

	public void storeFilebodyByFileid(InputStream finp, String aFileId, int contentLength, PersistenceConfigInfo persistenceContext) throws IOException
	{        	
		byte[] filebody = null;
		
		if (contentLength > 0)
		{
			filebody = new byte[contentLength];
			finp.read(filebody);
			storeFilebodyByFileid(filebody, aFileId, persistenceContext);			
		}
	}

	public DMSFileDataTableAdapter selectFilesInFolder(
					String physicalName, PersistenceConfigInfo persistenceContext, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
      DMSFileFilter filter = new DMSFileFilter();
      filter.or().andFilephysicalpathEqualTo(physicalName);
		
      DMSFileDataTableAdapter dt = query(filter, persistenceContext, sEcho, iDisplayStart, iDisplayLength, countElements);        
      return dt;
      
	}

	public void deleteByFilephysicalpath(String physicalName, PersistenceConfigInfo persistenceContext)
	{
		DMSFileFilter filter = new DMSFileFilter();
		filter.or().andFilephysicalpathEqualTo(physicalName);

		delete(filter, persistenceContext);
	}
	
}
  
