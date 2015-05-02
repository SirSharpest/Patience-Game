package uk.ac.aber.dcs.cs12320.cards;


import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> mCards; 
	private ArrayList<FaceUpCard> mFaceupCards;
	private int mNumCardsInPlay; 
	private int mNumCardsDrawn; 
	private boolean mDeckHasBeenShuffled; 
	
	
	
	
	
	/**
	 * This constructor will build a deck of 52 cards
	 * 1 card for each in a pack of playing cards 
	 * it will then sort the deck based on the name of the suit 
	 * Ace -> King
	 */
	public Deck(){
		
		//Initialise the deck 
		mCards = new ArrayList<Card>();
		mFaceupCards = new ArrayList<FaceUpCard>();
		
		//used to count the turns so that no more than 52 cards are drawn in a game 
		mNumCardsDrawn = 0;
		mNumCardsInPlay = 0; 
		
		//set deck flag of shuffled to be false
		mDeckHasBeenShuffled = false; 
		//set deck flag of  can be shuffled to be true
		
		
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
	 * This will return a string builder 
	 * cocatinated string of all the cards in their 
	 * current order 
	 * @return
	 */
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
		
		mFaceupCards.add(new FaceUpCard(mCards.get(mNumCardsDrawn).getSuit(), mCards.get(mNumCardsDrawn).getValue()));
		//increase drawn cards count
		mNumCardsDrawn++;

	}
	
	/**
	 * Will swap two cards and then remove one
	 * @param oldIndex
	 * @param newIndex
	 * @return boolean value indicating if this worked or was allowed
	 */
	public boolean replaceCard(int oldIndex, int newIndex){
		
		//Cannot perform if out of bounds
		if(oldIndex < 1 || newIndex < 0){
			return false; 
		}
		
		//if they are the same suit or the same value
		if(mFaceupCards.get(oldIndex).equals(mFaceupCards.get(newIndex))){
			Collections.swap(mFaceupCards, oldIndex, newIndex);
			mFaceupCards.remove(oldIndex);
			return true; 
		}
		
		return false; 
		
	}
	
	
	/**
	 * Update the number of cards that are in play
	 */
	private void updateNumCardsInPlay(){
		mNumCardsInPlay = mFaceupCards.size();
	}
	
	/**
	 * Scans through the deck and returns a ArrayList 
	 * of any and all cards which have been set to "inPlay" 
	 * @return activeCards - cards which are in the game currently
	 */
	public ArrayList<String> printActiveCards(){
		
		ArrayList<String> activeCards = new ArrayList<String>(); 
		
		for (int i = 0; i < this.mFaceupCards.size(); i++) {
				activeCards.add(mFaceupCards.get(i).getImageName());
				
		}
		return activeCards;
	}
	
	/**
	 * Gets the number of cards to be drawn on the screen
	 * @return numCardsInPlay
	 */
	public int getNumCardsInPlay(){
		
		updateNumCardsInPlay();
		return mNumCardsInPlay;
	}
	
	/**
	 * sort all cards by suit 
	 */
	public void sortDeck(){
		Collections.sort(mCards);
	}
	
	/**
	 * This will allow the game to perform a movement of one card
	 * onto the previous one, covering it 
	 */
	public boolean moveOntoPrevious(){
		
		if(replaceCard(mFaceupCards.size()-1, mFaceupCards.size()-2)){
			return true; 
		}
		else{
			return false; 
		}
	}
	
	/**
	 * This makes the movement of twice onto 
	 * @return
	 */
	public boolean moveOnto2Previous(){
		if(replaceCard(mFaceupCards.size()-1, mFaceupCards.size()-4)){
			return true; 
		}
		else{
			return false; 
		}
	}
	
	
	/**
	 * Amalgamates 2moves into one
	 */
	public void amalgamate(){
		int origin = mFaceupCards.size() -1; 
		int firstSwap = mFaceupCards.size() -4;
		int secondSwap = mFaceupCards.size() -5; 
		
		Collections.swap(mFaceupCards, origin, firstSwap);
		Collections.swap(mFaceupCards, firstSwap, secondSwap);
		
		
		mFaceupCards.remove(origin);
		mFaceupCards.remove(firstSwap);
		
	}
		
	
	
	/**
	 * Fixes and corrects the locations of each faceup card
	 */
	public void sortLocations(){
		

	}
	

}
