package HW2;

public class GravityCalculator {
	  public static void main(String[] arguments) {
		  double gravity = -9.81; // Earth's gravity in m/s^2
		  double initialVelocity = 0.0;
		  double fallingTime = 10.0;
		  double initialPosition = 0.0;
		  double finalPosition = 0.0;
		  System.out.println("The object's position after " + fallingTime + " seconds is " + finalPosition + " m.");
	  }
	}
//	There are no calculations done with the variables so the default values of falling time and 
//	final position (10.0 and 0.0 respectively) are printed to the console in sentence form.