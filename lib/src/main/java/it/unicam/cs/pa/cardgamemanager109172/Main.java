package it.unicam.cs.pa.cardgamemanager109172;

import it.unicam.cs.pa.cardgamemanager109172.Controller.GameController;
import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.View.GameSelector;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        GameSelector selector = new GameSelector();
        selector.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
        Scanner user = new Scanner(System.in);
        String playerName = GameController.playerName.toUpperCase();
        println("CIAO "+playerName+" :)\nBENVENUTO NEL GIOCO !");
        Rubamazzetto rubamazzetto = new Rubamazzetto(playerName);
    }

    private static void println(String s){
        System.out.println(s);
    }
}

