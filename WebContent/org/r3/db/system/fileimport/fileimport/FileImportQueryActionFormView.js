//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.system.fileimport.fileimport");

org.r3.db.system.fileimport.fileimport.FileImportQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.fileimport.fileimport.FileImportDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta )  
          {
          	    var item = data; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.site,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['importid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.importid,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.importid || '';
          }       
       };
        defaultColumnDefinitions['importname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.importname,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.importname || '';
          }       
       };
        defaultColumnDefinitions['importcontext'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.importcontext,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.importcontext || '';
          }       
       };
        defaultColumnDefinitions['majortype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.majortype,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.majortype || '';
          }       
       };
        defaultColumnDefinitions['minortype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.minortype,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.minortype || '';
          }       
       };
        defaultColumnDefinitions['withheader'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.withheader,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.withheader || '';
          }       
       };
        defaultColumnDefinitions['numberofcolumns'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.numberofcolumns,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.numberofcolumns || '';
          }       
       };
        defaultColumnDefinitions['numberofrecords'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.numberofrecords,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.numberofrecords || '';
          }       
       };
        defaultColumnDefinitions['uploaddate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.uploaddate,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.uploaddate || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.recstatus,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.fileimport.fileimport.message.rectimestamp,
          "render": function ( data, type, row, meta ) 
          {
             var item = data; 
             return item.dataBean.rectimestamp || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.fileimport.fileimport.FileImportDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

