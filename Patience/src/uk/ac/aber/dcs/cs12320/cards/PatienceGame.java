package uk.ac.aber.dcs.cs12320.cards;


import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
	
	/**
	 * Starts the program
	 * @param args
	 */
	public static void main(String args[]) {
		
		startGame(); 

	}
	
	/**
	 * Draws a card if possible for the user
	 */
	public static void drawCard(){
		
		//if more cards than in the deck have been drawn then
		//don't draw anymore 
		if(mDeck.getNumCardsDrawn() <= 51){
			mDeck.drawNextCard();
		}
		else{
			mWindow.infoBox("No more cards to draw", "Error");
		}
		
	}
	
	/**
	 * Prints the deck via a pop up message box
	 */
	public static void printDeck(){
		mWindow.infoBox(mDeck.listDeck(), "Pack contents!");
	}
	
	/**
	 * Prints a list of the top scorers to the 
	 * user 
	 */
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
		if(!mDeck.moveOntoPrevious()){
			mWindow.infoBox("Illegal move", "Error");
		}
	}
	
	/**
	 * Moves the rightmost card over 2 cards and onto the 3rd
	 */
	public static void moveOnto2Previous(){
		if(!mDeck.moveOnto2Previous()){
			mWindow.infoBox("Illegal move", "Error");
		}
	}
	
	/**
	 * Amalgamates 2moves into one
	 */
	public static void amalgamate(){
		if(!mDeck.amalgamate()){
			mWindow.infoBox("Illegal move", "Error");
		}
	}
	
	/**
	 * This reads in from a text file all of the previous high scores
	 */
	public static void readHighScores(){
		
		// Using try-with-resource (see my slides from session 15)
		try(FileReader fr = new FileReader("scores.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner infile = new Scanner(br)){
			
			int numScores = Integer.parseInt(infile.nextLine());
			
			//loop three times for top three players 
			for(int i = 0; i < numScores; i++ ){
				
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
	
	/**
	 * Called to write lowest scores back to the txt file
	 */
	public static void save(){
		
		if(mDeck.getNumCardsDrawn() == 52){
			int pilesLeft = mDeck.getNumCardsInPlay();
			String name = mWindow.getDialogBoxInput("Add Lowest Score", "Please enter your name for the lowest score"); 
			
			//if the player takes the time to enter in a name
			if(name != null){
				mLowScores.add(new PlayerScore(name, pilesLeft));
			}
		
			}
		try(FileWriter fw = new FileWriter("scores.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter outfile = new PrintWriter(bw);){
				
				outfile.println(mLowScores.size());
			
				for(int i = 0; i < mLowScores.size(); i++){
					outfile.println(mLowScores.get(i).getmPlayerName());
					outfile.println(mLowScores.get(i).getmNumPilesAtEnd());
				}

			} catch (IOException e) {
				System.err.println("Problem when trying to write to file: scores.txt");
			}
	}
	
	/**
	 * this function will play for the user by 
	 * making the largest jump that is possible in a turn,
	 * if no jump is possible then a card will be drawn 
	 * @param times
	 */
	public static void playForMe(int times){
		
		if(times == 0){
			return;
		}
		
		for(int i = 0; i < times; i++){
			if(mDeck.amalgamate()){
				continue;
			}
			else if(mDeck.moveOnto2Previous()){
				continue;
			}
			else if(mDeck.moveOntoPrevious()){
				continue;
			}
			else if(mDeck.getNumCardsDrawn() < 52){
				mDeck.drawNextCard();
				continue;
			}
			else{
				mWindow.infoBox("No suitable moves", "Game over it seems");
			}
		}
		
	}
	
	/**
	 * this will get a number integer value from the user
	 * through the use of a pop up box 
	 * @return
	 */
	public static int getIntInput(){
		String input = mWindow.getDialogBoxInput("Enter a number", "");
		try{
			int num = Integer.parseInt(input);
			return num;
			
		}catch (NumberFormatException e){
			mWindow.infoBox("Invalid Input", "Error");
		}
		return 0;
	}
	
	/**
	 * Displays the current board status 
	 * as text for the user 
	 */
	public static void currentBoardAsTxt(){
		
		mWindow.infoBox(mDeck.listGameBoard(),"Cards in play");
	}

}

