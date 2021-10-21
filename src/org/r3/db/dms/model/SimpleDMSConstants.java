/**
 * Nome File 	: SimpleDMSConstants.java
 * Progetto 	: gwf_struts
 * Sottosistema : gwfdms
 * Modulo 		: dms
 * Errori		:
 * Description	: classe che contiene le sole constanti di definizione di
 *				  SimpleDMS
 *
 * Modifiche :
 *          01/03/2006 :     -prima versione
 */
package org.r3.db.dms.model;
//
/**
 * Definisce le sole costanti che servono al package SimpleDMS.
 * Le costanti sono incluse in questa classe per evitare
 * che esistano troppe classi che dipendano una dall'altra in modo
 * incrociato (prima le costanti erano definite nella classe
 * SimpleDMS)
 *
 * @author 		ldm
 * @version 	$Revision: 1.6 $
 * @since   	versione 1.0
 *
 */
final public class SimpleDMSConstants
{
	/***************************************************************************
	*
	*	Costanti Private Statiche
	*
	***************************************************************************/
   /**
    * Se queste costanta è true abilita (forse) le trace di debug
    * attraverso apache.commons.logging (ma questo dipende anche dalla
    * configurazione dello specifica Log).
    * Se questa è false tutte le trace e tutte le variabili
    * definite per il debug vengono tolte.
    * Notare che le classi statiche della Log, tipicamente una o più per
    * package, vengono di fatto non allocate
    *
    * Questa costante che se == true abilita la gestione delle trace, se
    * == false tali trace vengono completamente disabilitate.
    * <br>
    * Queste costanti servono per poter scrivere parti di codice del tipo :
    * <pre>
    *  if (SystemConstants.DEBUG_ENABLED)
    *  {
	*		l.log(Level.INFO,"..");
	* 	}
    * </pre>
    * Questo, con i nuovi compilatori del JDK dovrebbero permettere
    * di togliere completamente le istruzioni di trace dal compilato java;
    * in pratica avendo lo stesso comportamento di un preprocessor C++ in
    * quanto la costante statica è nota in fase di compilazione e, quindi,
    * l'ottimizzatore è in grado, comunque, di togliere la if (sia se false
    * che true) e di togliere eventualmente anche le istruzioni
    * di debug inserite.Per cui mettendo tutte queste variabili a false
    * in unica compilata si disabilita tutta la parte di trace/debug.
    *
    * Questo flag deve essere settato a false per disabilitare il
    * org.apache.commons.logging, che può creare problemi di cofigurazione
    * classpath e classloader se usato con Junit per il testing.
    * In teoria si dovrebbe includere in exlued.properties di Junit
    * il valore org.apache.commons.logging.* (ma non funziona !)
    */
    //public 	static 	final 	boolean			DEBUG_ENABLED	= false;
	/**
	* Nome di default da usare per la tabella da usare per descrivere i
	* Folder logici
	*
	*/
	//final static	public 	String			DEFAULT_FOLDER_TABLE = "FoldersDef";
	/**
	* Costante ce indica la size in bytes dei buffers usati per leggere
	* o scrivere files (ossia dei buffers usati per fare operazioni di
	* i/o in caso in cui l'implementazione sia su File System Standard).
	* Più size è grande e normalmente più eloce è l'operazione, ma consuma
	* molta più memoria e quindi si mangia velocemente l'heap della JVM.
	* La size è di fatto la size di un byte[].
	*
	*/
	final static	public 	int				FILE_SYSTEM_BUFFER_SIZE = 4096;
	/**
	* Costante che definisce ogni quante operazioni di IO che modificano
	* contenuto del file system (insert, update e delete) devono essere
	* rileti completamente i dati di occupazione disc di un Folder logico.
	* Tra due letture la libreria cerca comunque di tener aggiornati i dati,
	* ma potrebbero esserci altri utenti che isnistono su stesso file
	* system; inoltre i dati di occupazione calcolati sulla base dei
	* files scritti non sono molto precisi
	*
	*/
	//final static	public 	int				FOLDER_RELOAD_INFO = 10;
	/**
	* Costante che definisce la size massima tipica di un path,
	* viene usata semplicemente per allocare la size di uno StringBuffer
	*
	*/
	//final static	public 	int				FOLDER_PATH_SIZE = 250;
	/**
	* Costante che definisce la percentuale minima che la libreria
	* vuole libera, se non si conosce la size del file da ricevere,
	* per indicare che c'è spazio in un container. E' un fattore, per cui
	* il valore deve essere del tipo 0,xxx; un valore del o.1 vuol
	* dire 10%, un valore 0,05 vuol dire 5% (attenzione che i float
	* rapresentano male i valori del tipo 0.1, 0.01, 0.001, etc.).
	* Un valore di 1.0 vuol dire 100 % !!!!!
	*
	*/
	//final static	public 	float			FOLDER_FREE_SPACE = 0.03f;
	/**
	* Costante che definisce la size della cache interna usata per memorizzare
	* i folder logici, serve per velocizzare le ricerche senza rileggere dati
	* da disco o database. Normalmente si lavora sempre sugli stessi folder.
	* Se viene creato un singolo folder, viene letto anche il folder padre;
	* ugualmente se viene aperto un folder viene letto il suo padre.
	*
	*/
	//final static	public 	int				FOLDER_CACHE_SIZE = 100;
	/**
	* Costante che definisce la size della cache interna usata per memorizzare
	* gli SlotType, serve per velocizzare le ricerche senza rileggere dati
	* da disco o database.
	*
	*/
	//final static	public 	int				SLOTTYPE_CACHE_SIZE = 40;
	/**
	* Costante che definisce la size della cache interna usata per memorizzare
	* i dati dei singoli Slot (ossia i ContainerData), serve per velocizzare le
	* operazioni
	*
	*/
	//final static	public 	int				CONTAINERDATA_CACHE_SIZE = 200;
	/**
	* Nome di default da usare per la tabella da usare per descrivere le
	* tipologie di Slot Fisico
	*
	*/
	//final static	public 	String			DEFAULT_SLOT_TABLE = "SlotsDef";
	/**
	* Costante che definisce la size degli StringBuffer da usare per
	* preparare le String SQL. La size degli StringBuffer dovrebbe sempre
	* essere definita in modo che non sia necessario rilasciare il buffer
	* interno e ricrearlo, ossia deve sempre essere più grande della
	* effettiva necessita. Si ricorda che in JDK 1.4.2.10 una istruzione
	* del tipo new StringBuffer() genera un buffer di 16 caratteri, e,
	* quindi, spesso soggetto ad espansione
	*
	*/
	//final static	public 	int				DEFAULT_SB_SQL_SIZE = 150;
	/**
	* Costante che definisce la size degli StringBuffer da usare per
	* preparare le toString(). La size degli StringBuffer dovrebbe sempre
	* essere definita in modo che non sia necessario rilasciare il buffer
	* interno e ricrearlo.
	*
	*/
	//final static	public 	int				DEFAULT_SB_TOSTRING_SIZE = 400;
	/**
	* Costante da usare per scrivere i char(1) che corrispondono ad
	* un boolean o ad un Boolean, in caso valore sia <code>true</code>
	*
	*/
	final static	public 	String			DEFAULT_CHAR_BOOLEAN_TRUE = "Y";
	/**
	* Costante da usare per scrivere i char(1) che corrispondono ad
	* un boolean o ad un Boolean, in caso valore sia <code>false</code>
	*
	*/
	final static	public 	String			DEFAULT_CHAR_BOOLEAN_FALSE = "N";
	/**
	* Costante usata per i path dei folder logici; il path di un folder
	* logico deve iniziare con questo carattere, se no viene
	* rifiutato. Esempio "/assegni"; ci possono essere più
	* livelli per cui altro esempio valido di path è "/assegni/1998/Dicembre".
	*
	*/
	final static	public 	String			FOLDER_PATH_SEPARATOR = "/";
	/**
	* Costante usata per i path dei folder logici; il path di un folder
	* logico deve iniziare con questo carattere, se no viene
	* rifiutato. Esempio "/assegni"; ci possono essere più
	* livelli per cui altro esempio valido di path è "/assegni/1998/Dicembre".
	*
	*/
	final static	public 	String			FILESYSTEM_FOLDER_SEPARATOR;
	static
	{
			FILESYSTEM_FOLDER_SEPARATOR = System.getProperty("file.separator");
	}
	/**
	* Carattere che nei path (compresi i path dei folder logici) indica il
	* top folder
	*
	*/
	final static 	public String 			TOP_PATH = "..";
	/**
	* Carattere che nei path (compresi i path dei folder logici) indica
	* il folder corrente
	*
	*/
	final static 	public String 			CURRENT_PATH = ".";
	/**
	* Caratteri permessi nei vari campi alfanumerici standards
	*
	*/
    final static 	public	String 			ENABLED_BASIC_CHARACTERS	= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	/**
	* Caratteri permessi nei path dei folder logici. Modificare questa
	* costante se si desidera abilitare altri caratteri nei path dei
	* folder logici, che poi diventano parte dei path fisici
	* (quindi i caratteri qui inseriti devo essere permessi per i
	* path fisici del sistema in uso)
	*
	*/
    final static 	public	String 			FOLDER_ENABLED_CHARACTERS	= ENABLED_BASIC_CHARACTERS+"\\/._-";

    /**
    * Identifica il root folder logico.
    */
    final static    public  String          ROOT_FOLDER   = "/";

    /***************************************************************************
	*
	*	Metodi Privati
	*
	***************************************************************************/
	/**
	* Costruttore vuoto dichiarato privato in modo che non sia possibile
	* instanziare questa classe che ha solo costanti statiche
	*/
	private SimpleDMSConstants()
	{
	}
    
	public enum DMSFolderAddFileMode {NONEIFPRESENT, REPLACEIFPRESENT, NEWNAMEIFPRESENT};
	
    // public final static int ADDFILE_NONEIFPRESENT    = 0;
    // public final static int ADDFILE_REPLACEIFPRESENT = 1;
    // public final static int ADDFILE_NEWNAMEIFPRESENT = 2;
    
    final static String DMSFILENAMESCHEME_PREFIX            = "";  //  "__DMS__";
    final static String DMSMETAFILENAMESCHEME_PREFIX        = "";  //  "__DMSMETA__";
    final static String DMSMETAFILENAMESCHEME_SUFFIX        = ".DMSMETA";    
    
}