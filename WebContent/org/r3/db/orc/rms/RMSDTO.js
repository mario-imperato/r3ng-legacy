//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.orc.rms");

org.r3.db.orc.rms.RMSDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_rms";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.rmsid = aDataBean.rmsid || null;
        this.filename = aDataBean.filename || null;
        this.fileurl = aDataBean.fileurl || null;
        this.filesize = aDataBean.filesize || null;
        this.numberofcerts = aDataBean.numberofcerts || null;
        this.numberofdupcerts = aDataBean.numberofdupcerts || null;
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
