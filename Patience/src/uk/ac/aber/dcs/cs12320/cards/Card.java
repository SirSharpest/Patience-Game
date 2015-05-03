/**
 * 
 */
package uk.ac.aber.dcs.cs12320.cards;



/**
 * @author Nathan
 *
 */


public abstract class Card implements Comparable<Card> {

	public enum Suit { HEARTS, CLUBS, DIAMONDS, SPADES;}
	public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX,
						SEVEN, EIGHT, NINE, TEN, JACK, 
						QUEEN, KING;}
	
	private final Suit mSuit; 
	private final Value mValue; 
	
	
	/**
	 * Public constructor which assigns the values 
	 * as a constant with the keyword 'final' 
	 */
	public Card (final Suit suit, final Value value){
		
		this.mSuit = suit; 
		this.mValue = value; 	
	}
	

	
	
	/**
	 * Just an updated toString method 
	 * @Override 
	 */
	public String toString(){
		return mSuit.name()+"-"+mValue.name();
	}
	


	/**
	 * Comparing for sorting a deck by suit
	 * @param cardToCompare
	 * @return
	 */
	@Override
	public int compareTo(Card cardToCompare) {
		
		return mSuit.name().compareToIgnoreCase(cardToCompare.mSuit.name());

	}

	/**
	 * @return the mSuit
	 */
	public Suit getSuit() {
		return mSuit;
	}

	/**
	 * @return the mValue
	 */
	public Value getValue() {
		return mValue;
	}



	/**
	 * Checks if suit or value of another card matches 
	 * @param 
	 */
	public boolean equals(Card other) { 
		
		if(this.mSuit.toString().equals(other.getSuit().toString())){
			return true;
		}
		if(this.mValue.toString().equals(other.getValue().toString())){
			return true;
		}
		//If neither of these then return false 
		return false;
	}
	
	
	
	
	
}