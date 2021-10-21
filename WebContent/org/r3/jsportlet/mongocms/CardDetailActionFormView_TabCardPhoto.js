$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardPhoto = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		var resolvedUrl = null; 
			
		$('#cardphotoactionform_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');
								
		$('#cardphotoactionform_form_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
		$('#cardphotoactionform_form_authorname').html(aCardDataBean.dataBean.authorname);
										
		$('#cardphotoactionform_form_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());							
	},
	
	refresh: function()
	{		

	}
		
});
