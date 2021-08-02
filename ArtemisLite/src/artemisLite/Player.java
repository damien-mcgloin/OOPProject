/**
 * Class represents a player in the ArtemisLite game.
 */
package artemisLite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class Player {

	
	// private member vars 
	private String name;
	private int resources;
	private int position;
	private List<Square> propertiesOwned = new ArrayList<Square>();

	/**
	 * Default constructor
	 */
	public Player() {

	}

	/**
	 * Constructor with arguments
	 * 
	 * @param name
	 * @param resources
	 * @param position
	 */
	public Player(String name, int resources, int position) {
		super();
		this.name = name;
		this.resources = resources;
		this.position = position;
	}
	
	/**
	 * Updates the players position.
	 * 
	 * @param diceTotal
	 */
	public void movePosition(int diceTotal) {
		position = position + diceTotal;
	}


	/**
	 * Adds to player's research tokens.
	 * 
	 * @param resourcesToAdd
	 */
	public void addResources(int resourcesToAdd) {
		resources = resources + resourcesToAdd;
	}

	/**
	 * Deducts from player's research tokens.
	 * 
	 * @param resourcesToDeduct
	 */
	public void deductResources(int resourcesToDeduct) {
		int balance;
		balance = resources - resourcesToDeduct;
		if (balance <= 0) {
			resources=0;
			Game.gameOngoing = false;
		} else {
			resources = balance;
		}
	}

	/**
	 * Adds a square to player's owned squares.
	 * 
	 * @param propertyToAdd
	 */
	public void addProperty(Square propertyToAdd) {
		if (!propertiesOwned.contains(propertyToAdd)) {
			propertiesOwned.add(propertyToAdd);
		} else {
			//player already owns this property
		}
		
	}

	/**
	 * Returns a list of all Squares player is in charge of.
	 * 
	 * @return list of squares player owns
	 */
	public List<Square> getPropertiesOwned() {
		return propertiesOwned;
	}

	/**
	 * Sets the list of squares that a player owns.
	 * 
	 * @param propertiesOwned
	 */
	public void setPropertiesOwned(List<Square> propertiesOwned) {
		this.propertiesOwned = propertiesOwned;
	}
	
	/**
	 * Returns the name of the player.
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the player.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the player's resources.
	 * 
	 * @return player resources
	 */
	public int getResources() {
		return resources;
	}

	/**
	 * Sets the player's resources
	 * 
	 * @param resources
	 */
	public void setResources(int resources) {
		this.resources = resources;
	}

	/**
	 * Returns the player's position on the board.
	 * 
	 * @return player position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the player's pposition on the board.
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
}
