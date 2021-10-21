//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.wbs.wbs");

org.r3.db.wbs.wbs.WBSDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	  this._super(new org.r3.db.wbs.wbs.WBSDTO(aDataBean));	 	   
	 	  // this.wbsActors = null;
	 },
	 
	 getListOfWbsNodes: function()
	 {
		 var listOfNodes = [];
		 
		 if (this.dataBean.rootnode)
		 {
			 listOfNodes = this.dataBean.rootnode.visitTree();	 
		 }
		 
		 return listOfNodes;
	 },
	 
	 getROI: function()
	 {
		 var ROI = 0.0;		 
		 var listOfNodes = [];
		 
		 if (this.dataBean.rootnode)
		 {
			 listOfNodes = this.dataBean.rootnode.visitTree();	 
			 if (listOfNodes && listOfNodes.length > 0)
			 {
			    for(var i = 0; i < listOfNodes.length; i++)	 
			    {
			    	ROI += listOfNodes[i].getROI();	
			    }
			 }
		 }
		 
		 return ROI;
	 },
	 
	 getOptionsAsArray: function()
	 {
		 if (this.dataBean.options)
			 return this.dataBean.options.split(',');
		 
		 return null;
	 },
 
	 visit: function(aVisitor, rootLast)
	 {
		 if (this.dataBean.rootnode)
		 {
			 this.dataBean.rootnode.visit(aVisitor, rootLast);	 
		 }
		 
	 },
	 
//	 setWbsActors: function(aListOfWBSActorDTOAdapter)
//	 {
//		 this.wbsActors = aListOfWBSActorDTOAdapter;
//	 },
	 
	 getActorByRole: function(aRole, aWbsId)
	 {
		 var foundActor = 0;
		 
		 if (this.dataBean.actors)
		 {
			for(var j = 0; j < this.dataBean.actors.length; j++)
		    {
				var aWBSActorDTOAdapter = this.dataBean.actors[j];
				
				if (aRole == aWBSActorDTOAdapter.dataBean.actorrole)
		    	{
		    		if (!aWBSActorDTOAdapter.dataBean.wbsid || aWBSActorDTOAdapter.dataBean.wbsid == aWbsId)
		    		{
		    		  foundActor = aWBSActorDTOAdapter;
		    	      break;
		    	    }
		    	}		    					 
			}
			
//		    var wbsActorFinder = 
//		    {		    				       
//		       processItem: function(aWBSActorDTOAdapter)	
//		       {
//		    	   if (aRole == aWBSActorDTOAdapter.dataBean.actorrole)
//		    	   {
//		    		   if (!aWBSActorDTOAdapter.dataBean.wbsid || aWBSActorDTOAdapter.dataBean.wbsid == aWbsId)
//		    		   {
//		    			   foundActor = aWBSActorDTOAdapter;
//		    			   return false;
//		    		   }
//		    	   }
//		    	   
//		    	   return true;
//		       }		    		
//		    };
//		    
//		    this.wbsActors.visit(wbsActorFinder);
		 }
		 
	     return foundActor;	 
	 },

//	 isActorInRole: function(anActorId, aRole_or_arrayOfROles, aWbsId)
//	 {
//		 var foundActor = 0;
//		 
//		 if (this.dataBean.actors)
//		 {
//			 for(var j = 0; j < this.dataBean.actors.length; j++)
//		    {
//				var aWBSActorDTOAdapter = this.dataBean.actors[j];
//				
//				if (aRole == aWBSActorDTOAdapter.dataBean.actorrole)
//		    	{
//		    		if (!aWBSActorDTOAdapter.dataBean.wbsid || aWBSActorDTOAdapter.dataBean.wbsid == aWbsId)
//		    		{
//		    		  foundActor = aWBSActorDTOAdapter;
//		    	      break;
//		    	    }
//		    	}		    					 
//			}
//			 
//		    var wbsActorFinder = 
//		    {		    				       
//		       processItem: function(aWBSActorDTOAdapter)	
//		       {		    	   
//		    	   if (aWBSActorDTOAdapter.hasRole(aWBSActorDTOAdapter, aWBSActorDTOAdapter.dataBean.wbsid))
//		    	   {		    		
//		    		   if (aWBSActorDTOAdapter.dataBean.actorid == anActorId)
//		    		   {
//		    			   foundActor = aWBSActorDTOAdapter;
//		    			   return false;
//		    		   }
//		    	   }
//		    	   
//		    	   return true;
//		       }		    		
//		    };
//		    
//		    this.wbsActors.visit(wbsActorFinder);
//		 }
//		 
//	     return foundActor;	 
//	 },

	 getManager: function()
	 {
	     return this.getActorByRole('manager', this.dataBean.wbsid);	 
	 },
	 
	 getManagerId: function()
	 {
		 var o = this.getManager();
		 return o && o.dataBean.actorid;
	 },
	 
	 getCoach: function()
	 {
		 return this.getActorByRole('coach', this.dataBean.wbsid);
	 },

	 getCoachId: function()
	 {
		 var o = this.getCoach();
		 return o && o.dataBean.actorid;
	 },

	 getSponsor: function()
	 {
		 return this.getActorByRole('sponsor');	 
	 },
	 
	 getSponsorId: function()
	 {
		 var o = this.getSponsor();
		 return o && o.dataBean.actorid;
	 },
	 
	 isExecutiveOrCoach: function()
	 {
		 var actorUserProfile = org.r3.PageManager.actorUserProfileInfo;
		 
		 return actorUserProfile && (actorUserProfile.isActor(this.getManagerId()) || actorUserProfile.isActor(this.getSponsorId()) || actorUserProfile.isActor(this.getCoachId()));
	 },
	 
     collectWbsStatInfo: function()
	 {
			var v = {	
					
				numberOfActions : 0,
				numberOfCompleted : 0,
				numberOfLateCompleted : 0,
				numberOfNotStarted: 0,
				numberOfStarted   : 0,
				numberOfLateIncomplete: 0,
				
				visit: function(aWbsNodeDTOAdapter)
				{
					console.log('Visiting WBSNode: ' + aWbsNodeDTOAdapter.dataBean.wbsnodeid);
					
					if (aWbsNodeDTOAdapter.isAction())
					{
						this.numberOfActions ++ ;
						
						if (aWbsNodeDTOAdapter.hasBeenCompleted())
						{
							this.numberOfCompleted ++;	
							if (aWbsNodeDTOAdapter.isCompletionLate())
							{
								this.numberOfLateCompleted ++;	
							}
						}
						else 
						{
	                        if (aWbsNodeDTOAdapter.hasExpired())
	                        {
	                        	this.numberOfLateIncomplete ++ ;
	                        }
							
	                        if (aWbsNodeDTOAdapter.hasBeenStarted())
	                            this.numberOfStarted ++ ;
						    else 
							{
								this.numberOfNotStarted ++;
							}
						}
					}
					
					return true;
				}
			};
				
			this.visit(v);
			
			return v;
		}



});
