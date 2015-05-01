package uk.ac.aber.dcs.cs12320.cards;

public class FaceUpCard extends Card {

	private int mLocation; 
	
	public FaceUpCard(Suit suit, Value value) {
		super(suit, value);
		super.setCardInPlay(true);
		
		
	}
	
	/**
	 * Sets where on the board that the card is
	 * @param location
	 */
	public void setLocation(int location){
		this.mLocation = location; 
	}

	/**
	 * Gets the location of the card 
	 * for game logic computation 
	 * @return
	 */
	public int getLocation(){
		return this.mLocation;
	}
}
