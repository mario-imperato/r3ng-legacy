<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
  
  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
       org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());
  
  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage());
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = sitePages.getPages();
%>
  
  <!-- Fixed navbar -->
  <nav class="navbar navbar-inverse navbar-fixed-top " >
      <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            <!-- Tende a sfondare.. 
            <a class="navbar-brand" href="#"><%=targetSite.getSitedescr()%></a>
             -->
             
          </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class='nav navbar-nav'>  
<%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
    if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_txtmenu, r3Env.isGuest())  && r3Env.checkFunction(pageDTO.getPermissions()))
    {
%>
        <li><a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />'><%=pageDTO.getPagetitle()%></a></li>  
<%
    }
  }
%>    
          </ul>
  
        </div><!--/.nav-collapse -->
      </div>
  </nav>

  <div id="homecarouselview" style="border-bottom: 5px solid #7A94AB;"></div>
    
  <!--     
  <div class="html_carousel">
      <div id="foo2">
           
          <div class="slide">
              <img src="/r3ng/org/r3/home/yachtclubsite/banner_002_bw.jpg" alt="carousel 1" width="1690" height="524" />
              <div>
                 <div class='slide-caption' >
                  <h4>Circolo Velico Fiumicino</h4>
                  <p>Il Circolo Velico Fiumicino e' un'associazione sportiva senza fini di lucro basata su principi di solidarieta' ed aggregazione nello sviluppo delle attivita' veliche e degli sport nautici.</p>
                 </div>
              </div>
          </div>

          <div class="slide">
              <img src="/r3ng/org/r3/home/yachtclubsite/banner_001.jpg" alt="carousel 1" width="1690" height="524" />
              <div>
                 <div class='slide-caption'>
                  <h4>Circolo Velico Fiumicino</h4>
                  <p>Il Circolo Velico Fiumicino e' un'associazione sportiva senza fini di lucro basata su principi di solidarieta' ed aggregazione nello sviluppo delle attivita' veliche e degli sport nautici.</p>
                 </div>
              </div>
          </div>
      </div>
      <div class="clearfix"></div>
  </div>

   -->    
          
              
</r3_lang:environment>