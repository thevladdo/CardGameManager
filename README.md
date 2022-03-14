# CardGameManager
### Project for Advanced Programming exam of University of Camerino

The project of this report consists in the design of a Java library that allows the implementation of card games, the use of this library to implement one generic game and the creation of an interface that allows you to access the different games implemented.



### Approach
The approach used for the development of these specifications is guided by the basic idea of modeling classes and interfaces on real-life situations. In the case of card games, a similar approach is to visualize what is happening when one, two or more people play a certain card game.



### Responsabilities
The first idea in a card game was Card, an indispensable element. The management of the features and actions that can be implemented on the Card has been assigned to the *"CardInterface"* interface which is implemented by the *"Card"* class and represents a single card element.

Following this decision, I needed to organize them in a deck to organize a deck. A real example could be the generic 52-card deck with 4 different suits and 13 values for each suit. The second responsibility that emerged is evident: a card, for example the ace, can assume various values according to the rules of the game, in our case the ace can have the minimum or maximum value.
In addition to this factor, others, such as the maximum number of cards in the deck and the limit values that each card can assume are managed by the *"GameRulesInterface"* interface implemented by the *"GameRules"* class. In addition to this responsibility, there is also the need to have each player draw cards from the deck and keep them in their hand, managing it according to the rules of the game.

As stated above, a deck of cards will manage the set of cards that make it up, allowing it to perform various operations, such as being sorted according to certain criteria or randomly mixed. This responsibility is managed by the *"DeckInterface"* interface which is implemented by the *"Deck"* class.

Instead, each player will be created with characteristics and will be able to perform well-defined operations in the *"PlayerInterface"* interface which is implemented by the *"Player"* class.

Finally, each player will have a certain amount of cards in his hand. This amount will be used by the player to carry out his actions in the game according to strategies and in compliance with the rules of the game. Based on the approach used, a group of people was imagined holding the cards in their hands and carrying out various operations while looking at the card objects. This quantity of cards is defined by the *"HandInterface"* interface which is implemented by the *"Hand"* class. *"Hand"* extends the aforementioned *"Deck"* class. In fact, the *"Hand"* class was conceived as a small 'deck' of cards with additional features. Therefore, the cards in each player's hand can be shuffled, sorted, added or removed exactly as for the deck, while allowing compliance with the rules and additional operations such as the action of discarding a card.



The use of the library's classes and interfaces is visible in the *"Rubamazzetto"* class and in the *"RubamazzettoInterface"* interface created for the elaboration of a card game called 'Rubamazzetto', also known under the name of 'Rubamazzo'. Within the *"Rubamazzetto"* class there is an *"Actions"* Inner Class that deals with the actions that a player can do in the game.

The whole project was also organized according to the standards of the MVC pattern.

A further brief description of the responsibilities listed above can be found in the javadocs accompanying the source code.

<p align="center">
  <img width="599" alt="Schermata 2022-03-14 alle 10 51 52" src="https://user-images.githubusercontent.com/56829605/158148159-a73d8416-9e00-466f-bbeb-fcd0a034c655.png">
</p>
