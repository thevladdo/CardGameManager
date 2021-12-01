package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be extended by "Player" class which will represent a player or a bot
 */
public interface PlayerInterface {

    /**
     * This method set the Name of the player
     */
    void setName();

    /**
     * This method get the Name of the player
     * @return the name
     */
    String getName();

    /**
     * This method set the unique ID of the player
     * @param newID the ID
     */
    void setID(int newID);

    /**
     * This method get the unique ID of the player
     * @return the ID
     */
    int getID();

    /**
     * This method set actual amount of points of the player
     */
    void setPoints(int points);

    /**
     * This method get actual amount of points of the player
     * @return the actual amount of points
     */
    int getPoints();

    /**
     * This method set the cards in the player's hand
     * @param hand the Hand
     */
    void setHand(HandInterface hand);

    /**
     * This method get the cards in the player's hand
     * @return the Hand
     */
    HandInterface getHand();


}
