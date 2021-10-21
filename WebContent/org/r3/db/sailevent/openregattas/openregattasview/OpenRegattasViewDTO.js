//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.openregattas.openregattasview");

org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_openregattasview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.regattaid = aDataBean.regattaid || null;
        this.title = aDataBean.title || null;
        this.languages = aDataBean.languages || null;
        this.domain = aDataBean.domain || null;
        this.icon = aDataBean.icon || null;
 
	 }
    
   
});
