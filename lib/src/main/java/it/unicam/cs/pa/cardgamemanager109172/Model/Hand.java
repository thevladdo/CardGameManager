package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.*;

public class Hand extends Deck implements HandInterface {

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
}
