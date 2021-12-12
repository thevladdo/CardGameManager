package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.*;

public class Player implements PlayerInterface {
    @Override
    public void drawCard(DeckInterface deck, int position) {

    }

    @Override
    public void placeCard(int position, TableInterface table) {

    }

    @Override
    public CardInterface showCard(int position) {
        return null;
    }

    @Override
    public void setName() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setID(int newID) {

    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void addPoints(int points) {

    }

    @Override
    public void removePoints(int points) {

    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public HandInterface getHand() {
        return null;
    }
}
