package at.g1.MatheMann.model;

public class Question {
    private String value;
    private Answer[] answers = new Answer[4];

    public Question (String value, Answer answer1, Answer answer2, Answer answer3, Answer answer4)
    {
        this.value = value;
        this.answers[0] = answer1;
        this.answers[1] = answer2;
        this.answers[2] = answer3;
        this.answers[3] = answer4;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addAnswer(Answer answer)
    {
        for(int i = 0; i < this.answers.length; i++)
        {
            if(this.answers[i] == null)
            {
                this.answers[i] = answer;
                break;
            }
        }
    }

    public String getValue() {
        return value;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}
