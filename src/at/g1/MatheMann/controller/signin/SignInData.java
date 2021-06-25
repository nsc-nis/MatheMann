package at.g1.MatheMann.controller.signin;

public class SignInData {
    public String username;
    private String password;
    private int score1;
    private int score2;
    private int score3;
    private int score4;

    public SignInData(String username, String password, int score1, int score2, int score3, int score4) {
        this.username = username;
        this.password = password;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score1 = score4;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
