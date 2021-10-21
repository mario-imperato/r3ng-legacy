package org.r3.db.dms.model;

import java.util.Arrays;
import java.util.Calendar;

public class DMSUtils
{
	
	private static int[] loadFactorBitWiseMask = {
	          0 , 0x001 , 0x003, 0x007, 
	      0x00f,  0x01f,  0x03f, 0x07f, 
	      0x0ff,  0x1ff,  0x3ff, 0x7ff 	
	};

	private static String[] monthDescr = {
		"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"
    };

	public static DMSFolder getFolder(DMSContext dmsContext, DMSFolder rootFolder, String[] prefixPathSegment, boolean partitionByYear, String partitionYear, boolean partitionByMonth, String[] suffixPathSegment, int loadFactor, int loadDepth, int seqNumber, String leafFolder) throws DMSException
	{
		String[] folderRelativePath = getFolderRelativePath(prefixPathSegment, partitionByYear, partitionYear, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);
		DMSFolder documentFolder = rootFolder.makeFoldersBoundToParent(dmsContext, folderRelativePath);
		return documentFolder;		
	}
	
	public static String[] getFolderRelativePath(String[] prefixPathSegment, boolean partitionByYear, String partitionYear, boolean partitionByMonth, String[] suffixPathSegment, int loadFactor, int loadDepth, int seqNumber, String leafFolder) throws DMSException
	{
		String[] documentFolderRelativePath = new String[ 
		                ((partitionByYear)  ? 1 : 0) + 		         
		                ((partitionByMonth) ? 1 : 0) + 
		                ((prefixPathSegment != null) ? prefixPathSegment.length : 0) + 
		                ((suffixPathSegment != null) ? suffixPathSegment.length : 0) +
		                loadDepth + 
		                ((leafFolder != null) ? 1 : 0)];
        
		int offset = 0;
		
		Calendar c = Calendar.getInstance();

        if (prefixPathSegment != null)
        {
           for(int i = 0; i < prefixPathSegment.length; i++)
           {
        	   documentFolderRelativePath[ i + offset ] = prefixPathSegment[i];
           }
           
           offset += prefixPathSegment.length;
        }
		
		if (partitionByYear)
        {        	
        	documentFolderRelativePath[offset] = (partitionYear != null) ? partitionYear : String.valueOf(c.get(Calendar.YEAR));
        	offset++;
        }
        
        if (partitionByMonth)
        {
        	documentFolderRelativePath[offset] = monthDescr[c.get(Calendar.MONTH)];
        	offset++;
        }
                
        if (suffixPathSegment != null)
        {
           for(int i = 0; i < suffixPathSegment.length; i++)
           {
        	   documentFolderRelativePath[ i + offset ] = suffixPathSegment[i];
           }
           
           offset += suffixPathSegment.length;
        }
        
        if (loadDepth > 0)
        {
        
        for(int i = 0; i < loadDepth; i++)
        {
        	int folderIndex = (seqNumber >> (loadFactor * (loadDepth - i))) & loadFactorBitWiseMask[loadFactor]; 
        	documentFolderRelativePath[i + offset] = new StringBuilder().append("DFLD").append(folderIndex).toString();                    					
        }
        
        offset += loadDepth;
        }
        
        if (leafFolder != null)
        {
        	documentFolderRelativePath[offset] = leafFolder;
        	offset++;            	
        }
        
        return documentFolderRelativePath;
	}
		
	public static void main(String[] args) throws DMSException
	{		
		boolean partitionByYear = true;
		boolean partitionByMonth = true;
		int loadFactor = 6;
		int loadDepth  = 2;
		int seqNumber  = 8095;
        String leafNumber = "zucca";
        
		String[] pSeg = null; // { "LEV1", "LEV2" };
		String[] prefixSeg = { "LEV1", "LEV2" };
		
		String[] folderRelPath = DMSUtils.getFolderRelativePath(prefixSeg, partitionByYear, null, partitionByMonth, pSeg, loadFactor, loadDepth, seqNumber, leafNumber);
		System.out.println(Arrays.toString(folderRelPath));
	}
}
