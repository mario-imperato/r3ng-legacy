//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.jsportlet.sev.homequiz");

org.r3.jsportlet.sev.homequiz.QuizDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(aDataBean);
	 	   
	 	   this.numberOfOK = 0;
	 	   this.numberOfKO = 0;
	 	   this.numberOfRepaired = 0;
	 },
	 
	 isEmpty: function()
	 {
		 return false;
	 },
	 
	 getNumberOfQuestions: function()
	 {
		 return (this.dataBean && this.dataBean.questions && this.dataBean.questions.length) ? this.dataBean.questions.length : 0;
	 },
	 
	 getQuestion: function(qIndex)
	 {
		 return (this.dataBean && this.dataBean.questions && this.dataBean.questions.length && this.dataBean.questions.length > qIndex) 
		 		? this.dataBean.questions[qIndex] 
		 		: null;		 
	 },
	 
	 findCorrectAnswer: function(aQuestion)
	 {

		 for(var i = 0; i < aQuestion.answers.length; i++)
		 {
			 if (aQuestion.answers[i].valid)
			 {
				 return aQuestion.answers[i];
			 }

		 }
		 
		 return null;		 
	 },
	 
	 
	 findAnswer4: function(aQuestion, anAnswerId)
	 {
		 for(var i = 0; i < aQuestion.answers.length; i++)
		 {
			 if (aQuestion.answers[i].answerid == anAnswerId)
			 {
				 return aQuestion.answers[i];
			 }
		 }
		 
		 return null;
	 },
	 
	 getScore: function()
	 {
		 var score = 0;
		 
		 if (this.dataBean && this.dataBean.questions && this.dataBean.questions.length)
		 {
			 for(var i = 0; i < this.dataBean.questions.length; i++)
			 {
				 score += this.getQuestionScore(this.dataBean.questions[i]);
			 }
		 }
		 
		 return score;
	 },
	 
	 getQuestionScore: function(aQuestion)
	 {
		 if (aQuestion.selectedAnswerValid)
		 {
			 if (aQuestion.numberOfResponses == 1)
				 return this.findCorrectAnswer(aQuestion).weight || 0;
		 }
		 
		 return 0;
	 },
	 
	 getScoreComment: function()
	 {
		 var score = this.getScore();
		 if (this.dataBean.score_comment)
		 {
			 if (this.dataBean.score_comment.length)
			 {
				 for(var i = 0; i < this.dataBean.score_comment.length; i++)
				 {
					 if (score <= this.dataBean.score_comment[i].score_level)
						 return this.dataBean.score_comment[i].score_comment;
				 }
			 }
			 
			 return this.dataBean.score_comment;
		 }
		 
		 return "";
	 },
	 
	 getReportIconColumn: function(aQuestion)
	 {
		 var s = "";
		 
		 if (aQuestion.selectedAnswerValid)
		 {
			 if (aQuestion.numberOfResponses == 1)
			 {
				 s = "<td style='color: green'><i class='icon fa fa-thumbs-o-up'></i></td>";	
			 }
			 else
			 {
				 s = "<td style='color: orange'><i class='icon fa fa-thumbs-o-up'></i></td>";	
			 }
		 }
		 else
		 {
			 s = "<td style='color: red'><i class='icon fa fa-thumbs-o-down'></i></td>";		 
		 }
		 
		 return s;
	 }
	 
 
});

