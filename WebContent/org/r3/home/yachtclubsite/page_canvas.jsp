<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3'>

<div class='r3_container' style='margin-top: 30px;'>

<!--
<div style='padding: 10px 10px 20px 10px; text-align: center; font-size: 24px; font-family: Arial,'Helvetica Neue',Helvetica,sans-serif !important; line-height: 1.05; font-weight: bold;'>
<div style='border: 1px solid #C90B0B; padding: 20px'>
<div style="color: #C90B0B; !important">
Informiamo che il Campionato Invernale riprende l'8 Gennaio 2023. <br />Buon Anno!
</div>
</div>
</div>
-->

<!-- style="color: #C90B0B #ff00FF;" style="color: #008080;" style="color: #333333;"
<div style='padding: 10px 10px 20px 10px; text-align: center; font-size: 24px; font-family: Arial,'Helvetica Neue',Helvetica,sans-serif !important; line-height: 1.05; font-weight: bold;'>
<div style='border: 1px solid #C90B0B; padding: 20px'>
<div style="color: #4040FF; !important">
<p>
INFORMIAMO CHE LA SEGRETERIA RIPRENDERA&rsquo; LA PIANA OPERATIVITA&rsquo; DAL 1&deg; SETTEMBRE <span style='color: #C90B0B'>NEL RISPETTO DELLE DISPOSIZIONI GOVERNATIVE COVID-19</span><br />
DURANTE IL MESE DI AGOSTO LE RICHIESTE E LE NECESSITA&rsquo; AVVERRANNO VIA E MAIL O TELEFONO<br />
A seguito dei recenti DPCM e ultime disposizioni della FIV tutte le regate in calendario sono differite a data da destinarsi.
Comunicheremo non appena possibile la ripresa delle attività sportiva.<br />

<span style="color: #C90B0B">Si informa che la segreteria dal 5 luglio al 31 agosto 2021 rimarr&agrave; chiusa al pubblico. <br />Richieste e necessita&#39; verranno gestite esclusivamente per via informatica.
</span>
</p>
</div>

</div>
</div>
-->

<!-- #300AAB
La Segreteria del Circolo Velico causa lavori di ristrutturazione della club house sar&agrave; chiuso da <b>mercoled&igrave; 9/12</b> fino a <span style='color: #C90B0B'><b>Gioved&igrave; 07/01</b></span>
<div style='color: #C90B0B !important;'>Anche il Sito del Circolo sar&agrave; oggetto di manutenzione durante le festivit&agrave;. Potrebbe non risultare raggiungibile nei giorni tra Natale e Capodanno. Poich&egrave; cambieranno diverse cose vi preghiamo di rientrare da http://www.cvfiumicino.it
e non utilizzare eventuali bookmark salvati. Vi preghiamo infine di segnalarci tempestivamente qualsiasi problema si possa manifestare in seguito a detto aggiornamento.
</div>
<div style='color: #058b7b; !important;'>Ci scusiamo per qualsiasi inconveniente e vi auguriamo Buone Feste!
</div>
-->




<div class="row">
<div class="col-md-3 hidden-sm hidden-xs">
<div id='JSPortlet_HomeChannelsActionForm' style='margin-bottom: 10px; background-color: #eeeeff; border: 1px solid #dddddd; display: none'></div>
</div>

<div class="col-md-5 col-sm-12">

<div class="box box-solid box-grade1 box-noborder">
  <div class="box-header ">
    <h3 class="box-title"><a href='cms/cmspage.do?pageid=regattas'>Regate</a></h3>
    <div class="box-tools pull-right">
       <a href='cms/cmspage.do?pageid=regattas' class="btn btn-box-tool" title="Vai alla Pagina">
            <i class="fa fa-chevron-circle-right"></i>
       </a>            
    </div>
  </div>
  <div class="box-body" id='homesailevent'>
 
  </div>
</div>

