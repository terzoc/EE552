package HW3;

import java.util.Scanner;

public class seriesSum {
	public static void main(String[] args){
		
//      Gets input and forces user to use valid input before continuing 		
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        String in = input.nextLine();
        while(!inputGood(in)) {
        	System.out.println("Input must be a positive integer please try again");  
        	System.out.print("Enter the value of n: "); 
			in = input.nextLine();
        }
        input.close();
        
//      Calculates sum
        int n = Integer.parseInt(in);
        double sum = 0;
        for( int i = 0; i < n; i++) {
        	sum += 1.0/Math.pow(2,i);
        }
        
//      Formatted print
        System.out.println("The sum of the first " + n + " terms of the series is: "+ sum);
    }
	
//	Makes sure input is a positive int
	public static boolean inputGood(String str) {
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
}
