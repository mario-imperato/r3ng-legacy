//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.wbs.wbsnode");

org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.wbs.wbsnode.WBSNodeDTO(aDataBean));
	 },
	 
	 getNodeId: function()
	 {
		 return this.dataBean.dtokey;
	 },
	 
	 getNodeLabel: function(addSectionNumber)
	 {
		 var s = this.dataBean.dtodescr;
		 if (addSectionNumber && this.dataBean.nodesect)
			 s = this.getNodesectFormatted() + ' ' + s;
		 
		 return s;
	 },
	 
	 getNodesectFormatted: function()
	 {
		 var ns = null;
		 if (this.dataBean.nodesect)
		 {
			 ns = this.dataBean.nodesect.replace(/\.0/g, '.');
			 ns = ns.replace(/^0*/g, '');
		 }
		 
		 return ns;
	 },
	 
	 getDuration: function(includeUnit)
	 {
		var d = '0';
	    if (this.dataBean.duration)
	    	d = this.dataBean.duration + '';
	    
	    if (includeUnit)
	    {
	    	d = d + ' ' + org.r3.db.wbs.wbsnode.message.unit_duration;
	    }
	    
	    return d;
	 },
	 
	 getStartdate: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.startdate);
	 },

	 getEnddate: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.enddate);
	 },
	 
	 getCompletiondate: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.completiondate);
	 },
	 
	 getCutOffDateMoment: function()
	 {
	     if (this.isAction())
	     {
			 var theDate = moment(this.getEnddate(), "DD/MM/YYYY");
			 return theDate; // theDate.add("days",this.dataBean.duration);	    	 
	     }
	     
	     return null;
	 },
	 
	 getCompletionDateMoment: function()
	 {
	     if (this.isAction() && this.dataBean.completiondate)
	     {
			 var completionDate = moment(this.getCompletiondate(), "DD/MM/YYYY");
			 return completionDate;	    	 
	     }
	     
	     return null;
	 },
	 
	 isRoot: function()
	 {
	     return !this.dataBean.nodeparentid;	 
	 },
	 
	 isAction: function()
	 {
	     return this.dataBean.nodetype && this.dataBean.nodetype == 'action'; 	 
	 },
	 
	 getNodedepth: function()
	 {
	     var p = this.dataBean.nodepath;
	     return Math.floor((p.length - 1) / 16);
	 },
	 
	 getNodeHSection: function()
	 {
	     var d = this.getNodedepth() + 1;
	     if (d > 4)
	    	 d = 4;
	     
	     return 4;
	 },
	 
	 visitTree: function()
	 {
		 var listOfNodes = [];
		 
		 this.visitNode(listOfNodes);
		 return listOfNodes;
	 },
	 
	 visitNode: function(aListOfNodes)
	 {
		 if (!this.isRoot())
		    aListOfNodes.push(this);
		 
		 if (this.dataBean.children)
		 {
		    for(var i = 0; i < this.dataBean.children.length; i++)
		    {		    	
		        this.dataBean.children[i].visitNode(aListOfNodes);	
		    }
		 }
	 },
	 
	 visit: function(aVisitor, rootLast)
	 {				 
		 if (!rootLast)
		 {
			 if (!aVisitor.visit(this))
				 return false;			 
		 }
		 
		 if (this.dataBean.children)
		 {
		    for(var i = 0; i < this.dataBean.children.length; i++)
		    {		    	
		    	if (!this.dataBean.children[i].visit(aVisitor))
		    		return false;
		    }
		 }		 			

		 if (rootLast)
		 {
			 if (!aVisitor.visit(this))
				 return false;			 
		 }

		 return true;
	 },
	 
	 isEditable: function()
	 {
		 var b = this.dataBean.nodetype && this.dataBean.nodetype == 'action';
		 if (b)
			b = !(this.hasBeenCompleted());
		 
		 return b;
	 },
	 
	 getAssignedToUserName: function()
	 {
		 return this.dataBean.assignedto;
	 },
	 
	 getNodetypeDescr: function()
	 {
		 return this.dataBean.nodetype;
	 },

	 getCompletioneffort: function()
	 {
		var v = (this.dataBean.completioneffort || 0);
		return v || '0';
	 },
	 
	 getEconomicvalue: function()
	 {
		var v = (this.dataBean.economicvalue || 0);
		return v || '0';
	 },
	 
	 getEconomicvalue2: function()
	 {
		var v = (this.dataBean.economicvalue2 || 0);
		return v || '0';
	 },
	 
	 getCompletioneffortEValue: function()
	 {
		var v = (this.dataBean.completioneffort || 0) * (this.dataBean.economicvalue3 || 0);
		return v || '0';
	 },
	 
	 getROI: function()
	 {
		 var effortValue = (this.dataBean.completioneffort || 0) * (this.dataBean.economicvalue3 || 0);
		 var roi = (this.dataBean.economicvalue || 0) + effortValue;
		 roi = (this.dataBean.economicvalue2 || 0) - roi;
		 return roi;
	 },
	 
	 getCompletion: function(aCompletionValue)
     {
		  var c = ((aCompletionValue) ? aCompletionValue : this.dataBean.completion);
		  
		  if (this.dataBean.completiontype == 'percentage')
				 c = c + '%';
		  
		  return c;
     },
     
     getCompletionAsPercentage: function()
     {
    	 if (!(this.dataBean.completiontype && this.dataBean.completionstatus && this.dataBean.completion))
    		 return '0%';
     	 
    	 if (this.dataBean.completionstatus == 'empty')
    		 return '0%';
    	     	     	 
         if (this.dataBean.completiontype == 'percentage')
    	 {
    		 return this.dataBean.completion + '%';
    	 }
         else
         {
        	 var f = 100.0 * (this.dataBean.completion - this.dataBean.completionfrom) / ( this.dataBean.completionto - this.dataBean.completionfrom );
        	 return  Math.round(f) + '%';	 
         }
         
    	 return 'Err';     	 
     },
     
	 getCompletionDescr: function(aCompletionValue)
	 {
		 var c = '';
		 
		 if (this.dataBean.completiondescr) 
			 c = this.dataBean.completiondescr + ' ' + this.getCompletion(aCompletionValue);
		 		 		 		 
		 return c;
	 },
	 
	 getCompletionMinValue: function()
	 {
		 return this.dataBean.completion || (this.dataBean.completiontype == 'percentage' ? 0: this.dataBean.completionfrom);
	 },

	 getCompletionMaxValue: function()
	 {
	     return (this.dataBean.completiontype == 'percentage' ? 100: this.dataBean.completionto);	 
	 },

	 getCompletionDate: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.completiondate);
	 },
	 
	 hasBeenCompleted: function()
	 {		 
		 return this.dataBean.completionstatus && this.dataBean.completionstatus == 'completed';
//	     if (!this.dataBean.completion)
//	    	 return false;
//
//	     var rc = false;
//	     
//	     switch(this.dataBean.completiontype)
//	     {
//	     case 'percentage':
//	    	 rc = this.dataBean.completion == 100;
//	    	 break;
//	    	 
//	     case 'int_pos_range':
//	    	 rc = this.dataBean.completion == this.dataBean.completionto;	    	 
//	    	 break;	    	 
//	     }
//	     
//	     return rc;
	 },
	 
	 isCompletionLate: function()
	 {
		 var c = this.getCompletionDateMoment();
		 if (c && c.startOf('day').isAfter(this.getCutOffDateMoment()))
			 return true;
		 
		 return false;
	 },
	 
	 hasBeenStarted: function()
	 {
		 return this.dataBean.completionstatus && this.dataBean.completionstatus == 'partial';
		 
//	     if (!this.dataBean.completion)
//	    	 return false;
//
//	     var rc = false;
//	     
//	     switch(this.dataBean.completiontype)
//	     {
//	     case 'percentage':
//	    	 rc = this.dataBean.completion > 0;
//	    	 break;
//	    	 
//	     case 'int_pos_range':
//	    	 rc = this.dataBean.completion > this.dataBean.completionfrom;	    	 
//	    	 break;	    	 
//	     }
//	     
//	     return rc;
	 },
	 
	 hasExpired: function()
	 {
		 var c = this.getCutOffDateMoment();
//		 var l = c.endOf('day');
//		 l = moment();
		 if (c && c.endOf('day').isBefore(moment()))
			 return true;
		 
		 return false;
	 },
	 
	 getCustomCSSClassName: function()
	 {
		 var c = 'wbsnode';
		 if (this.dataBean.nodetype)
			 c += ' wbs_' + this.dataBean.nodetype;
		 
		 if (this.dataBean.stereotype)
			 c += ' wbs_' + this.dataBean.stereotype;		
		 
		 return c;
	 },
	 
	 getGanttSource: function()
	 {
         var s = { 
            name: this.getNodeLabel(true),
 			desc: '',
 			values: []
         };
         
		 if (this.isAction())
		 {
			 var startDate = moment(this.getStartdate(), "DD/MM/YYYY");
			 var endDate = moment(this.getEnddate(), "DD/MM/YYYY"); // startDate.clone().add("days",this.dataBean.duration);
			 
			 var barCSSClass = 'ganttGrey';
			 if (this.hasBeenCompleted())
				 barCSSClass = 'ganttGreen';
			 else if (this.hasExpired())
				 barCSSClass = 'ganttRed';
			 else if (this.hasBeenStarted())
				 barCSSClass = 'ganttOrange';

			 s.values.push({
				     from: "/Date(" + startDate.valueOf() + ")/",
					   to: "/Date(" + endDate.valueOf() + ")/",					
		      customClass: barCSSClass
			 });						 			 
		 }
		    	
		 return s;
	 },
	 
	 isAssignee: function()
	 {
		 var actorUserProfile = org.r3.PageManager.actorUserProfileInfo;
		 return (this.dataBean.assignedto && actorUserProfile && actorUserProfile.isActor(this.dataBean.assignedto));
	 },
	 
	 getTemperatureClassForNode: function()
	 {
		 if (this.isAction())
	     {
			 if (this.hasBeenCompleted())
			 {
				 if (this.isCompletionLate())
 				 {
					 return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_lateCompleted;
				 }
				 else
				 {
					 return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeCompleted;
				 }
			 }
			 else
			 {
				 if (this.hasExpired())
                 {
					 return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_lateIncomplete;
                 }
				 else
				 {
					 if (this.hasBeenStarted())
			         {
						 return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeStarted;
			         }
					 else
					 {
						 return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeNotStarted;
					 }
				 }                    
			 }
	     }
			 
	     return org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_node;
	 }
	  
});

org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_node = 'wbsnode_temperature_node';
org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeCompleted = 'wbsnode_temperature_onTimeCompleted';
org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeStarted = "wbsnode_temperature_onTimeStarted";
org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_onTimeNotStarted = "wbsnode_temperature_onTimeNotStarted";
org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_lateCompleted = "wbsnode_temperature_lateCompleted";
org.r3.db.wbs.wbsnode.WBSNodeDTOTemperatureColor_lateIncomplete = "wbsnode_temperature_lateIncomplete";