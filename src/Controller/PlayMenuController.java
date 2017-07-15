/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.AllLevelsView;
import view.MainMenuView;
import view.PlayMenuView;
import Kabasuji.PieceType;

/**
 * The Class PlayMenuController.
 */
public class PlayMenuController implements ActionListener{
	
	/** The main view. */
	//views that this view can get to
	MainMenuView mainView;
	
	/** The all view. */
	AllLevelsView allView;
	
	/** The play view. */
	//personal copy of the boundary to dispose
	PlayMenuView playView;
	
	/** The model. */
	Model model;
	
	/**
	 * Instantiates a new play menu controller.
	 *
	 * @param playView
	 *            the play view
	 * @param model
	 *            the model
	 */
	public PlayMenuController(PlayMenuView playView, Model model){
		this.mainView = playView.getMainView();
		this.allView = playView.getAllLevelsView();
		
		this.playView = playView;
		
		this.model = model;
	}
		
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//open main menu
		if(source.getName().equals("back")){
			mainView = new MainMenuView(model);
			mainView.setVisible(true);
		}

		//open lightning level
		if(source.getName().equals("lightning")){
			allView = new AllLevelsView(model,PieceType.LIGHTNING);
			allView.setVisible(true);
		}

		//open Puzzle level
		if(source.getName().equals("puzzle")){
			allView = new AllLevelsView(model,PieceType.PUZZLE);
			allView.setVisible(true);
		}
		//open Release level
		if(source.getName().equals("release")){
			allView = new AllLevelsView(model,PieceType.RELEASE);
			allView.setVisible(true);
		}

		playView.dispose();
	}

}
