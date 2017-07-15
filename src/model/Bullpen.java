/*
 * 
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Kabasuji.PieceFactory;

/**
 * @author xavier & Himanjal
 *
 */
public class Bullpen {
	
	/** The pieces. */
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	/** The original pieces. */
	ArrayList<Piece> originalPieces = new ArrayList<Piece>();
	
	/** The piece factory. */
	PieceFactory pieceFactory = new PieceFactory();
	
	/** The selected piece. */
	Piece selectedPiece = pieceFactory.makePiece(100);
	
	/** The counter. */
	private int counter =0;
	
	//bullpen constructor
	/**
	 * @param pieces
	 */
	
	
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces.addAll(pieces);
	}
	
	/**
	 * Instantiates a new bullpen.
	 */
	//default constructor
	public Bullpen(){
		int i;
		for (i = 1; i < 36; i++){
			pieces.add(pieceFactory.makePiece(i));
		}
	}
	
	

	
	/**
	 * Adds a piece to he bullpen
	 * @param piece the piece to add
	 */
	public void addPiece(Piece p, int i){
		
		
			pieces.add(p);
			
			System.out.println(pieces.size());
			
	}
	
	/**
	 * Adds the random piece.
	 *
	 * @param numOfPieces
	 *            the num of pieces
	 */
	public void addRandomPiece(int numOfPieces){
		if(numOfPieces<0){
			throw new RuntimeException("Cannot add negative number of piece");
		}
		for(int i=0; i<numOfPieces; i++){
			this.pieces.add(pieceFactory.makePiece(new Random().nextInt(35)+1));
		}
	}
	
	/**
	 * Removes the given piece from the bullpen, if present.
	 * @param piece the piece to remove.
	 * @return true if piece was found and removed, false otherwise.
	 */
	public boolean removePiece(int ID){
		for(int i=0;i<this.pieces.size(); i++){

			if(this.pieces.get(i).getId() == ID ){
				originalPieces.add(this.pieces.remove(i));
				
				
				return true;

			}
		}
		return false;
	}
	
	/**
	 * @return
	 */
	public int numOfPiecesAvailable(){
		int count = 0;
		for(int i=0; i<this.pieces.size(); i++){
			count++;
		}
		return count;
	}
	
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		return this.pieces.size() == 0;
	}
	
	
	/**
	 * Gets the selected piece.
	 *
	 * @return the selected piece
	 */
	public Piece getSelectedPiece(){
		return selectedPiece;
	}
	
	/**
	 * Sets the selected piece.
	 *
	 * @param ID
	 *            the id
	 * @return true, if successful
	 */
	public boolean setSelectedPiece(int ID){
		if(selectedPiece != null){
			for(int i=0; i< this.pieces.size(); i++){
				if(selectedPiece.getId() == pieces.get(i).getId()){
					pieces.get(i).setC(pieces.get(i).getBackupColor());
				}
			}
		}
		
		if(ID == 100){
			selectedPiece = pieceFactory.makePiece(100);
			return true;
		}
		
		this.selectedPiece = this.pieces.get(ID);
		this.pieces.get(ID).setC(Color.RED);
		
		

//		return false;
		return true;
	}
	
		/**
		 * Same piece clicked.
		 *
		 * @param n
		 *            the n
		 * @return true, if successful
		 */
		public boolean samePieceClicked(int n){
			if((pieces.get(n) == selectedPiece) && (getSelectedPiece().getId() != 100)){
				return true;
			}
		
		
		
		return false;
	}
	
	/**
	 * Clear selected piece.
	 */
	public void clearSelectedPiece(){
		this.selectedPiece = null;
	}
	
	
	/**
	 * 
	 */
	public void resetBullpen(){
		pieces.addAll(originalPieces);
		originalPieces.clear();
	}
	
	/**
	 * Clear bullpen.
	 */
	public void clearBullpen(){
		pieces.clear();
	}

	/**
	 * Rotate.
	 *
	 * @param i
	 *            the i
	 */
	public void rotate(int i){
		pieces.get(i).rotatePiece();
	}
	
	/**
	 * Flip x.
	 *
	 * @param i
	 *            the i
	 */
	public void flipX(int i){
		pieces.get(i).flipPieceX();
	}
	
	/**
	 * Flip y.
	 *
	 * @param i
	 *            the i
	 */
	public void flipY(int i){
		pieces.get(i).flipPieceY();
	}
	
	/**
	 * Gets the piece.
	 *
	 * @param i
	 *            the i
	 * @return the piece
	 */
	public Piece getPiece(int i){
		return pieces.get(i);
	}
	/**
	 * @return
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}

	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 *
	 * @param counter
	 *            the new counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

}
