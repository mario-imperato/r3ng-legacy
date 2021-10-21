/**
 * Nome File 	: DMSUrl.java
 * Progetto 	: gwf_struts
 * Sottosistema : it.gwf_struts.gwfdms.model
 * Modulo 		: 
 * Errori		:
 * Description	: descrizione
 *
 * Modifiche :
 *          21-apr-2006 :     -prima versione
 */

package org.r3.db.dms.model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.r3.system.util.StringUtils;

/**
 * @author mai
 *
 */
public class DMSFileSystemUrl extends DMSUrl
{
        
    /**
     * Funzione che crea un URL dato il padre e una stringa di specifica.
     * 
     * @param parentUrl
     * @param subPath
     * @throws DMSException
     */
    public DMSFileSystemUrl(DMSFileSystemUrl parentUrl, String subPath) throws DMSException
    {
        this(parentUrl.getUrl() + SimpleDMSConstants.FOLDER_PATH_SEPARATOR + subPath);    
    }

    /**
     * Funzione che crea un URL dato il padre e una stringa di specifica.
     * 
     * @param parentUrl
     * @param subPath
     * @throws DMSException
     */
    public DMSFileSystemUrl(String parentPath, String subPath) throws DMSException
    {
        this(parentPath + SimpleDMSConstants.FOLDER_PATH_SEPARATOR + subPath);    
    }

    /**
     * 
     */
    public DMSFileSystemUrl(String aUrl) throws DMSException
    {
        super();
        
        // Prima elimino l'eventuale schema per le operazioni di normalizzazione. 
        // Lo schema viene re-inserito durante il setUrl..        
        aUrl = DMSUrl.getPath(aUrl);
        
        // Gli URL di tipo file system (es. folder name e bucket path) sono sempre portati in maiuscolo
        // in quanto le tabelle di catalogo su DB2 hanno problemi sui casi case sensitive.
        aUrl = aUrl.toUpperCase();
        
        aUrl = aUrl.replace(
                SimpleDMSConstants.FILESYSTEM_FOLDER_SEPARATOR.charAt(0),
                SimpleDMSConstants.FOLDER_PATH_SEPARATOR.charAt(0));

        if (!isWellFormed(aUrl))
        {
            DMSException exc = new DMSException("$DMS_EXC_CODE$: Malformed URL");
            throw exc;
        }
                
        setUrl(normalize(aUrl));
    }

    public boolean isRoot()
    {
        return getPath().equalsIgnoreCase(SimpleDMSConstants.ROOT_FOLDER);    
    }
    
    /**
     * Funzione che valuta se l'url e' ben formato oppure no. Ritorna un valore booleano
     * in risposta all'attivita' di verifica. Implementazione corrente sostanzialmente vuota.
     * 
     * @param aUrl
     * @return
     */
    protected boolean isWellFormed(String aUrl)
    {
        if (aUrl == null)  return false;

        String  primoChar = Character.toString(aUrl.charAt(0));
        boolean toReturn = false;
        if (SimpleDMSConstants.FOLDER_PATH_SEPARATOR.equals(primoChar))
        {
            toReturn = true;
        }
        toReturn = toReturn && StringUtils.existsOnlyInBag(aUrl,SimpleDMSConstants.FOLDER_ENABLED_CHARACTERS);
        return  toReturn;
    }
    
    
    /**
     * Restituisce il valore della ultima componente dell'url.
     * L'url viene sempre riportato in forma canonica ovvero risolti i casi
     * di tipo '..' e '.' ed eliminato un eventuale slash finale.
     */
    public String getName()
    {
        if (isRoot()) return null;
        
        int ndx = getUrl().lastIndexOf(SimpleDMSConstants.FOLDER_PATH_SEPARATOR);
        return getUrl().substring(ndx + 1);
    }
    
