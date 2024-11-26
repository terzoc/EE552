package hw8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CapitalizeWords {
	
	
	private static String capFirstLetters(String line) {
//		Split line into an array of words by spaces
        String[] words = line.split("\\s+");
        StringBuilder output = new StringBuilder();

//      For every word in the line capitalize the first letter
        for (String word : words) {
            if (word.length() > 0) {
            	output.append(Character.toUpperCase(word.charAt(0)))
                               .append(word.substring(1))
                               .append(" ");
            }
        }

//      Return modified line
        return output.toString().trim();
    }
	
	public static void capitalizeWordsFromFile(String inputFile, String outputFile){

//		Try with resources for buffered reader and writer
		try (BufferedReader readBuffer = new BufferedReader(new FileReader(inputFile));
	         BufferedWriter writeBuffer = new BufferedWriter(new FileWriter(outputFile))) {

	        String line;
	        
//			Read file line at a time
	        while ((line = readBuffer.readLine()) != null) {
	        	
//	        	Capitalize first letter of every word in line
	        	String capitalizedLine = capFirstLetters(line);
	        	
//	        	Write modified line to output file0
	        	writeBuffer.write(capitalizedLine);
	        	writeBuffer.newLine();
	        }

	        System.out.println("The first letters of every word in " + inputFile + " have been capitalized and stored in " + outputFile);
	    } catch (IOException e) {
	    	System.out.println("Error with read and write buffers");
	        e.printStackTrace();

	    }
	}

	public static void main(String[] args) {
		 String inputFile = "in.txt";
		 String outputFile = "out.txt";
		 
		 capitalizeWordsFromFile(inputFile, outputFile);

	}

}
