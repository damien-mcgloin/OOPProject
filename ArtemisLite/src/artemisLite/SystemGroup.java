/**
 * Class represents a system group of squares in the ArtemisLite game.
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
public class SystemGroup {

	private SystemName name;

	private List<Square> squares = new ArrayList<Square>();

	/**
	 * Constructor with argument for name.
	 * 
	 * @param name
	 */
	public SystemGroup(SystemName name) {
		this.name = name;
	}

	/**
	 * Returns a list of squares in the system group.
	 * 
	 * @return squares in system group
	 */
	public List<Square> getSquares() {
		return squares;
	}

	/**
	 * Sets the squares in the system group.
	 * 
	 * @param squares
	 */
	public void setSquares(List<Square> squares) {
		this.squares = squares;
	}

	/**
	 * Returns the name of the system group.
	 * 
	 * @return name of system group
	 */
	public SystemName getName() {
		return name;
	}

	/**
	 * Sets the name of the system group.
	 * 
	 * @param name
	 */
	public void setName(SystemName name) {
		this.name = name;
	}

	/**
	 * Adds a square to the system group.
	 * 
	 * @param newSquare
	 */
	public void addSquare(Square newSquare) {
		squares.add(newSquare);
	}

}
