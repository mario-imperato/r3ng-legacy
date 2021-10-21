//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.page");

org.r3.db.cms.page.PageDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.cms.page.PageDTO(aDataBean));
	 },
	 
	 isInRole: function()
	 {
	     if (!this.dataBean.permissions)
	    	 return true;
	     
	     return org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, this.dataBean.permissions);
	 },
	 
	 isVisible: function(aContext)
	 {
		 return this.dataBean.visibility && this.dataBean.visibility.indexOf(aContext) >= 0;
	 },
	 
	 getPageIcon2Url: function()
	 {
		 return org.r3.SiteConstants.getSiteresourcepathUrl4FileName(this.dataBean.pageicon2);
	 },
	 
	 loadPageImage: function(anImageContainerId)
	 {
		 if (this.dataBean.pageicon2)
		 {
			 loadImage(
					this.getPageIcon2Url(), // this.dataBean.pageicon2,
				    function (img) {
				        if(img.type === "error") {
				            console.log("Error loading image " + imageUrl);
				        } else {
				            $(anImageContainerId).append(img);
				        }
				    },
				    {maxWidth: 600}
			 );		 
		 }
	 },
	 
	 getVisibilityAsArray: function()
	 {
		 if (this.dataBean.visibility)
			 return this.dataBean.visibility.split(',');
		 
		 return null;
	 },
	 
	 getViewOptionsJSObject: function()
	 {
		 var r = { 
			"cardindexquery": "groupid=grp_meeting", "cardtemplate": "cms_tpl_cardview_type3", "downloadCanvas": true  
		 };
		 
		 if (this.dataBean.viewoptions)
		 {
			 r = JSON.parse(this.dataBean.viewoptions);
		 }
		 
		 return r;
	 }
 
});

