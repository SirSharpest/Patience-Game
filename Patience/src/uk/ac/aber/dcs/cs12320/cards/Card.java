/**
 * 
 */
package uk.ac.aber.dcs.cs12320.cards;

/**
 * @author Nathan
 *
 */


public class Card {

	public enum Suit { HEARTS, CLUBS, DIAMONDS, SPADES;}
	public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX,
						SEVEN, EIGHT, NINE, TEN, JACK, 
						QUEEN, KING;}
	
	final Suit suit; 
	final Value value; 
	
	/**
	 * Public constructor which assigns the values 
	 * as a constant with the keyword 'final' 
	 */
	public Card (final Suit suit, final Value value){
		
		this.suit = suit; 
		this.value = value; 
		
	}
	
	/**
	 * Just an updated toString method 
	 * @Override 
	 */
	public String toString(){
		return suit.name()+"-"+value.name();
	}
	
	/**
	 * Gets file name realitive to the card 
	 */
	public String getImageLocation(){
		
		String firstPart = null; 
		String secondPart = null; 
		
		switch (suit) {
		case HEARTS:
			//
			break;
		case DIAMONDS:
			//
			break;
		case SPADES:
			//
			break;
		case CLUBS:
			//
			break;
		default:
			break;
		}
		
		switch (value) {
		case ACE:
			//
			break;
		case TWO:
			//
			break;
		case THREE:
			//
			break;
		case FOUR:
			//
			break;
		case FIVE:
			//
			break;
		case SIX:
			//
			break;
		case SEVEN:
			//
			break;
		case EIGHT:
			//
			break;
		case NINE:
			//
			break;
		case TEN:
			//
			break;
		case JACK:
			//
			break;
		case QUEEN:
			//
			break;
		case KING:
			//
			break;
		default:
			break;
		}
		
		return ""; 
	}
	
	
	
	
	
}
