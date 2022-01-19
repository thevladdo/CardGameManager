package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.HandInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

public class Hand extends Deck implements HandInterface {

    private GameRules rules;

    public Hand(){
        super();
    }

    public Hand(GameRules gameRules, ArrayList<Card> hand, int starter){
        super(gameRules,hand,starter);
        this.rules = gameRules;
    }

    public void add(Card card) {
        if(this.getCards().size()+1 <= this.rules.getMaxHandCount()){
            this.getCards().add(card);
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
    public void remove(Predicate<Card> p) {
        this.getDeckCards().removeIf(card -> p.test(card) &&
                this.getDeckCards().size()-1 >= this.rules.getMinHandCount());
    }

    @Override
    public void moveTo(Card card, int index) {
        super.getDeckCards().remove(card);
        super.getDeckCards().add(index,card);
    }

    @Override
    public void clear() {
        super.getDeckCards().clear();
    }

    @Override
    public Card getLowestCard() {
        return Collections.min(super.getDeckCards());
    }

    @Override
    public Card getHighestCard() {
        return Collections.max(super.getDeckCards());
    }

    @Override
    public ArrayList<Card> getCards(){
        return super.getDeckCards();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Hand hand)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCards(), hand.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCards());
    }

    @Override
    public String toString() {
        return "\nHAND: " + super.getDeckCards().toString();
    }
}
