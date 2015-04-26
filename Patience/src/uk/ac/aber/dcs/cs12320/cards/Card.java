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
	
	
	
	
	
	
}
