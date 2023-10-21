<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id="JSPortlet_SEVApplicationActionForm" style='min-height: 500px; padding: 10px;' >

<div class="row">
<div class="col-md-2 cmsCard">

<div id="HLP_SEVBOATINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none;">
  <h2>Aiuto rapido</h2>
  <p class="text">
  Il modulo di iscrizione &egrave; abbastanza articolato. Ti preghiamo di compilare tutte le informazioni nella maniera
  più fedele possibile.
  </p>  
  
  <h3>Bozze</h3>
  <p class="text">
  La compilazione pu&ograve; essere interrotta in qualsiasi momento. L'iscrizione rimarr&agrave; in stato 'bozza' e 
  la compilazione potr&agrave; essere ripresa in una fase successiva. 
  </p>
</div>

<div id="HLP_SEVCLASSINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>

  <h3>Certificati</h3>
  <p class="text">
  Indicare il tipo di certificato di stazza in corso di validità con il quale si intende gareggiare.
  In caso di IRC/ORC è possibile/necessario specificare entrambi i certificati nel caso siano previste classifiche separate.  
  </p>  

  <h3>Assicurazione</h3>
  <p class="text">
  E' necessario specificare che la propria Assicurazione copra il caso 'Regata': alcune Assicurazioni includono questa copertura 
  nella polizza base mentre altre prevedono una gestione separata. Ti preghiamo quindi di verificare con la tua Compagnia.
  </p>
  
  <h3>Pubblciità</h3>
  <p class="text">
  Nel caso tu esponga della pubblicità ti ricordiamo che devi allegare alla domanda o portare in segreteria la copia della licenza FIV corrispondente.
  </p>      
</div>

<div id="HLP_SEVOWNERINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>
  <p class="text">
  Ti preghiamo di inserire i tuoi dati per poter essere contattato più facilmente.
  </p>  
  
  <h3>Timoniere</h3>
  <p class="text">
  Nel caso in cui tu non timoni la tua imbarcazione ma il ruolo sia assegnato a persona diversa ti preghiamo di 
  indicare riferimenti e generalità
  </p>
</div>

<div id="HLP_SEVCREWINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>
  
  <h3>Quando posso compilare la lista equipaggio?</h3>
  <p class="text">
  Gli utenti hanno la possibilità di compilare la lista equipaggio anche successivamente all'inoltro della domanda.
  Molto spesso capita infatti di iscrivere la barca quando ancora non sappiamo chi sar&agrave; a bordo.
  Mi raccomando: compila la lista fedelmente per evitare inconvenienti e fallo prima della regata!
  </p>  
</div>

<div id="HLP_COVIDINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>
  
  <h3>Debbo compilare le certificazioni Covid?</h3>
  <p class="text">
  In questo periodo estremamente difficile chiediamo a tutti la massima responsabilità nel garantire la sicurezza propria e altrui e 
  permettere a tutti quanti di godere il mare nella maniera più sana. 
  Mi raccomando: compila la lista fedelmente per evitare inconvenienti e fallo prima della regata!
  </p>  
</div>

<div id="HLP_SEVAUTHORINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>

  <p class="text">
  Le liberatorie contenute in questa pagina riguardano i vari aspetti della partecipazione all'evento. Preghiamo di prendere visione dei vari aspetti e, 
  se possibile, concederci il vostro consenso. In caso di dubbi preghiamo di contattare la segreteria.        
  </p>  
</div>

<div id="HLP_SEVATTSHEET" class="cmsCard actionForm sidebar applicationactionform_helpsidebar" style="display: none; margin-top: 0; padding: 5px;">
  <h2>Aiuto rapido</h2>

  <p class="text">
  Il foglio presenza aiuta il CdR nel suo lavoro.In ogni giornata di regata l'armatore e' chiamato a compilare due dichiarazioni: la prima riguarda la presenza della barca in regata, la seconda
  riguarda l'assunzione di responsabilità per la regolarità della lista equipaggio. Il pannello permette di valorizzare le dichiarazioni relative alla sola giornata successiva. Non sarà possibile modificare tali dichiaraizoni successivamente.       
  </p>  
</div>

<div id="HLP_SEVDOCINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>
  
  <h3>Che documenti posso allegare?</h3>
  <p class="text">
  Puoi allegare i documenti che ritieni debbano essere visionati. Per motivi di classificazione ti preghiamo di 
  valorizzare il campo a tendina con la tipologia del documento per aiutarci a distinguerli.
  </p>  

  <h3>In che formato debbono essere i documenti?</h3>
  <p class="text">
  I documenti debbono essere in formato Adobe Acrobat PDF; l'immagine che si vuole associare alla barca deve essere invece in formato immagine, ovvero jpeg, png oppure gif.
  </p>  

  <h3>Quale è la dimensione massima dei documenti?</h3>
  <p class="text">
  I documenti non debbono eccedere la dimensione massima di 1MB. 
  </p>  
   
</div>

<div id="HLP_SEVPAYINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>
  
  <h3>Come posso pagare?</h3>
  <p class="text">
  Il pagamento va effettuato direttamente in Segreteria oppure attraverso 
  uno dei meccanismi indicati nella pagina.
  </p>  
</div>

<div id="HLP_SEVSUMMARYINFO" class="cmsCard actionForm  applicationactionform_helpsidebar" style="display: none; ">
  <h2>Aiuto rapido</h2>

  <h3>Come confermo la domanda?</h3>
  <p class="text">
  E' possibile confermare la domanda semplicemente attivando l'apposito pulsante e rispondere positivamente alla richiesta di conferma.
  Prima di farlo ti raccomandiamo di visualizzare il modulo in maniera da verificare che il sistema abbia recepito correttamente i dati inseriti.
  </p>
</div>

</div>

<div class="col-md-10 ">

<div id="JSPortlet_SEVApplicationActionForm_wizardnavigator" class="actionForm"  ></div>
   
<div id="JSPortlet_SEVApplicationActionForm_BoatInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_ClassInfoActionForm" class="actionForm" style="display: none"></div>
   
<div id="JSPortlet_SEVApplicationActionForm_OwnerInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_CrewInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_UploadCrewInfoFileActionForm" class="actionForm" style="display: none">
</div>

<div id="JSPortlet_SEVApplicationActionForm_AttendanceSheetActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_AuthorInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_DocInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_UploadFileActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_PayInfoActionForm" class="actionForm" style="display: none"></div>

<div id="JSPortlet_SEVApplicationActionForm_SummaryInfoActionForm" class="actionForm" style="display: none"></div>
   
</div>
</div>
</div>
