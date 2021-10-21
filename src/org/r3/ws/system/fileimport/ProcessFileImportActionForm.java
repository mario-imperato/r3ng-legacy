package org.r3.ws.system.fileimport;

import javax.ws.rs.FormParam;

import org.r3.system.rest.SecurityTokenActionForm;

public class ProcessFileImportActionForm extends SecurityTokenActionForm
{

	@FormParam("columnmatch")
    private String[] columnmatch;

    public String[] getColumnmatch()
    {    	
    	return columnmatch;
    }
	
	@FormParam("processingopts")
    private String[] processingopts;

    public String[] getProcessingopts()
    {    	
    	return processingopts;
    }    
}
