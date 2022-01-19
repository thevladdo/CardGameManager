package it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Card;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Deck;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.GameRules;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Hand;

import java.util.ArrayList;

/**
 * This interface will be implemented by the {@link Hand} class which will represent the cards in a player's hand.
 * It extends the {@link Deck} class because the cards in hand represent a smaller version of a deck.
 * Use {@link GameRules} to find out what is the maximum or minimum number of cards a hand can have.
 * The constructor of this class will have as argument an object of type {@link GameRules} that
 * will use to know what will be the starter number of cards a player hand at the start of the game.
 */
public interface HandInterface extends DeckInterface{

    /**
     * This method moves the card to the desired location in the hand
     * @param card the card that will be moved
     * @param index the location where the card will be placed
     */
    void moveTo(Card card, int index);

    /**
     * This method discard all the cards from the hand
     */
    void clear();

    /**
     * This method get the lowest card according to suit weight
     * @return the lowest card
     */
    Card getLowestCard();

    /**
     * This method get the highest card according to suit weight
     * @return the highest card
     */
    Card getHighestCard();

    /**
     * This method return the actual hand cards
     * @return the actual cards in the hand
     */
    ArrayList<Card> getCards();
}
