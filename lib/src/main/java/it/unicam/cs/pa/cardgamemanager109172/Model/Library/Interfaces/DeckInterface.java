package it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * This interface will be implemented by the "Deck" class which will represent a deck of a generic game.
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRulesInterface} to manage the maximum and minimum number of cards that a deck can have.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<CardInterface>} to avoid privacy leak.
 */
public interface DeckInterface extends Comparable<DeckInterface>{

    /**
     * This method randomly mix the order of the cards in the deck.
     * This method may not shuffle because the {@link Collections}'s shuffle() method
     * has the probability to return the elements of the input in the same order.
     * The size of the deck can proportionally increase or decrease this probability.
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
     * This method removes a card from the deck
     * @param index the index if the card that will be removed from the deck
     */
    void remove(int index);

    /**
     * This method removes a card from the deck that satisfy a certain Predicate
     * @param p the Predicate used to find the card
     */
    void remove(Predicate<CardInterface> p);

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
     * This method return the actual deck
     * @return the actual cards in the deck
     */
    ArrayList<CardInterface> getDeckCards();
}
