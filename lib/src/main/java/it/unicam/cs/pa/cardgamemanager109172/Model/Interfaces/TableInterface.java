package it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces;

import java.util.ArrayList;
import it.unicam.cs.pa.cardgamemanager109172.Model.*;

/**
 * This interface will be implemented by the "Table" class which will represent the table in a generic card game.
 * The constructor of the class that will implement this interface will have as argument an {@link ArrayList<Player>}
 * {@link Player} to avoid privacy leak.
 */
public interface TableInterface {

    /**
     * This method show the cards on the table
     * @return the cards on the table
     */
    ArrayList<Card> getOnTableCards();

    /**
     * This method add a cardInterface on the table
     * @param card the cardInterface that will be added
     */
    void addCard(Card card);

    /**
     * This method remove a cardInterface on the table
     * @param card the cardInterface that will be removed
     */
    void removeCard(Card card);

    /**
     * This method show a list of players that are playing at this moment
     * @return a list of players
     */
    ArrayList<Player> getPlayers();

    /**
     * This method show the player that is playing at this moment
     * @param position the position of player
     * @return the player
     */
    Player getPlayer(int position);
}