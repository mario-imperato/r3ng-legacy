//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.resourcetimesheetview");

org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
       return org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView_ColumnDefinitions (this.dataTableId);
   },
      
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView_ColumnDefinitions  = function(theDataTableId, includeOnlyFieldList)
{ 
    var defaultColumnDefinitions = {};
          	  
    var attributekey = '<attributeid>';    
    var global_multiselector = theDataTableId + "_all_" + attributekey;
    var selectorPrefix = theDataTableId;

    var columnId = 'singleselector';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {
    defaultColumnDefinitions[columnId] = 
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
//      	    if ($('#' + global_multiselector).prop('checked'))
//      	    {
//      	    	itemChecked = ' checked ';
//      	    }
      	    var s = "<input type='radio' name='" + attributekey + "' id='" + selectorPrefix + '_' + item.dataBean.dtokey + "' value='" + k + "' title='" + d + "' " + itemChecked + " />"; 
            return s;
      }
    };   	      	         	      
    }
    
		var columnId = 'multiselector';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
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
//       	    if ($('#' + global_multiselector).prop('checked'))
//       	    {
//       	    	itemChecked = ' checked ';
//       	    }
       	    var s = "<input type='checkbox' name='" + attributekey + "' value='" + k + "' " + itemChecked + " />"; 
             return s;
       }
    };  
    }
    
		var columnId = 'indexofitem';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {                   
	   defaultColumnDefinitions[columnId] = 
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
    }
    
		var columnId = 'queryformview-tools';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {  
    	  "aTargets": [ -1 ], 
    	  "sClass": "text-center", 
    	  "sTitle": "",
    	  "sWidth": "30px",
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          var s = '<div class="queryformview-tools"><i class="fa fa-trash-o tools-icon toolid-trash" style="margin: 2px"></i></div>';
             return s;
       }       
    };  
    }
    
		var columnId = 'site';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.site,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.site || '';
       }       
    };
    }
 		var columnId = 'tsentryid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.tsentryid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.tsentryid || '';
       }       
    };
    }
 		var columnId = 'sitedomain';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.sitedomain,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.sitedomain || '';
       }       
    };
    }
 		var columnId = 'resourceid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.resourceid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.resourceid || '';
       }       
    };
    }
 		var columnId = 'resourcedescr';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.resourcedescr,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.resourcedescr || '';
       }       
    };
    }
 		var columnId = 'teamid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.teamid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.teamid || '';
       }       
    };
    }
 		var columnId = 'teamperiod';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.teamperiod,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.teamperiod || '';
       }       
    };
    }
 		var columnId = 'profileid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.profileid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.profileid || '';
       }       
    };
    }
 		var columnId = 'companyid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.companyid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.companyid || '';
       }       
    };
    }
 		var columnId = 'costcenter1';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.costcenter1,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.costcenter1 || '';
       }       
    };
    }
 		var columnId = 'costcenter2';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.costcenter2,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.costcenter2 || '';
       }       
    };
    }
 		var columnId = 'costcenter3';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.costcenter3,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.costcenter3 || '';
       }       
    };
    }
 		var columnId = 'uniteffort';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.uniteffort,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.uniteffort || '';
       }       
    };
    }
 		var columnId = 'ordeffort';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-center",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.ordeffort,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.ordeffort || '0';
       }       
    };
    }
 		var columnId = 'exteffort';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-center",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.exteffort,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.exteffort || '0';
       }       
    };
    }
 		var columnId = 'oncalleffort';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-center",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.oncalleffort,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.oncalleffort || '0';
       }       
    };
    }
 		var columnId = 'price';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.price,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.price || '0';
       }       
    };
    }
 		var columnId = 'cost';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.cost,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.cost || '0';
       }       
    };
    }
 		var columnId = 'evalueunit';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.evalueunit,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.evalueunit || '';
       }       
    };
    }
 		var columnId = 'caldate';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.caldate,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.caldate || '';
       }       
    };
    }
 		var columnId = 'caleveday';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.caleveday,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.caleveday || '';
       }       
    };
    }
 		var columnId = 'calevemonth';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.calevemonth,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.getCalevemonth() || '';
       }       
    };
    }
 		var columnId = 'caleveweek';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.caleveweek,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.caleveweek || '';
       }       
    };
    }
 		var columnId = 'calevequarter';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.calevequarter,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.getCalevequarter() || '';
       }       
    };
    }
 		var columnId = 'caleveyear';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.caleveyear,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.getCaleveyear() || '';
       }       
    };
    }
 		var columnId = 'tseuserid';
	  if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	  {        
    defaultColumnDefinitions[columnId] = 
    {
    	  "aTargets": [ -1 ],
       "sClass": "text-left",
       "sTitle": org.r3.db.project.resourcetimesheetview.message.tseuserid,
       "render": function ( data, type, row, meta )
       {
          var item = data; 
          return item.dataBean.tseuserid || '';
       }       
    };
    }
     
    return defaultColumnDefinitions;
};

