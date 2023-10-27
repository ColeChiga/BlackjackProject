package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO("Two", 2),
	THREE("Three", 3),
	FOUR("Four",4),
	FIVE("Five",5),
	SIX("Six",6),
	SEVEN("Seven",7),
	EIGHT("Eight",8),
	NINE("Nine",9),
	TEN("Ten",10),
	JACK("Jack",10),
	QUEEN("Queen",10),
	KING("King",10),
	ACE("Ace",11);
	
	final private int value;
	final private String name;

	private Rank(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
