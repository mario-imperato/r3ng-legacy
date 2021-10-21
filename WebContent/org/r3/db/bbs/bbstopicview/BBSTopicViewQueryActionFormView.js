//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.bbs.bbstopicview");

org.r3.db.bbs.bbstopicview.BBSTopicViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.bbs.bbstopicview.BBSTopicViewDTOAdapter(aRowDataBean); });   
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
          "sTitle": org.r3.db.bbs.bbstopicview.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['topicid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.topicid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.topicid || '';
          }       
       };
        defaultColumnDefinitions['topictitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.topictitle,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.topictitle || '';
          }       
       };
        defaultColumnDefinitions['cardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.cardid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cardid || '';
          }       
       };
        defaultColumnDefinitions['moderatorid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.moderatorid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.moderatorid || '';
          }       
       };
        defaultColumnDefinitions['moderatormode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.moderatormode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.moderatormode || '';
          }       
       };
        defaultColumnDefinitions['options'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.options,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.options || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.bbs.bbstopicview.message.recstatus,
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
          "sTitle": org.r3.db.bbs.bbstopicview.message.rectimestamp,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.rectimestamp || '';
          }       
       };
        defaultColumnDefinitions['numthreads'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "right",
          "sTitle": org.r3.db.bbs.bbstopicview.message.numthreads,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numthreads || '0';
          }       
       };
        defaultColumnDefinitions['numposts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "right",
          "sTitle": org.r3.db.bbs.bbstopicview.message.numposts,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numposts || '0';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.bbs.bbstopicview.BBSTopicViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

