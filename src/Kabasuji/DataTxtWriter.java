/*
 * 
 */
package Kabasuji;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jetro
 *
 */
public class DataTxtWriter {

	/**
	 * @param aFileName
	 */
	public DataTxtWriter(String aFileName){
		fFilePath = aFileName;
	}
	
	/**
	 * @param newValue
	 * @throws IOException
	 */
	public void txtAdd(String newValue) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(fFilePath));
        String line;String input = "";

        while ((line = file.readLine()) != null) input += line + '\n';
        file.close();
        input = input + '\n'+ newValue;
        
        FileOutputStream fileOut = new FileOutputStream(fFilePath);
        fileOut.write(input.getBytes());
        fileOut.close();
	}
	
	/**
	 * @param nameToFind
	 * @throws IOException
	 */
	public void txtDelete(String nameToFind) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(fFilePath));
        String line;String input = "";

        while ((line = file.readLine()) != null) input += line + '\n';
        file.close();
        input = input.replace(nameToFind, "");

        FileOutputStream fileOut = new FileOutputStream("src/Data.txt");
        fileOut.write(input.getBytes());
        fileOut.close();
	}
	
//	public static void main(String[] args) throws IOException{
//		DataTxtWriter dtw = new DataTxtWriter("src/Data.txt");
//		dtw.txtAdd("LLEVEL6 = ,10");
//	}
	
	/**
	 * @param nameToFind
	 * @param newValue
	 * @throws IOException
	 */
	public void txtReplace(String nameToFind, String newValue) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(fFilePath));
        String line;String input = "";

        while ((line = file.readLine()) != null) input += line + '\n';
        file.close();
        input = input.replace(nameToFind, newValue);
        
        FileOutputStream fileOut = new FileOutputStream(fFilePath);
        fileOut.write(input.getBytes());
        fileOut.close();
	}
	
	/**
	 * Txt replace line.
	 *
	 * @param nameToFind
	 *            the name to find
	 * @param newValue
	 *            the new value
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void txtReplaceLine(String nameToFind, String newValue) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(fFilePath));
        String line;String input = "";

        while ((line = file.readLine()) != null) {
        	if(line.startsWith(nameToFind)){
            	line = nameToFind + newValue;
            }
        	input += line + '\n';
        }
        file.close();
        
        FileOutputStream fileOut = new FileOutputStream(fFilePath);
        fileOut.write(input.getBytes());
        fileOut.close();
	}
	
	/** The file path. */
	private final String fFilePath;
}