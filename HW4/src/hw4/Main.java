package hw4;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Gregorian Date Conversion Program!");
		while(true) {
			String input = getGregorian();
			
		}
	}
	
	public static String getGregorian() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a date in the format (YYYY MM DD): ");
		String in = input.nextLine();
		input.close();
		return in;
	}

}
