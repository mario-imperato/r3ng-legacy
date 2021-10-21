//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo.postcollection");

org.r3.db.mongo.postcollection.PostCollectionQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(aRowDataBean); });
      return adapter;
   },

   _setupDefaultColumnDefinitions: function()
   {
       return org.r3.db.mongo.postcollection.PostCollectionQueryActionFormView_ColumnDefinitions (this.dataTableId);
   },

   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(anItem);
   	  this.addItem(adaptedItem);
   },

   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }

});

org.r3.db.mongo.postcollection.PostCollectionQueryActionFormView_ColumnDefinitions  = function(theDataTableId, includeOnlyFieldList)
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

	var columnId = 'postid';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.postid,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.postid || '';
       		}
    	};
    }
 	var columnId = 'status';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.status,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.status || '';
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
       		"sTitle": org.r3.db.mongo.postcollection.message.site,
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
       		"sTitle": org.r3.db.mongo.postcollection.message.domain,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.domain || '';
       		}
    	};
    }
 	var columnId = 'timeline';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.timeline,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.timeline || '';
       		}
    	};
    }
 	var columnId = 'author';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.author,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.author || '';
       		}
    	};
    }
 	var columnId = 'authorname';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.authorname,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.authorname || '';
       		}
    	};
    }
 	var columnId = 'authortype';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.authortype,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.authortype || '';
       		}
    	};
    }
 	var columnId = 'userid';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.userid,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.userid || '';
       		}
    	};
    }
 	var columnId = 'refdate';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.refdate,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.refdate || '';
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
       		"sTitle": org.r3.db.mongo.postcollection.message.lastmodified,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.getLastmodified() || '';
       		}
    	};
    }
 	var columnId = 'title';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.title,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.title || '';
       		}
    	};
    }
 	var columnId = 'contentcategory';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.contentcategory,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.contentcategory || '';
       		}
    	};
    }	
 	var columnId = 'contentclass';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.contentclass,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.contentclass || '';
       		}
    	};
    }
 
    return defaultColumnDefinitions;
};

