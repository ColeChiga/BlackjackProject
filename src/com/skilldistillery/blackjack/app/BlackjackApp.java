package com.skilldistillery.blackjack.app;

import java.util.*;
import java.util.concurrent.TimeUnit;

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

		boolean play;
		boolean startGame = true;
		
		while (startGame) {
			dealCards();

			do {
				play = play(false);
			} while (play);

			System.out.println("\n\n");

			do {
				if (player.isBust()) {
					break;
				}
				play = play(true);
			} while (play);

			
			dealer.determineWinner(player);
			cleanUp();
			startGame = continuePlaying();
		}
		System.out.println("Thank you for playing, come again!");
	}

	public boolean play(boolean dealerTurn) {

		String currentPlayer;
		BlackjackHand hand;
		String choice;

		if (!dealerTurn) {
			hand = (BlackjackHand) player.getHand();
			currentPlayer = "Player";
		} else {
			hand = (BlackjackHand) dealer.getHand();
			currentPlayer = "Dealer";
		}

		showHand(dealerTurn);

		if (hand.isBlackjack()) {
			System.out.println("BLACKJACK! " + currentPlayer + "'s hand equals 21!");
			return false;
		}
		if (!dealerTurn) {
			dealer.promptForCard();
			choice = sc.nextLine();
			choice = player.playersMove(choice);

		} else {
			choice = dealer.playersMove();
		}

		if (choice.equals("hit")) {
			Card card = dealer.dealerDeals();
			
			dealer.announceCard(currentPlayer, card);
			
			if (!dealerTurn) {
				player.addCard(card);
			} else {
				dealer.addCard(card);
			}

		} else if (choice.equals("stand")) {
			System.out.println(currentPlayer + " has chosen to stand");
			return false;
		}
		if (!choice.equals("hit") && !choice.equals("stand")) {
			System.out.println("Invalid input");
			return true;
		}

		pause();

		if (hand.isBust()) {
			showHand(dealerTurn);
			System.out.println(currentPlayer + " has busted");
			return false;
		}
		return true;
	}

	private void cleanUp() {
		
		dealer.rebuildDeck(player.getHand());
		System.out.println("The game has been cleaned up");
	}

	private boolean continuePlaying() {
		System.out.println("Would you like to play another round? 1 for yes, anything else for no");
		String answer = sc.nextLine();
		answer = answer.toLowerCase();
		if (answer.equals("one") || answer.equals("yes") || answer.equals("1")) {
			return true;
		} else {
			return false;
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

	public void showHand(boolean dealerTurn) {
		player.showHand();
		System.out.println();
		pause();
		dealer.showHand(dealerTurn);
		System.out.println();
		pause();
	}

	public void pause() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
