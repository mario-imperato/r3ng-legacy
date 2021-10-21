<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div id='crewoffer_view_wrapper'>

<div class='row'>
  <div class='col-md-4'>
{% var imageUrl = '/r3ng/resources/sites/default/default_avatar_male.jpg';  
   if (o.post.dataBean.photo && o.post.dataBean.photo.image) 
   {
     imageUrl = $.r3Utils.formatDMSUrl4ClientAccess(o.post.dataBean.photo.image.url);
   } %} 
  <img class="img-thumbnail" src="{%=imageUrl%}" style='width: 100%' />  
  </div>

  <div class='col-md-8'>
{% if (o.post.dataBean.content) { %}
	<table class="table">
		<tbody>
			<tr >
				<td ><b>Ruolo</b></td>
				<td >{%=o.post.dataBean.content.crewroletext%}</td>
			</tr>
			<tr >
				<td ><b>Livello</b></td>
				<td >{%=o.post.dataBean.content.crewleveltext%}</td>
			</tr>
			<tr >
				<td ><b>Nominativo</b></td>
				<td >{%=o.post.dataBean.content.ownername%}</td>
			</tr>
			<tr >
				<td ><b>Barca</b></td>
				<td >{%=o.post.dataBean.content.yachtname%}</td>
			</tr>
			<tr >
				<td ><b>E-mail</b></td>
				<td >{%=o.post.dataBean.content.owneremail%}</td>
			</tr>
			<tr >				
				<td ><b>Modello</b></td>
				<td >{%=o.post.dataBean.content.yachtmodel%}</td>
			</tr>
			<tr >
				<td ><b>Telefono</b></td>
				<td >{%=o.post.dataBean.content.ownerphone%}</td>
			</tr>
		</tbody>
	</table>
{% } %}
	
</div>
</div>

	<div style="padding: 10px">{%=o.post.dataBean.content.yachtinfo%}</div>
</div>
