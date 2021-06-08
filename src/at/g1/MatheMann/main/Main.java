package at.g1.MatheMann.main;

import at.g1.MatheMann.controller.game.gameController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * MatheMann - Main
 * @author Niklas Schachl
 * @version 1.0, 19.5.2021
 */
public class Main extends Application
{
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        gameController.show(stage);

    }
}
