package hw4;
import java.util.Arrays;
import java.util.Scanner;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.temporal.JulianFields;

public class Main {
	public static void main(String[] args) {
//		Start up
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Gregorian Date Conversion Program!");
		
//		Main loop
		while(true) {
			int[] gregDate = getGregorian(input);	// Gets validated date input
			int julian = convJulian(gregDate);		// Converts gregorian date to julian
			System.out.println("Serial Julian Date: " + julian);
			
//			Checks and validates users input for quiting program
			if(quitCheck(input)) {
				System.out.println("Exiting the program. Goodbye!");
				break;
			}
		}
    	input.close(); 
	}
	
	public static int[] getGregorian(Scanner input) {
		System.out.print("Enter a date in the format (YYYY MM DD): ");
		String in = input.nextLine();
		
//		Makes sure input is 3 different digits separated by spaces
        boolean isValid = in.trim().split("\\s+").length == 3 && 
                          Arrays.stream(in.trim().split("\\s+"))
                                .allMatch(s -> s.matches("\\d+"));  
        
//      Ensures input adheres to calendar rules, forces user to have valid input before continuing 
        if(isValid) {
        	int[] numbers = Arrays.stream(in.trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        	if(numbers[0] > 9999 || numbers[1] > 12 || numbers[2] > 31 || numbers[1] < 1 || numbers[2] < 1 || numbers[0] < 1) {
        		System.out.println("Sorry that is not a valid date");
            	return getGregorian(input);
        	}else if(checkDates(numbers)){
        		return numbers;
        	}else{
        		System.out.println("Sorry that date is not valid for that month");
            	return getGregorian(input);
        	}
        	
        }else
        	System.out.println("Sorry that input is invalid");
        	return getGregorian(input);
			
	}
	
//	Helper function checking if date of month is less than or equal to days in relevant month
	public static boolean checkDates(int[] dates) {
		YearMonth yearMonthObj = YearMonth.of(dates[0], dates[1]);
		if(dates[2] <= yearMonthObj.lengthOfMonth()) {
			return true;
		}else{
			return false;
		}
			
	}
	
//	Converts gregorian date to julian date
	public static int convJulian(int[] gregDate) {
		LocalDate date = LocalDate.of(gregDate[0], gregDate[1], gregDate[2]);
        return (int) date.getLong(JulianFields.JULIAN_DAY);
	}
	
//	Forces valid user input for quiting program
	public static boolean quitCheck(Scanner input) {
		System.out.print("Enter another date? (Y/N): ");
		String in = input.nextLine();
		if(in.equals("y") || in.equals("Y")) {
			return false;
		}else if(in.equals("n") || in.equals("N")){
			return true;
		}else {
			System.out.println("Sorry that input is not recognized");
			return quitCheck(input);
		}
	}

}
