(function($)
{
	$.widget('r3.formmessage',
	{
		options :
		{},

		_create : function()
		{
			this._message = { category: 'info' };
			this._currentCategory = "info";

			this._infoLineDiv = $('<div></div>').addClass('formmessageCanvas info');
            this._setMessage(this.options);            
			this._renderMessage();

			this.element.html(this._infoLineDiv);
		},

		_setMessage: function(anHash)
		{
			if (anHash.text && anHash.text.length > 0)
			{
				this._message = {
				     'text': anHash.text,
				     'category': ((!anHash.category) ? 'info' : anHash.category)
				};								
			}
			else
			{
				this._message = { category: 'info' };				
			}
		},
		
		setText : function(anHash)
		{
			this._setMessage(anHash);
 		    this._renderMessage();
		},

        clear: function()
        {
        	this._message = { category: 'info' };
        	this._renderMessage();        	
        },
        
		_renderMessage : function()
		{
			this._infoLineDiv.empty();

			if (this._currentCategory != this._message.category)
			{
				this._infoLineDiv.removeClass(this._currentCategory);
				this._infoLineDiv.addClass(this._message.category);
				this._currentCategory = this._message.category;
			}
			
			if (this._message.text)
			{
               	 this._infoLineDiv.append(this._message.text);
               	 this._infoLineDiv.show();
			}
			else this._infoLineDiv.hide();			
		},

		destroy : function()
		{
			this._infoLineDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		}

	});

})(jQuery);
