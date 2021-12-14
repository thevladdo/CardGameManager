package it.unicam.cs.pa.cardgamemanager109172.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Card card1;
    private Card card2;
    private Card card3;
    private Deck deck;

    private Deck createDeck(){
        Map<Card, Integer> map = new HashMap<>(3);
        GameRules rules = new GameRules(
                0, 20,
                0, 20, 3,
                0, 10, 0, map);
        card1 = new Card("Cuori","Rosso",5, rules,5);
        card2 = new Card("Cuori","Rosso",6, rules,6);
        card3 = new Card("Cuori","Rosso",11, rules,11);
        ArrayList<Card> toSort = new ArrayList<>(3);
        toSort.add(card2);
        toSort.add(card1);
        toSort.add(card3);
        deck = new Deck(rules, toSort);
        return deck;
    }

    @Test
    void shouldBeSortedAscending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card1);
        sorted.add(card2);
        sorted.add(card3);
        deck.sortAscending();
        assertEquals(sorted,testDeck.getDeck());
    }

    @Test
    void shouldBeSortedDescending() {
        Deck testDeck = createDeck();
        ArrayList<Card> sorted = new ArrayList<>(3);
        sorted.add(card3);
        sorted.add(card2);
        sorted.add(card1);
        deck.sortDescending();
        assertEquals(sorted,testDeck.getDeck());
    }

    //TODO OtherMethods and Equals, HashCode, toString
}