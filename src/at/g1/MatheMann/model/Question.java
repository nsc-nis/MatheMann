package at.g1.MatheMann.model;

/**
 * A Question has a Text and 4 possible Answers
 */
public class Question {
    private String value;
    private Answer[] answers = new Answer[4];
    int i = 0;

    /**
     * Creates a Question with 4 possible Answers
     * @param value sets the Text of the Question
     * @param answer1 first possible Answer to the Question
     * @param answer2 second possible Answer to the Question
     * @param answer3 third possible Answer to the Question
     * @param answer4 fourth possible Answer to the Question
     */
    public Question (String value, Answer answer1, Answer answer2, Answer answer3, Answer answer4)
    {
        this.value = value;
        this.answers[0] = answer1;
        this.answers[1] = answer2;
        this.answers[2] = answer3;
        this.answers[3] = answer4;
    }

    /**
     * sets the Text of the Question
     * @param value Question text
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Tries to add an Answer to the Question
     * @param answer The Answer to add to the Question
     * @return True if the Answer could be added, False if the Question already has its 4 Answers
     */
    public boolean addAnswer(Answer answer)
    {
        boolean wasAdded = false;
        for(int i = 0; i < this.answers.length; i++)
        {
            if(this.answers[i] == null)
            {
                this.answers[i] = answer;
                wasAdded = true;
                break;
            }
        }
        return wasAdded;
    }

    /**
     * Returns the Question text
     * @return Question text
     */
    public String getValue() {
        return value;
    }

    /**
     * Gives all possible answers to the Question
     * @return an Array of 4 answers
     */
    public Answer[] getAnswers() {
        return answers;
    }

    public Answer getAnswer()
    {
        if(i > 4)
            i = 0;

        return answers[i];
    }
}
