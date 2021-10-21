package org.r3.db.dms.model;

import org.r3.db.DTOBase;


public class DMSFolderHelper
{	
	public static DMSFolder getSiteFolder(DMSContext dmsContext, String aSite, boolean isPub) throws DMSException
	{
		String[] prefixPathSegment = null;
		if (isPub)
		{
			prefixPathSegment = new String[1];
			prefixPathSegment[0] = "pub";
		}
		
		String[] suffixPathSegment = null; // { aSite };
		boolean partitionByYear = false;
		boolean partitionByMonth = false;
		int loadFactor = 0;
		int loadDepth  = 0;
		int seqNumber  = 0; // DTOBase.getNumberFromGWFSequenceId(aCardId);
		String leafFolder = aSite;
		return createFolder(dmsContext, prefixPathSegment, partitionByYear, null, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);		
	}
	
	public static DMSFolder getCMSCardFolder(DMSContext dmsContext, String aSite, String aCardId, boolean isPub) throws DMSException
	{
		String[] prefixPathSegment = null;
		if (isPub)
		{
			prefixPathSegment = new String[1];
			prefixPathSegment[0] = "pub";
		}
		
		String[] suffixPathSegment = { aSite, "cms" };
		boolean partitionByYear = false;
		boolean partitionByMonth = false;
		int loadFactor = 6;
		int loadDepth  = 2;
		int seqNumber  = DTOBase.getNumberFromGWFSequenceId(aCardId);
		String leafFolder = aCardId;
		return createFolder(dmsContext, prefixPathSegment, partitionByYear, null, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);		
	}

	public static DMSFolder getSailApplicationFolder(DMSContext dmsContext, String aSite, String anApplicationId, boolean isPub) throws DMSException
	{
		String[] prefixPathSegment = null;
		if (isPub)
		{
			prefixPathSegment = new String[1];
			prefixPathSegment[0] = "pub";
		}
		
		String[] suffixPathSegment = { aSite, "r3ea" };
		boolean partitionByYear = false;
		boolean partitionByMonth = false;
		int loadFactor = 6;
		int loadDepth  = 2;
		int seqNumber  = DTOBase.getNumberFromGWFSequenceId(anApplicationId);
		String leafFolder = anApplicationId;
		return createFolder(dmsContext, prefixPathSegment, partitionByYear, null, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);		
	}

	public static DMSFolder getCyberAlturaRankingUploadFolder(DMSContext dmsContext, String aSite) throws DMSException
	{
		String[] prefixPathSegment = null;
		prefixPathSegment = new String[1];
		prefixPathSegment[0] = "pub";
		
		String[] suffixPathSegment = { aSite, "cyberaltura", DTOBase.currentDate(DTOBase.sysDateFormat) };
		boolean partitionByYear = false;
		boolean partitionByMonth = false;
		int loadFactor = 6;
		int loadDepth  = 0;
		int seqNumber  = -1;
		String leafFolder = null;
		return createFolder(dmsContext, prefixPathSegment, partitionByYear, null, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);		
	}

	public static DMSFolder getUserPhotoUploadFolder(DMSContext dmsContext, String aUserId) throws DMSException
	{
		String[] prefixPathSegment = null;
		prefixPathSegment = new String[1];
		prefixPathSegment[0] = "pub";
		
		String[] suffixPathSegment = { "users", aUserId, DTOBase.currentDate(DTOBase.sysDateFormat) };
		boolean partitionByYear = false;
		boolean partitionByMonth = false;
		int loadFactor = 6;
		int loadDepth  = 0;
		int seqNumber  = -1;
		String leafFolder = null;
		return createFolder(dmsContext, prefixPathSegment, partitionByYear, null, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);		
	}
	
    private static DMSFolder createFolder(DMSContext dmsContext, String[] prefixPathSegment, boolean partitionByYear, String partitionYear, boolean partitionByMonth, String[] suffixPathSegment, int loadFactor, int loadDepth, int seqNumber, String leafFolder) throws DMSException
    {    	    	
    	DMSFileSystemUrl url = new DMSFileSystemUrl("/");
		DMSFolder folder = new DMSFolder(dmsContext, url);

		DMSFolder docFolder = null;
		if (folder.exists())
		{
			System.out.println("Folder is Bound: " + folder.isBound());
			DMSStorageBucket storageBucket = folder.getStorageBucket();
			if (!storageBucket.exists(dmsContext))
				storageBucket.mkdir(dmsContext);

			docFolder = DMSUtils.getFolder(dmsContext, folder, prefixPathSegment, partitionByYear, partitionYear, partitionByMonth, suffixPathSegment, loadFactor, loadDepth, seqNumber, leafFolder);
		}
		
		return docFolder;
    }
	
}
