//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.cardview");

org.r3.db.cms.cardview.CardViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.cms.cardview.CardViewDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['cardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "cardid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.cardid || '';
          }       
       };
        defaultColumnDefinitions['languagecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "languagecode",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.languagecode || '';
          }       
       };

        defaultColumnDefinitions['categoryid'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "categoryid",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.categoryid || '';
           }       
        };
        defaultColumnDefinitions['pagelinktype'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "pagelinktype",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.pagelinktype || '';
           }       
        };
         defaultColumnDefinitions['pagelink'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "pagelink",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.pagelink || '';
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
         defaultColumnDefinitions['refdate'] = 
        {
       	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "Data Rif.",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.refdate || '';
           }       
        };
         defaultColumnDefinitions['options'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "options",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.options || '';
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
        defaultColumnDefinitions['summary'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "summary",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.summary || '';
          }       
       };
        defaultColumnDefinitions['textbody'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "textbody",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.textbody || '';
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
   	  var adaptedItem = new org.r3.db.cms.cardview.CardViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

