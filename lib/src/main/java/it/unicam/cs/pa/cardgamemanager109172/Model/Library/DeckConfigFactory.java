package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.CardInterface;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.GameRulesInterface;
import java.util.ArrayList;

/**
 * This class deals with the generation of pre-created Deck objects.
 * With its methods this class allows the creation of a deck of 54 French cards and a deck of 40 Italian cards.
 */
public class DeckConfigFactory {

    private final GameRulesInterface rules;

    public DeckConfigFactory(GameRulesInterface rules){
        this.rules = rules;
    }

    public Deck ItalianDeck(){
        ArrayList<CardInterface> deckArray = new ArrayList<>(40);
        deckArray.add(new Card("Swords","-",1,rules,1));
        deckArray.add(new Card("Cups","-",1,rules,1));
        deckArray.add(new Card("Coins","-",1,rules,1));
        deckArray.add(new Card("Batons","-",1,rules,1));

        deckArray.add(new Card("Swords","-",2,rules,2));
        deckArray.add(new Card("Cups","-",2,rules,2));
        deckArray.add(new Card("Coins","-",2,rules,2));
        deckArray.add(new Card("Batons","-",2,rules,2));

        deckArray.add(new Card("Swords","-",3,rules,3));
        deckArray.add(new Card("Cups","-",3,rules,3));
        deckArray.add(new Card("Coins","-",3,rules,3));
        deckArray.add(new Card("Batons","-",3,rules,3));

        deckArray.add(new Card("Swords","-",4,rules,4));
        deckArray.add(new Card("Cups","-",4,rules,4));
        deckArray.add(new Card("Coins","-",4,rules,4));
        deckArray.add(new Card("Batons","-",4,rules,4));

        deckArray.add(new Card("Swords","-",5,rules,5));
        deckArray.add(new Card("Cups","-",5,rules,5));
        deckArray.add(new Card("Coins","-",5,rules,5));
        deckArray.add(new Card("Batons","-",5,rules,5));

        deckArray.add(new Card("Swords","-",6,rules,6));
        deckArray.add(new Card("Cups","-",6,rules,6));
        deckArray.add(new Card("Coins","-",6,rules,6));
        deckArray.add(new Card("Batons","-",6,rules,6));

        deckArray.add(new Card("Swords","-",7,rules,7));
        deckArray.add(new Card("Cups","-",7,rules,7));
        deckArray.add(new Card("Coins","-",7,rules,7));
        deckArray.add(new Card("Batons","-",7,rules,7));

        deckArray.add(new Card("Swords Queen","-",8,rules,8));
        deckArray.add(new Card("Cups Queen","-",8,rules,8));
        deckArray.add(new Card("Coins Queen","-",8,rules,8));
        deckArray.add(new Card("Batons Queen","-",8,rules,8));

        deckArray.add(new Card("Swords Knight","-",9,rules,9));
        deckArray.add(new Card("Cups Knight","-",9,rules,9));
        deckArray.add(new Card("Coins Knight","-",9,rules,9));
        deckArray.add(new Card("Batons Knight","-",9,rules,9));

        deckArray.add(new Card("Swords King","-",10,rules,10));
        deckArray.add(new Card("Cups King","-",10,rules,10));
        deckArray.add(new Card("Coins King","-",10,rules,10));
        deckArray.add(new Card("Batons King","-",10,rules,10));

        return new Deck(this.rules,deckArray,this.rules.getDeckStarter());
    }

    public Deck FrenchDeck(){

        ArrayList<CardInterface> deckArray = new ArrayList<>(52);
        deckArray.add(new Card("Heart Ace","Red",1,rules,1));
        deckArray.add(new Card("Diamonds Ace","Red",1,rules,1));
        deckArray.add(new Card("Clubs Ace","Black",1,rules,1));
        deckArray.add(new Card("Spades Ace","Black",1,rules,1));

        deckArray.add(new Card("Heart","Red",2,rules,2));
        deckArray.add(new Card("Diamonds","Red",2,rules,2));
        deckArray.add(new Card("Clubs","Black",2,rules,2));
        deckArray.add(new Card("Spades","Black",2,rules,2));

        deckArray.add(new Card("Heart","Red",3,rules,3));
        deckArray.add(new Card("Diamonds","Red",3,rules,3));
        deckArray.add(new Card("Clubs","Black",3,rules,3));
        deckArray.add(new Card("Spades","Black",3,rules,3));

        deckArray.add(new Card("Heart","Red",4,rules,4));
        deckArray.add(new Card("Diamonds","Red",4,rules,4));
        deckArray.add(new Card("Clubs","Black",4,rules,4));
        deckArray.add(new Card("Spades","Black",4,rules,4));

        deckArray.add(new Card("Heart","Red",5,rules,5));
        deckArray.add(new Card("Diamonds","Red",5,rules,5));
        deckArray.add(new Card("Clubs","Black",5,rules,5));
        deckArray.add(new Card("Spades","Black",5,rules,5));

        deckArray.add(new Card("Heart","Red",6,rules,6));
        deckArray.add(new Card("Diamonds","Red",6,rules,6));
        deckArray.add(new Card("Clubs","Black",6,rules,6));
        deckArray.add(new Card("Spades","Black",6,rules,6));

        deckArray.add(new Card("Heart","Red",7,rules,7));
        deckArray.add(new Card("Diamonds","Red",7,rules,7));
        deckArray.add(new Card("Clubs","Black",7,rules,7));
        deckArray.add(new Card("Spades","Black",7,rules,7));

        deckArray.add(new Card("Heart","Red",8,rules,8));
        deckArray.add(new Card("Diamonds","Red",8,rules,8));
        deckArray.add(new Card("Clubs","Black",8,rules,8));
        deckArray.add(new Card("Spades","Black",8,rules,8));

        deckArray.add(new Card("Heart","Red",9,rules,9));
        deckArray.add(new Card("Diamonds","Red",9,rules,9));
        deckArray.add(new Card("Clubs","Black",9,rules,9));
        deckArray.add(new Card("Spades","Black",9,rules,9));

        deckArray.add(new Card("Heart","Red",10,rules,10));
        deckArray.add(new Card("Diamonds","Red",10,rules,10));
        deckArray.add(new Card("Clubs","Black",10,rules,10));
        deckArray.add(new Card("Spades","Black",10,rules,10));

        deckArray.add(new Card("Heart Jack","Red",11,rules,11));
        deckArray.add(new Card("Diamonds Jack","Red",11,rules,11));
        deckArray.add(new Card("Clubs Jack","Black",11,rules,11));
        deckArray.add(new Card("Spades Jack","Black",11,rules,11));

        deckArray.add(new Card("Heart Qeen","Red",12,rules,12));
        deckArray.add(new Card("Diamonds Qeen","Red",12,rules,12));
        deckArray.add(new Card("Clubs Qeen","Black",12,rules,12));
        deckArray.add(new Card("Spades Qeen","Black",12,rules,12));

        deckArray.add(new Card("Heart King","Red",13,rules,13));
        deckArray.add(new Card("Diamonds King","Red",13,rules,13));
        deckArray.add(new Card("Clubs King","Black",13,rules,13));
        deckArray.add(new Card("Spades King","Black",13,rules,13));

        deckArray.add(new Card("Joker","Red",14,rules,14));
        deckArray.add(new Card("Joker","Black",14,rules,14));

        return new Deck(this.rules,deckArray,this.rules.getDeckStarter());
    }
}
