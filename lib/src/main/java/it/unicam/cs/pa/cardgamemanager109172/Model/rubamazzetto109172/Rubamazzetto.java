package it.unicam.cs.pa.cardgamemanager109172.Model.rubamazzetto109172;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The "Rubamazzetto" is a card game, a simplified variant of "Scopa".
 * Played with Italian deck of 40 cards divided into 4 suits of 10 cards each without color differentiation.
 * It is often played by only 2 people.
 */
public class Rubamazzetto {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("""
                
                BENVENUTO IN RUBAMAZZETTO
                SCEGLI UNA DELLE SEGUENTI OPZIONI\040
                DIGITANDO IL NUMERO CORRISPONDENTE:
                1- Nuova Partita
                2- Esci
                """);
        int choice = user.nextInt();
        switch (choice){
            case 1:
                System.out.println("""
                
                INIZIAMO !
                """);
                newGame();
            case 2:
                System.exit(0);
        }


    }

    private static void newGame(){

        //SOLO QUESTO

        Scanner user = new Scanner(System.in);
        File deckConfig = new File("lib/src/main/java/it/unicam/cs/pa/gameConfigurations/ItalianDeck/ItalianDeck");
        ConfigGenerator deckLoader = new ConfigGenerator(deckConfig);

        //RULES
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(
                1,10,
                0,40,40,
                0,3,weights);

        //DECKS
        Deck deck = (Deck) deckLoader.loadConfig();
        Deck bounchOne = new Deck(rules,new ArrayList<>(1),0);
        Deck bounchTwo = new Deck(rules,new ArrayList<>(1),0);

        //PLAYERS
        System.out.println("Insert your name:");
        Player playerOne = new Player(
                new Hand(rules,new ArrayList<>(1),0), user.nextLine(),1);
        Player playerTwo = new Player(
                new Hand(rules,new ArrayList<>(1),0), "BotMan",1);
        user.close();

        //TABLE
        ArrayList<Player> players = new ArrayList<>(2);
        Table table = new Table(new ArrayList<>(4),players);
        dealer(deck,table);
    }

    private static void dealer(Deck deck, Table table){
        deck.shuffle();
        for (Player player : table.getPlayers()) {
            for (int i = 0; i < 3; i++) {
                player.drawCard(deck);
            }
        }
        for (int i = 0; i < 4; i++) {
            table.addCard(deck.getFirstCard());
        }
    }
}
