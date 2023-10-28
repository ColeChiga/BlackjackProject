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

		dealer.showHand(false);
		if (hand.isBlackjack()) {
			return false;
		}

		dealer.promptForCard();
		String choice = sc.nextLine();

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
			player.addCard(card);
		} else {
			return false;
		}
		player.showHand();
		if (hand.isBust()) {
			System.out.println("you have busted");
			return false;
		}
		return true;
	}

}
