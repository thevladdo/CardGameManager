package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PokerConfig {

    public static void main(String[] args) {
        //POKER RULES
        HashMap<Card,Integer> weights = new HashMap<>(40);
        GameRules rules = new GameRules(1,10,0,40,40,0,0,weights);

        //POKER DECK
        ArrayList<Card> deck = new ArrayList<>(52);
        deck.add(new Card("Swords","-",1,rules,1));
        deck.add(new Card("Cups","-",1,rules,1));
        deck.add(new Card("Coins","-",1,rules,1));
        deck.add(new Card("Batons","-",1,rules,1));

        deck.add(new Card("Swords","-",2,rules,2));
        deck.add(new Card("Cups","-",2,rules,2));
        deck.add(new Card("Coins","-",2,rules,2));
        deck.add(new Card("Batons","-",2,rules,2));

        deck.add(new Card("Swords","-",3,rules,3));
        deck.add(new Card("Cups","-",3,rules,3));
        deck.add(new Card("Coins","-",3,rules,3));
        deck.add(new Card("Batons","-",3,rules,3));

        deck.add(new Card("Swords","-",4,rules,4));
        deck.add(new Card("Cups","-",4,rules,4));
        deck.add(new Card("Coins","-",4,rules,4));
        deck.add(new Card("Batons","-",4,rules,4));

        deck.add(new Card("Swords","-",5,rules,5));
        deck.add(new Card("Cups","-",5,rules,5));
        deck.add(new Card("Coins","-",5,rules,5));
        deck.add(new Card("Batons","-",5,rules,5));

        deck.add(new Card("Swords","-",6,rules,6));
        deck.add(new Card("Cups","-",6,rules,6));
        deck.add(new Card("Coins","-",6,rules,6));
        deck.add(new Card("Batons","-",6,rules,6));

        deck.add(new Card("Swords","-",7,rules,7));
        deck.add(new Card("Cups","-",7,rules,7));
        deck.add(new Card("Coins","-",7,rules,7));
        deck.add(new Card("Batons","-",7,rules,7));

        deck.add(new Card("Swords Queen","-",8,rules,8));
        deck.add(new Card("Cups Queen","-",8,rules,8));
        deck.add(new Card("Coins Queen","-",8,rules,8));
        deck.add(new Card("Batons Queen","-",8,rules,8));

        deck.add(new Card("Swords Knight","-",9,rules,9));
        deck.add(new Card("Cups Knight","-",9,rules,9));
        deck.add(new Card("Coins Knight","-",9,rules,9));
        deck.add(new Card("Batons Knight","-",9,rules,9));

        deck.add(new Card("Swords King","-",10,rules,10));
        deck.add(new Card("Cups King","-",10,rules,10));
        deck.add(new Card("Coins King","-",10,rules,10));
        deck.add(new Card("Batons King","-",10,rules,10));

        Deck pokerDeck = new Deck(rules,deck, rules.getDeckStarter());

        //CONFIGURATION FILES CREATOR
        /*
        File outputDeckFile = new File("/Users/thevladdo/Desktop/ItalianDeck");
        File outputRulesFile = new File("/Users/thevladdo/Desktop/ItalianRules");
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
         */


        File pippo = new File("lib/src/test/gameConfigurations/ItalianDeck/ItalianDeck");
        ConfigGenerator configGenerator = new ConfigGenerator(pippo);
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Deck mio = null;
        try {
            fileInputStream = new FileInputStream(pippo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            mio = (Deck) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



        System.out.println(pokerDeck.equals(mio));


        /*
        File outputMY = new File("/Users/thevladdo/Desktop/PokerDeckMY");
        ConfigGenerator configGenerator = new ConfigGenerator(outputMY);
        configGenerator.generateConfig(pokerDeck);

        Deck my = (Deck) configGenerator.loadConfig();

        System.out.println(pokerDeck.equals(my));
         */
    }
}
