package hw1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Celsius to Fahrenheit Converter");  
		System.out.print("Celsius: ");  
		String celsius = input.nextLine();
		while(!inputGood(celsius)) {
			System.out.println("Invalid input please try again");  
			System.out.print("Celsius: ");  
			celsius = input.nextLine();
		}
		input.close();
		
		double fahrenheit = Double.parseDouble(celsius);
		fahrenheit = fahrenheit * 9 /5 + 32;
		System.out.println("Fahrenheit: " + fahrenheit);
		
	}
	
	public static boolean inputGood(String str) {
		if(str == null) {
			return false;
		}
		try {
			Double.parseDouble(str);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
