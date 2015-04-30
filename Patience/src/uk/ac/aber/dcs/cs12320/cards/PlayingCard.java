package uk.ac.aber.dcs.cs12320.cards;



public class PlayingCard extends Card {

	
	public enum Suit { HEARTS, CLUBS, DIAMONDS, SPADES;}
	public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX,
						SEVEN, EIGHT, NINE, TEN, JACK, 
						QUEEN, KING;}
	
	final Suit mSuit; 
	final Value mValue; 
	
	public PlayingCard (final Suit suit, final Value value){
		
		this.mSuit = suit; 
		this.mValue = value; 
		super.setName(getImageName());
		
	}
	
	/**
	 * Comparing for sorting a deck by suit
	 * @param cardToCompare
	 * @return
	 */
	@Override
	public int compareTo(Card cardToCompare) {
		
		return mSuit.name().compareToIgnoreCase(((PlayingCard) cardToCompare).getSuit().name());
		
	}
	
	public Suit getSuit(){
		return this.mSuit;
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


	
}
