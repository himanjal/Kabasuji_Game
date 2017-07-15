/*
 * 
 */
package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JButton;

import builderModel.LBModel;
import builderModel.PieceType;
import builderView.AllLevelsView;
import builderView.LevelBuilderMenu;
import builderView.LevelBuilderView;
import builderModel.Board;
import builderModel.Bullpen;
import builderModel.LBDataTxtWriter;
import builderModel.Level;

/**
 * The Class LevelController.
 */
public class LevelBuilderController extends TimerTask implements ActionListener{
	
	/** The all view. */
	//views this view can get to
	AllLevelsView allView;
	
	/**
	 * Level used
	 */
	Level level;
	
	/** The lbmenu. */
	LevelBuilderMenu lbmenu;
	
	/** The lvl view. */
	//personal copy of the boundary to dispose
	LevelBuilderView lvlView;
	
	/** The model. */
	LBModel model;
	
	/**
	 * Instantiates a new level controller.
	 *
	 * @param lvlView
	 *            the lvlview
	 * @param model
	 *            the model
	 */
	public LevelBuilderController (LevelBuilderView lvlView, LBModel model){
		this.allView = lvlView.getAllLevelsView();
		this.lbmenu = lvlView.getMenuView();
		this.lvlView = lvlView;
		this.model = model;
		this.level = lvlView.getLevel();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source.getName().equals("back")){
			if(lvlView.getLevel().getMode().equals("create") && lvlView.getLevel().getType().equals(PieceType.LIGHTNING)){
				model.getLlevels().remove(model.getLlevels().size()-1);
			}
			if(lvlView.getLevel().getMode().equals("create") && lvlView.getLevel().getType().equals(PieceType.PUZZLE)){
				model.getPlevels().remove(model.getPlevels().size()-1);
			}
			if(lvlView.getLevel().getMode().equals("create") && lvlView.getLevel().getType().equals(PieceType.RELEASE)){
				model.getRlevels().remove(model.getRlevels().size()-1);
			}
			lbmenu = new LevelBuilderMenu(model);
			lbmenu.setVisible(true);
		}
		
		if(source.getName().equals("Clear All")){
			level.getBoard().clearBoard();
			Bullpen newbp = new Bullpen();
			level.setBullpen(newbp);
			level.getBoard().setBp(newbp);
			lvlView.initialize();
			return;
			
		}
		if(source.getName().equals("Redo")){
			Board board1 = level.redoBoard();
			level.setBoard(board1);
			Bullpen bullpen1 = level.redoBullpen();
			level.setBullpen(bullpen1);
			System.out.println("Did Redo");
			lvlView.getBoardView().redraw();
			lvlView.getBullpenView().refresh();		

			return;
		}
	
		if(source.getName().equals("Undo")){
			Board board2 = level.undoBoard();
			level.setBoard(board2);
			Bullpen bullpen2 = level.undoBullpen();

			level.setBullpen(bullpen2);
			System.out.println("Did Undo");
			
			/**
			 * 
			 **********************************************************************************

			lvlView.getBoardView().redraw(); //null ptr exc
			lvlView.getBullpenView().refresh();
			return;
			*/
		}
		
		if(source.getName().equals("Publish")){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			this.level.setBoard(lvlView.getLevel().getBoard());
			Integer x = lvlView.getLevel().getNumber();
			String levelName = "";
			String levelBoardName = "";
			String levelBullpenName = "";
			String newValue1 = "";
			String newValue2 = "";
			String newValue3 = "";

			if (lvlView.getLevel().getType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString()+ " ";
				levelBoardName = "LLEVEL" + x.toString() + "_BOARD";
				levelBullpenName = "LLEVEL" + x.toString() + "_PIECES";
//				Integer secs = lvlView.getLevel().getSeconds();	
				Integer y = Integer.parseInt(lvlView.getCounterLabel().getText());
				newValue1 = " = ," + y.toString();
				if(x==1){
					newValue1 = " = 0," + y.toString();
				}
			}
			if (lvlView.getLevel().getType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString()+ " ";
				levelBoardName = "PLEVEL" + x.toString() + "_BOARD";
				levelBullpenName = "PLEVEL" + x.toString() + "_PIECES";
//				Integer mvs =  lvlView.getLevel().getMoves();
				Integer y = Integer.parseInt(lvlView.getCounterLabel().getText());
				newValue1 = " = ," + y.toString();	
				if(x==1){
					newValue1 = " = 0," + y.toString();
				}
			}
			if (lvlView.getLevel().getType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString()+ " ";
				levelBoardName = "RLEVEL" + x.toString() + "_BOARD";
				levelBullpenName = "RLEVEL" + x.toString() + "_PIECES";
				newValue1 = " = " ;		//+ lvlView.getLevel().getRSet()
				if(x==1){
					newValue1 = " = 0,";
				}
			}
			newValue2 = " = " + lvlView.getLevel().getBoard().toTxt(lvlView.getLevel().getType());
			newValue3 = " = " + lvlView.getLevel().getBullpen().toTxt();
			
			if (lvlView.getLevel().getMode().equals("edit")){
				try {
					dataWriter.txtReplaceLine(levelName, newValue1);
					dataWriter.txtReplaceLine(levelBullpenName, newValue3);
					dataWriter.txtReplaceLine(levelBoardName, newValue2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (lvlView.getLevel().getMode().equals("create")){
				String love1 = levelName + newValue1;
				String love2 = levelBoardName + newValue2;
				String love3 = levelBullpenName + newValue3;
				try {
					dataWriter.txtAdd(love1);
					dataWriter.txtAdd(love3);
					dataWriter.txtAdd(love2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		lvlView.dispose();
	}

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		//increase the current count
		lvlView.setCurCount(lvlView.getCurCount() + 1);
		
		//set the text field so the user can see the remaining count
		lvlView.getCounterLabel().setText("" + (lvlView.getCounter() - lvlView.getCurCount()));
		
		//once the count is 0, complete the level, stop any timers and return to the level select screen
		if(lvlView.getCounter() == lvlView.getCurCount()){
			allView = new AllLevelsView(model, lvlView.getLevel().getType(),"");
			allView.setVisible(true);
			lvlView.dispose();
		}
	}

}