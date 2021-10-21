//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizuserblockcollection");

org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_quizuserblockcollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.quizuserblocknumber = aDataBean.quizuserblocknumber || null;
       this.quizid = aDataBean.quizid || null;
       this.usersessionid = aDataBean.usersessionid || null;
       this.blocknumber = aDataBean.blocknumber || null;
       this.status = aDataBean.status || null;
       this.validfrom = aDataBean.validfrom || null;
       this.validto = aDataBean.validto || null;
       this.duration = aDataBean.duration || null;
       this.lateanswerpenalty = aDataBean.lateanswerpenalty || null;
       this.userstartdate = aDataBean.userstartdate || null;
       this.usertimer = aDataBean.usertimer || null;
       this.score = aDataBean.score || null;
       this.lastanswerdate = aDataBean.lastanswerdate || null;
       this.lastanswerquestion = aDataBean.lastanswerquestion || null;
       this.userlateanswerpenalty = aDataBean.userlateanswerpenalty || null;
       this.numberofquestions = aDataBean.numberofquestions || null;
       this.numberofanswered = aDataBean.numberofanswered || null;
       this.numberofok = aDataBean.numberofok || null;
       this.questions = aDataBean.questions || null;
       
       // Aggiunto
       this.questionsDTOs = aDataBean.questionsDTOs || null;
       
       if (this.questionsDTOs &&  this.questions && this.questionsDTOs.length &&  this.questions.length)
       {
       var reorderedQuestions = [];
       for(var i = 0; i < this.questions.length; i++)
       {
    	   for(var j = 0; j < this.questionsDTOs.length; j++)
    	   {
    		   if (this.questions[i] == this.questionsDTOs[j].questionid)
    			   reorderedQuestions.push(this.questionsDTOs[j]);
    	   }
       }       
       this.questionsDTOs = reorderedQuestions;	   
       }
       
	 }
       
});

