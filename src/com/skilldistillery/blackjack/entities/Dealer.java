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
	
	public boolean ruleOfSeventeen(){
		if (hand.getHandValue() <= 17) {
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
		System.out.print("The dealer has ");
		
		if (dealersTurn) {
		System.out.println(hand.toString());
		System.out.println("showing a total of " + hand.getHandValue());

		}
		else {
			System.out.println(hand.viewACard() + " and a hidden card");
			System.out.println("showing a total of " + hand.viewACard().getValue());

		}
	}
	
	public void rebuildDeck(){
		while(hand.getHandValue()!=0) {
		Card card = hand.clear();
		deck.addCard(card);
		}
	}
	
	public void rebuildDeck(Hand playerHand){
		while(playerHand.getHandValue()!=0) {
		Card card = playerHand.clear();
		deck.addCard(card);
		}
	}
	
	
}
