package it.unicam.cs.pa.cardgamemanager109172.Model.rubamazzetto109172;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Table;

public class Actions {

    public void showCard(Player player, int position){
        player.showCard(position);
    }

    public boolean checkIfSame(Table table, Card playerCard){
        for (Card onTable : table.getOnTableCards()) {
        }
        return false;
    }
}
