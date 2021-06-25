package at.g1.MatheMann.controller.game;

import at.g1.MatheMann.controller.mainmenu.MainMenuC;
import at.g1.MatheMann.main.Main;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * MatheMann - Controller
 * @author Simon Sperr
 * @version: 1.0, 1.6.2021
 * @author Niklas Schachl
 * @version: 1.2, 22.6.2021
 */
public class gameController implements Initializable
{
    private Stage stage;

    private  ArrayList<Question> questions_class1;
    private  ArrayList<Question> questions_class2;
    private  ArrayList<Question> questions_class3;
    private  ArrayList<Question> questions_class4;

    private  String button_1_answer;
    private  String button_2_answer;
    private  String button_3_answer;
    private  String button_4_answer;

    private static int active_class = 1;
    private int active_question = 0;

    @FXML
    private TextField text_score;
    @FXML
    private Button button_settings;
    @FXML
    private TextArea text_questions;
    @FXML
    private Button button_1;
    @FXML
    private Button button_2;
    @FXML
    private Button button_3;
    @FXML
    private Button button_4;
    @FXML
    private Button button_next;

    public gameController()
    {

    }

    /**
     * Opens the stage and shows the window
     * @param stage The stage is given to the controller by the main-Class
     */
    public static void show(Stage stage, int class_number)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(gameController.class.getResource("/at/g1/MatheMann/view/game.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            gameController ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            initialize_class(class_number);
            active_class = class_number;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        questions_class1 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse1.csv");
        questions_class2 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse2.csv");
        questions_class3 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse3.csv");
        questions_class4 = importQuestions("src/at/g1/MatheMann/ressources/questions/Klasse4.csv");

        button_settings.setGraphic(new ImageView(new Image("/at/g1/MatheMann/ressources/options.png")));
        button_1.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_frame1.png')");
        button_2.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_frame1.png')");
        button_3.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_frame1.png')");
        button_4.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_frame1.png')");

        loadQuestion();
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
        ArrayList<Question> currentQuestion;
        switch (active_class)
        {
            case 1 -> currentQuestion = questions_class1;
            case 2 -> currentQuestion = questions_class2;
            case 3 -> currentQuestion = questions_class3;
            case 4 -> currentQuestion = questions_class4;
            default -> throw new IllegalStateException("Unexpected value: " + active_class);
        }

        if (active_question < currentQuestion.size())
        {
            loadQuestion();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Geschafft!");
            alert.setContentText(String.format("Geschafft! Du hast alle Fragen der %d.Klasse erledigt!", active_class));
            alert.setResizable(true);
            alert.showAndWait();
            MainMenuC.show(new Stage());
            stage.close();
        }
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
                    String[] split = q.split(";");
                    questions.add(new Question(split[0], new Answer(split[1], Boolean.parseBoolean(split[2])), new Answer(split[3], Boolean.parseBoolean(split[4])), new Answer(split[5], Boolean.parseBoolean(split[6])), new Answer(split[7], Boolean.parseBoolean(split[8]))));
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Laden!");
        }
        return questions;
    }

    private static void initialize_class(int class_number)
    {
        active_class = class_number;
    }

    private void check_answer(String answer)
    {
        boolean isRight;
        switch (active_class)
        {
            case 1 -> isRight = check_answer_right(answer, questions_class1.get(active_question-1));
            case 2 -> isRight = check_answer_right(answer, questions_class2.get(active_question-1));
            case 3 -> isRight = check_answer_right(answer, questions_class3.get(active_question-1));
            case 4 -> isRight = check_answer_right(answer, questions_class4.get(active_question-1));
            default -> throw new IllegalStateException("Unexpected value: " + active_class);
        }

        if(isRight)
        {
            try
            {
                Clip clip;
                AudioInputStream audioInputStream;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/at/g1/MatheMann/ressources/sound.wav").getAbsoluteFile());
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Antwort korrekt");
                alert.setContentText("Deine Antwort ist richtig!");
                alert.setResizable(true);
                alert.showAndWait();
                action_next();
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
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Antwort falsch");
            String right = "?";
            if (check_answer_right(button_1_answer, questions_class1.get(active_question-1)))
                right = button_1_answer;
            if (check_answer_right(button_2_answer, questions_class1.get(active_question-1)))
                right = button_2_answer;
            if (check_answer_right(button_3_answer, questions_class1.get(active_question-1)))
                right = button_3_answer;
            if (check_answer_right(button_4_answer, questions_class1.get(active_question-1)))
                right = button_4_answer;
            alert.setContentText(String.format("Deine Antwort ist falsch! Die Antwort wäre %s", right));
            alert.setResizable(true);
            alert.showAndWait();
            action_next();
        }
    }

    private boolean check_answer_right(String answer, Question question)
    {
        Answer[] answers = question.getAnswers();

        for (Answer value : answers)
        {
            if (value.getValue().equals(answer) && value.isRight())
                return true;
        }
        return false;
    }

    private void loadQuestion()
    {
        Question question;
        switch (active_class) {
            case 1 -> question = questions_class1.get(active_question);
            case 2 -> question = questions_class2.get(active_question);
            case 3 -> question = questions_class3.get(active_question);
            case 4 -> question = questions_class4.get(active_question);
            default -> throw new IllegalStateException("Unexpected value: " + active_class);
        }

        text_questions.setText(question.getValue());

        button_1_answer = question.getAnswer().getValue();
        button_1.setText(button_1_answer);
        button_2_answer = question.getAnswer().getValue();
        button_2.setText(button_2_answer);
        button_3_answer = question.getAnswer().getValue();
        button_3.setText(button_3_answer);
        button_4_answer = question.getAnswer().getValue();
        button_4.setText(button_4_answer);

        active_question++;
    }
}
