/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.PlayMenuController;
import model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

/**
 * @author Jetro
 *
 */
public class PlayMenuView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Model model;
	
	/** The release. */
	//buttons in the view
	JButton release;
	
	/** The puzzle. */
	private JButton puzzle;
	
	/** The lightning. */
	JButton lightning;
	
	/** The back. */
	JButton back;
	
	/** The main view. */
	//views that this view can get to
	private MainMenuView mainView;
	
	/** The all view. */
	private AllLevelsView allView;

	/**
	 * Create the frame.
	 */
	public PlayMenuView(Model model) {
		this.model = model;
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	public void initialize(){
		//setup frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 250, 205));
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		//setup lightning button
		lightning = new JButton("");
		lightning.setName("lightning");
		lightning.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lightning.setBackground(new Color(100, 149, 237));
		lightning.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/LightningLevelIcon.png")));
		lightning.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		lightning.addActionListener(new PlayMenuController(this, model));
		
//		setup puzzle button
		setPuzzle(new JButton(""));
		getPuzzle().setName("puzzle");
		getPuzzle().addActionListener(new PlayMenuController(this, model));
		getPuzzle().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getPuzzle().setBackground(new Color(205, 92, 92));
		getPuzzle().setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/PuzzleLevelIcon.png")));
		getPuzzle().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
//		setup release button
		release = new JButton("");
		release.setName("release");
		release.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		release.setBackground(new Color(244, 164, 96));
		release.addActionListener(new PlayMenuController(this, model));
		release.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/ReleaseLevelIcon.png")));
		release.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));

//		setup Lightning JLabel
		JLabel lblNewLabel = new JLabel("Lightning");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
//		setup Puzzle JLabel
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setForeground(new Color(205, 92, 92));
		lblPuzzle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
//		setup Release JLabel
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setForeground(new Color(244, 164, 96));
		lblRelease.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
//		setup new JPanel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		
//		setup group layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(lightning, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(74)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(getPuzzle(), GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(lblPuzzle)))
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(release, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(116))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRelease)
							.addGap(149))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 979, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblPuzzle)
						.addComponent(lblRelease))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lightning, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(release, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPuzzle(), GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(108))
		);
//		setup JLabel for PLAY
		JLabel lblNewLabel_1 = new JLabel("PLAY");
		lblNewLabel_1.setForeground(new Color(255, 250, 205));
		lblNewLabel_1.setBackground(new Color(255, 250, 205));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		
//		setup back button
		back = new JButton("");
		back.setName("back");
		back.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		back.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/BackIcon.png")));
		back.setForeground(new Color(255, 250, 205));
		back.setBackground(new Color(107, 142, 35));
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 8));
		back.addActionListener(new PlayMenuController(this, model));
		
//		setup group layout
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(312)
					.addComponent(lblNewLabel_1))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap())
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
	 * Gets the all levels view.
	 *
	 * @return the all levels view
	 */
	public AllLevelsView getAllLevelsView() {
		return allView;
	}

	/**
	 * Sets the all levels view.
	 *
	 * @param allView
	 *            the new all levels view
	 */
	public void setAllLevelsView(AllLevelsView allView) {
		this.allView = allView;
	}

	/**
	 * Gets the puzzle.
	 *
	 * @return the puzzle
	 */
	public JButton getPuzzle() {
		return puzzle;
	}

	/**
	 * Sets the puzzle.
	 *
	 * @param puzzle
	 *            the new puzzle
	 */
	public void setPuzzle(JButton puzzle) {
		this.puzzle = puzzle;
	}
}
