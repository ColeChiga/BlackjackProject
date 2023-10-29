package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts",'\u2665'),
	SPADES("Spades",'\u2660'),
	CLUBS("Clubs",'\u2663'),
	DIAMONDS("Diamonds",'\u2666');
	
	final private String name;
	final private char Ucode;

	private Suit(String name, char Ucode) {
		this.name = name;
		this.Ucode = Ucode;
	}
	
	public char getUCode() {
		return Ucode;
	}
	
	@Override
	public String toString() {
		return name;
	}
		
	

}
