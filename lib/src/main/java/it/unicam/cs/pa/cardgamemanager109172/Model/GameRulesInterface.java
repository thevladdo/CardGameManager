package it.unicam.cs.pa.cardgamemanager109172.Model;

public interface GameRulesInterface {

    /**
     * This method assigns a weight to each suit on a card
     * Example: the aces can be either the lowest card value, the highest, or both
     * @param card the card whose suit will have assigned a weight in the deck
     */
    void setSuitWeight(CardInterface card);


}
