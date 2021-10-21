<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

{%
var  shakedClass = null;
if (o.comment.isShaked())
{
    shakedClass = "shaked";
}
%}
	<div class="box-comment timelinecomment {%=shakedClass%}" style='padding: 10px' id="comm_{%=o.comment.dataBean.commentid%}">
		<!-- User image -->
		<img class="img-circle img-sm"
			src="{%#o.comment.getAuthorImgUrl()%}" alt="User Image">

		<div class="comment-text">
			<span class="username" style='height: 40px'><span class="authorname">{%=o.comment.getAuthorname()%}</span> - <span class="text-muted lastmodified">{%#o.comment.getCreationDateAsBadge()%} -
			{%=o.comment.getCreationdateAsElapsed()%}</span>
			    <span class="text-muted pull-right">

{% if (!org.r3.PageManager.userInfo.isGuest()) {

    var canvasActions = o.contentClassObj.getActionsByActionType('canvas-action', o.post, o.comment); 
    if (canvasActions && canvasActions.length)
    {
 %}
		{% for(var j = 0; j < canvasActions.length; j++) { %}
		
	    {% } %}

    <!-- /.box-footer -->
{% } } %}			          

				      {% if (o.contentClassObj.isActionEnabled('shakeit', o.post, o.comment)) { %}
                      <button  data-action='shakeit' class="btn btn-box-tool view-mode btn-social-icon bg-olive" title="Prenota" type="button" >
		                  <i class="fa fa-thumbs-up fa-2x"></i>
	                  </button> 
	                  {% } %}

				      {% if (o.contentClassObj.isActionEnabled('unshakeit', o.post, o.comment)) { %}
                      <button  data-action='unshakeit' class="btn btn-box-tool view-mode btn-social-icon btn-google" title="Annulla Prenotazione" type="button" >
		                  <i class="fa fa-times fa-2x"></i>
	                  </button> 
	                  {% } %}
	                  
				      {% if (o.contentClassObj.isActionEnabled('edit', o.post, o.comment)) { %}
                      <button type="button" class="btn btn-box-tool view-mode" data-toggle="tooltip" title="Modifica" data-action="edit-child" style='padding-top: 0px'>
				        <i class="fa fa-pencil"></i>
			          </button>					    
				      {% } %}
				      {% if (o.contentClassObj.isActionEnabled('delete', o.post, o.comment)) { %}
				      <button type="button" class="btn btn-box-tool view-mode" data-toggle="tooltip" title="Cancella" data-action="delete-child" style='padding-top: 0px'>
				        <i class="fa fa-trash"></i>
			          </button>	
			          {% } %}
					  <button type="button" class="btn btn-box-tool edit-mode" data-action="child-edit-cancel" style='display: none'>
						<i class="fa fa-times"></i>
					  </button>			          		
				    </span>
				</span>
				
				<!-- /.username -->
				<div class='comment-content-viewcanvas'></div>
				<div class='comment-content-editcanvas'></div>
			</div>
			<!-- /.comment-text -->
		</div>