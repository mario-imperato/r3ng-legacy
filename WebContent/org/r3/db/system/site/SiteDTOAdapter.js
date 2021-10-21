//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.site");

org.r3.db.system.site.SiteDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.site.SiteDTO(aDataBean));
	 },
	 
	 getOptions: function()
	 {
		 var p = null;
		 
		 if (this.dataBean.options)
			 p = this.dataBean.options.split(',');
		 
		 return p;
	 },
	 
	 isDomainController: function()
	 {
		 return this.dataBean.sitedomain && this.dataBean.sitedomain == this.dataBean.site;
	 }
 
});

