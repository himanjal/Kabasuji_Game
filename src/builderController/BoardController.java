/*
 * 
 */
package builderController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import builderModel.PieceFactory;
import builderModel.PieceType;
import builderModel.Square;
import builderModel.Board;
import builderModel.BuilderRSet;
import builderModel.Piece;
import builderModel.Level;
import builderModel.Bullpen;
import builderView.BoardView;

/**
 * The Class BoardController.
 */
public class BoardController implements MouseListener, MouseMotionListener{	
	
	/** The board. */
	Board board;
	
	/** The board view. */
	BoardView boardView;
	
	/** The pf. */
	PieceFactory pf = new PieceFactory();
	
	/** The rset controller. */
	RsetController rsetController;
	
	/** The selected piece. */
	Piece selectedPiece; 
	
	/** The level. */
	Level level;
	
	/** The bp. */
	Bullpen bp;
	
	/**
	 * Instantiates a new board controller.
	 *
	 * @param board
	 *            the board
	 * @param boardView
	 *            the board view
	 * @param rsetController
	 *            the rset controller
	 */
	public BoardController(Board board, BoardView boardView, RsetController rsetController){
		this.board = board;
		this.boardView = boardView;
		this.rsetController = rsetController;
		
	}

	/**
	 * Instantiates a new board controller.
	 *
	 * @param board
	 *            the board
	 * @param boardView
	 *            the board view
	 * @param rsetController
	 *            the rset controller
	 * @param level
	 *            the level
	 */
	public BoardController(Board board, BoardView boardView, RsetController rsetController, Level level){
		this.board = board;
		this.boardView = boardView;
		this.rsetController = rsetController;
		this.level = level;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		
		boardView.setY(y);
		boardView.setX(x);
		boardView.redraw();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	/**
	 * When mouse is clicked in controller, four events can happen:
	 * 1. Piece placed on board from bullpen
	 * 2. Piece placed on board from board
	 * 3. Piece removed from board and eventually mouseClicked onto Bullpen 
	 * 		to put the piece back in the Bullpen
	 * 4. A hint is placed on the board with a middle click
	 * 
	 *  @author Anne
	 *  
	 */
	public void mouseClicked(MouseEvent e) {
		int row = e.getX();
		int col = e.getY();
		
		row = row/32;
		col = col/32;
		Piece draggingPiece = boardView.getDraggingPiece();
		
		
		/** When middle button is clicked, set selected square to a hint */
		if(e.getButton() ==3){

			Square s = board.getBoard()[row][col];
			
			/** copy board, send to stack before placing hint on board*/
			//level.pushCurrentBoard(board);

			/** set hint */
			s.setHint(!board.getBoard()[row][col].getHint());
			
			/** copy board, send to stack before after placing hint on board*/
			//level.pushCurrentBoard(board);
			boardView.redraw();
			return;
		}
		  
		//Only happens in release, puts RSets in
		if((board.getPt() == PieceType.RELEASE) && this.rsetController.flag){
			this.rsetController.flag = false;
			board.getBoard()[row][col].setRS(new BuilderRSet(rsetController.draggingColor, rsetController.draggingNumber, true, false));
			if(board.getBoard()[row][col].getRS() == null){
				board.getBoard()[row][col].setRS(new BuilderRSet(rsetController.draggingColor, rsetController.draggingNumber, true, true));
			}
			
			boardView.redraw();
		}
		else{
			/** 100 piece is null, used in Puzzle. 
			 * Sets the dragging piece after piece is selected 
			 * Picking something up from the board
			 * */
			if((draggingPiece.getId() == 100) && (board.getPt() == PieceType.PUZZLE)){
				if(board.getBoard()[row][col].isTaken()){
					
					/** copy board, send to stack before removing piece*/
				//	level.pushCurrentBoard(board);
					
					board.removePiece(row,col);
					
					boardView.setDraggingPiece(board.getSelectedPiece());
				}
				boardView.redraw();
				}
			
			else{
				/** if the piece you have picked up from the board isn't null, 
				 * you can put it on the board 
				*/
				if((draggingPiece != null) && (draggingPiece.getId() != 100)){
					
					/** copy board, send to stack before placing piece on board*/
				//	level.pushCurrentBoard(board);
					
					if(board.putPieceOnBoard(draggingPiece, row , col)){
						
						/** copy board, send to stack after placing piece on board*/
					//	level.pushCurrentBoard(board);
						
						/** update bullpen by removing the piece you put onto the board
						 * Sets the dragging piece to null 
						 * */
						if(draggingPiece != board.getSelectedPiece()){
							/** copy bullpen, send to stack before removing piece*/
					//		level.pushCurrentBullpen(board.getBp());
							
							board.getBp().removePiece(board.getBp().getSelectedPiece().getId());
							
							/** copy bullpen, send to stack after removing piece*/
					//		level.pushCurrentBullpen(board.getBp());
							
							board.getBpc().bullpenView.refresh();
							board.getBpc().draggingPiece = pf.makePiece(100);
						}
						
						
						/** copy bullpen, send to stack before removing piece*/
					//	level.pushCurrentBullpen(board.getBp());
						
						/** Remove piece from bullpen since you put it on the board */
						board.getBp().removePiece(board.getBp().getSelectedPiece().getId());
						
						/** copy bullpen, send to stack after removing piece*/
				//		level.pushCurrentBullpen(board.getBp());
						
						/** Resets dragging and selected piece to null */
						boardView.setDraggingPiece(pf.makePiece(100));
						board.getBp().setSelectedPiece(100);
						board.setSelectedPiece(pf.makePiece(100));
						board.getBpc().bullpenView.refresh();

					}
				}
				boardView.redraw();
			}
		}
		
		
		
		  
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if((board.getSelectedPiece().getId() == 100) || (board.getPt() == PieceType.LIGHTNING)){
			selectedPiece = board.getBp().getSelectedPiece();
			selectedPiece.setC(selectedPiece.getBackupColor());
			boardView.setDraggingPiece(selectedPiece);
		}
		else {
			boardView.setDraggingPiece(board.getSelectedPiece());
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		if(boardView.getDraggingPiece().getId() == 100){
			board.getBpc().draggingPiece = pf.makePiece(100);
		}
		boardView.setDraggingPiece(pf.makePiece(100));
		boardView.redraw();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		//Piece source = (Piece) arg0.getSource();
		int row = arg0.getX();
		int col = arg0.getY();
		
		row = row/32;
		col = col/32;
		
	}
}



