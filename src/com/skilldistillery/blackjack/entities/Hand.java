package com.skilldistillery.blackjack.entities;

import java.util.*;

public abstract class Hand {
	
	protected List<Card> cards;
	
	public abstract int getHandValue();
	

}