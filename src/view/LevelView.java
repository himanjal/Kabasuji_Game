/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Kabasuji.PieceType;
import model.Level;
import model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.util.Timer;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Controller.BoardController;
import Controller.BullpenController;
import Controller.LevelController;

import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JScrollPane;

/**
 * @author Alex Guerra & Himanjal
 *
 */

public class LevelView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The timer. */
	//Lightning Timer attributes
	private Timer timer = new Timer();
	
	/** The counter view. */
	private JTextField counterView;
	
	/**
	 * Gets the counter label.
	 *
	 * @return the counter label
	 */
	public JTextField getCounterLabel(){return getCounterView();}
	
	/** The text field. */
	private //textfields for release sets
	JTextField textField;
	
	/** The text field_1. */
	private JTextField textField_1;
	
	/** The text field_2. */
	private JTextField textField_2;
	
	/** The counter. */
	//general attributes, except for release, used for moves and seconds
	private int counter;
	
	/** The cur count. */
	private int curCount;
	
	/** The all view. */
	//views that this view can get to
	private AllLevelsView allView;
	
	/** The back. */
	private //buttons in this view
	JButton back;
	
	/** The level. */
	//model of the level to get stats from
	private Level level;
	
	/** The model. */
	private Model model;
	
//	LevelController levelController;

	/**
	 * Create the frame.
	 */
	
	
	public LevelView(Model model, Level level) {
		this.setModel(model);
		this.setLevel(level);
		this.counter = level.getCounter();
		this.curCount = level.getCurCount();
		initialize();
	}
	
	/**
	 * Initialize.
	 */
	public void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 250, 205));
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		
		//Lightning color 100, 149, 237
		//Puzzle color 240, 128, 128
		//Release color 244, 164, 96
		JLabel timeLabel = new JLabel("LABLE:");
		if(getLevel().getType() == PieceType.LIGHTNING){
			timeLabel.setText("TIME :");
			timeLabel.setForeground(new Color(100, 149, 237));
		}
		if(getLevel().getType() == PieceType.PUZZLE){
			timeLabel.setText("MOVES :");
			timeLabel.setForeground(new Color(240, 128, 128));
		}
		if(getLevel().getType() == PieceType.RELEASE){
			timeLabel.setText("SETS :");
			timeLabel.setForeground(new Color(244, 164, 96));
		}
		timeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		
		//counter textfield for lightning and puzzle levels, hidden in release levels
		setCounterView(new JTextField());
		counterView.setName("counter");
		if(level.getType() == PieceType.RELEASE)
			getCounterView().setVisible(false);
		if(level.getType() == PieceType.LIGHTNING)
			getCounterView().setBackground(new Color(65, 105, 225));
		if(level.getType() == PieceType.PUZZLE)
			getCounterView().setBackground(new Color(205, 92, 92));
		getCounterView().setEditable(false);
		getCounterView().setForeground(new Color(255, 250, 205));
		getCounterView().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getCounterView().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		getCounterView().setColumns(10);
		getCounterView().setText("" + (getCounter() - getCurCount()));
		counterView.getDocument().addDocumentListener(new LevelController(this, model));
		
		//reset area for release levels, hidden for lightning and puzzle levels
		setTextField(new JTextField());
		getTextField().setEditable(false);
		getTextField().setForeground(new Color(255, 250, 205));
		getTextField().setBackground(new Color(205, 92, 92));
		getTextField().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getTextField().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		getTextField().setColumns(10);
		textField.getDocument().addDocumentListener(new LevelController(this, model));
		
		setTextField_1(new JTextField());
		getTextField_1().setForeground(new Color(255, 250, 205));
		getTextField_1().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		getTextField_1().setEditable(false);
		getTextField_1().setColumns(10);
		getTextField_1().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getTextField_1().setBackground(new Color(65, 105, 225));
		textField_1.getDocument().addDocumentListener(new LevelController(this, model));
		
		setTextField_2(new JTextField());
		getTextField_2().setForeground(new Color(255, 250, 205));
		getTextField_2().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		getTextField_2().setEditable(false);
		getTextField_2().setColumns(10);
		getTextField_2().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getTextField_2().setBackground(new Color(34, 139, 34));
		textField_2.getDocument().addDocumentListener(new LevelController(this, model));
		
		if(level.getType() != PieceType.RELEASE){
			getTextField().setVisible(false);
			getTextField_1().setVisible(false);
			getTextField_2().setVisible(false);
		}
		
		//start timer for lightning levels
