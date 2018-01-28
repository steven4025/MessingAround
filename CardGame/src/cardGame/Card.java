package cardGame;

/*
 * Description of a playing card that can be used in card games (Blackjack, Poker, etc.).
 * The card is represented as a pair of integers, one for the suit (0, 1, 2, or 3,
 * standing for Spades, Hearts, Diamonds, and Clubs, respectively) and one for
 * the rank (1, 2, ..., 13, where values 2 through 10 represent the numeric value 
 * present on number cards, and 1 represents the Ace, 11 represents the Jack, 12
 * represents the Queen, and 13 represents the King). The class Deck.java is an
 * array of Cards to act as a deck.
 *
 */
public class Card {

	// Named constants for easier design of class
	// Also for use in other classes in project
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;

	public final static int ACE = 14;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;

	private final int suit; // The suit of the card
							// (spades, hearts, etc.)
	private final int rank; // The number or face appearing on 
							// the card
	
	/**
	 * Creates a card object with the specified suit and rank
	 * @param givenSuit specified suit (0, 1, 2, or 3)
	 * @param givenRank specified rank/value (1, 2, ..., 13)
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * Gives the value of the card, where an Ace counts as 11, all 
	 * face cards count as 10, and other cards have the same value
	 * as their rank.
	 * @return	the card's value (between 2 and 11 inclusive)
	 */
	public int valueOf(){
		if (rank > 1 && rank < 11)
			return rank;
		else {
			switch (rank) {
			case ACE: 
				return 11;
			default:
				return 10;
			}
		}
	}

	/**
	 * Converts the rank of the card into a readable String
	 * @return	String with card's rank ("Ace", "2", ..., "Queen", or "King")
	 */
	public String stringOfRank() {
		if (rank > 1 && rank < 11)
			return rank + "";
		else {
			switch (rank) {
			case ACE:
				return "Ace";
			case JACK:
				return "Jack";
			case QUEEN:
				return "Queen";
			default:
				return "King";
			}
		}
	}

	/**
	 * Converts the rank of the card into a readable String
	 * @return	String with card's suit ("Spades", "Hearts", "Diamonds", or "Clubs")
	 */
	public String stringOfSuit() {
		switch (suit) {
		case SPADES:
			return "Spades";
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		default:
			return "Clubs";
		}
	}

	public String toString(){
		return stringOfRank() + " of " + stringOfSuit();
	}

}
