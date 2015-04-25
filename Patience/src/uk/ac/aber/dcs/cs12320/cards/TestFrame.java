package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

import uk.ac.aber.dcs.cs12320.cards.gui.TheFrame;

public class TestFrame {
	public static void main(String args[]) {
		TheFrame frame = new TheFrame();
		ArrayList<String> cardStrings = new ArrayList<String>();
		cardStrings.add("3h.gif");
		cardStrings.add("tc.gif");
		cardStrings.add("js.gif");
		cardStrings.add("4d.gif");
		frame.cardDisplay(cardStrings);
	}
}
