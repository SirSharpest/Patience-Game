package uk.ac.aber.dcs.cs12320.cards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * Extra class used to handle input from the user via button clicks
 * @author nathan
 *
 */
public class ButtonListener implements ActionListener{

	
	private ArrayList<JButton> mButtons; 
	
	public ButtonListener() {
		
	}
	
	/**
	 * Loads in a list of buttons that the listener needs to function 
	 * and apply itself to!
	 * @param buttonsToListen
	 */
	public void setButtonsToListen(ArrayList<JButton> buttonsToListen){
		this.mButtons = buttonsToListen;
	}
	
	/**
	 * Tells the listener what functions to trigger 
	 * if an action occurs 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//button 1 handle 
		if(e.getSource() == mButtons.get(0)){
			PatienceGame.printDeck();
		}
		
		//button 2 handle 
		if(e.getSource() == mButtons.get(1)){
			PatienceGame.shuffleDeck();
		}
		
		//button 3 handle 
		if(e.getSource() == mButtons.get(2)){
			PatienceGame.drawCard();
		}
		
		//button 4 handle 
		if(e.getSource() == mButtons.get(3)){
			PatienceGame.moveOntoPrevious();
		}
		
		//button 5 handle 
		if(e.getSource() == mButtons.get(4)){
			PatienceGame.moveOnto2Previous();
		}
		
		//button 6 handle 
		if(e.getSource() == mButtons.get(5)){
			PatienceGame.amalgamate();
		}
		
		//button 7 handle 
		if(e.getSource() == mButtons.get(6)){
			PatienceGame.playForMe(1);
		}
		
		//button 8 handle 
		if(e.getSource() == mButtons.get(7)){
			PatienceGame.playForMe(PatienceGame.getIntInput());
		}
		
		//button 9 handle 
		if(e.getSource() == mButtons.get(8)){
			PatienceGame.printScores();
		}
		
		//button 10 handle 
		if(e.getSource() == mButtons.get(9)){
			PatienceGame.currentBoardAsTxt();
		}
		
		//button 11 handle 
		if(e.getSource() == mButtons.get(10)){
			PatienceGame.save();
			PatienceGame.printScores();
			System.exit(0);
		}
		

		
	}

}