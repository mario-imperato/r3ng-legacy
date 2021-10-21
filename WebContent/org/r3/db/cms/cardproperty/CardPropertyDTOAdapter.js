//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.cardproperty");

org.r3.db.cms.cardproperty.CardPropertyDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.cms.cardproperty.CardPropertyDTO(aDataBean));
	 },
	 
	 isAttachment: function()
	 {
		 return this.databean && 
		   (this.dataBean.propertytypecode == 'image' || 
		    this.dataBean.propertytypecode == 'document' || 
		    this.dataBean.propertytypecode == 'file');  
	 },

	 isImage: function()
	 {
		 // console.log(this.dataBean.propertytypecode == 'image')
		 return this.dataBean && 
		   (this.dataBean.propertytypecode == 'image');  
	 },
	 
	 isDocument: function()
	 {
		 // console.log(this.dataBean.propertytypecode == 'image')
		 return this.dataBean && 
		   (this.dataBean.propertytypecode == 'document');  
	 },

	 isFile: function()
	 {
		 // console.log(this.dataBean.propertytypecode == 'image')
		 return this.dataBean && 
		   (this.dataBean.propertytypecode == 'file');  
	 },

	 isHtmlfragment: function()
	 {
		 // console.log(this.dataBean.propertytypecode == 'image')
		 return this.dataBean && 
		   (this.dataBean.propertytypecode == 'htmlfragment');  
	 },

	 isLink: function()
	 {
		 // console.log(this.dataBean.propertytypecode == 'image')
		 return this.dataBean && 
		   (this.dataBean.propertytypecode == 'link');  
	 },

	 hasIcon: function()
	 {
		 return this.dataBean && this.dataBean.iconurl;  	 	 
	 },
	 
	 getPropertyrole: function()
	 {
		 if (this.dataBean.propertyrole && this.dataBean.propertyrole.length)
		 {
			 var prole = '';
			 var proles = this.dataBean.propertyrole.split(',');
			 
			 if (proles && proles.length)
			 {
				for(var i = 0; i < proles.length; i++)
				{
				   prole = prole + ' ' + proles[i];	
				}
			 }			 			 
			 
			 return prole;
		 }
		 
		 return null;
	 },
	 
	 hasPropertyrole: function(aPropertyRole)
	 {
		 return this.dataBean.propertyrole && this.dataBean.propertyrole.indexOf(aPropertyRole) >= 0;
	 },
	 
	 getImageurl: function()
	 {
		 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.imageurl);
	 },

	 getIconurl: function()
	 {
		 if (this.dataBean.iconurl)
		    return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.iconurl);
		 
		 return this.getImageurl();
	 },
	 
	 getIconMarginTop: function(maxWidth, maxHeight)
	 {
		 if (this.dataBean.iconurl)
		 {
			 return Math.floor((maxHeight - this.dataBean.iconheight) / 2)  || '0';			 
		 }
		 else  return '0';
	 },
	 
	 getDocumenturl: function()
	 {
		 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.propertyvalue);
	 },
	 
	 getDocumentIconClass_16x16: function()
	 {
		 var s = 'icon_file';
		 var ct = this.dataBean.contenttype;
		 if (ct)
		 {
			 switch(ct)
			 {
			 case 'application/pdf':
			   s = 'icon_application_pdf';
			   break;
			 }
		 }

	     return s;	 
	 },
	 
	 getOnClickGoogleTracking: function()
	 {
	     return "org.r3.PageManager.googleAnalyticsSendPageView('" + this.dataBean.propertyid + "');";	 
	 }
});

