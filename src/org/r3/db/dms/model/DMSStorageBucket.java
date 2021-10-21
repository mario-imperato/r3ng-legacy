package org.r3.db.dms.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;

import org.r3.db.dms.file.DMSFileDataTableAdapter;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.system.util.ContentTypeUtil;
import org.r3.system.util.SystemUtils;

public abstract class DMSStorageBucket extends DMSObject 
{
    private DMSDevice device       = null;
    private String    physicalName = null;
    
    public DMSStorageBucket(DMSDevice aDevice, String aPhysicalName) 
    {
        super();
        device = aDevice;
        physicalName = aPhysicalName;
    }

    protected void setDevice(DMSDevice device)
    {
        this.device = device;
    }

    public DMSDevice getDevice()
    {
        return device;
    }

    protected void setPhysicalName(String physicalName)
    {
        this.physicalName = physicalName;
    }

    public String getPhysicalName()
    {
        return physicalName;
    }
    
    /**
     * Funzione che dato un nome di file resituisce il riferimento di un file fisico su disco. Il file può essere il file originale
     * oppure una copia temporanea creata per l'occasione.
     */
    public abstract File getFile(DMSContext aDmsContext, String aFileName) throws DMSException;
    
    /**
     * Funzione che dato un nome di file ne legge il contenuto e lo invia all'outputstream
     * 
     * @param aFileName
     * @param anOutputStream
     * @return
     * @throws DMSException
     */
    public abstract long getFileContent(DMSContext aDmsContext, String aFileName, OutputStream anOutputStream) throws DMSException;


    /*
     * Funzione booleana che permette di stabilire se il folder fisico esiste oppure no.
     */
    public abstract boolean exists(DMSContext aDmsContext) throws DMSException; 
    
    /*
     * Funzione booleana che permette di stabilire se esiste un dato file all'interno del folder fisico.
     */
    public abstract boolean fileExists(DMSContext aDmsContext, String aFileName) throws DMSException;                

    /*
     * Funzione di creazione del bucket fisico e di tutte le cartelle fisiche intermedie necessarie. 
     */
    public abstract boolean mkdir(DMSContext aDmsContext) throws DMSException;                

