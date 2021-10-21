<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00"     prefix="r3_lang" %>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page language="java" session="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,    
    java.util.*,
    org.r3.db.system.site.SiteDTO  
    " %>

<r3_lang:environment id="r3Env">

<tiles:useAttribute id="windowLayout_cssprofile" ignore="true" name="windowLayout_cssprofile" classname="java.lang.String" />

<%
  SiteDTO targetSite = r3Env.getRequestSite();

  boolean gsidebarEnabled = true; // windowLayout_cssprofile!=null && windowLayout_cssprofile.equalsIgnoreCase("gsidebar-layout-cssprofile");

  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
  org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());

  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage()); 
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = null;  
  
  if (sitePages != null)
      listOfPages = sitePages.getPages();  
  
%>

  <!-- Logo -->
  <a href='<r3_lang:pathResolver path="/org/r3/home.do" />' class="logo">
    <!-- mini logo for sidebar mini 50x50 pixels -->
    <span class="logo-mini"><i class="fa fa-home "></i></span> <!-- <span class="logo-mini"><b>A</b>LT</span> -->
    <!-- logo for regular state and mobile devices -->
    <span class="logo-lg"><i class="fa fa-home "></i> <%=targetSite.getSitedescr()%></span>
  </a>
        
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      
      <!-- Sidebar toggle button-->
      <r3_lang:ifinclude include='<%=gsidebarEnabled%>'>
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      </r3_lang:ifinclude>
      
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
  <ul class='nav navbar-nav pull-right '>  
            
<%
  int numberOfAreasEnabled = 0;
  if (listOfPages != null)
  {
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
	
    if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_consolemenu, r3Env.isGuest()) && r3Env.checkFunction(pageDTO.getPermissions()))
    {
    	numberOfAreasEnabled++;
    	if (numberOfAreasEnabled == 1)
    	{
%>  
       <li role="presentation" class="dropdown">
         <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
         Aree Funzionali <span class="caret"></span>
         </a>
         <ul class="dropdown-menu"> 
<%    		
    	}
%>
        <li><a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />'><%=pageDTO.getPagetitle()%></a></li>
<%
    }
  }
  }
  
  if (numberOfAreasEnabled > 0)
	{
%>  </ul></li> <%    		
	}
	
%>      
          
               
          <r3_lang:ifinrole allowFunctions="console">
          <r3_lang:comment><li><a href='<r3_lang:pathResolver path="/org/r3/console/home.do" />'>Area Amministrativa</a></li></r3_lang:comment>
          </r3_lang:ifinrole>
                      
          <r3_lang:ifinclude include="<%=!r3Env.isGuest()%>">
          <r3_lang:comment><li><a href='<r3_lang:pathResolver path="/org/r3/user/myr3.do" />'>My R3</a></li></r3_lang:comment>
          <li><a href="javascript:void(0)" id="pageAction_console_logOut" ><i class="fa fa-user fa-1x pull-left"></i> Log-out (<%=r3Env.getUsername()%>)</a></li>                    
          </r3_lang:ifinclude>
          
          </ul>
    
      </div>
    </nav>
        
        <!--    
    <div id="breadcrumb_bar" class="hidden-print clearfix" style="display: none; width: 100%; background-color: #cccccc;">
    <div id="breadcrumbs">
    </div>
     </div>
     -->

</r3_lang:environment>
