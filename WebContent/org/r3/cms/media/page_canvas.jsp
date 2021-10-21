<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">


<div class='cf' style='width: 960px; min-height: 500px; margin: 0 auto; background: none repeat scroll 0 0 rgba(255,255,255,0.5); padding: 10px;' >

<div id='cmsPagedIndexActionForm' style='display: none'>
<!-- 
 <div style="background-color: #274E90; height: 50px; white-space: nowrap; text-align: right; margin-bottom: 10px;"><img src='/r3ng/resources/sites/cvfonline/pages/articles_headline.png' style='height: 50px;'/></div>
 -->
 
<div  style="float:left; min-height: 300px; width: 200px; margin-right: 10px; padding: 0px; ">
   <div class='cmsCard' style='min-height: 300px; border-right: 1px solid #aaaaaa'>
      <div class="borderless sidebar"> 
        <img class="icons_180" src="/r3ng/resources/sites/<%=r3Env.getSiteresourcepath()%>/pages/media.png" />
        <div id="cms_pageIndex"></div>       
      </div>
    </div>
</div>

<div style="float:left; min-height: 100px; width: 740px; margin-right: 10px; padding: 0px;">
    <div id='cmsPagedIndexActionForm_cardIndexCanvas'></div>
</div>
    
</div>

<div id='cmsPageDetailActionForm' style='display: none'></div>

<div class='cf'></div>

<!-- BOF Sezione Sponsor -->
<div style="border-top: 1px solid #cccccc; margin-top: 20px">
  <div id="sponsorcarouselview"></div>
</div>
<!-- EOF Sezione Sponsor -->

</div>
            
</r3_lang:environment>