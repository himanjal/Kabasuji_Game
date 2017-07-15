/*
 * 
 */
package model;

import java.io.IOException;

import Kabasuji.DataTxtWriter;
import Kabasuji.PieceType;

/**
 * @author Jetro
 *
 */
public class Level  {

	/** The board. */
	//general Level attributes
	private Board board;

	/** The number. */
	int number;

	/** The bullpen. */
	private Bullpen bullpen;

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

	//release sets for release levels

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
		setStars(0);

		this.setCounter(counter);
		setCurCount(0);

		//if this is the first level it should be unlocked by default
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
		this.setBoard(board);
		this.setBullpen(bullpen);
		star = 0;
		//this.board.moves = this.curCount;
		//if this is the first level it should be unlocked by default
		if(number == 1)
			unlocked = true;
		else
			unlocked = false;
	}

	/**
	 * Check badges unlocked.
	 *
	 * @param model
	 *            the model
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	//check for badges unlocked
	public void checkBadgesUnlocked(Model model) throws IOException{
		DataTxtWriter dWriter = new DataTxtWriter("src/Data.txt");
		if(type == PieceType.LIGHTNING && curCount<=35){
			model.badges[0].setAchieved(true);
			dWriter.txtReplaceLine("BADGE1 = ", "1");
		}
		if(type == PieceType.LIGHTNING && (board.getNumVisibleSquares()/6+1) >= curCount){
			model.badges[1].setAchieved(true);
			dWriter.txtReplaceLine("BADGE2 = ", "1");
		}
		if(type == PieceType.LIGHTNING && curCount<=25){
			model.badges[2].setAchieved(true);
			dWriter.txtReplaceLine("BADGE3 = ", "1");
		}
		if(type == PieceType.PUZZLE && counter-curCount == 1){
			model.badges[3].setAchieved(true);
			dWriter.txtReplaceLine("BADGE4 = ", "1");
		}
		if(type == PieceType.PUZZLE && counter-curCount == 2){
			model.badges[4].setAchieved(true);
			dWriter.txtReplaceLine("BADGE5 = ", "1");
		}
		//		if(type == PieceType.PUZZLE && getBullpen().hasRotated()){
		//			model.badges[5].setAchieved(true);
//					dWriter.txtReplaceLine("BADGE6 = ", "1");
		//		}
		//		if(type == PieceType.PUZZLE && model.successPuzzleCounter().equals(3)){
		//			model.badges[6].setAchieved(true);
//					dWriter.txtReplaceLine("BADGE7 = ", "1");
		//		}
		//		if(type == PieceType.RELEASE && board.isAnyPieceNotCoveringAnyRSet()){
		//			model.badges[7].setAchieved(true);
//					dWriter.txtReplaceLine("BADGE8 = ", "1");
		//		}
		//		if(type == PieceType.RELEASE && board.coveredTwoRSets()){
		//			model.badges[8].setAchieved(true);
//					dWriter.txtReplaceLine("BADGE9 = ", "1");
		//		}
				if(type == PieceType.RELEASE && number ==5){
					model.badges[9].setAchieved(true);
					dWriter.txtReplaceLine("BADGE10 = ", "1");
				}
	}
	/**
	 * @param starsWon
	 */
	public void completeLevel(Model model){
		int starsWon = 0;

		//badges logic
		try {
			checkBadgesUnlocked(model);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//star logic
		if(type == PieceType.LIGHTNING || type == PieceType.PUZZLE){
			if(board.getNumSquaresRem() == 0){
				starsWon = 3;
			}
			else if(board.getNumSquaresRem() <= 6){
				starsWon = 2;
			}
			else if(board.getNumSquaresRem() <= 12){
				starsWon = 1;
			}
		}
		else if(type == PieceType.RELEASE){
			if(board.getRedGot().length() == 18 && board.getBlueGot().length() == 18 && board.getGreenGot().length() == 18){
				starsWon = 3;
			}
			else if((board.getRedGot().length() == 18 && board.getBlueGot().length() == 18) || (board.getBlueGot().length() == 18 && board.getGreenGot().length() == 18) || (board.getRedGot().length() == 18 && board.getGreenGot().length() == 18)){
				starsWon = 2;
			}
			else if(board.getRedGot().length() == 18 || board.getBlueGot().length() == 18 || board.getGreenGot().length() == 18){
				starsWon = 1;
			}
		}
		//check if even need to update
		if(starsWon > star){
			try {
				if(type == PieceType.LIGHTNING)
					new DataTxtWriter("src/Data.txt").txtReplace("LLEVEL" + number + " = " + star + "," + getCounter(), "LLEVEL" + number + " = " + starsWon + "," + getCounter());
				if(type == PieceType.PUZZLE)
					new DataTxtWriter("src/Data.txt").txtReplace("PLEVEL" + number + " = " + star + "," + getCounter(), "PLEVEL" + number + " = " + starsWon + "," + getCounter());
				if(type == PieceType.RELEASE)
					new DataTxtWriter("src/Data.txt").txtReplace("RLEVEL" + number + " = " + star + ",", "RLEVEL" + number + " = " + starsWon + ",");
			} catch (IOException e) {
				e.printStackTrace();
			}
			star = starsWon;
		}


		//unlock the next level
		if(starsWon > 0 && number + 1 <= model.getNumLevels(type)){
			model.getLevel(type, number + 1).unlocked = true;
			try {
				if(type == PieceType.LIGHTNING)
					new DataTxtWriter("src/Data.txt").txtReplace("LLEVEL" + (number + 1) + " = ," + model.getLevel(type, number + 1).counter, "LLEVEL" + (number + 1) + " = " + 0 + "," + model.getLevel(type, number + 1).counter);
				if(type == PieceType.PUZZLE)
					new DataTxtWriter("src/Data.txt").txtReplace("PLEVEL" + (number + 1) + " = ," + model.getLevel(type, number + 1).counter, "PLEVEL" + (number + 1) + " = " + 0 + "," + model.getLevel(type, number + 1).counter);
				if(type == PieceType.RELEASE)
					new DataTxtWriter("src/Data.txt").txtReplace("RLEVEL" + (number + 1) + " = ", "RLEVEL" + (number + 1) + " = " + 0 + ",");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.getBoard().clearBoard();
		//bullpen.resetBullpen();
		bullpen = new Bullpen();
//		bullpen.resetBullpen();
//		bullpen = new Bullpen();
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
	public Bullpen getBullpen () {return bullpen; }

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


}
