<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<%
	String mode = request.getParameter("mode");
	boolean isDetail = mode.equalsIgnoreCase("detail");
	boolean isCreate = !isDetail;
%>

<div class="modal fade " id="sitemember-dialog-form" title="Site Member"
	role="dialog" aria-labelledby="gridSystemModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content"></div>
	</div>
</div>


<div class="box box-widget">
	<div class="box-header with-border">
		<h3 class='box-title'>Members</h3>
		<!-- /.user-block -->
		<div class="box-tools">
			<button type="button" class="btn btn-box-tool" data-widget="collapse">
				<i class="fa fa-minus"></i>
			</button>
			<button type="button" class="btn btn-box-tool" data-widget="remove">
				<i class="fa fa-times"></i>
			</button>
		</div>
		<!-- /.box-tools -->
	</div>
{%  var profileOk = org.r3.PageManager.userCollectionProfileInfo.isProfileOK(), 
        inFavList = org.r3.PageManager.userCollectionProfileInfo.isSiteInFavoriteList();  %}	
        
{% if (!org.r3.PageManager.userInfo.isGuest()) { %}	        
	<div class="box-footer">
{% if (!profileOk) { %}	
		<div class="alert alert-danger alert-dismissible">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<p>
				<a
					href="{%=org.r3.Constants.getStrutsActionContext()%}/org/r3/user/myr3.do"
					" style='text-decoration: none;'><i class="icon fa fa-edit"></i>Completa
					il tuo profilo</a>
			</p>
		</div>
{% } %}	

{% if (!inFavList) { %}	
		<div id='JSPortlet_SiteMember_ILike_Canvas'>
			<p>Se il nostro vicinato ti piace inseriscilo tra i tuoi
				preferiti!</p>

			<button id='JSPortlet_SiteMember_ILike' type="button"
				class="btn btn-default">
				<i class="fa fa-thumbs-o-up"></i> Like
			</button>
		</div>
{% } 
   else 
   {         
   		if (!(org.r3.PageManager.userInfo.hasRole4Site(null, 'shkmember') || org.r3.PageManager.userInfo.hasRole4Site(null, 'shkowner') || org.r3.PageManager.userInfo.hasRole4Site(null, 'shkadmin')))
   		{
   %}
   		<!-- La Div viene inserita solamente se l'utente non ha uno dei ruoli associativi o gestionali... -->
		<div id='JSPortlet_SiteMember_IDisLike_Canvas'>			
			<p>Il nostro vicinato non ti piace piu'?</p>

			<button id='JSPortlet_SiteMember_IDisLike' type="button"
				class="btn btn-default">
				<i class="fa fa-thumbs-o-down"></i> Abbandona Vicinato
			</button>
		</div>   
{% 		}
	}
   %}	

	<!-- 
	<span class="pull-right text-muted">127 likes - 3 comments</span>
	 -->

	</div>
{% } %}	

	<!-- /.box-header -->
	<div class="box-body"><div id='JSPortlet_SiteMember_Photo_Canvas'></div></div>
	<!-- /.box-body -->

	<div class="overlay sitemember-loading-state" style='display: none'>
		<i class="fa fa-refresh fa-spin"></i>
	</div>
	
</div>

<div id='jsportlet_endof_sitememberportlet' style="display: none"></div>   