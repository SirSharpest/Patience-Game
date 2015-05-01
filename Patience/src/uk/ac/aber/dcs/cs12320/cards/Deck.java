package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> mCards; 
	private int mNumCardsInPlay; 
	private int mNumCardsDrawn; 
	private boolean mDeckHasBeenShuffled; 
	private boolean mDeckCanBeShuffled; 
	
	
	
	/**
	 * This constructor will build a deck of 52 cards
	 * 1 card for each in a pack of playing cards 
	 * it will then sort the deck based on the name of the suit 
	 * Ace -> King
	 */
	public Deck(){
		
		//Initialise the deck 
		mCards = new ArrayList<Card>();
		
		//used to count the turns so that no more than 52 cards are drawn in a game 
		mNumCardsDrawn = 0;
		
		//set deck flag of shuffled to be false
		mDeckHasBeenShuffled = false; 
		//set deck flag of  can be shuffled to be true
		mDeckCanBeShuffled = true;
		
		//Loop through the enums of Card class 
		//assign each one to a new position in the card pack
		for (Card.Suit suit : Card.Suit.values()) {
			for(Card.Value value : Card.Value.values()){
				mCards.add(new FaceDownCard(suit, value));
			}
		}
		
		//Once deck is created, sort by suit 
		this.sortDeck();
		
		
		
	}
	
	/**
	 * Returns the answer to if the deck has been shuffled already
	 * @return
	 */
	public boolean getShuffleStatus(){
		return this.mDeckHasBeenShuffled;
	}
	
	/**
	 * Returns the answer to if the deck can be shuffled again
	 * @return
	 */
	public boolean getCanShuffle(){
		return this.mDeckCanBeShuffled;
	}
	public String listDeck(){
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < mCards.size(); i++) {
			sb.append(mCards.get(i).getImageName());
			sb.append(" ");
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Shuffles the deck of cards
	 * and sets boolean flag to true
	 */
	public void shuffleDeck(){
		mDeckHasBeenShuffled = true; 
		Collections.shuffle(mCards);
	}
	
	/**
	 * Gets the number of cards drawn so far
	 * @return mNumCardsDrawn - cards played so far
	 */
	public int getNumCardsDrawn(){
		return this.mNumCardsDrawn;
	}
	
	/**
	 * Draws a card to be put into the game
	 */
	public void drawNextCard(){
		
		//increment the amount of cards drawn 
		mNumCardsDrawn++; 
		
		//get number of cards in play
		updateNumCardsInPlay();
		
		
			//change type to be drawn
			reverseFace(mNumCardsInPlay);
	}
	
	/**
	 * Removes the last card drawn from the screen 
	 * 
	 */
	public void removePreviousCard(){
		
		updateNumCardsInPlay();
		reverseFace(mNumCardsInPlay -1);
	}
	
	
	private void reverseFace(int index){
		
		
		//if it is a FaceDownCard then we reverse it to FaceUp
		if(this.mCards.get(index) instanceof FaceDownCard){
			FaceUpCard tmpCard = new FaceUpCard(mCards.get(index).getSuit(), mCards.get(index).getValue());
			tmpCard.setLocation(0);
			mCards.set(index, tmpCard);	
		}
		
		//if it is a FaceUpCard then we reverse it to FaceDown
		else if(this.mCards.get(index) instanceof FaceUpCard){
			FaceDownCard tmpCard = new FaceDownCard(mCards.get(index).getSuit(), mCards.get(index).getValue());
			mCards.set(index, tmpCard);	
			
		}
		
		
	}
	
	/**
	 * Update the number of cards that are in play
	 */
	private void updateNumCardsInPlay(){
		int counter = 0; 
		
		for(int i = 0; i < mCards.size(); i++){
			if(mCards.get(i) instanceof FaceUpCard){
				counter++;
			}
		}
		
		this.mNumCardsInPlay = counter; 
	}
	
	/**
	 * Scans through the deck and returns a ArrayList 
	 * of any and all cards which have been set to "inPlay" 
	 * @return activeCards - cards which are in the game currently
	 */
	public ArrayList<String> printActiveCards(){
		
		ArrayList<String> activeCards = new ArrayList<String>(); 
		
		for (int i = 0; i < this.mCards.size(); i++) {
			if(this.mCards.get(i) instanceof FaceUpCard){
				activeCards.add(mCards.get(i).getImageName());
				
			}
		}
		
		this.mNumCardsInPlay = activeCards.size();
		return activeCards;
	}
	
	/**
	 * Gets the number of cards to be drawn on the screen
	 * @return numCardsInPlay
	 */
	public int getNumCardsInPlay(){
		
		return mNumCardsInPlay;
	}
	
	/**
	 * sort all cards by suit 
	 */
	public void sortDeck(){
		Collections.sort(mCards);
	}
	
	

}
