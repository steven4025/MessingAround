package prime;

import java.lang.Math;

import java.util.Scanner;

public class numPrimes {

	public static int estimatePrimes(int n) {
		return (int) (n / ((Math.log(n) / Math.log(2)) - 1));
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if ((n % i) == 0) return false;
		}
		return true;
	}

	public static int primesBelow(int n) {
		int counter = 0;
		for (int i = 2; i <= n; n--) {
			if (isPrime(n)) counter++;
		}return counter;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		do {
			System.out.println("Please give a number between 2 and 100,000, or type quit");
			str = sc.nextLine();
			try {
				int n = Integer.parseInt(str);
				System.out.println("Counting primes less than or equal to " + n + "..." );
				System.out.println("Estimate: " + estimatePrimes(n));
				System.out.println("Actual: " + primesBelow(n));
			}catch (NumberFormatException e) {
				if (str.equals("quit")) {
					System.out.println("Exiting program.");
					break;
				}
				System.out.println("Incorrect Number Format. Please Try Again.");
			}
			
		}while (true);
	}

}
