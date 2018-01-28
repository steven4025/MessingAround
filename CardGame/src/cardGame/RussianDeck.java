package cardGame;

import java.util.Random;

public class RussianDeck {
	
	protected Card[] deck; //array of cards to represent deck
	private int cardsRemaining; //number of cards left in the deck
	
	/**
	 * Creates a new deck of 52 cards in a specific, fixed order. Sets
	 * cardsRemaining at 52 to ensure that draw() can be used correctly.
	 */
	public RussianDeck(){
		deck = new Card[36]; //number of cards for Seka
		
		int cardCounter = 0;
		for (int suit = 0; suit <= 3; suit++) {	
			//for each of the 4 suits
			for (int rank = 6; rank >= 6 && rank <= 14; rank++) { 
				// and each of the 8, through King (13), and Ace (14)
				deck[cardCounter] = new Card(suit, rank); //we create a card 
															//and add it to the deck

				cardCounter++;
				} //this initializes the deck like a new pack of cards: sorted
		}
		
		cardsRemaining = deck.length;
	}
	
	public void shuffle(){
		Random gen = new Random(); //used to pick a random position in deck
		int cardToSwap; //the selected deck position
		Card tmpCard; //holds the card being swapped
		
		for (int ind = 0; ind < deck.length; ind++){ //for each position in the deck:
			cardToSwap = gen.nextInt(36); //pick a random number between 1 and 52
			tmpCard = deck[ind]; //pull the card at current position from deck
			deck[ind] = deck[cardToSwap]; //put the randomly selected card into this position
			deck[cardToSwap] = tmpCard; //put the original card in the new position
		}
	}
	
	public Card draw(){
		if (cardsRemaining == 0)
			throw new IllegalStateException("No cards are left in the deck.");
		
		Card draw = deck[deck.length-cardsRemaining];
				//when all cards present, draws deck[0],
				//when 1 card drawn, draws deck[1], 
				//etc.
		cardsRemaining--;
		return draw;
	}
}
