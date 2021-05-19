package at.g1.MatheMann.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * MatheMann - Controller
 * @author Niklas Schachl
 * @version: 1.0, 19.5.2021
 */
public class Controller
{
    private Stage stage;

    public Controller()
    {

    }

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
            //stage.getIcons().add(new Image("/at/nsc/images/icon_logo.png"));
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
}
