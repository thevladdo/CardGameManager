package it.unicam.cs.pa.cardgamemanager109172.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    private Map<Card, Integer> map;

    private GameRules createRules(){
        this.map = new HashMap<>(1);
        return new GameRules(
                0,15,
                0,52,1,
                1,10,2,map);
    }

    @Test
    void shouldSetCardWeight() {
        GameRules rules = createRules();
        Card card = new Card(rules);
        rules.setCardWeight(card,5);
        assertTrue(map.containsKey(card));
        assertTrue(map.containsValue(5));
        assertEquals(5,rules.getCardWeight(card));
        assertThrows(NullPointerException.class,()-> rules.setCardWeight(null,5));
    }

    @Test
    void shouldGetCardWeight() {
        GameRules rules = createRules();
        Card card = new Card("Heart","Red",5,rules,5);
        assertEquals(5,rules.getCardWeight(card));
    }

    @Test
    void shouldSetMinCardValue() {
        GameRules rules = createRules();
        assertEquals(0,rules.getMinCardValue());
        rules.setMinCardValue(2);
        assertEquals(2,rules.getMinCardValue());
    }

    @Test
    void shouldGetMinCardValue() {
        GameRules rules = createRules();
        assertEquals(0,rules.getMinCardValue());
    }

    @Test
    void shouldSetMaxCardValue() {
        GameRules rules = createRules();
        assertEquals(15,rules.getMaxCardValue());
        rules.setMaxCardValue(20);
        assertEquals(20,rules.getMaxCardValue());
    }

    @Test
    void shouldGetMaxCardValue() {
        GameRules rules = createRules();
        assertEquals(15,rules.getMaxCardValue());
    }

    @Test
    void shouldCheckIfCardIsInLimit() {
        GameRules rules = createRules();
        Card card = new Card("Heart","Red",2,rules,5);
        assertTrue(rules.isCardInLimit(card));
        rules.setMinCardValue(5);
        assertFalse(rules.isCardInLimit(card));
    }

    @Test
    void shouldSetDeckMin() {
        GameRules rules = createRules();
        assertEquals(0,rules.getDeckMin());
        rules.setDeckMin(20);
        assertEquals(20,rules.getDeckMin());
    }

    @Test
    void shouldGetDeckMin() {
        GameRules rules = createRules();
        assertEquals(0,rules.getDeckMin());
    }

    @Test
    void shouldSetDeckMax() {
        GameRules rules = createRules();
        assertEquals(52,rules.getDeckMax());
        rules.setDeckMax(55);
        assertEquals(55,rules.getDeckMax());
    }

    @Test
    void shouldGetDeckMax() {
        GameRules rules = createRules();
        assertEquals(52,rules.getDeckMax());
    }

    @Test
    void shouldSetDeckStarter() {
        GameRules rules = createRules();
        assertEquals(1,rules.getDeckStarter());
        rules.setDeckStarter(2);
        assertEquals(2,rules.getDeckStarter());
    }

    @Test
    void shouldGetDeckStarter() {
        GameRules rules = createRules();
        assertEquals(1,rules.getDeckStarter());
    }

    @Test
    void shouldCheckIfDeckIsInLimit() {
        GameRules rules = createRules();
        Card card = new Card("Joker","Red",15,rules,15);
        ArrayList<Card> deckCards = new ArrayList<>(1);
        deckCards.add(card);
        Deck deck = new Deck(rules,deckCards);
        assertTrue(rules.isDeckInLimit(deck));
        rules.setDeckMin(5);
        assertFalse(rules.isDeckInLimit(deck));
    }

    @Test
    void shouldSetMinHandCount() {
        GameRules rules = createRules();
        assertEquals(1,rules.getMinHandCount());
        rules.setMinHandCount(7);
        assertEquals(7,rules.getMinHandCount());
    }

    @Test
    void shouldGetMinHandCount() {
        GameRules rules = createRules();
        assertEquals(1,rules.getMinHandCount());
    }

    @Test
    void shouldSetMaxHandCount() {
        GameRules rules = createRules();
        assertEquals(10,rules.getMaxHandCount());
        rules.setMaxHandCount(52);
        assertEquals(52,rules.getMaxHandCount());
    }

    @Test
    void shouldGetMaxHandCount() {
        GameRules rules = createRules();
        assertEquals(10,rules.getMaxHandCount());
    }

    @Test
    void shouldSetHandStarter() {
        GameRules rules = createRules();
        assertEquals(2,rules.getHandStarter());
        rules.setHandStarter(1);
        assertEquals(1,rules.getHandStarter());
    }

    @Test
    void shouldGetHandStarter() {
        GameRules rules = createRules();
        assertEquals(2,rules.getHandStarter());
    }

    @Test
    void shouldCheckIfHandIsInLimit() {
        GameRules rules = createRules();
        Card card = new Card("Joker","Red",15,rules,15);
        Card card2 = new Card("Aces","Red",1,rules,14);
        ArrayList<Card> handCards = new ArrayList<>(2);
        handCards.add(card);
        handCards.add(card2);
        Hand hand = new Hand(rules,handCards);
        assertTrue(rules.isHandInLimit(hand));
        rules.setMinHandCount(5);
        assertFalse(rules.isHandInLimit(hand));
    }

    @Test
    void shouldBeEquals() {
        GameRules rules = createRules();
        GameRules sameRules = createRules();
        GameRules otherRules = new GameRules();
        Object o = new Object();
        Object sameObj = rules;
        assertThrows(NullPointerException.class, () -> rules.equals(null));
        assertTrue(rules.equals(sameObj));
        assertFalse(rules.equals(o));
        assertFalse(rules.equals(otherRules));
        assertTrue(rules.equals(sameRules));
    }

    @Test
    void testHashCode() {
        GameRules rules = createRules();
        GameRules sameRules = createRules();
        GameRules otherRules = new GameRules();
        assertNotSame(rules,otherRules);
        assertEquals(rules.hashCode(),sameRules.hashCode());
        assertNotEquals(rules.hashCode(),otherRules.hashCode());
    }

    @Test
    void testToString() {
        GameRules rules = createRules();
        String expected = "GAME RULES: " +
                "\nCard Weight = {}" +
                "\n Minimum Card Value = " + rules.getMinCardValue() +
                "\n Maximum Card Value = " + rules.getMaxCardValue() +
                "\n Minimum Cards number in Deck = " + rules.getDeckMin() +
                "\n Maximum Cards number in Deck = " + rules.getDeckMax() +
                "\n Starter number of Cards in Deck = " + rules.getDeckStarter() +
                "\n Minimum Cards number in Hand = " + rules.getMinHandCount() +
                "\n Maximum Cards number in Hand = " + rules.getMaxHandCount() +
                "\n Starter number of Cards in Hand = " + rules.getHandStarter();
        assertEquals(expected,rules.toString());
    }
}