//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.system.fileimport.fileimport");

org.r3.db.system.fileimport.fileimport.FileImportDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_fileimport";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.importid = aDataBean.importid || null;
        this.importname = aDataBean.importname || null;
        this.importcontext = aDataBean.importcontext || null;
        this.majortype = aDataBean.majortype || null;
        this.minortype = aDataBean.minortype || null;
        this.withheader = aDataBean.withheader || null;
        this.numberofcolumns = aDataBean.numberofcolumns || null;
        this.numberofrecords = aDataBean.numberofrecords || null;
        this.uploaddate = aDataBean.uploaddate || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
	 }
    
  ,compareTo: function(anItemId)
   {
   	   if (!this.dtokey)
   	       return -99;
   	       
   	   if (this.dtokey < anItemId)
   	       return -1;
   	   else if (this.dtokey > anItemId)
   	   	   return  1;
   	   	   
   	   return 0;
   }
   
});
