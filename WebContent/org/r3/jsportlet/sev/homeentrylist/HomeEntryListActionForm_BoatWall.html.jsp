<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div class="box box-solid box-primary">
  <div class="box-header with-border">
    <h3 class="box-title">Lista Iscritti</h3>
    <div class="box-tools pull-right">
       <a href='javascript:void(0)' id="homeentrylistactionform_action_goto_entrylist"  class="btn btn-box-tool" title="Vai alla Pagina">
            <i class="fa fa-chevron-circle-right"></i>
       </a>            
    </div>
  </div>
  <div class="box-body">
{%  if (o.apps.getNumberOfItems() > 0) 
    {
       %} <div class='homeentrylist_boatwall clearfix' style="width: 100%"> {%

       for (var i = 0; i < o.apps.getNumberOfItems(); i++) {  
           
           var theItem = o.apps.getItem(i);
           var iconTitle = theItem.getEscapedYachtTitle();
           
           if (theItem.hasBoatImage()) { %}         
               <div class="boatIcon"><a href='{%=theItem.getBoatImageUrl()%}' rel="lightbox-homeentrylist"  title='{%=iconTitle%}' ><img src='{%=theItem.getBoatIconUrl()%}' border='0' style="margin-top: {%=theItem.getBoatIconMarginTop()%}px;" /></a></div>
        {% } 
            
       }
              
       %} </div> {%
    } %}
  </div>
</div>

