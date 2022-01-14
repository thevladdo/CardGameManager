package it.unicam.cs.pa.cardgamemanager109172.Model.Game;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The "Rubamazzetto", also known as "Rubamazzo" is a card game, a simplified variant of "Scopa".
 * Played with Italian deck of 40 cards divided into 4 suits of 10 cards each without color differentiation.
 * It is played by only 2 people.
 */
public class Rubamazzetto implements RubamazzettoInterface {

    private int turn;
    private final Deck deck;
    private final Deck bounchOne;
    private final Deck bounchTwo;
    private final Player playerOne;
    private Bot bot;
    private final Table table;

    public Rubamazzetto(String playerName){
        this.turn = 0;
        File deckConfig = new File(
                "lib/src/main/java/it/unicam/cs/pa/gameConfigurations/Italian.deck");
        ConfigGenerator deckLoader = new ConfigGenerator(deckConfig);
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        this.deck = ((Deck) deckLoader.loadConfig());
        this.bounchOne = new Deck(rules,new ArrayList<>(1),0);
        this.bounchTwo = new Deck(rules,new ArrayList<>(1),0);
        playerOne = new Player(
                new Hand(rules,new ArrayList<>(1),0), playerName,1);
        ArrayList<Player> players = new ArrayList<>(2);
        players.add(this.playerOne);
        this.table = new Table(new ArrayList<>(4),players);
    }

    @Override
    public void newGame(){
        this.turn = 0;
        this.deck.shuffle();
        for (Player player : this.table.getPlayers()) {
            for (int i = 0; i < 3; i++) {
                player.drawCard(this.deck);
            }
        }
        for (int i = 0; i < 4; i++) {
            this.table.addCard(this.deck.getFirstCard());
        }
    }

    @Override
    public int getTurn(){
        return this.turn;
    }

    @Override
    public void nextTurn(){
        this.turn++;
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public Deck getBounchOne() {
        return bounchOne;
    }

    @Override
    public Deck getBounchTwo() {
        return bounchTwo;
    }

    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    @Override
    public Table getTable() {
        return table;
    }


    public class Actions {

        public Actions(){}

        public void placeOnTable(int index){
            getPlayerOne().placeCard(index,getTable());
        }

        public void makeMove(){
            Card checkResult = checkOtherBunch();
            if (checkResult != null){
                unifyBounch(getBounchTwo(),getBounchOne(),checkOtherBunch());
            }
            checkResult = checkIfSame(getTable());
            if ( checkResult != null){
                getBounchOne().add(checkResult);
            }
        }

        private void unifyBounch(Deck toMerge, Deck merged, Card last){
            for (Card card : toMerge.getDeck()) {
                merged.add(card);
            }
            merged.add(last);
        }

        private Card checkOtherBunch(){
            for (Card inHand : getPlayerOne().getPlayerHand().getCards()) {
                if (inHand.equals(getBounchOne().getLastCard())) return inHand;
            }
            return null;
        }

        private Card checkIfSame(Table table){
            for (Card inHand : getPlayerOne().getPlayerHand().getCards()) {
                for (Card onTable : table.getOnTableCards()) {
                    if (inHand.equals(onTable)) return inHand;
                }
            }
            return null;
        }
    }


    /*
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("""

                BENVENUTO IN RUBAMAZZETTO
                SCEGLI UNA DELLE SEGUENTI OPZIONI\040
                DIGITANDO IL NUMERO CORRISPONDENTE:
                1- Nuova Partita
                2- Esci
                """);
        int choice = user.nextInt();
        switch (choice){
            case 1:
                System.out.println("""

                INIZIAMO !
                """);
                Rubamazzetto rubamazzetto = new Rubamazzetto("GG");
                rubamazzetto.newGame();
            case 2:
                System.exit(0);
        }
    }

     */


}
