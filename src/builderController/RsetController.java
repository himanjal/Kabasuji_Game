/*
 * 
 */
package builderController;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderModel.Rset;
import builderView.RsetView;

/**
 * The Class RsetController.
 */
public class RsetController implements MouseListener{
	
	/** The r view. */
	RsetView rView;
	
	/** The r set. */
	Rset rSet;
	
	/** The dragging color. */
	Color draggingColor = Color.BLACK;
	
	/** The dragging number. */
	int draggingNumber =0;
	
	/** The flag. */
	boolean flag = false;
	
	/**
	 * Instantiates a new rset controller.
	 *
	 * @param rsetView
	 *            the rset view
	 */
	public RsetController(RsetView rsetView){
		this.rView = rsetView;
		this.rSet = rsetView.getRset();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = arg0.getY()/32;
		int col = arg0.getX()/32;
		
		if(col>5) col =5;
		switch(row){
		case 0: {
			draggingColor = Color.RED;
			break;
		}
		case 1: {
			draggingColor = Color.CYAN;
			break;
		}
		case 2: {
			draggingColor = Color.GREEN;
			break;
		}
		}
		
		draggingNumber = col;
		
		flag = true;
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
