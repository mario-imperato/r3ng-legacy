<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div id='crewask_view_wrapper'>

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
			<tr>
				<td><b>Ruolo</b></td>
				<td>{%=o.post.dataBean.content.crewroletext%}</td>
			</tr>
			<tr >
				<td><b>Livello</b></td>
				<td>{%=o.post.dataBean.content.crewleveltext%}</td>
			</tr>
			<tr >
				<td><b>Nominativo</b></td>
				<td>{%=o.post.dataBean.content.crewname%}</td>
			</tr>
			<tr >
				<td><b>E-mail</b></td>
				<td>{%=o.post.dataBean.content.crewemail%}</td>
			</tr>			
			<tr >
				<td><b>Telefono</b></td>
				<td>{%=o.post.dataBean.content.crewphone%}</td>
			</tr>
			<tr>
				<td><b>Peso</b></td>
				<td>{%=o.post.dataBean.content.crewweight%}</td>
			</tr>

			<tr>
				<td><b>Altezza</b></td>
				<td>{%=o.post.dataBean.content.crewheight%}</td>
			</tr>
			<tr>
				<td><b>Eta'</b></td>
				<td>{%=o.post.dataBean.content.crewage%}</td>
			</tr>
		</tbody>
	</table>
{% } %}
    
  </div> 
 </div>
 
  <div style="padding: 10px">{%=o.post.dataBean.content.crewinfo%}</div>
</div>
