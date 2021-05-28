package at.g1.MatheMann.controller;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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

            Clip clip;
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/at/g1/MatheMann/ressources/intro.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
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
    private static void playSound() throws NullPointerException, LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
        /*

        URL file = Controller.class.getResource("/at/g1/MatheMann/view/sound.mp3");
        final Media media = new Media(file.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        */

        Clip clip;
        AudioInputStream audioInputStream;

        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File("src/at/g1/MatheMann/ressources/sound.wav").getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);
        clip.loop(1);
    }
}
