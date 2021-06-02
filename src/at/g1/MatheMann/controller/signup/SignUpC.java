package at.g1.MatheMann.controller.signup;


import at.g1.MatheMann.controller.signin.SignIn;
import at.g1.MatheMann.controller.signin.SignInData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpC implements Initializable {

    @FXML
    private TextField textUsername;
    @FXML
    private PasswordField textPassword;
    @FXML
    private PasswordField textReenter;

    public static Stage stageOne;
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/at/g1/MatheMann/view/overview.fxml"));
            Parent root = fxmlLoader.load();

            stageOne = stage;

            stageOne.setTitle("Sign Up");
            stageOne.setScene(new Scene(root, 400, 400));
            stageOne.show();
        }
        catch(Exception e)
        {
            System.err.println("Something wrong with overview.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    public boolean newUser(){
        String name = textUsername.getText();
        String password = textPassword.getText();
        String reenter = textReenter.getText();
        if(password.equals(reenter)){
            SignIn.dataList.add(new SignInData(name, password));

            //System.out.println(SignIn.dataList.get(1).getUsername());
            //System.out.println(SignIn.dataList.get(1).getPassword());
            System.out.println("Navigation started ...");
            stageOne.close();
            return true;
        }
        else{
            System.err.println("Password does not match! Try again.");
            return false;
        }
    }

    @FXML
    private void next()
    {
        newUser();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
