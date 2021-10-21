<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<div class="box box-info quiz-sessions-section">
	<div class="box-header">
		<div
			style="padding: 15%; background: url(/r3ng/org/r3/jsportlet/sev/homequiz/quizone_cvf.png); background-size: cover;">
		</div>

		<div style='padding: 0 15px'>
			<h4>
				<i class="icon fa fa-quora"></i> {%#o.quizDto.dataBean.title%}
			</h4>
			<p class="quiz-description">{%#o.quizDto.dataBean.description%}</p>
		</div>
	</div>
	<div class="box-body">
{%
  if (!o.quizUserBlocks || o.quizUserBlocks.getNumberOfItems() == 0)
  { %}
  <div style='padding: 0 15px; color: red'>
  <h3 style='margin-top: 0px;'>Attenzione</h3>
  <p>Non sono attualmente disponibili le sessioni di compilazione. Il QuizOne non è ancora disponibile.</p>
  </div>
{% }
  else
  {
%}    
<table class='table quiz-sessions'>
{%
    var scoreTotal = 0;
    var penaltyTotal = 0;
	for (var i = 0; i < o.quizUserBlocks.getNumberOfItems(); i++)
	{
	    var theItem = o.quizUserBlocks.getItem(i); 	    
	    var trClass = "userblock";
	    
	    scoreTotal = scoreTotal + (theItem.dataBean.score || 0);
	    penaltyTotal = penaltyTotal + (theItem.dataBean.userlateanswerpenalty || 0);
	    if (theItem.dataBean.status == 'ready' || theItem.dataBean.status == 'started')
	    	var trClass = "editableuserblock";
%}	
	<tr class='{%=trClass%}' data-userblockid="{%#theItem.dataBean.quizuserblocknumber%}">
        <td>{%#theItem.getUserBlockStatusAsSemaphore()%}</td>		
		<td>{%#theItem.dataBean.blocknumber%}</td>
		<td>{%#theItem.dataBean.status%}</td>		
		<td>{%#theItem.getValidto()%}</td>
		<td>{%#theItem.dataBean.numberofquestions || "0"%}/{%#theItem.dataBean.numberofanswered || "0"%}</td>
		<td>{%#theItem.dataBean.score || "0"%}/(<span style='color: red'>{%#theItem.dataBean.userlateanswerpenalty || "0"%}</span>)</td>
	</tr>
{%		
	}
%}	

	<tr >
        <td><b>Punteggio</b></td>		
		<td><b>{%#scoreTotal%}</b></td>
		<td><b><span style='color: red'>{%#penaltyTotal%}</span></b></td>		
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>

{%  
  }
%}
	</div>
	<div class="box-footer">
		<div style='padding: 15px'>
			<div class="quiz-actions" style='text-align: right; margin-top: 10px'>			
				<button class="btn btn-primary quiz-action-help"><i class="fa fa-question" aria-hidden="true"></i> Aiuto</button>
			</div>
		</div>
	</div>
</div>


<div class="box box-info quiz-help-section" style='display: none'>

	<div class="box-body">
		<div
			style="padding: 15%; background: url(/r3ng/org/r3/jsportlet/sev/homequiz/quizone_cvf.png); background-size: cover;">
		</div>

		<div class="alert  ">
		<h4><i class="icon fa fa-quora"></i>Legenda</h4>
		
		<table class='table'>
		<tr><td><i class="fa fa-clock-o" aria-hidden="true"></i></td><td>Contatore per misurazione del tempo di compilazione.</td></tr>
		<tr><td><span class="quiz-info-box-icon bg-aqua" style='padding: 3px'><i class="fa fa-question-circle-o"></i></span></td><td>Numero totale delle domande nella sessione di compilazione / Numero delle domande rimanenti in caso la compilazione sia fatta in più fasi</td></tr>

        <!-- 
		<tr><td><span class="quiz-info-box-icon bg-green" style='padding: 3px'><i class="fa fa-thumbs-o-up"></i></span></td><td>Numero totale delle risposte corrette</td></tr>		
		<tr><td><span class="quiz-info-box-icon bg-yellow" style='padding: 3px'><i class="fa fa-thumbs-o-up"></i></span></td><td>Numero totale delle risposte corrette al secondo tentativo (*)</td></tr>		
		<tr><td><span class="quiz-info-box-icon bg-red" style='padding: 3px'><i class="fa fa-thumbs-o-down"></i></span></td><td>Numero totale delle risposte errate</td></tr>
		-->
		 
		</table>
				
		<!-- 		
		<p>(*) Ad ogni domanda &egrave; possibile dare un massimo di due risposte. Al secondo errore il sistema mostra la risposta corretta.</p>
		 -->
		 
		</div>


	<div class="box-footer">
						
			<div class='quiz-actions' style='text-align: right'>
				<button class="btn btn-primary quiz-action-closehelp">Indietro</button>
			</div>

		</div>
			
</div>
</div>



