package it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces;

import java.util.ArrayList;

/**
 * This interface will be implemented by the "Table" class which will represent the table in a generic card game.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<PlayerInterface>} to avoid privacy leak.
 */
public interface TableInterface {

    /**
     * This method show the cards on the table
     * @return the cards on the table
     */
    ArrayList<CardInterface> getOnTableCards();

    /**
     * This method add a card on the table
     * @param card the card that will be added
     */
    void addCard(CardInterface card);

    /**
     * This method remove a card on the table
     * @param card the card that will be removed
     */
    void removeCard(CardInterface card);

    /**
     * This method show the discarded cards from the table
     * @return the cards discarded from the table
     */
    ArrayList<CardInterface> getDiscardedCards();

    /**
     * This method show a list of players that are playing at this moment
     * @return a list of players
     */
    ArrayList<PlayerInterface> getPlayers();

    /**
     * This method add a {@link PlayerInterface} at the table
     * @param player the player that will be added
     */
    void addPlayer(PlayerInterface player);

    /**
     * This method remove a {@link PlayerInterface} from the table
     * @param player the player that will be removed
     */
    void removePlayer(PlayerInterface player);

    /**
     * This method remove a {@link PlayerInterface} from the table
     * @param position the player's position that will be removed
     */
    void removePlayer(int position);

    /**
     * This method show the player that is playing at this moment
     * @param position the position of player
     * @return the player
     */
    PlayerInterface getPlayer(int position);
}
