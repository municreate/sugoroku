package game;

import java.util.Random;

public class Dice {

	Random rand = new Random();

	private int diceNumber;

	public int getDice() {
		diceNumber = 0;
		diceNumber = rand.nextInt(6) + 1;
		return diceNumber;
	}

	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}

	public int getDiceNumber() {
		return diceNumber;
	}
}
