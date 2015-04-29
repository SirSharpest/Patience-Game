package uk.ac.aber.dcs.cs12320.cards;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.ArrayList;



import java.util.Collections;

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
		
		//Printing menu once initially 
		printMenu();
		
		updateCards();
		
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
			
			
			//display & render the game to the screen
			renderWindow();

			
		}
		
	}
	
	
	/**
	 * This function will print the menu options for the 
	 * player 
	 */
	public static void printMenu(){
		System.out.println("Hello there");
		System.out.println("Click the button relating to \nthe option you want to take");
		System.out.println("---");
		System.out.println("1.  Print the pack of cards");
		System.out.println("2.  Shuffle pack");
		System.out.println("3.  Deal a card");
		System.out.println("4.  Move last pile onto previous one");
		System.out.println("5.  Move last pile over 2 previous piles");
		System.out.println("6.  Almalgamate piles");
		System.out.println("7.  Play for me once");
		System.out.println("8.  Play for me many times");
		System.out.println("9.  Display lowest pack sizes");
		System.out.println("10. Control text display");
		System.out.println("11. Quit");
	}
	
	/**
	 * Game logic will be handled here 
	 * based on what is received through the @handleInput() 
	 */
	private static void updateCards(){
		mCardStrings = mDeck.printActiveCards();
	}
	
	/**
	 * Everything here will be drawn to the screen 
	 */
	private static void renderWindow(){
		
		//update what to draw
		//updateCards();
		//Draw to the window
		mWindow.cardDisplay(mCardStrings);
		
		//Used to determine the need of the scroll bar on bottom of jFrame
		mWindow.setCanvasPreferredSize(new Dimension(mDeck.getNumCardsInPlay() * 73, 300));
		
	}
	
	public static void shuffleDeck(){
		Collections.shuffle(mCardStrings);
		Collections.shuffle(mCardStrings);
	
	}
	
	public static void main(String args[]) {
		
		startGame(); 

	}

}

