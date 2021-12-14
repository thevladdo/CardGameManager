package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.*;
import java.util.ArrayList;

public class Hand extends Deck implements HandInterface {

    private final ArrayList<Card> hand;

    public Hand(){
        this.hand = null;
    }

    public Hand(GameRules gameRules, ArrayList<Card> hand){
        if(hand.size() >= gameRules.getMinHandCount()
                && hand.size() <= gameRules.getMaxHandCount()
                && hand.size() == gameRules.getHandStarter()) {
            this.hand = new ArrayList<>(hand.size());
            this.hand.addAll(hand);
        } else throw new IllegalArgumentException("The new deck must be in rule's limits");
    }

    //TODO Implement Methods
    @Override
    public void moveTo(Card card, int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void discard(Card card) {

    }

    @Override
    public int getCardCount(){
        this.hand.trimToSize();
        return this.hand.size();
    }

    @Override
    public boolean isInLimit(GameRules rules) {
        return false;
    }

    @Override
    public Card getLowestCard() {
        return null;
    }

    @Override
    public Card getHighestCard() {
        return null;
    }

    @Override
    public ArrayList<Card> getHand(){
        return this.hand;
    }
}
