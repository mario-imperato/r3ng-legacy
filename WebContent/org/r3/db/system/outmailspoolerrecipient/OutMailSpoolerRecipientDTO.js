//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.system.outmailspoolerrecipient");

org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_outmailspoolerrecipient";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.recipientid = aDataBean.recipientid || null;
        this.site = aDataBean.site || null;
        this.messageid = aDataBean.messageid || null;
        this.msgto = aDataBean.msgto || null;
        this.businesskey = aDataBean.businesskey || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
	 }
    
   
});
