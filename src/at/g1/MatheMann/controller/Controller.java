package at.g1.MatheMann.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.media.*;
import javafx.stage.Stage;

/**
 * MatheMann - Controller
 * @author Niklas Schachl
 * @version: 1.0, 25.5.2021
 */
public class Controller
{
    private Stage stage;

    public Controller()
    {

    }

    /**
     * Opens the stage and shows the window
     * @param stage The stage is given to the controller by the main-Class
     */
    public static void show(Stage stage)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("/at/g1/MatheMann/view/view.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            Controller ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.setTitle("MatheMann");
            stage.getIcons().add(new Image("/at/g1/MatheMann/ressources/icon.png"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception exception)
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

    /**
     * Plays a sound when the answer was correct
     */
    private void playSound()
    {
        String ressource_sound = "/at/g1/MatheMann/ressources/sound.mp3";
        Media sound = new Media(ressource_sound);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
