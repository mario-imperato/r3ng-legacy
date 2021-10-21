package org.r3.ws.system.velocity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class VelocityStreamingOutput implements StreamingOutput
{
	protected VelocityTemplateRenderer renderer = null;

	public VelocityStreamingOutput(VelocityTemplateModel aVelocityEngine, String aScriptName)
	{
		renderer = aVelocityEngine.newRendererInstance(aScriptName, null);
	}

	public void addParameter(String paramName, Object paramValue)
	{
		renderer.add(paramName, paramValue);
	}

	public void write(OutputStream arg0) throws IOException,
			WebApplicationException
	{
		PrintWriter prt = new PrintWriter(new OutputStreamWriter(arg0, "UTF-8"));
			
        String mergedTemplate = getMergedTemplate();
         if (mergedTemplate != null)
        	 prt.print(mergedTemplate);
         
         prt.flush();
	}

	protected String getMergedTemplate()
	{
		String batchStatement;
		try
		{
			batchStatement = renderer.mergeTemplate();
			return batchStatement;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
