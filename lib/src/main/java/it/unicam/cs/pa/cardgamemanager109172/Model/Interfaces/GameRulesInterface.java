package it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces;

import it.unicam.cs.pa.cardgamemanager109172.Model.*;

/**
 * This interface will be implemented by "GameRules" class which will represent basic rules of a generic card game.
 * It contains all the behavior concerning the rules.
 * The constructor will create a Map to associate a card with a weight value.
 */
public interface GameRulesInterface {

    /**
     * This method assigns a weight to each cardInterface of the deck in a Map with cardInterface as key and the weight as value.
     * If the cardInterface isn't already present in the Map, add the cardInterface as key and assign it the weight as the value.
     * Example: the aces can be either the lowest cardInterface value, the highest, or both.
     * @param cardInterface the cardInterface that will have assigned a weight in the deck
     * @param weight the weight
     */
    void setCardWeight(Card card, int weight);

    /**
     * This method shows the weight a cardInterface suit has and will be user
     * @param card the cardInterface whose weight will show
     * @return the weight of the cardInterface or null if the suit isn't present in the Map
     */
    Integer getCardWeight(Card card);

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
     * This method control if a cardInterface is created according the game rules by checking the value
     * @param cardInterface the cardInterface controlled
     * @return true if the cardInterface is created according the game rules, false otherwise.
     */
    boolean isCardInLimit(Card card);

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
     * This method set the number of cards in the deck at the start of the game
     * @param starter the number of starter cards
     */
    void setDeckStarter(int starter);

    /**
     * This method get the number of cards in the deck at the start of the game
     * @return the number of starter cards
     */
    int getDeckStarter();

    /**
     * This method control if a deck is created according the game rules by checking the number of the cards,
     * if the cards are legally created and if the number of cards are in rules limit during the game
     * @param deck the deck controlled
     * @return true if the deck is created according the game rules, false otherwise.
     */
    boolean isDeckInLimit(Deck deck);

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

    /**
     * This method control if a hand is created according the game rules by checking the number of the cards
     * and if the number of cards are in rules limit during the game
     * @param hand the hand controlled
     * @return true if the hand is created according the game rules, false otherwise.
     */
    boolean isHandInLimit(Hand hand);
}