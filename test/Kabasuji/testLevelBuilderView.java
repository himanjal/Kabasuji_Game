/*
 * 
 */
package Kabasuji;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import builderController.LevelBuilderMenuController;
import builderController.AllLevelsController;
import builderModel.Board;
import builderModel.BuildSplash;
import builderModel.Bullpen;
import builderModel.LBDataTxtWriter;
import builderModel.LBModel;
import builderModel.LBReadWithScanner;
import builderModel.Level;
import builderModel.Piece;
import builderModel.PieceFactory;
import builderModel.PieceType;
import builderView.AllLevelsView;
import builderView.BullpenView;
import builderView.LevelBuilderMenu;
import builderView.LevelBuilderView;
import builderView.PieceView;
import builderView.RsetView;
import builderView.SquareView;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import junit.framework.TestCase;

import levelBuilder.Model;
import builderModel.Square;


import java.awt.AWTException;
import java.awt.Graphics;

import junit.framework.TestCase;

/**
 * The Class testLevelBuilderView.
 */
public class testLevelBuilderView extends TestCase {
	
	/** The lb model. */
	LBModel lbModel;
	
	/** The b. */
	Board b; 
		
		/* (non-Javadoc)
		 * @see junit.framework.TestCase#setUp()
		 */
		@Override
	protected void setUp() throws Exception{
		this.lbModel = new LBModel();
		//this.kabasuji = new Model();
		LBReadWithScanner parser = new LBReadWithScanner("src/Data.txt",lbModel);
		try {
			this.lbModel = parser.processLineByLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		}
		LevelBuilderMenu builderMenu = new LevelBuilderMenu(lbModel);
		builderMenu.setVisible(true);
					
		Square[][] squares = new Square[12][12];
		
		for(int  i=0; i<12;i++){
			for(int j=0; j<12; j++){
				squares[i][j] = new Square(i,j,b,true,false);
			}
		}
		b = new Board(squares, null, PieceType.LIGHTNING);
		
	}
		
		/**
		 * Test main.
		 */
		public void testMain(){
			builderModel.Main main = new builderModel.Main();
			LBModel model = new LBModel();
			
			//read in from the data file to load saved information
			LBReadWithScanner parser = new LBReadWithScanner("src/Data.txt", model);
				// make the final application
			final LevelBuilderMenu app = new LevelBuilderMenu(model);
		}
		
	/**
	 * Test level builder.
	 */
	public void testLevelBuilder(){
		LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
		buildMenu.setVisible(true);
		assertTrue(buildMenu.isVisible());
		
		AllLevelsView allView = new AllLevelsView(this.lbModel, PieceType.LIGHTNING, "create");
		AllLevelsView allView2 = new AllLevelsView(this.lbModel, PieceType.LIGHTNING, "edit");
		AllLevelsView allView3 = new AllLevelsView(this.lbModel, PieceType.LIGHTNING, "delete");
		//BullpenView bullpenView = new BullpenView(this.lbModel);
		allView.setVisible(true);
		allView.getLevel1().doClick();
		
		lbModel = new LBModel();
				
		//create new level 
			
		buildMenu.getCreateLevel().doClick();
		
		buildMenu.getLightning().doClick();
		buildMenu.getLightning().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.LIGHTNING));

		buildMenu.getEditLevel().doClick();
		buildMenu.getLightning().doClick();
		buildMenu.getLightning().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.LIGHTNING));
		
		buildMenu.getDeleteLevel().doClick();
		buildMenu.getLightning().doClick();
		allView3.setVisible(true);
		assertTrue(allView3.isVisible());
		
		assertFalse(buildMenu.getDeleteLevel().isValid());
		allView3.getNextPage().doClick();
		allView3.getPrePage().doClick();
		assertTrue(allView3.getNextPage().isVisible());
		
		buildMenu.getCreateLevel().doClick();
		
		buildMenu.getPuzzle().doClick();
		buildMenu.getPuzzle().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.PUZZLE));

		buildMenu.getEditLevel().doClick();
		buildMenu.getPuzzle().doClick();
		buildMenu.getPuzzle().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.PUZZLE));
		
		buildMenu.getDeleteLevel().doClick();
		buildMenu.getPuzzle().doClick();
		allView3.setVisible(true);
		assertTrue(allView3.isVisible());
		
		assertFalse(buildMenu.getDeleteLevel().isValid());
		allView3.getNextPage().doClick();
		allView3.getPrePage().doClick();
		assertTrue(allView3.getNextPage().isVisible());
		
		buildMenu.getCreateLevel().doClick();
		
		buildMenu.getRelease().doClick();
		buildMenu.getRelease().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.RELEASE));

		buildMenu.getEditLevel().doClick();
		buildMenu.getRelease().doClick();
		buildMenu.getRelease().isVisible();
		assertFalse(buildMenu.isVisible());
		System.out.println(this.lbModel.getNumLevels(PieceType.RELEASE));
		
		buildMenu.getDeleteLevel().doClick();
		buildMenu.getRelease().doClick();
		allView3.setVisible(true);
		assertTrue(allView3.isVisible());
		
		assertFalse(buildMenu.getDeleteLevel().isValid());
		allView3.getNextPage().doClick();
	
			
