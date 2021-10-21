//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.resourcetimesheetview");

org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTO(aDataBean));
	 },
	 
	 getCalevemonth: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField("LUT_DefaultCalendarMonthlyPeriod", this.dataBean.calevemonth);
	 },
	 
	 getCaleveyear: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField("LUT_DefaultCalendarYearlyPeriod", this.dataBean.caleveyear);
	 },
	 
	 getCalevequarter: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField("LUT_DefaultCalendarQuarterlyPeriod", this.dataBean.calevequarter);
	 }
	 
 
});

