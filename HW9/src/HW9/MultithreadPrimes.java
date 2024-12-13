package HW9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultithreadPrimes {
	static private int checkInput(Scanner scanner) {
		boolean inputInvalid = true;
		String input = scanner.next();
		int output = 0;
		
		while(inputInvalid) {
			try {
				output = Integer.parseInt(input);
				inputInvalid = false;
			}catch(NumberFormatException e) {
				System.out.println("Invalid input, please try again: ");
				input = scanner.next();
			}
		}
		return output;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of threads to be used: ");
		int NUM_THREADS = checkInput(scanner);
		
		System.out.print("Enter the number the upper bound for the prime number search range: ");
		int UPPER_BOUND = checkInput(scanner);
		
		long startTime = System.currentTimeMillis();
		List<PrimeSearchThread> threads = new ArrayList<>();
		int blockSize = UPPER_BOUND / NUM_THREADS;
		
		for (int i = 0; i < NUM_THREADS; i++) {
			int start = i * blockSize;
			int end = (i == NUM_THREADS - 1) ? UPPER_BOUND : (i + 1) * blockSize;
			PrimeSearchThread thread = new PrimeSearchThread(start, end);
			threads.add(thread);
			thread.start();
		}
		for (PrimeSearchThread thread : threads) {
			thread.join();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Done in " + (endTime - startTime) + " ms.");
	}
	
	private static class PrimeSearchThread extends Thread {
		private final int start;
		private final int end;
		private static final Object lock = new Object();
		
		public PrimeSearchThread(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public void run() {
			for (int i = start; i < end; i++) {
				if (isPrime(i)) {
					synchronized(lock){
						System.out.println(i);
					}
				}
			}
		}
		private boolean isPrime(int n) {
			if (n <= 1) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
				return false;
				}
			}
			return true;
		}
	}
}