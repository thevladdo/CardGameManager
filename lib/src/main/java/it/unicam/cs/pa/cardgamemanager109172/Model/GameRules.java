package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.DeckInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.GameRulesInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.HandInterface;

import java.util.Map;

/**
 * This class implements {@link GameRulesInterface} and will represent basic rules of a generic card game.
 * It contains all the behavior concerning the rules.
 * The constructor will create a Map to associate a card with a weight value.
 */
public class GameRules implements GameRulesInterface{

    private final Map<CardInterface,Integer> cardWeight;
    private int minCardValue;
    private int maxCardValue;
    private int deckMin;
    private int deckMax;
    private int deckStarter;
    private int minHand;
    private int maxHand;
    private int handStarter;

    public GameRules(){
        this(0,0,0,0,0,0,0,0,null);
    }

    public GameRules(
            int minCardValue, int maxCardValue,
            int deckMin, int deckMax, int deckStarter,
            int minHand, int maxHand, int handStarter,
            Map<CardInterface,Integer> map)
    {
        this.cardWeight = map;
        this.minCardValue = minCardValue;
        this.maxCardValue = maxCardValue;
        this.deckMin = deckMin;
        this.deckMax = deckMax;
        this.deckStarter = deckStarter;
        this.minHand = minHand;
        this.maxHand = maxHand;
        this.handStarter = handStarter;
    }

    @Override
    public void setCardWeight(CardInterface card, int weight) {
        this.cardWeight.put(card,weight);
    }

    @Override
    public Integer getCardWeight(CardInterface card) {
        return this.cardWeight.get(card);
    }

    @Override
    public void setMinCardValue(int minValue) {
        this.minCardValue = minValue;
    }

    @Override
    public int getMinCardValue() {
        return this.minCardValue;
    }

    @Override
    public void setMaxCardValue(int maxValue) {
        this.maxCardValue = maxValue;
    }

    @Override
    public int getMaxCardValue() {
        return this.maxCardValue;
    }

    @Override
    public boolean isCardInLimit(CardInterface card) {
        int cardValue = card.getValue();
        return (cardValue >= this.getMinCardValue()) && (cardValue <= this.getMaxCardValue());
    }

    @Override
    public void setDeckMin(int min) {
        this.deckMin = min;
    }

    @Override
    public int getDeckMin() {
        return this.deckMin;
    }

    @Override
    public void setDeckMax(int max) {
        this.deckMax = max;
    }

    @Override
    public int getDeckMax() {
        return this.deckMax;
    }

    @Override
    public void setDeckStarter(int starter) {
        this.deckStarter = starter;
    }

    @Override
    public int getDeckStarter() {
        return this.deckStarter;
    }

    @Override
    public boolean isDeckInLimit(DeckInterface deck) {
        int cardCount = deck.getCardCount();
        return (cardCount >= this.getDeckMin()) && (cardCount <= this.getDeckMax());
    }

    @Override
    public void setMinHandCount(int min) {
        this.minHand = min;
    }

    @Override
    public int getMinHandCount() {
        return this.minHand;
    }

    @Override
    public void setMaxHandCount(int max) {
        this.maxHand = max;
    }

    @Override
    public int getMaxHandCount() {
        return this.maxHand;
    }

    @Override
    public void setHandStarter(int starter) {
        this.handStarter = starter;
    }

    @Override
    public int getHandStarter() {
        return this.handStarter;
    }

    @Override
    public boolean isHandInLimit(HandInterface hand) {
        int cardCount = hand.getCardCount();
        return (cardCount >= this.getMinHandCount()) && (cardCount <= this.getMaxHandCount());
    }
}
