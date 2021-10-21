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
%>

<div id='speedsails_canvas1'>

<div style='background: rgba(0, 0, 0, 0.3); float: left; width: 160px; font-size: 1.2em; padding-bottom: 5px; margin-bottom: 15px; height: 482px; padding-left: 10px; padding-right: 10px; '>
<h3 class="p1"><span>SpeedSails Roma</span></h3>
<p class="p1">Viale Traiano, 27<br />Fiumicino (RM) Italy<br />tel.- fax.06.65036236<br />email: <a href="mailto:info@speedsails.it">info@speedsails.it </a></p>
<h3 class="p1">SpeedSails Oricola</h3>
<p class="p1">Zona Industriale Miole <br />Oricola (AQ) Italy<br />tel. 0863.997155<br />email: <a href="mailto:veleria@speedsails.it">veleria@speedsails.it </a> </p>
<h3 class="p1">Centri Assistenza</h3>
<p class="p1">Toscana: 328-3911010<br /> Friuli Venezia Giulia: 349-7827958<br /> Sardegna Nord: 329-3932816<br /> Sardegna Sud: 328-5653299</p>
<h3 class="p1">Denmark</h3>
<p class="p1">SYDSEJL Stjernehjulet 5, <br />DK-4760 Vordingborg<br />Phone (+45) 2047 8330 <br />E-mail: <a href="mailto:sydsejl@mail.dk">sydsejl@mail.dk</a><br />Web Site: <a href="http://sydsejl.dk/">http://sydsejl.dk/</a></p>
</div>

<div id='triangle-topleft'></div>
<div id='triangle-filler'></div>
<div id='triangle2'></div>

<div class="transparent_canvas">
<div id="iconic_menu_cnt" >

  <div class="iconic_menu" style='padding: 0; padding-left: 0px;'>
     <div id="iconic_menu_canvas" style='float: right' >
  
        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=veleria" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/veleria.jpg" alt="La Veleria"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=veleria" />' style='padding: 0; margin: 0'><p>La Veleria</p></a>
          </div>          
        </div>
        
        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=genoa" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/genoa.jpg" alt="Genoa"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=genoa" />' style='padding: 0; margin: 0'><p>Genoa</p></a>
          </div>          
        </div>
        
        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=mainsail" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/rande.jpg" alt="Rande"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=mainsail" />' style='padding: 0; margin: 0'><p>Rande</p></a>
          </div>          
        </div>

        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=spi" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/spi.jpg" alt="Vele Portanti"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=spi" />' style='padding: 0; margin: 0'><p>Vele Portanti</p></a>
          </div>          
        </div>

        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=derive" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/derive.jpg" alt="Derive e Monotipi"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=derive" />' style='padding: 0; margin: 0'><p>Derive e Monotipi</p></a>
          </div>          
        </div>

        <div class="iconic_menu_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=accessories" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/accessori.jpg" alt="Accessori"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=accessories" />' style='padding: 0; margin: 0'><p>Accessori</p></a>
          </div>          
        </div>
                 
      </div>
     
      <div class="clearfix"></div>           
      
  </div>  
             
</div>
</div>

</div>

<div id='site_logo'>
   <h4>SpeedSails <span style='color: #425aa2; font-style: italic'>STRUTTURE</span></h4>
   <!-- <p>Il Circolo Velico Fiumicino e' un'associazione sportiva senza fini di lucro basata su principi di solidarieta' ed aggregazione nello sviluppo delle attivita' veliche e degli sport nautici.</p>
   -->
</div>

            
</r3_lang:environment>