package org.r3.ws.sailevent.event.fivmemberverificationclient;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.r3.system.util.SystemUtils;
import org.r3.ws.sailevent.event.fivmemberverificationclient.RegattaCubedClient.HTTPRequestResult;

public class FIVMemberCardParser
{
	private static HashMap<String, HtmlItemParser> fivInfoFields;

	static 
	{
	fivInfoFields = new HashMap<String, HtmlItemParser>();
	
	fivInfoFields.put("name=\"txtCOG\""        , new InputTextParser("txtCOG",  "value=\""        )); // 
	fivInfoFields.put("name=\"txtNOM\""        , new InputTextParser("txtNOM",  "value=\""        )); // 
	fivInfoFields.put("name=\"txtDNAS\""       , new InputDateParser("txtDNAS", "value=\"" , new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("yyyy-MM-dd"), "00:00:00")); // 
	fivInfoFields.put("name=\"txtSEX\""        , new InputRadioParser("txtSEX", "value=\""       )); // radio checked
	fivInfoFields.put("name=\"txtLNAS\""       , new InputTextParser("txtLNAS", "value=\""       )); // 
	fivInfoFields.put("name=\"txtPNAS\""       , new InputSelectParser("txtPNAS", "value=\""     )); // 
	fivInfoFields.put("name=\"txtCF\""         , new InputTextParser("txtCF", "value=\""         )); // 
	fivInfoFields.put("name=\"hCFBloccato\""   , new InputTextParser("hCFBloccato", "value=\""   )); // 
	fivInfoFields.put("name=\"txtIND\""        , new InputTextParser("txtIND", "value=\""        )); // 
	fivInfoFields.put("name=\"txtNCIV\""       , new InputTextParser("txtNCIV", "value=\""       )); // 
	fivInfoFields.put("name=\"txtCIT\""        , new InputTextParser("txtCIT", "value=\""        )); // 
	fivInfoFields.put("name=\"txtCAP\""        , new InputTextParser("txtCAP", "value=\""        )); // 
	fivInfoFields.put("name=\"txtPRO\""        , new InputSelectParser("txtPRO", "value=\""      )); // select
	fivInfoFields.put("name=\"txtTEL\""        , new InputTextParser("txtTEL", "value=\""        )); // 
	fivInfoFields.put("name=\"txtCEL\""        , new InputTextParser("txtCEL", "value=\""        )); // 
	fivInfoFields.put("name=\"txtFAX\""        , new InputTextParser("txtFAX", "value=\""        )); // 
	fivInfoFields.put("name=\"txtEMAIL\""      , new InputTextParser("txtEMAIL", "value=\""      )); // 
	fivInfoFields.put("name=\"txtVISITA\""     , new InputSelectParser("txtVISITA", "value=\""   )); // 
	fivInfoFields.put("name=\"txtSCAD\""       , new InputDateParser("txtSCAD", "Value = \"", new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("yyyy-MM-dd"), "23:59:59"       )); // 
	fivInfoFields.put("name=\"txtQUALIFICA\""  , new InputSelectParser("txtQUALIFICA", "value=\"")); // select
	// fivInfoFields.put("name=\"txtDISA\""       , new InputMLSelectParser("name=\"txtDISA\""   )); // select non sulla stessa riga
	// fivInfoFields.put("name=\"chkRICP\""       , new InputRadioParser("name=\"chkRICP\""      )); // radio
	fivInfoFields.put("name=\"hSocieta\""      , new InputTextParser("hSocieta", "value=\""      )); // 
	fivInfoFields.put("name=\"hNTESS\""        , new InputTextParser("hNTESS", "value=\""        )); // 
	fivInfoFields.put("name=\"hRinnovo\""      , new RinnovoDateParser("hRinnovo", "value=\"", new SimpleDateFormat("yyyy-MM-dd")      )); // fine riga c'è la data rinnovo
	fivInfoFields.put("name=\"hStato\""        , new InputTextParser("hStato", "value=\""        )); // Vale 'A' per...
	// fivInfoFields.put("ChkTipoAtt1"            , new InputCheckBoxParser("ChkTipoAtt1"        )); // 
	// fivInfoFields.put("ChkTipoAtt2"            , new InputCheckBoxParser("ChkTipoAtt2"        )); // 
	// fivInfoFields.put("ChkTipoAtt3"            , new InputCheckBoxParser("ChkTipoAtt3"        )); // 
	// fivInfoFields.put("ChkTipoAtt7"            , new InputCheckBoxParser("ChkTipoAtt7"        )); // 
	// fivInfoFields.put("name=\"txtTATT\""       , new InputMLRadioParser("name=\"txtTATT\""    )); // radio ... su più righe. Risulta disabled.
	fivInfoFields.put("name=\"hIDP\""          , new InputTextParser("hIDP", "value=\""          )); // 
	fivInfoFields.put("name=\"hIDT\""          , new InputTextParser("hIDT", "value=\""          )); // 
	fivInfoFields.put("name=\"hIDS\""          , new InputTextParser("hIDS", "value=\""          )); // 
	fivInfoFields.put("name=\"hIDSSOC\""       , new InputTextParser("hIDSSOC", "value=\""       )); // 

	}

	public HtmlItemParser findParserForLine(String aTextLine)
	{
	    for( String matchingKey : fivInfoFields.keySet())
	    {
	        if (aTextLine.indexOf(matchingKey) >= 0)
	        {
	            return fivInfoFields.get(matchingKey);
	        }
	    }
	    
	    return null;
	}

	private HTTPRequestResult pageInfo;
		
	public String getParsedValueFor(String aFieldName)
	{
	    return getPageInfo().getPageInfoParameter(aFieldName);	
	}
	
	public void dumpParsedValues()
	{
	    getPageInfo().dumpPageInfo();
	}
	
	public HTTPRequestResult getPageInfo()
    {
		if (pageInfo == null)
		{
			pageInfo = new HTTPRequestResult();
			pageInfo.setReturnCode(true);
		}
		return pageInfo;
    }
	
	public void parse(BufferedReader bd, boolean dumpBodyFlag, File logFile) throws IOException
	{
		PrintWriter prt = null;
		
		try
		{
			if (dumpBodyFlag)
			    prt = new PrintWriter(new FileWriter(logFile));
			
			int lineNumber = 0;
			String line = bd.readLine();
			while(line != null)
			{
				if (dumpBodyFlag)
				 prt.println(line);
				
				lineNumber++;
				HtmlItemParser p = findParserForLine(line);
				if (p != null)
				{
					p.parse(line);
					String value = p.getParsedValue();
					if (value != null)
						getPageInfo().addPageInfo(p.getFieldName(), value);
				}
				line = bd.readLine();
			}
			
			System.out.println("NumberOfLines: " + lineNumber);
		}
		finally
		{
			SystemUtils.close(prt);
		}
	}
	
	public void parse(InputStream is, boolean dumpBodyFlag, File logFile) throws IOException
	{
    	BufferedReader bd = null;    	
        try
        {
            try
			{
				bd = new BufferedReader(new InputStreamReader(is));
				
				parse(bd, dumpBodyFlag, logFile);	
				// dumpParsedValues();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
        }
        finally
        {
        	SystemUtils.close(bd);
        }
	}
	
    public static void main(String[] args)
    {
    	String fileName = "Z:\\DiscoF\\shuttle\\temp\\Sito_FIV_tessere\\response_5.txt";
    	    	
		try
		{
			FIVMemberCardParser parser = new FIVMemberCardParser();
			parser.parse(new FileInputStream(fileName), false, null);
			parser.dumpParsedValues();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }

}
