package it.unicam.cs.pa.cardgamemanager109172.Model;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.DeckInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class implements {@link DeckInterface} and will represent a deck of a generic game.
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRules} to manage the maximum and minimum number of cards that a deck can have.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<Card>} to avoid privacy leak.
 */
public class Deck implements DeckInterface{

    private final ArrayList<Card> deck;

    public Deck(){
        this.deck = null;
    }

    public Deck(GameRules gameRules, ArrayList<Card> deck){
        if(deck.size() >= gameRules.getDeckMin()
                && deck.size() <= gameRules.getDeckMax()
                && deck.size() == gameRules.getDeckStarter()) {
            this.deck = new ArrayList<>(deck.size());
            this.deck.addAll(deck);
        } else throw new IllegalArgumentException("The new deck must be in rule's limits");
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    @Override
    public void add(CardInterface card) {
        this.deck.add((Card) card);
    }

    @Override
    public void remove(CardInterface card) {
        this.deck.remove((Card) card);
    }

    @Override
    public void sortAscending() {
        Collections.sort(this.deck);
    }

    @Override
    public void sortDescending() {
        this.deck.sort((card1, card2) -> Integer.compare(card2.getValue(), card1.getValue()));
    }

    @Override
    public void sortBySuit() {

    }

    @Override
    public int getCardCount() {
        return 0;
    }

    @Override
    public CardInterface getCard(int index) {
        return null;
    }

    @Override
    public CardInterface getFirstCard() {
        return null;
    }

    @Override
    public CardInterface getLastCard() {
        return null;
    }

    @Override
    public ArrayList<CardInterface> getDeck() {
        return null;
    }
}
