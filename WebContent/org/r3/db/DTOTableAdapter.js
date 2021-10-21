$.r3Utils.namespace("org.r3.db");

org.r3.db.DTOTableAdapter = Class.extend(
{
	init : function(queryResult, aDataBeanAdapterConstructor, simpleArrayFlag)
	{
		this.listOfItems = [];
		this.dataBeanAdapterConstructor = aDataBeanAdapterConstructor;

		if (simpleArrayFlag && queryResult && queryResult.length > 0)
		{
			$.each(queryResult, $.r3Utils.hitch(this, function(entryIndex, entry)
			{
				this.addRowItem(entry);
			}));
		}
		else
		{			
		if (queryResult && queryResult.aaData && queryResult.aaData.length > 0)
		{
			$.each(queryResult.aaData, $.r3Utils.hitch(this, function(entryIndex, entry)
			{
				this.addRowItem(entry);
			}));
		}
		}

	},

	getNumberOfItems : function()
	{
		return this.listOfItems.length;
	},

	visit : function(aVisitor)
	{
		for ( var i = 0; i < this.listOfItems.length; i++)
		{
			var entry = this.listOfItems[i];

			var continueTheLoop = true;
			if (aVisitor.processItem)
				continueTheLoop = aVisitor.processItem(entry);
			if (!continueTheLoop)
				break;
		}
	},

	getItem : function(index)
	{
		if (this.getNumberOfItems() > index && index >= 0)
			return this.listOfItems[index];

		return null;
	},

	addRowItem : function(aRowDataBean)
	{
		var theModel = this.dataBeanAdapterConstructor(aRowDataBean);
		return this.addItem(theModel);
	},

	addItem : function(anAdaptedDataBean)
	{
		anAdaptedDataBean.indexOfItem = this.listOfItems.length;
		this.listOfItems.push(anAdaptedDataBean);
		return anAdaptedDataBean;
	},

	removeItem : function(anItemId)
	{
		var foundItem = this.findItem(anItemId);
		if (foundItem)
		{			
			var e = this.listOfItems.splice(foundItem.indexOfItem, 1);
			return e;
		}
				
		return null;
	},
	
	replaceItem : function(anItemId, anAdaptedDataBean)
	{
		var foundItem = this.findItem(anItemId);
		if (foundItem)
		{
			anAdaptedDataBean.indexOfItem = foundItem.indexOfItem;
			this.listOfItems[foundItem.indexOfItem] = anAdaptedDataBean;
			return anAdaptedDataBean;
		}
		else
		{
			this.addItem(anAdaptedDataBean);
		}
				
		return anAdaptedDataBean;
	},
	
	findItem : function(anItemId)
	{
		var theModel = null;
		var visitor =
		{

			processItem : function(anItem)
			{
				if (!anItem.dataBean.compareTo)
				{
					console.error("::findItem - item doesn't implement function compareTo");
				}
				else
				{
					if (anItem.dataBean.compareTo(anItemId) == 0)
					{
						theModel = anItem;
						return false;
					}
				}
				return true;
			}
		};

		this.visit(visitor);
		return theModel;
	},

	findRowOfItem : function(anItemId)
	{
		var rowNumber = -1;
		var counter = 0;
		var visitor =
		{

			processItem : function(anItem)
			{
				if (anItem.dataBean.compareTo(anItemId) == 0)
				{
					rowNumber = counter;
					return false;
				}

				counter++;
				return true;
			}
		};

		this.visit(visitor);
		return rowNumber;
	}

});
