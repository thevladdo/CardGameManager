package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be extended by "GameRules" class which will represent basic rules of a generic card game
 *  It contains all the behavior concerning the rules
 */
public interface GameRulesInterface {

    /**
     * This method assigns or change a weight to each suit on a card
     * Example: the aces can be either the lowest card value, the highest, or both
     * @param card the card whose suit will have assigned a weight in the deck
     * @param weight the weight
     */
    void setSuitWeight(CardInterface card, int weight);
    //TODO come aggiungo a Card ?

    /**
     * This method set the minimum number of cards in the deck
     * @param min the minimum number of cards
     */
    void setDeckMin(int min);

    /**
     * This method get the minimum number of cards in the deck
     * @return the minimum number of cards
     */
    int getDeckMin();

    /**
     * This method set the maximum number of cards in the deck
     * @param max the maximum number of cards
     */
    void setDeckMax(int max);

    /**
     * This method get the maximum number of cards in the deck
     * @return the maximum number of cards
     */
    int getDeckMax();

    /**
     * This method set the minimum number of cards a player must have in their hand
     * @param min the minimum number of cards
     */
    void setMinHandCount(int min);
    //TODO come aggiungo a Hand ?

    /**
     * This method get the minimum number of cards a player must have in their hand
     * @return the minimum number of cards
     */
    int getMinHandCount();

    /**
     * This method the maximum number of cards a player must have in their hand
     * @param max the maximum number of cards
     */
    void setMaxHandCount(int max);

    /**
     * This method the maximum number of cards a player must have in their hand
     * @return maximum the maximum number of cards
     */
    int getMaxHandCount();

}
