package prime;

import java.lang.Math;
import java.util.Scanner;

public class PrimeNums {
	
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	public static int estimatePrimes(int n) {
		return (int) (n / ((Math.log(n) / Math.log(2)) - 1));
	}
	
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
		if (n == 2) return true;
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static int primesBelow(int n) {
		int counter = 0;
		for(int i = 2; i <= n; i++) { 
			if (isPrime(n)) {
				counter++;
			}
		}return counter;
	}
	
	public static void main(String[] args) {
		System.out.println(primesBelow(5));
	}

}
