package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PokerConfig {

    public static void main(String[] args) {
        //POKER RULES
        HashMap<Card,Integer> weights = new HashMap<>(52);
        GameRules rules = new GameRules(1,13,0,52,52,0,0,weights);

        //POKER DECK
        ArrayList<Card> deck = new ArrayList<>(52);
        deck.add(new Card("Heart Aces","Red",1,rules,1));
        deck.add(new Card("Clubs Aces","Black",1,rules,1));
        deck.add(new Card("Diamonds Aces","Red",1,rules,1));
        deck.add(new Card("Spades Aces","Black",1,rules,1));

        deck.add(new Card("Heart Two","Red",2,rules,2));
        deck.add(new Card("Clubs Two","Black",2,rules,2));
        deck.add(new Card("Diamonds Two","Red",2,rules,2));
        deck.add(new Card("Spades Two","Black",2,rules,2));

        deck.add(new Card("Heart Three","Red",3,rules,3));
        deck.add(new Card("Clubs Three","Black",3,rules,3));
        deck.add(new Card("Diamonds Three","Red",3,rules,3));
        deck.add(new Card("Spades Three","Black",3,rules,3));

        deck.add(new Card("Heart Four","Red",4,rules,4));
        deck.add(new Card("Clubs Four","Black",4,rules,4));
        deck.add(new Card("Diamonds Four","Red",4,rules,4));
        deck.add(new Card("Spades Four","Black",4,rules,4));

        deck.add(new Card("Heart Five","Red",5,rules,5));
        deck.add(new Card("Clubs Five","Black",5,rules,5));
        deck.add(new Card("Diamonds Five","Red",5,rules,5));
        deck.add(new Card("Spades Five","Black",5,rules,5));

        deck.add(new Card("Heart Six","Red",6,rules,6));
        deck.add(new Card("Clubs Six","Black",6,rules,6));
        deck.add(new Card("Diamonds Six","Red",6,rules,6));
        deck.add(new Card("Spades Six","Black",6,rules,6));

        deck.add(new Card("Heart Seven","Red",7,rules,7));
        deck.add(new Card("Clubs Seven","Black",7,rules,7));
        deck.add(new Card("Diamonds Seven","Red",7,rules,7));
        deck.add(new Card("Spades Seven","Black",7,rules,7));

        deck.add(new Card("Heart Eight","Red",8,rules,8));
        deck.add(new Card("Clubs Eight","Black",8,rules,8));
        deck.add(new Card("Diamonds Eight","Red",8,rules,8));
        deck.add(new Card("Spades Eight","Black",8,rules,8));

        deck.add(new Card("Heart Nine","Red",9,rules,9));
        deck.add(new Card("Clubs Nine","Black",9,rules,9));
        deck.add(new Card("Diamonds Nine","Red",9,rules,9));
        deck.add(new Card("Spades Nine","Black",9,rules,9));

        deck.add(new Card("Heart Ten","Red",10,rules,10));
        deck.add(new Card("Clubs Ten","Black",10,rules,10));
        deck.add(new Card("Diamonds Ten","Red",10,rules,10));
        deck.add(new Card("Spades Ten","Black",10,rules,10));

        deck.add(new Card("Heart Jack","Red",11,rules,11));
        deck.add(new Card("Clubs Jack","Black",11,rules,11));
        deck.add(new Card("Diamonds Jack","Red",11,rules,11));
        deck.add(new Card("Spades Jack","Black",11,rules,11));

        deck.add(new Card("Heart Queen","Red",12,rules,12));
        deck.add(new Card("Clubs Queen","Black",12,rules,12));
        deck.add(new Card("Diamonds Queen","Red",12,rules,12));
        deck.add(new Card("Spades Queen","Black",12,rules,12));

        deck.add(new Card("Heart King","Red",13,rules,13));
        deck.add(new Card("Clubs King","Black",13,rules,13));
        deck.add(new Card("Diamonds King","Red",13,rules,13));
        deck.add(new Card("Spades King","Black",13,rules,13));

        Deck pokerDeck = new Deck(rules,deck, rules.getDeckStarter());

        //CONFIGURATION FILES CREATOR
        File outputDeckFile = new File("/Users/thevladdo/Desktop/PokerConfig");
        File outputRulesFile = new File("/Users/thevladdo/Desktop/PokerRules");
        FileOutputStream deckFileOut;
        FileOutputStream rulesFileOut;
        ObjectOutputStream outputDeckStream;
        ObjectOutputStream outputRulesStream;
        try {
            deckFileOut = new FileOutputStream(outputDeckFile);
            rulesFileOut = new FileOutputStream(outputRulesFile);
            outputDeckStream = new ObjectOutputStream(deckFileOut);
            outputRulesStream = new ObjectOutputStream(rulesFileOut);
            outputDeckStream.writeObject(pokerDeck);
            outputRulesStream.writeObject(rules);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
