/*
 * 
 */
package Kabasuji;

import java.io.IOException;

import model.Model;
import model.PlaySplash;
import model.ReadWithScanner;

/**
 * The Class Main.
 */
public class Main {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Model model = new Model();
		
		//read in from the data file to load saved information
		ReadWithScanner parser = new ReadWithScanner("src/Data.txt", model);
		try {
			//go line by line
			model = parser.processLineByLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		new PlaySplash(model);
	}
}
