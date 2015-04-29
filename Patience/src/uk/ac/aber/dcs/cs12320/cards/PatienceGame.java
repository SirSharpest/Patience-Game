package uk.ac.aber.dcs.cs12320.cards;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.ArrayList;

import uk.ac.aber.dcs.cs12320.cards.gui.Window;

public class PatienceGame {
	
	private static ArrayList<String> mCardStrings; 
	
	private static boolean mGameIsRunning; 
	
	private static Window mWindow; 
	
	private static Deck mDeck; 
		

	
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
		mDeck = new Deck();
		
		//Setup custom output stream
		PrintStream printStream = new PrintStream(mWindow.getTextAreaStream());
		System.setErr(printStream);
		System.setOut(printStream);
		
		//Printing menu once initally 
		printMenu();
		
		//Drop into the game loop 
		while(mGameIsRunning){
			
			//Consume less CPU by sleeping a slight amount 
			//Hopefully will not affect player, unless they 
			//have computer cat like reflexes
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
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
	 * This function will print the menu options for the 
	 * player 
	 */
	private static void printMenu(){
		System.out.println("Hello there");
		System.out.println("Click the button relating to \nthe option you want to take");
		System.out.println("---");
		System.out.println("1. Print the pack of cards");
		System.out.println("2. Shuffle pack");
		System.out.println("3. Deal a card");
		System.out.println("4. Move last pile onto previous one");
		System.out.println("5. Move last pile over 2 previous piles");
		System.out.println("6. ");
	}
	
	/**
	 * Game logic will be handled here 
	 * based on what is received through the @handleInput() 
	 */
	private static void performLogic(){
		mCardStrings = mDeck.printActiveCards();
	}
	
	/**
	 * Everything here will be drawn to the screen 
	 */
	private static void renderWindow(Window window){
		
		//Used to determine the need of the scroll bar on bottom of jFrame
		window.setCanvasPreferredSize(new Dimension(mDeck.getNumCardsInPlay() * 73, 300));
		
		//Draw example to the window
		window.cardDisplay(mCardStrings);
	
		
	}
	
	
	public static void main(String args[]) {
		
		startGame(); 

	}
	
}