//		//edit level 
		/* errors
		LevelBuilderView buildView = new LevelBuilderView(this.lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 5));
		
		buildView.setVisible(true);
		assertTrue(buildView.isVisible());
		
		*/
		}
	
	/**
	 * Test builder add piece.
	 */
	public void testBuilderAddPiece(){
		Bullpen bp1 = new Bullpen();  
		Level builderLevel = new Level(7, PieceType.PUZZLE, bp1);
		builderLevel.setBoard(b);
		assertFalse(builderLevel.getBullpen().isEmpty());
		assertTrue(builderLevel.getBoard().putPieceOnBoardLB(new builderModel.PieceFactory().makePiece(4), 5, 5));
		assertEquals(b.getPieces().size(), 1);
		builderLevel.getBullpen().setSelectedPiece(1);
		assertTrue(bp1.getSelectedPiece().equals(bp1.getPiece(1)));
		//LevelBuilderView builderView = new LevelBuilderView(this.lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 7) );
		//assertTrue(builderView.isVisible());
	}
	
	/**
	 * Test all levels view edit.
	 */
	//test allLevelsView clicking level1, go back, level2, go back, etc
	public void testAllLevelsViewEdit(){
		LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
		buildMenu.setVisible(true);
		assertTrue(buildMenu.isVisible());
		
		AllLevelsView allView = new AllLevelsView(this.lbModel, PieceType.LIGHTNING, "edit");
		AllLevelsView allViewp = new AllLevelsView(this.lbModel, PieceType.PUZZLE, "edit");
		AllLevelsView allViewr = new AllLevelsView(this.lbModel, PieceType.RELEASE, "edit");
		
		allView.setVisible(true);
		allView.getLevel1().doClick();
		allView.getLevel2().doClick();
		allView.getLevel3().doClick();
		allView.getLevel4().doClick();
		allView.getLevel5().doClick();
		allView.setPage(2);
		allView.setAction("edit");
		allView.getLevel1().doClick();
		allView.getBack().doClick();
		//dispose
		LevelBuilderView builderView2 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 2));
		builderView2.getLevel().setMode("edit");
		builderView2.getBack().doClick();
		LevelBuilderView builderView3 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 3));
		LevelBuilderView builderView4 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 4));
		LevelBuilderView builderView5 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 5));
		
//		AllLevelsController love = new AllLevelsController(allView, lbModel, "edit");
//		ActionEvent e = new ActionEvent();
//		love.actionPerformed(e);
//		allView.setVisible(true);
//		allView.getLevel1().doClick();
//		LevelBuilderView builderViewp = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 1));
//		builderView.getBack().doClick();
//		//dispose
		LevelBuilderView builderViewp2 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 2));
		builderViewp2.getLevel().setMode("edit");
		builderViewp2.getBack().doClick();
		LevelBuilderView builderViewp3 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 3));
		LevelBuilderView builderViewp4 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 4));
		LevelBuilderView builderViewp5 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 5));
//		
//		allView.setVisible(true);
//		allView.getLevel1().doClick();
//		LevelBuilderView builderViewr = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 1));
//		builderView.getBack().doClick();
//		//dispose
		LevelBuilderView builderViewr2 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 2));
		builderViewr2.getLevel().setMode("edit");
		builderViewr2.getBack().doClick();
		LevelBuilderView builderViewr3 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 3));
		LevelBuilderView builderViewr4 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 4));
		LevelBuilderView builderViewr5 = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 5));
	}
	
	/**
	 * Test all levels view delete.
	 */
	public void testAllLevelsViewDelete(){
		LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
		buildMenu.setVisible(true);
		assertTrue(buildMenu.isVisible());
		
		AllLevelsView allView = new AllLevelsView(this.lbModel, PieceType.LIGHTNING, "delete");
		
		allView.setVisible(true);
		allView.getLevel1().doClick();
		allView.getLevel2().doClick();
		allView.getLevel3().doClick();
		allView.getLevel4().doClick();
		allView.getLevel5().doClick();
		
		AllLevelsView allView1 = new AllLevelsView(this.lbModel, PieceType.PUZZLE, "delete");
		
		allView1.setVisible(true);
		allView1.getLevel1().doClick();
		allView1.getLevel2().doClick();
		allView1.getLevel3().doClick();
		allView1.getLevel4().doClick();
		allView1.getLevel5().doClick();
		
		AllLevelsView allView2 = new AllLevelsView(this.lbModel, PieceType.RELEASE, "delete");
		
		allView2.setVisible(true);
		allView2.getLevel1().doClick();
		allView2.getLevel2().doClick();
		allView2.getLevel3().doClick();
		allView2.getLevel4().doClick();
		allView2.getLevel5().doClick();
		
		allView.setPage(2);
		allView.getLevel1().doClick();
	}
	
