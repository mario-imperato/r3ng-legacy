package org.r3.system.rest.fileupload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class ReportTrackerFileUploadDTO extends FileUploadDTO
{

	public ReportTrackerFileUploadDTO()
	{

	}

	@Override
	public void applyUploadOptions() throws IOException
	{
		String newLine = System.getProperty("line.separator");
		
		InputStream uploadInputStream = getFileInputStream();
		uploadInputStream.reset();

		BufferedReader br = new BufferedReader(new InputStreamReader(uploadInputStream));
		
		String line = matchLine(br, "<DIV id=\"rptmeta\">");
		if (line == null)
		{
			throw new IOException("Could not find <DIV id=\"rptmeta\"> starting line....");
		}
		
		StringBuilder stb = new StringBuilder();
		stb.append("<div class='tacktracker'>").append(newLine);
		stb.append(line).append(newLine);
		
		line = br.readLine();
		while(line != null)
		{
			int ndx = line.indexOf("</BODY></HTML>");
			if(ndx >= 0)
			{
				 stb.append(line.substring(0, ndx)).append(newLine);
			}
			else stb.append(line).append(newLine);
			line = br.readLine();			
		}
		
		stb.append("</div>").append(newLine);
		super.setFileInputStream(IOUtils.toInputStream(stb.toString()));
	}
	
	private String matchLine(BufferedReader br, String s) throws IOException
	{
        String line = br.readLine();
		
		while(line != null)
		{
			line = line.trim();
			if (line.equalsIgnoreCase("<DIV id=\"rptmeta\">"))
					break;
			
			line = br.readLine();
		}	
		
		return line;
	}

}
