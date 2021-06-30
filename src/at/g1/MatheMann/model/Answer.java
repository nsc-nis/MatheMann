package at.g1.MatheMann.model;

/**
 * Answers belong to Questions and can be right
 */
public class Answer {
    private final String value;
    private final boolean right;

    /**
     * Creates an Answer with its text and wheter it is right or not
     * @param value is the text of the Answer
     * @param right if true the Answer is right, if false the Answer is wrong
     */
    public Answer(String value, boolean right)
    {
        this.value = value;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    /**
     * Checks if the Answer is right
     * @return true if right false if wrong
     */
    public boolean isRight()
    {
        return right;
    }
}
