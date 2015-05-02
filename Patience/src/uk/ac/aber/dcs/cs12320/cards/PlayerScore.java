package uk.ac.aber.dcs.cs12320.cards;


/**
 * This is a class that will hold a player and their score of the game
 * @author nathan
 *
 */
public class PlayerScore implements Comparable<PlayerScore>{

	
	private int mNumPilesAtEnd; 
	private String mPlayerName; 
	
	public PlayerScore(String name, int pilesLeft){
		this.mNumPilesAtEnd = pilesLeft;
		this.mPlayerName = name;
	}

	/**
	 * @return the mNumPilesAtEnd
	 */
	public int getmNumPilesAtEnd() {
		return mNumPilesAtEnd;
	}

	/**
	 * @param mNumPilesAtEnd the mNumPilesAtEnd to set
	 */
	public void setmNumPilesAtEnd(int mNumPilesAtEnd) {
		this.mNumPilesAtEnd = mNumPilesAtEnd;
	}

	/**
	 * @return the mPlayerName
	 */
	public String getmPlayerName() {
		return mPlayerName;
	}

	/**
	 * @param mPlayerName the mPlayerName to set
	 */
	public void setmPlayerName(String mPlayerName) {
		this.mPlayerName = mPlayerName;
	}

	/**
	 * Compares based on integers to find best score
	 */
	@Override
	public int compareTo(PlayerScore otherScore) {
		return Integer.compare(mNumPilesAtEnd, otherScore.mNumPilesAtEnd);
	}
	
	/**
	 * @return the player's name and score
	 */
	@Override
	public String toString(){
		return this.mPlayerName + " : " + this.mNumPilesAtEnd;
	}
	
}
