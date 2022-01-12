package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.TableInterface;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class implements {@link TableInterface} and will represent the table in a generic card game.
 */
public class Table implements TableInterface {

    private final ArrayList<Card> tableCards;
    private final ArrayList<Card> discarded;
    private final ArrayList<Player> players;

    public Table(){
        this(new ArrayList<>(0),new ArrayList<>(0));
    }

    public Table(ArrayList<Card> tableCards){
        this(new ArrayList<>(tableCards),new ArrayList<>(0));
    }

    public Table(ArrayList<Card> tableCards, ArrayList<Player> players){
        this.tableCards = new ArrayList<>(tableCards);
        this.discarded = new ArrayList<>(0);
        this.players = new ArrayList<>(players);
    }

    @Override
    public ArrayList<Card> getOnTableCards() {
        return this.tableCards;
    }

    @Override
    public void addCard(Card card) {
        this.tableCards.add(card);
    }

    @Override
    public void removeCard(Card card) {
        this.discarded.add(card);
        this.tableCards.remove(card);
    }

    @Override
    public ArrayList<Card> getDiscardedCards() {
        return this.discarded;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void removePlayer(int position) {
        this.players.remove(position);
    }

    @Override
    public Player getPlayer(int position) {
        return this.players.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException("Object 'o' is Null");
        if (this == o) return true;
        if (!(o instanceof Table table)) return false;
        return getOnTableCards().equals(table.getOnTableCards())
                && getDiscardedCards().equals(table.getDiscardedCards())
                && getPlayers().equals(table.getPlayers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOnTableCards(), getDiscardedCards(), getPlayers());
    }

    @Override
    public String toString() {
        return "\nTABLE:" +
                "\nCards on table = " + tableCards +
                "\nDiscarded cards = " + discarded +
                "\nPlayers = " + players;
    }
}