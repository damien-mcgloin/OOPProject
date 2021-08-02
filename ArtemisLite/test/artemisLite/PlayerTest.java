package artemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
class PlayerTest {

	// test data
	Player player;
	
	private List<Square> propertiesOwned;
	
	Square propertyToAdd;
	Square propertyToNotAdd;
	
	String name;
	int resources;
	int resourcesToAdd;
	int resourcesToDeduct;
	int position;
	int diceTotal;
	int balance;
	
	
	@BeforeEach
	void setup() {
		name = "validName";
		resources = 300;
		resourcesToAdd = 300;
		resourcesToDeduct = 200;
		position = 5;
		diceTotal = 8;
		
		player = new Player();
		
		propertiesOwned = new ArrayList<Square>();
		
	}

	@Test
	void testPlayerDefaultConstructor() {
		assertNotNull(player);
	}

	@Test
	void testPlayerConsructorWithArgs() {
		Player player2 = new Player(name, resources, position);
		
		assertEquals(name, player2.getName());
		assertEquals(resources, player2.getResources());
		assertEquals(position, player2.getPosition());
	}

	@Test
	void testMovePosition() {
		position = position + diceTotal;
		
		assertEquals(13, position);
	}

	@Test
	void testAddResources() {
		resources = resources + resourcesToAdd;
		
		assertEquals(600, resources);
	}

	@Test
	void testDeductResources() {
		balance = resources - resourcesToDeduct;
		
		assertEquals(100, balance);	
	}
	
	@Test
	void testAddPropertyValid() {	
		if (!propertiesOwned.contains(propertyToAdd)) {
			propertiesOwned.add(propertyToAdd);
		} 
		
		assertEquals(propertyToAdd, propertiesOwned.get(0));
	}
	
	@Test
	void testAddPropertyInvalid() {
		
		propertiesOwned.add(propertyToNotAdd);
		
		if (!propertiesOwned.contains(propertyToNotAdd)) {
			propertiesOwned.add(propertyToNotAdd);
		} 
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			assertEquals(propertyToAdd, propertiesOwned.get(1));
		});
		
	}

	@Test
	void testGetSetPropertiesOwned() {
		player.setPropertiesOwned(propertiesOwned);
		
		assertNotNull(propertiesOwned);
	}

	@Test
	void testGetSetName() {
		player.setName(name);
		
		assertEquals(name, player.getName());
	}

	@Test
	void testGetSetResources() {
		player.setResources(resources);
		
		assertEquals(resources, player.getResources());
	}

	@Test
	void testGetSetPosition() {
		player.setPosition(position);
		
		assertEquals(position, player.getPosition());
	}

}
