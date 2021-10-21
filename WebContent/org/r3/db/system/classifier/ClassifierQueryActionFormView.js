//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifier");

org.r3.db.system.classifier.ClassifierQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.classifier.ClassifierDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['clsid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clsid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.clsid || '';
          }       
       };
        defaultColumnDefinitions['clsdescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clsdescr",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.clsdescr || '';
          }       
       };
        defaultColumnDefinitions['clstypecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clstypecode",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.clstypecode || '';
          }       
       };
        defaultColumnDefinitions['clsambitcode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clsambitcode",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.clsambitcode || '';
          }       
       };
        defaultColumnDefinitions['cacheinterval'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "cacheinterval",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.cacheinterval || '';
          }       
       };
        defaultColumnDefinitions['etag'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "etag",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.etag || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "rectimestamp",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.rectimestamp || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.classifier.ClassifierDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

