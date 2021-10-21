//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.openregattas.openregattasview");

org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['regattaid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "regattaid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.regattaid || '';
          }       
       };
        defaultColumnDefinitions['title'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "title",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.title || '';
          }       
       };
        defaultColumnDefinitions['languages'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "languages",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.languages || '';
          }       
       };
        defaultColumnDefinitions['domain'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "domain",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.domain || '';
          }       
       };
        defaultColumnDefinitions['icon'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "icon",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.icon || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

