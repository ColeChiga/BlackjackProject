package com.skilldistillery.blackjack.entities;

public class Player {
	
	protected BlackjackHand hand ;
	
	public Player(){
		hand = new BlackjackHand();
	}
	
	public boolean playerHits(String choice) {
		if (choice.equals("hit")) {
			return true;
		}
		return false;
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}
	
	public void showHand() {
		System.out.println("The player has " + hand.toString());
		System.out.println("showing a total of " + hand.getHandValue());
	}
	
	public Hand getHand() {
		return hand;
	}
}
