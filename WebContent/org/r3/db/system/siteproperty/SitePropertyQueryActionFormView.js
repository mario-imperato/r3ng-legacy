//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.siteproperty");

org.r3.db.system.siteproperty.SitePropertyQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['propertyscope'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "propertyscope",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.propertyscope || '';
          }       
       };
        defaultColumnDefinitions['propertykey'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "propertykey",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.propertykey || '';
          }       
       };
        defaultColumnDefinitions['propertyvalue'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "propertyvalue",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.propertyvalue || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

