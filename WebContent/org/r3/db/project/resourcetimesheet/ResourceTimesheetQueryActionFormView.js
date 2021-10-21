//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.resourcetimesheet");

org.r3.db.project.resourcetimesheet.ResourceTimesheetQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.resourcetimesheet.ResourceTimesheetDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	         	  
   	   var attributekey = '<attributeid>';    
       var global_multiselector = this.dataTableId + "_all_" + attributekey;
   	   var selectorPrefix = this.dataTableId;

   	   defaultColumnDefinitions['singleselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    var k = item.dataBean.dtokey;
          	    var d = item.dataBean.dtodescr;
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='radio' name='" + attributekey + "' id='" + selectorPrefix + '_' + item.dataBean.dtokey + "' value='" + k + "' title='" + d + "' " + itemChecked + " />"; 
                return s;
          }
       };   	      	         	      
       
   	   defaultColumnDefinitions['multiselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "<input type='checkbox' id='" + global_multiselector + "' name='all_" + attributekey + "' value='btrue' />",
       
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    var k = item.dataBean.dtokey;
          	    var d = item.dataBean.dtodescr;
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='checkbox' name='" + attributekey + "' value='" + k + "' " + itemChecked + " />"; 
                return s;
          }
       };  
              
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.indexOfItem;
          }       
       };

	    defaultColumnDefinitions['queryformview-tools'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
       	  "sWidth": "30px",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             var s = '<div class="queryformview-tools"><i class="fa fa-file-o tools-icon toolid-file" style="margin: 2px"></i></div>';
                return s;
          }       
       };  
       
        defaultColumnDefinitions['tsentryid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.tsentryid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.tsentryid || '';
          }       
       };
        defaultColumnDefinitions['caleveday'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.caleveday,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.caleveday || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['teamid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.teamid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.teamid || '';
          }       
       };
        defaultColumnDefinitions['resourceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.resourceid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourceid || '';
          }       
       };
        defaultColumnDefinitions['uniteffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.uniteffort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.uniteffort || '';
          }       
       };
        defaultColumnDefinitions['ordeffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.ordeffort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ordeffort || '';
          }       
       };
        defaultColumnDefinitions['exteffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.exteffort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.exteffort || '';
          }       
       };
        defaultColumnDefinitions['oncalleffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.oncalleffort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.oncalleffort || '';
          }       
       };
        defaultColumnDefinitions['tseuserid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.tseuserid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.tseuserid || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resourcetimesheet.message.rectimestamp,
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
   	  var adaptedItem = new org.r3.db.project.resourcetimesheet.ResourceTimesheetDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

