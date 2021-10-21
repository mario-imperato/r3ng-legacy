//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};

   	   var global_multiselector = this.dataTableId + "_all_threadid";
   	   
   	   defaultColumnDefinitions['multiselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "<input type='checkbox' id='" + global_multiselector + "' name='all_threadid' value='btrue' />",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    
          	    var itemChecked = "";
          	    var s = "<input type='checkbox' name='threadid' value='" + item.dataBean.threadid + "' " + itemChecked + " />"; 
                return s;
          }
       };
   	   
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

       defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['threadid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.threadid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.threadid || '';
          }       
       };
        defaultColumnDefinitions['topicid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.topicid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.topicid || '';
          }       
       };
        defaultColumnDefinitions['threadtitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.threadtitle,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.threadtitle || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.userid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['creationdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "right",
          "sTitle": org.r3.db.bbs.bbsthread.message.creationdate,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getCreationdate() || '';
          }       
       };
        defaultColumnDefinitions['numposts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "right",
          "sTitle": org.r3.db.bbs.bbsthread.message.numposts,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numposts || '0';
          }       
       };
        defaultColumnDefinitions['lastthreadnodeid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.lastthreadnodeid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.lastthreadnodeid || '';
          }       
       };
        defaultColumnDefinitions['lastposttimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "right",
          "sTitle": org.r3.db.bbs.bbsthread.message.lastposttimestamp,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getLastposttimestamp() || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbsthread.message.recstatus,
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
          "sTitle": org.r3.db.bbs.bbsthread.message.rectimestamp,
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
   	  var adaptedItem = new org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

