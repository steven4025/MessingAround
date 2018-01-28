package cardGame;

public class Player {
	
	public final static int STARTAMOUNT = 100;
	
	public int bet(int startAmount, int betAmount) {
		int remainAmount = startAmount - betAmount;
		return remainAmount;
	}
}
