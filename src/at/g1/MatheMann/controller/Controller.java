package at.g1.MatheMann.controller;

import at.g1.MatheMann.model.Answer;
import at.g1.MatheMann.model.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ResourceBundle;

/**
 * MatheMann - Controller
 * @author Simon Sperr
 * @version: 1.0, 1.6.2021
 */
public class Controller implements Initializable
{
    private Stage stage;

    private ArrayList<Question> class1;
    private ArrayList<Question> class2;
    private ArrayList<Question> class3;
    private ArrayList<Question> class4;

    @FXML
    private TextField text_score;
    @FXML
    private Button button_settings;
    @FXML
    private TextArea text_questions;
    @FXML
    private RadioButton button_1;
    @FXML
    private RadioButton button_2;
    @FXML
    private RadioButton button_3;
    @FXML
    private RadioButton button_4;
    @FXML
    private Button button_next;

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
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("/at/g1/MatheMann/view/game.fxml"));
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
    private static void playSound() throws NullPointerException, LineUnavailableException, IOException, UnsupportedAudioFileException
    {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        class1 = importQuestions("questions/Klasse1.csv");
        class2 = importQuestions("questions/Klasse2.csv");
        class3 = importQuestions("questions/Klasse3.csv");
        class4 = importQuestions("questions/Klasse4.csv");
    }

    @FXML
    private void action_settings()
    {

    }

    @FXML
    private void action_next()
    {

    }

    @FXML
    private void action_answer()
    {

    }

    /**
     *
     * @param filename The Name of the save File that has to be imported
     * @return An Arraylist of all Questions contained in the File
     */
    private ArrayList<Question> importQuestions(String filename)
    {
        ArrayList<Question> questions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String q = br.readLine();
            if(q.equals("Question SaveFile 1.0"))
            {
                while ((q = br.readLine()) != null)
                {
                    String split[] = q.split(";");
                    questions.add(new Question(split[0], new Answer(split[1], Boolean.parseBoolean(split[2])), new Answer(split[3], Boolean.parseBoolean(split[4])), new Answer(split[5], Boolean.parseBoolean(split[6])), new Answer(split[7], Boolean.parseBoolean(split[8]))));
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Laden!");
        }
        return questions;
    }
}
