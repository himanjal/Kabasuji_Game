/*
 * 
 */
package builderView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import builderModel.PieceType;
import builderModel.Level;
import builderModel.Bullpen;
import builderModel.LBModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.util.Timer;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import builderController.BoardController;
import builderController.BullpenController;
import builderController.LevelBuilderController;
import builderController.RsetController;

import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JScrollPane;

/**
 * @author Alex Guerra
 *
 */
public class LevelBuilderView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The timer. */
	//Lightning Timer attributes
	private Timer timer = new Timer();
	
	/** The views. */
	JTextField counterView;
	
	/**
	 * Gets the counter label.
	 *
	 * @return the counter label
	 */
	public JTextField getCounterLabel(){return counterView;}
	
	/** The rsets. */
	RsetView rsets;
	
	/** The counter. */
	//general attributes, except for release, used for moves and seconds
	private int counter;
	
	/** The cur count. */
	private int curCount;
	
	/** The all view. */
	//views that this view can get to
	private AllLevelsView allView;
	
	/** The menu view. */
	private LevelBuilderMenu menuView;
	
	/** The board view. */
	private BoardView boardView;
	
	/** The bullpen view. */
	private BullpenView bullpenView;
	
	/**
	 * Gets the menu view.
	 *
	 * @return the menu view
	 */
	public LevelBuilderMenu getMenuView() {
		return menuView;
	}

	/**
	 * Sets the menu view.
	 *
	 * @param menuView
	 *            the new menu view
	 */
	public void setMenuView(LevelBuilderMenu menuView) {
		this.menuView = menuView;
	}
	
	/**
	 * Gets the board view.
	 *
	 * @return the board view
	 */
	public BoardView getBoardView(){
		return boardView;
	}
	
	/**
	 * Sets the board view.
	 *
	 * @param boardView
	 *            the new board view
	 */
	public void setBoardView(BoardView boardView){
		this.boardView = boardView;
	}
	
	/**
	 * Gets the bullpen view.
	 *
	 * @return the bullpen view
	 */
	public BullpenView getBullpenView(){
		return bullpenView;
	}
	
	/**
	 * Sets the bullpen view.
	 *
	 * @param bullpenView
	 *            the new bullpen view
	 */
	public void setBullpenView(BullpenView bullpenView){
		this.bullpenView = bullpenView;
	}
	

	/** The back. */
 //buttons in this view
	private JButton back;
	
	/** The Clear all. */
	private JButton ClearAll;
	
	/** The Publish. */
	private JButton Publish;

	
	/** The level. */
	//model of the level to get stats from
	private Level level;
	
	/** The model. */
	LBModel model;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 *
	 */
	public LevelBuilderView(LBModel model, Level level, BullpenController bullpenController, LevelBuilderController levelBuilderController, BoardController boardController) {
		this.model = model;
		this.setLevel(level);
		this.counter = level.getCounter();
		this.curCount = level.getCurCount();
		
		initialize();
	}
	
	/**
	 * Instantiates a new level builder view.
	 *
	 * @param model
	 *            the model
	 * @param level
	 *            the level
	 */
	public LevelBuilderView(LBModel model, Level level){
		this.model = model;
		this.setLevel(level);
		this.level.setBullpen(new Bullpen());
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
		JLabel timeLabel = new JLabel("LABEL:");
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
		counterView = new JTextField();
		counterView.setName("counter");
		if(level.getType() == PieceType.RELEASE)
			counterView.setVisible(false);
		if(level.getType() == PieceType.LIGHTNING)
			counterView.setBackground(new Color(65, 105, 225));
		if(level.getType() == PieceType.PUZZLE)
			counterView.setBackground(new Color(205, 92, 92));
		counterView.setEditable(true);
		counterView.setForeground(new Color(255, 250, 205));
		counterView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		counterView.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		counterView.setColumns(10);
		counterView.setText("" + (getCounter() - getCurCount()));
		
		rsets = new RsetView();
		rsets.setBounds(0, 0, 206, 96);
		rsets.setBackground(new Color(255, 250, 205));
		
		
		if(level.getType() != PieceType.RELEASE){
			rsets.setVisible(false);
		}
		
		//start timer for lightning levels

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(timeLabel)
					.addGap(5)
					.addComponent(counterView, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(rsets, GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(timeLabel))
						.addComponent(counterView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(rsets, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addContainerGap())
		);
		GroupLayout gl_rsets = new GroupLayout(rsets);
		gl_rsets.setHorizontalGroup(
			gl_rsets.createParallelGroup(Alignment.LEADING)
				.addGap(0, 206, Short.MAX_VALUE)
		);
		gl_rsets.setVerticalGroup(
			gl_rsets.createParallelGroup(Alignment.LEADING)
				.addGap(0, 36, Short.MAX_VALUE)
		);
		rsets.setLayout(gl_rsets);
		panel.setLayout(gl_panel);
		RsetController rsetController = new RsetController(rsets);
		
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
		rsets.addMouseListener(rsetController);
		
		
		BoardController boardController =new BoardController(level.getBoard(), boardView, rsetController, level);
		boardView.addMouseListener(boardController);
		boardView.addMouseMotionListener(new BoardController(level.getBoard(), boardView, rsetController));
		BullpenController bullpenController = new BullpenController(level.getBullpen(), bullpenView);
		bullpenView.addMouseListener(bullpenController);
		level.getBoard().setBp(level.getBullpen());
		level.getBoard().setPt(level.getType());
		level.getBoard().setBpc(bullpenController);
		
		
		boardView.setDraggingPiece(level.getBullpen().getSelectedPiece());
		level.getBoard().setBp(level.getBullpen());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension (750, 300));
		scrollPane.setViewportView(bullpenView);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(250);
		
		setClearAll(new JButton("Clear All"));
		getClearAll().setName("Clear All");
		getClearAll().addActionListener(new LevelBuilderController(this, model));
		
		setPublish(new JButton("Publish"));
		getPublish().setName("Publish");
		getPublish().addActionListener(new LevelBuilderController(this, model));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ClearAll)
								.addComponent(Publish)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
					.addGap(44))
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(ClearAll)
							.addGap(18)
							.addComponent(Publish))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
					.addGap(110))
		);
		
		JLabel lblLevel = new JLabel("LEVEL " + getLevel().getNumber());
		lblLevel.setForeground(new Color(255, 250, 205));
		lblLevel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		
		JLabel lblNewLabel = new JLabel("");
		if(level.getStars() >= 1)
			lblNewLabel.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/StarIcon.png")));
		else
			lblNewLabel.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/NotStarIcon.png")));
		
		JLabel label = new JLabel("");
		if(level.getStars() >= 2)
			label.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/StarIcon.png")));
		else
			label.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/NotStarIcon.png")));
		
		JLabel label_1 = new JLabel("");
		if(level.getStars() == 3)
			label_1.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/StarIcon.png")));
		else
			label_1.setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/NotStarIcon.png")));
		
		//setup back button
		setBack(new JButton(""));
		getBack().setName("back");
		//set button listener depending on the level type
		getBack().addActionListener(new LevelBuilderController(this, model));
		getBack().setMargin(new Insets(0, 0, 0, 0));
		getBack().setAlignmentY(0.0f);
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().setIcon(new ImageIcon(LevelBuilderView.class.getResource("/Images/BackIcon.png")));
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
	 * Gets the clear all.
	 *
	 * @return the clear all
	 */
	public JButton getClearAll() {
		return ClearAll;
	}

	/**
	 * Sets the clear all.
	 *
	 * @param clearAll
	 *            the new clear all
	 */
	public void setClearAll(JButton clearAll) {
		ClearAll = clearAll;
	}

	/**
	 * Gets the publish.
	 *
	 * @return the publish
	 */
	public JButton getPublish() {
		return Publish;
	}

	/**
	 * Sets the publish.
	 *
	 * @param publish
	 *            the new publish
	 */
	public void setPublish(JButton publish) {
		Publish = publish;
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
	
}
