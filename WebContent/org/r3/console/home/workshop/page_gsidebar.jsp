<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.home.workshop'>
  
  <!-- sidebar: style can be found in sidebar.less -->
  <section class="sidebar"> <!-- Sidebar Menu -->
  <ul class="sidebar-menu">
  <!-- 
  <li class="header">HEADER</li> 
  -->
  <li >
   <a href="contacts.do"><i class="fa fa-users  "></i><span> <r3_lang:string resourceId="gmenubar_actors" /></span></a>
  </li>
  
  <li>
     <a href="cms/cards.do"><i class="fa fa-edit  "></i> <span><r3_lang:string resourceId="gmenubar_cms" /></span></a>
  </li>

  <li >
     <a href="bbs.do"><i class="fa fa-comment-o  "></i> <span><r3_lang:string resourceId="gmenubar_bbs" /></span></a>
  </li>

  <li>
     <a href="wbs.do"><i class="fa fa-list-ul  "></i> <span><r3_lang:string resourceId="gmenubar_wbs" /></span></a>
  </li>

  <li>
     <a href="tow.do"><i class="fa fa-tasks "></i> <span><r3_lang:string resourceId="gmenubar_tow" /></span></a>
  </li>
  
  <li>
     <a href="resources.do"><i class="fa fa-user-times  "></i> <span><r3_lang:string resourceId="gmenubar_resource" /></span></a>
  </li>
  
  <li>
     <a href="siteconfig.do"><i class="fa fa-cog  "></i> <span><r3_lang:string resourceId="gmenubar_config" /></span></a>
  </li>
  
  <li>
     <a href="users.do"><i class="fa fa-users  "></i> <span><r3_lang:string resourceId="gmenubar_users" /></span></a>
  </li>
<!-- 
      <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Link</span></a></li>
      <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
      <li class="treeview">
        <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span> <i class="fa fa-angle-left pull-right"></i></a>
        <ul class="treeview-menu">
          <li><a href="#">Link in level 2</a></li>
          <li><a href="#">Link in level 2</a></li>
        </ul>
      </li>
      -->
    </ul><!-- /.sidebar-menu -->
  </section>
  <!-- /.sidebar -->
   
  <!--      
  <div id='gsidebar-nav' class='gsidebar-nav csshoverenabled'>
  <ul class="sidebar-nav nav-pills nav-stacked" id="gsidebar-menu">

  <li >
   <a href="contacts.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-users fa-stack-1x "></i></span><span class='menuitem-title'><r3_lang:string resourceId="gmenubar_actors" /></span></a>
  </li>
  
  <li>
     <a href="cms/cards.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-edit fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_cms" /></a>
  </li>

  <li >
     <a href="bbs.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-comment-o fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_bbs" /></a>
  </li>

  <li>
     <a href="wbs.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-list-ul fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_wbs" /></a>
  </li>

  <li>
     <a href="tow.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-tasks fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_tow" /></a>
  </li>
  
  <li>
     <a href="resources.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-user-times fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_resource" /></a>
  </li>
  
  <li>
     <a href="siteconfig.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-cog fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_config" /></a>
  </li>
  
  <li>
     <a href="users.do"><span class="fa-stack fa-lg pull-left"><i class="fa fa-users fa-stack-1x "></i></span><r3_lang:string resourceId="gmenubar_users" /></a>
  </li>
       
           </ul>
</div>
 -->
 
</r3_lang:environment>        