//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuseranswercollection;

import org.r3.db.MongoPersistenceContext;

public class QuizUserAnswerCollectionPersistence extends QuizUserAnswerCollectionPersistenceBase
{
  public static QuizUserAnswerCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
  {
      QuizUserAnswerCollectionPersistence p = new QuizUserAnswerCollectionPersistence();
      return p;
  }    
}


