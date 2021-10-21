//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizuseranswercollection");

org.r3.db.mongo.quiz.quizuseranswercollection.QuizUserAnswerCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_quizuseranswercollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.useranswerid = aDataBean.useranswerid || null;
       this.quizid = aDataBean.quizid || null;
       this.usersessionid = aDataBean.usersessionid || null;
       this.quizuserblocknumber = aDataBean.quizuserblocknumber || null;
       this.blocknumber = aDataBean.blocknumber || null;
       this.questionid = aDataBean.questionid || null;
       this.answerid = aDataBean.answerid || null;
       this.valid = aDataBean.valid || null;
       this.score = aDataBean.score || null;
       this.when = aDataBean.when || null;
       this.timeout = aDataBean.timeout || null;
	 }
       
});

