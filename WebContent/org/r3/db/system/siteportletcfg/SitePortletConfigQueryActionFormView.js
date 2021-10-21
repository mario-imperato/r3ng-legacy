//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.siteportletcfg");

org.r3.db.system.siteportletcfg.SitePortletConfigQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
{
   //
   // optionsHash: dataTableId, dataTableSource, dataTableColumns, searchEnabled, advancedSearchActionFormView, htmlTemplateUrl
   //
   init: function(anHtmlActionFormContainerId, anActionFormManager, optionsHash)
   {
      this._super(anHtmlActionFormContainerId, anActionFormManager, optionsHash);
   },

   getAdapterFromServerData: function(serverResponseData)
   {
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.siteportletcfg.SitePortletConfigDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
          "fnRender": function ( oObj, sVal ) 
          {
          	    var item = oObj.aData; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "site",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['pageid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pageid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pageid || '';
          }       
       };
        defaultColumnDefinitions['positionid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "positionid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.positionid || '';
          }       
       };
        defaultColumnDefinitions['jsclassname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "jsclassname",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.jsclassname || '';
          }       
       };
        defaultColumnDefinitions['cssclassname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "cssclassname",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.cssclassname || '';
          }       
       };
        defaultColumnDefinitions['datacardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "datacardid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.datacardid || '';
          }       
       };
        defaultColumnDefinitions['dataoptions'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "dataoptions",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.dataoptions || '';
          }       
       };
        defaultColumnDefinitions['dataonuserstatus'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "dataonuserstatus",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.dataonuserstatus || '';
           }       
        };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.siteportletcfg.SitePortletConfigDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

