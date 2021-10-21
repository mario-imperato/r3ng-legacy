<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

{%
  if (!o.quizDto)
  {
%}    
<div class="box box-info">
	
	<div class="box-body">
	<div style="padding: 15%; background: url(/r3ng/org/r3/jsportlet/sev/homequiz/quizone_cvf.png); background-size: cover;">
	</div>
	
	<div class="alert  " >
				
				<h4 >
					<i class="icon fa fa-quora"></i> Quiz non Presente o non abilitato...
				</h4>
				<p style='text-align: center'>
				{%#org.r3.jsportlet.sev.homequiz.message.quiz_not_found%}
				</p>
			</div>
	</div>
</div>
{%  
  }
  else {
%}

<div class="box box-info quiz-start-section">
	<div class="box-body">
		<div
			style="padding: 15%; background: url(/r3ng/org/r3/jsportlet/sev/homequiz/quizone_cvf.png); background-size: cover;">
		</div>

		<div class="alert">
			<h4>
				<i class="icon fa fa-quora"></i> {%#o.quizDto.dataBean.title%}
			</h4>
			<p class="quiz-description">{%#o.quizDto.dataBean.description%}</p>

{% if (o.loginRequired) { %}
  <div style='margin-top: 10px'>
  <p>Per accedere al Quiz è necessario identificarsi al sito.</p>
  
  <ul>
  <li>Se NON si dispone di una utenza procedere con la <a style='color: #0099ff' href="registration/register.do#Registrazione">registrazione</a></li>
  <li>Successivamente alla ricezione della mail di conferma e dell'attivazione dell'utenza effettuare Log-In al sito nella sezione presente in questa pagina.</li>
  <li>Una volta identificati inserire eventualmente il numero di tessera FIV e procedere con la compilazione.</li>  
  </ul>
  </div>
{% } %}

{% if (o.membershipRequired) { %}
  <div style='margin-top: 10px'>
  <div id="entermembership_form_fieldset_message" ></div>
  
  <p>{%#org.r3.jsportlet.sev.homequiz.message.membershipid_required%}</p>
  
  <form id="membership_form" method="POST" class="form-horizontal">
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Numero Tessera FIV</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="membershipid" id="membership_form_membershipid" maxlength='10'/>
    </div>
  </div>
     
  </form>
  </div>			
{% } %}
			
			<div class="quiz-actions" style='text-align: right; margin-top: 10px'>	
			    <button class="btn btn-primary quiz-action-applymembership">Salva</button>		
				<button class="btn btn-success quiz-action-start">Inizia</button>
				<!-- <button class="btn btn-primary quiz-action-help"><i class="fa fa-question" aria-hidden="true"></i> Aiuto</button>  -->
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

{%  
  }
%}

