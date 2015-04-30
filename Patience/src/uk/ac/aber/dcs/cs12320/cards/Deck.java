package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> mCards; 
	private int mNumCardsInPlay; 
	
	
	
	/**
	 * This constructor will build a deck of 52 cards
	 * 1 card for each in a pack of playing cards 
	 * it will then sort the deck based on the name of the suit 
	 * Ace -> King
	 */
	public Deck(){
		
		//Initialise the deck 
		mCards = new ArrayList<Card>();
		
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
	 * Draws a card to be put into the game
	 */
	public void drawNextCard(){
		
		//get number of cards in play
		updateNumCardsInPlay();
		//change type to be drawn
		reverseFace(mNumCardsInPlay);
		
		
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
			if(this.mCards.get(i).isCardInPlay() == true){
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
