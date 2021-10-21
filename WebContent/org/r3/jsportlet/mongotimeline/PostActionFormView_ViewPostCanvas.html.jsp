<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div class="box box-widget timelinepost post-blue" id="post_{%=o.post.dataBean.postid%}">
	<div class="box-header with-border">
		<div class="user-block">
			<img class="img-circle"
				src="{%#o.post.getAuthorImgUrl()%}"
				alt="User Image"> <span class="username">{%=o.post.getAuthorname()%}</span>
			<span class="description">
				{%#o.post.getCreationDateAsBadge()%} -
				{%=o.post.getCreationdateAsElapsed()%} - {%=o.post.dataBean.title%}</span>
		</div>
		<!-- /.user-block -->
		<div class="box-tools">

            {% if (o.contentClassObj.isActionEnabled('edit', o.post)) { %}
			<button type="button" class="btn btn-box-tool view-mode" data-toggle="tooltip" title="Modifica" data-action="edit-primary">
				<i class="fa fa-pencil"></i>
			</button>
			{% } %}	
			{% if (o.contentClassObj.isActionEnabled('delete_DISABLED', o.post)) { %}
			<button type="button" class="btn btn-box-tool view-mode" data-toggle="tooltip" title="Cancella" data-action="delete-post">
				<i class="fa fa-trash"></i>
			</button>		
			{% } %}	
			<button type="button" class="btn btn-box-tool view-mode" data-widget="collapse">
				<i class="fa fa-minus"></i>
			</button>
			<button type="button" class="btn btn-box-tool edit-mode" data-action="primary-edit-cancel" style='display: none'>
				<i class="fa fa-times"></i>
			</button>

		</div>
		<!-- /.box-tools -->
	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<div id="post_{%=o.post.dataBean.postid%}_viewcanvas"></div>
        <div id="post_{%=o.post.dataBean.postid%}_editcanvas"></div>		
	</div>

	<div class="box-footer box-comments comments-canvas hidden-on-empty" style='padding: 0' ></div>
	
	
{% if (!org.r3.PageManager.userInfo.isGuest()) {

    var newChildActions = o.contentClassObj.getActionsByActionType('new-child', o.post); 
    if (newChildActions && newChildActions.length)
    {
 %}
	<div class="box-footer clearfix new-child-actionbar">
		<div class='pull-right'>
		{% for(var j = 0; j < newChildActions.length; j++) { %}
		<button  data-action='{%=newChildActions[j].dataAction%}' class="btn btn-default" type="button" >
		    {%=newChildActions[j].text%}
	    </button>
	    {% } %}
	    </div>
    </div>
   	<div id="post_{%=o.post.dataBean.postid%}_newchildcanvas" ></div>
	<!-- /.box-footer -->
{% } } %}		

</div>
