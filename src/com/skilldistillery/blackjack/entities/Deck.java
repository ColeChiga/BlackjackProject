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
	
	public int cardsLeftInDeck() {
		for (Card card : deckOfCards) {
			System.out.println(card.toString());
		}
		return checkDeckSize();
	}
	
	public int checkDeckSize() {
		return deckOfCards.size();
	}
	
	public Card dealCard() {
		return deckOfCards.remove(0);
	}
	
	public void dealCard(Hand hand) {
		Card card;
		card = deckOfCards.remove(0);
		System.out.println(card);
		hand.addCard(card);
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
	
	public void addCard(Card card) {
		deckOfCards.add(card);
	}
}
