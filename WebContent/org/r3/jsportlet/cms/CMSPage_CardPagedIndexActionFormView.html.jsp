<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
<div class='cmsCard' style='min-height: 300px; padding: 0px;'>

<div class="cms_pagination_container clearfix" style="padding: 5px; border-bottom: 1px solid #cccccc">
<nav>
  <ul class="pager">
    <li class="previous"><a href="#" id='cms_pagination_action_prev'><span aria-hidden="true">&larr;</span> Pag. Precedente</a></li>
    <li class="next"><a href="#" id='cms_pagination_action_next'>Pag. Successiva <span aria-hidden="true">&rarr;</span></a></li>
  </ul>
</nav>

<div class="cms_pagination_info">Record visualizzati da 1 a 14 di 14</div>
</div>
 
<div class="cms_cardIndex"></div>
</div>
  