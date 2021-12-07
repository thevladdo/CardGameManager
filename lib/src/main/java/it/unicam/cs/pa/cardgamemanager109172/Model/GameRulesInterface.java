package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be extended by "GameRules" class which will represent basic rules of a generic card game
 * It contains all the behavior concerning the rules
 * The constructor will create a Map with the cards as the key and null as the value assigned to each key
 */
public interface GameRulesInterface {

    /**
     * This method assigns a weight to each card of the deck in a Map with card as key and the weight as value
     * If the card isn't already present in the Map, add the card as key and assign it the weight as the value
     * Example: the aces can be either the lowest card value, the highest, or both
     * @param card the card that will have assigned a weight in the deck
     * @param weight the weight
     * @return the previous value associated with card, or null if there was no weight for the card
     */
    Integer setCardWeight(CardInterface card, int weight);
    // use Map.put(card,weight)

    /**
     * This method shows the weight a card suit has
     * @param card the card whose weight will show
     * @return the weight of the card or null if the suit isn't present in the Map
     */
    Integer getCardWeight(CardInterface card);
    // use Map.get(Object key)

    /**
     * This method set the minimum assignable value of a card
     * @param minValue the minimum assignable value
     */
    void setMinCardValue(int minValue);

    /**
     * This method get the minimum assignable value of a card
     */
    int getMinCardValue();

    /**
     * This method set the maximum assignable value of a card
     * @param maxValue the maximum assignable value
     */
    void setMaxCardValue(int maxValue);

    /**
     * This method get the maximum assignable value of a card
     */
    int getMaxCardValue();

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

    /**
     * This method set the number of cards in the hand of a player at the start of the game
     * @param starter the number of starter cards
     */
    void setHandStarter(int starter);

    /**
     * This method get the number of cards in the hand of a player at the start of the game
     * @return the number of starter cards
     */
    int getHandStarter();
}
