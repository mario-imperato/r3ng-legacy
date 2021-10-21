//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.wbs.wbsactor");

org.r3.db.wbs.wbsactor.WBSActorDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_wbsactor";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.wbsactorid = aDataBean.wbsactorid || null;
        this.site = aDataBean.site || null;
        this.actorid = aDataBean.actorid || null;
        this.actorrole = aDataBean.actorrole || null;
        this.wbsid = aDataBean.wbsid || null;
        this.wbsnodeid = aDataBean.wbsnodeid || null;
 
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
