//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.usercollection");

org.r3.db.mongo.usercollection.UserCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_usercollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.userid = aDataBean.userid || null;
       this.nickname = aDataBean.nickname || null;
       this.firstname = aDataBean.firstname || null;
       this.lastname = aDataBean.lastname || null;
       this.email = aDataBean.email || null;
       this.usertype = aDataBean.usertype || null;
       this.primarygeo = aDataBean.primarygeo || null;
       this.lastmodified = aDataBean.lastmodified || null;
       this.userstatus = aDataBean.userstatus || null;
       this.lastlogin = aDataBean.lastlogin || null;
       this.numberoflogins = aDataBean.numberoflogins || null;
       this.userconsent = aDataBean.userconsent || null;
       this.userana = aDataBean.userana || null;
       this.sections = aDataBean.sections || null;
       this.favsites = aDataBean.favsites || null;
       this.photo = aDataBean.photo || null;
       this.address = aDataBean.address || null;
       this.businesscard = aDataBean.businesscard || null;
	 }
       
});

 org.r3.db.mongo.usercollection.UseranaDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.numberofposts = aDataBean.numberofposts || null;
        this.lastpostaction = aDataBean.lastpostaction || null;
        this.numberofcomments = aDataBean.numberofcomments || null;
        this.lastcommentaction = aDataBean.lastcommentaction || null;
        this.lastpostauthorid = aDataBean.lastpostauthorid || null;
        this.lastpostauthortype = aDataBean.lastpostauthortype || null;
	 }	   
 });   
  
 org.r3.db.mongo.usercollection.PhotoDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.url = aDataBean.url || null;
        this.ctype = aDataBean.ctype || null;
        this.width = aDataBean.width || null;
        this.height = aDataBean.height || null;
        this.role = aDataBean.role || null;
	 }	   
 });   
  
 org.r3.db.mongo.usercollection.AddressDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.formatted = aDataBean.formatted || null;
        this.snumber = aDataBean.snumber || null;
        this.route = aDataBean.route || null;
        this.locality = aDataBean.locality || null;
        this.adminarea_l3 = aDataBean.adminarea_l3 || null;
        this.adminarea_l2 = aDataBean.adminarea_l2 || null;
        this.adminarea_l1 = aDataBean.adminarea_l1 || null;
        this.country = aDataBean.country || null;
        this.postcode = aDataBean.postcode || null;
        this.geom = aDataBean.geom || null;
        this.gmapplaceid = aDataBean.gmapplaceid || null;
	 }	   
 });   
  
 org.r3.db.mongo.usercollection.AddressGeomDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.location = aDataBean.location || null;
        this.viewpnortheast = aDataBean.viewpnortheast || null;
        this.viewpsouthwest = aDataBean.viewpsouthwest || null;
	 }	   
 });   
  
 org.r3.db.mongo.usercollection.BusinesscardDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.personalstatement = aDataBean.personalstatement || null;
        this.email = aDataBean.email || null;
        this.cellphone = aDataBean.cellphone || null;
	 }	   
 });   
  
