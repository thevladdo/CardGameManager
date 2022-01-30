package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.DeckInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.GameRulesInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * This class implements {@link DeckInterface} and will represent a deck of a generic game.
 * The constructor of the class that will implement this interface will have as argument an object of
 * {@link GameRulesInterface} to manage the maximum and minimum number of cards that a deck can have.
 * The constructor of the class that will implement this interface will have as argument an
 * {@link ArrayList<CardInterface>} to avoid privacy leak.
 */
public class Deck implements DeckInterface{

    private final ArrayList<CardInterface> deck;
    private GameRulesInterface rules;

    public Deck(){
        this.deck = null;
    }

    public Deck(GameRulesInterface gameRules, ArrayList<CardInterface> newDeck, int starter){
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
    public void add(CardInterface card) {
        if(this.getDeckCards().size()+1 <= this.rules.getDeckMax()){
            this.deck.add(card);
        }
    }

    @Override
    public void remove(CardInterface card) {
        remove(Predicate.isEqual(card));
    }

    @Override
    public void remove(int index) {
        remove(card -> (card == getCard(index)));
    }

    @Override
    public void remove(Predicate<CardInterface> p){
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
    public CardInterface getCard(int index) {
        return this.deck.get(index);
    }

    @Override
    public CardInterface getFirstCard() {
        if (this.getCardCount() == 0) return null;
        return getCard(0);
    }

    @Override
    public CardInterface getLastCard() {
        return getCard(this.deck.size()-1);
    }

    @Override
    public ArrayList<CardInterface> getDeckCards() {
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
    public int compareTo(DeckInterface toCompare) {
        return Integer.compare(this.getCardCount(), toCompare.getCardCount());
    }
}
