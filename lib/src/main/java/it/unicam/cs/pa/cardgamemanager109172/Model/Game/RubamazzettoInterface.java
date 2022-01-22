package it.unicam.cs.pa.cardgamemanager109172.Model.Game;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Deck;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Table;

/**
 * This interface will be implemented by "Rubamazzetto" class which will represent a card game.
 * The class that will implement this interface will have an inner class with all the actions of the game.
 *
 * RULES:
 * The dealer deals the cards until each player has three.
 * The next four cards are instead placed face up on the table.
 * Each player can play only one card each turn, and when no one has
 * any more cards in hand the dealer deals again three each.
 * The player must see if among his cards there is at least
 * one of the same value as one of those on the table.
 * In that case he takes it and places the two cards stacked
 * in the bounch, with his card face up on top and visible.
 * If another player, during his turn, has a card of the same value
 * in his hand as the one on top of the deck of cards taken by another,
 * he can steal the deck and put it next to him.
 * To steal the deck it is necessary to have the same value as the top card of the stack.
 * The game ends when there are no more cards to deal and the remaining cards on the table
 * are taken by the last player who took a card from the table or stole someone else's deck.
 *
 * SCORING METHOD:
 * The score is established by counting the cards in each player's deck at the end of the game.
 *
 * PURPOSE:
 * The purpose of the game is to get at the end of the game as many cards in your deck as possible.
 */
public interface RubamazzettoInterface {

    /**
     * This method reset the turn and distributes the cards to the players and on the table as defined in rules
     */
    void newGame();

    /**
     * This method finish the actual game
     * @return the winner name
     */
    String finishGame();

    /**
     * This method return the actual turn
     * @return the actual turn number
     */
    int getTurn();

    /**
     * This method increment the turn value
     */
    void nextTurn();

    /**
     * This method return the actual deck
     * @return the actual deck
     */
    Deck getDeck();

    /**
     * This method return the actual bounch of cards earned by first player
     * @return the actual bounch of cards
     */
    Deck getBounchOne();

    /**
     * This method return the actual bounch of cards earned by second player
     * @return the actual bounch of cards
     */
    Deck getBounchTwo();

    /**
     * This method return the bounch of card of the specified player
     * @param player the player
     * @return his bounch of cards
     */
    Deck getPlayerBounch(Player player);

    /**
     * This method return the first {@link Player}
     * @return the first player
     */
    Player getPlayerOne();

    /**
     * This method return the bot player
     * @return the bot player
     */
    Player getBot();

    /**
     * This method return the {@link Table}
     * @return the table
     */
    Table getTable();
}
