//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.cms.cardchannelview");

org.r3.db.cms.cardchannelview.CardChannelViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_cardchannelview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.channelid = aDataBean.channelid || null;
        this.site = aDataBean.site || null;
        this.cardid = aDataBean.cardid || null;
        this.languagecode = aDataBean.languagecode || null;
        this.categoryid = aDataBean.categoryid || null;
        this.pagelinktype = aDataBean.pagelinktype || null;
        this.pagelink = aDataBean.pagelink || null;
        this.pageid = aDataBean.pageid || null;
        this.refdate = aDataBean.refdate || null;
        this.options = aDataBean.options || null;
        this.title = aDataBean.title || null;
        this.summary = aDataBean.summary || null;
        this.textbody = aDataBean.textbody || null;
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
