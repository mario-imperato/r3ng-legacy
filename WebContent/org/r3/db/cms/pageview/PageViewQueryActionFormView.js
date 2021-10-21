//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.cms.pageview");

org.r3.db.cms.pageview.PageViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.cms.pageview.PageViewDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['pagetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pagetype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pagetype || '';
          }       
       };
        defaultColumnDefinitions['pagetitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pagetitle",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pagetitle || '';
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
        defaultColumnDefinitions['pageicon1'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pageicon1",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pageicon1 || '';
          }       
       };
        defaultColumnDefinitions['pageicon2'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pageicon2",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pageicon2 || '';
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
        defaultColumnDefinitions['pageorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pageorder",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pageorder || '';
          }       
       };
        defaultColumnDefinitions['visibility'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "visibility",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.visibility || '';
          }       
       };
        defaultColumnDefinitions['pagestyle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "pagestyle",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.pagestyle || '';
          }       
       };
        defaultColumnDefinitions['forwardview'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "forwardview",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.forwardview || '';
          }       
       };
        defaultColumnDefinitions['onuserstatus'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "onuserstatus",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.onuserstatus || '';
           }       
        };
         defaultColumnDefinitions['permissions'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "permissions",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.permissions || '';
           }       
        };        
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "recstatus",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.recstatus || '';
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
   	  var adaptedItem = new org.r3.db.cms.pageview.PageViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

