package com.skilldistillery.blackjack.entities;

import java.util.*;

public class Card {
	Suit suit;
	Rank rank;
	
	PlayingCardDesign design;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;

		this.design = new PlayingCardDesign(suit, rank);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	public int getValue() {
		return rank.getValue();
	}

	@Override
	public String toString() {
		
		design.printCard();
		
		return "the "+ rank + " of " + suit ;
	}
	
}
