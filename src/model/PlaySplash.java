/*
 * 
 */
package model;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.PlaySplashController;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/**
 * The Class PlaySplash.
 */
public class PlaySplash {
	
	/** The timer. */
	private Timer timer;
	
	/** The frame. */
	private JFrame frame;

    /**
	 * Instantiates a new play splash.
	 *
	 * @param model
	 *            the model
	 */
    public PlaySplash(Model model) {
        setFrame(new JFrame());
        getFrame().getContentPane().add(new ImagePanel());
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setUndecorated(true);
        getFrame().pack();
        getFrame().setLocationRelativeTo(null);
        getFrame().setBackground(new Color(0, 0, 0, 0));
        getFrame().setVisible(true);
        setTimer(new Timer());
        getTimer().schedule(new PlaySplashController(this, model), 4000, 10);
    }

    /**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
    public JFrame getFrame() {
		return frame;
	}

	/**
	 * Sets the frame.
	 *
	 * @param frame
	 *            the new frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
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
	 * The Class ImagePanel.
	 */
	@SuppressWarnings("serial")
    public class ImagePanel extends JPanel {

        /** The img. */
        BufferedImage img;

        /**
		 * Instantiates a new image panel.
		 */
        public ImagePanel() {
            setOpaque(false);
            setLayout(new GridBagLayout());
            try {
                img = ImageIO.read(new File("src/Images/PlaySplash.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        /* (non-Javadoc)
         * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        /* (non-Javadoc)
         * @see javax.swing.JComponent#getPreferredSize()
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(960, 540);
        }
    }
}
