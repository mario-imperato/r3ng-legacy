<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.home.site'>
  
  <section class="sidebar">
  <ul class="sidebar-menu">
   <!-- 
  <li class="header">HEADER</li> 
  -->
  <li >
   <a href="sev/applications.do"><i class="fa fa-edit  "></i><span ><r3_lang:string resourceId="gmenubar_sevapp" /></span></a>
  </li>
  
  <li >
   <a href="contacts.do"><i class="fa fa-users  "></i><span ><r3_lang:string resourceId="gmenubar_actors" /></span></a>
  </li>
  
  <li>
     <a href="sev/ranking.do"><i class="fa fa-list-ol  "></i><span><r3_lang:string resourceId="gmenubar_sevrank" /></span></a>
  </li>
  
  <li>
     <a href="cms/cards.do"><i class="fa fa-edit  "></i><span><r3_lang:string resourceId="gmenubar_cms" /></span></a>
  </li>

  <li >
     <a href="bbs.do"><i class="fa fa-comment-o  "></i><span><r3_lang:string resourceId="gmenubar_bbs" /></span></a>
  </li>

  <li>
     <a href="wbs.do"><i class="fa fa-list-ul  "></i><span><r3_lang:string resourceId="gmenubar_wbs" /></span></a>
  </li>

  <li>
     <a href="tow.do"><i class="fa fa-tasks  "></i><span><r3_lang:string resourceId="gmenubar_tow" /></span></a>
  </li>
  
  <li>
     <a href="resources.do"><i class="fa fa-user-times  "></i><span><r3_lang:string resourceId="gmenubar_resource" /></span></a>
  </li>
  
  <li>
     <a href="siteconfig.do"><i class="fa fa-cog  "></i><span><r3_lang:string resourceId="gmenubar_config" /></span></a>
  </li>
  
  <r3_lang:ifinrole allowFunctions="consoleext">

  <li>
     <a href="users.do"><i class="fa fa-users  "></i><span><r3_lang:string resourceId="gmenubar_users" /></span></a>
  </li>
  
  <li>
     <a href="system/resturls.do"><i class="fa fa-wrench  "></i><span>Rest URLs</span></a>
  </li>
  
  </r3_lang:ifinrole>

   </ul>
   </section>
   

</r3_lang:environment>        