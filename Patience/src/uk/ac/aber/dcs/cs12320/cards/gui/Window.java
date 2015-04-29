package uk.ac.aber.dcs.cs12320.cards.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import uk.ac.aber.dcs.cs12320.cards.ButtonListener;

/**
 * Represents a window on which to draw the cards
 * @author Lynda Thomas (and Chris Loftus)
 * @version 1.1 (5th March 2015)
 *
 */
public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ThePanel canvas;
	private JTextArea textArea; 
	private CustomStream streamTextArea;

	private ArrayList<JButton> buttons;
	private ButtonListener listener; 

	/**
	 * The constructor creates a Frame ready to display the cards
	 */
	public Window() {

		
		
		// Calls the constructor in the JFrame superclass passing up the name to 
		// display in the title
		super("Becky's Patience");
		
		
		//Create customStream object
		streamTextArea = new CustomStream();
		
		// When you click on the close window button the window will be closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// This has North, East, South, West and Center positions for components
		setLayout(new BorderLayout());

		// This is what we will draw on (see the inner class below)
		canvas = new ThePanel();
		
		//This is the max size I expect it to ever be
		canvas.setPreferredSize(new Dimension(585, 348));
		
		//Text area information
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(300, 860));
		textArea.setEditable(false);
		
		//Button area information
		JPanel buttonPanel = new JPanel(); 
		buttons = new ArrayList<JButton>();
		for(int i = 1; i < 13; i ++){
			JButton tmpButton = new JButton(""+i);
			tmpButton.setPreferredSize(new Dimension(75, 40));;
			buttons.add(tmpButton);
			buttonPanel.add(buttons.get(i-1));
		}
		//setting up listener for buttons
		listener = new ButtonListener();
		listener.setButtonsToListen(buttons);
		for(int i = 0; i < 12; i++){
			buttons.get(i).addActionListener(listener);
		}
		buttonPanel.setPreferredSize(new Dimension(690, 50));
		
		//implementing a scroll pane to the drawing section and 
		//attaching it to the canvas object 
		JScrollPane scrollPane = new JScrollPane(canvas);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Scroll pane for text section
		JScrollPane scrollText = new JScrollPane(textArea);
		scrollText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//screen size
		this.setSize(900, 390);
	
		//adding panels to the screen 
		this.add(scrollText, BorderLayout.EAST);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(scrollPane, BorderLayout.WEST);
		
		//DO NOT EVER RESIZE IT WILL MESS UP 
		//MORE THAN I CARE TO ADMIT OR TRY TO FIX :)
		this.setResizable(false);
		
		

		setVisible(true); // Display the window
	}
	/**
	 * This method allows for the screen to be resized whenever 
	 * called by a sub class with dimensions 
	 * @param size
	 */
	public void setCanvasPreferredSize(Dimension size){
		this.canvas.setPreferredSize(size);
	}
	
	/**
	 * Custom outputstream for text to go to
	 * @return streamTextArea - where to push the text to
	 */
	public OutputStream getTextAreaStream(){
		return this.streamTextArea;
	}
	
	/**
	 * @return the buttons
	 */
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	/**
	 * Displays all cards
	 * 
	 * @param cards
	 *            an arraylist of strings of the form 3h.gif for 3 of hearts
	 */
	public void cardDisplay(ArrayList<String> cards) {
		canvas.cardDisplay(cards);
	}

	/**
	 * Call before cardDisplay at end of game (takes away the unused pile)
	 */
	public void allDone() {
		canvas.allDone();
	}

	// /////////////////////////////////////////////////

	/*
	 * This is an example of an inner class (like Russian dolls)
	 * It private so can only be seen by the outer class. It's part
	 * of the implementation of TheFrame. Because it extends JPanel we
	 * can draw on it
	 */
	private class ThePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ArrayList<String> cards = new ArrayList<String>();
		private Image image;
		private boolean done;

		private ThePanel() {
			setBackground(Color.pink);
			done = false;
		}

		private void cardDisplay(ArrayList<String> c) {
			cards = c;
			repaint();
		}

		private void allDone() {
			done = true;
		}

		/**
		 * This is called automatically by Java when it want to draw this panel.
		 * So we have to put our drawing command in here. 
		 * @param g Is the graphics object on which we draw.
		 */
		@Override
		public void paintComponent(Graphics g) {
			// Always do this. It's giving the JPanel superclass a change to
			// paint its parts before we paint ours. E.g. we don't draw the
			// edge of the window, one of the super-classes does that.
			super.paintComponent(g);
			int x = 20;
			int y = 50;
			// Loop through all the cards get each image in turn
			for (String c : cards) {
				String file = "cards/" + c + ".gif";
				image = Toolkit.getDefaultToolkit().getImage(file);
				g.drawImage(image, x, y, 70, 100, null);
				x += 72;  // The x position is moved on in order to position the next card
				          // This could be improved by having a horizontal scroll bar

			}
			if (!done) {
				// Draws the face-down top card of our pack of cards
				String file = "cards/b.gif";
				image = Toolkit.getDefaultToolkit().getImage(file);
				g.drawImage(image, 100, 152, 70, 100, null);
			}
		}
		

	} // ThePanel inner class
	
	private class CustomStream extends OutputStream{
 
		public  CustomStream() {
			// TODO Auto-generated constructor stub
		}
		
	    @Override
	    public void write(int b) throws IOException {
	        // redirects data to the text area
	        textArea.append(String.valueOf((char)b));
	        // scrolls the text area to the end of data
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	    }
	    
	   
		
	}


} 