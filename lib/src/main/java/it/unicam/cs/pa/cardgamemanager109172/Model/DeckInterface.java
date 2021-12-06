package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.util.ArrayList;

/**
 * This interface will be extended by the "Deck" class which will represent a deck of a generic game
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRulesInterface} to manage the maximum and minimum number of cards that a deck can have
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
    void add(CardInterface card);

    /**
     * This method removes a card from the deck
     * @param card the card that will be removed from the deck
     */
    void remove(CardInterface card);

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
     * This method returns the card to the selected location
     * @param index location of the card
     * @return the card selected
     */
    CardInterface getCard(int index);

    /**
     * This method returns the first card of the deck
     * @return the first card of the deck
     */
    CardInterface getFirstCard();

    /**
     * This method returns the last card of the deck
     * @return the last card of the deck
     */
    CardInterface getLastCard();

    /**
     * This method changes the deck of cards
     * @param cards cards of the new deck
     */
    void setDeck(ArrayList<CardInterface> cards);

    /**
     * This method return the actual deck
     * @return the actual deck
     */
    ArrayList<CardInterface> getDeck();
}