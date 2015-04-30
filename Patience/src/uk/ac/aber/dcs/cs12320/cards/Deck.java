package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<PlayingCard> mCards; 
	private int mNumCardsInPlay; 
	
	/**
	 * This constructor will build a deck of 52 cards
	 * 1 card for each in a pack of playing cards 
	 * it will then sort the deck based on the name of the suit 
	 * Ace -> King
	 */
	public Deck(){
		
		//Initialise the deck 
		mCards = new ArrayList<PlayingCard>();
		
		//Loop through the enums of Card class 
		//assign each one to a new position in the card pack
		for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
			for(PlayingCard.Value value : PlayingCard.Value.values()){
				mCards.add(new PlayingCard(suit, value));
			}
		}
		
		//Once deck is created, sort by suit 
		this.sortDeck();
		
	}
	
	/**
	 * Scans through the deck and returns a ArrayList 
	 * of any and all cards which have been set to "inPlay" 
	 * @return activeCards - cards which are in the game currently
	 */
	public ArrayList<String> printActiveCards(){
		
		ArrayList<String> activeCards = new ArrayList<String>(); 
		
		for (int i = 0; i < this.mCards.size(); i++) {
			if(this.mCards.get(i).isCardInPlay() == true){
				activeCards.add(mCards.get(i).toString());
				
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
