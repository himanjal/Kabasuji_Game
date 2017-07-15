/*
 * 
 */
package model;

import java.awt.Color;

/**
 * The Class RSet.
 */
public class RSet {
	
	/** The color. */
	protected Color color;
	
	/** The i. */
	protected int i;
	
	/** The is r set. */
	protected boolean isRSet;
	
	/**
	 * Instantiates a new r set.
	 *
	 * @param c
	 *            the c
	 * @param j
	 *            the j
	 */
	public RSet(Color c, int j){
		color = c;
		i = j;
		isRSet = false;
	}
	
	/**
	 * Instantiates a new r set.
	 *
	 * @param c
	 *            the c
	 * @param j
	 *            the j
	 * @param t
	 *            the t
	 */
	public RSet(Color c, int j, boolean t){
		color = c;
		i = j;
		isRSet = t;
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
	

}
