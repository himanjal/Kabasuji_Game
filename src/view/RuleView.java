/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.RuleController;
import model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

/**
 * @author Jetro
 *
 */
public class RuleView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/** The back. */
private //	Buttons in the view
	JButton back;
	
/** The main view. */
//	Views that this view can get to
	private MainMenuView mainView;
	
	/** The model. */
	Model model;

	/**
	 * Create the frame.
	 */
	public RuleView(Model model) {
		this.model = model;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	public void initialize(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("2.1.In Puzzle, you have to fill the board");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		JLabel lblGitCommit = new JLabel("2.2.In Lightning, you need to finish before time runs out");
		lblGitCommit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		JLabel lbli = new JLabel("2.3.In Release, you need to get the three sets of colors 1-6");
		lbli.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		JLabel lblesc = new JLabel("3.Drag pieces from the bullpen to the board and WIN");
		lblesc.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		JLabel lblGitPush = new JLabel("4.Use the Level Builder to contruct new levels!");
		lblGitPush.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		JLabel lblGitPull = new JLabel("1.Select a level after clicking PLAY");
		lblGitPull.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(153)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblesc, 0, 0, Short.MAX_VALUE)
						.addComponent(lblGitPush, 0, 0, Short.MAX_VALUE)
						.addComponent(lbli, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 673, Short.MAX_VALUE)
						.addComponent(lblGitPull, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGitCommit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblGitPull, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGitCommit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbli, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblesc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGitPush, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(268, Short.MAX_VALUE))
		);
		
		JLabel lblRules = new JLabel("RULES");
		lblRules.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));

//		setup back button
		setBack(new JButton(""));
		getBack().setName("back");
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().setIcon(new ImageIcon(RuleView.class.getResource("/Images/BackIcon.png")));
		getBack().setFont(new Font("Tahoma", Font.BOLD, 8));
		getBack().setBackground(new Color(169, 169, 169));
		getBack().addActionListener(new RuleController(this,model));
		
//		setup group Layout
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(315)
					.addComponent(lblRules)
					.addContainerGap(430, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRules, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Gets the main view.
	 *
	 * @return the main view
	 */
	public MainMenuView getMainView() {
		return mainView;
	}

	/**
	 * Sets the main view.
	 *
	 * @param mainView
	 *            the new main view
	 */
	public void setMainView(MainMenuView mainView) {
		this.mainView = mainView;
	}

	/**
	 * Gets the back.
	 *
	 * @return the back
	 */
	public //	Buttons in the view
	JButton getBack() {
		return back;
	}

	/**
	 * Sets the back.
	 *
	 * @param back
	 *            the new back
	 */
	public void setBack(//	Buttons in the view
	JButton back) {
		this.back = back;
	}
}
