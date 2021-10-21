//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

public class DMSFolderDTO extends DMSFolderDTOBase
{
	public enum FolderStatus { sys_recact, sys_recblock, sys_recdeleted  };
	
    public DMSFolderDTO()
    {
        super();
    }

    public DMSFolderDTO(DMSFolderDTO another)
    {
        super(another);
    }

    public void copyFrom(DMSFolderDTO another)
    {
       folderid = another.getFolderid();
       deviceid = another.getDeviceid();
       folderlogicalpath = another.getFolderlogicalpath();
       folderphysicalpath = another.getFolderphysicalpath();
       folderstatus = another.getFolderstatus();
       folderdepth = another.getFolderdepth();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }

}
