$.r3Utils.namespace("org.r3.db");

org.r3.db.DTOAdapter = Class.extend(
{	 
	 init: function(aDataBean)
	 {  
	 	   this.dataBean = aDataBean;
	     this.markFlag = false;
	     this.setDT_RowClass();
	     this.indexOfItem = 0;
	 },

   setDT_RowClass: function()
   {
   	   this.DT_RowClass = this.dataBean.dtrowclass;
       
       if (this.markFlag)
          this.DT_RowClass += " grade_mark";
   },
   
   setMark: function(aFlag)
   {
   	   this.markFlag = aFlag;
	     this.setDT_RowClass();   	   
   },
   	    
   update: function(aDataBeanHashObject)
   {
   	   for(pname in aDataBeanHashObject)
   	   {
      	   if (typeof this.dataBean[pname] === "undefined")
      	       console.error("DTOAdapter::update property " + pname + " is undefined and cannot be set ", aDataBeanHashObject); 
      	   else
   	   	       this.dataBean[pname] = aDataBeanHashObject[pname];
   	   }  
   }
	 	 
});