    /**
     * Funzione che permette l'inserimento di un file all'interno di un bucket.
     * La funzione richiede che il nome del file, il suo contentType, la sua dimensione siano specificati 
     * nell'oggetto di metadati fornito.
     * 
     * @param anInputStream
     * @param aFileMetadata
     * @param addMode
     * @return
     * @throws DMSException
     */    
    public String addFile(DMSContext aDmsContext, InputStream anInputStream, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException
    {
    	//  || aFileMetadata.getContentLength() <= 0 || aFileMetadata.getCreationDate() == null
        if (aFileMetadata.getContentType() == null  ||
                aFileMetadata.getFileName() == null )
        {
            throw new DMSException("$DMS_EXC_CODE$: Cannot find required file metadata in adding from inputStream.");
        }

        if (!exists(aDmsContext))
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-existing storageBucket!");
                
        return addFileImpl(aDmsContext, anInputStream, aFileMetadata, addMode);
    }

    /*
     * Funzione che permette l'inserimento di un file all'interno di un bucket. 
     * Alcune caratteristiche del file
     * sono desunte dall'oggetto File (dimensione, tipo - dall'estensione -, nome) e vanno  a popolare i valori
     * all'interno dei metadati
     *
     * @param aFile
     * @param addMode
     * @return
     * @throws DMSException
     */    
    public String addFile(DMSContext aDmsContext, File aFile, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException
    {
        if (!exists(aDmsContext))
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-existing storageBucket!");

        // Popola alcuni attributi fondamentali di metadata.
        aFileMetadata = augmentMetadata(aFile, aFileMetadata);

        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(aFile);
            return addFileImpl(aDmsContext, fileInputStream, aFileMetadata, addMode);
        }
        catch(FileNotFoundException fexc)
        {
            throw new DMSException(fexc);
        }
        finally
        {
            SystemUtils.close(fileInputStream);
        }
    }

    protected abstract String addFileImpl(DMSContext aDmsContext, InputStream aFileInputStream, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException;    

    /**
     * Funzione utilizzata all'interno del metodo addFile per popolare alcuni valori a partire dal file in ingresso.
     * 
     * @param aFile
     * @param aFileMetadata
     * @return
     */
    private DMSFileMetadata augmentMetadata(File aFile, DMSFileMetadata aFileMetadata)
    {
        if (aFileMetadata == null)
        {
            aFileMetadata = new DMSFileMetadata();
        }
        
        // MOD4GWF_30
        if (aFileMetadata.getFileName() == null)
        {
           aFileMetadata.setFileName(wellFormFileName(aFile.getName()));
        }
        
        aFileMetadata.setContentLength(aFile.length());
        aFileMetadata.setContentType(ContentTypeUtil.findMimeType(aFile.getName()));
        aFileMetadata.setCreationDate();
        return aFileMetadata;
    }

    /**
     * Funzione che permette di ottenere le informazioni di metedata a partire dal nome del file.
     * 
     * @param fileName
     * @return
     * @throws DMSException
     */
    public abstract DMSFileMetadata getFileMetadata(DMSContext aDmsContext, String fileName) throws DMSException;

    public int getFileSize(DMSContext aDmsContext, String aFileName)
    {
        DMSFileMetadata fileMetadata = null;
        try
        {
            fileMetadata = getFileMetadata(aDmsContext, aFileName);
        }
        catch (DMSException e)
        {
            e.printStackTrace();
        }

        if (fileMetadata != null)
            return (int)fileMetadata.getContentLength();

        return 0;
    }    

    /**
     * Funzione che permette di aggiornare in maniera persistente i metadati legati ad un file.
     * 
     * @param fileName
     * @return
     * @throws DMSException
     */
    public abstract void setFileMetadata(DMSContext aDmsContext, String fileName, DMSFileMetadata metadata) throws DMSException;


    /**
     * Funzione di cancellazione del bucket: questo metodo viene invocato dal metodo di pruning che elimina fisicamente 
     * tutto. Ci potrebbe essere un problema nel caso di mapping degeneri con piu' folder che puntano allo stesso bucket.
     * @param fileName
     * @throws DMSException
     */
    public abstract void delete(DMSContext aDmsContext) throws DMSException;

    /**
     * Funzione di cancellazione di un file da un bucket: la cancellazione prevede sia la cancellazione
     * del file vero e proprio, sia la cancellazione dei metadati.
     * @param fileName
     * @throws DMSException
     */
    public abstract void delete(DMSContext aDmsContext, String fileName) throws DMSException;

    
    /**
     * Funzione di cancellazione di tutti i file da un bucket: la cancellazione prevede sia la cancellazione
     * del file vero e proprio, sia la cancellazione dei metadati.
     * @throws DMSException
     */
    public abstract void deleteAllFiles(DMSContext aDmsContext) throws DMSException;
    
    /**
     * Funzione che si occupa di generare nomi ben formati dal punto di vista sintattico
     * In generale si tratta di eliminare caratteri speciali e spazi sostituendoli con un carattere
     * di riferimento. Al momento la funzione converte in maiuscolo.
     * 
     * @param aFileName
     * @return
     */
    protected String wellFormFileName(String aFileName)
    {
        return DMSUrl.wellFormFileName(aFileName);
    }
    
    /**
     * Funzione utilizzata per la generazione dei nomi di file in caso di conflitti.
     * La generazione prevede essenzialmente una composizione del nome con un progressivo.
     */
    protected String generateFileName(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        String fileBaseName  = aFileName;
        String fileExtension = null;

        int posNdx = aFileName.indexOf('.');
        if (posNdx >= 0)
        {
            fileExtension = aFileName.substring(posNdx + 1);
            fileBaseName  = aFileName.substring(0, posNdx);           
        }
        
        String generatedFileName = buildGeneratedFileName(0, fileBaseName, fileExtension);
        for( int i = 1; fileExists(aDmsContext, generatedFileName); i++)
        {
            generatedFileName = buildGeneratedFileName(i, fileBaseName, fileExtension);
        }
            
        return generatedFileName;   
    }

    /**
     * Funzione utilizzata per la determinazione del file di metadati.
     */
    protected String getMetadataFileName(String aFileName) throws DMSException
    {        
        String metadataFileName = 
             new StringBuffer()
                   .append(SimpleDMSConstants.DMSMETAFILENAMESCHEME_PREFIX)
                   .append(aFileName)
                   .append(SimpleDMSConstants.DMSMETAFILENAMESCHEME_SUFFIX)
                   .toString();
        
        return metadataFileName;   
    }

    private String buildGeneratedFileName(int fileIndex, String basePart, String extPart)
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(5);
        nf.setGroupingUsed(false);

        StringBuffer stb = new StringBuffer();
        stb.append(SimpleDMSConstants.DMSFILENAMESCHEME_PREFIX)
           .append(basePart).append('.').append(nf.format(fileIndex))
           .append('.').append(extPart);
        
        return stb.toString();
    }
    
    /**
     * Funzione che restituisce la lista dei files sotto forma di un oggetto di tipo GWFDMSFileQuery2Result
     * @return
     * @throws DMSException
     */
    public abstract DMSFileDataTableAdapter getFiles(DMSContext aDmsContext, DMSFileSystemUrl aFolderUrl, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements) throws DMSException;
    
}
