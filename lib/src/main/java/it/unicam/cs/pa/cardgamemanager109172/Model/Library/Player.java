package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.PlayerInterface;

import java.util.Objects;

/**
 * This class implements {@link PlayerInterface} will represent a player or a bot.
 */
public class Player implements PlayerInterface {

    private final Hand playerHand;
    private String name;
    private int id;
    private int points;

    public Player(){
        this(new Hand(),"",0);
    }

    public Player(Hand hand, String name, int id){
        this.playerHand = hand;
        this.name = name;
        this.id = id;
        this.points = 0;
    }

    @Override
    public void drawCard(Deck deck) {
        Card drawnCard = deck.getCard(deck.getDeckCards().size()-1);
        deck.remove(deck.getDeckCards().size()-1);
        this.playerHand.add(drawnCard);
    }

    @Override
    public void placeCard(int handPosition, Table table) {
        table.addCard(showCard(handPosition));
        this.playerHand.remove(handPosition);
    }

    @Override
    public Card showCard(int handPosition) {
        return this.playerHand.getCard(handPosition);
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setID(int newId) {
        this.id = newId;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public void removePoints(int points) {
        this.points -= points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public Hand getPlayerHand() {
        return this.playerHand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getId() == player.getId()
                && getPoints() == player.getPoints()
                && getPlayerHand().equals(player.getPlayerHand())
                && getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerHand(), getName(), getId(), getPoints());
    }

    @Override
    public String toString() {
        return "\nPLAYER :" +
                "\nName = " + name + '\'' +
                "\nID = " + id +
                "\nActual cards in hand = " + playerHand +
                "\nPoints = " + points;
    }
}
