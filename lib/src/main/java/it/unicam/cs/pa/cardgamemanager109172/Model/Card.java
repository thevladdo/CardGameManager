package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.util.Objects;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;

/**
 * This class implements {@link CardInterface} and will represent a generic card.
 * The constructor of this class will create the Card with the attributes "Suit","Values" and "Color"
 * that will never change during the game.
 * The constructor of this class will have as argument an object of type {@link GameRules}
 * that will be used to know what will be the minimum and maximum value of a card and to set a weight.
 */
public class Card implements CardInterface, Comparable<Card>{

    private final String suit;
    private final String color;
    private final int value;

    public Card(GameRules gameRules){
        this.suit = null;
        this.color = null;
        this.value = gameRules.getMinCardValue();
        gameRules.setCardWeight(this,0);
    }

    public Card(String suit, String color, int value, GameRules gameRules, int weight){
        if(gameRules.getMinCardValue() <= value && gameRules.getMaxCardValue() >= value){
            this.value = value;
        } else throw new IllegalArgumentException("The value of the card must be in rule's limits");
        this.suit = suit;
        this.color = color;
        gameRules.setCardWeight(this,weight);
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
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (!(o instanceof Card)) return false;
        if (this == o) return true;
        Card card = (Card) o;
        return this.getValue() == card.getValue() &&
                this.getSuit().equals(card.getSuit()) &&
                this.getColor().equals(card.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getColor(), getValue());
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", color='" + color + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(this.getValue(), otherCard.getValue());
    }
}