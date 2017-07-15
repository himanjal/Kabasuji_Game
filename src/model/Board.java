/*
 * 
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Controller.BullpenController;
import Kabasuji.PieceFactory;
import Kabasuji.PieceType;
import view.BullpenView;
import view.LevelView;

/**
 * @author Himanjal
 *
 */
public class Board {

	/** The Constant SIZE. */
	public static final int SIZE = 12;
	
	/** The red. */
	ArrayList<Square> red = new ArrayList<Square>();
	
	/** The blue. */
	ArrayList<Square> blue = new ArrayList<Square>();
	
	/** The green. */
	ArrayList<Square> green = new ArrayList<Square>();

	/** The board. */
	private Square[][] board = new Square[12][12];
	
	/** The pieces. */
	ArrayList<Piece> pieces = new ArrayList<Piece>();

	/** The bp. */
	private Bullpen bp;
	
	/** The num visible squares. */
	private Integer numVisibleSquares;

	/** The selected piece. */
	Piece selectedPiece = new PieceFactory().makePiece(100);
	
	/** The pt. */
	private PieceType pt;
	
	/** The bpc. */
	BullpenController bpc = new BullpenController(bp, new BullpenView());
	
	/** The moves. */
	private int moves = 0;
	
	/** The completed. */
	private boolean completed;
	
	/** The lvl view. */
	private LevelView lvlView;
	
	/** The counter. */
	private int counter =0;
	
