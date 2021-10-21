//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbstopicview");

org.r3.db.bbs.bbstopicview.BBSTopicViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_bbstopicview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.topicid = aDataBean.topicid || null;
        this.topictitle = aDataBean.topictitle || null;
        this.cardid = aDataBean.cardid || null;
        this.moderatorid = aDataBean.moderatorid || null;
        this.moderatormode = aDataBean.moderatormode || null;
        this.options = aDataBean.options || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
        this.numthreads = aDataBean.numthreads || null;
        this.numposts = aDataBean.numposts || null;
 
	 }
    
   
});
