/*
 * 
 */
package builderView;
import java.awt.event.MouseEvent;

import builderModel.Piece;


/**
 * @author xavier
 *
 */
public class PieceView {
	
	/** The p. */
	Piece p;


	/**
	 * Instantiates a new piece view.
	 *
	 * @param p
	 *            the p
	 */
	public PieceView(Piece p){
		this.p = p;
	}

	/**
	 * Update location.
	 *
	 * @param e
	 *            the e
	 */
	public void updateLocation(MouseEvent e) {

	//repaint();
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Piece getModel(){
		return p;
	}
}
