//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifieritem");

org.r3.db.system.classifieritem.ClassifierItemDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.classifieritem.ClassifierItemDTO(aDataBean));
	 },
	 
	 getClassifierDTOKey: function()
	 {
		 var s = this.dataBean.site + "_" + this.dataBean.clsid;
		 return s;
	 },
	 
	 getChildrenAsCSV: function()
	 {
		 var s = '';
		 
		 if (this.dataBean.children && this.dataBean.children.length)
		 {		    
		    for(var i = 0; i <  this.dataBean.children.length; i++)
		    {
		        if (i)
		        	s = s + ', ';
		        
		        s = s + this.dataBean.children[i].dataBean.classifieritemdescr;
		    }
		 }
		 
		 return s;
	 }
 
});

