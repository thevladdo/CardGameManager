package it.unicam.cs.pa.cardgamemanager109172.Model;

/**
 * This interface will be implemented by the "Hand" class which will represent the cards in a player's hand
 * It extends the {@link Deck} interface because the cards in hand represent a smaller version of a deck
 */
public interface Hand extends Deck{

    /**
     * This method moves the card to the desired location
     * @param card the card that will be moved
     * @param index the location where the card will be placed
     */
    void moveTo(Card card, int index);

}
