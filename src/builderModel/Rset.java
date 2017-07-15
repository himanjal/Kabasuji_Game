/*
 * 
 */
package builderModel;

import java.awt.Color;

/**
 * The Class Rset.
 */
public class Rset {

	/** The rset. */
	Square[][] rset;
	
	/** The c. */
	Color c;
	
	/**
	 * Instantiates a new rset.
	 */
	public Rset(){
		rset = new Square[3][6];
		
		for(int i=0; i<3;i++){
			for(int j=0; j<6; j++){
				if(i==0) c = Color.RED;
				if(i==1) c = Color.CYAN;
				if(i==2) c = Color.GREEN;
				rset[i][j] = new Square(i,j);
				rset[i][j].setRS(new BuilderRSet(c, j, true, false));
			}
		}
	}
	
	/**
	 * Gets the rset.
	 *
	 * @return the rset
	 */
	public Square[][] getRset(){
		return rset;
	}
	
}
