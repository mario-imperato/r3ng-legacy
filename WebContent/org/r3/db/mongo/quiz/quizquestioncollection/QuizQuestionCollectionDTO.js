//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizquestioncollection");

org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_quizquestioncollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.questionid = aDataBean.questionid || null;
       this.quizid = aDataBean.quizid || null;
       this.text = aDataBean.text || null;
       this.qlevel = aDataBean.qlevel || null;
       this.answers = aDataBean.answers || null;
	 }
       
});

 org.r3.db.mongo.quiz.quizquestioncollection.AnswersDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.answerid = aDataBean.answerid || null;
        this.text = aDataBean.text || null;
        this.valid = aDataBean.valid || null;
        this.weight = aDataBean.weight || null;
	 }	   
 });   
  
