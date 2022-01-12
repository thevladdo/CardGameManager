package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.HandInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
        if(this.getHand().size()+1 < this.rules.getMaxHandCount()){
            this.getHand().add(card);
        }
    }

    public void remove(Card card) {
        if(this.getHand().size()-1 > this.rules.getMinHandCount()){
            this.getHand().remove(card);
        }
    }

    public void remove(int index) {
        if(this.getHand().size()-1 > this.rules.getMinHandCount()){
            this.getHand().remove(index);
        }
    }

    @Override
    public void moveTo(Card card, int index) {
        super.getDeck().remove(card);
        super.getDeck().add(index,card);
    }

    @Override
    public void clear() {
        super.getDeck().clear();
    }

    @Override
    public Card getLowestCard() {
        return Collections.min(super.getDeck());
    }

    @Override
    public Card getHighestCard() {
        return Collections.max(super.getDeck());
    }

    @Override
    public ArrayList<Card> getHand(){
        return super.getDeck();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Hand hand)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getHand(), hand.getHand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHand());
    }

    @Override
    public String toString() {
        return "\nHAND: " + super.getDeck().toString();
    }
}
