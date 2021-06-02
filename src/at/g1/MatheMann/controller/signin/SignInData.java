package at.g1.MatheMann.controller.signin;

public class SignInData {
    public String username;
    private String password;

    public SignInData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
