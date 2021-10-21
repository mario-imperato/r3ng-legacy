//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizuserblockcollection");

org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO(aDataBean)); 
	   this.numberOfOK = 0;
	   this.numberOfKO = 0;
	   this.numberOfRepaired = 0;
	 },
	 
	 getValidfrom: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.validfrom);
	 },
	 
	 getValidto: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.validto);
	 },
	 
	 isEmpty: function()
	 {
		 return !this.dataBean.questionsDTOs || !this.dataBean.questionsDTOs.length ;
	 },
	 
	 getBlockSize: function()
	 {
		 return (this.dataBean && this.dataBean.numberofquestions);
	 },
	 
	 getNumberOfQuestions: function()
	 {
		 return (this.dataBean && this.dataBean.questions && this.dataBean.questions.length) ? this.dataBean.questions.length : 0;
	 },
	 
	 getQuestion: function(qIndex)
	 {
		 return (this.dataBean && this.dataBean.questionsDTOs && this.dataBean.questionsDTOs.length && this.dataBean.questionsDTOs.length > qIndex) 
		 		? this.dataBean.questionsDTOs[qIndex] 
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
		 
		 if (this.dataBean && this.dataBean.questionsDTOs && this.dataBean.questionsDTOs.length)
		 {
			 for(var i = 0; i < this.dataBean.questionsDTOs.length; i++)
			 {
				 score += this.getQuestionScore(this.dataBean.questionsDTOs[i]);
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
	 },
	 
	 getUserTimer: function()
	 {
		 if (this.dataBean.userstartdate)
	     {
			 var now = Date.now();
	 	     var millis = now - this.dataBean.userstartdate;
	         return Math.floor(millis/1000);		 
		 }
		 
		 return 0;
	 },
	 
	 isLate: function()
	 {
		 var now = Date.now();
		 
		 if (this.dataBean.lateanswerpenalty)
		 {
			 if (this.dataBean.userlateanswerpenalty || 
				 ((this.dataBean.status == 'ready' || this.dataBean.status == 'started') && (now - this.dataBean.validto) > 0))
				 return true;
		 }
		 
		 return false;
	 },
	 
     getUserBlockStatusAsSemaphore: function()
     {
    	 var semaphoreColor = 'gray';
    	 if (this.isLate())
    		 semaphoreColor = 'red';
		 
    	 return $.r3Utils.formatSemaphore(semaphoreColor);
     },
	 
	 canBeStarted: function()
	 {
		 return this.dataBean && (this.dataBean.status == 'ready' || this.dataBean.status == 'started');
	 }
	 
       
});




