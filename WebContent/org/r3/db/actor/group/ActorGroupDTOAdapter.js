//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.actor.group");

org.r3.db.actor.group.ActorGroupDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.actor.group.ActorGroupDTO(aDataBean));
	 },
 
	 getGroupprofile: function()
	 {
		 var p = null;
		 
		 if (this.dataBean.groupprofile)
			 p = this.dataBean.groupprofile.split(',');
		 
		 return p;
	 },
	 
	 isGroupprofile: function(aProfileOption)
	 {
		 return this.dataBean.groupprofile && this.dataBean.groupprofile.indexOf(aProfileOption) >= 0;
	 }
});

