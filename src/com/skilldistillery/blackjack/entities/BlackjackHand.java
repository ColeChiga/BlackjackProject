package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	
	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
		
		return total;
	}
	
	public boolean isBlackjack(){
		
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust(){
		
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

	public boolean isHard(){
		// determine if an ace is hard
		return false;
	}
	
	public boolean isSoft(){
		// determine if an ace is soft
		return false;
	}	

	public Card viewACard() {
		return cards.get(0);
//		Card card = cards.get();
//		return cards.;
	}
}
