package it.unicam.cs.pa.cardgamemanager109172.Model;

import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.PlayerInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Interfaces.TableInterface;

import java.util.ArrayList;

public class Table implements TableInterface {
    @Override
    public ArrayList<CardInterface> getOnTableCards() {
        return null;
    }

    @Override
    public void addCard(CardInterface card) {

    }

    @Override
    public void removeCard(CardInterface card) {

    }

    @Override
    public ArrayList<PlayerInterface> getPlayers() {
        return null;
    }

    @Override
    public PlayerInterface getPlayer(int position) {
        return null;
    }
}
