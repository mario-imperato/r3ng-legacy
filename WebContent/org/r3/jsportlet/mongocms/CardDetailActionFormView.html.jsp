<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   boolean isDetail = mode.equalsIgnoreCase("detail");
   boolean isCreate = !isDetail;
%>

<input id="loadimage_input_file" name="files[]" type="file" class="" style="opacity: 0; position: absolute;">
<div class="modal fade" id='photo_dialog' tabindex="-1" role="dialog" aria-labelledby="photo_dialog">
	<div class="modal-dialog r3_img_cropcanvas" style='width: 530px'>
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body ">
				<div id="result" class="result" style='width: 500px; max-height: 500px; line-height: 0'></div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					id='r3_img_cropcanvas_commit'>Save changes</button>
			</div>
		</div>
	</div>
</div>

<div id="cardDetailActionFormTabs" >

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#cardDetailActionForm_tab_generale" role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_generale%}</a></li>
    
  <r3_lang:ifinclude include="<%=isDetail%>" >   
  {%
  if (o.contentdefinition.isSectionEnabledInMongoCMS("customcontent")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_cardcontent" role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_cardcontent%}</a></li>
  {% }      
  if (o.contentdefinition.isSectionEnabledInMongoCMS("richtext")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_cardtext"  role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_cardtext%}</a></li>
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("photo")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_cardphoto" role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_cardphoto%}</a></li>
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("fileattachments")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_cardfile"  role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_cardfile%}</a></li>
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("links")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_cardlink"  role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_cardlink%}</a></li>        
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("publishing")) { %}
    <li role="presentation" ><a href="#cardDetailActionForm_tab_publishing"  role="tab" data-toggle="tab">{%=org.r3.jsportlet.mongocms.message.cardDetailActionForm_tab_publishing%}</a></li>        
  {% } %}
    </r3_lang:ifinclude>
</ul>

<div class="tab-content" >  
  <div id="cardDetailActionForm_tab_generale"  class='tab-pane active tab-pane-framed'></div> 
  <r3_lang:ifinclude include="<%=isDetail%>" >   
  {%
  if (o.contentdefinition.isSectionEnabledInMongoCMS("customcontent")) { %}
    <div id="cardDetailActionForm_tab_cardcontent"  class='tab-pane tab-pane-framed' ></div> 
  {% } 
  if (o.contentdefinition.isSectionEnabledInMongoCMS("richtext")) { %}
  <div id="cardDetailActionForm_tab_cardtext"  class='tab-pane tab-pane-framed' ></div>  
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("photo")) { %}
  <div id="cardDetailActionForm_tab_cardphoto" class='tab-pane tab-pane-framed' ></div>  
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("fileattachments")) { %}
   <div id="cardDetailActionForm_tab_cardfile"  class='tab-pane tab-pane-framed' ></div>
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("links")) { %}
  <div id="cardDetailActionForm_tab_cardlink"  class='tab-pane tab-pane-framed' ></div>
  {% }
  if (o.contentdefinition.isSectionEnabledInMongoCMS("publishing")) { %}
  <div id="cardDetailActionForm_tab_publishing"  class='tab-pane tab-pane-framed' ></div>
   {% } %}
  </r3_lang:ifinclude>
</div>
  
  
</div>
