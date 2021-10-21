//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthreadnodeview");

org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTO(aDataBean));
	 },
	 
	 getCreationdate: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.creationdate); 
	 },
	 
	 getUsername: function()
	 {
		 var s = "N.A.";
			 
		 // In alcuni casi il campo non e' popolato in quanto in realtà viene usato questo JS al posto di quello base della tabella.
		 // Mi baso sulla presenza del nickname per capire il riferimento.
		 if (this.dataBean.nickname)
		 {
			 s = this.dataBean.firstname;
			 s = s + ' ' + this.dataBean.lastname;			 			
		 }
		 else
		 {
			 s = org.r3.PageManager.userInfo.dataBean.firstname;
			 s = s + ' ' + org.r3.PageManager.userInfo.dataBean.lastname;	
		 }
		 
		 return s;
	 },
	 
	 getCreationdate: function()
	 {
		return $.r3Utils.formatTimestampDataBeanField(this.dataBean.creationdate);
	 },
	 
	 getCreationDateAsBadge: function()
	 {
		 return $.r3Utils.formatDateAsBadge(this.dataBean.creationdate);
		 // '<i>29</i> <span class="text-uppercase">dic</span>';		 
	 },
	 
	 getCreationdateAsElapsed: function()
	 {   
		 return $.r3Utils.formatTimeDifferenceFromNow(this.dataBean.creationdate);
	 
		 // return this.getCreationdate();
	 },
	 
	 allowsTweets: function()
	 {
		 return !this.dataBean.nodeparentid;
	 }
 
});

