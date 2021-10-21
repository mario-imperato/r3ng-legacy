//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.application");

org.r3.db.sailevent.application.SailApplicationDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailapplication";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.userid = aDataBean.userid || null;
        this.dmsfolderurl = aDataBean.dmsfolderurl || null;
        this.annotation = aDataBean.annotation || null;
        this.completionstatus = aDataBean.completionstatus || null;
        this.verificationstatus = aDataBean.verificationstatus || null;
        this.adminchecks = aDataBean.adminchecks || null;
        this.adminracegroup = aDataBean.adminracegroup || null;
        this.adminraceclass = aDataBean.adminraceclass || null;
        this.plate = aDataBean.plate || null;
        this.yachtname = aDataBean.yachtname || null;
        this.yachtclub = aDataBean.yachtclub || null;
        this.yachttype = aDataBean.yachttype || null;
        this.mooringloc = aDataBean.mooringloc || null;
        this.yachtbsf = aDataBean.yachtbsf || null;
        this.yachtgph = aDataBean.yachtgph || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.racegroup = aDataBean.racegroup || null;
        this.raceclass = aDataBean.raceclass || null;
        this.apptype = aDataBean.apptype || null;
        this.ownerid = aDataBean.ownerid || null;
        this.helmsmanid = aDataBean.helmsmanid || null;
        this.boatimageid = aDataBean.boatimageid || null;
        this.boatimageurl = aDataBean.boatimageurl || null;
        this.boatimageheight = aDataBean.boatimageheight || null;
        this.boatimagewidth = aDataBean.boatimagewidth || null;
        this.boaticonurl = aDataBean.boaticonurl || null;
        this.boaticonwidth = aDataBean.boaticonwidth || null;
        this.boaticonheight = aDataBean.boaticonheight || null;
        this.addtohomeentrylist = aDataBean.addtohomeentrylist || null;
        this.createtimestamp = aDataBean.createtimestamp || null;
        this.committimestamp = aDataBean.committimestamp || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
        // Inserito
        this.nickname = aDataBean.nickname || null;
        if (aDataBean.owner)
             this.owner = new org.r3.db.actor.actor.ActorDTOAdapter(aDataBean.owner);
        else this.owner = null;

        if (aDataBean.helmsman)
             this.helmsman = new org.r3.db.actor.actor.ActorDTOAdapter(aDataBean.helmsman);
        else this.helmsman = null;

        if (aDataBean.properties)
        {
        	this.properties =  new org.r3.db.DTOTableAdapter(aDataBean.properties, 
    				function(aRowDataBean) { return new org.r3.db.sailevent.appdata.SailApplicationDataDTOAdapter(aRowDataBean); });            	
        }
        else this.properties = null;
                
	 }
    
  ,compareTo: function(anItemId)
   {
   	   if (!this.dtokey)
   	       return -99;
   	       
   	   if (this.dtokey < anItemId)
   	       return -1;
   	   else if (this.dtokey > anItemId)
   	   	   return  1;
   	   	   
   	   return 0;
   }
   
});
