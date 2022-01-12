package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Deck;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.GameRules;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Hand;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    private Card card1;
    private Card card2;
    private Card card3;
    private GameRules rules;

    private Hand createHand(){
        Map<Card, Integer> map = new HashMap<>(3);
        rules = new GameRules(
                0,15,
                0,52,0,
                0,10, map);
        card1 = new Card("Hearts","Red",5, rules,5);
        card2 = new Card("Aces","Black",1, rules,14);
        card3 = new Card("Aces","Red",1, rules,1);
        ArrayList<Card> cards = new ArrayList<>(2);
        cards.add(card1);
        cards.add(card2);
        return new Hand(rules,cards,2);
    }

    @Test
    void moveTo() {
        Hand hand = createHand();
        hand.add(card3);
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(card2);
        expected.add(card1);
        expected.add(card3);
        hand.moveTo(card1,1);
        assertEquals(expected,hand.getHand());
    }

    @Test
    void clear() {
        Hand hand = createHand();
        ArrayList<Card> expected = new ArrayList<>(0);
        assertNotEquals(expected,hand.getHand());
        hand.clear();
        assertEquals(expected,hand.getHand());
    }

    @Test
    void getLowestCard() {
        Hand hand = createHand();
        assertEquals(card2,hand.getLowestCard());
    }

    @Test
    void getHighestCard() {
        Hand hand = createHand();
        assertEquals(card1,hand.getHighestCard());
    }

    @Test
    void getHand() {
        Hand hand = createHand();
        ArrayList<Card> expected = new ArrayList<>(3);
        expected.add(card1);
        expected.add(card2);
        assertEquals(expected,hand.getHand());
    }

    @Test
    void testEquals() {
        Hand firstHand = createHand();
        Object o = new Object();
        Hand sameHand = createHand();
        ArrayList<Card> cards = new ArrayList<>(3);
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        Deck deck = new Deck(rules,cards,3);
        Hand otherHand = new Hand(rules,cards,3);
        assertThrows(NullPointerException.class, () -> firstHand.equals(null));
        assertFalse(firstHand.equals(o));
        assertTrue(firstHand.equals(sameHand));
        assertTrue(firstHand.equals(firstHand));
        assertFalse(firstHand.equals(otherHand));
        assertFalse(otherHand.equals(deck));
    }

    @Test
    void testHashCode() {
        Hand firstHand = createHand();
        Hand sameHand = createHand();
        ArrayList<Card> cards = new ArrayList<>(3);
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        Hand otherHand = new Hand(rules,cards,3);
        assertNotSame(firstHand, sameHand);
        assertEquals(firstHand.hashCode(), sameHand.hashCode());
        assertNotEquals(firstHand.hashCode(), otherHand.hashCode());
    }

    @Test
    void testToString() {
        Hand hand = createHand();
        String expected = """

                HAND: [
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 5,\s
                CARD:\s
                Suit = Aces
                Color = Black
                Value = 1]""";
        assertEquals(expected,hand.toString());
    }
}