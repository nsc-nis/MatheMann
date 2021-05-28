package at.g1.MatheMann.main;

import at.g1.MatheMann.controller.Controller;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
        Controller.show(stage);

    }
}
