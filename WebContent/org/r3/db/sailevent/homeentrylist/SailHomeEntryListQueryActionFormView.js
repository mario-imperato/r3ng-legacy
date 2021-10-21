//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.homeentrylist");

org.r3.db.sailevent.homeentrylist.SailHomeEntryListQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.homeentrylist.SailHomeEntryListDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "eventid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "applicationid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "userid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "sailnumber",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtname",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['yachttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachttype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachttype || '';
          }       
       };
        defaultColumnDefinitions['boatimageurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimageurl",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimageurl || '';
          }       
       };
        defaultColumnDefinitions['boatimageheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimageheight",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimageheight || '';
          }       
       };
        defaultColumnDefinitions['boatimagewidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimagewidth",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimagewidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonurl",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonurl || '';
          }       
       };
        defaultColumnDefinitions['boaticonwidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonwidth",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonwidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonheight",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonheight || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.homeentrylist.SailHomeEntryListDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

