//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizquestioncollection");

org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTO(aDataBean));       
	 }
       
});




