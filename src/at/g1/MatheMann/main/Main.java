package at.g1.MatheMann.main;

import at.g1.MatheMann.controller.mainmenu.MainMenuC;
import at.g1.MatheMann.controller.signin.SignInC;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        SignInC.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
