/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.AchievementView;
import view.CreditView;
import view.MainMenuView;
import view.PlayMenuView;
import view.RuleView;

/**
 * The Class MainMenuController.
 */
public class MainMenuController implements ActionListener{
	
	/** The ach view. */
	//views to create
	AchievementView achView;
	
	/** The rule view. */
	RuleView ruleView;
	
	/** The cred view. */
	CreditView credView;
	
	/** The play view. */
	PlayMenuView playView;
	
	/** The mm view. */
	//personal copy of the boundary to dispose when switching screens
	MainMenuView mmView;
	
	/** The model. */
	Model model;
	
	/**
	 * Instantiates a new main menu controller.
	 *
	 * @param mmv
	 *            the mmv
	 * @param model
	 *            the model
	 */
	public MainMenuController(MainMenuView mmv, Model model){
		this.achView = mmv.getAchievementView();
		this.playView = mmv.getPlayView();
		this.credView = mmv.getCreditView();
		this.ruleView = mmv.getRuleView();
		
		this.model = model;
		this.mmView = mmv;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//open the badges screen
		if(source.getName().equals("play")){
			playView = new PlayMenuView(model);
			playView.setVisible(true);
		}
		
		//open the badges screen
		if(source.getName().equals("achievements")){
			achView = new AchievementView(model);
			achView.setVisible(true);
		}

		//open the badges screen
		if(source.getName().equals("rules")){
			ruleView = new RuleView(model);
			ruleView.setVisible(true);
		}

		//open the badges screen
		if(source.getName().equals("credits")){
			credView = new CreditView(model);
			credView.setVisible(true);
		}
		
		//close the main menu view screen
		mmView.dispose();
	}
}
