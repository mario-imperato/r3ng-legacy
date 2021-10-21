//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.quiz.quizcollection");

org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTO(aDataBean));       
	 },
	 
	 getScoreComment: function(score)
	 {
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
	 
	 isOpaque: function()
	 {
		 return !(this.dataBean && this.dataBean.mode == 'clear');
	 }
       
});




