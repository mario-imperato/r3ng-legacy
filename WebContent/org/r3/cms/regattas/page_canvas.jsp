<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<div class='r3_container' style='min-height: 500px; padding: 10px;' >

<div id='cmsPagedIndexActionForm' style='display: none'>
 
<div class="row">
<div class="col-md-3 hidden-sm hidden-xs">
    <div style='text-align: center'>
      <img src='/r3ng/resources/sites/<%=r3Env.getSiteresourcepath()%>/pages/regattas_calendar.png' style='width: 100%;' />
    </div>
    <div id="cms_cardRegattasCalendar" ></div> 
</div>

<div class="col-md-9 ">
     <div id='cmsPagedIndexActionForm_cardIndexCanvas'></div>
</div>
</div>
</div>

<div id='cmsPageDetailActionForm' style='display: none'></div>
</div>

<!-- 
<div  style="float:left; min-height: 300px; width: 280px; margin-right: 10px; padding: 0px; ">
   <div class='cmsCard' style='min-height: 300px; border-right: 1px solid #aaaaaa'>
      <div class="borderless d20170212-sidebar">  
         <img src='/r3ng/resources/sites/<%=r3Env.getSiteresourcepath()%>/pages/regattas_calendar.png' style='width: 100%; display: block' />
         <div id="cms_cardRegattasCalendar" ></div> 
      </div>
    </div>
</div>

<div style="float:left; min-height: 100px; width: 660px; margin-right: 10px; padding: 0px;">
    <div id='cmsPagedIndexActionForm_cardIndexCanvas'></div>
</div>
    
</div>

<div id='cmsPageDetailActionForm' style='display: none'></div>

<div class='cf'></div>

<div style="border-top: 1px solid #cccccc; margin-top: 20px">
  <div id="sponsorcarouselview"></div>
</div>

</div> -->
            
</r3_lang:environment>