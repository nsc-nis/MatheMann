package at.g1.MatheMann.controller.mainmenu;

import at.g1.MatheMann.controller.game.gameController;
import at.g1.MatheMann.controller.signin.SignInC;
import at.g1.MatheMann.controller.signup.SignUpC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * MatheMann - Controller
 * @author Niklas Schachl
 * @version: 1.0, 16.6.2021
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

    @FXML
    private void first_class()
    {
        gameController.show(new Stage());
        stageMenu.close();
    }

    @FXML
    private void second_class()
    {

    }

    @FXML
    private void third_class()
    {

    }

    @FXML
    private void fourth_class()
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        button_logout.setGraphic(new ImageView(new Image("/at/g1/MatheMann/ressources/LogOut.png")));
        button_class1.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        button_class2.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        button_class3.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
        button_class4.setStyle("-fx-background-image: url('/at/g1/MatheMann/ressources/button_class1.png')");
    }
}
