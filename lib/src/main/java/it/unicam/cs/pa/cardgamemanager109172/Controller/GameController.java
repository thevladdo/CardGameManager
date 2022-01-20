package it.unicam.cs.pa.cardgamemanager109172.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class GameController{

    @FXML
    private Button startGame;
    @FXML
    private RadioButton poker;
    @FXML
    private RadioButton scala;
    @FXML
    private RadioButton rubamazzetto;

    Alert a = new Alert(Alert.AlertType.WARNING);

    public void selectGame(ActionEvent actionEvent) {
        if(poker.isSelected() || scala.isSelected())
            a.setContentText("Gioco disponibile nel prossimo aggiornamento");
        if(rubamazzetto.isSelected() && startGame.isArmed()){

        }
    }
}
