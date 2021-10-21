//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo");

org.r3.db.mongo.MongoFileAttachmentDTO = Class.extend(
 {
     init: function(aDataBean)
	 {         
    	this.fileid = aDataBean.fileid || null;    	 
        this.url = aDataBean.url || null;
        this.ctype = aDataBean.ctype || null;
        this.width = aDataBean.width || null;
        this.height = aDataBean.height || null;
        this.name = aDataBean.name || null;
        this.size = aDataBean.size || null;
        this.attachmenttype = aDataBean.attachmenttype || null;
        this.fileIcon = aDataBean.fileIcon || null;
	 }	   
 });  

org.r3.db.mongo.MongoFileAttachmentDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	init : function(aDataBean)
	{
		this._super(new org.r3.db.mongo.MongoFileAttachmentDTO(aDataBean));
	},
		
	getUrl: function()
	{
		return this.dataBean.url;
	},
	
	hasIcon: function()
	{
		return this.dataBean.fileIcon;
	},
	
	getIcon: function()
	{
		return new org.r3.db.mongo.MongoImageDTOAdapter(this.dataBean.fileIcon);
	},
	
	isImage: function()
	{
		return false;
	}

});

org.r3.db.mongo.MongoFileAttachmentQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.mongo.MongoFileAttachmentDTOAdapter(aRowDataBean); });
      return adapter;
   },

   _setupDefaultColumnDefinitions: function()
   {
       return org.r3.db.mongo.MongoFileAttachmentQueryActionFormView_ColumnDefinitions (this.dataTableId);
   },

   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.mongo.MongoFileAttachmentDTOAdapter(anItem);
   	  this.addItem(adaptedItem);
   },

   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }

});

org.r3.db.mongo.MongoFileAttachmentQueryActionFormView_ColumnDefinitions  = function(theDataTableId, includeOnlyFieldList)
{
    var defaultColumnDefinitions = {};

    var attributekey = 'fileid';
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
//						      	    if ($('#' + global_multiselector).prop('checked'))
//						      	    {
//						      	    	itemChecked = ' checked ';
//						      	    }
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
//						       	    if ($('#' + global_multiselector).prop('checked'))
//						       	    {
//						       	    	itemChecked = ' checked ';
//						       	    }
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

	var columnId = 'fileid';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.attachment_fileid,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.fileid || '';
       		}
    	};
    }
 
	var columnId = 'name';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.attachment_name,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.name || '';
       		}
    	};
    }

	var columnId = 'ctype';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.attachment_ctype,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.ctype || '';
       		}
    	};
    }
	
	var columnId = 'attachmenttype';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.attachment_attachmenttype,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.attachmenttype || '';
       		}
    	};
    }

	var columnId = 'size';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.postcollection.message.attachment_size,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.size || '0';
       		}
    	};
    }
    return defaultColumnDefinitions;
};
