//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appeventlogview");

org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDTO(aDataBean));
	 },
	 
	 getLatest_ts: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.latest_ts);
	 },
	 
	 getApplicationinfo: function()
	 {
		return  this.dataBean.sailnumber + ' ' + this.dataBean.yachtname + '<br /><span style="font-size: 0.7em">' + this.dataBean.ownername + '</span>';  
	 },
	 
	 getEv_info: function()
	 {
    	 result = "<div style='margin: 0 auto; width: " + (4 * 19) + "px'>";

    	 var checkBoxIcon = $.r3Utils.formatBooleanAsCheckboxIcon(this.dataBean.ev_general, 2);
         result = result + checkBoxIcon;

    	 var checkBoxIcon = $.r3Utils.formatBooleanAsCheckboxIcon(this.dataBean.ev_document, 2);
         result = result + checkBoxIcon;

    	 var checkBoxIcon = $.r3Utils.formatBooleanAsCheckboxIcon(this.dataBean.ev_crew, 2);
         result = result + checkBoxIcon;

    	 var checkBoxIcon = $.r3Utils.formatBooleanAsCheckboxIcon(this.dataBean.ev_commit, 2);
         result = result + checkBoxIcon;

         result += "<div>";         
         return result;
	 },
	 
	 getEv_generalAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.dataBean.ev_general ? 'green' : 'gray');
	 },
	 
	 getEv_documentAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.dataBean.ev_document ? 'green' : 'gray');
	 },

	 getEv_crewAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.dataBean.ev_crew ? 'green' : 'gray');
	 },

	 getEv_commitAsSemaphore: function()
	 {
		 return $.r3Utils.formatSemaphore(this.dataBean.ev_commit ? 'green' : 'gray');
	 }
 
});

