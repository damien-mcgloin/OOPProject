/**
 * This class represents a dice object in the ArtemisLite game.
 */
package artemisLite;

import java.util.Random;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class Dice {

	// private member vars 
	private int numOfSides;
	private int numOfDice;
	private int dice;
	private int diceTotal;
	
	/**
	 * Default constructor.
	 */
	public Dice() {
	}

	/**
	 * Constructor with args.
	 * 
	 * @param numOfSides
	 * @param numOfDice
	 * @param dice
	 * @param diceTotal
	 */
	public Dice(int numOfSides, int numOfDice, int dice, int diceTotal) {

		this.numOfSides = numOfSides;
		this.numOfDice = numOfDice;
		this.dice = dice;
		this.diceTotal = diceTotal;
	}

	/**
	 * Returns the number of sides of the die.
	 * 
	 * @return number of sides of die
	 */
	public int getNumOfSides() {
		return numOfSides;
	}

	/**
	 * Sets the number of sides of the die.
	 * 
	 * @param numOfSides 
	 */
	public void setNumOfSides(int numOfSides) {
		this.numOfSides = numOfSides;
	}

	/**
	 * Returns the number of dice.
	 * 
	 * @return number of dice
	 */
	public int getNumOfDice() {
		return numOfDice;
	}

	/**
	 * Sets the number of dice.
	 * 
	 * @param numOfDice
	 */
	public void setNumOfDice(int numOfDice) {
		this.numOfDice = numOfDice;
	}

	/**
	 * Returns the dice.
	 * 
	 * @return dice
	 */
	public int getDice() {
		return dice;
	}

	/**
	 * Sets the dice.
	 * 
	 * @param dice
	 */
	public void setDice(int dice) {
		this.dice = dice;
	}

	/**
	 * Returns the dice total.
	 * 
	 * @return dice total
	 */
	public int getDiceTotal() {
		return diceTotal;
	}

	/**
	 * Sets the dice total.
	 * 
	 * @param diceTotal
	 */
	public void setDiceTotal(int diceTotal) {
		this.diceTotal = diceTotal;
	}

	/**
	 * Rolls a single dice by returning a random number.
	 * (number will vary based on number of sides of the dice)
	 * 
	 * @return dice total
	 */
	public int rollDice() {
		
				Random myDiceRoll = new Random();

				int diceTotal = myDiceRoll.nextInt(numOfSides) + 1;
				
				return diceTotal;

		}
	}