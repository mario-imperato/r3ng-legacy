<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>

<script id="template-homeportlet-quiz-question" type="text/x-tmpl">
  			    	
<h3 style='margin-top: 10px' class='quiz-question-title'>Domanda N.{%#o.questionIndex+1%}</h3>
<p class='quiz-question-text'>{%#o.question.text%}</p>

<form>
	<div class="form-group">
{%
	for(var i = 0; i < o.question.answers.length; i++)
	{
%}		
		<div class="radio">
			<label><input type="radio" name="quiz-question-answer" class='quiz-question-answer-text' value="{%#o.question.answers[i].answerid%}"> {%#o.question.answers[i].text%}</label>
		</div>
{%		
	}
%}	
				
	</div>
</form>
</script>

<script id="template-homeportlet-quiz-report" type="text/x-tmpl">
<table class='table'>
{%
	for(var i = 0; i < o.quizblockdto.dataBean.questionsDTOs.length; i++)
	{
%}	
	<tr>
		<td>{%#i+1%}</td>
		<td>{%#o.quizblockdto.dataBean.questionsDTOs[i].text%}</td>
		{%#o.quizblockdto.getReportIconColumn(o.quizblockdto.dataBean.questionsDTOs[i])%}
	</tr>
{%		
	}
%}	
</table>
</script>
