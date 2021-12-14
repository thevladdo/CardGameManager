package it.unicam.cs.pa.cardgamemanager109172.Model;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Card card1;
    private Card card2;
    private Card card3;
    private GameRules rules;

    private Deck createDeck(){
        Map<Card, Integer> map = new HashMap<>(3);
        rules = new GameRules(
                0, 20,
                0, 20, 3,
                0, 10, 0, map);
        card1 = new Card("Hearts","Red",5, rules,5);
        card2 = new Card("Hearts","Red",6, rules,6);
        card3 = new Card("Hearts","Red",11, rules,11);
        ArrayList<Card> deckCards = new ArrayList<>(3);
        deckCards.add(card2);
        deckCards.add(card1);
        deckCards.add(card3);
        return new Deck(rules, deckCards);
    }

    /**
     * This Test may fail because the {@link Collections}'s shuffle() method
     * has the probability to return the elements of the input in the same order.
     * The size of the deck can proportionally increase or decrease this probability.
     */
    @Test
    void shouldShuffle() {
        Deck toShuffle = createDeck();
        ArrayList<Card> toShuffleDeck = new ArrayList<>(toShuffle.getDeck());
        assertEquals(toShuffleDeck,toShuffle.getDeck());
        toShuffle.shuffle();
        assertNotEquals(toShuffleDeck,toShuffle.getDeck());
    }

    @Test
    void shouldAdd() {
        Deck testDeck = createDeck();
        Card willBeAdded = new Card("Aces","Black",5,this.rules,5);
        assertEquals(3,testDeck.getCardCount());
        testDeck.add(willBeAdded);
        assertEquals(4,testDeck.getCardCount());
    }

    @Test
    void shouldRemove() {
        Deck testDeck = createDeck();
        assertEquals(3,testDeck.getCardCount());
        testDeck.remove(this.card3);
        assertEquals(2,testDeck.getCardCount());
    }

    @Test
    void shouldSortBySuit() {
        Deck testDeck = createDeck();
        Card aces = new Card("Aces","Black",5,this.rules,5);
        testDeck.add(aces);
        ArrayList<Card> expected = new ArrayList<>(4);
        expected.add(aces);
        expected.add(card2);
        expected.add(card1);
        expected.add(card3);
        testDeck.sortBySuit();
        assertEquals(expected,testDeck.getDeck());
    }

    @Test
    void shouldBeSortedAscending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card1);
        sorted.add(card2);
        sorted.add(card3);
        testDeck.sortAscending();
        assertEquals(sorted,testDeck.getDeck());
    }

    @Test
    void shouldBeSortedDescending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card3);
        sorted.add(card2);
        sorted.add(card1);
        testDeck.sortDescending();
        assertEquals(sorted,testDeck.getDeck());
    }

    @Test
    void shouldGetCardCount() {
        Deck deck = createDeck();
        assertEquals(3,deck.getCardCount());
    }

    @Test
    void shouldGetCard() {
        Deck testDeck = createDeck();
        Card expected = new Card("Hearts","Red",5, rules,5);
        assertEquals(expected,testDeck.getCard(1));
    }

    @Test
    void shouldGetFirstCard() {
        Deck testDeck = createDeck();
        Card expected = new Card("Hearts","Red",6, rules,6);
        assertEquals(expected,testDeck.getFirstCard());
    }

    @Test
    void shouldGetLastCard() {
        Deck testDeck = createDeck();
        Card expected = new Card("Hearts","Red",11, rules,11);
        assertEquals(expected,testDeck.getLastCard());
    }

    @Test
    void shouldGetDeck() {
        Deck testDeck = createDeck();
        ArrayList<Card> expected = new ArrayList<>(3);
        expected.add(new Card("Hearts","Red",6, rules,6));
        expected.add(new Card("Hearts","Red",5, rules,5));
        expected.add(new Card("Hearts","Red",11, rules,11));
        assertEquals(expected,testDeck.getDeck());
    }

    @Test
    void shouldBeEquals() {
        Deck testDeck = createDeck();
        Object o = new Object();
        Deck sameDeck = createDeck();
        Deck otherDeck = new Deck();
        assertThrows(NullPointerException.class, () -> testDeck.equals(null));
        assertFalse(testDeck.equals(o));
        assertTrue(testDeck.equals(sameDeck));
        assertTrue(testDeck.equals(testDeck));
        assertFalse(testDeck.equals(otherDeck));
    }

    @Test
    void testHashCode() {
        Deck firstDeck = createDeck();
        Deck sameDeck = createDeck();
        ArrayList<Card> secondDeckCards = new ArrayList<>(3);
        secondDeckCards.add(new Card(this.rules));
        secondDeckCards.add(new Card(this.rules));
        secondDeckCards.add(new Card(this.rules));
        Deck secondDeck = new Deck(rules,secondDeckCards);
        assertNotSame(firstDeck, sameDeck);
        assertEquals(firstDeck.hashCode(), sameDeck.hashCode());
        assertNotEquals(firstDeck.hashCode(), secondDeck.hashCode());
    }

    @Test
    void testToString() {
        Deck testDeck = createDeck();
        String expected = """
                
                Deck: [
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 6,\s
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 5,\s
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 11]""";
        assertEquals(expected,testDeck.toString());
    }
}