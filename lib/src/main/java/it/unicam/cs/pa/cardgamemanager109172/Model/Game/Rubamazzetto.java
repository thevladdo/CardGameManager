package it.unicam.cs.pa.cardgamemanager109172.Model.Game;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * The "Rubamazzetto", also known as "Rubamazzo" is a card game, a simplified variant of "Scopa".
 * Played with Italian deck of 40 cards divided into 4 suits of 10 cards each without color differentiation.
 * It is played by only 2 people.
 */
public class Rubamazzetto implements RubamazzettoInterface {

    private int turn;
    private Deck deck;
    private final Deck bounchOne;
    private final Deck bounchTwo;
    private final Player playerOne;
    private final Player bot;
    private final Table table;

    public Rubamazzetto(){
        this.turn = -1;
        this.deck = null;
        this.bounchOne = null;
        this.bounchTwo = null;
        this.playerOne = null;
        this.bot = null;
        this.table = null;
    }

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
        this.playerOne = new Player(
                new Hand(rules,new ArrayList<>(1),0), playerName,1);
        this.bot =new Player(
                new Hand(rules,new ArrayList<>(1),0), playerName,2);
        ArrayList<Player> players = new ArrayList<>(2);
        players.add(this.playerOne);
        players.add(this.bot);
        this.table = new Table(new ArrayList<>(4),players);
    }

    @Override
    public void newGame(){
        resetGame();
        dealer();
    }

    @Override
    public String finishGame(){
        String winner = findWinner();
        if (cantContinue()) newGame();
        return winner;
    }

    public Player defineStarter(){
        if (whoStart() == 0) return this.playerOne;
        return this.bot;
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
        return this.deck;
    }

    @Override
    public Deck getBounchOne() {
        return this.bounchOne;
    }

    @Override
    public Deck getBounchTwo() {
        return this.bounchTwo;
    }

    @Override
    public Deck getPlayerBounch(Player player){
        return switch (player.getId()){
            case 1 -> getBounchOne();
            case 2 -> getBounchTwo();
            default -> null;};
    }

    @Override
    public Player getPlayerOne() {
        return this.playerOne;
    }

    @Override
    public Player getBot(){
        return this.bot;
    }

    @Override
    public Table getTable() {
        return this.table;
    }

    private void dealer(){
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

    private boolean cantContinue(){
        return ((this.deck.getDeck().size() == 0) &&
                ((this.bounchOne.getDeck().size() == 0) || (this.bounchTwo.getDeck().size() == 0)));
    }

    private String findWinner(){
        return switch (this.bounchOne.compareTo(this.bounchTwo)) {
            case 1 -> this.playerOne.getName();
            case -1 -> this.bot.getName();
            default -> "Tie";
        };
    }

    private void resetGame(){
        File deckConfig = new File(
                "lib/src/main/java/it/unicam/cs/pa/gameConfigurations/Italian.deck");
        ConfigGenerator deckLoader = new ConfigGenerator(deckConfig);
        this.deck = ((Deck) deckLoader.loadConfig());
        this.turn = 0;
        this.bounchOne.getDeck().clear();
        this.bounchTwo.getDeck().clear();
    }

    private int whoStart(){
        Random rand = new Random();
        int upperbound = 2;
        return rand.nextInt(upperbound);
    }


    public class Actions {

        /**
         * With this action a player can steal the other player's bounch of cards
         * @param turner the player that try to steal
         * @return true if the bounch was stolen, false otherwise
         */
        public boolean stealBounch(Player turner){
            Card handCard = checkOtherBunch(turner);
            if (handCard != null){
                switch (turner.getId()) {
                    case 1 -> {
                        unifyBounch(getBounchTwo(), getBounchOne(), handCard);
                        getPlayerOne().getPlayerHand().remove(handCard);}
                    case 2 -> {
                        unifyBounch(getBounchOne(), getBounchTwo(), handCard);
                        getBot().getPlayerHand().remove(handCard);}
                }
                nextTurn();
                return true;
            } else return false;
        }

        /**
         * With this action a player can make a move and take a card from the table.
         * If there's no match between the cards on the table and those in his hand,
         * the player places a card on the table.
         * @param turner the player that make the move
         * @param handCardIndex the card selected from the hand
         */
        public void makeMove(Player turner, int handCardIndex){
            ArrayList<Card> moveCards = checkIfSame(getTable());
            if (moveCards != null){
                getPlayerBounch(turner).add(moveCards.get(0));
                getPlayerBounch(turner).add(moveCards.get(1));
                getTable().removeCard(moveCards.get(0));
                nextTurn();
            } else placeOnTable(handCardIndex);
        }

        private void placeOnTable(int index){
            getPlayerOne().placeCard(index,getTable());
            nextTurn();
        }

        private void unifyBounch(Deck toMerge, Deck merged, Card last){
            for (Card card : toMerge.getDeck()) {
                merged.add(card);
            }
            merged.add(last);
        }

        private Card checkOtherBunch(Player turner){
            for (Card inHand : getPlayerBounch(turner).getDeck()) {
                if (inHand.equals(getPlayerBounch(turner).getLastCard())) return inHand;
            }
            return null;
        }

        private ArrayList<Card> checkIfSame(Table table){
            ArrayList<Card> toReturn = new ArrayList<>(2);
            for (Card inHand : getPlayerOne().getPlayerHand().getCards()) {
                for (Card onTable : table.getOnTableCards()) {
                    if (inHand.getValue() == onTable.getValue()){
                        toReturn.add(onTable);
                        toReturn.add(inHand);
                    }
                    return toReturn;
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