    /**
    * Restituisce il path del folder di livello superiore,
    * o null, se il path passato è quello di un folder master
    *
    * @param path la String contenente il path in input
    *
    * @return null se il path è null o se il path è di un folder
    *           master (ossia di primo livello), il path del folder padre
    *           in caso contrario
     * @throws DMSException 
    */
    public DMSFileSystemUrl getParent() throws DMSException
    {
        int i = getPath().lastIndexOf(SimpleDMSConstants.FOLDER_PATH_SEPARATOR);
        if (i <= 0)     return  DMSFILESYSTEM_ROOTURL;
        return  new DMSFileSystemUrl(getPath().substring(0,i));
    }
    
    public List<DMSFileSystemUrl> getChainOfUrls() throws DMSException
    {       
        if (isRoot()) return null;
        
        String[]    pathArray = StringUtils.delimitedListToArray(getPath(),SimpleDMSConstants.FOLDER_PATH_SEPARATOR);
        
        List<DMSFileSystemUrl> listOfUrls = new ArrayList<DMSFileSystemUrl>();
        listOfUrls.add(DMSFILESYSTEM_ROOTURL);
        
        DMSFileSystemUrl parentUrl = DMSFILESYSTEM_ROOTURL;
        for(int i = 0; i< pathArray.length-1; i++)
        {
            DMSFileSystemUrl aDMSUrl = new DMSFileSystemUrl(parentUrl, pathArray[i]);
            listOfUrls.add(aDMSUrl);
            parentUrl = aDMSUrl;
        }
        
        return listOfUrls;
    }
    
    /**
     * Normalizza il path sopprimendo sequenze tipo "path/..", etc
     * Il risultato può essere usato nei confroti tra path in quanto
     * il path restituito e' normalizzato.
     *
     * @param path il aUrl originario
     *
     * @return una String contenente il path normalizzato
     */
     private String normalize(String aUrl)
     {
         //
         //  Ora estrai tuti i pezzi di path in uno String[]. Sequenze di caratteri '/'
         //  vengono eliminate.
         String[]    pathArray = StringUtils.delimitedListToArray(aUrl,SimpleDMSConstants.FOLDER_PATH_SEPARATOR);
         List<String>        pathElements = new LinkedList<String>();
         int tops = 0;

         //
         //  Loop di analisi di ogni singolo pezzo del path
         //  parti dal fondo andando verso l'inzio
         //
         for (int i = pathArray.length - 1; i >= 0; i--)
         {
             //
             //  E' "." ossia current path ? se sì non fare niente
             //
             if (SimpleDMSConstants.CURRENT_PATH.equals(pathArray[i]))
             {
             }
             else
             {
                 //
                 //  E' ".." ossia top path ? somma 1 ai tops
                 if (SimpleDMSConstants.TOP_PATH.equals(pathArray[i]))
                 {
                     tops++;
                 }
                 else
                 {
                     //  Siccome ti sei spostato di 1 diminuisci
                     //  il counters dei tops se è valorizzato
                     //  se no inserisci l'elemento in LinkedList
                     //  risultato
                     //
                     if (tops > 0)
                     {
                         tops--;
                     }
                     else
                     {
                         pathElements.add(0, pathArray[i]);
                     }
                 }
             }
         } 

         //
         //  Ora che hai eliminato tutto quello che non serve ricostruisci il path
         //
         return StringUtils.joinCollection(pathElements,SimpleDMSConstants.FOLDER_PATH_SEPARATOR,true,false);
     }

     /**
      * Calcola la profondita' dell'url in base al numero delle occorrenze
      * del carattere '/' all'interno della string url normalizzata.
      * 
      * @return
      */
     public int getUrlDepth()
     {
         if (isRoot())  return 0;
         int delimOccurrences = StringUtils.numberOfOccurrences(getPath(), SimpleDMSConstants.FOLDER_PATH_SEPARATOR);         
         return delimOccurrences;
     }
     
     public static void main(String[] args) throws DMSException
     {
         System.err.println("Args[0]: " + args[0]);
         DMSFileSystemUrl aUrl = new DMSFileSystemUrl(args[0]);
         System.err.println("DMSUrl: " + aUrl);
     }

    @Override
    protected String getSchema()
    {        
        return UrlType.DMS_FILE.toString();
    }
}
