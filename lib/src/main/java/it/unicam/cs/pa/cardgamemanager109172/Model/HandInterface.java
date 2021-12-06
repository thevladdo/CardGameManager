package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.util.ArrayList;

/**
 * This interface will be implemented by the "Hand" class which will represent the cards in a player's hand.
 * It extends the {@link DeckInterface} because the cards in hand represent a smaller version of a deck.
 * Use {@link GameRulesInterface} to find out what is the maximum or minimum number of cards a hand can have.
 * The constructor of this class will have as argument an object of type {@link GameRulesInterface} that
 * will use to know what will be the starter number of cards a player hand at the start of the game.
 */
public interface HandInterface extends DeckInterface {

    /**
     * This method show the cards to everyone
     * @return the cards in the hand of the player
     */
    ArrayList<CardInterface> showCards();
    //prende e fa hand.showCard() per ogni carta mettendole in un ArrayList

    /**
     * This method moves the card to the desired location
     * @param card the card that will be moved
     * @param index the location where the cardInterface will be placed
     */
    void moveTo(CardInterface card, int index);

    /**
     * This method draws a card from the deck and adds it to the player's hand
     * Use isInLimit() to control if the new number of card in the hand complies with the rules of the game
     * @param position the position in the hand of the card that will be placed
     */
    void drawCard(int position);

    /**
     * This method places a card from the hand down on the table and removes it in the player's hand
     * Use isInLimit() to control if the new number of card in the hand complies with the rules of the game
     * @param position the position in the hand of the card that will be placed
     * @param table the table where the card will be placed
     */
    void placeCard(int position, TableInterface table);
    //richiama showCard();

    /**
     * This method show a card from the hand without discarding or placing it on the table
     * @param position the position in the hand of the card that will be showed
     * @return the card
     */
    CardInterface showCard(int position);

    /**
     * This method discard all the cards from the hand
     */
    void clear();

    /**
     * This method get the actual number of cards in the hand
     * @return the actual number of cards
     */
    int getCardCount();

    /**
     * This method get the lowest card according to suit weight
     * @return the lowest card
     */
    CardInterface getLowestCard();

    /**
     * This method get the highest card according to suit weight
     * @return the highest card
     */
    CardInterface getHighestCard();

    /**
     * This method checks whether the amount of cards in the hand complies with the rules of the game
     * @param rules Game Rules
     * @return true if the amount of cards in the hand exceeds the maximum or minimum according the game rules
     */
    boolean isInLimit(GameRulesInterface rules);
}
