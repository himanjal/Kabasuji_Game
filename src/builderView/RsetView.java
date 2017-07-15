/*
 * 
 */

package builderView;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import builderModel.Rset;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;



/**
 * @author Himanjal
 *
 */
public class RsetView extends JPanel  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	/** The offset. */
	public final int offset = 2;
	
	/** The square size. */
	public final int squareSize = 32;
	
	/** The rset. */
	private Rset rset;

	/** The off screen image. */
	Image offScreenImage = null;
	
	/** The off screen graphics. */
	Graphics offScreenGraphics = null;
	
	
	/**
	 * Instantiates a new Rset view.
	 */
	
	public RsetView(){
		super();
		this.setRset(new Rset());
		
	}
		
	

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getMinimumSize()
	 */
	@Override
	public Dimension getMinimumSize(){
		int width = 6*squareSize + 7*offset;
		int height = 3*squareSize + 4*offset;
		
		return new Dimension(width, height);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize(){
		
		int width = 6*squareSize + 7*offset;
		int height = 3*squareSize + 4*offset;
		
		return new Dimension(width, height);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		if(offScreenImage == null){
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width,s.height);
			offScreenGraphics = offScreenImage.getGraphics();
			redraw();
		}

		if(offScreenImage == null){
			return;
		}
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	/**
	 * Refresh.
	 */
	public void refresh(){
		redraw();
		repaint();
	}
	
	/**
	 * Redraw.
	 */
	void redraw(){
		int x = 0;
		
		this.setSize(getPreferredSize());
		Color c = Color.RED;
		for (int i =0; i<3; i++) {
			for( int j = 0; j<6;j++){
				if(i==0) c =Color.RED;
				if(i==1) c =Color.CYAN;
				if(i==2) c = Color.GREEN;
				
				offScreenGraphics.setColor(c);
				offScreenGraphics.fillRect(x, i*32+offset, 32, 32);
				
				offScreenGraphics.setColor(Color.BLACK);
				offScreenGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
				offScreenGraphics.drawString(Integer.toString(getRset().getRset()[i][j].getRS().getRSInt()), x+5, ((i+1)*squareSize)-5);
					
				x += squareSize + offset;	
			}
			x=0;
		}
	}



	/**
	 * Gets the rset.
	 *
	 * @return the rset
	 */
	public Rset getRset() {
		return rset;
	}



	/**
	 * Sets the rset.
	 *
	 * @param rset
	 *            the new rset
	 */
	public void setRset(Rset rset) {
		this.rset = rset;
	}
	
}
