//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.racegroupview");

org.r3.db.sailevent.racegroupview.SailRaceGroupViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailracegroupview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.parentitemid = aDataBean.parentitemid || null;
        this.parentitemdescr = aDataBean.parentitemdescr || null;
        this.parentitemorder = aDataBean.parentitemorder || null;
        this.childitemid = aDataBean.childitemid || null;
        this.childitemdescr = aDataBean.childitemdescr || null;
        this.childitemorder = aDataBean.childitemorder || null;
 
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
