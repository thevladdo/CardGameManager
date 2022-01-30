package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.GameRulesInterface;
import java.util.Objects;

/**
 * This class implements {@link CardInterface} and will represent a generic card.
 * The constructor of this class will create the Card with the attributes "Suit","Values" and "Color"
 * that will never change during the game.
 * The constructor of this class will have as argument an object of type {@link GameRulesInterface}
 * that will be used to know what will be the minimum and maximum value of a card and to set a weight.
 */
public class Card implements CardInterface{

    private final GameRulesInterface rules;
    private final String suit;
    private final String color;
    private final int value;
    private final int weight;

    public Card(GameRulesInterface gameRules){
        this.rules = gameRules;
        this.suit = "";
        this.color = "";
        this.value = gameRules.getMinCardValue();
        this.weight = -1;
        this.rules.setCardWeight(this,this.weight);
    }

    public Card(String suit, String color, int value, GameRulesInterface gameRules, int weight){
        this.rules = gameRules;
        if(this.rules.getMinCardValue() <= value && this.rules.getMaxCardValue() >= value){
            this.value = value;
        } else throw new IllegalArgumentException("The value of the card must be in rule's limits");
        this.suit = suit;
        this.color = color;
        this.weight = weight;
        this.rules.setCardWeight(this,this.weight);
    }

    @Override
    public String getSuit() {
        return this.suit;
    }


    @Override
    public int getValue() {
        return this.value;
    }


    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getWeight(){
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return this.getValue() == card.getValue() &&
                this.getSuit().equals(card.getSuit()) &&
                this.getColor().equals(card.getColor()) &&
                this.getWeight() == card.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getColor(), getValue(), getWeight());
    }

    @Override
    public String toString() {
        return "\nCARD: " +
                "\nSuit = " + this.suit +
                "\nColor = " + this.color +
                "\nValue = " + this.value +
                "\nWeight = " + this.weight;
    }


    @Override
    public int compareTo(CardInterface otherCard) {
        return Integer.compare(this.getValue(), otherCard.getValue());
    }
}