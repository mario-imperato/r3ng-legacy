//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifier");

org.r3.db.system.classifier.ClassifierDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.classifier.ClassifierDTO(aDataBean));
	 },
	 
	 isLinear: function()
	 {
		 return !this.dataBean.clstypecode || this.dataBean.clstypecode == 'linear';
	 },
	 
	 isHierarchical: function()
	 {
		 return !this.dataBean.clstypecode || this.dataBean.clstypecode == 'hierarchical';
	 }
 
});

