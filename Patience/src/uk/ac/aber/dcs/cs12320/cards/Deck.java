package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> mCards; 
	private int mNumCardsInPlay; 
	
	public Deck(){
		
		mCards = new ArrayList<Card>();
		
		for (Card.Suit suit : Card.Suit.values()) {
			for(Card.Value value : Card.Value.values()){
				mCards.add(new Card(suit, value));
			}
		}
		
	}
	
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
	
	public int getNumCardsInPlay(){
		
		return mNumCardsInPlay;
	}

}
