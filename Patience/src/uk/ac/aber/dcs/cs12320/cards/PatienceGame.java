package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

import uk.ac.aber.dcs.cs12320.cards.gui.Window;

public class PatienceGame {
	
	private static ArrayList<String> mCardStrings; 
	
	private static boolean mGameIsRunning; 
	
	private static Window mWindow; 
		

	
	/**
	 * This function calls everything needed for 
	 * the game to run
	 */
	private static void startGame() {
		
		//perform the set up of a game here
		//create a deck of cards and shuffle them 
		mGameIsRunning = true; 
		mWindow = new Window(); 
		mCardStrings = new ArrayList<String>();
		
		//Drop into the game loop 
		while(mGameIsRunning){
			
			//get the user input 
			handleInput();
			//perform game logic 
			performLogic();
			//display & render the game to the screen
			renderWindow(mWindow);
			
		}
		
	}
	
	/**
	 * This function will get the user's input from the keyboard
	 * using the scanner class 
	 */
	private static void handleInput(){
		
	}
	
	/**
	 * Game logic will be handled here 
	 * based on what is received through the @handleInput() 
	 */
	private static void performLogic(){
		
	}
	
	/**
	 * Everything here will be drawn to the screen 
	 */
	private static void renderWindow(Window window){
		
		//Draw example to the window
		window.cardDisplay(mCardStrings);
		
	}
	
	
	public static void main(String args[]) {
		
		startGame(); 

	}
	
}
