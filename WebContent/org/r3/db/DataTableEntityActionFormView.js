$.r3Utils.namespace("org.r3.db");

org.r3.db.DataTableEntityActionFormView = org.r3.ActionFormView.extend(
{
   //
   // optionsHash: dataTableId, dataTableSource, dataTableColumns, searchEnabled, advancedSearchActionFormView, htmlTemplateUrl
   //
   init: function(anHtmlActionFormContainerId, anActionFormManager, optionsHash)
   {
      this._super(anHtmlActionFormContainerId, anActionFormManager);
      this.dataTableSource = null;
      this.dataTable = null;
      this.dataTableId = optionsHash.dataTableId;;
      
      optionsHash = $.extend({ iDisplayLength: 10, "showTemplateOnOpen" : true, actionBarOnTop: false, "canvasType": "panel-light" }, optionsHash);
      this._setupOptions(optionsHash);

   },

   _setupOptions: function(optionsHash)
   {
      this.optionsHash = optionsHash;
      this.optionsHash.defaultColumnDefinitions = this._setupDefaultColumnDefinitions();
      this.optionsHash.isLayoutFullWidth = function() { return optionsHash.layout && optionsHash.layout == 'fullWidth'; };
      this.optionsHash.isHScrollable = function() { return optionsHash.hscrollable ? optionsHash.hscrollable : ''; };
      this.optionsHash.isSortEnabled = function() { return optionsHash.sortable ? true : false; };
      this._setupSearchInfoOptions();
      this._setupAdvancedSearchInfoOptions();
      this._setupButtonsOptions();
   },

   _setupButtonsOptions: function()
   {
      this.optionsHash.isActionBarEnabled      = function() { return this.buttons; };
      this.optionsHash.isActionBarOnTop        = function() { return this.actionBarOnTop; };     
      this.optionsHash.getActionBarPosition    = function() { 
    	  var pos = 'none';
    	  if (this.buttons)
    	  {
    		  pos = 'right';
    		  if (this.actionBarOnTop) 
    			  pos = 'top';    		  
    	  }
    	  
    	  return pos;
      };      
      
      this.optionsHash.getCanvasType = function() { 
    	  return this.canvasType;
      };
    	      
   },

   _setupSearchInfoOptions: function()
   {
      this.optionsHash.isSearchEnabled         = function() { return this.searchInfo; };
      this.optionsHash.isSearchWidgetSelect    = function() { return this.searchInfo.widget == 'select'; };
      this.optionsHash.getSearchWidgetInitialization  = function() { return (this.searchInfo.widget == 'select') ? this.searchInfo.widgetInitialization : null; };
      this.optionsHash.getSearchLabel          = function() { return this.searchInfo.label; };
      
      if (this.optionsHash.isSearchEnabled())
      {
          if (!this.optionsHash.searchInfo.label)
             this.optionsHash.searchInfo.label = "Ricerca";                         
      }
   },

   _setupAdvancedSearchInfoOptions: function()
   {
      this.optionsHash.isAdvancedSearchEnabled = function() { return this.advancedSearchInfo && this.advancedSearchInfo.length > 0; };
      this.optionsHash.getAdvancedSearchLabel  = function(i) { return this.advancedSearchInfo[i].label; };
      this.optionsHash.getNumberOfAdvancedSearchOptions = function() { return (this.advancedSearchInfo) ? this.advancedSearchInfo.length : 0; };
      this.optionsHash.advancedSearchAutoOpenIndex = -1;
      if (this.optionsHash.isAdvancedSearchEnabled())
      {
          for(var i = 0; i < this.optionsHash.advancedSearchInfo.length; i++)
          {
              if (!this.optionsHash.advancedSearchInfo[i].label)
                 this.optionsHash.advancedSearchInfo[i].label = "Ricerca Avanzata";
                 
              if (this.optionsHash.advancedSearchInfo[i].autoOpen)
                 this.optionsHash.advancedSearchAutoOpenIndex = i;
          }
          
      }
   },

   _initAdvancedSearchForm: function()
   {
      if (this._isAdvancedSearchEnabled())
      {
         $('.' + this.dataTableId + '_filter_advsearch').bind('click', $.r3Utils.hitch(this, this._onClickOpenAdvancedSearchDialog));
      }
   },
   
   _initSearchForm: function()
   {
        if (this._isSearchEnabled())
        {
          if (this.optionsHash.searchInfo.validationRules)
          {
          $('#' + this.dataTableId + '_filter_searchform').validate
          ({
             rules: this.optionsHash.searchInfo.validationRules,
             messages: this.optionsHash.searchInfo.validationMessages    
          });
          }
                     
          $('#' + this.dataTableId + '_filter_searchform').bind("keypress", $.r3Utils.hitch(this, function(event)
          {              
              if (event.keyCode == 13)
              {                
               	 event.preventDefault();
                 this._executeSearch(); 
                 return false;
              }                                            
          }));
          
//          $('#' + this.dataTableId + '_filter_item').keydown($.r3Utils.hitch(this, function(event)
//          {
//          }));

          // Il finder cerca la classe....
          $('.' + this.dataTableId + '_filter_search').bind('click', $.r3Utils.hitch(this, this._executeSearch));
          
          if (this._getSearchWidgetInitialization())
          {
  			org.r3.PageManager.lutManager.populateSelectField(
  		 	{
  				"lutUrl" : this._getSearchWidgetInitialization().url,
  				"blankOptionText" : this._getSearchWidgetInitialization().blankOptionText,
  				"selectWidget" : $('#' + this.dataTableId + '_filter_searchitem')
  			});  
  			
  			$('#' + this.dataTableId + '_filter_searchitem').unbind().change($.r3Utils.hitch(this, this._executeSearch));
          }
        }
                
   },
   
   close: function()
   {
      this.hide();
   },

   refresh: function()
   {
	  console.info("Refreshing the view....");
	  this._super();
	  
  	  if (this.optionsHash.requiredLUTs && this.optionsHash.requiredLUTs.length)
	  {
  		    var networkRequestsQueue = [];
			for ( var j = 0; j < this.optionsHash.requiredLUTs.length; j++)
			{
				networkRequestsQueue.push(this._getLUTNetworkRequest(j));
			}
			
			org.r3.PageManager.multiAjax(networkRequestsQueue, $.r3Utils.hitch(this, function(responseData)
			{
				this.dataTable.fnDraw();
			}));			
	  }
  	  else 
  	  {
  		  console.info("Doing a Redraw Only....");
  		  this.dataTable.fnDraw();
  	  }
   },
   
   _getHtmlTemplateUrl: function()
   {
	   var templateUrl = this.optionsHash.htmlTemplateUrl;
	   if (!templateUrl)
		   templateUrl = org.r3.Constants.applicationContext + "/org/r3/db/DefaultEntityViewTemplate.html";
	   
	   return templateUrl;
   },
   
   _isDeferLoading: function()
   {
      if (this._isAjaxSource() && this._isSearchEnabled() && !this.optionsHash.searchInfo.autoStart)
           return true;
           
      return false;
   },
   
   _getScrollX: function()
   {
	   if (this.optionsHash.isHScrollable())
		   return "100%";
	   
	   return null;
   },
   
   _getScrollXInner: function()
   {
	   if (this.optionsHash.isHScrollable())
		   return this.optionsHash.isHScrollable();
	   
	   return null;	   
   },
   
   _isAutoWidth: function()
   {	   
	   if (this.optionsHash.fixedWidth)
		   return false;
	   
	   return true;
   },
   
   _isPaginate: function()
   {
      return this.optionsHash.dataTableSource && this.optionsHash.iDisplayLength > 0;
   },

   _getIDisplayLength: function()
   {
	   return this.optionsHash.iDisplayLength;
   },
   
   _isAjaxSource: function()
   {
      return this.optionsHash.dataTableSource;
   },

   _isSearchEnabled: function()
   {
      return this.optionsHash.isSearchEnabled();
   },

   _isSortEnabled: function()
   {
	   var b = this.optionsHash.isSortEnabled();
	   return b
   },
   
   _getSearchWidgetInitialization: function()
   {
      return this.optionsHash.getSearchWidgetInitialization();
   },
   
   _isAdvancedSearchEnabled: function()
   {
      return this.optionsHash.isAdvancedSearchEnabled();
   },

   _getAjaxSource: function()
   {
      return this.dataTableSource;
   },

   _executeSearch: function()
   {
	   org.r3.PageManager.googleAnalyticsSendPageView("search");
       
	   var theForm = $('#' + this.dataTableId + '_filter_searchform');
       this.clearQueryParameters();
                     
       if (theForm.valid())              
          this._applyFnFilter($('#' + this.dataTableId + '_filter_searchitem').val());
       
   },

   _onClickOpenAdvancedSearchDialog: function(aClickEvent)
   {
       var currentTarget = $(aClickEvent.currentTarget);
       var idOfAdvancedSearchLink = currentTarget.attr('id');
       var indexOfView = idOfAdvancedSearchLink.lastIndexOf('_');
       if (indexOfView >= 0)
       {
            indexOfView = parseInt(idOfAdvancedSearchLink.slice(indexOfView + 1));
       }
       else indexOfView = 0;
       this._openAdvancedSearchDialog(indexOfView);
   },

   _openAdvancedSearchDialog: function(indexOfView)
   {
       this.optionsHash.advancedSearchInfo[indexOfView].actionView.show($.r3Utils.hitch(this, this._executeAdvancedSearch));
   },

   _getAutoOpenIndexOfAdvancedSearch: function()
   {
       return this.optionsHash.advancedSearchAutoOpenIndex;
   },
   
   _executeAdvancedSearch: function(anArrayOfQueryParameters)
   {
	   org.r3.PageManager.googleAnalyticsSendPageView("advancedSearch");
	   
       this.clearQueryParameters();
       if (anArrayOfQueryParameters && anArrayOfQueryParameters.length)
       {
          for(var i = 0; i < anArrayOfQueryParameters.length; i++)
               this.addQueryParameter(anArrayOfQueryParameters[i]);
       }

       $('#' + this.dataTableId + '_filter_searchitem').val(null); // .attr('value', null);
       this._applyFnFilter('');
   },

   _applyFnFilter: function(searchTerm)
   {
       this.dataTable.fnFilter( searchTerm );
   },

   _getNumberOfColumns: function()
   {
       if (!this.optionsHash.dataTableColumns)
       {
          console.error("org.r3.db.DataTableEntityActionFormView::_getNumberOfColumns - No columns specified for dataTable");
          return 0;
       }

       var columnNames = this.optionsHash.dataTableColumns.split(",");
       return columnNames.length;
   },

   _getColumnIds: function()
   {
       if (!this._getNumberOfColumns())
       {
          console.error("org.r3.db.DataTableEntityActionFormView::_getColumnIds - No columns specified for dataTable");
          return [];
       }

       var columnNames = this.optionsHash.dataTableColumns.split(",");
       return columnNames;
   },

   _getDefaultColumnDefinitions: function()
   {
       return this.optionsHash.defaultColumnDefinitions;
   },

   getAoColumns: function()
   {
      var aoColumns = [];
      if (this._getNumberOfColumns())
      {
          for(var i = 0; i < this._getNumberOfColumns(); i++)
          {
             aoColumns.push({ "mDataProp": null });
          }
      }

      return aoColumns;
   },

   getAoColumnDefs: function()
   {
       var aoColumnDefs = [];

       if (!this._getNumberOfColumns())
       {
          console.error("org.r3.db.DataTableEntityActionFormView::getAoColumnDefs - No columns specified for dataTable");
          return aoColumnDefs;
       }

       var columnIds = this._getColumnIds();
       for(var i = 0; i < columnIds.length; i++)
       {
    	   var realColId = columnIds[i];
    	   var columnSortable = false;
    	   
    	   var ndx = realColId.indexOf(';sort');
    	   if (ndx >= 0)
    	   {
    		   columnSortable = true;       		   
    	   }
    		   
    	   ndx = realColId.indexOf(';');
    	   if (ndx >= 0)
    		   realColId = realColId.substring(0, ndx);
    	   
           var colDef = this._getDefaultColumnDefinitions()[realColId];
           if (colDef)
           {
               colDef.aTargets = [ i ];
               colDef.bSortable = columnSortable;
               
               // All'interno dei generatori la propriet� sName � stata inserita successivamente.
               // Viene generata qui nel caso non ci sia.
               if (!colDef.sName)
            	   colDef.sName = realColId;
               
               if (colDef.sTitle && $.isFunction(colDef.sTitle))
            	   colDef.sTitle = colDef.sTitle();
           }
           else
               colDef = this._getColumnDefinition4UnmatchedColumn(columnIds[i], i);
           
           aoColumnDefs.push(colDef);
       }

       return aoColumnDefs;
   },

   _setupDefaultColumnDefinitions: function()
   {
       var defaultColumnDefinitions = {};
       return defaultColumnDefinitions;
   },

   _getColumnDefinition4UnmatchedColumn: function(aColumnId, aColumnIndex)
   {
      var colDef =
      {
          "aTargets": [ aColumnIndex ],
          "sClass": "left",
          "sTitle": aColumnId,
          "fnRender": function ( oObj, sVal )
          {
               return "N.D.";
          },
          
          "render": function ( data, type, row, meta )
          {
        	  return "N.D.";
          }
      };

      return colDef;
   },

   _getLUTNetworkRequest: function(indexOfRequest)
   {
      var networkRequest = 
      {
          "id": "requiredLUT_" + indexOfRequest,
          "context": this,
          "requester": function(onSuccess, onError)
          {
              var resolvedUrl = org.r3.PageManager.getRESTUrl(this.optionsHash.requiredLUTs[indexOfRequest]);
              org.r3.PageManager.lutManager.getLUT(resolvedUrl, onSuccess);          
          }
      };
      
      return networkRequest;    
   },
   
   getAdapterFromServerData: function(serverResponse)
   {
      return serverResponse;
   },
   
   _fnServerData: function ( sUrl, aoData, fnCallback, oSettings )
   {
      var me = this;
      
      $.ajax({
        "dataType": 'json',
        "type": "GET",
        "url": sUrl,
        "data": aoData,
        "success": function(data, textStatus, jqXHR)
        {
            $(oSettings.oInstance).trigger('xhr', oSettings);

            // Adattamento di impedenza. Arricchisco i record ritornati dal metodo.
            var items = me.getAdapterFromServerData(data);
                        
            data.aaData = items.listOfItems;
            fnCallback(data);
            
            if (me.optionsHash.onServerData)
				me.optionsHash.onServerData(items, data);
        },
        "error": function (xhr, error, thrown)
        {
          if ( error == "parsererror" ) {
            alert( "DataTables warning: JSON data from server could not be parsed. "+
              "This is caused by a JSON formatting error." );
          }
        }
      });
   },
   

    open : function(openOptionsHash)
	{
    	this.clearQueryParameters();
    	
    	if (openOptionsHash && openOptionsHash.queryparams && openOptionsHash.queryparams.length)
        {
            for(var i = 0; i < openOptionsHash.queryparams.length; i++)
                 this.addQueryParameter(openOptionsHash.queryparams[i]);
        }
    	 
		this.optionsHash = $.extend(this.optionsHash, openOptionsHash);
		if (this.optionsHash.dataTableSource)
		{
			// Inserire la chiamata a RESTUrl qui significa non essere in grado di parametrizzare l'url.
			// La risoluzione deve essere spostata nel chiamante ove possibile. In questo momento
			// se vede uno slash utilizza l'URL direttamente, in caso contrario invoca la RESTUrl. 
			// in questo modo si salva il pregresso.
			if (this.optionsHash.dataTableSource.indexOf('/') >= 0)
			{
				this.dataTableSource = this.optionsHash.dataTableSource;	
			}
			else
				this.dataTableSource = org.r3.PageManager.getRESTUrl(this.optionsHash.dataTableSource);
			
		}		

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(this._getHtmlTemplateUrl()),
			dataType : "html"
		});

		if (this.optionsHash.requiredLUTs && this.optionsHash.requiredLUTs.length)
		{
			for ( var j = 0; j < this.optionsHash.requiredLUTs.length; j++)
			{
				networkRequestsQueue.push(this._getLUTNetworkRequest(j));
			}
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue, $.r3Utils.hitch(this, function(responseData)
		{
			var aoColumnDefinitions = this.getAoColumnDefs();
			this.optionsHash.columnDefinitions = aoColumnDefinitions;
			
			var templatedHtml = tmpl(responseData['view'], this.optionsHash);
			$(this.htmlContainerId).html(templatedHtml);
			
			/*
			if (this.dataTableId == 'UNEPRangeCodiciQueryActionFormView')
			{
				  console.info("DataTableEntityActionFormView: " + this.htmlContainerId, $(this.htmlContainerId));
			      console.info("DataTableEntityActionFormView: " + templatedHtml);
				  console.info("DataTableEntityActionFormView: " + this.dataTableId, $('#' + this.dataTableId));				
			} 
			*/
						
			this.dataTable = $('#' + this.dataTableId).dataTable(
			{
				"responsive" : true,
				"bPaginate" : this._isPaginate(),
				"bLengthChange" : false,
				"iDisplayLength":  this._getIDisplayLength(),
				"bFilter" : this._isSearchEnabled(),
				"sDom" : 'rtipl',
				"bSort" : this._isSortEnabled(),
				"aaSorting": [],
				"bInfo" : true,
				
				"bAutoWidth" : this._isAutoWidth(),

				// "sScrollX": this._getScrollX(),
				// "sScrollXInner": this._getScrollXInner(),

				// "iDeferLoading" : this._isDeferLoading() ? 0 : undefined,
				"bProcessing" : this._isAjaxSource(),
				"bServerSide" : this._isAjaxSource(),
				"sAjaxSource" : this._getAjaxSource(),
				"aoColumns" : this.getAoColumns(),
				"aoColumnDefs" : aoColumnDefinitions,				
				"fnServerParams" : $.r3Utils.hitch(this, this.fnGetQueryParameters),
				"fnServerData" : (this._isAjaxSource()) ? $.r3Utils.hitch(this, this._fnServerData) : null

			});

			this._initSearchForm();
			this._initAdvancedSearchForm();

			$('#' + this.dataTableId).unbind('page').bind('page', $.r3Utils.hitch(this, this.onPageChange));

			var matchExpr = '#' + this.dataTableId + " tbody tr";
			if (this.optionsHash.onSelected)
				$(document).off('click', matchExpr).on('click', matchExpr, $.r3Utils.hitch(this, this.fnSelectRow));
			//	$('#' + this.dataTableId + " tbody tr").die('click').live("click", $.r3Utils.hitch(this, this.fnSelectRow));

			if (this.optionsHash.onDblClick)
				$(document).off('dblclick', matchExpr).on('dblclick', matchExpr, $.r3Utils.hitch(this, this.fnDbClickRow));
			//	$('#' + this.dataTableId + " tbody tr").die('dblclick').live("dblclick", $.r3Utils.hitch(this, this.fnDbClickRow));

			var advancedFormAutoOpenIndex = this._getAutoOpenIndexOfAdvancedSearch();
			if (advancedFormAutoOpenIndex >= 0)
				this._openAdvancedSearchDialog(advancedFormAutoOpenIndex);

			if (this.optionsHash.isActionBarEnabled())
			{
				for ( var j = 0; j < this.optionsHash.buttons.length; j++)
				{
					$('#' + this.optionsHash.buttons[j].id).unbind().click(this.optionsHash.buttons[j].onClick);
				}
			}

			// In caso l'argomento e' nullo gli passo l'array vuoto.
			if (this.optionsHash.onInitializationComplete)
				this.optionsHash.onInitializationComplete.apply(this, (this.optionsHash.onInitializationCompleteArgs) ? this.optionsHash.onInitializationCompleteArgs: []);

			if (this.optionsHash.showTemplateOnOpen)
			    this.show();
		}

		));
	},

   addItem: function(anItem)
   {
   	  this.dataTable.fnAddData(anItem);
   },

   /* Get the rows which are currently selected */
   fnGetSelected: function( oTableLocal )
   {
       return oTableLocal.$('tr.row_selected');
   },

   fnGetSelectedDataBean: function()
   {
      var selectedItem = this.fnGetSelected(this.dataTable)[0];
      var dataReturned = this.dataTable.fnGetData(selectedItem);

      return dataReturned;
   },

   fnDeleteRow: function()
   {
       var anSelected = this.fnGetSelected( this.dataTable );
       this.dataTable.fnDeleteRow( anSelected[0] );
       //$('#delete_riepilogo_row')[0].disabled = true;
       $('#' + this.dataTableId + "_delete").prop('disabled', true);
   },

   fnDbClickRow: function(e)
   {
	   console.log("Row dbl-clicked");
	   
       var currentTarget = e.currentTarget;

       console.log("ScanSessionItemsActionFormView::fnDbClickRow:: e.CurrentTarget: ", currentTarget);
       var dataReturned = this.dataTable.fnGetData(e.currentTarget);
       console.log("DataReurned: ", dataReturned);
       // dataReturned perde coscienza della natura dell'oggetto di partenza.... instanceof it.unep.scansione.ModelAtto
       // non funziona.

       if ( $(e.currentTarget).hasClass('row_selected')) {
           $(e.currentTarget).removeClass('row_selected');
           
           if (dataReturned)
              this.optionsHash.onDblClick(dataReturned, false);
       }
       else {
           this.dataTable.$('tr.row_selected').removeClass('row_selected');
           $(e.currentTarget).addClass('row_selected');
           
           if (dataReturned)
              this.optionsHash.onDblClick(dataReturned, true);
       }
       
   },

   fnSelectRow: function(e)
   {
	   console.log("Row selected");
	   
       var selectRowEnabled = false;

       var selectedDataBean = this.dataTable.fnGetData(e.currentTarget);
       
       if ( $(e.currentTarget).hasClass('row_selected') || !selectedDataBean) {
           $(e.currentTarget).removeClass('row_selected');     
           if (this.optionsHash.onClearSelection) this.optionsHash.onClearSelection();
       }
       else {
           this.dataTable.$('tr.row_selected').removeClass('row_selected');
           $(e.currentTarget).addClass('row_selected');
           selectRowEnabled = true;
       }

       // Il click sul detail lo abilito comunque anche nel caso di clearSelection       
       var isToolSelection = false;
       if (this.optionsHash.onToolsIconSelected)
       {
    	   var target = $(e.target);
    	   isToolSelection = /* target.closest('[class*="select-detail-icon"]').length > 0 || */ target.hasClass('tools-icon') ;
    	   if (isToolSelection)
    	   {
    		   var t = null;
    		   var c = target.attr('class').split(/\s+/);
    		   if (c.length)
    		   {
    			  for(var i = 0; i < c.length; i++)
    			  {
    				  if (c[i].indexOf('toolid-') >= 0)
    				  {
    					  t = c[i];
    					  break ;
    				  }  
    			  }
    		   }
    		   
    		   this.optionsHash.onToolsIconSelected(selectedDataBean, t);
    	   }    	   
       }
              
       if (selectRowEnabled && !isToolSelection)
       {    	       	   
    	   this.optionsHash.onSelected(selectedDataBean);    	   
       }
   },

   onPageChange: function()
   {
	  if (this.optionsHash.onPageChange) this.optionsHash.onPageChange();
	  else if (this.optionsHash.onClearSelection) this.optionsHash.onClearSelection();          
   },
   
   clearTable: function()
   {
	   this.dataTable.fnClearTable();
   },
   
   getDataTable: function()
   {
	   return this.dataTable;
   },
   
   getFilterSearchItem: function()
   {
	   var item = $('#' + this.optionsHash.dataTableId + '_filter_searchitem');
	   
	   // Organizzo cos� il controllo. In caso di errore il chiamante non si rompe in quanto torno comunque un oggetto jQuery
	   if (item && item.length == 0)
		   console.error("The Item " + '#' + this.optionsHash.dataTableId + '_filter_searchitem' + " could not be found");
	   
	   return item;	   	   
   }
   
});

