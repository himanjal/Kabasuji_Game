/*
 * 
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.CreditView;
import view.MainMenuView;

/**
 * The Class CreditController.
 */
public class CreditController implements ActionListener{

	/** The model. */
	Model model;
	
/** The main view. */
//	Views that this view can get to
	MainMenuView mainView;
	
/** The credit view. */
//	Personal copy of the boundary to dispose
	CreditView creditView;
	
	/**
	 * Instantiates a new credit controller.
	 *
	 * @param creditView
	 *            the credit view
	 * @param model
	 *            the model
	 */
	public CreditController(CreditView creditView, Model model){
		this.creditView = creditView;
		this.mainView = creditView.getMainView();
		this.model = model;
		
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
		
		creditView.dispose();
		
	}

}
