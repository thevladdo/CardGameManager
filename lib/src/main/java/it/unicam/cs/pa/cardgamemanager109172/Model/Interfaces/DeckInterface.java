package it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces;

import java.util.ArrayList;
import it.unicam.cs.pa.cardgamemanager109172.Model.*;

/**
 * This interface will be implemented by the "Deck" class which will represent a deck of a generic game.
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRules} to manage the maximum and minimum number of cards that a deck can have.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<Card>} to avoid privacy leak.
 */
public interface DeckInterface {

    /**
     * This method randomly mix the order of the cards in the deck
     */
    void shuffle();

    /**
     * This method adds a card to the deck
     * @param card the card that will be added to the deck
     */
    void add(Card card);

    /**
     * This method removes a card from the deck
     * @param card the card that will be removed from the deck
     */
    void remove(Card card);

    /**
     * This method removes a card from the deck
     * @param index the index if the card that will be removed from the deck
     */
    void remove(int index);

    /**
     * This method will sort the cards in the deck in ascending order based on their value
     */
    void sortAscending();

    /**
     * This method will sort the cards in the deck in descending order based on their value
     */
    void sortDescending();

    /**
     * This method will sort the cards by suit
     */
    void sortBySuit();

    /**
     * This method show the actual number of cards in the deck
     * @return the actual number of cards
     */
    int getCardCount();

    /**
     * This method returns the card to the selected location
     * @param index location of the card
     * @return the card selected
     */
    Card getCard(int index);

    /**
     * This method returns the first card of the deck
     * @return the first card of the deck
     */
    Card getFirstCard();

    /**
     * This method returns the last card of the deck
     * @return the last card of the deck
     */
    Card getLastCard();

    /**
     * This method return the actual deck
     * @return the actual cards in the deck
     */
    ArrayList<Card> getDeck();
}
