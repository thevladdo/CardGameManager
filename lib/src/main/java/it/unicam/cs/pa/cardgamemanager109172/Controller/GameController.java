package it.unicam.cs.pa.cardgamemanager109172.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Optional;

public class GameController{

    @FXML
    private Button startGame;
    @FXML
    private RadioButton poker;
    @FXML
    private RadioButton scala;
    @FXML
    private RadioButton rubamazzetto;
    @FXML
    private Pane pane;

    Alert a = new Alert(Alert.AlertType.WARNING);
    public static String playerName;
    Stage stage;
    private int counter;

    public void startGame(ActionEvent event){
        if (counter<1){
            stage = (Stage) pane.getScene().getWindow();
            a.initModality(Modality.APPLICATION_MODAL);
            a.initOwner(stage);
            counter++;
        }
        if ((poker.isSelected() || scala.isSelected())) {
            a.getDialogPane().setContentText("Ci scusiamo per l'inconveniente :(");
            a.getDialogPane().setHeaderText("Gioco disponibile nel prossimo aggiornamento");
            a.showAndWait();
            counter++;
        } else if (rubamazzetto.isSelected()){
            Stage stage = (Stage) pane.getScene().getWindow();
            TextInputDialog dialog = new TextInputDialog("walter");
            dialog.setTitle("UNICAM CARD GAME");
            dialog.setHeaderText("Ciao, inserisci i seguenti dati per continuare");
            dialog.setContentText("Il mio nome è");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> playerName = name);
            stage.close();
        }
    }


    public void selectPoker(ActionEvent event){
        if(scala.isSelected() || rubamazzetto.isSelected()){
            scala.setSelected(false);
            rubamazzetto.setSelected(false);
            poker.setSelected(true);
        }
    }

    public void selectScala(ActionEvent event){
        if(poker.isSelected() || rubamazzetto.isSelected()){
            poker.setSelected(false);
            rubamazzetto.setSelected(false);
            scala.setSelected(true);
        }
    }

    public void selectRubamazzetto(ActionEvent event){
        if(scala.isSelected() || poker.isSelected()){
            scala.setSelected(false);
            poker.setSelected(false);
            rubamazzetto.setSelected(true);
        }
    }

}
