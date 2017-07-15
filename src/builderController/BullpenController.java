/*
 * 
 */
package builderController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import builderModel.PieceFactory;
import builderView.BullpenView;
import builderModel.Bullpen;
import builderModel.Piece;

/**
 * The Class BullpenController.
 */
/*
 * 
 * @author Himanjal, Xavier
 */



public class BullpenController  implements MouseListener, MouseMotionListener{
	
	/** The bp. */
	private Bullpen bp;
	
	/** The bullpen view. */
	BullpenView bullpenView;
	
	/** The dragging piece. */
	Piece draggingPiece =  new PieceFactory().makePiece(100);
	/**
	 * Instantiates a new bullpen controller.
	 *
	 * @param bp
	 *            the bp
	 */
	public BullpenController(Bullpen bp, BullpenView bullpenView){
		this.setBp(bp);
		this.bullpenView = bullpenView;
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		processMouse (e.getButton(), e.getX(), e.getY());
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		processMouse (e.getButton(), e.getX(), e.getY());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		 processMouse (e.getButton(), e.getX(), e.getY());
	}
	
	/**
	 * Process mouse.
	 *
	 * @param button
	 *            the button
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void processMouse (int button, int x, int y) {
		//int row = e.getX();
		int col = y;  
		col = col/200;
		if (col >= bp.getPieces().size()) return; 
		
		if (button ==1){
			if((draggingPiece.getId() != 100)&& (draggingPiece != null) && (draggingPiece != bp.getSelectedPiece())){
				bp.addPiece(draggingPiece, draggingPiece.getId());
				draggingPiece = new PieceFactory().makePiece(100);
				bp.setSelectedPiece(100);
				
			}
			else{
				if(bp.samePieceClicked(col)){
					bp.setSelectedPiece(100);
				}else getBp().setSelectedPiece(col);
			}
		}
		if(button == 3){
			getBp().rotate(col);
			}
		
		if(button == 2){
			getBp().flipX(col);
		}
		
		bullpenView.refresh();		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		bullpenView.refresh();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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



}