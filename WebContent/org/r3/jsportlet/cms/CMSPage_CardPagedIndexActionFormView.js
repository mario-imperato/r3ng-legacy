$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, aCMSCardIndexContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.defaultOptions = { 
				"cardindextemplate": "cms_tpl_cardgroup_index",
				"iDisplayStart": 0,
				"iDisplayLength": 10,
				"fetchmode": 'partial',
				"cardIndexDivLocator": aCMSCardIndexContainerId + " .cms_cardIndex",
				// "cardDetailDivLocator": aCMSCardIndexContainerId + " .cms_cardDetail",
				"downloadCanvas": true							
		};

		this.options = null;
		this.pageId = '__ND__::CMSPage_CardPagedIndexActionFormView';
		
		this.cmsCardIndexContainerId = aCMSCardIndexContainerId;
		
		this.paginationHelper = new org.r3.jsportlet.cms.CMSPage_PaginationHelper(aCMSCardIndexContainerId + ' .cms_pagination_container');
	},

	close : function()
	{
		this.hide();
	},

	open : function(pageInfo, cardInfo, options)
	{
		var _self = this;

		this.pageId = pageInfo.pageid;
		this.options = $.extend({}, this.defaultOptions, options);
		
		if (this.options.downloadCanvas)
		{
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cms/CMSPage_CardPagedIndexActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			$(this.cmsCardIndexContainerId).html(responseData['view']);	
						
			this._fetchDataPage(
					this.pageId,
					this.options.iDisplayStart, 
					this.options.iDisplayLength,
					$.r3Utils.hitch(this, this._onPreviousPage), 
					$.r3Utils.hitch(this, this._onNextPage));

			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		}
		else
		{
			this._fetchDataPage(
					this.pageId,
					this.options.iDisplayStart, 
					this.options.iDisplayLength,
					$.r3Utils.hitch(this, this._onPreviousPage), 
					$.r3Utils.hitch(this, this._onNextPage));

			this.show();
		}
	},
	
	_fetchDataPage: function(aPageId, startRecord, pageSize, onPreviousPage, onNextPage)
	{
		var _self = this;
		
		$(this.options.cardIndexDivLocator).cmsCard(
		{
			pageid: aPageId,
			card_tmpl : this.options.cardindextemplate,
			cardquery : this.options.cardindexquery,
			iDisplayStart: startRecord,
			iDisplayLength: pageSize,
			// paginationHelper: this.options.paginationHelper,
			fetchmode: this.options.fetchmode,
			onComplete : function(responseInfo, totalNumberOfItems)
			{			
				_self.show();
				_self.paginationHelper.render(						
						startRecord, (totalNumberOfItems > 0) ? responseInfo.getNumberOfItems() : 0, totalNumberOfItems, pageSize, onPreviousPage, onNextPage);					
				
				var cardsInnerLinks = $(_self.options.cardIndexDivLocator + ' .cmsCard_link2carddetail');
				// console.info(cardsInnerLinks);
				
				$(_self.options.cardIndexDivLocator + ' .cmsCard_link2carddetail').unbind().click($.r3Utils.hitch(_self, _self._onCMSCardLink2CardDetail));
				
				//console.info(responseInfo, numberOfItems);
				
//				$('#cms_cardIndex .cms_pagination_actionbar .enabled_previous').unbind().click(
//					$.r3Utils.hitch(_self, _self._onPreviousPage)
//				);
//
//				$('#cms_cardIndex .cms_pagination_actionbar .enabled_next').unbind().click(
//						$.r3Utils.hitch(_self, _self._onNextPage)
//				);			
			}
		});		
	},
	
	_onNextPage: function(startRecord)
	{
		// console.log("Next Page: " + startRecord);
		this._fetchDataPage(this.pageId, startRecord, this.options.iDisplayLength);		
	},
	
	_onPreviousPage: function(startRecord)
	{
		// console.log("Prev Page: " + startRecord);		
		this._fetchDataPage(this.pageId, startRecord, this.options.iDisplayLength);		
	},
	
	_onCMSCardLink2CardDetail: function(e)
	{
		var theItem = $(e.currentTarget);
		var cardId  = theItem.attr('data-cardid');
		
		this.actionFormManager.openCMSCardDetailByPageIdCardId(this.pageId, cardId);
	}
	
});
