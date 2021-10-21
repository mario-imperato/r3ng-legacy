//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.r3.db.utils.DTOCSVStreamingOutput;

public class DMSFolderCSVStreamingOutput extends DTOCSVStreamingOutput
{
    private java.util.List<DMSFolderDTO> listOfDTOs;
    
    public DMSFolderCSVStreamingOutput(List<DMSFolderDTO> aListOfDTOs)
    {
        super(DMSFolderDTO.class);
    	  listOfDTOs = aListOfDTOs;
    }
        
	  public void write(OutputStream arg0) throws IOException, WebApplicationException
	  {
        PrintWriter prt = new PrintWriter(new OutputStreamWriter(arg0, "UTF-8"));
		    printlnHeader(prt);
		
				if (listOfDTOs != null)
				{
					for(DMSFolderDTO dto : listOfDTOs)
					{
						println(prt, dto);
					}
				}
		}

}
