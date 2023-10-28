package com.skilldistillery.blackjack.entities;

import java.util.*;

public abstract class Hand {
	
	protected List<Card> cards = new ArrayList<>();
	
	public abstract int getHandValue();
	
	public Hand() {
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.removeAll(cards);
	}
	
	public String toString() {
		return cards.toString();
	}
	
	

}
