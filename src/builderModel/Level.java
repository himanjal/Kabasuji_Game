/*
 * 
 */
package builderModel;

import builderModel.PieceType;
import builderModel.Board;
import builderModel.Bullpen;

/**
 * @author Jetro
 *
 */
public class Level {
	
	/** The board. */
	//general Level attributes
	private Board board;
	
	/** The number. */
	int number;
	
	/** The bullpen. */
	private Bullpen bullpen;
	
	/** The current bullpen. */
	protected java.util.Stack<Bullpen> currentBullpens = new java.util.Stack<Bullpen>();
	/** The undone bullpen. */
	protected java.util.Stack<Bullpen> undoneBullpens = new java.util.Stack<Bullpen>();
	/** The current Boards. */
	protected java.util.Stack<Board> currentBoards = new java.util.Stack<Board>();
	/** The undone Boards. */
	protected java.util.Stack<Board> undoneBoards = new java.util.Stack<Board>();
	
	/** The star. */
	private int star;
	
	/** The type. */
	PieceType type;
	
	/** The unlocked. */
	private boolean unlocked;
	
	/** The counter. */
	//counter used for lightning and puzzle levels
	private int counter = 0;
	
	/** The cur count. */
	private int curCount = 0;
	
	/** The mode of the level builder - edit,create*/
	private String mode;
	
	//release sets for release levels
	
	/**
	 * Gets the mode.
	 *
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Sets the mode.
	 *
	 * @param mode
	 *            the new mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @param number
	 * @param type
	 * Constructor for Lightning and Puzzle type levels
	 */
	public Level(int number, PieceType type, Bullpen bullpen, int counter){
		this.number = number; 
		this.type = type;
		//this.setBoard(board);
		this.setBullpen(bullpen);
		/**
		 * Sends initial bullpen state as the first stack element
		 */
		//currentBullpens.push(bullpen);
		//currentBoards.push(board);
		setStars(0);
		
		this.setCounter(counter);
		setCurCount(0);
		
		/**
		 * if this is the first level it should be unlocked by default
		 */
		if(number == 1)
			unlocked = true;
		else
			unlocked = false;
	}
	
	/**
	 * @param number
	 * @param type
	 * Constructor for Release type levels
	 */
	public Level(int number, PieceType type, Bullpen bullpen){
		this.number = number; 
		this.type = type;
		//this.setBoard(board);
		this.setBullpen(bullpen);
		currentBullpens.push(bullpen);
		star = 0;
		
		/**
		 * if this is the first level it should be unlocked by default
		 */
		if(number == 1)
			unlocked = true;
		else
			unlocked = false;
	}
	
	/**
	 * @param stars
	 */
	public void setStars(int stars){
		star = stars;
	}
	
	/**
	 * @return
	 */
	public int getStars(){
		return star;
	}

	/**
	 * @return
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * @return
	 */
	public PieceType getType(){
		return type;
	}
	
	/**
	 * Gets the bullpen.
	 *
	 * @return the bullpen
	 */
	public Bullpen getBullpen () {
		if(this.bullpen.equals(null)){
			return new Bullpen();
		}
		return bullpen; 
	}
	
	/**
	 * @return
	 */
	public boolean isUnlocked(){return unlocked;}
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard(){return board;}

	/**
	 * Sets the unlocked.
	 *
	 * @param unlocked
	 *            the new unlocked
	 */
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	/**
	 * Sets the bullpen.
	 *
	 * @param bullpen
	 *            the new bullpen
	 */
	public void setBullpen(Bullpen bullpen) {
		this.bullpen = bullpen;
		
	}

