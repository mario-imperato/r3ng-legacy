//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.applicationview");

org.r3.db.sailevent.applicationview.SailApplicationViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.applicationview.SailApplicationViewDTO(aDataBean));
	 },
	 
	 getRacegroup: function()
     {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_boatgroup', this.dataBean.adminracegroup || this.dataBean.racegroup);
	 },
	 
	 getRaceclass: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_raceclass', this.dataBean.adminraceclass || this.dataBean.raceclass);
	 },
	 
	 getRectimestamp: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.rectimestamp);
	 },
	 
	 isDraft: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_draft';
	 },
	 
	 isEmpty: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_empty';
	 },
	 
	 isCommit: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_commit';
	 },
	 
	 isAccepted: function()
	 {
		 return this.dataBean.verificationstatus == 'r3ea_accepted';
	 },
	 
	 getCompletionstatusAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.isCommit() ? 'green' : 'gray');
	 },

	 getVerificationstatusAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.isAccepted() ? 'green' : 'gray');
	 },
	 
	 getAdminchecks: function()
	 {
		 var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_admincks');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         
         var result = '';
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
        	 result = "<div style='margin: 0 auto; width: " + (theLUT.iTotalRecords * 19) + "px'>";
        	 var theDataBeanValue = this.dataBean.adminchecks;
             $.each(theLUT.aaData, function(index, item)
             {
                var checkBoxIcon = $.r3Utils.formatBooleanAsCheckboxIcon(theDataBeanValue &&  theDataBeanValue.indexOf(item.dtokey) >= 0, 2);
                result = result + checkBoxIcon;
             });
             result += "<div>";
         }
         
		 return result;
	 },
	 
	 isAccepted: function()
	 {
		var theDataBeanValue = this.dataBean.adminchecks;
        if (theDataBeanValue && theDataBeanValue.indexOf('chk5') >= 0) 
             return true;
             
        return false;
	 }

 
});

