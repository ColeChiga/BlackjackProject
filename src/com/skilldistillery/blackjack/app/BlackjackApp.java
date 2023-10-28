package com.skilldistillery.blackjack.app;

import java.util.*;

import com.skilldistillery.blackjack.entities.*;

public class BlackjackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();

		bja.run();

	}

	public void run() {
		dealCards();
		boolean play;
		do {
			play = gamePlay();
		} while (play);
		System.out.println("\n\n");
		do {
			play = dealerGamePlay();
		} while (play);
		winner();
	}

	private void winner() {
		if (player.isBust()) {
			System.out.println("You lose because you busted");
		}
		else if (dealer.isBust()) {
			System.out.println("You win because the dealer busted");
		}
		else if(player.getHandValue()==dealer.getHandValue()) {
			System.out.println("The game was a tie");
		}
		else if(player.getHandValue()>dealer.getHandValue()) {
			System.out.println("You win! Your hand was higher without going over 21.");
		}
		else if(player.getHandValue()<dealer.getHandValue()) {
			System.out.println("You lose! The dealer's hand was higher without going over 21.");
		}
	}

	public void dealCards() {

		Card card;
		dealer.dealerShuffles();

		for (int i = 0; i < 4; i++) {
			card = dealer.dealerDeals();
			if (i % 2 == 0) {
				player.addCard(card);
			} else {
				dealer.addCard(card);
			}
		}
	}

	public boolean gamePlay() {
		BlackjackHand hand = (BlackjackHand) player.getHand();

		player.showHand();
		System.out.println();
		dealer.showHand(false);
		if (hand.isBlackjack()) {
			System.out.println("BLACKJACK! You have 21!");
			return false;
		}

		dealer.promptForCard();
		String choice = sc.nextLine();
		choice = choice.toLowerCase();
		
		
		if (choice.contentEquals("1")) {
			choice = "hit";
		} else if (choice.equals("2")) {
			choice = "stand";
		}
		if (!choice.equals("hit") && !choice.equals("stand")) {
			System.out.println("Invalid input");
			return true;
		}

		if (player.playerHits(choice)) {
			Card card = dealer.dealerDeals();
			System.out.println("Player recieved "+ card + "\n");
			player.addCard(card);
		} else {
			System.out.println("You have chosen to stand");
			
			return false;
		}
		if (hand.isBust()) {
			player.showHand();
			System.out.println("you have busted");
			return false;
		}
		return true;
	}

	private boolean dealerGamePlay() {
		BlackjackHand hand = (BlackjackHand) dealer.getHand();

		player.showHand();
		System.out.println();
		dealer.showHand(true);
		System.out.println();
		
		
		
		if (hand.isBlackjack()) {
			System.out.println("BLACKJACK! the Dealer has 21!\n");
			return false;
		}
		
		if (dealer.ruleOfSeventeen()) {
			Card card = dealer.dealerDeals();
			
			System.out.println("Dealer recieved " + card+"\n");

			dealer.addCard(card);
		} else {
			return false;
		}
		
		dealer.showHand(true);
		
		if (hand.isBust()) {
			System.out.println("The dealer has busted\n");
			return false;
		}
		return true;
	}
}
