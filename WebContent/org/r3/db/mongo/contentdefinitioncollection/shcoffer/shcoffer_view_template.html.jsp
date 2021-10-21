<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div id='shcoffer_view_wrapper'>

<div class='row'>

 <div class='col-md-12'>
{%
if (o.post.dataBean.photo && o.post.dataBean.photo.image)
{
%}  <img src="{%=$.r3Utils.formatDMSUrl4ClientAccess(o.post.dataBean.photo.image.url)%}" style='width: 100%' /> {%
}
%} 
  </div>

{% if (o.post.dataBean.content) { %}
  <div class='col-md-12'>
  
	<table class="table">
		<tbody>
			<tr >
				<td ><b>Oggetto</b></td>
				<td >{%=o.post.dataBean.content.what%}</td>
			</tr>
			<tr >
				<td ><b>Prezzo</b></td>
				<td >{%=o.post.dataBean.content.unitprice%}</td>
			</tr>
			<tr >
				<td ><b>Disponibilita'</b></td>
				<td >{%=o.post.dataBean.content.availability%}</td>
			</tr>
		</tbody>
	</table>
</div>
{% } %}

</div>

	<div style="padding: 10px">{%=o.post.dataBean.content.description%}</div>
</div>
