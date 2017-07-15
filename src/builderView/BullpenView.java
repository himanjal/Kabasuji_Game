/*
 * 
 */
package builderView;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import builderModel.Bullpen;
import builderModel.Piece;
import builderModel.Square;

import java.awt.Dimension;

/**
 * Shows all Kabasuji pieces in single panel, meant to be scrolled over.
 * 
 * Each piece is shows in its normal orientation, assuming squareSize pixels for square length
 * 
 * Drawn so center is in middle of unit square
 */
/**
 * @author Himanjal
 *
 */
public class BullpenView extends JPanel  {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The pieces. */
	ArrayList<Piece> pieces;
		
	/** The offset. */
	public final int offset = 4;
	
	/** The square size. */
	public final int squareSize = 32;
	
	/** The piece view. */
	PieceView pieceView[];
	
	/** The bp. */
	Bullpen bp;
	
	/** The off screen image. */
	Image offScreenImage = null;
	
	/** The off screen graphics. */
	Graphics offScreenGraphics = null;
	
	
	/**
	 * Instantiates a new bullpen view.
	 */
	
	public BullpenView(){
		super();
		this.bp = new Bullpen();
		this.pieces = new ArrayList<Piece>();
	}
	
	/**
	 * Instantiates a new bullpen view.
	 *
	 * @param bp
	 *            the bp
	 */
	public BullpenView(Bullpen bp){
		super();
		this.bp = bp;
		this.pieces = bp.getPieces();
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getMinimumSize()
	 */
	@Override
	public Dimension getMinimumSize(){
		int width = squareSize + 2*offset;
		int height = 10 * squareSize + pieces.size()*(squareSize*offset);
		
		return new Dimension(width, height);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize(){
		int width = 200;
		int height = 10*offset + pieces.size()* 200;
		
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
		this.pieces = bp.getPieces();
		redraw();
		repaint();
	}
	
	/**
	 * Redraw.
	 */
	void redraw(){
		int y = 0;
		
		@SuppressWarnings("unused")
		boolean[][] squares;
		this.setSize(getPreferredSize());
		
		for (Piece p : pieces) {
			squares = p.getBooleans();
			offScreenGraphics.setColor(getBackground());
			offScreenGraphics.fillRect(0 , y, 200, 200);
			List<Square> sq = p.getSquareList();
			offScreenGraphics.setColor(p.getC());	
			for(Square s: sq){
				offScreenGraphics.fillRect((s.getRow() * 32) , (s.getCol() * 32) + y, 32, 32);
			}
			y += 200;
	
		}
	}
	
}
