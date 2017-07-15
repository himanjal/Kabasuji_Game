/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.AchievementView;
import view.MainMenuView;

/**
 * The Class AchievementController.
 */
public class AchievementController implements ActionListener{
	
	/** The main view. */
	//views to create
	MainMenuView mainView;
	
	/** The ach view. */
	//personal copy of the boundary to dispose of the screen
	AchievementView achView;
	
	/** The model. */
	Model model;

	/**
	 * Instantiates a new achievement controller.
	 *
	 * @param achView
	 *            the ach view
	 * @param model
	 *            the model
	 */
	public AchievementController(AchievementView achView, Model model){
		this.mainView = achView.getMainView();
		
		this.model = model;
		this.achView = achView;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//open the badges screen
		if(source.getName().equals("back")){
			mainView = new MainMenuView(model);
			mainView.setVisible(true);
			
			//close the achievement view screen
			achView.dispose();
		}
		
		if(source.getName().equals("reset")){
			model.resetBadges();
			
			//refresh achievement view
			achView.dispose();
			achView = new AchievementView(model);
			achView.setVisible(true);
		}
	}
	
	
}
