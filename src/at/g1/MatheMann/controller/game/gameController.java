package at.g1.MatheMann.controller.game;

import at.g1.MatheMann.controller.mainmenu.MainMenuC;
import at.g1.MatheMann.model.Answer;
import at.g1.MatheMann.model.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * MatheMann - Controller
 * @author Simon Sperr
 * @version: 1.0, 1.6.2021
 * @author Niklas Schachl
 * @version: 1.1, 15.6.2021
 */
public class gameController implements Initializable
{
    private Stage stage;

    private ArrayList<Question> questions_class1;
    private ArrayList<Question> questions_class2;
    private ArrayList<Question> questions_class3;
    private ArrayList<Question> questions_class4;

    private String button_1_answer;
    private String button_2_answer;
    private String button_3_answer;
    private String button_4_answer;

    private int active_class;

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
    @FXMLSperr
    private RadioButton button_4;
    @FXML
    private Button button_next;

    public gameController()
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
            FXMLLoader fxmlLoader = new FXMLLoader(gameController.class.getResource("/at/g1/MatheMann/view/game.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            gameController ctrl = fxmlLoader.getController();
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
        questions_class1 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse1.csv");
        questions_class2 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse2.csv");
        questions_class3 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse3.csv");
        questions_class4 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse4.csv");

        button_settings.setGraphic(new ImageView(new Image("/at/g1/MatheMann/ressources/options.png")));
    }

    @FXML
    private void action_settings()
    {
        MainMenuC.show(new Stage());
        stage.close();
    }

    @FXML
    private void action_next()
    {

    }

    @FXML
    private void action_answer1()
    {
        check_answer(button_1_answer);
    }

    @FXML
    private void action_answer2()
    {
        check_answer(button_2_answer);
    }

    @FXML
    private void action_answer3()
    {
        check_answer(button_3_answer);
    }

    @FXML
    private void action_answer4()
    {
        check_answer(button_4_answer);
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

    private void initialize_class(int class_number)
    {
        active_class = class_number;
    }

    private void check_answer(String answer)
    {
        boolean isRight;
        switch (active_class) {
            case 1 -> isRight = check_answer_right(answer, questions_class1);
            case 2 -> isRight = check_answer_right(answer, questions_class2);
            case 3 -> isRight = check_answer_right(answer, questions_class3);
            case 4 -> isRight = check_answer_right(answer, questions_class4);
        }

        if(isRight)
        {
            
        }
    }

    private boolean check_answer_right(String answer, ArrayList<Question> questions)
    {
        for (Question question : questions)
        {
            if (question.getAnswer().getValue().equals(answer) && question.getAnswer().isRight())
                return true;
        }
        return false;
    }
}
