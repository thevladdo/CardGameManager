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
     * @param cards location of the table where the card will be placed
     */
    void addCard(CardInterface card, ArrayList<CardInterface> cards);

    /**
     * This method remove a card on the table
     * @param card the card that will be removed
     * @param cards location of the table where the card will be placed
     */
    void removeCard(CardInterface card, ArrayList<CardInterface> cards);

}
