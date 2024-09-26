package HW3;

import java.util.Scanner;

public class taylorSeries {
	public static void main(String[] args){
//		Open scanner
		Scanner input = new Scanner(System.in);

//		Get valid value for x
		System.out.print("Enter the value of x: ");
        String in = input.nextLine();
        while(!xValid(in)) {
        	System.out.println("X must be a real number please try again");  
        	System.out.print("Enter the value of x: "); 
			in = input.nextLine();
        }
        double x = Double.parseDouble(in);
        
//      Get valid value for n
        System.out.print("Enter the number of terms (n): ");
        in = input.nextLine();
        while(!nValid(in)) {
        	System.out.println("N must be a positive integer please try again");  
        	System.out.print("Enter the value of n: "); 
			in = input.nextLine();
        }
        int n = Integer.parseInt(in);
        
//      Close input(scanner)
        input.close();
        
//      Calculate Sum
        double sum = 0;
        for(int i = 0; i < n; i++) {
        	sum += Math.pow(x, i)/factorial(i);
        }
        
//      Formatted sum output print
        System.out.println("The approximation of e^" + x + " using "+ n + " terms is: " + sum);
        
	}

//	Make sure x is valid input
	public static boolean xValid(String str) {
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
	
//	Makes sure n is valid input
	public static boolean nValid(String str) {
		if(str == null) {
			return false;
		}
		try {
			Integer.parseInt(str);
		}catch (NumberFormatException e) {
			return false;
		}
		
		if(Integer.parseInt(str) < 1) {
			return false;
		}
		return true;
	}
	
//	Calculates factorial
	public static int factorial(int n) { 
		if (n == 0) {
			return 1; 
		}
		return n * factorial(n - 1); 
		} 
	
}