<div class="box box-solid box-grade2 box-noborder">
  <div class="box-header ">
    <h3 class="box-title"><a href='cms/cmspage.do?pageid=articles'>Articoli</a></h3>
    <div class="box-tools pull-right">
       <a href='cms/cmspage.do?pageid=articles' class="btn btn-box-tool" title="Vai alla Pagina">
            <i class="fa fa-chevron-circle-right"></i>
       </a>            
    </div>
  </div>
  <div class="box-body" id='homearticles'>
 
  </div>
</div>

<!-- 
  <div style='margin-bottom: 15px;'>  
   <h3 class='actionable grade1' style='margin-top: 0px'><a href='cms/cmspage.do?pageid=regattas'><i class="fa fa-file-o"></i> <span data-i18n='org.r3.home.yachtclubsite:regattas'>Regate</span></a></h3>  
  <div id='homesailevent' ></div>
  </div>

  <div style='margin-bottom: 15px;'>
  <h3 class='actionable grade2' style='margin-top: 0px'><a href='cms/cmspage.do?pageid=articles'><i class="fa fa-file-o"></i> <span data-i18n='org.r3.home.yachtclubsite:articoli'>Articoli</span></a></h3>  
  <div id='homearticles'></div>  
  </div>
-->

</div>

<div class="col-md-4 col-sm-12">

  <div class='row'>
  
  <!-- 
  <div class='col-md-12 col-sm-6 hidden-xs'>
  <a class="twitter-timeline" href="https://twitter.com/cvfiumicino" data-widget-id="483963506908069888">Tweets di @cvfiumicino</a>  
  </div>
  -->
  <div class='col-md-12 col-sm-6 col-xs-12'>  
  <a href="https://www.createevashop.com/pages/abbigliamento-vela">
  <img src="/r3ng/resources/img/emporia.gif" style="width: 100%; margin-bottom: 10px" />
  </a>
  </div>
  
  
  <div class='col-md-12 col-sm-6 col-xs-12'>  
  <a href="/r3ng/cvfonline/it/org/r3/cms/cmspage.do?pageid=webcam&cardid=00_METEO">
  <img src="/r3ng/resources/img/vedetta.png" style="width: 100%; margin-bottom: 10px" />
  </a>
  </div>
  
  <div class='col-md-12 col-sm-6 hidden-xs'>
  <div style='margin-bottom: 10px;'>
  <div class="fb-page" data-href="https://www.facebook.com/Circolo-Velico-Fiumicino-714928588568140/" data-tabs="timeline" data-width="500" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/Circolo-Velico-Fiumicino-714928588568140/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/Circolo-Velico-Fiumicino-714928588568140/">Circolo Velico Fiumicino</a></blockquote></div>
  </div>
  </div>

  <!-- 
  <div class='col-md-12 col-sm-6 hidden-xs'>
  <div id="JSPortlet_NewsLetterActionForm"></div>  
  </div>
  -->
  </div>
  
  <div class='row'>
  
  <div class='col-md-12 col-sm-6 col-xs-12'>      
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/gta2RHuYlGw" title="Invernali Live" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/vzShNkwfPh0" title="Invernali Live: intervista a Franco Quadrana" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/av7ZSd932Z8" title="Invernali Live: intervista a Massimo Pettirossi" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/2acLP67qYAE" title="Benvenuti al 41o Campionato" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/VviZHBVCx6o" title="Percorsi di regata" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
  <div style='position: relative; width: 100%; height: 0; padding-bottom: 56%; margin-bottom: 10px;'>
  <iframe style='position: absolute; width: 100%; height: 100%; left: 0; top: 0;' src="https://www.youtube.com/embed/MSZpr1llqL8" title="Il Tack Tracker" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  

  

  </div>
  </div>
  

  
</div>
</div>

<div class="box box-solid box-grade6 box-noborder">
  <div class="box-header ">
    <h3 class="box-title"><a href='cms/cmspage.do?pageid=articles'>Links</a></h3>
  </div>
  <div class="box-body" id="friendcarouselview">
 
  </div>
</div>


</div>
            
</r3_lang:environment>