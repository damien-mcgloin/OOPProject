package artemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
class DiceTest {
	
	// Test data
	Dice diceExample = new Dice();
	int numOfSides; 
	int numOfDice;
	int dice;
	int diceTotal, diceTotal2;
	int die1, die2;
	
	@BeforeEach
	void setup() {
		numOfSides = 3;
		numOfDice = 2;
		dice = 4;
		diceTotal = 8;
		diceTotal2 = die1 + die2;
	}
	

	@Test
	void testDiceDefaultConstructor() {
		assertNotNull(diceExample);
	}

	@Test
	void testDiceConstructorWithArgs() {
		Dice diceExample2 = new Dice(numOfSides, numOfDice, dice, diceTotal);
		
		assertEquals(numOfSides, diceExample2.getNumOfSides());
		assertEquals(numOfDice, diceExample2.getNumOfDice());
		assertEquals(dice, diceExample2.getDice());
		assertEquals(diceTotal, diceExample2.getDiceTotal());
	}

	@Test
	void testGetSetNumOfSides() {
		diceExample.setNumOfSides(numOfSides);
		assertEquals(numOfSides, diceExample.getNumOfSides());
	}

	@Test
	void testGetSetNumOfDice() {
		diceExample.setNumOfDice(numOfDice);
		assertEquals(numOfDice, diceExample.getNumOfDice());
	}

	@Test
	void testGetSetDice() {
		diceExample.setDice(dice);
		assertEquals(dice, diceExample.getDice());
	}

	@Test
	void testGetSetDiceTotal() {
		diceExample.setDiceTotal(diceTotal);
		assertEquals(diceTotal, diceExample.getDiceTotal());
	}
	
}
