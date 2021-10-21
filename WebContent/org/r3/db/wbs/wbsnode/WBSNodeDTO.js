//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.wbs.wbsnode");

org.r3.db.wbs.wbsnode.WBSNodeDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_wbsnode";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.wbsnodeid = aDataBean.wbsnodeid || null;
        this.site = aDataBean.site || null;
        this.wbsid = aDataBean.wbsid || null;
        this.nodetype = aDataBean.nodetype || null;
        this.nodeorder = aDataBean.nodeorder || null;
        this.nodesect = aDataBean.nodesect || null;
        this.nodename = aDataBean.nodename || null;
        this.nodesummary = aDataBean.nodesummary || null;
        this.nodetext = aDataBean.nodetext || null;
        this.nodeparentid = aDataBean.nodeparentid || null;
        this.nodepath = aDataBean.nodepath || null;
        this.assignedto = aDataBean.assignedto || null;
        this.duration = aDataBean.duration || 0;
        this.startdate = aDataBean.startdate || null;
        this.enddate = aDataBean.enddate || null;
        this.completiontype = aDataBean.completiontype || null;
        this.completiondescr = aDataBean.completiondescr || '';
        this.completion = aDataBean.completion || 0;
        this.completionfrom = aDataBean.completionfrom || 0;
        this.completionto = aDataBean.completionto || 0;
        this.completionstatus = aDataBean.completionstatus || null;
        this.completiondate = aDataBean.completiondate || null;
        this.completioneffort = aDataBean.completioneffort || null;
        this.completioneffunit = aDataBean.completioneffunit || null;
        this.economicvalue = aDataBean.economicvalue || 0;
        this.economicvalue2 = aDataBean.economicvalue2 || 0;
        this.economicvalue3 = aDataBean.economicvalue3 || 0;
        this.remarks = aDataBean.remarks || null;
        this.stereotype = aDataBean.stereotype || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
        // Inserito
        this.nodesectdirtiness = aDataBean.nodesectdirtiness || null;
        
        this.children = [];
        if (aDataBean.children)
        {
           	for(var i = 0; i < aDataBean.children.length; i++)
           	{
           	    this.children.push(new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(aDataBean.children[i]));	
           	}
        }  
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