//		getTimer().cancel();
		setCurCount(0);
		setTimer(new Timer());
		if(level.getType() == PieceType.LIGHTNING)
			getTimer().schedule(new LevelController(this, getModel()), 0, 1000);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(timeLabel)
					.addGap(5)
					.addComponent(getCounterView(), GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTextField_2(), GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(timeLabel))
						.addComponent(getCounterView(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getTextField_2(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentX(0.0f);
		panel_2.setAlignmentY(0.0f);
		//Lightning color 100, 149, 237
		//Puzzle color 240, 128, 128
		//Release color 244, 164, 96
		if(getLevel().getType() == PieceType.LIGHTNING)
			panel_2.setBackground(new Color(100, 149, 237));
		else if(getLevel().getType() == PieceType.PUZZLE)
			panel_2.setBackground(new Color(240, 128, 128));
		else if(getLevel().getType() == PieceType.RELEASE)
			panel_2.setBackground(new Color(244, 164, 96));
		
		BoardView boardView = new BoardView(level.getBoard());
		BullpenView bullpenView = new BullpenView(level.getBullpen());
		boardView.setSize(new Dimension(80, 80));
		bullpenView.setSize(new Dimension(200, 400));
		
		
		BoardController boardController = new BoardController(level.getBoard(), boardView);
		boardView.addMouseListener(boardController);
		BullpenController bullpenController = new BullpenController(level.getBullpen(), bullpenView);
		boardView.addMouseMotionListener(boardController);
		bullpenView.addMouseListener(bullpenController);
		level.getBoard().setBp(level.getBullpen());
		level.getBoard().setPt(level.getType());
		level.getBoard().setBpc(bullpenController);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension (750, 300));
		scrollPane.setViewportView(bullpenView);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(150);


		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
								.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))))
					.addGap(110))
		);
		
		JLabel lblLevel = new JLabel("LEVEL " + getLevel().getNumber());
		lblLevel.setForeground(new Color(255, 250, 205));
		lblLevel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		
		JLabel lblNewLabel = new JLabel("");
		if(level.getStars() >= 1)
			lblNewLabel.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
		else
			lblNewLabel.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		
		JLabel label = new JLabel("");
		if(level.getStars() >= 2)
			label.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
		else
			label.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		
		JLabel label_1 = new JLabel("");
		if(level.getStars() == 3)
			label_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
		else
			label_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		
		//setup back button
		setBack(new JButton(""));
		getBack().setName("back");
		//set button listener depending on the level type
		getBack().addActionListener(new LevelController(this, getModel()));
		getBack().setMargin(new Insets(0, 0, 0, 0));
		getBack().setAlignmentY(0.0f);
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().setIcon(new ImageIcon(LevelView.class.getResource("/Images/BackIcon.png")));
		//Lightning dark color 65, 105, 225
		//puzzle dark color 205, 92, 92
		//release dark 210, 105, 30
		if(level.getType() == PieceType.RELEASE)
			getBack().setBackground(new Color(210, 105, 30));
		if(level.getType() == PieceType.LIGHTNING)
			getBack().setBackground(new Color(65, 105, 225));
		if(level.getType() == PieceType.PUZZLE)
			getBack().setBackground(new Color(205, 92, 92));
				
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(7)
					.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(301)
					.addComponent(lblLevel)
					.addGap(282)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(label)
					.addGap(5)
					.addComponent(label_1)
					.addGap(73))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(lblLevel))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(label_1))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		//panel_2.setLayout(gl_panel_2);   HEINEMAN - PUT BACK IN
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Refresh.
	 */
	public void refresh(){
		initialize();
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
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Gets the cur count.
	 *
	 * @return the cur count
	 */
	public int getCurCount() {
		return curCount;
	}

	/**
	 * Sets the cur count.
	 *
	 * @param curCount
	 *            the new cur count
	 */
	public void setCurCount(int curCount) {
		this.curCount = curCount;
	}

	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 *
	 * @param counter
	 *            the new counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Gets the timer.
	 *
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Sets the timer.
	 *
	 * @param timer
	 *            the new timer
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
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

	/**
	 * Gets the counter view.
	 *
	 * @return the counter view
	 */
	public JTextField getCounterView() {
		return counterView;
	}

	/**
	 * Sets the counter view.
	 *
	 * @param counterView
	 *            the new counter view
	 */
	public void setCounterView(JTextField counterView) {
		this.counterView = counterView;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Gets the text field.
	 *
	 * @return the text field
	 */
	public //textfields for release sets
	JTextField getTextField() {
		return textField;
	}

	/**
	 * Sets the text field.
	 *
	 * @param textField
	 *            the new text field
	 */
	public void setTextField(//textfields for release sets
	JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Gets the text field_1.
	 *
	 * @return the text field_1
	 */
	public JTextField getTextField_1() {
		return textField_1;
	}

	/**
	 * Sets the text field_1.
	 *
	 * @param textField_1
	 *            the new text field_1
	 */
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	/**
	 * Gets the text field_2.
	 *
	 * @return the text field_2
	 */
	public JTextField getTextField_2() {
		return textField_2;
	}

	/**
	 * Sets the text field_2.
	 *
	 * @param textField_2
	 *            the new text field_2
	 */
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

}
