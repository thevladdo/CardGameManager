package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be extended by "Card" class which will represent a generic card
 */
public interface CardInterface {

    /**
     * Method for setting the card suit
     * @param suit the card suit
     */
    void setSuit(String suit);

    /**
     * Method for getting the card suit
     * @return the card suit
     */
    String getSuit();

    /**
     * Method for setting the card value
     * @param value the card value
     */
    void setValue(int value);

    /**
     * Method for getting the card value
     * @return the card value
     */
    int getValue();

    /**
     * Method for setting the card color
     * @param color the color of the card
     */
    void setColor(String color);

    /**
     * Method for getting the card color
     * @return the color of the card
     */
    String getColor();
}
