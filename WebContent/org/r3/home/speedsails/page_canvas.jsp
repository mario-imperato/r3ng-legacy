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

<div id='speedsails_canvas1'>

<div style='background: rgba(0, 0, 0, 0.3); float: left; width: 160px; font-size: 1.2em; padding-bottom: 5px; margin-bottom: 15px; height: 595px;  '>

<div id='site_logo'>
   <h4>SpeedSails <span style='color: #425aa2; font-style: italic'>STRUTTURE</span></h4>
</div>

<div style='padding-left: 10px; padding-top: 20px;'>
<h3 class="p1"><span>SpeedSails Roma</span></h3>
<p class="p1">Viale Traiano, 27<br />Fiumicino (RM) Italy<br />tel.- fax.06.65036236<br /><a href="mailto:info@speedsails.it"><span style='color: #2CAFEC'>info@speedsails.it</span> </a></p>
<h3 class="p1">SpeedSails Oricola</h3>
<p class="p1">Zona Industriale Miole <br />Oricola (AQ) Italy<br />tel. 0863.997155<br /><a href="mailto:veleria@speedsails.it"><span style='color: #2CAFEC'>veleria@speedsails.it</span></a> </p>
<h3 class="p1">Centri Assistenza</h3>
<p class="p1">Toscana: 328-3911010<br /> Friuli Venezia Giulia: 349-7827958<br /> Sardegna Nord: 329-3932816<br /> Sardegna Sud: 328-5653299</p>
<h3 class="p1">Denmark</h3>
<p class="p1">SYDSEJL Stjernehjulet 5, <br />DK-4760 Vordingborg<br />Phone (+45) 2047 8330 <br /><a href="mailto:sydsejl@mail.dk"><span style='color: #2CAFEC'>sydsejl@mail.dk</span></a><br /><a href="http://sydsejl.dk/"><span style='color: #2CAFEC'>http://sydsejl.dk/</span></a></p>
</div>

</div>

<div id='triangle-topleft'></div>
<div id='triangle-filler'></div>
<div id='triangle2'></div>

<div class="transparent_canvas">
<div id="iconic_menu_cnt" >

  <div class="iconic_menu" style='padding: 0; padding-left: 0px;'>
     <div id="iconic_menu_canvas" style='float: right' >
  
    <%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
	  if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_homemenu, r3Env.isGuest()) && r3Env.checkFunction(pageDTO.getPermissions()))
	  {
%>
        <div class="iconic_menu_item <%=pageDTO.getPagestyle()%>" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />' ><img src='<%=targetSite.getResourceAbslutePath(org.r3.db.system.site.SiteDTO.SiteResourceType.iconicmenu, pageDTO.getPageicon1())%>' alt="<%=pageDTO.getPagetitle()%>"  /></a>
          <div >
            <a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />' style='padding: 0; margin: 0'><p><%=pageDTO.getPagetitle()%></p></a>
          </div>          
        </div>
<%
	  }
  }
%>

                 
      </div>
     
      <div class="clearfix"></div>           
      
  </div>  
             
</div>
</div>

</div>

            
</r3_lang:environment>