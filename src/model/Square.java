/*
 * 
 */
package model;

import java.awt.Color;
import java.awt.Rectangle;

import Kabasuji.PieceType;

/**
 * @author Jetro
 *
 */
public class Square extends Rectangle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/** The color. */
	Color color;
	
	/** The type. */
	PieceType type;
	
	/** The set number. */
	int setNumber;
	
	/** The visible. */
	boolean visible;
	
	/** The taken. */
	private boolean taken;
	
	/** The p. */
	Piece p;
	
	/** The b. */
	Board b;
	
	/** The pixel length. */
	int pixelLength = 32;
	
	/** The rs. */
	RSet rs;  
	
	/** The hint. */
	boolean hint = false;
	
	/**
	 * @param row
	 * @param col
	 */
	public Square(int row, int col){// Color color, PieceType type, int setNumber, boolean visible){
		this.row = row;
		this.col = col;
	}
	
	/**
	 * @param row
	 * @param col
	 * @param type
	 * @param visible
	 * @param taken
	 */
	
	public Square(int row, int col, Piece p, boolean visible, Color c){
		this.row = row;
		this.col = col;
		this.p = p;
		this.visible = visible;
		this.color = c;
		this.rs = new RSet(p.getC(), row + col);
	}
	
	/**
	 * Instantiates a new square.
	 *
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param type
	 *            the type
	 * @param visible
	 *            the visible
	 * @param taken
	 *            the taken
	 */
	public Square(int row, int col, PieceType type, boolean visible, boolean taken){
		this.row = row;
		this.col = col;
		this.type = type;
		this.visible = visible;
		this.setTaken(taken);
	}
	
	/**
	 * Instantiates a new square.
	 *
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param b
	 *            the b
	 * @param visible
	 *            the visible
	 * @param taken
	 *            the taken
	 */
	public Square(int row, int col, Board b, boolean visible, boolean taken){
		this.row = row;
		this.col = col;
		this.visible = visible;
		this.setTaken(taken);
		this.b = b;
		
	}
	
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public int getCol(){
		return this.col;
	}
	
	/**
	 * Update row.
	 *
	 * @param newRow
	 *            the new row
	 */
	public void updateRow(int newRow){
		this.row = newRow;
	}
	
	/**
	 * Update col.
	 *
	 * @param newCol
	 *            the new col
	 */
	public void updateCol(int newCol){
		this.col = newCol;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Sets the color.
	 *
	 * @param c
	 *            the new color
	 */
	public void setColor(Color c){
		this.color = c;
	}
	
	
	/**
	 * @param snapRow
	 * @param snapCol
	 */
	public void snap(int snapRow, int snapCol){
		return;
	}
	
	/**
	 * @return
	 */
	public boolean isCovered(){
		return false;
	}
	
	/**
	 * @return
	 */
	public boolean isVisible(){return visible;}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength(){
		return this.pixelLength;
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
	
	/**
	 * Sets the visible.
	 *
	 * @param b
	 *            the new visible
	 */
	public void setVisible(boolean b){
		this.visible = b;
	}
	
	/**
	 * Rotate around origin
	 * 
	 */
	public void rotateAroundOrigin(){
		int x = this.row;
		int y = this.col;
		this.row = -y;
		this.col = x;
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y){
		this.row = x;
		this.col = y;
	}
	
	/**
	 * @param i
	 */
	public void rotateBefore(int i){
		this.row += i;
		this.col += i;
	}
	
	/**
	 * Rotate after.
	 *
	 * @param i
	 *            the i
	 */
	public void rotateAfter(int i){
		this.row += (i- 1);
		this.col += i;
	}
	
	/**
	 * Flip after.
	 *
	 * @param i
	 *            the i
	 */
	public void flipAfter(int i){
		this.row += i;
		this.col += (i - 1);
	}
	
	/**
	 * 
	 */
	public void flipXHelper(){
		this.row = -this.row;
	}
	
	/**
	 * 
	 */
	public void flipYHelper(){
		this.col = -this.col;
	}
	
	/**
	 * Gets the piece.
	 *
	 * @return the piece
	 */
	public Piece getPiece(){
		return p;
	}
	
	/**
	 * Sets the piece.
	 *
	 * @param p
	 *            the new piece
	 */
	public void setPiece(Piece p){
		this.p = p;
	}
	
	/**
	 * Gets the rs.
	 *
	 * @return the rs
	 */
	public RSet getRS(){
		return rs;
	}
	
	/**
	 * Sets the rs.
	 *
	 * @param rs
	 *            the new rs
	 */
	public void setRS(RSet rs){
		this.rs = rs;
	}
	
	/**
	 * Gets the hint.
	 *
	 * @return the hint
	 */
	public boolean getHint(){
		return hint;
	}
	
	/**
	 * Sets the hint.
	 *
	 * @param h
	 *            the new hint
	 */
	public void setHint(boolean h){
		this.hint = h;
	}
	

}
