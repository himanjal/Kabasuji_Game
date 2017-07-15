/*
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CreditController;
import model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Jetro
 *
 */
public class CreditView extends JFrame {

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
	public CreditView(Model model) {
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
		
		JLabel lblCredits = new JLabel("CREDITS\r\n");
		lblCredits.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		
//		setup back button
		setBack(new JButton(""));
		getBack().setName("back");
		getBack().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getBack().setIcon(new ImageIcon(CreditView.class.getResource("/Images/BackIcon.png")));
		getBack().setFont(new Font("Tahoma", Font.BOLD, 8));
		getBack().setBackground(new Color(169, 169, 169));
		getBack().addActionListener(new CreditController(this,model));
		
//		setup group layout
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(312)
					.addComponent(lblCredits)
					.addContainerGap(384, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCredits, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(getBack(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
//		setup the label (JLabel)
		JLabel lbl1 = new JLabel("By: Georgios Ardamerinos, Xavier Jackson, Saraj Pirasmepulkul,");
		lbl1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		
		JLabel lbl2 = new JLabel("Alex Guerra, Anne Harris, Himanjal Sharma\r\n");
		lbl2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
					.addGap(439))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(439, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(272, Short.MAX_VALUE))
		);
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
