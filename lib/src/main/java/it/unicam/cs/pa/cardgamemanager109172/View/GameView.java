package it.unicam.cs.pa.cardgamemanager109172.View;

import it.unicam.cs.pa.cardgamemanager109172.Controller.GameController;
import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;

import java.util.ArrayList;

public class GameView {

    public void getInitView(){
        String playerName = GameController.playerName.toUpperCase();
        println("*******************************************\n" +
                "*     CIAO "+playerName+" :)    \n" +
                "*     BENVENUTO NEL GIOCO !     \n" +
                "*******************************************");
    }

    public void getActualVew(Rubamazzetto rm){
        println("\n* LO STATO ATTUALE DELLE CARTE SUL TAVOLO È:\n");
        printCard(rm.getTable().getOnTableCards());
        println("\n* LE SEGUENTI SONO LE TUE CARTE:\n");
        printCard(rm.getPlayerOne().getPlayerHand().getCards());
    }

    public void askNextMove(){
        println("""
                * COSA VUOI FARE ?
                
                  1- Provo a rubare il mazzetto avversario
                  2- Prendo una carta dal tavolo
                  3- Esco dal gioco
                
                * DIGITA IL NUMERO IN CORRISPONDENZA ALLA TUA SCELTA
                  SEGUITO DAL TASTO INVIO""");
    }

    public void getTurner(Player turner){
        println("\n* È IL TURNO DI "+turner.getName());
    }

    public void getWinner(Rubamazzetto rm){
        println("\n\n* IL VINCITORE DI QUESTA PARTITA È "+rm.finishGame());
    }

    public void sayGoodbye(){
        println("""


                * GRAZIE PER AVER GIOCATO :)
                * ALLA PROSSIMA!""");
    }

    private static void printCard(ArrayList<Card> toPrint){
        for (Card card : toPrint ) {
            println(printCardFace(card.getValue(), card.getSuit()));
        }
    }

    private static String printCardFace(int value, String suit) {
        StringBuilder face = new StringBuilder();
        face.append("+-----------+" + "\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0 && i != 3) {
                    face.append("|  " + " ");
                } else if (j == 1 && i == 1) {
                    if(value == 10) {
                        face.append(" ").append(value).append(" ");
                    } else face.append("  ").append(value).append(" ");
                } else if (i != 3) face.append("   " + " ");
                if (j == 0 && i == 3) {
                    switch (suit) {
                        case "Swords" -> face.append("|   SWORDS  ");
                        case "Cups" -> face.append("|    CUPS   ");
                        case "Coins" -> face.append("|   COINS   ");
                        case "Batons" -> face.append("|   BATONS  ");

                        case "Swords Queen" -> face.append("|   SWORDS  |\n" +
                                "|   QUEEN   ");
                        case "Cups Queen" -> face.append("|   CUPS    |\n" +
                                "|   QUEEN   ");
                        case "Coins Queen" -> face.append("|   COINS   |\n" +
                                "|   QUEEN   ");
                        case "Batons Queen" -> face.append("|   BATONS  |\n" +
                                "|   QUEEN   ");

                        case "Swords King" -> face.append("|   SWORDS  |\n" +
                                "|   KING    ");
                        case "Cups King" -> face.append("|   CUPS    |\n" +
                                "|   KING    ");
                        case "Coins King" -> face.append("|   COINS   |\n" +
                                "|   KING    ");
                        case "Batons King" -> face.append("|   BATONS  |\n" +
                                "|   KING    ");

                        case "Swords Knight" -> face.append("|   SWORDS  |\n" +
                                "|   KNIGHT  ");
                        case "Cups Knight" -> face.append("|   CUPS    |\n" +
                                "|   KNIGHT  ");
                        case "Coins Knight" -> face.append("|   COINS   |\n" +
                                "|   KNIGHT  ");
                        case "Batons Knight" -> face.append("|   BATONS  |\n" +
                                "|   KNIGHT  ");
                    }
                }
            }
            face.append("|");
            face.append("\n");
        }
        face.append("+-----------+" + "\n");
        return face.toString();
    }


    private static void println(String s){
        System.out.println(s);
    }
}
