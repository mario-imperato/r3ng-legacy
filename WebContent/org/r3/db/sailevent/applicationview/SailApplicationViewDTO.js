//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.applicationview");

org.r3.db.sailevent.applicationview.SailApplicationViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailapplicationview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.userid = aDataBean.userid || null;
        this.completionstatus = aDataBean.completionstatus || null;
        this.verificationstatus = aDataBean.verificationstatus || null;
        this.adminchecks = aDataBean.adminchecks || null;
        this.plate = aDataBean.plate || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.yachtname = aDataBean.yachtname || null;
        this.yachtclub = aDataBean.yachtclub || null;
        this.yachttype = aDataBean.yachttype || null;
        this.mooringloc = aDataBean.mooringloc || null;
        this.yachtbsf = aDataBean.yachtbsf || null;
        this.yachtgph = aDataBean.yachtgph || null;
        this.racegroup = aDataBean.racegroup || null;
        this.raceclass = aDataBean.raceclass || null;
        this.apptype = aDataBean.apptype || null;
        this.ownerid = aDataBean.ownerid || null;
        this.ownerfirstname = aDataBean.ownerfirstname || null;
        this.ownerlastname = aDataBean.ownerlastname || null;
        this.owneremail = aDataBean.owneremail || null;
        this.ownercellphone = aDataBean.ownercellphone || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
	 }
    
   
});
