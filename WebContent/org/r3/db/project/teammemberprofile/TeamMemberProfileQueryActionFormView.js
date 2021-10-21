//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.teammemberprofile");

org.r3.db.project.teammemberprofile.TeamMemberProfileQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter(aRowDataBean); });   
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
          "fnRender": function ( oObj, sVal ) 
          {
          	    var item = oObj.aData; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['profileid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.profileid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.profileid || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['teamid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.teamid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.teamid || '';
          }       
       };
        
        defaultColumnDefinitions['profiledescr'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": org.r3.db.project.teammemberprofile.message.profiledescr,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.profiledescr || '';
           }       
        };
        
        defaultColumnDefinitions['skillprofile'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.skillprofile,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getSkillprofile() || '';
          }       
       };
        defaultColumnDefinitions['skillambit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.skillambit,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getSkillambit() || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.teammemberprofile.message.recstatus,
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
          "sTitle": org.r3.db.project.teammemberprofile.message.rectimestamp,
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
   	  var adaptedItem = new org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

