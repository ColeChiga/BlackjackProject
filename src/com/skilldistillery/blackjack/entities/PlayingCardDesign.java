package com.skilldistillery.blackjack.entities;

public class PlayingCardDesign {

	private char suit;
	private char rank;
	private int value;

	public PlayingCardDesign(Suit suit, Rank rank) {
		char suitChar = suit.getUCode();

		char rankChar = rankConvert(rank);

		this.suit = suitChar;
		this.rank = rankChar;
	}

	public char rankConvert(Rank rank) {
		String rankString = rank.toString();
		char rankChar = ' ';

		if (rankString.equals("Jack") || rankString.equals("Queen") || rankString.equals("King") || rankString.equals("Ace")) {
			rankChar = rankString.charAt(0);
		} else if (rankString.equals("Ten")) {
			this.value = 10;
		} else {
			this.value = rank.getValue();
			rankChar = (char) this.value;
		}

		return rankChar;
	}

	public void printCard() {

		switch (rank) {
		case 'K':
			kingsCard();
			break;
		case 'Q':
			queensCard();
			break;
		case 'J':
			jacksCard();
			break;
		case 'A':
			aceCard();
			break;
		default:
			numberedCard();

		}
	}

	private void numberedCard() {

		char case1 = ' ';
		char case2 = ' ';
		char case3 = ' ';
		char case4 = ' ';
		char case5 = ' ';
		char case6 = ' ';

		if (value > 3) {
			case1 = suit;
		}
		if (value > 5 && value < 9) {
			case2 = suit;
		}
		if (value % 2 == 1) {
			case3 = suit;
		}
		if (value == 2 || value == 3) {
			case4 = suit;
		}
		if (value == 9 || value == 10) {
			case5 = suit;
		}
		if (value == 8 || value == 10) {
			case6 = suit;
		}

		System.out.println();
		System.out.println(" _____________ ");
		System.out.println("|             |");
		System.out.printf("| %c%-2d         |\n", suit, value);
		System.out.println("|             |");
		System.out.printf("|    %c %c %c    |\n", case1, case4, case1);
		System.out.printf("|    %c %c %c    |\n", case5, case6, case5);
		System.out.printf("|    %c %c %c    |\n", case2, case3, case2);
		System.out.printf("|    %c %c %c    |\n", case5, case6, case5);
		System.out.printf("|    %c %c %c    |\n", case1, case4, case1);
		System.out.println("|             |");
		System.out.printf("|         %2d%c |\n", value, suit);
		System.out.println("|_____________|");
	}

	public void kingsCard() {
		System.out.println();
		System.out.println(" _____________  ");
		System.out.println("|             | ");
		System.out.println("| " + suit + "K          | ");
		System.out.println("|   __ † __   |  ");
		System.out.println("|  / /\\" + suit + "/\\ \\  | ");
		System.out.println("| ( (  |  ) ) | ");
		System.out.println("|  \\ \\ | / /  | ");
		System.out.println("|   \\_\\|/_/   |");
		System.out.println("|   |_|_|_|   |");
		System.out.println("|             |");
		System.out.println("|          K" + suit + " |");
		System.out.println("|_____________|");

	}

	public void queensCard() {
		System.out.println();
		System.out.println(" _____________ ");
		System.out.println("|             |");
		System.out.println("| " + suit + "Q          |");
		System.out.println("|             |");
		System.out.println("|   ∆∆∆∆∆∆∆   |");
		System.out.println("|  / / " + suit + " \\ \\  |");
		System.out.println("|  \\ \\ | / /  |");
		System.out.println("|   \\_\\_/_/   |");
		System.out.println("|   |_|_|_|   |");
		System.out.println("|             |");
		System.out.println("|          Q" + suit + " |");
		System.out.println("|_____________|");
	}

	public void jacksCard() {
		System.out.println();
		System.out.println(" _____________ ");
		System.out.println("|             |");
		System.out.println("| " + suit + "J_     _   |");
		System.out.println("|  |" + suit + "|   |" + suit + "|  |");
		System.out.println("|   \\\\   //   |");
		System.out.println("|  |\\/\\" + suit + "/\\/|  |");
		System.out.println("|  |       |  |");
		System.out.println("|  |_______|  |");
		System.out.println("|    // \\\\    |");
		System.out.println("|   //   \\\\   |");
		System.out.println("|          J" + suit + " |");
		System.out.println("|_____________|");
	}

	public void aceCard() {
		System.out.println();
		System.out.println(" _____________ ");
		System.out.println("|             |");
		System.out.println("| " + suit + "A          |");

		if (suit == '\u2665') {
			System.out.println("|             |");
			System.out.println("|  ***   ***  |");
			System.out.println("| ***** ***** |");
			System.out.println("| *********** |");
			System.out.println("| *********** |");
			System.out.println("|  *********  |");
			System.out.println("|    *****    |");
			System.out.println("|      *      |");

		} else if (suit == '\u2660') {
			System.out.println("|      *      |");
			System.out.println("|     ***     |");
			System.out.println("|   *******   |");
			System.out.println("|  *********  |");
			System.out.println("| *********** |");
			System.out.println("|  *********  |");
			System.out.println("|      *      |");
			System.out.println("|     ***     |");

		} else if (suit == '\u2663') {
			System.out.println("|     ***     |");
			System.out.println("|    *****    |");
			System.out.println("|    *****    |");
			System.out.println("|  *********  |");
			System.out.println("| *********** |");
			System.out.println("|  **** ****  |");
			System.out.println("|      *      |");
			System.out.println("|     ***     |");

		} else if (suit == '\u2666') {
			System.out.println("|      *      |");
			System.out.println("|     ***     |");
			System.out.println("|   *******   |");
			System.out.println("| *********** |");
			System.out.println("| *********** |");
			System.out.println("|   *******   |");
			System.out.println("|     ***     |");
			System.out.println("|      *      |");
		}

		System.out.println("|          A" + suit + " |");
		System.out.println("|_____________|");
	}
}