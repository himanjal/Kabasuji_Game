/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;

import Controller.AchievementController;
import model.Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Jetro
 *
 */
public class AchievementView extends JFrame {
	
	/**
	 * Gets the reset badges.
	 *
	 * @return the reset badges
	 */
	public JButton getResetBadges() {
		return resetBadges;
	}

	/**
	 * Sets the reset badges.
	 *
	 * @param resetBadges
	 *            the new reset badges
	 */
	public void setResetBadges(JButton resetBadges) {
		this.resetBadges = resetBadges;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The back. */
	private //buttons in this view
	JButton back;
	
	/** The reset badges. */
	JButton resetBadges;
	
	/** The main view. */
	//view I can get to from this view
	MainMenuView mainView;
	
	/** The model. */
	Model model;

	/**
	 * Create the frame.
	 */
	public AchievementView(Model model) {
		this.model = model;
		initialize();
	}
	
	/**
	 * 
	 */
	public void initialize(){
		//setup the frame
		getContentPane().setBackground(new Color(255, 250, 205));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 89));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		
		//setup badge 1
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setToolTipText(model.getBadge(1).getName() + "- "+ model.getBadge(1).getDescription());
		if (model.getBadge(1).getAchieved()){
			lblNewLabel.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Electric Shock 2.png")));
		}
		else{
			lblNewLabel.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		//setup badge 2
		JLabel label = new JLabel("New label");
		label.setToolTipText(model.getBadge(2).getName() + "- "+model.getBadge(2).getDescription());
		if (model.getBadge(2).getAchieved()){
			label.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Thunderbird.png")));
		}
		else{
			label.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		//setup badge 3
		JLabel label_1 = new JLabel("New label");
		label_1.setToolTipText(model.getBadge(3).getName() + "- "+model.getBadge(3).getDescription());
		if (model.getBadge(3).getAchieved()){
			label_1.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Lightning God.png")));
		}
		else{
			label_1.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		//setup badge 4
		JLabel label_2 = new JLabel("New label");
		label_2.setToolTipText(model.getBadge(4).getName() + "- "+model.getBadge(4).getDescription());
		if (model.getBadge(4).getAchieved()){
			label_2.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Bird.png")));
		}
		else{
			label_2.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		//setup badge 5
		JLabel label_3 = new JLabel("New label");
		label_3.setToolTipText(model.getBadge(5).getName() + "- "+model.getBadge(5).getDescription());
		if (model.getBadge(5).getAchieved()){
			label_3.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Eagle.png")));
		}
		else{
			label_3.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
//		if (model.getBadge(6).getAchieved()){
//			label_4.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Sword and Shield.png")));
//		}
//		else{
//			label_4.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
//		}
//		if (model.getBadge(7).getAchieved()){
//			label_5.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Baseball.PNG")));
//		}
//		else{
//			label_5.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
//		}
//		if (model.getBadge(8).getAchieved()){
//			label_6.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Joker.png")));
//		}
//		else{
//			label_6.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
//		}
//		if (model.getBadge(9).getAchieved()){
//			label_7.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Wizard.png")));
//		}
//		else{
//			label_7.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
//		}
		
		//setup badge 10
		JLabel label_8 = new JLabel("New label");
		label_8.setToolTipText(model.getBadge(10).getName() + "- "+model.getBadge(10).getDescription());
		if (model.getBadge(10).getAchieved()){
			label_8.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/Sage.png")));
		}
		else{
			label_8.setIcon(new ImageIcon(AchievementView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		//setup reset badges button
		resetBadges = new JButton("Reset Badges");
		resetBadges.setName("reset");
		resetBadges.addActionListener(new AchievementController(this, model));
		
		//setup the group layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(184)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(191)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(135)))
					.addGap(111))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(resetBadges)
					.addGap(153))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(resetBadges)
					.addGap(41))
		);
		
		//setup the back button
		setBack(new JButton(""));
		getBack().setName("back");
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().setIcon(new ImageIcon(AchievementView.class.getResource("/Images/BackIcon.png")));
		getBack().setBackground(new Color(255, 204, 0));
		getBack().setFont(new Font("Tahoma", Font.BOLD, 8));
		getBack().addActionListener(new AchievementController(this, model));
		
		//title label
		JLabel lblBadges = new JLabel("BADGES");
		lblBadges.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		lblBadges.setForeground(new Color(255, 250, 205));
		
		//ribbon panel
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(249)
					.addComponent(lblBadges)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBadges)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
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
	public //buttons in this view
	JButton getBack() {
		return back;
	}

	/**
	 * Sets the back.
	 *
	 * @param back
	 *            the new back
	 */
	public void setBack(//buttons in this view
	JButton back) {
		this.back = back;
	}
}
