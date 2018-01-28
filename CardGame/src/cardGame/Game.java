package cardGame;

import java.util.Scanner;

public class Game {

	public static int getMax(Card[] cards) { //for finding max rank value if no cards share a suit
		int maxValue = 0;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].valueOf() < cards[i+1].valueOf()) {
				maxValue = cards[i+1].valueOf(); //sets max value to next card if previous card has lower rank
			}else {
				maxValue = cards[i].valueOf(); //if previous card holds higher rank than next card, make max value previous card
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RussianDeck deck = new RussianDeck(); //create Russian deck for Seka
		deck.shuffle(); //shuffles deck

		//int cardsRemaining = 36;
		int money = 100; //initial amount of money for betting

		do {
			System.out.println("Remaining amount: " + money + " Please enter bet amount."); //first statement telling you how much money player has left.
			int bet = sc.nextInt();
			if (bet > money) throw new IllegalArgumentException("Cannot bet more than remaning money."); //exception thrown if input higher than remaining amount
			System.out.println("Bet amount: " + bet); //prints out bet amount inputed by user

			int playerSekaValue = 0; //initialize player seka value
			int opponentSekaValue = 0; //initialize opponent seka value

			System.out.println("Player Cards: "); 
			Card[] userCards = new Card[3]; //creating user's hand
			for (int i = 0; i < 3; i++) {
				userCards[i] = deck.draw();
				System.out.println(userCards[i]); //prints out user's hand
			}
			for (int j = 0; j < userCards.length - 1; j++) {
				if (userCards[j].stringOfSuit() == userCards[j+1].stringOfSuit()) { //compares cards next to each other
					playerSekaValue = userCards[j].valueOf() + userCards[j+1].valueOf(); //make player's seka value the combination of like-suit cards
				}else {
					playerSekaValue = getMax(userCards); //if no cards share suit, make player's seka value the max rank
				}
			}

			System.out.println("Player Seka Value: " + playerSekaValue); //print player's seka value


			System.out.println("Opponent Cards: ");
			Card[] opponentCards = new Card[3]; //creating opponent's hand
			for (int i = 0; i < 3; i++) {
				opponentCards[i] = deck.draw();
				System.out.println(opponentCards[i]); //prints out opponent's hand
			}
			for (int j = 0; j < opponentCards.length - 1; j++) {
				if (opponentCards[j].stringOfSuit() == opponentCards[j+1].stringOfSuit()) {  //compares cards next to each other
					opponentSekaValue = opponentCards[j].valueOf() + opponentCards[j+1].valueOf();  //make opponent's seka value the combinarion of like-suit cards
				}else {
					opponentSekaValue = getMax(opponentCards); //if not cards share suit, make opponent's seka value the max rank
				}
			}

			System.out.println("Opponent Seka Value: " + opponentSekaValue); //prints opponent's seka value
			
			if (playerSekaValue > opponentSekaValue) { //if player's seka value is greater than opponent's
				System.out.println("Player wins!");  //print player wins statement
				money = money + bet;
			}else if (playerSekaValue == opponentSekaValue) { //if seka values are the same
				System.out.println("Draw!");  		//print draw statement
			}
			else { 								//if opponent's seka value is greater than player's
				System.out.println("Opponent wins!"); //print opponent wins statement
				money = money - bet;
			}

		}while (true);

	}

}
