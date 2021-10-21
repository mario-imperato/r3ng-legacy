$.r3Utils.namespace("org.r3");

org.r3.BreadCrumbManager = Class.extend(
{
   
   init: function()
   {   
	   this._browserHistory_initialize();
   },

	_browserHistory_synchronization : false,			
	
	_browserHistory_initialize : function() 
	{
		if (!org.r3.Constants.browserHistory_isEnabled())
			return;

		_browserHistory_synchronization = false;
		
		var numberOfEntries = window.history.length;
		// console.info("History Length is: " + numberOfEntries);

		var currentState = window.history.state;
		// console.info("CurrentState is: ", currentState);
		if (currentState) {
			// console.info("Resetting State: ", currentState);
			history.replaceState(null, 'Resetted State', null);
		}

		window.onpopstate = $.r3Utils.hitch(this, this._browserHistory_onPopState);
	}, 
    
	_browserHistory_onPopState: function(e)
	{
		// console.info("On State Changed", e);
//		if (e.state)
//			console.info("Popped State location: " + document.location + ", state: " + JSON.stringify(e.state));
//		else
//			console.info("Popped State location: "
//					+ document.location);

		if (this._browserHistory_synchronization)
		{
			// console.info("History synchronization On Going..... skipping ");
			this._browserHistory_synchronization = false;
			return ;
		}
		
		var currentState = e.state; // window.history.state;
		if (currentState
				&& currentState.breadCrumbIndex >= 0) {
			// console.info("Actual Index: ", currentState.breadCrumbIndex);

			if (currentState.breadCrumbIndex >= this.breadCrumbData.length) {
				var numberOfSteps = (currentState.breadCrumbIndex - this.breadCrumbData.length) + 1;
				// console.info("Sort Of Forward - Backing ", numberOfSteps);
				history.go(-numberOfSteps);
			} else 
				if (currentState.breadCrumbIndex < (this.breadCrumbData.length - 1) )
				{
				      this.activateBreadCrumb(currentState.breadCrumbIndex, true);	
				}
				else
				{
					// console.info("Replacing the title on the bar.... In case...");
					history.replaceState({ "breadCrumbIndex": currentState.breadCrumbIndex }, 'Title BreadCrumb_' + (currentState.breadCrumbIndex), '#' + this.breadCrumbData[currentState.breadCrumbIndex].title /* "" */);									
				}
					
				
			
		}		
	},

	_browserHistory_back: function(numberOfEntries)
    {
		if (!org.r3.Constants.browserHistory_isEnabled() || !numberOfEntries)
			return;
		
		this._browserHistory_synchronization = true;
		history.go(-numberOfEntries);
    },
    
	_browserHistory_onPushState: function(aBreadCrumb)
	{
		if (!org.r3.Constants.browserHistory_isEnabled())
			return;
		
		// window.location.href = '#BreadCrumb_' + this.breadCrumbData.length;
		if (!aBreadCrumb.noHistory)
		{
			if (history.state)
			{
				// console.info("OnPushState:: " + history.state.breadCrumbIndex + " on " + (this.breadCrumbData.length - 1));
				if (history.state.breadCrumbIndex < (this.breadCrumbData.length - 1))		
				{
					history.pushState({ "breadCrumbIndex": this.breadCrumbData.length - 1 }, 'Title BreadCrumb_' + (this.breadCrumbData.length - 1), '#' + aBreadCrumb.title /* '#BreadCrumb_' + (this.breadCrumbData.length - 1) */);
					// console.info("I'm pushing state: " + (this.breadCrumbData.length - 1));								
				}
				else if (history.state.breadCrumbIndex == (this.breadCrumbData.length - 1))
				{
					history.replaceState({ "breadCrumbIndex": this.breadCrumbData.length - 1 }, 'Title BreadCrumb_' + (this.breadCrumbData.length - 1), '#' + aBreadCrumb.title /* "" */);				
					// console.info("Replacing State: " + (this.breadCrumbData.length - 1));					
				}
				else 
				{
				    // In questo caso potrei essere una situazione di backtrack applicativa con un salto all'indietro
					// di un certo numero di passi e la sostituzione di uno stato: closeBreadCrumbs + pushState.
					// Ora questa cosa funzione se la onPopState fosse sincrona con l'operazione history.back:
					// back(1) - OnPopState (non fa nulla ma aggiorna la history) - Replace. In questo caso
					// la push avverrebbe correttamente dopo che la history e' tornata indietro. Non sembra questo il caso con
					// Chrome versione 32... Quindi provo questo hack, evito il pushState in modo da risequenziare le attività in
					// onPopState.  back(1) - No Push - OnPopState (a questo punto con l'indice corretto) - Replace
					// console.info("Re-enable synchronization? " + this._browserHistory_synchronization);
					this._browserHistory_synchronization = false;
				}
			}
			else
			{
				// console.info("OnPushState:: No History State found");
				history.replaceState({ "breadCrumbIndex": this.breadCrumbData.length - 1 }, 'Title BreadCrumb_' + (this.breadCrumbData.length - 1), '#' + aBreadCrumb.title /* "" */);				
				// console.info("Replacing State: " + (this.breadCrumbData.length - 1));					
			}
		}
	},

	breadCrumbData : [],

	_isBreadCrumbReadOnly : function()
	{
		if (this.breadCrumbData.length == 0)
			return false;

		var bc = this.peekBreadCrumb();
		if (typeof bc.readOnly === "undefined")
			return false;

		return bc.readOnly;
	},
	
	// AdminLTE Rendering
	_adminlte_renderBreadCrumb : function()
	{
		var ol = $('.content-wrapper .content-header .breadcrumb');
		ol.empty();
		
		if (!this.breadCrumbData.length)
		{
			ol.parent().hide();
		}
		else 
			ol.parent().show();
					
		for ( var i = 0; i < (this.breadCrumbData.length - 1); i++)
		{
			var child = null;
			if (this.breadCrumbData[i].actionForm && !this._isBreadCrumbReadOnly())
				ol.append(this._adminlte_renderHrefBreadCrumbData(this.breadCrumbData[i], i));
			else
				ol.append(this._adminlte_renderReadOnlyBreadCrumbData(this.breadCrumbData[i], i));
		}

		var i = (this.breadCrumbData.length - 1);
		ol.append(this._adminlte_renderReadOnlyBreadCrumbData(this.breadCrumbData[i], i));

		ol.show();
	},

	_adminlte_renderHrefBreadCrumbData : function(aBreadCrumb, aBreadCrumbIndex)
	{
		return "<li id='breadcrumb_" + aBreadCrumbIndex
				+ "'><a href='javascript:void(0)' onClick='org.r3.PageManager.activateBreadCrumb(" + aBreadCrumbIndex + ")' >"
				+ aBreadCrumb.title + "</a></li>";
	},

	_adminlte_renderReadOnlyBreadCrumbData : function(aBreadCrumb, aBreadCrumbIndex)
	{
		return "<li id=\"breadcrumb_" + aBreadCrumbIndex + "\" class=\"active\" >" + aBreadCrumb.title + "</li>";
	},
	
	renderBreadCrumb : function()
	{
		if (console_layout)
			return this._adminlte_renderBreadCrumb();
		
		var outHtml = "";
		for ( var i = 0; i < (this.breadCrumbData.length - 1); i++)
		{
			if (i > 0)
			{
				outHtml += " &gt;&gt; ";
			}

			if (this.breadCrumbData[i].actionForm && !this._isBreadCrumbReadOnly())
				outHtml += this._renderHrefBreadCrumbData(this.breadCrumbData[i], i);
			else
				outHtml += this._renderReadOnlyBreadCrumbData(this.breadCrumbData[i], i);
		}

		if (this.breadCrumbData.length > 1)
		{
			outHtml += " &gt;&gt; ";
		}

		var i = (this.breadCrumbData.length - 1);
		outHtml += this._renderReadOnlyBreadCrumbData(this.breadCrumbData[i], i);

		$('#breadcrumbs').html(outHtml);
		$('#breadcrumb_bar').show();
	},

	_renderHrefBreadCrumbData : function(aBreadCrumb, aBreadCrumbIndex)
	{
		return "<span id=\"breadcrumb_" + aBreadCrumbIndex
				+ "\" class=\"r3_breadcrumb\" onClick=\"org.r3.PageManager.activateBreadCrumb(" + aBreadCrumbIndex + ")\" >"
				+ aBreadCrumb.title + "</span>";
	},

	_renderReadOnlyBreadCrumbData : function(aBreadCrumb, aBreadCrumbIndex)
	{
		return "<span id=\"breadcrumb_" + aBreadCrumbIndex + "\" class=\"r3_breadcrumb_current\" >" + aBreadCrumb.title + "</span>";
	},

	_countBreadCrumbsByType: function(matchType)
	{
		var rc = -1;
		
		if (this.breadCrumbData && this.breadCrumbData.length)
		{
			rc = 0;
			for ( var i = 0; i < this.breadCrumbData.length; i++)
			{
				var b = this.breadCrumbData[i];
				if (b && b.type && b.type == matchType)
					rc++;
			}
		}
						
		return rc;
	},
	
	back : function()
	{
		this.activateBreadCrumb(this.breadCrumbData.length - 2);
		
//		this.closeBreadCrumbs(this.breadCrumbData.length - 1);
//		this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.show();
//		if (this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.refresh)
//			this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.refresh();
//		else
//			console.error("No Refresh for: ", this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm);

		// OLDER
//		if ((this.breadCrumbData.length - 1) > 0)
//		{
//			this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.close(); // .pop().actionForm.hide();
//		}
//
//		this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.show();
//		if (this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.refresh)
//			this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm.refresh();
//		else
//			console.error("No Refresh for: ", this.breadCrumbData[(this.breadCrumbData.length - 1)].actionForm);
//
//		this.renderBreadCrumb();
	},
	
	pushBreadCrumb : function(aBreadCrumb)
	{
		this.breadCrumbData.push(aBreadCrumb);
		this.renderBreadCrumb();
		// console.log("BreadCrumb is: ---> ", this.breadCrumbData);
		this._browserHistory_onPushState(aBreadCrumb);		
	},



	popBreadCrumb : function()
	{
		this.breadCrumbData.pop();
		this.renderBreadCrumb();
		// console.log("BreadCrumb is: ---> ", this.breadCrumbData);
	},

	peekBreadCrumb : function()
	{
		return this.breadCrumbData[this.breadCrumbData.length - 1];
	},

	// Metodo al momento mai usato.
	setBreadCrumb : function(aBreadCrumb)
	{
		this.breadCrumbData = [ aBreadCrumb ];
		this.renderBreadCrumb();
		// console.log("BreadCrumb is: ---> ", this.breadCrumbData);
		this._browserHistory_onPushState(aBreadCrumb);
	},

	
	closeAllBreadCrumbs: function()
	{
		var startingIndex = this._countBreadCrumbsByType('breadcrumb_system');
		var numberOfEntries = this.breadCrumbData.length - 1 - (startingIndex) + 1;
		if (numberOfEntries > 1)
		    this._browserHistory_back(numberOfEntries - 1);

		this.closeBreadCrumbs(startingIndex);		
	},
	
	closeBreadCrumbs : function(startingBreadCrumbIndex, onBrowserHistory)
	{
		console.info("closeBreadCrumbs: " + startingBreadCrumbIndex);
		


		if (startingBreadCrumbIndex >= this.breadCrumbData.length)
		{
			console.error("Could not close breadcrumb at index: " + startingBreadCrumbIndex);
			return ;	
		}
				
		for ( var i = this.breadCrumbData.length - 1; i >= startingBreadCrumbIndex; i--)
		{
			if (this.breadCrumbData[i].actionForm)
				this.breadCrumbData[i].actionForm.close(); // .pop().actionForm.hide();
			
			this.breadCrumbData.pop();
		}		

		this.renderBreadCrumb();		
	},

	activateFirstBreadCrumb: function()
	{
		var startingIndex = this._countBreadCrumbsByType('breadcrumb_system');
		this.activateBreadCrumb(startingIndex);
	},
	
	activateBreadCrumb : function(breadCrumbIndex, onBrowserHistory)
	{
		console.info("activateBreadCrumb: " + breadCrumbIndex);
		
		if ($('#canvas_report').is(":visible"))
		{
			this.closeFullScreenLayout();
		}
		
		// Nel caso e' top.... che faccio.. niente?
		if (breadCrumbIndex >= this.breadCrumbData.length)
		{
			console.error("Could not activate breadcrumb at index: " + breadCrumbIndex);
			return ;	
		}
	
		var numberOfEntries = (this.breadCrumbData.length - 1) - (breadCrumbIndex + 1) + 1;
		this.closeBreadCrumbs(breadCrumbIndex + 1, onBrowserHistory);
		
		// Mario 20150316 - La condizione era: if (!onBrowserHistory) Ho tolto il Not... sembrava un nonsense e generava effetti strani. 
		if (onBrowserHistory)
		   this._browserHistory_back(numberOfEntries);
		
//		for ( var i = this.breadCrumbData.length - 1; i > breadCrumbIndex; i--)
//		{
//			if (this.breadCrumbData[i].actionForm)
//				this.breadCrumbData[i].actionForm.close(); // .pop().actionForm.hide();
//		}

		if (this.breadCrumbData[breadCrumbIndex].actionForm)
		{
			this.breadCrumbData[breadCrumbIndex].actionForm.show();
			if (this.breadCrumbData[breadCrumbIndex].actionForm.refresh)
				this.breadCrumbData[breadCrumbIndex].actionForm.refresh();
			else
				console.error("No Refresh for: ", this.breadCrumbData[breadCrumbIndex].actionForm);
		}

		this.renderBreadCrumb();
	}
	 	
});

