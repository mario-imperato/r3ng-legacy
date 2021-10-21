<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">


<div class='cf' style='width: 960px; min-height: 500px; margin: 0 auto; background: none repeat scroll 0 0 rgba(255,255,255,0.5); padding: 10px;' >

<div id='cmsPageActionForm'>
<div  style="float:left; min-height: 300px; width: 200px; margin-right: 10px; padding: 0px; ">
<div class='cmsCard' style='min-height: 300px; border-right: 1px solid #aaaaaa'>
<div class="borderless d20170212-sidebar">
<img class="icons_180" src="/r3ng/resources/sites/<%=r3Env.getSiteresourcepath()%>/pages/genoa.png" />
<div class="cms_cardIndex"></div>
</div>
</div>

</div>

<div style="float:left; min-height: 100px; width: 740px; margin-right: 10px; padding: 0px;">
   <div class="cms_cardDetail" >
   <div class="cmsCard">
   <!--  <h3>Non sono presenti schede</h3>  -->
   </div>  
   </div>
</div>

<div class='cf'></div>
</div>

</div>
            
</r3_lang:environment>