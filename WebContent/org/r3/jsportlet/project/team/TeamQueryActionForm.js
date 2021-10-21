$.r3Utils.namespace("org.r3.jsportlet.project.team");

org.r3.jsportlet.project.team.TeamQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.project.team.TeamQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'TeamQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.team.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_Teams',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "teamstatus,teamid;sort,teamdescr,periodindex",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.teamDetail),
					onClearSelection : null,					        					
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_team_action_newteam',
						label : org.r3.jsportlet.project.team.message.console_team_action_newteam,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.hide(); this.pageManager.openNewTeamPanel(); })
					} ]

				}
		);
		
	},
   
   open: function()
   {   	  	   
	   this.listView.open();		
   },
     
   close: function()
   {   	  	   
	   // M20140201 - org.r3.PageManager.popBreadCrumb();
	   this.listView.close();		
   },
   
   hide: function()
   {   	  
   	  this.listView.hide();
   },

   show: function()
   {   	  
   	  this.listView.show();
   },

   refresh: function()
   {   	  
   	  this.listView.refresh();
   },
   
   teamDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		this.pageManager.openTeamDetailPanel(aDTOAdapter, {});
   }
      
            	       
});



