//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.entrylist");

org.r3.db.sailevent.entrylist.SailEntryListQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.entrylist.SailEntryListDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
       	  "render": function ( data, type, row, meta )
          {
           var item = data;  
                return item.indexOfItem;
          }
       };

       defaultColumnDefinitions['boaticon'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "",
          "render": function ( data, type, row, meta )
          {
           var item = data;  
             var stb = "";
             
             var showIcons = $('#entrylist_action_showboaticons').prop('checked');
             if (showIcons)
             {            	              
            	 var iconTitle = item.getEscapedYachtTitle();
             if (item.hasBoatImage()) {
                stb = "<div class='boatIcon'><a href='" + item.getBoatImageUrl() + "' rel='lightbox-entrylist' title='" + iconTitle + "'><img src='" + item.getBoatIconUrl() + "' border='0' style='max-width: 100px; margin-top: " + item.getBoatIconMarginTop() + "px;' /></a></div>";
             }
             else 
            	stb = "<div class='boatIcon'><img src='" + item.getBoatIconUrl() + "' border='0' style='margin-top: " + item.getBoatIconMarginTop() + "px;' /></div>";
             }
             
             return stb;
          }       
       };

       defaultColumnDefinitions['ownername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Armatore",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerlastname || '';
          }       
       };

       defaultColumnDefinitions['racegroup_raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Raggruppamento",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return (item.getRacegroup() || '') + (item.getRacegroup() != null && item.getRaceclass() != null ? ' - ' : '') + (item.getRaceclass() || '');
          }       
       };

       
       
        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.eventid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.applicationid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.userid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['verificationstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.verificationstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.verificationstatus || '';
          }       
       };
        defaultColumnDefinitions['plate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.plate,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.plate || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.sailnumber,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.yachtname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['yachtclub'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.yachtclub,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtclub || '';
          }       
       };
        defaultColumnDefinitions['yachttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.yachttype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachttype || '';
          }       
       };
        defaultColumnDefinitions['yachtbsf'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.yachtbsf,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtbsf || '';
          }       
       };
        defaultColumnDefinitions['yachtgph'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.yachtgph,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtgph || '';
          }       
       };
        defaultColumnDefinitions['racegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.racegroup,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racegroup || '';
          }       
       };
        defaultColumnDefinitions['raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.raceclass,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.raceclass || '';
          }       
       };
        defaultColumnDefinitions['apptype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.apptype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.apptype || '';
          }       
       };
        defaultColumnDefinitions['boatimageurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boatimageurl,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boatimageurl || '';
          }       
       };
        defaultColumnDefinitions['boatimageheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boatimageheight,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boatimageheight || '';
          }       
       };
        defaultColumnDefinitions['boatimagewidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boatimagewidth,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boatimagewidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boaticonurl,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boaticonurl || '';
          }       
       };
        defaultColumnDefinitions['boaticonwidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boaticonwidth,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boaticonwidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.boaticonheight,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.boaticonheight || '';
          }       
       };
        defaultColumnDefinitions['ownerfirstname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.ownerfirstname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerfirstname || '';
          }       
       };
        defaultColumnDefinitions['ownerlastname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.ownerlastname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerlastname || '';
          }       
       };
        defaultColumnDefinitions['owneremail'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.owneremail,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.owneremail || '';
          }       
       };
        defaultColumnDefinitions['ownercellphone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.sailevent.entrylist.message.ownercellphone,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownercellphone || '';
          }       
       };
     	var columnId = 'accepted';
    	
        	defaultColumnDefinitions[columnId] =
        	{
        	  	"aTargets": [ -1 ],
           		"sClass": "text-center sevapp-accepted-label",
           		"sTitle": org.r3.db.sailevent.entrylist.message.accepted,
           		"render": function ( data, type, row, meta )
           		{
              		var item = data;
              		
              		if (item.dataBean.accepted && item.dataBean.accepted == 'btrue')
              			return "<div style='background-color: #12633e; color: white; padding: 2px'>CONFERMATA</div>";
              		
              		return "<div style='background-color: #bb0606; color: white; padding: 2px'>DA&nbsp;CONFERMARE</div>";
           		}
        	};
       
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.entrylist.SailEntryListDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

