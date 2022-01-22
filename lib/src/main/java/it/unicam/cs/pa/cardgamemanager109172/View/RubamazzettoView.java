package it.unicam.cs.pa.cardgamemanager109172.View;

import it.unicam.cs.pa.cardgamemanager109172.Controller.GameController;
import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;

import java.util.ArrayList;

public class RubamazzettoView {

    public void getInitView(){
        String playerName = GameController.playerName.toUpperCase();
        println("*******************************************\n" +
                "*     CIAO "+playerName+" :)    \n" +
                "*     BENVENUTO NEL GIOCO !     \n" +
                "*******************************************");
    }

    public void getActualView(Rubamazzetto rm){
        println("\n* LO STATO ATTUALE DELLE CARTE SUL TAVOLO È:\n");
        printCard(rm.getTable().getOnTableCards());
        println("\n* LE SEGUENTI SONO LE TUE CARTE:\n");
        printCard(rm.getPlayerOne().getPlayerHand().getCards());
    }

    public void getOnTopBounch(Rubamazzetto rm){
        if (rm.getBounchTwo().getDeckCards().size() != 0){
            println("\n* LA CARTA IN CIMA AL MAZZETTO DELL'AVVERSARIO È LA SEGUENTE\n");
            Card toPrint = rm.getBounchTwo().getCard(rm.getBounchTwo().getCardCount()-1);
            println(printCardFace(toPrint.getValue(),toPrint.getSuit()));
        }
    }

    public void succesfullySteal(Player turner){
        if (turner.getId() == 0) {
            println("\n* MAZZETTO DELL'AVVERSARIO RUBATO CON SUCCESSO");
        } else println("\n* L'AVVERSARIO HA RUBATO IL TUO MAZZETTO !");
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

    public void notStealed(Rubamazzetto rm){
        println("\n* NON È POSSIBILE RUBARE IL MAZZETTO AVVERSARIO");
        if (rm.getBounchTwo().getDeckCards().size() == 0){
            println("  L'AVVERSARIO NON HA UN MAZZETTO !");
        } else {
            getOnTopBounch(rm);
        }
    }

    public void selectCard(Rubamazzetto rm){
        println("""
                
                * ORA FARAI UNA MOSSA !
                  QUALE DELLE TUE CARTE VUOI GIOCARE ?
                """);
        int counter = 1;
        for (Card card : rm.getPlayerOne().getPlayerHand().getCards()) {
            println("  "+counter+"- "+card.getSuit().toUpperCase()+" "+card.getValue());
            counter++;
        }
        println("\n* DIGITA IL NUMERO IN CORRISPONDENZA ALLA TUA SCELTA\n" +
                "  SEGUITO DAL TASTO INVIO");
    }

    public void getTurner(Player turner){
        println("\n* È IL TURNO DI "+turner.getName().toUpperCase());
    }

    public void getWinner(String winnerName){
        println("\n\n* IL VINCITORE DI QUESTA PARTITA È "+winnerName.toUpperCase());
    }

    public void retryInput(){
        println("* NESSUNA CORRISPONDENZA CON VALORE INSERITO" +
                "\n  RIPROVA");
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
