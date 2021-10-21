<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="image-decorated-sidebar  hidden-xs" >
<div class='row'>
<div class="col-md-12" >
{% 
   for (var i = 0; i < o.numberOfIcons; i++) {    
      var iconNumber = o.startIcon + i;
   %}
   <img src="/r3ng/resources/img/photo_icons/{%=o.collection%}/icon_180/hicon_00{%=iconNumber%}.jpg" style='margin-bottom: 5px' />

{% } %}
</div>
</div>
</div>    