package at.g1.MatheMann.controller.mainmenu;

import at.g1.MatheMann.controller.game.gameController;
import at.g1.MatheMann.controller.signin.SignIn;
import at.g1.MatheMann.controller.signin.SignInC;
import at.g1.MatheMann.controller.signup.SignUpC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * MatheMann - Controller
 * @author Niklas Schachl
 * @version: 1.1, 22.6.2021
 */
public class MainMenuC implements Initializable
{
    @FXML
    private Button button_class1;
    @FXML
    private Button button_class2;
    @FXML
    private Button button_class3;
    @FXML
    private Button button_class4;
    @FXML
    private Button button_logout;
    @FXML
    private Text progress_class1;
    @FXML
    private Text progress_class2;
    @FXML
    private Text progress_class3;
    @FXML
    private Text progress_class4;

    private int active_user;

    public static Stage stageMenu;
    public static void show(Stage stage, int user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/at/g1/MatheMann/view/mainMenu.fxml"));
            Parent root = fxmlLoader.load();
            MainMenuC ctrl = fxmlLoader.getController();

            ctrl.active_user = user;

            stageMenu = stage;

            stageMenu.setTitle("MatheMann - Hauptmenü");
            stage.getIcons().add(new Image("/at/g1/MatheMann/ressources/icon.png"));
            stageMenu.setScene(new Scene(root));
            stageMenu.show();
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
            SignIn.writeUsers();
            SignInC.show(new Stage());
            stageMenu.close();
        }catch (Exception ex){
            System.out.println("Something went wring");
        }
    }

    @FXML
    private void action_logout()
    {
        showLogIn_out_window();
    }

    @FXML
    private void action_firstClass()
    {
        gameController.show(new Stage(), 1, active_user);
        stageMenu.close();
    }

    @FXML
    private void action_secondClass()
    {
        gameController.show(new Stage(), 2, active_user);
        stageMenu.close();
    }

    @FXML
    private void action_thirdClass()
    {
        gameController.show(new Stage(), 3, active_user);
        stageMenu.close();
    }

    @FXML
    private void action_fourthClass()
    {
        gameController.show(new Stage(), 4, active_user);
        stageMenu.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        button_logout.setGraphic(new ImageView(new Image("/at/g1/MatheMann/ressources/LogOut.png")));
        button_class1.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        progress_class1.setText("Score: " + SignIn.getUser(active_user).getScore1());
        button_class2.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        progress_class2.setText("Score: " + SignIn.getUser(active_user).getScore2());
        button_class3.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        progress_class3.setText("Score: " + SignIn.getUser(active_user).getScore3());
        button_class4.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        progress_class4.setText("Score: " + SignIn.getUser(active_user).getScore4());
        button_logout.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_frame2.png')");
    }
}
