(function($)
{
	$.widget('r3.infoLine',
	{

		options :
		{},

		_create : function()
		{
			this._itemsMap =
			{};

			this._infoLineDiv = $('<div></div>').addClass('infoLineCanvas');

			if (this.options.items)
			{
				if (!this.options.groupId)
					this.options.groupId = 'default';

				this._itemsMap[this.options.groupId] = this.options.items;
				this._renderItems();
			}

			this.element.html(this._infoLineDiv);
		},

		update : function(anHash)
		{
			if (anHash && anHash.items)
			{
				if (!anHash.groupId)
					anHash.groupId = 'default';

				this._itemsMap[anHash.groupId] = anHash.items;
				this._renderItems();
			}
		},

        clear: function()
        {
        	this._itemsMap = {};
        	this._renderItems();
        },
        
		removeGroup : function(aGroupId)
		{
			if (aGroupId)
			{
				this._itemsMap[aGroupId] = [];
				this._renderItems();
			}
		},

		_renderItems : function()
		{
			this._infoLineDiv.empty();

			var itemCounter = 0;
			for (pname in this._itemsMap)
			{
				var groupItems = this._itemsMap[pname];
				if (groupItems && groupItems.length > 0)
				{
					for ( var i = 0; i < groupItems.length; i++, itemCounter++)
					{
						var separator = " ";
						if (itemCounter > 0 && !groupItems[i].newLine) // Logica da sistemare in quanto itemCounter non sembra essere per linea..
						{
							separator = ' - ';							
						}
						

						var item = "";
						if ($.isFunction(groupItems[i].value))
						{
							console.info("Is Function");
							var itemHtml = '<label>' + separator + groupItems[i].label + ': </label><label class="itemInfo" id="'
							+ groupItems[i].id + '">...Waiting...</label>';
														
							if (groupItems[i].newLine)
								itemHtml = '<br />' + itemHtml;
							
							item = $(itemHtml);
							
							//... groupItems[i].value(); Commentato in quanto apparentemente lo faccio anche dopo.... 
						}
						else
						{
							var gval = groupItems[i].value;
							var brender = true;
							if (!gval)
							{
								if (this.options.defaultOnEmptyValues && this.options.defaultOnEmptyValues == 'skip')
									 brender = false;
								else gval = this.options.defaultOnEmptyValues || ".";
							}
							
							if (brender)
							{
							   var itemHtml =  '<label>' +  separator + groupItems[i].label + ': </label><label class="itemInfo" id="'
							           + groupItems[i].id + '">' + gval + '</label>';		
							   
							   if (groupItems[i].newLine)
									itemHtml = '<br />' + itemHtml;
							   
							   item = $(itemHtml);
							}
						}

						this._infoLineDiv.append(item);
						
						if ($.isFunction(groupItems[i].value))
						{
							groupItems[i].value();
						}
						
					}
				}
			}
		},

		destroy : function()
		{
			this._infoLineDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		}

	});

})(jQuery);
