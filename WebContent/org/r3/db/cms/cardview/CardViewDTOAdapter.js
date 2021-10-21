//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.cardview");

org.r3.db.cms.cardview.CardViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.cms.cardview.CardViewDTO(aDataBean));
	 },
	 
	 getListOfPropertiesByPropertyrole: function(aPropertyRole)
	 {
		 var listOf = null;
		 
		 if (this.dataBean.properties && this.dataBean.properties.length)
		 {			 
		 var props = this.dataBean.properties;
		 for(var i = 0; i < props.length; i++)
		 {
		     if (props[i].hasPropertyrole(aPropertyRole))
		     {
		    	 if (listOf == null)
		    		  listOf = [ props[i] ];
		    	 else listOf.push(props[i]);
		     }
		 }
		 }
		 
		 return listOf;
	 },
	 
	 getRefdate: function()
	 {
		 return $.r3Utils.formatDataDataBeanField(this.dataBean.refdate);
	 },
	 
	 getCardIconUrl: function()
	 {
		 console.error("DataBean is: ", this.dataBean);
		 
		 if (this.dataBean.cardicon)
		 {
		     return this.dataBean.cardicon.getImageurl();	 
		 }
		 
		 if (this.dataBean.cardimage)
		 {
             return this.dataBean.cardimage.getIconurl();	 
         }
		 		 
		 return '';
	 },
	 
	 getCardImageUrl: function()
	 {
		 if (this.dataBean.cardimage)
		 {
		     return this.dataBean.cardimage.getImageurl();	 
		 }
		 
		 return '';
	 },
	 
	 getPagelink: function()
	 {
		 var pgl = null;

		 var urlPath = org.r3.Constants.getStrutsActionContext(this.dataBean.site) + '/org/r3/cms/cmspage.do';
		 if (this.dataBean.site != org.r3.SiteConstants.targetSite)
		 {
			 // In caso di siti diversi gestisco come se fosse una scheda regata. Forse nella vista ci dovrei mettere anche il sitetype...
			 // Questo ramo dovrebbe essere preso solamente nel caso del sito yachtclub quando vede schede dei regata...
			 urlPath = org.r3.Constants.getStrutsActionContext(this.dataBean.site) + '/org/r3/sev/cmspage.do';			 
		 }
		 else if (org.r3.SiteConstants.targetSiteType == 'regatta')
			 urlPath = org.r3.Constants.getStrutsActionContext(this.dataBean.site) + '/org/r3/sev/cmspage.do';
			 
		 switch(this.dataBean.pagelinktype)
		 {
		 case 'none':
			 break;
		 case 'page':
			 pgl = urlPath + '?pageid=' + this.dataBean.pageid + '&cardid=' + this.dataBean.cardid;
			 break;
		 case 'custom':
			 pgl = this.dataBean.pagelink;
			 break;
		 }
		 
		 return pgl;
	 },
	 
	 getOnClickGoogleTracking: function()
	 {
		 if (this.dataBean.pagelinktype == 'custom') 
		 {
			 if (this.dataBean.pagelink.indexOf("/r3ng") < 0)
			 {
			     return "org.r3.PageManager.googleAnalyticsSendPageView('" + this.dataBean.cardid + "');";	 
			 }
		 } 	 
		 
		 return "";
	 },
	 
	 // Contrariamente al precedente questo metodo ritorna un costrutto HTML che crea un link 'vero' oppure semplicemente un
	 // anchor che va intercettato per imporre l'onClick corretto.
	 getHtmlLinkFragmentTitle2Detail: function(currentPageId)
	 {
		 var pgl = null;
		 
		 var urlPath = org.r3.Constants.getStrutsActionContext() + '/org/r3/cms/cmspage.do';
		 if (org.r3.SiteConstants.targetSiteType == 'regatta')
			 urlPath = org.r3.Constants.getStrutsActionContext() + '/org/r3/sev/cmspage.do';
		 
		 switch(this.dataBean.pagelinktype)
		 {
		 case 'none':
			 pgl = this.dataBean.title;
			 break;
		 case 'page':
			 if (currentPageId && this.dataBean.pageid && this.dataBean.pageid == currentPageId)
			 {
				 pgl = "<a href='javascript:void(0)' data-cardid='" + this.dataBean.cardid + "' class='cmsCard_link2carddetail' >" + this.dataBean.title + "</a>";
			 }
			 else
			 {
				 pgl = urlPath + '?pageid=' + this.dataBean.pageid + '&cardid=' + this.dataBean.cardid;
				 pgl = "<a href='" + pgl + "'>" + this.dataBean.title + "</a>";
			 }
			 break;
		 case 'custom':
			 pgl = "<a href='" + this.dataBean.pagelink + "' onClick=\"" + this.getOnClickGoogleTracking() + "\" >" + this.dataBean.title + "</a>";
			 break;
		 }
		 
		 return pgl;		 		 
	 },
	 
	 hasExecutableHtmlFragments: function()
	 {
		 return this.dataBean.listof_executablehtmlfragments && this.dataBean.listof_executablehtmlfragments.length > 0;
	 }
 
});

