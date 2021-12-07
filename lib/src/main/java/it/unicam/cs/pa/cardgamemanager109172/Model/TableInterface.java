package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.util.ArrayList;

/**
 * This interface will be implemented by the "Table" class which will represent the table in a generic card game
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
}
