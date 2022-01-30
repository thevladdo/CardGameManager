package it.unicam.cs.pa.cardgamemanager109172.Controller;

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
    public Button startGame;
    @FXML
    private RadioButton poker;
    @FXML
    private RadioButton scala;
    @FXML
    private RadioButton rubamazzetto;
    @FXML
    private Pane pane;

    Alert a = new Alert(Alert.AlertType.WARNING);
    Stage stage;
    public static String playerName;
    private int counter;

    /**
     * This method has the responsibility to do actions when "Play" button is pressed.
     * If the selected game isn't already implemented show a warning message.
     * If the selected game is implemented close the Game Selector and starts the game from terminal.
     */
    public void startGame(){
        checkButtonCounter();
        if ((poker.isSelected() || scala.isSelected())) {
            a.getDialogPane().setContentText("Ci scusiamo per l'inconveniente :(");
            a.getDialogPane().setHeaderText("Gioco disponibile nel prossimo aggiornamento");
            a.showAndWait();
            counter++;
        } else if (rubamazzetto.isSelected()){
            Stage stage = (Stage) pane.getScene().getWindow();
            TextInputDialog dialog = new TextInputDialog("Eddie");
            dialog.setTitle("UNICAM CARD GAME");
            dialog.setHeaderText("Ciao, inserisci i seguenti dati per continuare");
            dialog.setContentText("Il mio nome \u00E8");
            Optional<String> result = dialog.showAndWait();
            if(result.isPresent()){
                result.ifPresent(name -> playerName = name);
                stage.close();
            }
        }
    }

    private void checkButtonCounter(){
        if (counter<1){
            stage = (Stage) pane.getScene().getWindow();
            a.initModality(Modality.APPLICATION_MODAL);
            a.initOwner(stage);
            counter++;
        }
    }

    public void selectPoker(){
        if(scala.isSelected() || rubamazzetto.isSelected()){
            scala.setSelected(false);
            rubamazzetto.setSelected(false);
            poker.setSelected(true);
        }
    }

    public void selectScala(){
        if(poker.isSelected() || rubamazzetto.isSelected()){
            poker.setSelected(false);
            rubamazzetto.setSelected(false);
            scala.setSelected(true);
        }
    }

    public void selectRubamazzetto(){
        if(scala.isSelected() || poker.isSelected()){
            scala.setSelected(false);
            poker.setSelected(false);
            rubamazzetto.setSelected(true);
        }
    }
}
