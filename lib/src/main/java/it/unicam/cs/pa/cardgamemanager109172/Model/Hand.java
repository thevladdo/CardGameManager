package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.GameRulesInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.HandInterface;

public class Hand extends Deck implements HandInterface {

    @Override
    public void moveTo(CardInterface card, int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void discard(CardInterface card) {

    }

    @Override
    public boolean isInLimit(GameRulesInterface rules) {
        return false;
    }

    @Override
    public CardInterface getLowestCard() {
        return null;
    }

    @Override
    public CardInterface getHighestCard() {
        return null;
    }
}
