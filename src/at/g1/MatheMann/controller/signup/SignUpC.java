package at.g1.MatheMann.controller.signup;


import at.g1.MatheMann.controller.signin.SignIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/at/g1/MatheMann/view/signUp.fxml"));
            Parent root = fxmlLoader.load();

            stageOne = stage;

            stageOne.setTitle("Sign Up");
            stage.getIcons().add(new Image("/at/g1/MatheMann/ressources/icon.png"));
            stageOne.setScene(new Scene(root, 400, 400));
            stageOne.show();
        }
        catch(Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public void newUser()
    {
        String name = textUsername.getText();
        String password = textPassword.getText();
        String reenter = textReenter.getText();

        if(password.equals(reenter)){
            SignIn.addUser(name, password);
            SignIn.setUser();
            stageOne.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erfolgreich!");
            alert.setContentText("Dein Account wurde erfolgreich erstellt!");
            alert.setResizable(true);
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passwörter ungleich!");
            alert.setContentText("Deine Passwörter stimmen nicht überein! Versuch's nochmal!");
            alert.setResizable(true);
            alert.showAndWait();
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
