
(function($) 
{
  $.fn.datePickerChecker = function(/* Hash */ anOptionHash) 
  {  	
  	   // var defaults = {  };
  	   // var options = $.extend({}, defaults, anOptionHash);
  	     	   
  	   if (this.length > 0)
  	   {                                   
  	   	  for(var i = 0; i < this.length; i++)
  	   	  {
  	   	  	 var item   = $(this[i]);
  	   	  	 
  	   	  	 var datePickerTarget = item.attr('for');
             
             console.info(datePickerTarget, datePickerTarget && datePickerTarget.length, datePickerTarget && $('#' + datePickerTarget).length);
             if (datePickerTarget && datePickerTarget.length > 0 && $('#' + datePickerTarget).length > 0)
             {
             	    __bindEvents(item, $('#' + datePickerTarget));
             }
  	   	  }
  	   }         	           	          
  	   return this;
  };
  
  function __bindEvents(datePickerChecker, datePicker)
  {
  	    datePicker.change(function(e)
        {
           var currentTarget = $(e.currentTarget);	  
           if (currentTarget.val() && currentTarget.val().length > 0)
        	 {
        	 	   datePickerChecker.prop('checked', true);
        	 }
        	 else
        	 	   datePickerChecker.prop('checked', false);
        });
        
        datePickerChecker.click(function(e) 
        {             	    	  
            var currentTarget = $(e.currentTarget);	  
            console.info("Clicking on", currentTarget);
            var datePickerTarget = $('#' + currentTarget.attr('for'));
            
            var currentDatePickerTargetValue = datePickerTarget.val();
            if (currentTarget.prop('checked'))
            {
            	 if (!currentDatePickerTargetValue || !currentDatePickerTargetValue.length)
            	 {
            	 	  currentTarget.prop('checked', false);
            	 }             	        	 
            }
            else
            {
            	 // Lo sto de-checkando....
            	 datePickerTarget.val('');
            }
        });
    }
    
})(jQuery);
