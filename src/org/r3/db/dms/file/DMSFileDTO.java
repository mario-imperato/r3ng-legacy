//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;

import org.r3.db.dms.model.DMSFileSystemUrl;


public class DMSFileDTO extends DMSFileDTOBase
{
    private DMSFileSystemUrl          fileUrl      = null;      
    
    public DMSFileDTO()
    {
        super();
    }

    public DMSFileDTO(DMSFileDTO another)
    {
        super(another);
    }

    public void setFileUrl(DMSFileSystemUrl fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public DMSFileSystemUrl getFileUrl()
    {
        return fileUrl;
    }

}
