<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class="home_portlet">
<div class='title grade3'><i class="fa fa-user"></i> {%#o.dictionary.portlet_list_of_wbs%}</div>

{%  
if (o.wbses && o.wbses.getNumberOfItems() > 0) { 
   for (var i = 0; i < o.wbses.getNumberOfItems(); i++) 
   {             
        var theWbs = o.wbses.getItem(i);         
%} 
<div class="wbs" id='{%=theWbs.dataBean.wbsid%}'>
<h3><a href='{%=org.r3.Constants.getStrutsActionContext()%}/org/r3/wbs/wbsfillout.do?pageid=wbses&wbsid={%=theWbs.dataBean.wbsid%}'>{%=theWbs.dataBean.wbstitle%}</a></h3>

{%#theWbs.dataBean.wbstext%}

</div>

{%  } %}
{%  } %}



</div>

