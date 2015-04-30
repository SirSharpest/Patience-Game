/**
 * 
 */
package uk.ac.aber.dcs.cs12320.cards;

/**
 * @author Nathan
 *
 */


public abstract class Card implements Comparable<Card> {


	private boolean mIsInPlay; 
	private String mName; 
	
	/**
	 * Public constructor which assigns the values 
	 * as a constant with the keyword 'final' 
	 */
	public Card (){

		this.mIsInPlay = true; 
		this.mName = null;
	}
	
	/**
	 * Tells the class that the card is currently in play
	 * and needs drawn to screen
	 * 
	 * @param cardStatus
	 */
	public void setCardInPlay(boolean cardStatus){
		this.mIsInPlay = cardStatus;
	}
	
	/**
	 * Provides the boolean that states the status of the card 
	 * @return mIsInPlay 
	 */
	public boolean isCardInPlay(){
		return this.mIsInPlay;
	}
	
	/**
	 * Just an updated toString method 
	 * @Override 
	 */
	public String toString(){
		return mName;
	}
	
	public void setName(String newName){
		this.mName = newName;
	}
	

	/**
	 * Comparing for sorting a card by Name
	 * @param cardToCompare
	 * @return
	 */
	@Override
	public int compareTo(Card cardToCompare) {
		
		return mName.compareToIgnoreCase(cardToCompare.mName);
		
	}
	
	
	
	
}
