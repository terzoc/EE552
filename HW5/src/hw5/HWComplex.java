package hw5;

public class HWComplex {
	double real, imaginary;
	
//	Constructor
	public HWComplex(double r, double i) {
		real = r;
		imaginary = i;
	}
	
//	Print override for appropriate formatting
	public String toString() {
		return real + " + " + imaginary + "i";
	}
	
	
//	Getters and setters
	private double getReal() {
		return real;
	}
	
	private double getImaginary() {
		return imaginary;
	}
	
//	Commented out because they are un-used
//	private void setReal(double r) {
//		real = r;
//	}
//	
//	private void setImaginary(double i) {
//		imaginary = i;
//	}
	
//	R1+R2 + I1+I2i
	public HWComplex add(HWComplex cNum) {
		return new HWComplex(real+cNum.getReal(), imaginary + cNum.getImaginary());
	}
	
//	"FOIL"s cNums  
	public HWComplex mul(HWComplex cNum) {
		double ac = real * cNum.getReal();
		double ad = real * cNum.getImaginary();
		double bc = imaginary * cNum.getReal();
		double bd = imaginary * cNum.getImaginary();
		return new HWComplex(ac-bd,ad+bc);
	}
	
	public static void main(String[] args){

	    HWComplex c1 = new HWComplex(2.5, 1.2);

	    HWComplex c2 = new HWComplex(2.4, 1.1);

	    // Test addition

	     HWComplex c3 = c1.add(c2);

	     System.out.println("Addition Result: " + c3);

	     HWComplex c4 = new HWComplex(2.5, 1.2);

	      HWComplex c5 = new HWComplex(2.4, 1.1);

	      // Test multiplication 
	      
	      HWComplex c6 = c4.mul(c5);

	       System.out.println("Multiplication Result: " + c6);

	}
}
