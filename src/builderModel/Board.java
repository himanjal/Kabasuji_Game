/*
 * 
 */
package builderModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import builderController.BullpenController;
import builderModel.PieceFactory;
import builderModel.PieceType;
import builderModel.Bullpen;
import builderModel.Piece;
import builderModel.Square;
import builderView.BullpenView;
import builderModel.BuilderRSet;

/**
 * @author Himanjal
 *
 */
public class Board {

	
	/** The red. */
	ArrayList<Square> red = new ArrayList<Square>();
	
	/** The blue. */
	ArrayList<Square> blue = new ArrayList<Square>();
	
	/** The green. */
	ArrayList<Square> green = new ArrayList<Square>();
	
	/** The Constant SIZE. */
	public static final int SIZE = 12;

	/** The board. */
	private Square[][] board = new Square[12][12];
	
	/** The pieces. */
	ArrayList<Piece> pieces = new ArrayList<Piece>();

	/** The bp. */
	private Bullpen bp;
	
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
	
	/** The counter. */
	private int counter =0;
	
	/**
	 * Instantiates a new board.
	 */
	public Board(){
		int i,j;
		this.setBp(new Bullpen());
		for (i = 0; i < 12; i++){
			for (j = 0; j < 12; j++){
				board[i][j] = new Square(i, j, this, true, false);
				if((i+j)%2 ==0){
					board[i][j].setColor(Color.DARK_GRAY);
				}
				else board[i][j].setColor(Color.lightGray);
			}
		}
	}
	
	
	/**
	 * Instantiates a new board.
	 */
	public Board(Square[][] squares, Bullpen bp, PieceType type){
		this.setBp(bp);
		
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				this.board[i][j] = squares[i][j];
				this.board[i][j].p =  new PieceFactory().makePiece(100);
				if(!board[i][j].isVisible()){
					board[i][j].setColor(new Color(255, 250, 205));
				}
				else if((i+j)%2 ==0){
					board[i][j].setColor(Color.DARK_GRAY);
				}
				else board[i][j].setColor(Color.lightGray);
			}
		}
		
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
			p.XLocation= col;
			p.YLocation = row;
			pieces.add(p);
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
		
	}
	
	/**
	 * Put piece on board.
	 *
	 * @param piece
	 *            the p
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 * @return true, if successful
	 */
	public boolean putPieceOnBoardLB(builderModel.Piece piece, int col, int row){
		int index = 2;
		col--;
		row--;
		if(isValid(piece,col,row)){
			for(int i=0; i<6;i++){
				
				int pcol = piece.getSquareList().get(i).getRow();
				int prow = piece.getSquareList().get(i).getCol();
				ColorBoard((col+(pcol-index)),(row+(prow-index)), piece);
			}
			piece.XLocation = col;
			piece.YLocation = row;
			pieces.add(piece);
			
			List<Square> sq = piece.getSquareList();
			for (Square s: sq){
				s.rs = new BuilderRSet(s.getColor(), s.getCol() + s.getRow());
			}
			setMoves(getMoves() - 1);
			return true;
		}
		
		return false;
	}

	/**
	 * To txt.
	 *
	 * @param type
	 *            the type
	 * @return the string
	 */
	public String toTxt(PieceType type){
		String love = "";
		if(type.equals(PieceType.RELEASE)){
			for(int j=0; j<12; j++){
				for(int i=0; i<12; i++){
					Integer x = 0;
					
					if(board[i][j].getRS() == null){
						if(board[i][j].getHint()){
							love = love + "2";
						}
						else if(board[i][j].isTaken()==true){
							love = love + "1";
						}
						else if(board[i][j].isTaken()==false){
							love = love + "0";
						}
					}
					else if(board[i][j].rs.getRSColor().equals(Color.RED)){
						x = 10+board[i][j].rs.getRSInt();
						love = love + x.toString();
					}
					else if(board[i][j].rs.getRSColor().equals(Color.CYAN)){
						x = 20+board[i][j].rs.getRSInt();
						love = love + x.toString();
					}
					else if(board[i][j].rs.getRSColor().equals(Color.GREEN)){
						x = 30+board[i][j].rs.getRSInt();
						love = love + x.toString();			
					}
					if((i==11) && (j==11)){
					}else love = love + ",";
				}
			}
		}
		else{
			for(int j=0; j<12; j++){
				for(int i=0; i<12; i++){
					if(board[i][j].getHint()){
						love = love + "2";
					}
					else if(board[i][j].isTaken()==true){
						love = love + "1";
					}
					else if(board[i][j].isTaken()==false){
						love = love + "0";
					}
					if((i==11) && (j==11)){
					}else love = love + ",";
				}  
			}
		}
		return love;
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
	 * Clear board.
	 */
	public void clearBoard(){
		int i, j;
		
		for (i = 0; i < 12; i++){
			for(j = 0; j < 12; j++){
				board[i][j].visible = true;
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
	
	/**
	 * Gets the bpc.
	 *
	 * @return the bpc
	 */
	public BullpenController getBpc(){
		return bpc;
	}

	/**
	 * Sets the bpc.
	 *
	 * @param bullpenController
	 *            the new bpc
	 */
	public void setBpc(BullpenController bullpenController) {
		this.bpc = bullpenController;
	}


	/**
	 * Copy.
	 *
	 * @return the board
	 */
	public Board copy() {
		Board copy = new Board(board, bp, pt);
		copy.pieces = pieces;
		copy.selectedPiece = selectedPiece;
		copy.bpc = bpc;
		copy.moves = moves;
		copy.completed = completed;
		copy.counter = counter;
		
		return copy;
	}
}