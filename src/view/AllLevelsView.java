/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Controller.AllLevelsController;
import Kabasuji.PieceType;
import model.Model;
import view.PlayMenuView;

/**
 * @author Jetro
 *
 */
public class AllLevelsView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Model model;
	
/** The level1. */
private //	Buttons in the view
	JButton level1;
	
	/** The level2. */
	private JButton level2;
	
	/** The level3. */
	JButton level3;
	
	/** The level4. */
	JButton level4;
	
	/** The level5. */
	JButton level5;
	
	/** The back. */
	private JButton back;
	
	/** Next page button. */
	JButton nextPage;
	
	/** Previous page button. */
	JButton prePage;
	
	/** The lvl view. */
	//views that this view can get to
	private LevelView lvlView;
	
	/** The type. */
	PieceType type;
	
	/** The page. */
	private int page;

	/**
	 * Create the application.
	 */
	public AllLevelsView(Model model, PieceType type) {
		this.type = type;
		this.model = model;
		setPage(1);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//setup frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		if(type == PieceType.LIGHTNING)
			panel.setBackground(new Color(100, 149, 237));
		else if(type == PieceType.PUZZLE)
			panel.setBackground(new Color(240, 128, 128));
		else if(type == PieceType.RELEASE)
			panel.setBackground(new Color(244, 164, 96));
		
		//Lightning color 100, 149, 237
		//Puzzle color 240, 128, 128
		//Release color 244, 164, 96
//		setup previous levels button
		prePage = new JButton("<");
		prePage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		if(page == 1)
			prePage.setEnabled(false);
		else
			prePage.setEnabled(true);
		prePage.setName("previousLevels");
		prePage.addActionListener(new AllLevelsController(this, model));
		prePage.setForeground(new Color(255, 250, 205));
		prePage.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		if(type == PieceType.LIGHTNING)
			prePage.setBackground(new Color(100, 149, 237));
		if(type == PieceType.PUZZLE)
			prePage.setBackground(new Color(240, 128, 128));
		if(type == PieceType.RELEASE)
			prePage.setBackground(new Color(244, 164, 96));
		
//		setup next levels button
		nextPage = new JButton(">");
		if(model.getNumLevels(type) > (5 * page))
			nextPage.setEnabled(true);
		else
			nextPage.setEnabled(false);
		nextPage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nextPage.setName("nextLevels");
		nextPage.addActionListener(new AllLevelsController(this, model));
		nextPage.setForeground(new Color(255, 250, 205));
		nextPage.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		if(type == PieceType.LIGHTNING)
			nextPage.setBackground(new Color(100, 149, 237));
		if(type == PieceType.PUZZLE)
			nextPage.setBackground(new Color(240, 128, 128));
		if(type == PieceType.RELEASE)
			nextPage.setBackground(new Color(244, 164, 96));
		
		JLabel lblNewLabel_1 = new JLabel("");
		JLabel label_1 = new JLabel("");
		JLabel label_2 = new JLabel("");
		setLevel1(new JButton("" + (1 + (5 * (page - 1)))));
		level1.setVisible(false);
		
		//setup level 1 button
		if(model.getNumLevels(type) >= 1 + (5 * (page - 1))){
			setLevel1(new JButton("" + (1 + (5 * (page - 1)))));
			level1.setVisible(true);
			getLevel1().setName("level1");
			if(!model.getLevel(type, (1 + (5 * (page - 1)))).isUnlocked())
				getLevel1().setEnabled(false);
			getLevel1().addActionListener(new AllLevelsController(this, model));
			getLevel1().setIconTextGap(0);
			getLevel1().setIcon(null);
			//Lightning color 100, 149, 237
			//Puzzle color 240, 128, 128
			//Release color 244, 164, 96
			if(type == PieceType.LIGHTNING)
				getLevel1().setBackground(new Color(100, 149, 237));
			else if(type == PieceType.PUZZLE)
				getLevel1().setBackground(new Color(240, 128, 128));
			else if(type == PieceType.RELEASE)
				getLevel1().setBackground(new Color(244, 164, 96));
			getLevel1().setForeground(new Color(255, 250, 205));
			getLevel1().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));

			//level1 star labels
			if(model.getLevel(type, (1 + (5 * (page - 1)))).getStars() >= 1)
				lblNewLabel_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				lblNewLabel_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));

			if(model.getLevel(type, (1 + (5 * (page - 1)))).getStars() >= 2)
				label_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));

			if(model.getLevel(type, (1 + (5 * (page - 1)))).getStars() == 3)
				label_2.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_2.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		JLabel label_11 = new JLabel("");
		JLabel label_3 = new JLabel("");
		JLabel label_4 = new JLabel("");
		setLevel2(new JButton("" + (2 + (5 * (page - 1)))));
		level2.setVisible(false);
		//setup level2 button
		if(model.getNumLevels(type) >= (2 + (5 * (page - 1)))){
			setLevel2(new JButton("" + (2 + (5 * (page - 1)))));
			level2.setVisible(true);
			getLevel2().setName("level2");
			if(!model.getLevel(type, (2 + (5 * (page - 1)))).isUnlocked())
				getLevel2().setEnabled(false);
			getLevel2().addActionListener(new AllLevelsController(this, model));
			getLevel2().setIconTextGap(0);
			getLevel2().setForeground(new Color(255, 250, 205));
			getLevel2().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
			if(type == PieceType.LIGHTNING)
				getLevel2().setBackground(new Color(100, 149, 237));
			else if(type == PieceType.PUZZLE)
				getLevel2().setBackground(new Color(240, 128, 128));
			else if(type == PieceType.RELEASE)
				getLevel2().setBackground(new Color(244, 164, 96));
			
			//level2 star labels
			if(model.getLevel(type, (2 + (5 * (page - 1)))).getStars() >= 1)
				label_11.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_11.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (2 + (5 * (page - 1)))).getStars() >= 2)
				label_3.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_3.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (2 + (5 * (page - 1)))).getStars() == 3)
				label_4.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_4.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		JLabel label_7 = new JLabel("");
		JLabel label_8 = new JLabel("");
		JLabel label_9 = new JLabel("");
		level3 = new JButton("3");
		level3.setVisible(false);
		//setup level3 button
		if(model.getNumLevels(type) >= (3 + (5 * (page - 1)))){
			level3 = new JButton("" + (3 + (5 * (page - 1))));
			level3.setVisible(true);
			level3.setName("level3");
			if(!model.getLevel(type, (3 + (5 * (page - 1)))).isUnlocked())
				level3.setEnabled(false);
			level3.addActionListener(new AllLevelsController(this, model));
			level3.setIconTextGap(0);
			level3.setForeground(new Color(255, 250, 205));
			level3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
			if(type == PieceType.LIGHTNING)
				level3.setBackground(new Color(100, 149, 237));
			else if(type == PieceType.PUZZLE)
				level3.setBackground(new Color(240, 128, 128));
			else if(type == PieceType.RELEASE)
				level3.setBackground(new Color(244, 164, 96));
			
			//level3 labels
			if(model.getLevel(type, (3 + (5 * (page - 1)))).getStars() >= 1)
				label_7.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_7.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (3 + (5 * (page - 1)))).getStars() >= 2)
				label_8.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_8.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (3 + (5 * (page - 1)))).getStars() == 3)
				label_9.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_9.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		JLabel label_12 = new JLabel("");
		JLabel label_13 = new JLabel("");
		JLabel label_14 = new JLabel("");
		level4 = new JButton("4");
		level4.setVisible(false);
		//setup level4 button
		if(model.getNumLevels(type) >= (4 + (5 * (page - 1)))){
			level4 = new JButton("" + (4 + (5 * (page - 1))));
			level4.setVisible(true);
			level4.setName("level4");
			if(!model.getLevel(type, (4 + (5 * (page - 1)))).isUnlocked())
				level4.setEnabled(false);
			level4.addActionListener(new AllLevelsController(this, model));
			level4.setIconTextGap(0);
			level4.setForeground(new Color(255, 250, 205));
			level4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
			if(type == PieceType.LIGHTNING)
				level4.setBackground(new Color(100, 149, 237));
			else if(type == PieceType.PUZZLE)
				level4.setBackground(new Color(240, 128, 128));
			else if(type == PieceType.RELEASE)
				level4.setBackground(new Color(244, 164, 96));
			
			//level4 labels
			if(model.getLevel(type, (4 + (5 * (page - 1)))).getStars() >= 1)
				label_12.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_12.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));

			if(model.getLevel(type, (4 + (5 * (page - 1)))).getStars() >= 2)
				label_13.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_13.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (4 + (5 * (page - 1)))).getStars() == 3)
				label_14.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_14.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		JLabel label_16 = new JLabel("");
		JLabel label_17 = new JLabel("");
		JLabel label_18 = new JLabel("");
		level5 = new JButton("5");
		level5.setVisible(false);
		//setup level5 button
		if(model.getNumLevels(type) >= (5 + (5 * (page - 1)))){
			level5 = new JButton("" + (5 + (5 * (page - 1))));
			level5.setVisible(true);
			level5.setName("level5");
			if(!model.getLevel(type, (5 + (5 * (page - 1)))).isUnlocked())
				level5.setEnabled(false);
			level5.addActionListener(new AllLevelsController(this, model));
			level5.setIconTextGap(0);
			level5.setForeground(new Color(255, 250, 205));
			level5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
			if(type == PieceType.LIGHTNING)
				level5.setBackground(new Color(100, 149, 237));
			else if(type == PieceType.PUZZLE)
				level5.setBackground(new Color(240, 128, 128));
			else if(type == PieceType.RELEASE)
				level5.setBackground(new Color(244, 164, 96));
			
			//level5 labels
			if(model.getLevel(type, (5 + (5 * (page - 1)))).getStars() >= 1)
				label_16.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_16.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		
			if(model.getLevel(type, (5 + (5 * (page - 1)))).getStars() >= 2)
				label_17.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_17.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
			
			if(model.getLevel(type, (5 + (5 * (page - 1)))).getStars() == 3)
				label_18.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
			else
				label_18.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));		
		
