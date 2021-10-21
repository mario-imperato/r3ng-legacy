package org.r3.db.cms.attachmenttype;


public class AttachmentTypeLUTBase
{
//	public enum ClassifierLUTName
//	{
//		grp_uff_type, uff_type, sottoarea_type, ita_regione, ita_provincia, ita_localita, d_titolo, grp_groupstruct,
//		esitonotifica1, esitonotifica2, scanitemtype, op_plichi, _23l_causesito, pmr_causesito, docaccesstype
//	}
//	
//	private static LUTSet setTable;
//
//	static
//	{
//		setTable = new LUTSet("UNEPClassifierItemLUTBase");
//		try
//		{
//			setTable.setReader(ClassifierLUTName.esitonotifica1.toString()                , new UNEPClassifierItemLUTReader("esitonotifica1"          ));
//			setTable.setReader(ClassifierLUTName.esitonotifica2.toString()                , new UNEPClassifierItemLUTReader("esitonotifica2"          ));
//			
//			setTable.setReader("usr_type"                , new UNEPClassifierItemLUTReader("usr_type"          ));
//			setTable.setReader("usr_roleclass"           , new UNEPClassifierItemLUTReader("usr_roleclass"     ));
//			setTable.setReader(ClassifierLUTName.uff_type.toString(), new UNEPClassifierItemLUTReader("uff_type"        ,1  ));
//			setTable.setReader(ClassifierLUTName.grp_uff_type.toString(), new UNEPClassifierItemLUTReader("uff_type"     ,0  ));
//			setTable.setReader("uac_procstatus"          , new UNEPClassifierItemLUTReader("uac_procstatus"    ));
//			setTable.setReader("uac_pkgstatus"           , new UNEPClassifierItemLUTReader("uac_pkgstatus"     ));
//			setTable.setReader("uac_fprocstatus"         , new UNEPClassifierItemLUTReader("uac_fprocstatus"   ));
//			setTable.setReader("uac_filetype"            , new UNEPClassifierItemLUTReader("uac_filetype"      ));
//			setTable.setReader("uac_fgpstatus"           , new UNEPClassifierItemLUTReader("uac_fgpstatus"     ));
//			setTable.setReader("uac_fgpmintype"          , new UNEPClassifierItemLUTReader("uac_fgpmintype"    ));
//			setTable.setReader("uac_fgpmajtype"          , new UNEPClassifierItemLUTReader("uac_fgpmajtype"    ));
//			setTable.setReader("tasks_attivo"            , new UNEPClassifierItemLUTReader("tasks_attivo"      ));
//			setTable.setReader("sys_recstatus_"          , new UNEPClassifierItemLUTReader("sys_recstatus_"    ));
//			setTable.setReader("sys_recstatus"           , new UNEPClassifierItemLUTReader("sys_recstatus"     ));
//			setTable.setReader("sys_doctype"             , new UNEPClassifierItemLUTReader("sys_doctype"       ));
//			setTable.setReader("sys_cnttype"             , new UNEPClassifierItemLUTReader("sys_cnttype"       ));
//			setTable.setReader("sys_ambit"               , new UNEPClassifierItemLUTReader("sys_ambit"         ));
//			setTable.setReader("statoscansione"          , new UNEPClassifierItemLUTReader("statoscansione"    ));
//			setTable.setReader("statoscanitem"           , new UNEPClassifierItemLUTReader("statoscanitem"     ));
//			setTable.setReader(ClassifierLUTName.sottoarea_type.toString(), new UNEPClassifierItemLUTReader("sottoarea_type"    ));
//			setTable.setReader(ClassifierLUTName.scanitemtype.toString(), new UNEPClassifierItemLUTReader("scanitemtype"      ));
//			setTable.setReader("que_type"                , new UNEPClassifierItemLUTReader("que_type"          ));
//			setTable.setReader("que_msgstatus"           , new UNEPClassifierItemLUTReader("que_msgstatus"     ));
//			setTable.setReader("que_msgprior"            , new UNEPClassifierItemLUTReader("que_msgprior"      ));
//			setTable.setReader("qimg"                    , new UNEPClassifierItemLUTReader("qimg"              ));
//			setTable.setReader("pmr_checks"              , new UNEPClassifierItemLUTReader("pmr_checks"        ));
//			setTable.setReader(ClassifierLUTName.pmr_causesito.toString()                , new UNEPClassifierItemLUTReader("pmr_causesito"     ));
//			setTable.setReader("pcg_checks"              , new UNEPClassifierItemLUTReader("pcg_checks"        ));
//			setTable.setReader("opano_checks"            , new UNEPClassifierItemLUTReader("opano_checks"      ));
//			setTable.setReader(ClassifierLUTName.op_plichi.toString(), new UNEPClassifierItemLUTReader("op_plichi"         ));
//			setTable.setReader("modoripartiz"            , new UNEPClassifierItemLUTReader("modoripartiz"      ));
//			setTable.setReader(ClassifierLUTName.ita_regione.toString()            , new UNEPClassifierItemLUTReader("ita"            , 0));
//			setTable.setReader(ClassifierLUTName.ita_provincia.toString()           , new UNEPClassifierItemLUTReader("ita"            , 1));
//			setTable.setReader(ClassifierLUTName.ita_localita.toString()            , new UNEPClassifierItemLUTReader("ita"            , 2));
//			setTable.setReader("i_type"                  , new UNEPClassifierItemLUTReader("i_type"            ));
//			setTable.setReader("i_status"                , new UNEPClassifierItemLUTReader("i_status"          ));
//			setTable.setReader("grp_regstruct"           , new UNEPClassifierItemLUTReader("grp_regstruct"     ));
//			setTable.setReader(ClassifierLUTName.grp_groupstruct.toString()        , new UNEPClassifierItemLUTReader("grp_groupstruct"   ));
//			setTable.setReader("esito_invio"             , new UNEPClassifierItemLUTReader("esito_invio"       ));
//			setTable.setReader(ClassifierLUTName.d_titolo.toString()                , new UNEPClassifierItemLUTReader("d_titolo"          ));
//			setTable.setReader("clav_type"               , new UNEPClassifierItemLUTReader("clav_type"         ));
//			setTable.setReader("cad_checks"              , new UNEPClassifierItemLUTReader("cad_checks"        ));
//			setTable.setReader("arcad_checks"            , new UNEPClassifierItemLUTReader("arcad_checks"      ));
//			setTable.setReader("23lplicrituff"           , new UNEPClassifierItemLUTReader("23lplicrituff"     ));
//			setTable.setReader("23lplicnotrit"           , new UNEPClassifierItemLUTReader("23lplicnotrit"     ));
//			setTable.setReader("23lcons"                 , new UNEPClassifierItemLUTReader("23lcons"           ));
//			setTable.setReader(ClassifierLUTName._23l_causesito.toString()                ,  new UNEPClassifierItemLUTReader("23l_causesito"     ));
//			setTable.setReader(ClassifierLUTName.docaccesstype.toString()                ,  new UNEPClassifierItemLUTReader("docaccesstype"     ));
//			
//			setTable.setTimeout(300000);
//		}
//		catch (LUTException e)
//		{
//		}
//	}
//	
//	public static LUTSet getLUTSet()  {  return setTable; }
//
//	public static UNEPClassifierItemDTO getItem(ClassifierLUTName aclassifierid, String aDtokey)
//	{
//	    try
//		{
//		    LUTSet lutBase = getLUTSet();
//		    UNEPClassifierItemDTO dto = (UNEPClassifierItemDTO)lutBase.getInstance(aclassifierid.toString()).getItem(aDtokey);
//		    if (dto == null)
//		    {
//		    	System.out.println("Error: Could not find LUT Data for " + aDtokey + " on " + aclassifierid);
//		        return null;
//		    }
//			return dto;
//		}
//		catch (LUTException e1)
//		{
//			e1.printStackTrace();
//		}
//	    
//	    return null;
//	}
//
//	public static String getDtodescr(ClassifierLUTName aclassifierid, String aDtokey)
//	{
//		UNEPClassifierItemDTO dto = getItem(aclassifierid, aDtokey);
//		if (dto != null)
//			return dto.classifieritemdescr;
//			    
//	    return null;
//	}
}
