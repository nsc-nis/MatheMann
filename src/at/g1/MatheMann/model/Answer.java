package at.g1.MatheMann.model;

public class Answer {
    private String value;
    private boolean right;

    public Answer(String value, boolean right)
    {
        this.value = value;
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public boolean isRight() {
        return right;
    }
}
