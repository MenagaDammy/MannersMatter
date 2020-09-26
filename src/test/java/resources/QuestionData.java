package resources;

import pojo.QuestionDetails;

public class QuestionData {
	
	QuestionDetails quesDetails = new QuestionDetails();
	
	public QuestionDetails getQuesDetails(String chapter, String questions, String choices, String goldAnswer, String silverAnswer, String bronzeAnswer)
	{
		quesDetails.setChapter(chapter);
		quesDetails.setQuestions(questions);
		quesDetails.setChoices(choices);
		quesDetails.setGoldAnswer(goldAnswer);
		quesDetails.setSilverAnswer(silverAnswer);
		quesDetails.setBronzeAnswer(bronzeAnswer);

		return quesDetails;
	}
}
