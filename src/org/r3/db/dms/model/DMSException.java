/**
 * Nome File 	: DMSException.java
 * Progetto 	: gwf_struts
 * Sottosistema : gwfdms
 * Modulo 		: dms
 * Errori		:
 * Description	: classe che definisce le Exception generata dalla Libreria
 *
 * Modifiche :
 *          01/03/2006 :     -prima versione
 */
package org.r3.db.dms.model;
/**
 * Questa classe definisce una generica Exception del DMS e sarà
 * usata per generare exception delle varie funzioni.
 * <P>
 * Un codice di errore o di exception, viene tipicamente numerato come
 * DMSnnnnMM essendo :
 * <UL>
 *	 <LI> nnnn è un numero che identifica il programma o la funzione
 *	 <LI> MM è un numero che identifica l'errore nell'ambito del programma
 * </UL>
 *
 *  DA AGGIORNARE IN QUANTO NON PIU' OK. -------------------------------------
 *  
 *	In dettaglio sono stati definiti al momento i seguenti codici :
 *		<UL>
 *			<LI> DMS000001 - DMS000099 : non usato</LI>
 *			<LI> DMS000100 - DMS000199 : SimpleDMS</LI>
 *			<LI> DMS000200 - DMS000299 : FolderData</LI>
 *			<LI> DMS000300 - DMS000399 : SlotType</LI>
 *			<LI> DMS000400 - DMS000499 : ContainerData</LI>
 *			<LI> DMS000500 - DMS000599 : UtilsDMS (assegnato ma non usato)</LI>
 *			<LI> DMS000600 - DMS000699 : FSFileSystemImplm</LI>
 *		</UL>
 *
 * @author 		ldm
 * @version 	$Revision: 1.6 $
 * @since   	versione 1.0
 */
public class DMSException extends Exception
{
	/**
    * Costruttore vuoto
    *
    * @param msg la String contenente il messaggo di errore
    */
  	public DMSException()
  	{
    	super();
  	}
    /**
    * Costruttore con messaggio di errore
    *
    * @param msg la String contenente il messaggo di errore
    */
  	public DMSException(String msg)
  	{
   		super(msg);
  	}
    /**
    * Costruttore con una Throwable, serve per incapsulare
    * un'altra Exception
    *
    * @param cause la Throwable che viene incpsulata
    */
  	public DMSException(Throwable cause)
  	{
        super(cause);
    }
    /**
    * Costruttore con una Throwable ed un messaggio, serve per
    * incapsulare un'altra Exception, ma dando una più
    * completa informazione
    *
    * @param msg la String contenente il messaggo di errore
    * @param cause la Throwable che viene incpsulata
    */
  	public DMSException(String msg, Throwable cause)
  	{
        super(msg, cause);
    }
}