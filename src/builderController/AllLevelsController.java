/*
 * 
 */
package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderModel.LBModel;
import builderModel.PieceType;
import builderView.AllLevelsView;
import builderView.LevelBuilderMenu;
import builderView.LevelBuilderView;
import builderModel.LBDataTxtWriter;

/**
 * The Class AllLevelsController.
 */
public class AllLevelsController implements ActionListener{

	/** The model. */
	LBModel model;
	
	/** The action. */
	String action;
	
/** The lvl view. */
//	Views that this view can get to
	LevelBuilderView lvlView;
	
/** The all view. */
//	Personal copy of the boundary to dispose
	AllLevelsView allView;
	
	/**
	 * Instantiates a new all levels controller.
	 *
	 * @param allView
	 *            the all view
	 * @param model
	 *            the model
	 */
	public AllLevelsController(AllLevelsView allView, LBModel model, String action){
		this.lvlView = allView.getLevelView();
		this.allView = allView;
		this.model = model;
		this.action = action;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//open legevel 1
		if((source.getName().equals("level1"))&&(this.action.equals("edit"))){
			model.getLevel(allView.getLevelType(), 1 + (5 * (allView.getPage() - 1))).setMode("edit");
			model.getLevel(allView.getLevelType(), 1 + (5 * (allView.getPage() - 1))).getBoard().setPt(allView.getLevelType());
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 1 + (5 * (allView.getPage() - 1))));
			lvlView.setVisible(true);
		}
		
		if((source.getName().equals("level1")) && (this.action.equals("delete"))){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			Integer x = (allView.getPage()-1)*5 + 1;
			String levelName = "";
			if (allView.getLevelType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString();
			}
			try {
				dataWriter.txtDeleteLine(levelName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}
		
		//open level 2
		if((source.getName().equals("level2"))&&(this.action.equals("edit"))){
			model.getLevel(allView.getLevelType(), 2 + (5 * (allView.getPage() - 1))).setMode("edit");
			model.getLevel(allView.getLevelType(), 2 + (5 * (allView.getPage() - 1))).getBoard().setPt(allView.getLevelType());
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 2 + (5 * (allView.getPage() - 1))));
			lvlView.setVisible(true);
		}
		
		if((source.getName().equals("level2")) && (this.action.equals("delete"))){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			Integer x = (allView.getPage()-1)*5 + 2;
			String levelName = "";
			if (allView.getLevelType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString();
			}
			try {
				dataWriter.txtDeleteLine(levelName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}

		//open level 3
		if((source.getName().equals("level3"))&&(this.action.equals("edit"))){
			model.getLevel(allView.getLevelType(), 3 + (5 * (allView.getPage() - 1))).setMode("edit");
			model.getLevel(allView.getLevelType(), 3 + (5 * (allView.getPage() - 1))).getBoard().setPt(allView.getLevelType());
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 3 + (5 * (allView.getPage() - 1))));
			lvlView.setVisible(true);
		}
		
		if((source.getName().equals("level3")) && (this.action.equals("delete"))){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			Integer x = (allView.getPage()-1)*5 + 3;
			String levelName = "";
			if (allView.getLevelType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString();
			}
			try {
				dataWriter.txtDeleteLine(levelName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}

		//open level 4
		if((source.getName().equals("level4"))&&(this.action.equals("edit"))){
			model.getLevel(allView.getLevelType(), 4 + (5 * (allView.getPage() - 1))).setMode("edit");
			model.getLevel(allView.getLevelType(), 4 + (5 * (allView.getPage() - 1))).getBoard().setPt(allView.getLevelType());
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 4 + (5 * (allView.getPage() - 1))));
			lvlView.setVisible(true);
		}
		
		if((source.getName().equals("level4")) && (this.action.equals("delete"))){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			Integer x = (allView.getPage()-1)*5 + 4;
			String levelName = "";
			if (allView.getLevelType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString();
			}
			try {
				dataWriter.txtDeleteLine(levelName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}

		//open level 5
		if((source.getName().equals("level5"))&&(this.action.equals("edit"))){
			model.getLevel(allView.getLevelType(), 5 + (5 * (allView.getPage() - 1))).setMode("edit");
			model.getLevel(allView.getLevelType(), 5 + (5 * (allView.getPage() - 1))).getBoard().setPt(allView.getLevelType());
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 5 + (5 * (allView.getPage() - 1))));
			lvlView.setVisible(true);
		}
		
		if((source.getName().equals("level5")) && (this.action.equals("delete"))){
			LBDataTxtWriter dataWriter = new LBDataTxtWriter("src/Data.txt");
			Integer x = (allView.getPage()-1)*5 + 1;
			String levelName = "";
			if (allView.getLevelType().equals(PieceType.LIGHTNING)){
				levelName = "LLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.PUZZLE)){
				levelName = "PLEVEL" + x.toString();
			}
			else if (allView.getLevelType().equals(PieceType.RELEASE)){
				levelName = "RLEVEL" + x.toString();
			}
			try {
				dataWriter.txtDeleteLine(levelName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}
		
		if(source.getName().equals("back")){
			LevelBuilderMenu view = new LevelBuilderMenu(model);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(true);
		}
		
		//close current screen
		allView.dispose();
		
		//load next pages
		if(source.getName().equals("nextLevels")){
			allView.setPage(allView.getPage() + 1);
			allView.initialize();
			allView.setVisible(true);
		}
		
		//load previous page
		if(source.getName().equals("previousLevels")){
			allView.setPage(allView.getPage() - 1);
			allView.initialize();
			allView.setVisible(true);
		}
	}

}
