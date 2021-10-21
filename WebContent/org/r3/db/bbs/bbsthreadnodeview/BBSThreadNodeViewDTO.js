//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthreadnodeview");

org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_bbsthreadnodeview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.threadnodeid = aDataBean.threadnodeid || null;
        this.site = aDataBean.site || null;
        this.threadid = aDataBean.threadid || null;
        this.nodetype = aDataBean.nodetype || null;
        this.nodetitle = aDataBean.nodetitle || null;
        this.nodetext = aDataBean.nodetext || null;
        this.nodeparentid = aDataBean.nodeparentid || null;
        this.nodepath = aDataBean.nodepath || null;
        this.userid = aDataBean.userid || null;
        this.nickname = aDataBean.nickname || null;
        this.firstname = aDataBean.firstname || null;
        this.lastname = aDataBean.lastname || null;
        this.creationdate = aDataBean.creationdate || null;
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
