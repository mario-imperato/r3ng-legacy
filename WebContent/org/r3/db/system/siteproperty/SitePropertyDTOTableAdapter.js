//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.siteproperty");

org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter = org.r3.db.DTOTableAdapter.extend(
{
	init: function(queryResult, aDataBeanAdapterConstructor)
	 {  
	 	   this._super(queryResult, aDataBeanAdapterConstructor);
	 },
	 
	 getPropertyByPropertyscopePropertykey: function(aPropertyScope, aPropertyKey)
	 {
		 var p = this.findItem(aPropertyScope + '.' + aPropertyKey);  		 		 
		 return p;
	 }
});
