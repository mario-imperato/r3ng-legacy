package org.r3.db.mongo.quiz;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

public class QuizQuestionDTO
{

	public QuizQuestionDTO()
	{
		// TODO Auto-generated constructor stub
	}

	//
	private java.lang.String questionid;

	public java.lang.String getQuestionid()
	{
		return questionid;
	}

	public void setQuestionid(java.lang.String p)
	{
		questionid = p;
	}

	//
	private java.lang.String text;

	public java.lang.String getText()
	{
		return text;
	}

	public void setText(java.lang.String p)
	{
		text = p;
	}

	//
//	private java.util.Date answerwhen;
//
//	public java.util.Date getAnswerwhen()
//	{
//		return answerwhen;
//	}
//
//	public void setAnswerwhen(java.util.Date p)
//	{
//		answerwhen = p;
//	}
//
//	//
//	private boolean answervalid;
//	
//	public boolean isAnswervalid()
//	{
//		return answervalid;
//	}
//
//	public void setAnswervalid(boolean answervalid)
//	{
//		this.answervalid = answervalid;
//	}
//
//	//
//	private int numberofretries;
//
//	public int getNumberofretries()
//	{
//		return numberofretries;
//	}
//
//	public void setNumberofretries(int p)
//	{
//		numberofretries = p;
//	}

	@Embedded
	private List<QuizAnswerDTO> answers;

	public List<QuizAnswerDTO> getAnswers()
	{
		return answers;
	}

	public void setAnswers(List<QuizAnswerDTO> p)
	{
		answers = p;
	}

	public void addAnswers(QuizAnswerDTO p)
	{
		if (answers == null)
			answers = new ArrayList<QuizAnswerDTO>();

		answers.add(p);
	}

}
