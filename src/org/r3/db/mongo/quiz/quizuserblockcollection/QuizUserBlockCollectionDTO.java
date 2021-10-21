//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.quiz.quizuserblockcollection;

import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizUserBlockCollectionName = "r3_quizuserblockcollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbQuizUserBlockCollectionName, noClassnameStored = true)
public class QuizUserBlockCollectionDTO extends QuizUserBlockCollectionDTOBase
{
	public enum BlockStatusType {
		unknown, ready, started, timeout, closed;
		
		public static BlockStatusType getBlockStatusType4(String s, BlockStatusType aDefaultValue)
		{
			BlockStatusType b = aDefaultValue;
			
			if (s != null && !s.isEmpty())
			{
				try
				{
					b = BlockStatusType.valueOf(s);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}			
			}
			
			return b;
		}
	}
	public QuizUserBlockCollectionDTO()
	{
		super();
	}

	public QuizUserBlockCollectionDTO clearSensitiveInformation()
	{
		this.questions = null;

		return this;
	}

	private List<QuizQuestionCollectionDTO> questionsDTOs;

	public List<QuizQuestionCollectionDTO> getQuestionsDTOs()
	{
		return questionsDTOs;
	}

	public void setQuestionsDTOs(List<QuizQuestionCollectionDTO> questionsDTOs)
	{
		this.questionsDTOs = questionsDTOs;
	}

	@JsonIgnore
	public int getNumberOfQuestions()
	{
		return questions != null ? questions.size() : 0;
	}

	@JsonIgnore
	public int findIndexOfFirstUnansweredQuestion()
	{
		if (getNumberOfQuestions() > 0)
		{
			if (getLastanswerquestion() != null)
			{
				for (int i = 0; i < questions.size(); i++)
				{
					if (getLastanswerquestion().equalsIgnoreCase(questions.get(i)))
					{						
						return (i + 1) < questions.size() ? i + 1 : -1;
					}
				}
			}
			else return 0;
		}

		return -1;
	}
	
	@JsonIgnore
	public String findFirstUnansweredQuestionId()
	{
		int ndx = findIndexOfFirstUnansweredQuestion();
		return (ndx >= 0) ? questions.get(ndx) : null;
	}
	
	@JsonIgnore
	public boolean isReady()
	{
		return BlockStatusType.getBlockStatusType4(getStatus(), BlockStatusType.unknown) == BlockStatusType.ready;
	}
	
	@JsonIgnore
	public boolean isStarted()
	{
		return BlockStatusType.getBlockStatusType4(getStatus(), BlockStatusType.unknown) == BlockStatusType.started;
	}
	
	@JsonIgnore
	public boolean isClosed()
	{
		return BlockStatusType.getBlockStatusType4(getStatus(), BlockStatusType.unknown) == BlockStatusType.closed;
	}
	
	@JsonIgnore
	public boolean isEarlyBird()
	{
		return validfrom.after(new java.util.Date());
	}

	@JsonIgnore
	public boolean isTimeout()
	{
		return BlockStatusType.getBlockStatusType4(getStatus(), BlockStatusType.unknown) == BlockStatusType.timeout;
	}
	
	public boolean isTimeout(long userTimer)
	{
		return userTimer > duration;
	}

	public long computeUserTimer(java.util.Date nowDate)
	{
		if (userstartdate != null)
		{
			return (nowDate.getTime() - getUserstartdate().getTime()) / 1000;
		}
		
		return -1;
	}
	
	public boolean isLastQuestion(String questionId)
	{
		if (questions != null && !questions.isEmpty())
		{
			if (questionId.equalsIgnoreCase(questions.get(questions.size() - 1)))
				return true;
		}
		
		return false;
	}
}
