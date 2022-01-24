package it.unicam.cs.pa.cardgamemanager109172.Model.Game;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class RubamazzettoTest {

    private DeckConfigFactory factory;
    private GameRules rules;

    private Rubamazzetto createGame(){
        HashMap<Card,Integer> weights = new HashMap<>(40);
        rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        this.factory = new DeckConfigFactory(rules);
        return new Rubamazzetto("Test");
    }

    @Test
    void shouldInitNewGame() {
        Rubamazzetto rm = createGame();
        Deck expected = factory.ItalianDeck();
        assertEquals(expected,rm.getDeck());
        rm.getPlayerOne().drawCard(rm.getDeck());
        rm.newGame();
        assertNotEquals(expected.getDeckCards(),rm.getDeck().getDeckCards());
        assertEquals(0,rm.getTurn());
        assertEquals(0,rm.getBounchOne().getDeckCards().size());
        assertEquals(0,rm.getBounchTwo().getDeckCards().size());
        assertEquals(3,rm.getPlayerOne().getPlayerHand().getCards().size());
        assertEquals(3,rm.getBot().getPlayerHand().getCards().size());
        assertNotEquals(0,rm.getTable().getOnTableCards().size());
    }

    @Test
    void shouldFinishGame() {
        Rubamazzetto rm = createGame();
        assertNull(rm.finishGame());
        String expected = rm.getPlayerOne().getName();
        for (Card card: rm.getDeck().getDeckCards()) {
            rm.getBounchOne().add(card);
        }
        rm.getDeck().remove(card1 -> true);
        rm.getBot().getPlayerHand().remove(card -> true);
        rm.getPlayerOne().getPlayerHand().remove(card -> true);
        assertEquals(expected,rm.finishGame());

        rm.getBounchOne().remove(card -> true);
        rm.getBounchTwo().remove(card -> true);
        rm.getBounchOne().add(new Card(rules));
        rm.getBounchTwo().add(new Card(rules));
        assertEquals("Tie",rm.finishGame());
    }

    @Test
    void shouldGetTurn() {
        Rubamazzetto rm = createGame();
        rm.newGame();
        assertEquals(0,rm.getTurn());
        rm.nextTurn();
        assertEquals(1,rm.getTurn());
        Rubamazzetto.Actions actions = rm.new Actions();
        actions.makeMove(rm.getPlayerOne(),0);
        assertEquals(2,rm.getTurn());
    }

    @Test
    void shouldSetNextTurn() {
        Rubamazzetto rm = createGame();
        assertEquals(0,rm.getTurn());
        rm.nextTurn();
        rm.nextTurn();
        assertEquals(2,rm.getTurn());
        rm.getPlayerOne().getPlayerHand().remove(card -> true);
        rm.getBot().getPlayerHand().remove(card -> true);
        rm.getTable().getOnTableCards().removeAll( rm.getTable().getOnTableCards());
        assertEquals(0,rm.getPlayerOne().getPlayerHand().getCards().size());
        assertEquals(0,rm.getBot().getPlayerHand().getCards().size());
        assertEquals(0,rm.getTable().getOnTableCards().size());
        rm.nextTurn();
        assertEquals(3,rm.getPlayerOne().getPlayerHand().getCards().size());
        assertEquals(3,rm.getBot().getPlayerHand().getCards().size());
        assertEquals(4,rm.getTable().getOnTableCards().size());
    }

    @Test
    void shouldGetDeck() {
        Rubamazzetto rm = createGame();
        Deck expected = factory.ItalianDeck();
        assertEquals(expected,rm.getDeck());
    }

    @Test
    void shouldGetBounchOne() {
        Rubamazzetto rm = createGame();
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Deck expected = new Deck(rules,new ArrayList<>(1),0);
        assertEquals(expected,rm.getBounchOne());
    }

    @Test
    void shouldGetBounchTwo() {
        Rubamazzetto rm = createGame();
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Deck expected = new Deck(rules,new ArrayList<>(1),0);
        assertEquals(expected,rm.getBounchTwo());
    }

    @Test
    void shouldGetPlayerBounch() {
        Rubamazzetto rm = createGame();
        Deck bounchOne = rm.getBounchOne();
        Deck bounchTwo = rm.getBounchTwo();
        bounchTwo.getDeckCards().add(rm.getDeck().getFirstCard());
        assertEquals(bounchOne,rm.getPlayerBounch(rm.getPlayerOne()));
        assertEquals(bounchTwo,rm.getPlayerBounch(rm.getBot()));
    }

    @Test
    void shouldGetPlayerOne() {
        Rubamazzetto rm = createGame();
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Player expected = new Player(new Hand(rules,new ArrayList<>(1),0), "Test",1);
        assertEquals(expected,rm.getPlayerOne());
    }

    @Test
    void shouldGetBot() {
        Rubamazzetto rm = createGame();
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Player expected = new Player(new Hand(rules,new ArrayList<>(1),0), "Game Bot",2);
        assertEquals(expected,rm.getBot());
    }

    @Test
    void shouldGetTable() {
        Rubamazzetto rm = createGame();
        ArrayList<Player> players = new ArrayList<>(2);
        players.add(rm.getPlayerOne());
        players.add(rm.getBot());
        Table expected = new Table(new ArrayList<>(4),players);
        assertEquals(expected,rm.getTable());
        rm.newGame();
        assertNotEquals(expected,rm.getTable());
    }

    @Test
    void shouldBeEquals() {
        Rubamazzetto rm = createGame();
        Rubamazzetto sameRm = createGame();
        Rubamazzetto otherRm = new Rubamazzetto();
        Object o = new Object();
        Object sameObj = rm;
        assertThrows(NullPointerException.class, () -> rm.equals(null));
        assertTrue(rm.equals(sameObj));
        assertFalse(rm.equals(o));
        assertFalse(rm.equals(otherRm));
        assertTrue(rm.equals(sameRm));
    }

    @Test
    void testHashCode() {
        Rubamazzetto rm = createGame();
        Rubamazzetto sameRm = createGame();
        Rubamazzetto otherRm = new Rubamazzetto();
        assertNotSame(rm,otherRm);
        assertEquals(rm.hashCode(),sameRm.hashCode());
        assertNotEquals(rm.hashCode(),otherRm.hashCode());
    }

    @Test
    void shouldMakeMove() {
        Rubamazzetto rm = createGame();
        Rubamazzetto.Actions actions = rm.new Actions();

        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Card onTable = new Card("Swords","-",1,rules,1);
        Card inHand = new Card("Cups","-",1,rules,1);
        rm.getTable().addCard(onTable);
        rm.getPlayerOne().getPlayerHand().add(inHand);

        assertEquals(0,rm.getBounchOne().getDeckCards().size());
        assertEquals(1,rm.getTable().getOnTableCards().size());
        actions.makeMove(rm.getPlayerOne(),0);
        assertEquals(2,rm.getBounchOne().getDeckCards().size());
        assertEquals(4,rm.getTable().getOnTableCards().size());
        assertEquals(1,rm.getTurn());
    }

    @Test
    void shouldStealBounch() {
        Rubamazzetto rm = createGame();
        Rubamazzetto.Actions actions = rm.new Actions();

        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1, 10,
                0, 40, 40,
                0, 3, weights);
        Card card = new Card("Swords","-",1,rules,1);
        Card card2 = new Card("Cups","-",1,rules,1);
        rm.getBounchTwo().add(card);
        rm.getPlayerOne().getPlayerHand().add(card2);

        assertEquals(0,rm.getBounchOne().getDeckCards().size());
        assertEquals(1,rm.getBounchTwo().getDeckCards().size());
        assertEquals(1,rm.getPlayerOne().getPlayerHand().getCards().size());
        actions.stealBounch(rm.getPlayerOne());
        assertEquals(2,rm.getBounchOne().getDeckCards().size());
        assertEquals(0,rm.getBounchTwo().getDeckCards().size());
        assertEquals(3,rm.getPlayerOne().getPlayerHand().getCards().size());
        assertEquals(1,rm.getTurn());
        rm.getBounchOne().getDeckCards().clear();
        assertFalse(actions.stealBounch(rm.getBot()));
    }
}