/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Kabasuji.PieceType;
import model.Model;
import view.AllLevelsView;
import view.LevelView;

/**
 * The Class LevelController.
 */
public class LevelController extends TimerTask implements ActionListener, DocumentListener{
	
	/** The all view. */
	//views this view can get to
	AllLevelsView allView;
	
	/** The lvl view. */
	//personal copy of the boundary to dispose
	LevelView lvlView;
	
	/** The model. */
	Model model;
	
	/**
	 * Instantiates a new level controller.
	 *
	 * @param lvlView
	 *            the lvl view
	 * @param model
	 *            the model
	 */
	public LevelController(LevelView lvlView, Model model){
		this.allView = lvlView.getAllLevelsView();
		this.lvlView = lvlView;
		this.model = model;
		lvlView.getLevel().getBoard().setLvlView(lvlView);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//complete the level and return to level select screen
		if(source.getName().equals("back")){
			lvlView.getLevel().completeLevel(model);
			allView = new AllLevelsView(model, lvlView.getLevel().getType());
			allView.setVisible(true);
		}
		
		lvlView.getTimer().cancel();
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
		if(lvlView.getCounter() == lvlView.getCurCount() || lvlView.getLevel().getBoard().getNumSquaresRem() == 0){
			lvlView.getLevel().completeLevel(model);
			allView = new AllLevelsView(model, lvlView.getLevel().getType());
			allView.setVisible(true);
			lvlView.getTimer().cancel();
			lvlView.dispose();
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		if(lvlView.getLevel().getType() == PieceType.PUZZLE){
			lvlView.setCurCount(lvlView.getLevel().getBoard().getMoves());
			
			//once the count is 0, complete the level, stop any timers and return to the level select screen
			if(lvlView.getCounter() == lvlView.getCurCount() || lvlView.getLevel().getBoard().getNumSquaresRem() == 0){
				lvlView.getLevel().completeLevel(model);
				allView = new AllLevelsView(model, lvlView.getLevel().getType());
				allView.setVisible(true);
				lvlView.getTimer().cancel();
				lvlView.dispose();
			}
		}
		else if(lvlView.getLevel().getType() == PieceType.RELEASE){
			if(lvlView.getTextField().getText().length() == 18 && lvlView.getTextField_1().getText().length() == 18 && lvlView.getTextField_2().getText().length() == 18){
				lvlView.getLevel().completeLevel(model);
				allView = new AllLevelsView(model, lvlView.getLevel().getType());
				allView.setVisible(true);
				lvlView.getTimer().cancel();
				lvlView.dispose();
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		
	}

}
