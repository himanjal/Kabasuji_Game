/*
 * 
 */
package builderView;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import builderModel.Square;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * The Class SquareView.
 */
public class SquareView extends Canvas implements MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The s. */
	Square s;
	
	/** The c. */
	Color c;

	/**
	 * @wbp.parser.entryPoint
	 */
	public SquareView(Square s){
		this.s = s;
		this.c = s.getColor();
		this.s.setSize(this.s.getLength(),this.s.getLength());
		
	}
	/*
	public void setColor(Color col){
		this.c = col;
	}
	*/
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setLocation(int x, int y){
		this.s.setLocation(x, y);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
	    Dimension dim = getSize();
	    int w = (int) dim.getWidth();
	    int h = (int) dim.getHeight();
	    g2.setStroke(new BasicStroke(8.0f));
	    


//	   
	    // Clears the rectangle that was previously drawn.
	    g2.setPaint(c);
	    

			g.fillRect(0, 0, w, h);
						
		

	    g2.setColor(Color.red);
	    g2.setColor(c);
		

		if(s.isVisible()){
			g.fillRect((int)this.s.getX(), (int)this.s.getY()+32, s.getLength(), s.getLength());
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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