//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.card");

org.r3.db.cms.card.CardDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_card";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.cardid = aDataBean.cardid || null;
        this.systemtitle = aDataBean.systemtitle || null;
        this.pagelinktype = aDataBean.pagelinktype || null;
        this.pagelink = aDataBean.pagelink || null;
        this.pageid = aDataBean.pageid || null;
        this.refdate = aDataBean.refdate || null;
        this.options = aDataBean.options || null;
        this.validityrule = aDataBean.validityrule || null;
        this.validfrom = aDataBean.validfrom || null;
        this.validto = aDataBean.validto || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
        this.categoryid = aDataBean.categoryid || null;
 
        // Inserito
        if ( aDataBean.groups)
        {
        	this.groups =  new org.r3.db.DTOTableAdapter(aDataBean.groups, 
    				function(aRowDataBean) { return new org.r3.db.cms.group.GroupDTOAdapter(aRowDataBean); });            	
        }        
        else this.groups = null;

        if ( aDataBean.channels)
        {
        	this.channels =  new org.r3.db.DTOTableAdapter(aDataBean.channels, 
    				function(aRowDataBean) { return new org.r3.db.cms.channel.ChannelDTOAdapter(aRowDataBean); });            	
        }        
        else this.channels = null;            
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
