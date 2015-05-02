package uk.ac.aber.dcs.cs12320.cards;


import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import uk.ac.aber.dcs.cs12320.cards.gui.Window;

public class PatienceGame {
	
	
	private static boolean mGameIsRunning; 
	
	private static Window mWindow; 
	
	private static Deck mDeck; 
	
	private static ArrayList<PlayerScore> mLowScores; 
	
	
	/**
	 * This function calls everything needed for 
	 * the game to run
	 */
	private static void startGame() {
		
		
		
		//perform the set up of a game here
		//create a deck of cards and shuffle them 
		mGameIsRunning = true; 
		mWindow = new Window(); 

		mDeck = new Deck();
		
		//Setup custom output stream
		PrintStream printStream = new PrintStream(mWindow.getTextAreaStream());
		System.setErr(printStream);
		System.setOut(printStream);
		
		//load scores
		mLowScores = new ArrayList<PlayerScore>();
		readHighScores();
		
		//Printing menu once initially 
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
	 * Everything here will be drawn to the screen 
	 */
	private static void renderWindow(){
		
		//Draw to the window
		mWindow.cardDisplay(mDeck.printActiveCards());
		
		//Used to determine the need of the scroll bar on bottom of jFrame
		mWindow.setCanvasPreferredSize(new Dimension(mDeck.getNumCardsInPlay() * 75, 300));
		
	}
	
	/**
	 * Will shuffle the card deck
	 * or tell the user that it cannot be
	 */
	public static void shuffleDeck(){
		if(mDeck.getNumCardsDrawn() <= 0 && !mDeck.getShuffleStatus()){
			mDeck.shuffleDeck();
			mWindow.infoBox("Deck has been shuffled", "Success");
		}
		else{
			mWindow.infoBox("Sorry cannot shuffle at this time", "Error");
		}
		
		
	}
	
	public static void main(String args[]) {
		
		startGame(); 

	}
	
	public static void drawCard(){
		
		//if more cards than in the deck have been drawn then
		//don't draw anymore 
		if(mDeck.getNumCardsDrawn() <= 51){
			mDeck.drawNextCard();
		}
		else{
			System.out.println("No more cards to draw!");
		}
		
	}
	
	/**
	 * Prints the deck via a pop up message box
	 */
	public static void printDeck(){
		mWindow.infoBox(mDeck.listDeck(), "Pack contents!");
	}
	
	public static void printScores(){
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < mLowScores.size(); i++) {
			sb.append(i+1);
			sb.append(". ");
			sb.append(mLowScores.get(i).toString());
			sb.append("\n");
		}
		
		mWindow.infoBox(sb.toString(), "Lowest Scores");
	}
	
	/**
	 * Moves the rightmost card onto the previous one
	 */
	public static void moveOntoPrevious(){
		mDeck.moveOntoPrevious();
	}
	
	/**
	 * Moves the rightmost card over 2 cards and onto the 3rd
	 */
	public static void moveOnto2Previous(){
		mDeck.moveOnto2Previous();
	}
	
	/**
	 * Amalgamates 2moves into one
	 */
	public static void amalgamate(){
		mDeck.amalgamate();
	}
	
	/**
	 * This reads in from a text file all of the previous high scores
	 */
	public static void readHighScores(){
		
		// Using try-with-resource (see my slides from session 15)
		try(FileReader fr = new FileReader("scores.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner infile = new Scanner(br)){
			
			//loop three times for top three players 
			for(int i = 0; i < 3; i++ ){
				
				String name = infile.nextLine();
				int score = Integer.parseInt(infile.nextLine());
				
				mLowScores.add(new PlayerScore(name, score));
				
			}
				}

			 catch (FileNotFoundException e) {
			System.err.println("The file: " + " does not exist. Assuming first use and an empty file." +
		                       " If this is not the first use then have you accidentally deleted the file?");
		} catch (IOException e) {
			System.err.println("An unexpected error occurred when trying to open the file " + "scores.txt");
			System.err.println(e.getMessage());
		}
		
		sortScores();
	}
	
	/**
	 * sorts the highscores of the game
	 */
	public static void sortScores(){
		Collections.sort(mLowScores);
	}
	
	

}

