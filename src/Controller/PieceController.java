/*
 * 
 */
package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import model.Piece;
import view.PieceView;

/**
 * @author xavier
 *
 */
public class PieceController implements MouseMotionListener, MouseListener{
	
	/** The pv. */
	PieceView pv;
	
	/** The p. */
	Piece p;
	
	/** The temp center y. */
	int tempCenterX, tempCenterY;
	
	/** The offset. */
	int offset = 96;
	
	/**
	 * Instantiates a new piece controller.
	 *
	 * @param pv
	 *            the pv
	 * @param p
	 *            the p
	 */
	public PieceController(PieceView pv, Piece p){
		//addMouseListener(this);
		this.pv = pv;
		this.p = p;
		this.tempCenterX = p.getCenterX();
		this.tempCenterY = p.getCenterY();
	}
	
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
if(SwingUtilities.isLeftMouseButton(e)){
			
		    if (p.containsPoint(e.getX(), e.getY())){
		 
		    	tempCenterX = e.getX() - offset;
				tempCenterY = e.getY() - offset;
				p.setCenterX(tempCenterX);
				p.setCenterY(tempCenterY);
		    	pv.updateLocation(e);
		    }
			
		}
		
		if( SwingUtilities.isRightMouseButton(e)){
			if (p.containsPoint(e.getX(), e.getY())){
				p.rotatePiece();
				pv.updateLocation(e);
			}
		}
				
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		   if (p.containsPoint(e.getX(), e.getY())){
//			   
		    	pv.updateLocation(e);
		    }
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}









	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		  if (p.containsPoint(e.getX(), e.getY())){
//			   
			    tempCenterX = e.getX() - offset;
				tempCenterY = e.getY() - offset;
				p.setCenterX(tempCenterX);
				p.setCenterY(tempCenterY);
		    	pv.updateLocation(e);
		    }
		// TODO Auto-generated method stub
		
	}









	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
