package eurocounter;

import java.util.Scanner;

public class EuroCounter {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("How many 1 cent coins do you have?");
		int oneCent = sc.nextInt();
		
		System.out.println("How many 2 cent coins do you have?");
		int twoCent = sc.nextInt();
		
		
		System.out.println("How many 5 cent coins do you have?");
		int fiveCent = sc.nextInt();
		
		System.out.println("How many 10 cent coins do you have?");
		int tenCent = sc.nextInt();
		
		System.out.println("How many 20 cent coins do you have?");
		int twentyCent = sc.nextInt();
		
		System.out.println("How many 50 cent coins do you have?");
		int fiftyCent = sc.nextInt();
		
		System.out.println("How many 1 Euro bills do you have?");
		int oneEuro = sc.nextInt();
		
		System.out.println("How many 2 Euro bills do you have?");
		int twoEuro = sc.nextInt();
		
		float total =  (float) ((oneCent*0.01) + (twoCent*0.02) + (fiveCent*0.05) + (tenCent*0.10) + (twentyCent*0.20) + (fiftyCent*0.50) + (oneEuro*1.00) + (twoEuro*2.00));
		
		System.out.printf("You have %1.2f euros", total);
	}

}
