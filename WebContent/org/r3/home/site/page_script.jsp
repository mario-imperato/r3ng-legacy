<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary_pt.json" ifLanguage="pt" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/home/site/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/home/site/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homelogin/HomeLoginActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homelogin/HomeLoginActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homelogin/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/messages.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTO.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/db/agenda/agendaentry/AgendaEntryQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/agenda/agendaentry/AgendaEntryDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/agenda/agendaentry/AgendaEntryDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/JSPortletFactory.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/HomeQuizActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormEnterView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormSessionsView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormQAOpaqueView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/QuizDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homequiz/membership_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizcollection/QuizCollectionDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizcollection/QuizCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizcollection/QuizCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizcollection/QuizCollectionQueryActionFormView.js" /> 

  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizuserblockcollection/QuizUserBlockCollectionDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizuserblockcollection/QuizUserBlockCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizuserblockcollection/QuizUserBlockCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizuserblockcollection/QuizUserBlockCollectionQueryActionFormView.js" /> 

  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizquestioncollection/QuizQuestionCollectionDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizquestioncollection/QuizQuestionCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizquestioncollection/QuizQuestionCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/quiz/quizquestioncollection/QuizQuestionCollectionQueryActionFormView.js" /> 
      
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecalendar/HomeCalendarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecalendar/HomeCalendarActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homenorlist/HomeNORActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homenorlist/HomeNORActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecard/HomeCardActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecard/HomeCardActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecomunicati/HomeComunicatiActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homecomunicati/HomeComunicatiActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/hometracker/HomeTrackerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/hometracker/HomeTrackerActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeranking/HomeRankingActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeranking/HomeRankingActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeyachtclub/HomeYachtClubActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeyachtclub/HomeYachtClubActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeiconmenu/HomeIconMenuActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeiconmenu/HomeIconMenuActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/hometwitter/HomeTwitterActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/hometwitter/HomeTwitterActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homefacebook/HomeFaceBookActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homefacebook/HomeFaceBookActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/flowplayer/FlowPlayerPortletActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/flowplayer/FlowPlayerPortletActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages_pt.json"  ifLanguage="pt" />

  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSQueryActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary_pt.json" ifLanguage='pt' /> 

  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTO.js" />
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/MyWbsesPortletActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/MyWbsesPortletActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/messages_pt.json" ifLanguage="pt" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/mytodolist/MyWbsNodesToDoListPortletActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/mytodolist/MyWbsNodesToDoListPortletActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/mytodolist/messages.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/mytodolist/messages_pt.json" ifLanguage="pt" /> 
  
  <script type="text/javascript">
  $(document).ready(function()
  {
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.home.site.PageManager.init();
        org.r3.PageManager.closeNotifier();
      },

      error : function()
      {
        org.r3.PageManager.error("org.r3.message.initializationerror");
      },

      verifyIdentity : true
    });
  });
  </script>   

</r3_lang:environment>
      