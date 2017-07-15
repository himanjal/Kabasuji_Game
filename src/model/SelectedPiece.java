/*
 * 
 */
package model;

/**
 * The Class SelectedPiece.
 */
public class SelectedPiece {
	
	/** The p. */
	Piece p;
	
	/**
	 * Sets the selected piece.
	 *
	 * @param p
	 *            the new selected piece
	 */
	public void setselectedPiece(Piece p){
		this.p = p;
	}
	
	/**
	 * Gets the selected piece.
	 *
	 * @return the selected piece
	 */
	public Piece getSelectedPiece(){
		return p;
	}
}
