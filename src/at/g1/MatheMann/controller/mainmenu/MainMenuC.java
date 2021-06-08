package at.g1.MatheMann.controller.mainmenu;

import at.g1.MatheMann.controller.signin.SignInC;
import at.g1.MatheMann.controller.signup.SignUpC;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MainMenuC {
    Button login_out_Btn;

    public static Stage stageMenu;
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/at/g1/MatheMann/view/mainMenu.fxml"));
            Parent root = fxmlLoader.load();

            stageMenu = stage;

            stageMenu.setTitle("MatheMann - Hauptmenü");
            stage.getIcons().add(new Image("/at/g1/MatheMann/ressources/icon.png"));
            stageMenu.setScene(new Scene(root));
            stageMenu.show();

            Clip clip;
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/at/g1/MatheMann/ressources/intro.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
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

    public void showLogIn_out_window(){
        try {
            SignInC.show(new Stage());
            stageMenu.close();
        }catch (Exception ex){
            System.out.println("Something went wring");
        }
    }

    @FXML
    private void next()
    {
        showLogIn_out_window();
    }


}
