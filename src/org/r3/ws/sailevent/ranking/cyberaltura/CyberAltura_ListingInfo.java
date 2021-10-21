package org.r3.ws.sailevent.ranking.cyberaltura;

import java.util.ArrayList;
import java.util.List;

public class CyberAltura_ListingInfo
{
	public static class CyberAlturaListingColumnInfo 
	{
		private int headerId;
		private List<String> listOfHeaderVariants;
		
		public CyberAlturaListingColumnInfo(int anHeaderId)
		{
			this(anHeaderId, null);
		}
		
		public CyberAlturaListingColumnInfo(int anHeaderId, String... defaultText)
		{
			headerId = anHeaderId;
			if (defaultText != null)
			{
				for(String t : defaultText)
					addHeaderTextVariant(t);				
			}
		}
		
		public void addHeaderTextVariant(String aHeaderText)
		{
			if (listOfHeaderVariants == null)
			{
				listOfHeaderVariants = new ArrayList<String>();
			}
			
			listOfHeaderVariants.add(aHeaderText);
		}

		public int getHeaderId()
		{
			return headerId;
		}

		public void setHeaderId(int headerId)
		{
			this.headerId = headerId;
		}
		
		public boolean headerMatches(String anHeaderText)
		{
			if (anHeaderText == null || anHeaderText.isEmpty() || listOfHeaderVariants == null)
				return false;
			
			for(String s : listOfHeaderVariants)
			{
				if (s.equalsIgnoreCase(anHeaderText))
				{
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static final int CRUCERO_LISTING_UNKNOWN_ID   			  =  -1;
	
	public static final int CRUCERO_LISTING_POS 					  =  1;
	public static final int CRUCERO_LISTING_N_VELICO                  =  2;
	public static final int CRUCERO_LISTING_CAS                       =  3;
	public static final int CRUCERO_LISTING_CLASSE                    =  4;
	public static final int CRUCERO_LISTING_DIV                       =  5;
	public static final int CRUCERO_LISTING_YACHT                     =  6;
	public static final int CRUCERO_LISTING_SPONSOR                   =  7;
	public static final int CRUCERO_LISTING_ARMATORE                  =  8;
	public static final int CRUCERO_LISTING_TIMONIERE                 =  9;
	public static final int CRUCERO_LISTING_CLUB                      = 10;
	public static final int CRUCERO_LISTING_MODELLO                   = 11;
	public static final int CRUCERO_LISTING_PROGETTO                  = 12;
	public static final int CRUCERO_LISTING_CANTIERE                  = 13;
	public static final int CRUCERO_LISTING_ANNO                      = 14;
	public static final int CRUCERO_LISTING_LOA                       = 15;
	public static final int CRUCERO_LISTING_LARGH                     = 16;
	public static final int CRUCERO_LISTING_D_CER_IRC                 = 17;
	public static final int CRUCERO_LISTING_O_CER_IRC                 = 18;
	public static final int CRUCERO_LISTING_TCC                       = 19;
	public static final int CRUCERO_LISTING_BSF                       = 20;
	public static final int CRUCERO_LISTING_D_CER_CIM                 = 21;
	public static final int CRUCERO_LISTING_O_CER_CIM                 = 22;
	public static final int CRUCERO_LISTING_APM_CIM                   = 23;
	public static final int CRUCERO_LISTING_PESO_EQ_                  = 24;
	public static final int CRUCERO_LISTING_CDL                       = 25;
	public static final int CRUCERO_LISTING_GPH                       = 26;
	public static final int CRUCERO_LISTING_D_CER_ORC                 = 27;
	public static final int CRUCERO_LISTING_O_CER_ORC                 = 28;
	public static final int CRUCERO_LISTING_TXD_INS_                  = 29;
	public static final int CRUCERO_LISTING_TXT_INS_                  = 30;
	public static final int CRUCERO_LISTING_PLT_INS_                  = 31;
	public static final int CRUCERO_LISTING_PLD_INS_                  = 32;
	public static final int CRUCERO_LISTING_T_NR_LOW_INS_             = 33;
	public static final int CRUCERO_LISTING_T_NR_MEDIUM_INS_          = 34;
	public static final int CRUCERO_LISTING_T_NR_HIGH_INS_            = 35;
	public static final int CRUCERO_LISTING_TXD_OFF_                  = 36;
	public static final int CRUCERO_LISTING_TXT_OFF_                  = 37;
	public static final int CRUCERO_LISTING_PLT_OFF_                  = 38;
	public static final int CRUCERO_LISTING_PLD_OFF_                  = 39;
	public static final int CRUCERO_LISTING_T_NR_LOW_OFF_             = 40;
	public static final int CRUCERO_LISTING_T_NR_MEDIUM_OFF_          = 41;
	public static final int CRUCERO_LISTING_T_NR_HIGH_OFF_            = 42;
	public static final int CRUCERO_LISTING_ORA_ARRIVO                = 43;
	public static final int CRUCERO_LISTING_T_REALE                   = 44;
	public static final int CRUCERO_LISTING_T_CORRETTI                = 45;
	public static final int CRUCERO_LISTING_OSS                       = 46;
	public static final int CRUCERO_LISTING_PUNTI_RDG                 = 47;
	public static final int CRUCERO_LISTING_PERC_PEN_TEM_             = 48;
	public static final int CRUCERO_LISTING_PERC_BON_TEM_             = 49;
	public static final int CRUCERO_LISTING_PERC_PEN_ALT_             = 50;
	public static final int CRUCERO_LISTING_PEN_POSTI                 = 51;
	public static final int CRUCERO_LISTING_V_IMPLICITO               = 52;
	public static final int CRUCERO_LISTING_POL                       = 53;
	public static final int CRUCERO_LISTING_PUNTI                     = 54;
	
	public static final int CRUCERO_LISTING_RACESCORE1                = 55;
	public static final int CRUCERO_LISTING_RACESCORE2                = 56;
	public static final int CRUCERO_LISTING_RACESCORE3                = 57;
	public static final int CRUCERO_LISTING_RACESCORE4                = 58;
	public static final int CRUCERO_LISTING_RACESCORE5                = 59;
	public static final int CRUCERO_LISTING_RACESCORE6                = 60;
	public static final int CRUCERO_LISTING_RACESCORE7                = 61;
	public static final int CRUCERO_LISTING_RACESCORE8                = 62;
	public static final int CRUCERO_LISTING_RACESCORE9                = 63;
	public static final int CRUCERO_LISTING_RACESCORE10               = 64;
	public static final int CRUCERO_LISTING_RACESCORE11               = 65;
	public static final int CRUCERO_LISTING_RACESCORE12               = 66;
	public static final int CRUCERO_LISTING_RACESCORE13               = 67;
	public static final int CRUCERO_LISTING_RACESCORE14               = 68;
	public static final int CRUCERO_LISTING_RACESCORE15               = 69;

	public static final List<CyberAlturaListingColumnInfo> rankEntriesColumns;
	public static final CyberAlturaListingColumnInfo unknownColumn = new CyberAlturaListingColumnInfo(CRUCERO_LISTING_UNKNOWN_ID, "Unknown");
	
	static 
	{
		rankEntriesColumns = new ArrayList<CyberAlturaListingColumnInfo>();

		rankEntriesColumns.add(/* 01 POS              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_POS 			 , "Pos"		    	 ));
		rankEntriesColumns.add(/* 02 N_VELICO         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_N_VELICO         , "N.Velico"            ));
		rankEntriesColumns.add(/* 03 CAS              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_CAS              , "Cas"                 ));
		rankEntriesColumns.add(/* 04 CLASSE           */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_CLASSE           , "Classe"              ));
		rankEntriesColumns.add(/* 05 DIV              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_DIV              , "Div"                 ));
		rankEntriesColumns.add(/* 06 YACHT            */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_YACHT            , "Yacht"               ));
		rankEntriesColumns.add(/* 07 SPONSOR          */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_SPONSOR          , "Sponsor"             ));
		rankEntriesColumns.add(/* 08 ARMATORE         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_ARMATORE         , "Armatore"            ));
		rankEntriesColumns.add(/* 09 TIMONIERE        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TIMONIERE        , "Timoniere"           ));
		rankEntriesColumns.add(/* 10 CLUB             */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_CLUB             , "Club"                ));
		rankEntriesColumns.add(/* 11 MODELLO          */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_MODELLO          , "Modello"             ));
		rankEntriesColumns.add(/* 12 PROGETTO         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PROGETTO         , "Progetto"            ));
		rankEntriesColumns.add(/* 13 CANTIERE         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_CANTIERE         , "Cantiere"            ));
		rankEntriesColumns.add(/* 14 ANNO             */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_ANNO             , "Anno"                ));
		rankEntriesColumns.add(/* 15 LOA              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_LOA              , "Loa"                 ));
		rankEntriesColumns.add(/* 16 LARGH            */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_LARGH            , "Largh"               ));
		rankEntriesColumns.add(/* 17 D_CER_IRC        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_D_CER_IRC        , "D.Cer.IRC"           ));
		rankEntriesColumns.add(/* 18 O_CER_IRC        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_O_CER_IRC        , "O.Cer.IRC"           ));
		rankEntriesColumns.add(/* 19 TCC              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TCC              , "TCC"                 ));
		rankEntriesColumns.add(/* 20 BSF              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_BSF              , "BSF"                 ));
		rankEntriesColumns.add(/* 21 D_CER_CIM        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_D_CER_CIM        , "D.Cer.CIM"           ));
		rankEntriesColumns.add(/* 22 O_CER_CIM        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_O_CER_CIM        , "O.Cer.CIM"           ));
		rankEntriesColumns.add(/* 23 APM_CIM          */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_APM_CIM          , "APM CIM"             ));
		rankEntriesColumns.add(/* 24 PESO_EQ_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PESO_EQ_         , "Peso eq."            ));
		rankEntriesColumns.add(/* 25 CDL              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_CDL              , "CDL"                 ));
		rankEntriesColumns.add(/* 26 GPH              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_GPH              , "GPH"                 ));
		rankEntriesColumns.add(/* 27 D_CER_ORC        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_D_CER_ORC        , "D.Cer.ORC"           ));
		rankEntriesColumns.add(/* 28 O_CER_ORC        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_O_CER_ORC        , "O.Cer.ORC"           ));
		rankEntriesColumns.add(/* 29 TXD_INS_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TXD_INS_         , "TxD Ins."            ));
		rankEntriesColumns.add(/* 30 TXT_INS_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TXT_INS_         , "TxT Ins."            ));
		rankEntriesColumns.add(/* 31 PLT_INS_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PLT_INS_         , "PLT Ins."            ));
		rankEntriesColumns.add(/* 32 PLD_INS_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PLD_INS_         , "PLD Ins."            ));
		rankEntriesColumns.add(/* 33 T_NR_LOW INS_    */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_LOW_INS_    , "T.nr.Low Ins."       ));
		rankEntriesColumns.add(/* 34 T_NR_MEDIUM INS_ */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_MEDIUM_INS_ , "T.nr.Medium Ins."    ));
		rankEntriesColumns.add(/* 35 T_NR_HIGH INS_   */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_HIGH_INS_   , "T.nr.High Ins."      ));
		rankEntriesColumns.add(/* 36 TXD_OFF_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TXD_OFF_         , "TxD Off."            ));
		rankEntriesColumns.add(/* 37 TXT_OFF_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_TXT_OFF_         , "TxT Off."            ));
		rankEntriesColumns.add(/* 38 PLT_OFF_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PLT_OFF_         , "PLT Off."            ));
		rankEntriesColumns.add(/* 39 PLD_OFF_         */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PLD_OFF_         , "PLD Off."            ));
		rankEntriesColumns.add(/* 40 T_NR_LOW OFF_    */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_LOW_OFF_    , "T.nr.Low Off."       ));
		rankEntriesColumns.add(/* 41 T_NR_MEDIUM_OFF_ */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_MEDIUM_OFF_ , "T.nr.Medium Off."    ));
		rankEntriesColumns.add(/* 42 T_NR_HIGH_OFF_   */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_NR_HIGH_OFF_   , "T.nr.High Off."      ));
		rankEntriesColumns.add(/* 43 ORA ARRIVO       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_ORA_ARRIVO       , "Ora Arrivo"          ));
		rankEntriesColumns.add(/* 44 T_REALE          */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_REALE          , "T.Reale"             ));
		rankEntriesColumns.add(/* 45 T_CORRETTI       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_T_CORRETTI       , "T.Corretti"          ));
		rankEntriesColumns.add(/* 46 OSS              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_OSS              , "Oss"                 ));
		rankEntriesColumns.add(/* 47 PUNTI_RDG        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PUNTI_RDG        , "Punti RDG"           ));
		rankEntriesColumns.add(/* 48 PERC_PEN_TEM_    */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PERC_PEN_TEM_    , "% Pen.Tem."          ));
		rankEntriesColumns.add(/* 49 PERC_BON_TEM_    */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PERC_BON_TEM_    , "% Bon.Tem."          ));
		rankEntriesColumns.add(/* 50 PERC_PEN_ALT_    */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PERC_PEN_ALT_    , "% Pen.Alt."          ));
		rankEntriesColumns.add(/* 51 PEN_POSTI        */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PEN_POSTI        , "Pen.Posti"           ));
		rankEntriesColumns.add(/* 52 V_IMPLICITO      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_V_IMPLICITO      , "V.Implicito"         ));
		rankEntriesColumns.add(/* 53 POL              */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_POL              , "Pol"                 ));
		rankEntriesColumns.add(/* 54 PUNTI            */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_PUNTI            , "Punti"               ));
		rankEntriesColumns.add(/* 55 RACESCORE1       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE1       , "RaceScore1"          ));
		rankEntriesColumns.add(/* 56 RACESCORE2       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE2       , "RaceScore2"          ));
		rankEntriesColumns.add(/* 57 RACESCORE3       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE3       , "RaceScore3"          ));
		rankEntriesColumns.add(/* 58 RACESCORE4       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE4       , "RaceScore4"          ));
		rankEntriesColumns.add(/* 59 RACESCORE5       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE5       , "RaceScore5"          ));
		rankEntriesColumns.add(/* 60 RACESCORE6       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE6       , "RaceScore6"          ));
		rankEntriesColumns.add(/* 61 RACESCORE7       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE7       , "RaceScore7"          ));
		rankEntriesColumns.add(/* 62 RACESCORE8       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE8       , "RaceScore8"          ));
		rankEntriesColumns.add(/* 63 RACESCORE9       */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE9       , "RaceScore9"          ));
		rankEntriesColumns.add(/* 64 RACESCORE10      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE10      , "RaceScore10"         ));
		rankEntriesColumns.add(/* 65 RACESCORE11      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE11      , "RaceScore11"         ));
		rankEntriesColumns.add(/* 66 RACESCORE12      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE12      , "RaceScore12"         ));
		rankEntriesColumns.add(/* 67 RACESCORE13      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE13      , "RaceScore13"         ));
		rankEntriesColumns.add(/* 68 RACESCORE14      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE14      , "RaceScore14"         ));
		rankEntriesColumns.add(/* 69 RACESCORE15      */ new CyberAlturaListingColumnInfo(CRUCERO_LISTING_RACESCORE15      , "RaceScore15"         ));	
	}
			
	public CyberAltura_ListingInfo()
	{

	}

	public static CyberAlturaListingColumnInfo getListingColumn4(String aListingHeaderColumnName)
	{
		for(CyberAlturaListingColumnInfo columnInfo : rankEntriesColumns)
		{
			if (columnInfo.headerMatches(aListingHeaderColumnName))
				return columnInfo;			
		}
		
		return unknownColumn;
	}
}
