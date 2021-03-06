package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.DeckInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.GameRulesInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.HandInterface;
import java.util.Map;
import java.util.Objects;

/**
 * This class implements {@link GameRulesInterface} and will represent basic rules of a generic card game.
 * It contains all the behavior concerning the rules.
 * The constructor will create a Map to associate a card with a weight value.
 */
public class GameRules implements GameRulesInterface{

    private final Map<CardInterface, Integer> cardWeight;
    private int minCardValue;
    private int maxCardValue;
    private int deckMin;
    private int deckMax;
    private int deckStarter;
    private int minHand;
    private int maxHand;

    public GameRules(){
        this(0,0,
                0,0,0,
                0,0,
                null);
    }

    public GameRules(
            int minCardValue, int maxCardValue,
            int deckMin, int deckMax, int deckStarter,
            int minHand, int maxHand,
            Map<CardInterface, Integer> map)
    {
        this.cardWeight = map;
        this.minCardValue = minCardValue;
        this.maxCardValue = maxCardValue;
        this.deckMin = deckMin;
        this.deckMax = deckMax;
        this.deckStarter = deckStarter;
        this.minHand = minHand;
        this.maxHand = maxHand;
    }

    @Override
    public void setCardWeight(CardInterface card, int weight) {
        if(card == null) throw new NullPointerException("Card object must be not null");
        this.cardWeight.put(card,weight);
    }

    @Override
    public Integer getCardWeight(CardInterface card) {
        return this.cardWeight.get(card);
    }

    @Override
    public Map<CardInterface, Integer> getCardWeight() {
        return this.cardWeight;
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
    public boolean isHandInLimit(HandInterface hand) {
        int cardCount = hand.getCardCount();
        return (cardCount >= this.getMinHandCount()) && (cardCount <= this.getMaxHandCount());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof GameRules rules)) return false;
        return getMinCardValue() == rules.getMinCardValue()
                && getMaxCardValue() == rules.getMaxCardValue()
                && getDeckMin() == rules.getDeckMin()
                && getDeckMax() == rules.getDeckMax()
                && getDeckStarter() == rules.getDeckStarter()
                && getMinHandCount() == rules.getMinHandCount()
                && getMaxHandCount() == rules.getMaxHandCount()
                && getCardWeight().equals(rules.getCardWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getCardWeight(), getMinCardValue(), getMaxCardValue(),
                getDeckMin(), getDeckMax(), getDeckStarter(),
                getMinHandCount(), getMaxHandCount());
    }

    @Override
    public String toString() {
        return "\nGAME RULES: " +
                "\nCard Weight = " + cardWeight.toString() +
                "\n Minimum Card Value = " + minCardValue +
                "\n Maximum Card Value = " + maxCardValue +
                "\n Minimum Cards number in Deck = " + deckMin +
                "\n Maximum Cards number in Deck = " + deckMax +
                "\n Starter number of Cards in Deck = " + deckStarter +
                "\n Minimum Cards number in Hand = " + minHand +
                "\n Maximum Cards number in Hand = " + maxHand;
    }

    @Override
    public GameRulesInterface clone() {
        try {
            GameRulesInterface clone = (GameRulesInterface) super.clone();
            clone.setMinCardValue(this.getMinCardValue());
            clone.setMaxCardValue(this.getMaxCardValue());
            clone.setDeckMin(this.getDeckMin());
            clone.setDeckMax(this.getDeckMax());
            clone.setDeckStarter(this.getDeckStarter());
            clone.setMinHandCount(this.getMinHandCount());
            clone.setMaxCardValue(this.getMaxCardValue());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
