package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.DeckInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * This class implements {@link DeckInterface} and will represent a deck of a generic game.
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRules} to manage the maximum and minimum number of cards that a deck can have.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<Card>} to avoid privacy leak.
 */
public class Deck implements DeckInterface, Comparable<Deck>, Serializable {

    private final ArrayList<Card> deck;
    private GameRules rules;

    public Deck(){
        this.deck = null;
    }

    public Deck(GameRules gameRules, ArrayList<Card> newDeck, int starter){
        this.rules = gameRules.clone();
        this.rules.setDeckStarter(starter);
        if(newDeck.size() >= this.rules.getDeckMin()
                && newDeck.size() <= this.rules.getDeckMax()
                && newDeck.size() == this.rules.getDeckStarter()) {
            this.deck = new ArrayList<>(newDeck);
        } else throw new IllegalArgumentException("The new deck must be in rule's limits");
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    @Override
    public void add(Card card) {
        if(this.getDeckCards().size()+1 <= this.rules.getDeckMax()){
            this.deck.add(card);
        }
    }

    @Override
    public void remove(Card card) {
        remove(Predicate.isEqual(card));
    }

    @Override
    public void remove(int index) {
        remove(card -> (card == getCard(index)));
    }

    @Override
    public void remove(Predicate<Card> p){
        this.deck.removeIf(card -> p.test(card) && this.deck.size()-1 >= this.rules.getDeckMin());
    }

    @Override
    public void sortAscending() {
        Collections.sort(this.deck);
    }

    @Override
    public void sortDescending() {
        this.deck.sort(Collections.reverseOrder());
    }

    @Override
    public void sortBySuit() {
        this.deck.sort((card1, card2) -> card1.getSuit().compareToIgnoreCase(card2.getSuit()));
    }

    @Override
    public int getCardCount() {
        this.deck.trimToSize();
        return this.deck.size();
    }

    @Override
    public Card getCard(int index) {
        return this.deck.get(index);
    }

    @Override
    public Card getFirstCard() {
        return getCard(0);
    }

    @Override
    public Card getLastCard() {
        return getCard(this.deck.size()-1);
    }

    @Override
    public ArrayList<Card> getDeckCards() {
        return this.deck;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Deck deck)) return false;
        return getDeckCards().equals(deck.getDeckCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeckCards());
    }

    @Override
    public String toString() {
        return "\nDeck: " + this.deck.toString();
    }

    @Override
    public int compareTo(Deck toCompare) {
        return Integer.compare(this.getCardCount(), toCompare.getCardCount());
    }
}
