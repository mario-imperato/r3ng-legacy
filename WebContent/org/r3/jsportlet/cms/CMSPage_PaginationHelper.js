$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_PaginationHelper = Class.extend(
{

	init : function(containerJQueryPath)
	{
		this.containerJQueryPath = containerJQueryPath;
		this.displayStart = 0;
		this.displayLength = 0;
		this.totalNumberOfRecords = 0;	
		this.pageSize = 0;
		
		this.currentCSSClassActionPrevious = 'disabled';
		this.currentCSSClassActionNext     = 'disabled';
		
		this.onPreviousActionCallBack = null;
		this.onNextActionCallBack = null;
	},
	
	_initializeFields : function(displayStart, displayLength, totalNumberOfRecords, pageSize)
	{
		this.displayStart = displayStart;
		this.displayLength = displayLength;
		this.totalNumberOfRecords = totalNumberOfRecords;
		this.pageSize = pageSize;
	},

	render : function(displayStart, displayLength, totalNumberOfRecords, pageSize, onPreviousActionCallBack, onNextActionCallBack)
	{
		this._initializeFields(displayStart, displayLength, totalNumberOfRecords, pageSize);
		
		$(this.containerJQueryPath + ' .cms_pagination_info').html(this.getPaginationInfo());
				
		var previousAction = $(this.containerJQueryPath + ' .pager li.previous');		
		if (this.previousActionEnabled())
		     previousAction.removeClass('disabled');
		else previousAction.addClass('disabled');
		

		var nextAction = $(this.containerJQueryPath + ' .pager li.next');
		if (this.nextActionEnabled())
			 nextAction.removeClass('disabled');
		else nextAction.addClass('disabled');
				
		if (onPreviousActionCallBack)
		{
			this.onPreviousActionCallBack = onPreviousActionCallBack;
			previousAction.unbind().click($.r3Utils.hitch(this, this._onPreviousAction));
		}

		if (onNextActionCallBack)
		{
			this.onNextActionCallBack = onNextActionCallBack;
			nextAction.unbind().click($.r3Utils.hitch(this, this._onNextAction));
		}
	},

	_onPreviousAction: function()
	{
		console.info("_onPreviousAction");
		if (this.previousActionEnabled() && this.onPreviousActionCallBack)
		{
			this.onPreviousActionCallBack((this.getStartRecord() - 1) - this.pageSize);
		}		
	},

	_onNextAction: function()
	{
		console.info("_onNextAction");
		if (this.nextActionEnabled() && this.onNextActionCallBack)
		{
			this.onNextActionCallBack(this.displayStart + this.pageSize);
		}
	},

	getStartRecord: function()
	{
		if (this.totalNumberOfRecords > 0)
		    return this.displayStart + 1;
		
		return 0;
	},
	
	getEndRecord: function()
	{
		if (this.totalNumberOfRecords > 0)
		   return this.displayStart + this.displayLength;
		
		return 0;		
	},
	
	getTotalNumberOfRecords: function()
	{
		return this.totalNumberOfRecords;
	},
	
	previousActionEnabled: function()
	{
		return this.getTotalNumberOfRecords() > 0 && this.getStartRecord() > 1;
	},
		
	nextActionEnabled: function()
	{
		return this.getTotalNumberOfRecords() > 0 && this.getEndRecord() < this.getTotalNumberOfRecords();
	},
		
	getPaginationInfo: function()
	{
		if (this.getTotalNumberOfRecords() > 0)		
		   return "Record visualizzati da " + this.getStartRecord() + " a " + this.getEndRecord() + "  di " + this.getTotalNumberOfRecords();
		
		return "Non sono presenti schede da visualizzare";
	}
	
		
});

