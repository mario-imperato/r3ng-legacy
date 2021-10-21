<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>



<div class="box box-info quiz-end-section" style='display: none'>

	<div class="box-body">
				
		<div style="padding: 15%; background: url(/r3ng/org/r3/jsportlet/sev/homequiz/quizone_cvf.png); background-size: cover;">
		</div>
					
		<div class='quiz-result' style='display: none'>

			 <div class="alert quiz-score" style='border-color: #aaa'>				
				<h4 >
					<i class="icon fa fa-mortar-board"></i> Punteggio <span class='quiz-score-value'></span>
				</h4>
				<p class='quiz-score-description'></p>
			</div>

		<div class="alert">
			<div class="quiz-actions" style='text-align: right; margin-top: 10px'>			
				<button class="btn btn-primary quiz-action-end">Termina</button>
			</div>
		</div>


	</div>
</div>
</div>

<div class="box box-info quiz-question-section" >
	<div class="box-header with-border">
		<h3 class="box-title"><i class="icon fa fa-quora"></i> {%#o.quizDto.dataBean.title%}</h3>
	</div>
	<div class="box-body">

		<div style='margin: 1%'>
		<div class="quiz-timer">
			<div class="quiz-timer-display">
				<span class="quiz-timer-display-data"></span> 
				<i class="fa fa-clock-o" aria-hidden="true"></i>
			</div>
		</div>

		<div class="clearfix quiz-counters">

			<div class="quiz-info-box">
				<span class="quiz-info-box-icon bg-aqua"><i	class="fa fa-question-circle-o"></i></span>
				<div class="quiz-info-box-content"><span class="quiz-info-box-numberofquestions">0/0</span></div>
			</div>


		</div>

		<div class="quiz-question">

		</div>
		</div>
		</div>
		
		<div class="box-footer">
					
			<div class="alert  quiz-question-timedout-feedback" style='border-color: red; display: none'>
				
				<h4 class='text-red'>
					<i class="icon fa fa-clock-o"></i> Tempo Scaduto
				</h4>
				<p>Il tempo assegnato per il quiz &egrave; scaduto.</p>
			</div>
									
			<div class='quiz-actions' style='text-align: right'>
				<button class="btn btn-primary quiz-action-answer">Rispondi</button>
				<button class="btn btn-primary quiz-action-next" style="display:none">Continua</button>
				<button class="btn btn-primary quiz-action-help"><i class="fa fa-question" aria-hidden="true"></i> Aiuto</button>
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

		</table>
		
		
		 
	</div>

	<div class="box-footer">
						
			<div class='quiz-actions' style='text-align: right'>
				<button class="btn btn-primary quiz-action-closehelp">Indietro</button>
			</div>

		</div>
			
</div>
</div>


