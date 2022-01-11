package it.unicam.cs.pa.cardgamemanager109172.Model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Card card1;
    private Card card2;
    private Card card3;
    private Hand hand;
    private Deck deck;
    private GameRules rules;

    private Player createPlayer(){
        Map<Card, Integer> map = new HashMap<>(3);
        rules = new GameRules(
                0,15,
                0,52,1,
                0,10, map);

        card1 = new Card("Hearts","Red",5, rules,5);
        card2 = new Card("Aces","Black",1, rules,14);
        card3 = new Card("Aces","Red",1, rules,1);

        ArrayList<Card> handCards = new ArrayList<>(2);
        handCards.add(card1);
        handCards.add(card2);
        hand = new Hand(rules,handCards,2);

        ArrayList<Card> deckCards = new ArrayList<>(1);
        deckCards.add(card3);
        deck = new Deck(rules,deckCards,1);

        return new Player(hand,"Alfred", 5);
    }

    @Test
    void drawCard(){
        Player player = createPlayer();
        Card drawed = deck.getCard(0);
        assertEquals(drawed,card3);
        player.drawCard(deck);
        assertEquals(0,deck.getDeck().size());
        assertEquals(drawed,player.getPlayerHand().getCard(2));
    }

    @Test
    void placeCard() {
        Player player = createPlayer();
        ArrayList<Card> tableCards = new ArrayList<>(0);
        ArrayList<Player> players = new ArrayList<>(1);
        players.add(player);
        Table table = new Table(tableCards,players);
        assertEquals(2,player.getPlayerHand().getHand().size());
        player.placeCard(0,table);
        assertEquals(card1,table.getOnTableCards().get(0));
        assertEquals(1,player.getPlayerHand().getHand().size());
    }

    @Test
    void showCard() {
        Player player = createPlayer();
        assertEquals(card1,player.showCard(0));
        assertEquals(2,player.getPlayerHand().getHand().size());
    }

    @Test
    void setName() {
        Player player = createPlayer();
        assertEquals("Alfred",player.getName());
        player.setName("NotAlfred");
        assertEquals("NotAlfred",player.getName());
    }

    @Test
    void getName() {
        Player player = createPlayer();
        assertEquals("Alfred",player.getName());
    }

    @Test
    void setID() {
        Player player = createPlayer();
        assertEquals(5,player.getId());
        player.setID(9);
        assertEquals(9,player.getId());
    }

    @Test
    void getId() {
        Player player = createPlayer();
        assertEquals(5,player.getId());
    }

    @Test
    void addPoints() {
        Player player = createPlayer();
        assertEquals(0,player.getPoints());
        player.addPoints(100);
        assertEquals(100,player.getPoints());
    }

    @Test
    void removePoints() {
        Player player = createPlayer();
        player.addPoints(100);
        assertEquals(100,player.getPoints());
        player.removePoints(50);
        assertEquals(50,player.getPoints());
    }

    @Test
    void getPoints() {
        Player player = createPlayer();
        player.addPoints(100);
        int expected = 100;
        assertEquals(expected,player.getPoints());
    }

    @Test
    void getHand() {
        Player player = createPlayer();
        ArrayList<Card> handCards = new ArrayList<>(2);
        handCards.add(card1);
        handCards.add(card2);
        Hand expectedHand = new Hand(rules,handCards,2);
        assertEquals(expectedHand,player.getPlayerHand());
        expectedHand.remove(1);
        assertNotEquals(expectedHand,player.getPlayerHand());
    }

    @Test
    void testEquals() {
        Player player = createPlayer();
        Player samePlayer = createPlayer();
        Object o = new Object();
        Player otherPlayer = new Player(hand,"NotAlfred",2);
        assertThrows(NullPointerException.class, () -> player.equals(null));
        assertFalse(player.equals(o));
        assertTrue(player.equals(samePlayer));
        assertTrue(player.equals(player));
        assertFalse(player.equals(otherPlayer));
    }

    @Test
    void testHashCode() {
        Player player = createPlayer();
        Player samePlayer = createPlayer();
        ArrayList<Card> cards = new ArrayList<>(3);
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        cards.add(new Card(this.rules));
        Hand otherHand = new Hand(rules,cards,3);
        Player otherPlayer = new Player(otherHand,"NotAlfred",3);
        assertNotSame(player, samePlayer);
        assertEquals(player.hashCode(), samePlayer.hashCode());
        assertNotEquals(player.hashCode(), otherPlayer.hashCode());
    }

    @Test
    void testToString() {
        Player player = createPlayer();
        String expected = """

                PLAYER :
                Name = Alfred'
                ID = 5
                Actual cards in hand =\s
                HAND: [
                CARD:\s
                Suit = Hearts
                Color = Red
                Value = 5,\s
                CARD:\s
                Suit = Aces
                Color = Black
                Value = 1]
                Points = 0""";
        assertEquals(expected,player.toString());
    }
}