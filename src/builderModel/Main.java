/*
 * 
 */
package builderModel;

import java.io.IOException;

import builderModel.LBReadWithScanner;

/**
 * The Class Main.
 */
public class Main {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		LBModel model = new LBModel();
		
		//read in from the data file to load saved information
		LBReadWithScanner parser = new LBReadWithScanner("src/Data.txt", model);
		try {
			//go line by line
			model = parser.processLineByLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BuildSplash(model);
	}
}