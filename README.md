# BlackjackProject

# Description

This project was creating a game of Blackjack.The game follows most of the typical rules of blackjack, with the exception of some rules like splitting your hand, betting, and hard or soft aces.

In this game the player is dealt two cards from a deck and is shown the total value of their cards (ace high). The dealer is also dealt two cards, but only one is shown to the player. 

The player then gets to decide if they want to hit or stand (pressing either 1 or 2, or typing hit or stand). If the player hits they are given another card and can choose again. The player's turn continues until they stand, get a total of 21, or get a total over 21. 

When the player's turn is over it becomes the dealer's turn, unless the player busted in which the game is over. The dealer reveal their other card and then plays by the rule of seventeen. If the total value of their cards is less than 17 they hit, otherwise they stand. 

Once the dealer's turn is over the winner is determined and announced, then the game is cleaned up, cards are added back to the deck, and the player can choose to play again. 

For best game play, expand your console as much as you can vertically.

# Tech used

Java, OOP, Eclipse

#Objectives

Building classes in an Object-Oriented manner: APIE.

Building classes whose fields are Objects (has-a).

Writing methods.

Using collections to organize and manage data.

Using conditionals to create game logic.
Considering common data and behaviors, and refactoring into parent / child classes.

#Lessons Learned
This project helped me to learn how to organize my methods better in an effective and efficient way. This helps to reduce redundancy and make the code more dry. I tried to do this in my project by organizing each method into the class that it would make the most sense for that action to occur in order to make the code run smoothly. 

I found this to be difficult at times, particularly regarding the methods in the app class. I found it a little difficult to determine if a certain section of code should be performed in the methods of the app class or in the dealer or player classes. I typically leaned toward putting the code into a method in an entities class whenever possible.  
