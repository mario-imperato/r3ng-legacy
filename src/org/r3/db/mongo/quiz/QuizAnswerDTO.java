package org.r3.db.mongo.quiz;

public class QuizAnswerDTO
{
	public QuizAnswerDTO()
	{

	}

	//
	private java.lang.String answerid;

	public java.lang.String getAnswerid()
	{
		return answerid;
	}

	public void setAnswerid(java.lang.String p)
	{
		answerid = p;
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
	private boolean valid;

	public boolean isValid()
	{
		return valid;
	}

	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	//
	private int weight;

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int p)
	{
		weight = p;
	}

}
