package prime;

public class HOTPO {

	public static int nextTerm(int n) {
		if (n < 1) throw new IllegalArgumentException("Parameter Less Than One.");
		if (n%2 == 0) return n/2;
		else return (3*n) + 1;
	}

	public static boolean isPrime(int n) {
		//if (n < 2 || n > 10000) throw new IllegalArgumentException("Number is must be between 2 and 10,000.");
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if ((n % i) == 0) return false;
		}
		return true;
	}

	public static int stoppingTime(int n) {
		int counter = 0;
		try {
			do {
				n = nextTerm(n);
				counter++;
			}while (n != 1);
		}catch (IllegalArgumentException e) {
			if (n < 1) System.out.println("Parameter Less Than One.");
		}return counter;
	}

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 3; i < 10000; i++) {
			if (isPrime(stoppingTime(i))) counter++;
		}
		System.out.println(counter + " numbers less than 10000 have prime stopping times, or  percent.");
	}

}
