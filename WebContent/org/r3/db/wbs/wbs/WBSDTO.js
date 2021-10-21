//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.wbs.wbs");

org.r3.db.wbs.wbs.WBSDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	    this.dtrowclass   = "grade_wbs";
        this.dtokey       = aDataBean.dtokey   || null;
        this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.wbsid = aDataBean.wbsid || null;
        this.wbstitle = aDataBean.wbstitle || null;
        this.wbstext = aDataBean.wbstext || null;
        this.bbstopicid = aDataBean.bbstopicid || null;
        this.options = aDataBean.options || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
        //
        this.rootnode = null;
        if (aDataBean.rootnode)
        {
          this.rootnode = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(aDataBean.rootnode);	
        }       

        this.actors = [];
        if (aDataBean.actors && aDataBean.actors.length)
        {
        	for(var i = 0; i < aDataBean.actors.length; i++)
        	{
        		var a = new org.r3.db.wbs.wbsactor.WBSActorDTOAdapter(aDataBean.actors[i]);
        		this.actors.push(a);
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