	/**
	 * Sets the board.
	 *
	 * @param board
	 *            the new board
	 */
	public void setBoard(Board board) {
		this.board = board;
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
	 * Gets the cur count.
	 *
	 * @return the cur count
	 */
	public int getCurCount() {
		return curCount;
	}

	/**
	 * Sets the cur count.
	 *
	 * @param curCount
	 *            the new cur count
	 */
	public void setCurCount(int curCount) {
		this.curCount = curCount;
	}
	/**
	 * Undo & Redo for Bullpens
	 */
	
	/**
	 * Returns most recent Bullpen and removes it from list of currentBullpens.
	 * <p>
	 * If there are no currentBullpens present in this level, null is returned.
	 * <p>
	 * This method must be protected since only <code>undoBullpen()</code> should
	 * have access.
	 * <p>
	 * 
	 * @return the most recent Bullpen made in this levelBuilder level.
	 */
	protected Bullpen popCurrentBullpen() {
		/**
		 *  Return null if the stack of currentBullpens is empty.
		 */
		if (currentBullpens.isEmpty())
			return null;

		/**
		 *  pop most recent Bullpen.
		 */
		return currentBullpens.pop();
	}
	
	/**
	 * Returns most recent undone Bullpen and removes it from list of undoneBullpens.
	 * <p>
	 * If there are no undoneBullpens present in this level, null is returned.
	 * <p>
	 * This method must be protected since only <code>undoBullpen()</code> should
	 * have access.
	 * <p>
	 * 
	 * @return the most recent Bullpen undone in this levelBuilder level.
	 */
	protected Bullpen popUndoneBullpen() {
		/**
		 *  Return null if the stack of currentBullpens is empty.
		 */
		if (undoneBullpens.isEmpty())
			return null;

		/**
		 *  pop most recent undone Bullpen.
		 */
		

		return (Bullpen) undoneBullpens.pop();
	}
	
	/**
	 * Pushes given Bullpen onto our stack of existing currentBullpens.
	 * Since a new Bullpen has been made, all Bullpens that have been undone get removed
	 * 
	 * @return boolean
	 * @param m
	 *            A Bullpen object representing the most recent Bullpen made in the
	 *            levelBuilder level.
	 */
	public boolean pushCurrentBullpen(Bullpen m) {
		currentBullpens.push(m.copy());
		undoneBullpens.removeAllElements();
		return true;
	}
	
	/**
	 * Pushes given Bullpen onto our stack of existing undoneBullpens.
	 * 
	 * @return boolean
	 * @param m
	 *            A Bullpen object representing the most recent Bullpen undone in the
	 *            levelBuilder level.
	 */
	public boolean pushUndoneBullpen(Bullpen m) {
		undoneBullpens.push(m.copy());
		return true;
	}
	
	/**
	 * Level level stores all currentBullpens and enables them to be undone. Once a
	 * request to undo is received, this takes care of it.
	 * 
	 * @return boolean true means the Bullpen was successfully undone; false
	 *         otherwise.
	 */
	
	public Bullpen undoBullpen() {
		Bullpen m = popCurrentBullpen();
		/**
		 *  unable to undo
		 */
		if (m == null) {
			return bullpen;
		}
			boolean status = true;
		
		/**
		 *  Undo and refresh all widgets.
		 */
		if (status) {
			pushUndoneBullpen(m.copy());
		} else {
			/**
			 *  if we can't undo the Bullpen, we push it back onto the current stack
			 */
			pushCurrentBullpen(m); 
		}
		
		/**
		 *  return results.
		 */
		setBullpen(currentBullpens.peek());
		return currentBullpens.peek();
	}
	
	/**
	 * Redo Bullpen.
	 *
	 * @return true, if successful
	 */
	public Bullpen redoBullpen(){
		 Bullpen m = popUndoneBullpen();
		 
		 /**
		  *  no undone moves, can't redo
		  */
		 if (m == null){
			 return bullpen;
		 }
		 boolean status = true;
		 
		 /**
		  *  push Bullpen back onto top of currentBullpens stack
		  */
		 if (status){
			 pushCurrentBullpen(m.copy());
			 
		 } 
		 	/**
			 *  if we can't redo the Bullpen, we push it back onto the undone stack
			 */
			else{
			 pushUndoneBullpen(m.copy());
		 }
		 
		 setBullpen(currentBullpens.peek());
		 return currentBullpens.peek();
	}
	

	
	/**
	 * Undo & Redo for Boards
	 */
	/**
	 * Returns most recent Board and removes it from list of currentBoards.
	 * <p>
	 * If there are no currentBoards present in this level, null is returned.
	 * <p>
	 * This method must be protected since only <code>undoBoard()</code> should
	 * have access.
	 * <p>
	 * 
	 * @return the most recent Board made in this levelBuilder level.
	 */
	protected Board popCurrentBoard() {
		/**
		 *  Return null if the stack of currentBoards is empty.
		 */
		if (currentBoards.isEmpty())
			return board;
	
		/**
		 *  pop most recent current Board.
		 */
		return (Board)currentBoards.pop();
	}
	/**
	 * Returns most recent undone Board and removes it from list of undoneBoards.
	 * <p>
	 * If there are no undoneBoards present in this level, null is returned.
	 * <p>
	 * This method must be protected since only <code>undoBoard()</code> should
	 * have access.
	 * <p>
	 * 
	 * @return the most recent Board undone in this levelBuilder level.
	 */
	protected Board popUndoneBoard() {
		/**
		 *  Return null if the stack of currentBoards is empty.
		 */
		if (undoneBoards.isEmpty())
			return board;
	
		/**
		 *  pop most recent undone Board.
		 */
		return (Board) undoneBoards.pop();
	}
	/**
	 * Pushes given Board onto our stack of existing currentBoards.
	 * Since a new Board has been made, all Boards that have been undone get removed
	 * 
	 * @return boolean
	 * @param m
	 *            A Board object representing the most recent Board made in the
	 *            levelBuilder level.
	 */
	public boolean pushCurrentBoard(Board m) {
		currentBoards.push(m.copy());
		undoneBoards.removeAllElements();
		return true;
	}
	
	/**
	 * Pushes given Board onto our stack of existing undoneMoves.
	 * 
	 * @return boolean
	 * @param m
	 *            A Board object representing the most recent Board undone in the
	 *            levelBuilder level.
	 */
	public boolean pushUndoneBoard(Board m) {
		undoneBoards.push(m.copy());
		return true;
	}
	
	/**
	 * Level level stores all currentBoards and enables them to be undone. Once a
	 * request to undo is received, this takes care of it.
	 * 
	 * @return boolean true means the Board was successfully undone; false
	 *         otherwise.
	 */
	
	public Board undoBoard() {
		Board m = popCurrentBoard();
		/**
		 *  unable to undo Board
		 */
		if (m == null) {
			return board;
		}
	
		/**
		 *  Undo and refresh all widgets.
		 */
		boolean status = true;
		if (status) {
			pushUndoneBoard(m);
		} else {
			/**
			 *  if we can't undo the Board, we push it back onto the stack of current Boards
			 */
			pushCurrentBoard(m);
		}
		setBoard(currentBoards.peek());
		/**
		 *  return results.
		 */
		return currentBoards.peek();
	}
	
	/**
	 * Redo move.
	 *
	 * @return true, if successful
	 */
	public Board redoBoard(){
		 Board m = popUndoneBoard();
		 
		 /**
		  *  no undone Boards, can't redo
		  */
		 if (m == null){
			 return board;
		 }
		 
		 /**
		  * redo and refresh widgets
		  */
		 boolean status = true;
		 
		 /**
		  *  push Board back onto top of currentBoards stack
		  */
		 if (status){
			 pushCurrentBoard(m.copy() );
		 } 
		 /**
		 *  if we can't redo the Board, we push it back onto the undone stack
		 */
		 else{
			 pushUndoneBoard(m.copy());
		 }
		 
		 setBoard(currentBoards.peek());
		 return currentBoards.peek();
		 }
	
}
