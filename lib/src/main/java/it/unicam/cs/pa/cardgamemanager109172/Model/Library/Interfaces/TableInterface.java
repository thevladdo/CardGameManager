package it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces;

import java.util.ArrayList;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;

/**
 * This interface will be implemented by the "Table" class which will represent the table in a generic card game.
 * The constructor of the class that will implement this interface will have as argument an {@link ArrayList<Player>}
 * to avoid privacy leak.
 */
public interface TableInterface {

    /**
     * This method show the cards on the table
     * @return the cards on the table
     */
    ArrayList<Card> getOnTableCards();

    /**
     * This method add a card on the table
     * @param card the card that will be added
     */
    void addCard(Card card);

    /**
     * This method remove a card on the table
     * @param card the card that will be removed
     */
    void removeCard(Card card);

    /**
     * This method show the discarded cards from the table
     * @return the cards discarded from the table
     */
    ArrayList<Card> getDiscardedCards();

    /**
     * This method show a list of players that are playing at this moment
     * @return a list of players
     */
    ArrayList<Player> getPlayers();

    /**
     * This method add a {@link Player} at the table
     * @param player the player that will be added
     */
    void addPlayer(Player player);

    /**
     * This method remove a {@link Player} from the table
     * @param player the player that will be removed
     */
    void removePlayer(Player player);

    /**
     * This method remove a {@link Player} from the table
     * @param position the player's position that will be removed
     */
    void removePlayer(int position);

    /**
     * This method show the player that is playing at this moment
     * @param position the position of player
     * @return the player
     */
    Player getPlayer(int position);
}
