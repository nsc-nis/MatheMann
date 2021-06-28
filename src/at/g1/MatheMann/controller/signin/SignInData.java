package at.g1.MatheMann.controller.signin;

public class SignInData {
    public String username;
    private String password;
    private int score1;
    private int score2;
    private int score3;
    private int score4;

    public SignInData(String username, String password) {
        this.username = username;
        this.password = password;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
        this.score4 = 0;
    }

    public SignInData(String username, String password, int score1, int score2, int score3, int score4) {
        this.username = username;
        this.password = password;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    public void changeScore1(int score1) {
        this.score1 += score1;
    }

    public void changeScore2(int score2) {
        this.score2 += score2;
    }

    public void changeScore3(int score3) {
        this.score3 += score3;
    }

    public void changeScore4(int score4) {
        this.score4 += score4;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    public int getScore4() {
        return score4;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
