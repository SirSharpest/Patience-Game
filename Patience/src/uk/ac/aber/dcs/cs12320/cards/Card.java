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
	
	final private Suit mSuit; 
	final private Value mValue; 
	
	
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
	 * Gets file name relative to the card 
	 */
	public String getImageName(){
		
		String firstPart = null; 
		String secondPart = null; 
		
		//case to determine the suit of the card
		switch (mSuit) {
		case HEARTS:
			secondPart = "h";
			break;
		case DIAMONDS:
			secondPart = "d";
			break;
		case SPADES:
			secondPart = "s";
			break;
		case CLUBS:
			secondPart = "c";
			break;
		default:
			break;
		}
		
		//case to determine the value of the card 
		switch (mValue) {
		case ACE:
			firstPart = "a";
			break;
		case TWO:
			firstPart = "2";
			break;
		case THREE:
			firstPart = "3";
			break;
		case FOUR:
			firstPart = "4";
			break;
		case FIVE:
			firstPart = "5";
			break;
		case SIX:
			firstPart = "6";
			break;
		case SEVEN:
			firstPart = "7";
			break;
		case EIGHT:
			firstPart = "8";
			break;
		case NINE:
			firstPart = "9";
			break;
		case TEN:
			firstPart = "t";
			break;
		case JACK:
			firstPart = "j";
			break;
		case QUEEN:
			firstPart = "q";
			break;
		case KING:
			firstPart = "k";
			break;
		default:
			break;
		}
		
		//the result of adding the parts of the file names 
		return firstPart + secondPart; 
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