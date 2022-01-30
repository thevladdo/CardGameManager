package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.CardInterface;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Card card1;
    private Card card2;
    private Card card3;
    private GameRules rules;

    private Deck createDeck(){
        Map<CardInterface, Integer> map = new HashMap<>(3);
        rules = new GameRules(
                0, 20,
                0, 20,0,
                0, 10, map);
        card1 = new Card("Hearts","Red",5, rules,5);
        card2 = new Card("Hearts","Red",6, rules,6);
        card3 = new Card("Hearts","Red",11, rules,11);
        ArrayList<CardInterface> deckCards = new ArrayList<>(3);
        deckCards.add(card2);
        deckCards.add(card1);
        deckCards.add(card3);
        return new Deck(rules, deckCards,3);
    }

    /**
     * This Test may fail because the {@link Collections}'s shuffle() method
     * has the probability to return the elements of the input in the same order.
     * The size of the deck can proportionally increase or decrease this probability.
     */
    @Test
    void shouldShuffle() {
        DeckConfigFactory factory = new DeckConfigFactory(
                new GameRules(0,14,
                        0,54,54,
                        0,10,new HashMap<>(54)));
        Deck toShuffle = factory.FrenchDeck();
        ArrayList<CardInterface> toShuffleDeck = new ArrayList<>(toShuffle.getDeckCards());
        assertEquals(toShuffleDeck,toShuffle.getDeckCards());
        toShuffle.shuffle();
        assertNotEquals(toShuffleDeck,toShuffle.getDeckCards());
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
    void shouldRemoveObject() {
        Deck testDeck = createDeck();
        assertEquals(3,testDeck.getCardCount());
        ArrayList<Card> expected = new ArrayList<>(2);
        expected.add(this.card2);
        expected.add(this.card1);
        testDeck.remove(this.card3);
        assertEquals(2,testDeck.getCardCount());
        assertEquals(expected,testDeck.getDeckCards());
        testDeck.remove(this.card2);
        testDeck.remove(this.card1);
        assertEquals(0,testDeck.getCardCount());
    }

    @Test
    void shouldRemoveByIndex() {
        Deck testDeck = createDeck();
        assertEquals(3,testDeck.getCardCount());
        ArrayList<Card> expected = new ArrayList<>(2);
        expected.add(this.card2);
        expected.add(this.card1);
        testDeck.remove(2);
        assertEquals(2,testDeck.getCardCount());
        assertEquals(expected,testDeck.getDeckCards());
        testDeck.remove(1);
        testDeck.remove(0);
        assertEquals(0,testDeck.getCardCount());
    }

    @Test
    void shouldSortBySuit() {
        Deck testDeck = createDeck();
        Card aces = new Card("Aces","Black",5,this.rules,5);
        Card joker = new Card("Joker","Black",0,this.rules,15);
        testDeck.add(aces);
        testDeck.add(joker);
        ArrayList<Card> expected = new ArrayList<>(4);
        expected.add(aces);
        expected.add(card2);
        expected.add(card1);
        expected.add(card3);
        expected.add(joker);
        testDeck.sortBySuit();
        assertEquals(expected,testDeck.getDeckCards());
    }

    @Test
    void shouldBeSortedAscending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card1);
        sorted.add(card2);
        sorted.add(card3);
        testDeck.sortAscending();
        assertEquals(sorted,testDeck.getDeckCards());
    }

    @Test
    void shouldBeSortedDescending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card3);
        sorted.add(card2);
        sorted.add(card1);
        testDeck.sortDescending();
        assertEquals(sorted,testDeck.getDeckCards());
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
        testDeck.remove(card -> true);
        assertEquals(0,testDeck.getCardCount());
        assertNull(testDeck.getFirstCard());
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
        assertEquals(expected,testDeck.getDeckCards());
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
        ArrayList<CardInterface> secondDeckCards = new ArrayList<>(3);
        secondDeckCards.add(new Card(this.rules));
        secondDeckCards.add(new Card(this.rules));
        secondDeckCards.add(new Card(this.rules));
        Deck secondDeck = new Deck(rules,secondDeckCards,3);
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
                Value = 6
                Weight = 6,\s
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 5
                Weight = 5,\s
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 11
                Weight = 11]""";
        assertEquals(expected,testDeck.toString());
    }


    @Test
    void shouldCompareTo() {
        Deck testDeck = createDeck();
        Deck sameDeck = createDeck();
        ArrayList<CardInterface> otherDeckCards = new ArrayList<>(3);
        otherDeckCards.add(new Card("Heart","Red",6,rules,5));
        otherDeckCards.add(new Card("Heart","Red",2,rules,5));
        otherDeckCards.add(new Card("Heart","Red",5,rules,5));
        Deck otherDeck = new Deck(rules,otherDeckCards,3);
        otherDeck.add(new Card("Aces","Black",1,rules,14));
        assertEquals(0,testDeck.compareTo(sameDeck));
        assertEquals(-1,testDeck.compareTo(otherDeck));
        sameDeck.remove(card1);
        assertEquals(+1,testDeck.compareTo(sameDeck));
    }
}