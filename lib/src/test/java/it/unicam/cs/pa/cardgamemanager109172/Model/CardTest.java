package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card initCard(String suit, String name, int value, int weight){
        Map<CardInterface, Integer> map = new HashMap<>(1);
        GameRules rules = new GameRules(
                0, 20,
                0, 20, 3,
                0, 10, 0, map);
        return new Card(suit,name,value,rules,weight);
    }

    @Test
    void getSuit() {
    }

    @Test
    void getValue() {
    }

    @Test
    void getColor() {
    }

    @Test
    void shouldBeEquals() {
        Card card = initCard("Cuori","Rosso",5,5);
        Object o = new Object();
        Card sameCard = initCard("Cuori","Rosso",5,5);
        Card otherCard = initCard("Cuori","Rosso",10,1);
        assertThrows(NullPointerException.class, () -> card.equals(null));
        assertFalse(card.equals(o));
        assertTrue(card.equals(card));
        assertTrue(card.equals(sameCard));
        assertFalse(card.equals(otherCard));
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }

    @Test
    void compareTo() {
    }
}