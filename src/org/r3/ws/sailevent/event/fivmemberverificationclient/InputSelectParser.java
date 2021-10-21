package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputSelectParser extends HtmlItemParser
{
    public InputSelectParser(String aMatchingString, String aValuePattern)
    {
    	super(aMatchingString, aValuePattern);
    }

    @Override
    public boolean parse(String aLine)
    {
    	String s = getOptionSelectedValueFromLine(aLine, getValuePattern());
    	setParsedValue(s);
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
    	String line = "						<TD align=\"left\" height=\"30\"><select name=\"txtPNAS\"><option value=\"\">...</option><option  value=\"AG\">AG</option><option  value=\"AL\">AL</option><option  value=\"AN\">AN</option><option  value=\"AO\">AO</option><option  value=\"AP\">AP</option><option  value=\"AQ\">AQ</option><option  value=\"AR\">AR</option><option  value=\"AT\">AT</option><option  value=\"AV\">AV</option><option  value=\"BA\">BA</option><option  value=\"BG\">BG</option><option  value=\"BI\">BI</option><option  value=\"BL\">BL</option><option  value=\"BN\">BN</option><option  value=\"BO\">BO</option><option  value=\"BR\">BR</option><option  value=\"BS\">BS</option><option  value=\"BZ\">BZ</option><option  value=\"CA\">CA</option><option  value=\"CB\">CB</option><option  value=\"CE\">CE</option><option  value=\"CH\">CH</option><option  value=\"CL\">CL</option><option  value=\"CN\">CN</option><option  value=\"CO\">CO</option><option  value=\"CR\">CR</option><option  value=\"CS\">CS</option><option  value=\"CT\">CT</option><option  value=\"CZ\">CZ</option><option  value=\"EN\">EN</option><option  value=\"FC\">FC</option><option  value=\"FE\">FE</option><option  value=\"FG\">FG</option><option  value=\"FI\">FI</option><option  value=\"FM\">FM</option><option  value=\"FR\">FR</option><option  value=\"GE\">GE</option><option  value=\"GO\">GO</option><option  value=\"GR\">GR</option><option  value=\"IM\">IM</option><option  value=\"IS\">IS</option><option  value=\"KR\">KR</option><option  value=\"LC\">LC</option><option  value=\"LE\">LE</option><option  value=\"LI\">LI</option><option  value=\"LO\">LO</option><option  value=\"LT\">LT</option><option  value=\"LU\">LU</option><option  value=\"MC\">MC</option><option  value=\"ME\">ME</option><option  value=\"MI\">MI</option><option  value=\"MN\">MN</option><option  value=\"MO\">MO</option><option  value=\"MS\">MS</option><option  value=\"MT\">MT</option><option  value=\"NA\">NA</option><option  value=\"NO\">NO</option><option  value=\"NU\">NU</option><option  value=\"OR\">OR</option><option  value=\"PA\">PA</option><option  value=\"PC\">PC</option><option  value=\"PD\">PD</option><option  value=\"PE\">PE</option><option  value=\"PG\">PG</option><option  value=\"PI\">PI</option><option  value=\"PL\">PL</option><option  value=\"PN\">PN</option><option  value=\"PO\">PO</option><option selected value=\"PR\">PR</option><option  value=\"PT\">PT</option><option  value=\"PU\">PU</option><option  value=\"PV\">PV</option><option  value=\"PZ\">PZ</option><option  value=\"RA\">RA</option><option  value=\"RC\">RC</option><option  value=\"RE\">RE</option><option  value=\"RG\">RG</option><option  value=\"RI\">RI</option><option  value=\"RM\">RM</option><option  value=\"RN\">RN</option><option  value=\"RO\">RO</option><option  value=\"SA\">SA</option><option  value=\"SI\">SI</option><option  value=\"SO\">SO</option><option  value=\"SP\">SP</option><option  value=\"SR\">SR</option><option  value=\"SS\">SS</option><option  value=\"SV\">SV</option><option  value=\"TA\">TA</option><option  value=\"TE\">TE</option><option  value=\"TN\">TN</option><option  value=\"TO\">TO</option><option  value=\"TP\">TP</option><option  value=\"TR\">TR</option><option  value=\"TS\">TS</option><option  value=\"TV\">TV</option><option  value=\"UD\">UD</option><option  value=\"VA\">VA</option><option  value=\"VB\">VB</option><option  value=\"VC\">VC</option><option  value=\"VE\">VE</option><option  value=\"VI\">VI</option><option  value=\"VR\">VR</option><option  value=\"VT\">VT</option><option  value=\"VV\">VV</option><option  value=\"ZA\">ZA</option>";
    	
    	HtmlItemParser p = new InputSelectParser("txtPNAS", "value=\"");
    	p.parse(line);
    	System.out.println(p.getParsedValue());
    }

}    