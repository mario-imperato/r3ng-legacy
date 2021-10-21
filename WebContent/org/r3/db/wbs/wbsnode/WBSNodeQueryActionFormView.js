//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.wbs.wbsnode");

org.r3.db.wbs.wbsnode.WBSNodeQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['wbsnodeid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "wbsnodeid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.wbsnodeid || '';
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
        defaultColumnDefinitions['wbsid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "wbsid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.wbsid || '';
          }       
       };
        defaultColumnDefinitions['nodetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodetype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodetype || '';
          }       
       };
        defaultColumnDefinitions['nodeorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodeorder",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodeorder || '';
          }       
       };
        defaultColumnDefinitions['nodesect'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodesect",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodesect || '';
          }       
       };
        defaultColumnDefinitions['nodename'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodename",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodename || '';
          }       
       };
        defaultColumnDefinitions['nodesummary'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodesummary",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodesummary || '';
          }       
       };
        defaultColumnDefinitions['nodetext'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodetext",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodetext || '';
          }       
       };
        defaultColumnDefinitions['nodeparentid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodeparentid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodeparentid || '';
          }       
       };
        defaultColumnDefinitions['nodepath'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "nodepath",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.nodepath || '';
          }       
       };
        defaultColumnDefinitions['assignedto'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "assignedto",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.assignedto || '';
          }       
       };
        defaultColumnDefinitions['duration'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "duration",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.duration || '';
          }       
       };
        defaultColumnDefinitions['startdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "startdate",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.startdate || '';
          }       
       };
        defaultColumnDefinitions['enddate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "enddate",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.enddate || '';
          }       
       };
        defaultColumnDefinitions['completiontype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completiontype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completiontype || '';
          }       
       };
        defaultColumnDefinitions['completionstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completionstatus",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completionstatus || '';
          }       
       };
        defaultColumnDefinitions['completiondescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completiondescr",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completiondescr || '';
          }       
       };
        defaultColumnDefinitions['completion'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completion",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completion || '';
          }       
       };
        defaultColumnDefinitions['completionfrom'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completionfrom",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completionfrom || '';
          }       
       };
        defaultColumnDefinitions['completionto'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completionto",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completionto || '';
          }       
       };
        defaultColumnDefinitions['completiondate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completiondate",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completiondate || '';
          }       
       };
        defaultColumnDefinitions['completioneffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completioneffort",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completioneffort || '';
          }       
       };
        defaultColumnDefinitions['completioneffunit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completioneffunit",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completioneffunit || '';
          }       
       };
        defaultColumnDefinitions['economicvalue'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "economicvalue",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.economicvalue || '';
          }       
       };
        defaultColumnDefinitions['economicvalue2'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "economicvalue2",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.economicvalue2 || '';
          }       
       };
        defaultColumnDefinitions['economicvalue3'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "economicvalue3",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.economicvalue3 || '';
          }       
       };
        defaultColumnDefinitions['remarks'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "remarks",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.remarks || '';
          }       
       };
        defaultColumnDefinitions['stereotype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "stereotype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.stereotype || '';
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
   	  var adaptedItem = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

