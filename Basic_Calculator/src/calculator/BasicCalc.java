package calculator;

import java.util.Scanner;

public class BasicCalc {


	public static void main(String[] args) {
		System.out.println("Welcome message");
		
		Scanner sc = new Scanner(System.in);

		do {
			String str = sc.nextLine();
			if (str.equals("exit")) {
				System.out.println("Exiting calculator. Goodbye!");
				break;
			}
			String [] stringParts = str.split(" ");
			String firstNum = stringParts[0];
			String op = stringParts[1];
			String secondNum = stringParts[2];
			int x;
			int y;
			int res;
		
			try {
				x = Integer.parseInt(firstNum);
			}catch (NumberFormatException e) {
				System.out.println("First number not valid. Please enter another expression.");
				continue;
			}
			try {
				y = Integer.parseInt(secondNum);
			}catch (NumberFormatException e) {
				System.out.println("Second number not valid. Please enter another expression.");
				continue;
			}if (op.equals("+")) {
				res = x + y;
				System.out.println("Answer: " + res);
			}else if (op.equals("-")) {
				res = x - y;
				System.out.println("Answer: " + res);
			}else if (op.equals("*")) {
				res = x * y;
				System.out.println("Answer: " + res);
			}else if (op.equals("/")) { 
				res = x / y;
				System.out.println("Answer: " + res);
			}else if (op.equals("%")) { 
				res = x % y;
				System.out.println("Answer: " + res);
			}
		}while (true);
	}
}
