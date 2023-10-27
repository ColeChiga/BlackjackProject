package com.skilldistillery.blackjack.entities;

import java.util.*;

public class Deck {

	List<Card> deckOfCards = new ArrayList<>();

	public Deck() {

		Suit[] suits = Suit.values();		
		Rank[] ranks = Rank.values();
		
		for (Rank rank : ranks) {
			for (Suit suit : suits) {
				Card aCard = new Card(suit,rank);
				deckOfCards.add(aCard);
			}
		}
	}
	
	public int checkDeckSize() {
		return deckOfCards.size();
	}
	
	public Card dealCard() {
		return deckOfCards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
}
