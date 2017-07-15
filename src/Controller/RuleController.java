/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.MainMenuView;
import view.RuleView;

/**
 * The Class RuleController.
 */
public class RuleController implements ActionListener{

	/** The model. */
	Model model;
	
/** The main view. */
//	Views that this view can get to
	MainMenuView mainView;
	
/** The rule view. */
//	Personal copy of the boundary to dispose
	RuleView ruleView;
	
	/**
	 * Instantiates a new rule controller.
	 *
	 * @param ruleView
	 *            the rule view
	 * @param model
	 *            the model
	 */
	public RuleController(RuleView ruleView, Model model){
		this.model = model;
		this.ruleView = ruleView;
		this.mainView = ruleView.getMainView();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton) e.getSource();

//		open mainMenu
		if(source.getName().equals("back")){
			mainView = new MainMenuView(model);
			mainView.setVisible(true);
		}
		ruleView.dispose();
		
	}

}
