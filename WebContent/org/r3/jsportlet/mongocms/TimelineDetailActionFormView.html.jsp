<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title">{%=org.r3.db.mongo.timelinecollection.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="timelinedetailactionform_fieldset_message" ></div>
  <form id="timelinedetailactionform_form" method="POST" class='form-horizontal'>
          
    <div class="row">
    <div class='col-md-12'>
 	  
     <div class="form-group">
	    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.mongo.timelinecollection.message.timelineid%}</label>
	    <div class='col-md-10'>
	    <input type="text" name="timelineid" class='form-control' id="timelinedetailactionform_timelineid" maxlength="15" disabled />
	    </div>
	  </div>
	
     <div class="form-group">
	    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.mongo.timelinecollection.message.title%}</label>
	    <div class='col-md-10'>
	    <input type='text' name="title" class='form-control' id="timelinedetailactionform_title" >
	    </div>
	  </div>
            
     <div class="form-group">
	    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.mongo.timelinecollection.message.description%}</label>
	    <div class='col-md-10'>
	    <textarea name="description" class='form-control' id="timelinedetailactionform_description" rows='8'></textarea>
	    </div>
	  </div>
	                 
     </div>
     
	
    </div>
    
    {%
    var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_m_contentclass_category" );
   	org.r3.PageManager.lutManager.getLUT(resolvedUrl, function(theLUT)
   	{
   		if (theLUT.aaData && theLUT.aaData.length > 0)
   		{
   		     for(var i = 0; i < theLUT.aaData.length; i++)
   		     {
   		         var categoryIem = theLUT.aaData[i];
    %}
    <div class="row">
    <div class='col-md-12'>

	<div class="form-group">
     <label class="col-md-2 control-label "  >{%=categoryIem.dtodescr%}</label>
     <div class="col-md-10 columns" >
     {%
    			var resolvedUrl1 = org.r3.PageManager.getRESTUrl("GET_classifier_contentclassdef" );
   				org.r3.PageManager.lutManager.getLUT(resolvedUrl1, function(theLUT1)
   				{
   					if (theLUT1.aaData && theLUT1.aaData.length > 0)
   					{
   		     			for(var i1 = 0; i1 < theLUT1.aaData.length; i1++)
   		     			{
   		         			var contentDefinitionItem = theLUT1.aaData[i1];
       						if (contentDefinitionItem.contentcategory && contentDefinitionItem.contentcategory == categoryIem.dtokey)
       						{
       						   var ac = o.timelineDTOAdapter && o.timelineDTOAdapter.hasAllowedcontent &&  o.timelineDTOAdapter.hasAllowedcontent(contentDefinitionItem.dtokey);
       						   if (ac)
       						   		ac = ' checked ';
       						   
       						   if (contentDefinitionItem.timeline && contentDefinitionItem.timeline.create)
       						   {
 %} <label class="checkbox-inline" style="width: 220px; ">
           <input  type="checkbox" name="allowedcontent" value='{%=contentDefinitionItem.dtokey%}' {%=ac%}/>{%=contentDefinitionItem.dtodescr%}</label>
	   {%
       						   }
      
	   						}
	   					}
	   				}
	   			});
	   %}
                     
     </div>
 	</div>
     
    </div>
    </div>
    {%
    			}
    	}
    });
    %}
    
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="timelinedetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>  
        
        <button type="button" id="timelinedetailactionform_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>     
        
        <button type="button" id="timelinedetailactionform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
        </button>                              
  </div>
  
  </div>
</div>



