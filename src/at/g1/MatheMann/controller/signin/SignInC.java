package at.g1.MatheMann.controller.signin;

import at.g1.MatheMann.controller.signup.SignUpC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInC implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    private Stage stage;

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignInC.class.getResource("/at/g1/MatheMann/view/signIn.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            SignInC ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.setTitle("Welcome");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        } catch (IOException e){
            System.err.println("Something wrong with firstV.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    public boolean compare(){

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        /*try {
            for (int i = 0; i < SignIn.getSize(); i++) {
                String correctUsername = SignIn.getNameOfUser(i);
                String correctPassword = SignIn.getPasswordOfUser(i);

                if (username.equals(correctUsername) && password.equals(correctPassword)){
                    System.out.println("Navigation started ...");
                    MagicBallC.show(new Stage(), "Hello from Fist Stage");
                    stage.close();
                    return true;
            }
                else {
                    System.err.println("Password or Username incorrect!");
                }
            }
        }

        catch(Exception e){
            System.err.println("error");
        }*/
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SignIn.setUser();
    }

    @FXML
    private void next()
    {
        compare();
    }

    @FXML
    private void signUp(){
        System.out.println("Navigation started ...");
        SignUpC.show(new Stage());
    }
}
