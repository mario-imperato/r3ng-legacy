<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
<div class="row">
<div class="col-md-3 cmsCard">
 <div style='text-align: center'>
 <img class="icons_180" src="{%=o.pageDTOAdapter.getPageIcon2Url()%}" /> 
 </div>
 <div class="cms_cardIndex"></div> 
</div>

<div class="col-md-9 ">
   <div class="cms_cardDetail" >
   <div class="cmsCard"></div>
   </div>
</div>
</div>
  
  
