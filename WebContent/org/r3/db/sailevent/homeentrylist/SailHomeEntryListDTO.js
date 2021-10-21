//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.homeentrylist");

org.r3.db.sailevent.homeentrylist.SailHomeEntryListDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailhomeentrylist";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.userid = aDataBean.userid || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.yachtname = aDataBean.yachtname || null;
        this.yachttype = aDataBean.yachttype || null;
        this.boatimageurl = aDataBean.boatimageurl || null;
        this.boatimageheight = aDataBean.boatimageheight || null;
        this.boatimagewidth = aDataBean.boatimagewidth || null;
        this.boaticonurl = aDataBean.boaticonurl || null;
        this.boaticonwidth = aDataBean.boaticonwidth || null;
        this.boaticonheight = aDataBean.boaticonheight || null;
        this.addtohomeentrylist = aDataBean.addtohomeentrylist || null;
 
	 }
    
   
});
