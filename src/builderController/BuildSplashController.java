/*
 * 
 */
package builderController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TimerTask;

import builderModel.BuildSplash;
import builderModel.LBModel;
import builderView.LevelBuilderMenu;

/**
 * The Class BuildSplashController.
 */
public class BuildSplashController extends TimerTask{
	
	/** The ps. */
	BuildSplash ps;
	
	/** The model. */
	LBModel model;

	/**
	 * Instantiates a new builds the splash controller.
	 *
	 * @param ps
	 *            the ps
	 * @param model
	 *            the model
	 */
	public BuildSplashController(BuildSplash ps, LBModel model){
		this.ps = ps;
		this.model = model;
	}
	
	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// make the final application
		final LevelBuilderMenu app = new LevelBuilderMenu(model);

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);

		app.setVisible(true);
		ps.getFrame().dispose();
		ps.getTimer().cancel();
	}
}
