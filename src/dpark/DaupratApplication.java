package dpark;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author STALKER_2010
 */
public class DaupratApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game.launch(new Game());
        Game.NAME = "Dauprat park";
    }
}