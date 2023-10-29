package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	
	private Deck deck;
	
	public Dealer() {
		super();
		deck = new Deck();
	}
	
	public void dealerShuffles() {
		deck.shuffle();
	}
	
	public Card dealerDeals() {
		Card card = deck.dealCard();
		return card;
	}
	
	public String playersMove() {
		if (ruleOfSeventeen()) {
			return super.playersMove("hit");
		} else {
			return super.playersMove("stand");
		}
	}
	
	public boolean ruleOfSeventeen(){
		if (hand.getHandValue() < 17) {
			System.out.println("The dealer has hit.");
			return playerHits("hit");
		}
		else {
			System.out.println("The dealer is forced to stand.");
			return playerHits("stand");
		}
	}

	public void promptForCard() {
		System.out.println("Would you like to hit or stand? 1 for hit, 2 for stand");
	}
	
	
	public void showHand(boolean dealersTurn) {
		
		if (dealersTurn) {
		System.out.println("The dealer has "+ hand.toString());
		System.out.println("showing a total of " + hand.getHandValue());

		}
		else {
			System.out.println("The dealer has ["+ hand.viewACard() + " and a hidden card]");
			System.out.println("showing a total of " + hand.viewACard().getValue());

		}
	}
	
	public void announceCard(String currentPlayer, Card card) {
		System.out.println(currentPlayer + " recieved " + card.toString() + "\n");
	}
	
	
	public void rebuildDeck(Hand playerHand){
		while(hand.getHandValue()!=0) {
			Card card = hand.clear();
			deck.addCard(card);
			}
		
		while(playerHand.getHandValue()!=0) {
		Card card = playerHand.clear();
		deck.addCard(card);
		}
	}

	public void determineWinner(Player player) {
		System.out.println();
		if (player.isBust()) {
			System.out.println("Player loses because the player busted");
		} else if (this.isBust()) {
			System.out.println("Player wins because the dealer busted");
		} else if (player.getHandValue() == this.getHandValue()) {
			System.out.println("The game was a tie");
		} else if (player.getHandValue() > this.getHandValue()) {
			System.out.println("Player wins! The Player's hand was higher without going over 21.");
		} else if (player.getHandValue() < this.getHandValue()) {
			System.out.println("Player loses! The dealer's hand was higher without going over 21.");
		}		
	}
	
	
}
