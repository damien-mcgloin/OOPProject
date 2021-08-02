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
class SquareTest {

	// test data
	Player player;
	Player player2;
	Player player3;
	Player player4;
	Player owner;

	Square square;
	Square square2;

	String name;
	SquareType squareType;
	SquareType squareType2;
	int priceToAcquire;
	int[] priceOfRent = new int[5];
	int priceToDevelop;
	int priceToMajorDevelop;
	int numOfDevelopments;
	int numOfDevelopments2;
	SystemName system;

	@BeforeEach
	void setup() {
		name = "validName";
		priceToAcquire = 200;
		priceOfRent = new int[] {100, 200, 300, 400, 500};
		priceToDevelop = 100;
		priceToMajorDevelop = 200;
		numOfDevelopments = 2;
		numOfDevelopments2 = 3;

		square = new Square(name, squareType.GOVERNMENT_GRANT);
		square2 = new Square(name, squareType2.EXTERNAL_INVESTIGATION, priceToAcquire, priceOfRent, priceToDevelop,
				priceToMajorDevelop, numOfDevelopments, player, system);

		player2 = new Player("validName1", 200, 1);
		player3 = new Player("validName2", 50, 1);
		player4 = new Player("validName3", 200, 1);
		owner = new Player("validName3", 200, 1);

	}

	@Test
	void testSquareNameTypeConstructor() {
		assertEquals(name, square.getName());
		assertEquals(squareType.GOVERNMENT_GRANT, square.getSquareType());
	}

	@Test
	void testSquareConstructorWithAllArgs() {
		assertEquals(name, square2.getName());
		assertEquals(squareType2.EXTERNAL_INVESTIGATION, square2.getSquareType());
		assertEquals(priceToAcquire, square2.getPriceToAcquire());
		assertEquals(priceOfRent, square2.getPriceOfRent());
		assertEquals(priceToDevelop, square2.getPriceToDevelop());
		assertEquals(priceToMajorDevelop, square2.getPriceToMajorDevelop());
		assertEquals(numOfDevelopments, square2.getNumOfDevelopments());
		assertEquals(player, square2.getOwner());
		assertEquals(system, square2.getSystem());
	}

	@Test
	void testGetSetName() {
		square.setName(name);
		assertEquals(name, square.getName());
	}

	@Test
	void testGetSetSquareType() {
		square.setSquareType(squareType.PURCHASABLE);
		assertEquals(squareType.PURCHASABLE, square.getSquareType());
	}

	@Test
	void testGetSetPriceToAcquire() {
		square.setPriceToAcquire(priceToAcquire);
		assertEquals(priceToAcquire, square.getPriceToAcquire());
	}

	@Test
	void testGetSetPriceOfRent() {
		square.setPriceOfRent(priceOfRent);
		assertEquals(priceOfRent, square.getPriceOfRent());
	}

	@Test
	void testGetPriceToDevelop() {
		square.setPriceToDevelop(priceToDevelop);
		assertEquals(priceToDevelop, square.getPriceToDevelop());
	}

	@Test
	void testGetSetPriceToMajorDevelop() {
		square.setPriceToMajorDevelop(priceToMajorDevelop);
		assertEquals(priceToMajorDevelop, square.getPriceToMajorDevelop());
	}

	@Test
	void testIncreaseNumOfDevelopments() {
		numOfDevelopments+=1;
		assertEquals(numOfDevelopments, 3);
	}

	@Test
	void testGetSetOwner() {
		square.setOwner(owner);
		assertEquals(owner, square.getOwner());
	}

	@Test
	void testGetSetSystem() {
		square.setSystem(system.ARTEMIS_GENERATION_SPACESUITS);
		assertEquals(system.ARTEMIS_GENERATION_SPACESUITS, square.getSystem());
	}

	@Test
	void testLandedOnWithEnoughResources() {
		
		int balance = 200;

		if (player2.getResources() < priceOfRent[numOfDevelopments]) {

			owner.addResources(player2.getResources());
			balance-=player2.getResources();

		} else {

			owner.addResources(priceOfRent[numOfDevelopments]);
			balance-=(priceOfRent[numOfDevelopments]);

		}

		assertEquals(0, balance);
		assertEquals(400, owner.getResources());

	}


	@Test
	void testDevelopSuccess() {

		int balance = 200;
		
		if (numOfDevelopments < 3) {

			numOfDevelopments += 1;
			balance -= priceToDevelop;

		} else if (numOfDevelopments2 == 3) {

			numOfDevelopments += 1;
			balance -= priceToMajorDevelop;

		} 
		
		assertEquals(3, numOfDevelopments);
		assertEquals(100, balance);

	}
	
	@Test
	void testMajorDevelop() {
		
		int balance = 400;
		
		if (numOfDevelopments2 < 3) {

			numOfDevelopments2 += 1;
			balance -= priceToDevelop;

		} else if (numOfDevelopments2 == 3) {

			numOfDevelopments2 += 1;
			balance -= priceToMajorDevelop;

		}
	
		assertEquals(4, numOfDevelopments2);
		assertEquals(200, balance);

	}
}
