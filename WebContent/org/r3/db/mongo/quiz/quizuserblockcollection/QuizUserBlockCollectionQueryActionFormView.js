//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizuserblockcollection");

org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(aRowDataBean); });
      return adapter;
   },

   _setupDefaultColumnDefinitions: function()
   {
       return org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionQueryActionFormView_ColumnDefinitions (this.dataTableId);
   },

   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(anItem);
   	  this.addItem(adaptedItem);
   },

   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }

});

org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionQueryActionFormView_ColumnDefinitions  = function(theDataTableId, includeOnlyFieldList)
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

	var columnId = 'quizuserblocknumber';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.quizuserblocknumber,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.quizuserblocknumber || '';
       		}
    	};
    }
 	var columnId = 'quizid';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.quizid,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.quizid || '';
       		}
    	};
    }
 	var columnId = 'usersessionid';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.usersessionid,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.usersessionid || '';
       		}
    	};
    }
 	var columnId = 'blocknumber';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.blocknumber,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.blocknumber || '';
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
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.status,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.status || '';
       		}
    	};
    }
 	var columnId = 'validfrom';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.validfrom,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.validfrom || '';
       		}
    	};
    }
 	var columnId = 'validto';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.validto,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.validto || '';
       		}
    	};
    }
 	var columnId = 'duration';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.duration,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.duration || '';
       		}
    	};
    }
 	var columnId = 'lateanswerpenalty';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.lateanswerpenalty,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.lateanswerpenalty || '';
       		}
    	};
    }
 	var columnId = 'userstartdate';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.userstartdate,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.userstartdate || '';
       		}
    	};
    }
 	var columnId = 'usertimer';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.usertimer,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.usertimer || '';
       		}
    	};
    }
 	var columnId = 'score';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.score,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.score || '';
       		}
    	};
    }
 	var columnId = 'lastanswerdate';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.lastanswerdate,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.lastanswerdate || '';
       		}
    	};
    }
 	var columnId = 'lastanswerquestion';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.lastanswerquestion,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.lastanswerquestion || '';
       		}
    	};
    }
 	var columnId = 'userlateanswerpenalty';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.userlateanswerpenalty,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.userlateanswerpenalty || '';
       		}
    	};
    }
 	var columnId = 'numberofquestions';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.numberofquestions,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.numberofquestions || '';
       		}
    	};
    }
 	var columnId = 'numberofanswered';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.numberofanswered,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.numberofanswered || '';
       		}
    	};
    }
 	var columnId = 'numberofok';
	if (!includeOnlyFieldList || includeOnlyFieldList.indexOf(columnId) >= 0)
	{
    	defaultColumnDefinitions[columnId] =
    	{
    	  	"aTargets": [ -1 ],
       		"sClass": "text-left",
       		"sTitle": org.r3.db.mongo.quiz.quizuserblockcollection.message.numberofok,
       		"render": function ( data, type, row, meta )
       		{
          		var item = data;
          		return item.dataBean.numberofok || '';
       		}
    	};
    }
 
    return defaultColumnDefinitions;
};

