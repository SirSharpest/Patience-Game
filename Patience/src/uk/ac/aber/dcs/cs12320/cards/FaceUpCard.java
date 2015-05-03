package uk.ac.aber.dcs.cs12320.cards;

public class FaceUpCard extends Card {

	private String mImageName;
	
	public FaceUpCard(Suit suit, Value value) {
		super(suit, value);
		mImageName = setImageName(suit, value);
	}
	
	public String getImageName(){
		return this.mImageName;
	}
	
	/**
	 * Gets file name relative to the card 
	 */
	private String setImageName(Suit suit, Value value){
		
		String firstPart = null; 
		String secondPart = null; 
		
		//case to determine the suit of the card
		switch (suit) {
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
		switch (value) {
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
