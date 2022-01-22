package it.unicam.cs.pa.cardgamemanager109172.Model.Game;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * The "Rubamazzetto", also known as "Rubamazzo" is a card game, a simplified variant of "Scopa".
 * Played with Italian deck of 40 cards divided into 4 suits of 10 cards each without color differentiation.
 * It is played by only 2 people.
 */
public class Rubamazzetto implements RubamazzettoInterface {

    private int turn;
    private Deck deck;
    private GameRules rules;
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
        HashMap<Card,Integer> weights = new HashMap<>(40);
        this.rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        DeckConfigFactory factory = new DeckConfigFactory(rules);
        this.deck = factory.ItalianDeck();
        this.bounchOne = new Deck(rules,new ArrayList<>(1),0);
        this.bounchTwo = new Deck(rules,new ArrayList<>(1),0);
        this.playerOne = new Player(
                new Hand(rules,new ArrayList<>(1),0), playerName,1);
        this.bot =new Player(
                new Hand(rules,new ArrayList<>(1),0), "Game Bot",2);
        ArrayList<Player> players = new ArrayList<>(2);
        players.add(this.playerOne);
        players.add(this.bot);
        this.table = new Table(new ArrayList<>(4),players);
    }

    @Override
    public void newGame(){
        resetGame();
        this.deck.shuffle();
        dealer();
    }

    @Override
    public String finishGame(){
        String winner = null;
        if (cantContinue()) winner = findWinner();
        return winner;
    }

    @Override
    public int getTurn(){
        return this.turn;
    }

    @Override
    public void nextTurn(){
        this.turn++;
        dealer();
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
        if (this.getPlayerOne().getPlayerHand().getCards().size() == 0 &&
                this.getBot().getPlayerHand().getCards().size() == 0){
            for (Player player : this.table.getPlayers()) {
                for (int i = 1; i <= 3; i++) {
                    player.drawCard(this.deck);
                }
            }
        }
        if (this.table.getOnTableCards().size() == 0){
            for (int i = 1; i <= 4; i++) {
                this.table.addCard(this.deck.getFirstCard());
                this.deck.remove(this.deck.getFirstCard());
            }
        }
    }

    private boolean cantContinue(){
        return ((this.deck.getDeckCards().size() == 0) &&
                ((this.getPlayerOne().getPlayerHand().getCards().size() == 0) ||
                        (this.getBot().getPlayerHand().getCards().size() == 0)));
    }

    private String findWinner(){
        return switch (this.bounchOne.compareTo(this.bounchTwo)) {
            case 1 -> this.playerOne.getName();
            case -1 -> this.bot.getName();
            default -> "Tie";
        };
    }

    private void resetGame(){
        DeckConfigFactory factory = new DeckConfigFactory(this.rules);
        this.deck = factory.ItalianDeck();
        this.turn = 0;
        this.bounchOne.getDeckCards().clear();
        this.bounchTwo.getDeckCards().clear();
        this.playerOne.getPlayerHand().clear();
        this.bot.getPlayerHand().clear();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Rubamazzetto rm)) return false;
        return getTurn() == rm.getTurn() &&
                Objects.equals(getDeck(), rm.getDeck()) &&
                Objects.equals(this.rules, rm.rules) &&
                Objects.equals(getBounchOne(), rm.getBounchOne()) &&
                Objects.equals(getBounchTwo(), rm.getBounchTwo()) &&
                Objects.equals(getPlayerOne(), rm.getPlayerOne()) &&
                Objects.equals(getBot(), rm.getBot()) &&
                Objects.equals(getTable(), rm.getTable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTurn(), getDeck(), this.rules, getBounchOne(),
                getBounchTwo(), getPlayerOne(), getBot(), getTable());
    }


    /**
     * This inner class encompasses the actions the game can have.
     */
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
                    case 1 -> unifyBounch(getBounchTwo(),getBounchOne(), handCard);
                    case 2 -> unifyBounch(getBounchOne(),getBounchTwo(), handCard);
                }
                turner.getPlayerHand().remove(handCard);
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
            ArrayList<Card> moveCards = checkIfSame(getTable(),turner.showCard(handCardIndex));
            if (moveCards != null){
                getPlayerBounch(turner).add(moveCards.get(0));
                getPlayerBounch(turner).add(moveCards.get(1));
                getTable().removeCard(moveCards.get(0));
                turner.getPlayerHand().remove(moveCards.get(1));
                nextTurn();
            } else placeOnTable(turner,handCardIndex);
        }

        private void placeOnTable(Player turner, int handCardIndex){
            turner.placeCard(handCardIndex,getTable());
            nextTurn();
        }

        private void unifyBounch(Deck toMerge, Deck merged, Card last){
            merged.getDeckCards().addAll(toMerge.getDeckCards());
            toMerge.getDeckCards().removeAll(toMerge.getDeckCards());
            merged.add(last);
        }

        private Card checkOtherBunch(Player turner){
            switch (turner.getId()){
                case 1 :
                    for (Card inHand : turner.getPlayerHand().getCards()) {
                        if (getBounchTwo().getDeckCards().size() != 0 &&
                                inHand.getValue() == getBounchTwo().getLastCard().getValue()) return inHand;
                    }
                case 2 :
                    for (Card inHand : turner.getPlayerHand().getCards()) {
                        if (getBounchOne().getDeckCards().size() != 0 &&
                                inHand.getValue() == getBounchOne().getLastCard().getValue()) return inHand;
                    }
            }
            return null;
        }

        private ArrayList<Card> checkIfSame(Table table, Card toCheck){
            ArrayList<Card> toReturn = null;
            for (Card onTable : table.getOnTableCards()) {
                if (toCheck.getValue() == onTable.getValue()){
                    toReturn = new ArrayList<>(2);
                    toReturn.add(onTable);
                    toReturn.add(toCheck);
                    return toReturn;
                }
            }
            return null;
        }
    }
}
