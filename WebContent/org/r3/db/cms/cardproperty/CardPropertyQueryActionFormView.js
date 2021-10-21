//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.cms.cardproperty");

org.r3.db.cms.cardproperty.CardPropertyQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.cms.cardproperty.CardPropertyDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['propertyid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertyid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.propertyid || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['cardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.cardid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cardid || '';
          }       
       };
        defaultColumnDefinitions['languagecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.languagecode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.languagecode || '';
          }       
       };
        defaultColumnDefinitions['propertyrole'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertyrole,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getPropertyrole() || '';
          }       
       };
        defaultColumnDefinitions['propertytypecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertytypecode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.propertytypecode || '';
          }       
       };
        defaultColumnDefinitions['propertyname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertyname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.propertyname || '';
          }       
       };
        defaultColumnDefinitions['propertyvalue'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertyvalue,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.propertyvalue || '';
          }       
       };
        defaultColumnDefinitions['propertysize'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.propertysize,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             var s = item.dataBean.propertysize + 'B';
             return s;
          }       
       };
        defaultColumnDefinitions['refpropertyid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.refpropertyid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.refpropertyid || '';
          }       
       };
        defaultColumnDefinitions['contenttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.contenttype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.contenttype || '';
          }       
       };
        defaultColumnDefinitions['imageurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.imageurl,
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
          "sTitle": org.r3.db.cms.cardproperty.message.imageheight,
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
          "sTitle": org.r3.db.cms.cardproperty.message.imagewidth,
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
          "sTitle": org.r3.db.cms.cardproperty.message.iconurl,
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
          "sTitle": org.r3.db.cms.cardproperty.message.iconwidth,
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
          "sTitle": org.r3.db.cms.cardproperty.message.iconheight,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.iconheight || '';
          }       
       };
        defaultColumnDefinitions['imagesize'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": org.r3.db.cms.cardproperty.message.imagesize,
           "render": function ( data, type, row, meta )
           {
              var item = data;
              var s = null;
              if (item.dataBean.imagewidth && item.dataBean.imageheight)
            	  s = "[" + item.dataBean.imagewidth + "," + item.dataBean.imageheight + "]";

              return s || '';
           }       
        };
        defaultColumnDefinitions['iconsize'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle":  org.r3.db.cms.cardproperty.message.iconsize,
           "render": function ( data, type, row, meta )
           {
              var item = data;
              var s = null;
              if (item.dataBean.iconwidth && item.dataBean.iconheight)
            	  s = "[" + item.dataBean.iconwidth + "," + item.dataBean.iconheight +  "]";

              return s || '';
           }       
        };        
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.cardproperty.message.recstatus,
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
          "sTitle": org.r3.db.cms.cardproperty.message.rectimestamp,
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
   	  var adaptedItem = new org.r3.db.cms.cardproperty.CardPropertyDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

