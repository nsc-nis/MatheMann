package at.g1.MatheMann.controller.mainmenu;

import at.g1.MatheMann.controller.signin.SignInC;
import at.g1.MatheMann.controller.signup.SignUpC;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuC {
    Button login_out_Btn;

    public static Stage stageMenu;
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/at/g1/MatheMann/view/mainMenu.fxml"));
            Parent root = fxmlLoader.load();

            stageMenu = stage;

            stageMenu.setTitle("Main-MENU");
            stageMenu.setScene(new Scene(root));
            stageMenu.show();
        }
        catch(Exception e)
        {
            System.err.println("Something wrong with overview.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
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
