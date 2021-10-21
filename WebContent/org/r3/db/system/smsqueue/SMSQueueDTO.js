//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.smsqueue");

org.r3.db.system.smsqueue.SMSQueueDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_smsqueue";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.smsid = aDataBean.smsid || null;
        this.smstext = aDataBean.smstext || null;
        this.smssender = aDataBean.smssender || null;
        this.smsopts = aDataBean.smsopts || null;
        this.smssendat = aDataBean.smssendat || null;
        this.numberofretries = aDataBean.numberofretries || null;
        this.numberoftargets = aDataBean.numberoftargets || null;
        this.numberofsentitems = aDataBean.numberofsentitems || null;
        this.gtwayresponsecode = aDataBean.gtwayresponsecode || null;
        this.gtwayresponsereason = aDataBean.gtwayresponsereason || null;
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