	/**
	 * Instantiates a new board.
	 */
	public Board(Square[][] squares, PieceType type){
		
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				this.board[i][j] = squares[i][j];
				this.board[i][j].p =  new PieceFactory().makePiece(100);
				
				if(board[i][j].rs != null){
					if(board[i][j].rs.color.equals(Color.RED))
						red.add(board[i][j]);
					if(board[i][j].rs.color.equals(Color.BLUE))
						blue.add(board[i][j]);
					if(board[i][j].rs.color.equals(Color.GREEN))
						green.add(board[i][j]);
				}
				
				if(!board[i][j].isVisible()){
					board[i][j].setColor(new Color(255, 250, 205));
				}
				else if((i+j)%2 ==0){
					board[i][j].setColor(Color.DARK_GRAY);
				}
				else board[i][j].setColor(Color.lightGray);
			}
		}
		this.setCompleted(false);
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param p
	 *            the p
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 * @return true, if is valid
	 */
	public boolean isValid(Piece p, int col, int row){
		int index =2;
		int count = 0;
		for(int i=0; i<6;i++){
			int pcol = p.getSquareList().get(i).getRow();
			int prow = p.getSquareList().get(i).getCol();
			if(col+(pcol-index)>=0 && col+(pcol-index) <12){
				if(row+(prow-index)>=0 && row+(prow-index)<12){
					if((!board[col+(pcol-index)][row+(prow-index)].isTaken()) || (this.pt == PieceType.LIGHTNING)){
						if(board[col+(pcol-index)][row+(prow-index)].isVisible()){
							count++;
						}
					}
				}
			}
		}
		if(count == 6){
			return true;
		}
		
		return false;
	}
	

	/**
	 * Put piece on board.
	 *
	 * @param p
	 *            the p
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 * @return true, if successful
	 */
	public boolean putPieceOnBoard(Piece p, int col, int row){
		int index = 2;
		col--;
		row--;
		if(isValid(p,col,row)){
			for(int i=0; i<6;i++){
				
				int pcol = p.getSquareList().get(i).getRow();
				int prow = p.getSquareList().get(i).getCol();
				ColorBoard((col+(pcol-index)),(row+(prow-index)), p);
			}
			p.XLocation = col;
			p.YLocation = row;
			pieces.add(p);
			
			List<Square> sq = p.getSquareList();
			for (Square s: sq){
				s.rs = new RSet(s.getColor(), s.getCol() + s.getRow());
			}
			setMoves(getMoves() + 1);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Color board.
	 *
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 */
	public void ColorBoard(int col, int row){
		board[col][row].setTaken(false);
		
		if((col+row)%2 == 0){
			board[col][row].setColor(Color.DARK_GRAY);
		}
		else board[col][row].setColor(Color.lightGray);
	}
	
	/**
	 * Color board.
	 *
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 * @param Color
	 *            the Color
	 */
	public void ColorBoard(int col, int row, Piece p){
		board[col][row].setTaken(true);
		board[col][row].setColor(p.getC());
		board[col][row].p = p;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Square[][] getBoard() {
		return board;
	}
	

	/**
	 * Sets the board.
	 *
	 * @param board
	 *            the new board
	 */
	public void setBoard(Square[][] board) {
		this.board = board;
	}
	

	/**
	 * Removes the piece.
	 *
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 */
	public void removePiece(int row, int col){
		
		Piece p = board[row][col].p;
		for(int i=0; i<12; i++){
			for(int j=0; j<12; j++){
				if(board[i][j].p == p){
					if((board[i][j].p.XLocation == p.XLocation) && (board[i][j].p.YLocation == p.YLocation)){
						board[i][j].setTaken(false);
						board[i][j].p = new PieceFactory().makePiece(100);
						ColorBoard(i,j);
					}
				}
			}
		}

		selectedPiece = p;
		pieces.remove(p);
		//setMoves(getMoves() - 1);
		
	}
	

	/**
	 * Sets the selected piece.
	 *
	 * @param p
	 *            the new selected piece
	 */
	public void setSelectedPiece(Piece p){
		selectedPiece = p;
		
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
	 * Gets the bp.
	 *
	 * @return the bp
	 */
	public Bullpen getBp() {
		return bp;
	}


	/**
	 * Sets the bp.
	 *
	 * @param bp
	 *            the new bp
	 */
	public void setBp(Bullpen bp) {
		this.bp = bp;
	}

	/**
	 * Gets the pt.
	 *
	 * @return the pt
	 */
	public PieceType getPt() {
		return pt;
	}

	/**
	 * Sets the pt.
	 *
	 * @param pt
	 *            the new pt
	 */
	public void setPt(PieceType pt) {
		this.pt = pt;
	}
	
	/**
	 * Gets the num visible squares.
	 *
	 * @return the num visible squares
	 */
	public Integer getNumVisibleSquares() {
		return numVisibleSquares;
	}

	/**
	 * Sets the num visible squares.
	 *
	 * @param numVisibleSquares
	 *            the new num visible squares
	 */
	public void setNumVisibleSquares(Integer numVisibleSquares) {
		this.numVisibleSquares = numVisibleSquares;
	}
	
	/**
	 * Sets the bpc.
	 *
	 * @param bpc
	 *            the new bpc
	 */
	public void setBpc(BullpenController bpc){
		this.bpc =bpc;
		this.bp = this.bpc.getBp();
	}
	
	/**
	 * Gets the bpc.
	 *
	 * @return the bpc
	 */
	public BullpenController getBpc(){
		return bpc;
	}
	
	/**
	 * Gets the pieces.
	 *
	 * @return the pieces
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}

	/**
	 * Gets the moves.
	 *
	 * @return the moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Sets the moves.
	 *
	 * @param moves
	 *            the new moves
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}

	/**
	 * Checks if is completed.
	 *
	 * @return true, if is completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Sets the completed.
	 *
	 * @param completed
	 *            the new completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	/**
	 * Gets the completed.
	 *
	 * @return the completed
	 */
	public boolean getCompleted() {
		return this.completed;
	}

	/**
	 * Gets the lvl view.
	 *
	 * @return the lvl view
	 */
	public LevelView getLvlView() {
		return lvlView;
	}

	/**
	 * Sets the lvl view.
	 *
	 * @param lvlView
	 *            the new lvl view
	 */
	public void setLvlView(LevelView lvlView) {
		this.lvlView = lvlView;
	}
	
	/**
	 * Clear board.
	 */
	public void clearBoard(){
		int i, j;
		
		for (i = 0; i < 12; i++){
			for(j = 0; j < 12; j++){
				board[i][j].setPiece(new PieceFactory().makePiece(100));
				board[i][j].setTaken(false);
				if((i+j)%2 ==0){
					board[i][j].setColor(Color.DARK_GRAY);
				}
				else 
					board[i][j].setColor(Color.lightGray);
			
			}
		}
		
		moves = 0;
	}
	
	/**
	 * Gets the num squares rem.
	 *
	 * @return the num squares rem
	 */
	public int getNumSquaresRem(){
		int count =0;
		for(int i =0; i< SIZE; i++){
			for(int j=0; j< SIZE; j++){
				if(!board[i][j].isTaken() && board[i][j].visible){
					count++;
				}
			}
		}
		return count;
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
	
	/**
	 * Gets the red got.
	 *
	 * @return the red got
	 */
	public String getRedGot(){
		String redGot = "";
		for(Square s: red){
			if(s.isTaken())
				redGot = redGot + s.rs.i + ", ";
		}
		
		return redGot;
	}
	
	/**
	 * Gets the blue got.
	 *
	 * @return the blue got
	 */
	public String getBlueGot(){
		String blueGot = "";
		for(Square s: blue){
			if(s.isTaken())
				blueGot = blueGot + s.rs.i + ", ";
		}
		
		return blueGot;
	}
	
	/**
	 * Gets the green got.
	 *
	 * @return the green got
	 */
	public String getGreenGot(){
		String greenGot = "";
		for(Square s: green){
			if(s.isTaken())
				greenGot = greenGot + s.rs.i + ", ";
		}
		
		return greenGot;
	}
}


