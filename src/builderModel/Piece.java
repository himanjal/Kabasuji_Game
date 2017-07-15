/*
 * 
 */
package builderModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import builderModel.Square;

/**
 * @author Xavier
 *
 */
public class Piece {
	
	/** The square list. */
	private List<Square> squareList;
	
	/** The pixel length. */
	int centerX, centerY, pixelLength;
	
	/** The c. */
	private Color c;
	
	/** The backup color. */
	private Color backupColor;
	
	/** The id. */
	private int id;
	
	/** The is valid. */
	boolean isValid = false;
	
	/** The pieces. */
	boolean[][] pieces;
	
	/** The X location. */
	int XLocation=0;
	
	/** The Y location. */
	int YLocation=0;
	
	

	
	/**
	 * @param color
	 * @param pieces
	 * @param id
	 */
	public Piece(Color color, boolean[][] pieces, int id){
		this.pieces = pieces;
		this.setSquareList(new ArrayList<Square>());	   
		this.setC(color);
		this.id = id;
		this.centerX = 0;
		this.centerY = 0;
		this.pixelLength = 32;		
		this.setBackupColor(this.c);
		createSquares(pieces);

		
	}
	
	/**
	 * @param squares
	 * @throws Exception 
	 */
	private void createSquares(boolean[][] squares) {
		  int i, j;			
			
			for (i = 0; i < 6; i++){
				for (j = 0; j < 6; j++){
					if (squares[i][j]){
						getSquareList().add(new Square(i, j, this, true, this.c));
						if(getSquareList().size() != 6);
					}
				}
			}
		  
	  }
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean containsPoint(double x, double y) {
		
		  double x0;
		  double y0;
		  
		  for (Square s: getSquareList()){		

			
	        x0 = (pixelLength * s.getRow()) + centerX;
	        y0 = (pixelLength * s.getCol()) + centerY;
			        
	        if (x >= (x0 - 10) &&
	                y >= (y0 - 10) &&
	                x < x0 + s.getWidth() &&
	                y < y0 + s.getHeight()){
//	        	
	        	return true;
	        }
		  }
		  return false;
	}
	
	/**
	 * Gets the booleans.
	 *
	 * @return the booleans
	 */
	public boolean[][] getBooleans(){
		return pieces;
	}


	/**
	 * Rotate piece.
	 */
	public void rotatePiece(){

		for (Square s: getSquareList()){
			s.rotateBefore(-3);							
		}

		for (Square s: getSquareList()){
			s.rotateAroundOrigin();							
		}
		for (Square s: getSquareList()){
			s.rotateAfter(3);							
		}

	}
	
	/**
	 * Rotate piece.
	 */
	public void flipPieceX(){

		for (Square s: getSquareList()){
			s.rotateBefore(-3);							
		}

		for (Square s: getSquareList()){
			s.flipXHelper();							
		}
		for (Square s: getSquareList()){
			s.rotateAfter(3);							
		}

	}
	
	/**
	 * Rotate piece.
	 */
	public void flipPieceY(){

		for (Square s: getSquareList()){
			s.rotateBefore(-3);							
		}

		for (Square s: getSquareList()){
			s.flipYHelper();							
		}
		for (Square s: getSquareList()){
			s.rotateAfter(3);							
		}

	}
	
	/**
	 * Gets the center x.
	 *
	 * @return the center x
	 */
	public int getCenterX(){
		return this.centerX;
	}
	
	/**
	 * Gets the center y.
	 *
	 * @return the center y
	 */
	public int getCenterY(){
		return this.centerY;
	}
	
	/**
	 * Sets the center x.
	 *
	 * @param newCenterX
	 *            the new center x
	 */
	public void setCenterX(int newCenterX){
		this.centerX = newCenterX;
	}
	
	/**
	 * Sets the center y.
	 *
	 * @param newCenterY
	 *            the new center y
	 */
	public void setCenterY(int newCenterY){
		this.centerY = newCenterY;
	}
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public Color getC() {
		return c;
	}

	/**
	 * Sets the c.
	 *
	 * @param c
	 *            the new c
	 */
	public void setC(Color c) {
		this.c = c;
	}

	/**
	 * Gets the square list.
	 *
	 * @return the square list
	 */
	public List<Square> getSquareList() {
		return squareList;
	}

	/**
	 * Sets the square list.
	 *
	 * @param squareList
	 *            the new square list
	 */
	public void setSquareList(List<Square> squareList) {
		this.squareList = squareList;
	}

	/**
	 * Gets the backup color.
	 *
	 * @return the backup color
	 */
	public Color getBackupColor() {
		return backupColor;
	}

	/**
	 * Sets the backup color.
	 *
	 * @param backupColor
	 *            the new backup color
	 */
	public void setBackupColor(Color backupColor) {
		this.backupColor = backupColor;
	}

	/**
	 * Copy.
	 *
	 * @return the piece
	 */
	public Piece copy() {
		Piece copy = new Piece(c, pieces, id);
		copy.backupColor = backupColor;
		copy.isValid = isValid;
		return copy;
		
	}

}
