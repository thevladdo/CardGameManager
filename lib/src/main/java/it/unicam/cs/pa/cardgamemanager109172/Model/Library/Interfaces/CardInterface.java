package it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces;

/**
 * This interface will be implemented by "Card" class which will represent a generic card.
 * The constructor of the class that extended this interface will create the Card with
 * the attributes "Suit","Values" and "Color" that will never change during the game.
 * The constructor of this class will have as argument an object of type {@link GameRulesInterface}
 * that will be used to know what will be the minimum and maximum value of a card and to set a weight.
 */
public interface CardInterface {

    /**
     * Method for getting the card suit
     * @return the card suit
     */
    String getSuit();

    /**
     * Method for getting the card value
     * @return the card value
     */
    int getValue();

    /**
     * Method for getting the card color
     * @return the color of the card
     */
    String getColor();

    /**
     * Method for getting the weight of the card according to the specific game rules
     * @return the weight of the card
     */
    int getWeight();
}
