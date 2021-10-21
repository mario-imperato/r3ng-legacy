//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo.sitecollection");

org.r3.db.mongo.sitecollection.SiteCollectionQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(aRowDataBean); });
      return adapter;
   },

   _setupDefaultColumnDefinitions: function()
   {
       return org.r3.db.mongo.sitecollection.SiteCollectionQueryActionFormView_ColumnDefinitions (this.dataTableId);
   },

   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(anItem);
   	  this.addItem(adaptedItem);
   },

   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }

});

org.r3.db.mongo.sitecollection.SiteCollectionQueryActionFormView_ColumnDefinitions  = function(theDataTableId, includeOnlyFieldList)
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
          		var s = '<div class="queryformview-tools"><i class="fa fa-file-o tools-icon toolid-file" style="margin: 2px"></i></div>';
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
       		"sTitle": org.r3.db.mongo.sitecollection.message.site,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.site || '';
       		}
    	};
    }
 	var columnId = 'domain';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.domain,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.domain || '';
       		}
    	};
    }
 	var columnId = 'sitetype';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.sitetype,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.sitetype || '';
       		}
    	};
    }
 	var columnId = 'sitestatus';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.sitestatus,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.sitestatus || '';
       		}
    	};
    }
 	var columnId = 'description';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.description,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.description || '';
       		}
    	};
    }
 	var columnId = 'summary';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.summary,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.summary || '';
       		}
    	};
    }
 	var columnId = 'primarygeo';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.primarygeo,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.primarygeo || '';
       		}
    	};
    }
 	var columnId = 'lastmodified';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.sitecollection.message.lastmodified,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.lastmodified || '';
       		}
    	};
    }
 
    return defaultColumnDefinitions;
};