/**
 * Test publish level.
 *
 * @throws IOException
 *             Signals that an I/O exception has occurred.
 */
//	
	public void testPublishLevel() throws IOException{
		LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
		buildMenu.setVisible(true);
		assertTrue(buildMenu.isVisible());
		this.lbModel.getLevel(PieceType.LIGHTNING, 6).setMode("edit");
		LevelBuilderView builderView = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.LIGHTNING, 6));
		builderView.getLevel().setMode("edit");
		builderView.getPublish().doClick();
		assertFalse(builderView.isVisible());
		LBDataTxtWriter writer = new LBDataTxtWriter("src/Data.txt");
		writer.txtReplaceLine("LLEVEL6_BOARD =", " 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");
		writer.txtReplaceLine("LLEVEL6_PIECES = ", "1,2,9,10");
	}
		
		/**
		 * Test clear all.
		 */
		public void testClearAll(){
		LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
		buildMenu.setVisible(true);
		assertTrue(buildMenu.isVisible());
	}
	
		/**
		 * Test square view.
		 */
		public void testSquareView(){
			builderModel.Square square = new builderModel.Square(4,4);
			builderView.SquareView squareView = new builderView.SquareView(square);
			squareView.setLocation(3, 4);
			assertFalse(square.isCovered());
			square.rotateAroundOrigin();
		}
		
		/**
		 * Test piece view.
		 */
		public void testPieceView(){
			builderModel.Piece newPiece = new builderModel.PieceFactory().makePiece(1);
			PieceView pieceView = new PieceView(newPiece);
			
		}
		
		/**
		 * Test undo.
		 */
		public void testUndo(){
			LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
			buildMenu.setVisible(true);
			assertTrue(buildMenu.isVisible());
			this.lbModel.getLevel(PieceType.PUZZLE, 3).setMode("edit");
			LevelBuilderView builderView = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.PUZZLE, 3));
//			builderView.getUndo().doClick();
//			assertFalse(builderView.isVisible());
		}
		
		/**
		 * Test redo.
		 */
		public void testRedo(){
			LevelBuilderMenu buildMenu = new LevelBuilderMenu(this.lbModel);
			buildMenu.setVisible(true);
			assertTrue(buildMenu.isVisible());
			this.lbModel.getLevel(PieceType.RELEASE, 4).setMode("edit");
			LevelBuilderView builderView = new LevelBuilderView(lbModel, this.lbModel.getLevel(PieceType.RELEASE, 3));
//			builderView.getRedo().doClick();
//			assertFalse(builderView.isVisible());
		}
		
		/**
		 * Test splash.
		 */
		public void testSplash(){
			new BuildSplash(lbModel);
		}
		
		/**
		 * Test bullpen.
		 */
		public void testBullpen(){
			Bullpen bp = new Bullpen();
			bp.addRandomPiece(5);
			bp.removePiece(10);
			assertTrue(bp.numOfPiecesAvailable()==39);
			Bullpen bp2 = bp.copy();
		}
		
		/**
		 * Test tx twriter.
		 *
		 * @throws IOException
		 *             Signals that an I/O exception has occurred.
		 */
		public void testTXTwriter() throws IOException{
			LBDataTxtWriter writer = new LBDataTxtWriter("src/Data.txt");
			writer.txtAdd("LET THE GAME BEGIN");
			writer.txtReplace("GAME", "HUNT");
			writer.txtDelete("LET THE HUNT BEGIN");
			writer.txtAdd("ALLNIGHTER LIFE");
			writer.txtDeleteLine("ALLNIGHTER");
		}
		
		/**
		 * Test piece.
		 */
		public void testPiece(){
			PieceFactory pf = new PieceFactory();
			Piece p = pf.makePiece(1);
			boolean b = p.containsPoint(1, 1);
			p.rotatePiece();
			p.flipPieceX();
			p.flipPieceY();
		}
		
		
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	

}
