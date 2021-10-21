//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appdocument");

org.r3.db.sailevent.appdocument.SailApplicationDocumentQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.appdocument.SailApplicationDocumentDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['documentid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Id.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.documentid || '';
          }       
       };
        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "eventid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "applicationid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['documenttypecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Tipo",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getDocumenttypecode() || '';
          }       
       };
        defaultColumnDefinitions['documentname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nome",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.documentname || '';
          }       
       };
        defaultColumnDefinitions['documenturl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "documenturl",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.documenturl || '';
          }       
       };
        defaultColumnDefinitions['filesize'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "filesize",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.filesize || '';
          }       
       };
        defaultColumnDefinitions['contenttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "contenttype",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.contenttype || '';
          }       
       };
        defaultColumnDefinitions['annotation'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "annotation",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.annotation || '';
          }       
       };
        defaultColumnDefinitions['imageurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "imageurl",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.imageurl || '';
          }       
       };
        defaultColumnDefinitions['imageheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "imageheight",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.imageheight || '';
          }       
       };
        defaultColumnDefinitions['imagewidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "imagewidth",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.imagewidth || '';
          }       
       };
        defaultColumnDefinitions['iconurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "iconurl",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.iconurl || '';
          }       
       };
        defaultColumnDefinitions['iconwidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "iconwidth",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.iconwidth || '';
          }       
       };
        defaultColumnDefinitions['iconheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "iconheight",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.iconheight || '';
          }       
       };
        defaultColumnDefinitions['uploadtimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "uploadtimestamp",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.uploadtimestamp || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.appdocument.SailApplicationDocumentDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

