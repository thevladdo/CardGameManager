package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.util.ArrayList;

/**
 * This interface will be extended by the "Deck" class which will represent a deck of a generic game
 */
public interface Deck {

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
     * This method will sort the cards in the deck in ascending order based on their value
     */
    void sortAscending();

    /**
     * This method will sort the cards in the deck in descending order based on their value
     */
    void sortDescending();

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
     * This method changes the deck of cards
     * @param cards cards of the new deck
     */
    void setDeck(ArrayList<Card> cards);

    /**
     * This method return the actual deck
     * @return the actual deck
     */
    ArrayList<Card> getDeck();
}