//		setup group layout for level 1
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(40)
							.addComponent(level2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(level2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
//		setup panel
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 250, 205));
		
//		setup group Layout for level 2
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(40)
							.addComponent(level3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(level3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 250, 205));
		
//		setup group layout for level 3
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 171, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(40)
							.addComponent(level4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 190, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(level4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 250, 205));
		
//		setup group layout for level 4
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 171, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(40)
							.addComponent(level5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 190, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(level5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(prePage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(113)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(nextPage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(234)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(261, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(prePage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(nextPage, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
//		setup group layout for level 5
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(40)
							.addComponent(level1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(level1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel(type.getName());
		label.setForeground(new Color(255, 248, 220));
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		label.setBackground(Color.BLUE);
		
		setBack(new JButton(""));
		getBack().setIcon(new ImageIcon(AllLevelsView.class.getResource("/Images/BackIcon.png")));
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayMenuView view = new PlayMenuView(model);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.setVisible(true);
				dispose();	
			}
		});
		//Lightning dark color 65, 105, 225
		//puzzle dark color 205, 92, 92
		//release dark 210, 105, 30
		if(type == PieceType.RELEASE)
			getBack().setBackground(new Color(210, 105, 30));
		if(type == PieceType.LIGHTNING)
			getBack().setBackground(new Color(65, 105, 225));
		if(type == PieceType.PUZZLE)
			getBack().setBackground(new Color(205, 92, 92));
		
		getBack().setForeground(new Color(255, 250, 205));
		getBack().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(309)
					.addComponent(label)
					.addGap(383))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Gets the level view.
	 *
	 * @return the level view
	 */
	public LevelView getLevelView() {
		return lvlView;
	}

	/**
	 * Sets the level view.
	 *
	 * @param lvlView
	 *            the new level view
	 */
	public void setLevelView(LevelView lvlView) {
		this.lvlView = lvlView;
	}
	
	/**
	 * Gets the level type.
	 *
	 * @return the level type
	 */
	public PieceType getLevelType(){
		return type;
	}

	/**
	 * Gets the level1.
	 *
	 * @return the level1
	 */
	public //	Buttons in the view
	JButton getLevel1() {
		return level1;
	}

	/**
	 * Sets the level1.
	 *
	 * @param level1
	 *            the new level1
	 */
	public void setLevel1(//	Buttons in the view
	JButton level1) {
		this.level1 = level1;
	}

	/**
	 * Gets the level2.
	 *
	 * @return the level2
	 */
	public JButton getLevel2() {
		return level2;
	}

	/**
	 * Sets the level2.
	 *
	 * @param level2
	 *            the new level2
	 */
	public void setLevel2(JButton level2) {
		this.level2 = level2;
	}

	/**
	 * Gets the back.
	 *
	 * @return the back
	 */
	public JButton getBack() {
		return back;
	}

	/**
	 * Sets the back.
	 *
	 * @param back
	 *            the new back
	 */
	public void setBack(JButton back) {
		this.back = back;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page
	 *            the new page
	 */
	public void setPage(int page) {
		this.page = page;
	}
}
