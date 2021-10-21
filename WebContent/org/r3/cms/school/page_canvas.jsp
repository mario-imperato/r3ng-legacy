<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<div class='r3_container' style='min-height: 500px; padding: 10px;' >

<div id='cmsPageActionForm' >
 
<div class="row">
<div class="col-md-3 cmsCard">
 <div style='text-align: center'>
 <img class="icons_180" src="/r3ng/resources/sites/<%=r3Env.getSiteresourcepath()%>/pages/sailschool.png" /> 
 </div>
 <div class="cms_cardIndex"></div> 
</div>

<div class="col-md-9 ">
   <div class="cms_cardDetail" >
   <div class="cmsCard"></div>
   </div>
</div>
</div>
</div>

<div id='cmsPageDetailActionForm' style='display: none'></div>
</div>
            
</r3_lang:environment>