<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<script type="text/x-tmpl" id="cms_tpl_trackerview">
  {% if (o.object.getNumberOfItems() > 0) {
        for(var i = 0; i < o.object.getNumberOfItems(); i++)
        {
           var item = o.object.getItem(i);
           
           %}
           <div class="cmsCard">
           <h3>{%=item.dataBean.title%}</h3>
           <p>{%=item.dataBean.summary%}</p>

           {% if (item.dataBean.listof_htmlfragments && item.dataBean.listof_htmlfragments.length) {  %}
               <ul>
               {% for(var j = 0; j <  item.dataBean.listof_htmlfragments.length; j++) {  %}
                  <li><a href="javascript:void(0)" class='cmsCard_link2fullscreen' data-dmsurl='{%=item.dataBean.listof_htmlfragments[j].dataBean.propertyvalue%}'>{%=item.dataBean.listof_htmlfragments[j].dataBean.propertyname%}</a></li>
               {% }  %}
               </ul>
           {% }  %}
          </div> 
          {%
        } 
     }     
     else { %}
     <div class="cmsCard">
     Non Sono Presenti Report Tack Tracker.
     </div>
  {% }      %}   
</script>
                
</r3_lang:environment>