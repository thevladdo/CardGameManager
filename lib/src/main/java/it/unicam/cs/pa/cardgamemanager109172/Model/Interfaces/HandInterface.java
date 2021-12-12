package it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces;

/**
 * This interface will be implemented by the "Hand" class which will represent the cards in a player's hand.
 * It extends the {@link DeckInterface} because the cards in hand represent a smaller version of a deck.
 * Use {@link GameRulesInterface} to find out what is the maximum or minimum number of cards a hand can have.
 * The constructor of this class will have as argument an object of type {@link GameRulesInterface} that
 * will use to know what will be the starter number of cards a player hand at the start of the game.
 */
public interface HandInterface extends DeckInterface{

    /**
     * This method moves the card to the desired location in the hand
     * @param card the card that will be moved
     * @param index the location where the cardInterface will be placed
     */
    void moveTo(CardInterface card, int index);

    /**
     * This method discard all the cards from the hand
     */
    void clear();

    /**
     * This method discard a card from the hand
     * @param card the card that will be discarded
     */
    void discard(CardInterface card);

    /**
     * This method checks whether the amount of cards in the hand complies with the rules of the game
     * @param rules Game Rules
     * @return true if the amount of cards in the hand exceeds the maximum or minimum according the game rules
     */
    boolean isInLimit(GameRulesInterface rules);

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
}
