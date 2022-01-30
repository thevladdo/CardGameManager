package it.unicam.cs.pa.cardgamemanager109172;

import it.unicam.cs.pa.cardgamemanager109172.Controller.RubamazzettoController;
import it.unicam.cs.pa.cardgamemanager109172.View.GameSelector;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        GameSelector selector = new GameSelector();
        selector.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
        RubamazzettoController rmController = new RubamazzettoController();
        rmController.play();
    }
}

