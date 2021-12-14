package it.unicam.cs.pa.cardgamemanager109172.Model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card initCard(String suit, String name, int value, int weight){
        Map<Card, Integer> map = new HashMap<>(1);
        GameRules rules = new GameRules(
                0, 20,
                0, 20, 3,
                0, 10, 0, map);
        return new Card(suit,name,value,rules,weight);
    }

    @Test
    void shouldGetSuit() {
        Card card = initCard("King","Black",13,2);
        assertEquals("King",card.getSuit());
    }

    @Test
    void shouldGetValue() {
        Card card = initCard("Joker","Black",15,15);
        assertEquals(15,card.getValue());
    }

    @Test
    void shouldGetColor() {
        Card card = initCard("Aces","Red",1,14);
        assertEquals("Red",card.getColor());
    }

    @Test
    void shouldBeEquals() {
        Card card = initCard("Heart","Red",5,5);
        Object o = new Object();
        Card sameCard = initCard("Heart","Red",5,5);
        Card otherCard = initCard("Heart","Red",10,1);
        assertThrows(NullPointerException.class, () -> card.equals(null));
        assertFalse(card.equals(o));
        assertTrue(card.equals(sameCard));
        assertTrue(card.equals(card));
        assertFalse(card.equals(otherCard));
    }

    @Test
    void testHashCode() {
        Card card = initCard("Heart","Red",5,5);
        Card sameCard = initCard("Heart","Red",5,5);
        Card card3 = initCard("Queen","Red",5,5);
        assertNotSame(card, sameCard);
        assertEquals(card.hashCode(), sameCard.hashCode());
        assertNotEquals(card.hashCode(),card3.hashCode());
    }

    @Test
    void testToString() {
        Card card = initCard("Queen","Red",5,5);
        String expected = """
                CARD:\s
                Suit = 'Queen'
                Color = 'Red'
                Value = '5'""";
        assertEquals(expected,card.toString());
    }

    @Test
    void testCompareTo() {
        Card card = initCard("Heart","Red",5,5);
        Card card2 = initCard("Heart","Red",5,5);
        Card card3 = initCard("Heart","Red",6,5);
        Card card4 = initCard("Heart","Red",2,5);
        assertEquals(0,card.compareTo(card2));
        assertEquals(-1,card.compareTo(card3));
        assertEquals(+1,card.compareTo(card4));
    }
}