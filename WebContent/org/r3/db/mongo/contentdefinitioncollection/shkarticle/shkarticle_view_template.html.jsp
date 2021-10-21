<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div id='shkarticle_view_wrapper'>	
{%
if (o.post.dataBean.photo && o.post.dataBean.photo.image)
{
%}  <img src="{%=$.r3Utils.formatDMSUrl4ClientAccess(o.post.dataBean.photo.image.url)%}" style='width: 100%' /> {%
}
%}   

{% 
   var tb = o.post.getTextBody4Language();
   if (tb) { %}
	<div style="padding: 10px">{%=tb.dataBean.summary%}</div>
	<div style="padding: 10px">{%#tb.dataBean.body%}</div>
{% } %}	
</div>
