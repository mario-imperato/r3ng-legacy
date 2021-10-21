//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.system.outmailspooler");

org.r3.db.system.outmailspooler.OutMailSpoolerDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_outmailspooler";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.messageid = aDataBean.messageid || null;
        this.msgtitle = aDataBean.msgtitle || null;
        this.msgtext = aDataBean.msgtext || null;
        this.msgfrom = aDataBean.msgfrom || null;
        this.msgcc = aDataBean.msgcc || null;
        this.msgbcc = aDataBean.msgbcc || null;
        this.msgmode = aDataBean.msgmode || null;
        this.msgsendat = aDataBean.msgsendat || null;
        this.numberofattachments = aDataBean.numberofattachments || null;
        this.numberoftargets = aDataBean.numberoftargets || null;
        this.numberofsentitems = aDataBean.numberofsentitems || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
	 }
    
   
});
