//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifieritem");

org.r3.db.system.classifieritem.ClassifierItemDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_classifieritem";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.clsitemid = aDataBean.clsitemid || null;
        this.site = aDataBean.site || null;
        this.clsid = aDataBean.clsid || null;
        this.clsitembusid = aDataBean.clsitembusid || null;
        this.parentitemid = aDataBean.parentitemid || null;
        this.classifieritemdescr = aDataBean.classifieritemdescr || null;
        this.classifieritempath = aDataBean.classifieritempath || null;
        this.classifieritemdepth = aDataBean.classifieritemdepth || null;
        this.classifieritemorder = aDataBean.classifieritemorder || null;
        this.classifieritemiattr = aDataBean.classifieritemiattr || null;
        this.classifieritemsattr = aDataBean.classifieritemsattr || null;
 
        // Inserito
        this.numberofchildren = aDataBean.numberofchildren || null;
        if (aDataBean.children && aDataBean.children.length)
        {
        	this.children = [];
        	for(var i = 0; i < aDataBean.children.length; i++)
        	{
        		this.children.push(new org.r3.db.system.classifieritem.ClassifierItemDTOAdapter(aDataBean.children[i]));
        	}
        }
        else this.children = null;
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
