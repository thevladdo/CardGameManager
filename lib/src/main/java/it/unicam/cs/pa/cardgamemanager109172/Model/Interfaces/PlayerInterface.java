package it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces;

/**
 * This interface will be implemented by "Player" class which will represent a player or a bot.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link HandInterface} to avoid privacy leak.
 */
public interface PlayerInterface {

    /**
     * This method draws a card from the deck and adds it to the player's hand.
     * Use isInLimit() to control if the new number of card in the hand complies with the rules of the game.
     * @param position the position in the hand of the card that will be placed
     */
    void drawCard(DeckInterface deck, int position);

    /**
     * This method places a card from the hand down on the table and removes it in the player's hand.
     * Use {@link HandInterface} isInLimit() method to control if the new number of card in the hand complies
     * with the rules of the game.
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
     * This method add a determinate amount of points to the total points reached by the player
     * @param points the points value that will be added
     */
    void addPoints(int points);

    /**
     * This method remove a determinate amount of points from the total points reached by the player
     * @param points the points value that will be added
     */
    void removePoints(int points);

    /**
     * This method get actual amount of points of the player
     * @return the actual amount of points
     */
    int getPoints();

    /**
     * This method get the cards in the player's hand
     * @return the Hand
     */
    HandInterface getHand();
}
