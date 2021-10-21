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
<div class="col-md-4 hidden-sm hidden-xs">
 <div id="newsletterSubscriptionActionForm" ></div> 
    <div> 
     <h2>Edizioni NewsLetter</h2>                 
    <div id="cms_newsletterCardIndex">Non sono presenti documenti</div>
 </div>
</div>

<div class="col-md-8 ">
     <div id='cmsPagedIndexActionForm_cardIndexCanvas'></div>
</div>
</div>
</div>

<div id='cmsPageDetailActionForm' style='display: none'></div>
</div>

<!-- <div class='cf' style='width: 960px; min-height: 500px; margin: 0 auto; background: none repeat scroll 0 0 rgba(255,255,255,0.5); padding: 10px;' > -->

<!-- <div id='cmsPagedIndexActionForm' style='display: none'> -->
<!-- <!--  -->
<!--  <div style="background-color: #274E90; height: 50px; white-space: nowrap; text-align: right; margin-bottom: 10px;"><img src='/r3ng/resources/sites/cvfonline/pages/articles_headline.png' style='height: 50px;'/></div> -->
<!--  -->
 
<!-- <div  style="float:left; min-height: 300px; width: 280px; margin-right: 10px; padding: 0px; "> -->
<!--    <div class='cmsCard' style='min-height: 300px; border-right: 1px solid #aaaaaa'> -->
<!--       <div class="borderless sidebar">   -->
<!--          <div id="newsletterSubscriptionActionForm" ></div>  -->
<!--          <div>  -->
<!--          <h3>Edizioni NewsLetter</h3>                  -->
<!--          <div id="cms_newsletterCardIndex">Non sono presenti documenti</div> -->
<!--          </div> -->
<!--       </div> -->
<!--     </div> -->
<!-- </div> -->

<!-- <div style="float:left; min-height: 100px; width: 660px; margin-right: 10px; padding: 0px;"> -->
<!--     <div id='cmsPagedIndexActionForm_cardIndexCanvas'></div> -->
<!-- </div> -->
    
<!-- </div> -->

<!-- <div id='cmsPageDetailActionForm' style='display: none'></div> -->

<!-- <div class='cf'></div> -->

<!-- <div style="border-top: 1px solid #cccccc; margin-top: 20px"> -->
<!--   <div id="sponsorcarouselview"></div> -->
<!-- </div> -->

            
</r3_lang:environment>