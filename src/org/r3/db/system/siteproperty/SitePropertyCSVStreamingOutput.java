//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.r3.db.utils.DTOCSVStreamingOutput;

public class SitePropertyCSVStreamingOutput extends DTOCSVStreamingOutput
{
    private java.util.List<SitePropertyDTO> listOfDTOs;
    
    public SitePropertyCSVStreamingOutput(List<SitePropertyDTO> aListOfDTOs)
    {
        super(SitePropertyDTO.class);
    	  listOfDTOs = aListOfDTOs;
    }
        
	  public void write(OutputStream arg0) throws IOException, WebApplicationException
	  {
        PrintWriter prt = new PrintWriter(new OutputStreamWriter(arg0, "UTF-8"));
		    printlnHeader(prt);
		
				if (listOfDTOs != null)
				{
					for(SitePropertyDTO dto : listOfDTOs)
					{
						println(prt, dto);
					}
				}
		}

}
