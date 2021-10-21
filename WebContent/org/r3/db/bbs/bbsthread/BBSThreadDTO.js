//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_bbsthread";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.threadid = aDataBean.threadid || null;
        this.topicid = aDataBean.topicid || null;
        this.threadtitle = aDataBean.threadtitle || null;
        this.threadprofile = aDataBean.threadprofile || null;
        this.userid = aDataBean.userid || null;
        this.creationdate = aDataBean.creationdate || null;
        this.numposts = aDataBean.numposts || null;
        this.lastthreadnodeid = aDataBean.lastthreadnodeid || null;
        this.lastposttimestamp = aDataBean.lastposttimestamp || null;
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
