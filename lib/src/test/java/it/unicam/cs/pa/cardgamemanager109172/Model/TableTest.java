package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private Player player1;
    private Player player2;
    private Hand hand1;
    private Card card1;
    private Card card2;
    private Card card3;
    private ArrayList<Card> tableCards;
    private ArrayList<Player> players;

    private Table createTable(){
        Map<Card,Integer> map = new HashMap<>(0);
        GameRules rules = new GameRules(0, 14, 0, 52, 2, 0, 2, map);
        card1 = new Card("Hearts","Red",5, rules,5);
        card2 = new Card("Aces","Black",1, rules,14);
        card3 = new Card("Aces","Red",1, rules,1);
        ArrayList<Card> handCards = new ArrayList<>(1);
        handCards.add(card2);
        hand1 = new Hand(rules, handCards,1);
        tableCards = new ArrayList<>(1);
        tableCards.add(card1);
        player2 = new Player(hand1,"Frank",1010);
        player1 = new Player(hand1,"Giulio",1011);
        players = new ArrayList<>(2);
        players.add(player1);
        players.add(player2);
        return new Table(tableCards,players);
    }

    @Test
    void shouldGetOnTableCards() {
        Table table = createTable();
        ArrayList<Card> expected = new ArrayList<>(1);
        expected.add(card1);
        assertEquals(expected,table.getOnTableCards());
    }

    @Test
    void shouldAddCard() {
        Table table = createTable();
        int actual = table.getOnTableCards().size();
        table.addCard(card3);
        assertNotEquals(actual,table.getOnTableCards().size());
    }

    @Test
    void shouldRemoveCard() {
        Table table = createTable();
        table.addCard(card3);
        Card expected = table.getOnTableCards().get(1);
        table.removeCard(card1);
        assertEquals(expected,table.getOnTableCards().get(0));
    }

    @Test
    void shouldGetDiscardedCards() {
        Table table = createTable();
        table.removeCard(card1);
        ArrayList<Card> expected = new ArrayList<>(1);
        expected.add(card1);
        assertEquals(expected,table.getDiscardedCards());
    }

    @Test
    void shouldGetPlayers() {
        Table table = createTable();
        ArrayList<Player> expected = new ArrayList<>(2);
        expected.add(player1);
        expected.add(player2);
        assertEquals(expected,table.getPlayers());
    }

    @Test
    void shouldAddPlayer() {
        Table table = createTable();
        Player player3 = new Player(hand1,"Mary",1100);
        int actual = table.getPlayers().size();
        ArrayList<Player> expected = new ArrayList<>(3);
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        table.addPlayer(player3);
        assertEquals(expected,table.getPlayers());
        assertNotEquals(actual,table.getPlayers().size());
    }

    @Test
    void shouldRemovePlayer() {
        Table table = createTable();
        int actual = table.getPlayers().size();
        ArrayList<Player> expected = new ArrayList<>(2);
        expected.add(player1);
        table.removePlayer(player2);
        assertEquals(expected,table.getPlayers());
        assertNotEquals(actual,table.getPlayers().size());
    }

    @Test
    void shouldRemovePlayerByPosition() {
        Table table = createTable();
        int actual = table.getPlayers().size();
        ArrayList<Player> expected = new ArrayList<>(2);
        expected.add(player1);
        table.removePlayer(1);
        assertEquals(expected,table.getPlayers());
        assertNotEquals(actual,table.getPlayers().size());
    }

    @Test
    void shouldGetPlayer() {
        Table table = createTable();
        Player expected = player1;
        assertEquals(expected,table.getPlayer(0));
    }

    @Test
    void shouldBeEquals() {
        Table firstTable = createTable();
        Table sameTable = createTable();
        Object o = new Object();
        Table otherTable = new Table(tableCards,players);
        otherTable.addCard(card3);
        assertThrows(NullPointerException.class, () -> firstTable.equals(null));
        assertFalse(firstTable.equals(o));
        assertTrue(firstTable.equals(sameTable));
        assertTrue(firstTable.equals(firstTable));
        assertFalse(firstTable.equals(otherTable));
        assertFalse(otherTable.equals(hand1));
    }

    @Test
    void testHashCode() {
        Table table = createTable();
        Table sameTable = createTable();
        Table otherTable = new Table(tableCards,players);
        otherTable.addCard(card3);
        assertNotSame(table, sameTable);
        assertEquals(table.hashCode(), sameTable.hashCode());
        assertNotEquals(table.hashCode(), otherTable.hashCode());
    }

    @Test
    void testToString() {
        Table table = createTable();
        String expected = """

                TABLE:
                Cards on table = [
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 5]
                Discarded cards = []
                Players = [
                PLAYER :
                Name = Giulio'
                ID = 1011
                Actual cards in hand =\s
                HAND: [
                CARD:\s
                Suit = Aces
                Color = Black
                Value = 1]
                Points = 0,\s
                PLAYER :
                Name = Frank'
                ID = 1010
                Actual cards in hand =\s
                HAND: [
                CARD:\s
                Suit = Aces
                Color = Black
                Value = 1]
                Points = 0]""";
        assertEquals(expected,table.toString());
    }
}