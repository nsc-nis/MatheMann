package at.g1.MatheMann.controller.signin;

import at.g1.MatheMann.controller.mainmenu.MainMenuC;
import at.g1.MatheMann.controller.signup.SignUpC;
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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
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

            stage.setTitle("Wilkommen bei MatheMann");
            stage.getIcons().add(new Image("/at/g1/MatheMann/ressources/icon.png"));
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        } catch (Exception exception)
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

    public void compare(){

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        try {
            for (int i = 0; i < SignIn.getSize(); i++)
            {
                String correctUsername = SignIn.getNameOfUser(i);
                String correctPassword = SignIn.getPasswordOfUser(i);

                if (username.equals(correctUsername) && password.equals(correctPassword))
                {
                    MainMenuC.show(new Stage());

                    Clip clip;
                    AudioInputStream audioInputStream;
                    audioInputStream = AudioSystem.getAudioInputStream(new File("src/at/g1/MatheMann/ressources/intro.wav").getAbsoluteFile());
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();

                    stage.close();
                    return;
                }
            }
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

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Falsche Anmeldedaten");
        alert.setContentText("Dein Benutzername oder Passwort ist falsch! Versuch's nochmal!");
        alert.setResizable(true);
        alert.showAndWait();
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
        SignUpC.show(new Stage());
    }
}
