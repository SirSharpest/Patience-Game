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

	
	private ArrayList<JButton> buttons; 
	
	public ButtonListener() {
		
	}
	
	public void setButtonsToListen(ArrayList<JButton> buttonsToListen){
		this.buttons = buttonsToListen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//button 1 handle 
		if(e.getSource() == buttons.get(0)){
			PatienceGame.printDeck();
			
		}
		
		//button 2 handle 
		if(e.getSource() == buttons.get(1)){
			PatienceGame.shuffleDeck();
		}
		
		//button 3 handle 
		if(e.getSource() == buttons.get(2)){
			PatienceGame.drawCard();
		}
		
		//button 4 handle 
		if(e.getSource() == buttons.get(3)){
			PatienceGame.moveOntoPrevious();
		}
		
		//button 5 handle 
		if(e.getSource() == buttons.get(4)){
			PatienceGame.moveOnto2Previous();
		}
		
		//button 6 handle 
		if(e.getSource() == buttons.get(5)){
			PatienceGame.amalgamate();
		}
		
		//button 7 handle 
		if(e.getSource() == buttons.get(6)){
			System.out.println("7");
		}
		
		//button 8 handle 
		if(e.getSource() == buttons.get(7)){
			System.out.println("8");
		}
		
		//button 9 handle 
		if(e.getSource() == buttons.get(8)){
			PatienceGame.printScores();
		}
		
		//button 10 handle 
		if(e.getSource() == buttons.get(9)){
			System.out.println("10");
		}
		
		//button 11 handle 
		if(e.getSource() == buttons.get(10)){
			System.exit(0);
		}
		

		
	}

}