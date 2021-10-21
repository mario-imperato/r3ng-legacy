//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.cms.card");

org.r3.db.cms.card.CardQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.cms.card.CardDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   var global_multiselector = this.dataTableId + "_all_cardid";
 	   var selectorPrefix = this.dataTableId;
 	   
   	defaultColumnDefinitions['singleselector'] = 
    {  
    	  "aTargets": [ -1 ], 
    	  "sClass": "text-center", 
    	  "sTitle": "",
	      "render": function ( data, type, row, meta ) 
	      {
	       	    var item = data; 
	       	    
	       	    var itemChecked = "";
	//       	    if ($('#' + global_multiselector).prop('checked'))
	//       	    {
	//       	    	itemChecked = ' checked ';
	//       	    }
	       	    var s = "<input type='radio' name='cardid' id='" + selectorPrefix + '_' + item.dataBean.cardid + "' value='" + item.dataBean.cardid + "' title='" + item.dataBean.systemtitle + "' " + itemChecked + " />"; 
	             return s;
	      }
	    };
	   
//	   	defaultColumnDefinitions['selectdetailicon'] = 
//	    {  
//	      "aTargets": [ -1 ], 
//	      "sClass": "text-center", 
//	      "sTitle": "",
//	      "render": $.r3Utils.hitch(this, function ( data, type, row, meta ) 
//	      {
//	       	    var item = data; 
//	       	    
//	             var s = "<span class='fa-stack fa-lg pull-left select-detail-icon' id='" + selectorPrefix + '_select-detail-icon_' + item.dataBean.cardid + "'><i class='fa fa-file-o fa-stack-1x select-detail-icon'></i></span>";
//	       	    return s;
//	      })
//	    };
	   
	    defaultColumnDefinitions['queryformview-tools'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "Azioni",
       	"render": function ( data, type, row, meta ) 
        {
        	    var item = data;  
          	    var s = '<div class="queryformview-tools"><i class="fa fa-file-o tools-icon toolid-file" style="margin: 2px"></i></div>';
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

   	   defaultColumnDefinitions['valid'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data;  
                return item.getValidityAsSemaphore();
          }
       };
   	   
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['cardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.cardid,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             var s =  item.getValidityAsSemaphore() + item.dataBean.cardid;
             return s;
          }       
       };
        defaultColumnDefinitions['categoryid'] = 
        {
           "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.cms.card.message.categoryid,
           "render": function ( data, type, row, meta )
           {
              var item = data;  
              return item.getCategorydescr() || '';
           }       
        };
        defaultColumnDefinitions['systemtitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.systemtitle,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.systemtitle || '';
          }       
       };
        defaultColumnDefinitions['pagelinktype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.pagelinktype,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.pagelinktype || '';
          }       
       };
        defaultColumnDefinitions['pagelink'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.pagelink,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.pagelink || '';
          }       
       };
        defaultColumnDefinitions['pageid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.pageid,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.pageid || '';
          }       
       };
        defaultColumnDefinitions['refdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.refdate,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.refdate || '';
          }       
       };
        defaultColumnDefinitions['options'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.options,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.options || '';
          }       
       };
        defaultColumnDefinitions['validityrule'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.validityrule,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.validityrule || '';
          }       
       };
        defaultColumnDefinitions['validfrom'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.validfrom,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.validfrom || '';
          }       
       };
        defaultColumnDefinitions['validto'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.validto,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.validto || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.recstatus,
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
          "sTitle": org.r3.db.cms.card.message.rectimestamp,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.rectimestamp || '';
          }       
       };
        defaultColumnDefinitions['categoryid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.cms.card.message.categoryid,
          "render": function ( data, type, row, meta )
          {
             var item = data;  
             return item.dataBean.categoryid || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.cms.card.CardDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

