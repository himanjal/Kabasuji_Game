/*
 * 
 */

package builderModel;

import java.awt.Color;

/**
 * The Class BuilderRSet.
 */
public class BuilderRSet {
	
	/** The color. */
	protected Color color;
	
	/** The i. */
	protected int i;
	
	/** The is r set. */
	protected boolean isRSet;
	
	/** The taken. */
	private boolean taken;
	
	/**
	 * Instantiates a new builder r set.
	 *
	 * @param c
	 *            the c
	 * @param j
	 *            the j
	 */
	public BuilderRSet(Color c, int j){
		color = c;
		i = j;
		isRSet = false;
	}
	
	/**
	 * Instantiates a new builder r set.
	 *
	 * @param c
	 *            the c
	 * @param j
	 *            the j
	 * @param t
	 *            the t
	 * @param taken
	 *            the taken
	 */
	public BuilderRSet(Color c, int j, boolean t, boolean taken){
		color = c;
		i = j;
		isRSet = t;
		this.setTaken(taken);
	}
	
	/**
	 * Gets the RS color.
	 *
	 * @return the RS color
	 */
	public Color getRSColor(){
		return color;
	}
	
	/**
	 * Gets the RS int.
	 *
	 * @return the RS int
	 */
	public int getRSInt(){
		return i;
	}
	
	/**
	 * Gets the r set visible.
	 *
	 * @return the r set visible
	 */
	public boolean getRSetVisible(){
		return isRSet;
	}

	/**
	 * Checks if is taken.
	 *
	 * @return true, if is taken
	 */
	public boolean isTaken() {
		return taken;
	}

	/**
	 * Sets the taken.
	 *
	 * @param taken
	 *            the new taken
	 */
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	

}
