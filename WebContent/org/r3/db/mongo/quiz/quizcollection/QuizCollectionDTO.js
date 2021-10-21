//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizcollection");

org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_quizcollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.quizid = aDataBean.quizid || null;
       this.mode = aDataBean.mode || null;
       this.useweight = aDataBean.useweight || null;
       this.title = aDataBean.title || null;
       this.description = aDataBean.description || null;
       this.score_comment = aDataBean.score_comment || null;
       this.quizblocks = aDataBean.quizblocks || null;
       this.questions = aDataBean.questions || null;
	 }
       
});

 org.r3.db.mongo.quiz.quizcollection.Score_commentDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.score_level = aDataBean.score_level || null;
        this.score_comment = aDataBean.score_comment || null;
	 }	   
 });   
  
 org.r3.db.mongo.quiz.quizcollection.QuizblocksDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.blocknumber = aDataBean.blocknumber || null;
        this.lateanswerpenalty = aDataBean.lateanswerpenalty || null;
        this.size = aDataBean.size || null;
        this.duration = aDataBean.duration || null;
        this.validfrom = aDataBean.validfrom || null;
        this.validto = aDataBean.validto || null;
	 }	   
 });   
  
