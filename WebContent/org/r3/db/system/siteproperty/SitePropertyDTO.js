//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.siteproperty");

org.r3.db.system.siteproperty.SitePropertyDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_siteproperty";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.propertyscope = aDataBean.propertyscope || null;
        this.propertykey = aDataBean.propertykey || null;
        this.propertyvalue = aDataBean.propertyvalue || null;
 
	 }
    
     // Modificato. SOstituita la comparazione su dtokey
  ,compareTo: function(anItemId)
   {
   	   if (!this.propertykey)
   	       return -99;
   	   
   	   var s = this.propertykey;
   	   // if (this.propertyscope.indexOf('.') >= 0)

   	   if (this.propertykey.indexOf('.') < 0)
   	   {
   		    s = this.propertyscope + '.' + this.propertykey;   
   	   }
   		   
   	   if (s < anItemId)
   	       return -1;
   	   else if (s > anItemId)
   	   	   return  1;
   	   	   
   	   return 0;
   }
   
});
