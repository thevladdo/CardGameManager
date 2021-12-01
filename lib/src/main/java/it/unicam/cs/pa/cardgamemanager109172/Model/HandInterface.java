package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be implemented by the "Hand" class which will represent the cards in a player's hand
 * It extends the {@link DeckInterface} because the cards in hand represent a smaller version of a deck
 */
public interface HandInterface extends DeckInterface {

    /**
     * This method moves the card to the desired location
     * @param card the card that will be moved
     * @param index the location where the cardInterface will be placed
     */
    void moveTo(CardInterface card, int index);

    /**
     * This method discard all the cards from the hand
     */
    void clear();

    /**
     * This method set the minimum number of cards a player must have in their hand
     */
    void setMinCardCount();

    /**
     * This method get the minimum number of cards a player must have in their hand
     * @return the minimum number of cards
     */
    int getMinCardCount();

    /**
     * This method the maximum number of cards a player must have in their hand
     */
    void setMaxCardCount();

    /**
     * This method the maximum number of cards a player must have in their hand
     * @return maximum
     */
    int getMaxCardCount();

    /**
     * This method get the actual number of cards in the hand
     * @return the actual number of cards
     */
    int getCardCount();

    /**
     * This method set the number of cards in the hand of a player at the start of the game
     * @param newStarterNum the number of cards
     */
    void setStarterCardCount(int newStarterNum);

    /**
     * This method get the number of cards in the hand of a player at the start of the game
     * @return the number of cards
     */
    int getStarterCardCount();
}
