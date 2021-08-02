/**
 * Class represents a square in the ArtemisLite game.
 */
package artemisLite;

import java.util.List;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class Square {

	// private member vars
	private String name;
	private SquareType squareType;
	private int priceToAcquire;
	private int[] priceOfRent = new int[5];
	private int priceToDevelop;
	private int priceToMajorDevelop;
	private int numOfDevelopments;
	private Player owner;
	private SystemName system;

	/**
	 * Default constructor
	 */
	public Square() {

	}

	/**
	 * Creates a square with name and squareType.
	 * 
	 * @param name
	 * @param squareType
	 */
	public Square(String name, SquareType squareType) {
		this.name = name;
		this.squareType = squareType;
	}

	/**
	 * Creates a square with all arguments.
	 * 
	 * @param name
	 * @param squareType
	 * @param priceToAcquire
	 * @param priceOfRent
	 * @param priceToDevelop
	 * @param priceToMajorDevelop
	 * @param numOfDevelopments
	 * @param owner
	 * @param system
	 */
	public Square(String name, SquareType squareType, int priceToAcquire, int[] priceOfRent, int priceToDevelop,
			int priceToMajorDevelop, int numOfDevelopments, Player owner, SystemName system) {
		this.name = name;
		this.squareType = squareType;
		this.priceToAcquire = priceToAcquire;
		this.priceOfRent = priceOfRent;
		this.priceToDevelop = priceToDevelop;
		this.priceToMajorDevelop = priceToMajorDevelop;
		this.numOfDevelopments = numOfDevelopments;
		this.owner = owner;
		this.system = system;
	}

	/**
	 * Returns the square name.
	 * 
	 * @return square name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the square name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the square type of the square.
	 * 
	 * @return square type of the square
	 */
	public SquareType getSquareType() {
		return squareType;
	}

	/**
	 * Sets the square type of the square.
	 * 
	 * @param squareType
	 */
	public void setSquareType(SquareType squareType) {
		this.squareType = squareType;
	}

	/**
	 * Returns the price to acquire the square.
	 * 
	 * @return price to acquire square
	 */
	public int getPriceToAcquire() {
		return priceToAcquire;
	}

	/**
	 * Sets the price to acquire the square.
	 * 
	 * @param priceToAcquire
	 */
	public void setPriceToAcquire(int priceToAcquire) {
		this.priceToAcquire = priceToAcquire;
	}

	/**
	 * Returns the price of rent array for the square.
	 * 
	 * @return price of rent array
	 */
	public int[] getPriceOfRent() {
		return priceOfRent;
	}

	/**
	 * Sets the price of rent of the square.
	 * 
	 * @param priceOfRent
	 */
	public void setPriceOfRent(int[] priceOfRent) {
		this.priceOfRent = priceOfRent;
	}

	/**
	 * Returns the price to develop a square.
	 * 
	 * @return price to develop
	 */
	public int getPriceToDevelop() {
		return priceToDevelop;
	}

	/**
	 * Sets the price to develop a square.
	 * 
	 * @param priceToDevelop
	 */
	public void setPriceToDevelop(int priceToDevelop) {
		this.priceToDevelop = priceToDevelop;
	}

	/**
	 * Returns the price to major develop a square.
	 * 
	 * @return price to major develop
	 */
	public int getPriceToMajorDevelop() {
		return priceToMajorDevelop;
	}

	/**
	 * Sets the price to major develop a square.
	 * 
	 * @param priceToMajorDevelop
	 */
	public void setPriceToMajorDevelop(int priceToMajorDevelop) {
		this.priceToMajorDevelop = priceToMajorDevelop;
	}

	/**
	 * Returns the number of developments of a square.
	 * 
	 * @return number of developments
	 */
	public int getNumOfDevelopments() {
		return numOfDevelopments;
	}

	/**
	 * Increases the number of developments of a square.
	 */
	public void increaseNumOfDevelopments() {
		this.numOfDevelopments = numOfDevelopments + 1;
	}

	/**
	 * Returns the owner of the square.
	 * 
	 * @return owner of square
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the square.
	 * 
	 * @param owner
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * Returns the system name of the square.
	 * 
	 * @return system name of square
	 */
	public SystemName getSystem() {
		return system;
	}

	/**
	 * Sets the system name of the square.
	 * 
	 * @param system
	 */
	public void setSystem(SystemName system) {
		this.system = system;
	}

	/**
	 * Method assesses square type, square ownership and player resources and may
	 * provide the player the option to purchase the square or to pay rent to the
	 * owner of the square. Method may also recognise that the player can not afford
	 * the square and call to offerSquare method.
	 * 
	 * @param player
	 */
	public void landedOn(Player player) {
		String playerOption = "";

		switch (this.getSquareType()) {
		case GOVERNMENT_GRANT:
			break;
		case EXTERNAL_INVESTIGATION:
			System.out.println(
					"You've landed in some hot water! A pesky external auditor has been poking around and something in the books isn't quite adding up. "
							+ "\nYour research has been put on hold until the investigation is resolved.");
			break;
		case PURCHASABLE:
			System.out.println("You have landed on " + this.getName() + "!");
			int currentRent = priceOfRent[this.numOfDevelopments];
			for (Player player2 : Game.players) {
				List<Square> systems = player2.getPropertiesOwned();
				for (Square sq : systems) {
					if (this.system.equals(sq.getSystem()) && player2.getName() != player.getName()
							&& this.getOwner() == null) {
						System.out
								.println("\nWarning : This element is in a system owned by " + player2.getName() + ".");
						System.out.println("If all elements are not controlled by the same player it is");
						System.out.println("not possible to develop all systems and win the game\n");
						break;
					}
				}
			}

			if (this.getOwner() == null && player.getResources() > this.getPriceToAcquire()) {
				// there is no owner and the player has sufficient funds

				System.out.println(this.getName() + " is available for purchase for a price of "
						+ this.getPriceToAcquire() + " research tokens. \nYour current balance is "
						+ player.getResources() + " research tokens. \nWould you like to purchase this square? Y/N");

				do {
					playerOption = Game.scanner.next();

					if (playerOption.trim().equalsIgnoreCase("y")) {
						// player decides to buy property
						player.deductResources(this.getPriceToAcquire());
						player.addProperty(this);
						this.setOwner(player);
						System.out.println("You've purchased " + this.getName() + "! \nYour new balance is "
								+ player.getResources() + " research tokens.");

					} else if (playerOption.trim().equalsIgnoreCase("n")) {
						// player decides not to purchase the property

						System.out.println(player.getName() + " does not wish to buy " + this.getName() + ".\n"
								+ this.getName() + " will now be offered to the other players.");
						Player nextPlayerToBeOffered;
						if (Game.players.indexOf(player) + 1 >= Game.players.size()) {
							nextPlayerToBeOffered = Game.players.get(0);
						} else {
							nextPlayerToBeOffered = Game.players.get(Game.players.indexOf(player) + 1);
						}
						do {
							if (nextPlayerToBeOffered.getResources() > this.priceToAcquire) {
								// other player can afford it
								offerSquare(nextPlayerToBeOffered);
								if (Game.players.indexOf(nextPlayerToBeOffered) + 1 >= Game.players.size()) {
									nextPlayerToBeOffered = Game.players.get(0);
								} else {
									nextPlayerToBeOffered = Game.players
											.get(Game.players.indexOf(nextPlayerToBeOffered) + 1);
								}

							} else {
								System.out.println(
										nextPlayerToBeOffered.getName() + " cannot afford to purchase this square.");
								if (Game.players.indexOf(nextPlayerToBeOffered) + 1 >= Game.players.size()) {
									nextPlayerToBeOffered = Game.players.get(0);
								} else {
									nextPlayerToBeOffered = Game.players
											.get(Game.players.indexOf(nextPlayerToBeOffered) + 1);
								}
							}
						} while (this.owner == null && nextPlayerToBeOffered != player);

						// no one bought the square
						if (this.owner == null) {
							System.out.println("No one took charge of " + this.getName()
									+ ". \nIt remains available for purchase");
						}

					} else {
						System.out.println("Invalid input. Please enter Y or N.");
					}
				} while (!playerOption.trim().equalsIgnoreCase("y") && !playerOption.trim().equalsIgnoreCase("n"));

			} else if (this.getOwner() == null && player.getResources() < this.getPriceToAcquire()) {
				// there is no owner but the player has insufficient funds
				System.out.println(this.getName() + " is available for purchase for a price of "
						+ this.getPriceToAcquire() + " research tokens. \nYour current balance is "
						+ player.getResources() + " research tokens. \nYou do not have sufficient funds. \n"
						+ this.getName() + " will now be offered to the other players.");

				Player nextPlayerToBeOffered;
				if (Game.players.indexOf(player) + 1 >= Game.players.size()) {
					nextPlayerToBeOffered = Game.players.get(0);
				} else {
					nextPlayerToBeOffered = Game.players.get(Game.players.indexOf(player) + 1);
				}
				do {
					if (nextPlayerToBeOffered.getResources() >= this.priceToAcquire) {
						// other player can afford it
						offerSquare(nextPlayerToBeOffered);
						if (Game.players.indexOf(nextPlayerToBeOffered) + 1 >= Game.players.size()) {
							nextPlayerToBeOffered = Game.players.get(0);
						} else {
							nextPlayerToBeOffered = Game.players.get(Game.players.indexOf(nextPlayerToBeOffered) + 1);
						}

					} else {
						if (Game.players.indexOf(nextPlayerToBeOffered) + 1 >= Game.players.size()) {
							nextPlayerToBeOffered = Game.players.get(0);
						} else {
							nextPlayerToBeOffered = Game.players.get(Game.players.indexOf(nextPlayerToBeOffered) + 1);
						}
					}
				} while (this.owner == null && nextPlayerToBeOffered != player);

				// no one bought the square
				if (this.owner == null) {
					System.out.println(
							"No one took charge of " + this.getName() + ". \nIt remains available for purchase");
				}

			} else {
				// the property is already owned
				if (this.owner != player) {
					System.out.println(this.getName() + " is owned by " + this.getOwner().getName()
							+ ". \nThe rent on this property is " + currentRent
							+ " resource tokens. \nYour current balance is " + player.getResources()
							+ " resource tokens. " + this.getOwner().getName() + " would you like to charge rent? Y/N");
					do {
						playerOption = Game.scanner.next();

						if (playerOption.trim().equalsIgnoreCase("y")) {
							// owner decides to charge rent

							if (player.getResources() < currentRent) {
								// the player cannot afford the rent

								owner.addResources(player.getResources());
								player.deductResources(player.getResources());
								System.out.println(this.owner.getName() + " has decided to charge rent. \n"
										+ player.getName()
										+ " you have been made bankrupt! \nGame Over!\nThe Artemis Project has failed...");
								Game.gameOngoing = false;
							} else {
								// the player can afford the rent

								owner.addResources(currentRent);
								player.deductResources(currentRent);
								System.out.println(this.owner.getName() + " has decided to charge rent. \n"
										+ player.getName() + " your new balance is " + player.getResources());
							}

						} else if (playerOption.trim().equalsIgnoreCase("n")) {
							// owner decides not to charge rent

							System.out.println(this.owner.getName() + " has decided not to charge rent. \n"
									+ player.getName() + " your balance is still " + player.getResources());
						} else {
							// invalid input
							System.out.println("Invalid input. Please enter Y or N.");
						}
					} while (!playerOption.trim().equalsIgnoreCase("y") && !playerOption.trim().equalsIgnoreCase("n"));
				} else {
					System.out.println("You already own this square!");
				}
			}

			break;
		default:
			System.out.println("uh oh");
		}
	}

	/**
	 * Method allows player to perform a development or a major development on the
	 * square.
	 * 
	 * @param player
	 */
	public void develop(Player player) {

		if (this.getNumOfDevelopments() < 3) {
			if (player.getResources() >= this.getPriceToDevelop()) {
				this.increaseNumOfDevelopments();
				player.deductResources(this.getPriceToDevelop());
				System.out.println("Successful development! " + this.getName() + " has now been developed "
						+ this.getNumOfDevelopments() + " times.");
			} else {
				System.out.println("You do not have sufficient funds to complete this action.");
			}
		} else if (this.getNumOfDevelopments() == 3) {
			if (player.getResources() >= this.getPriceToMajorDevelop()) {
				this.increaseNumOfDevelopments();
				player.deductResources(this.getPriceToMajorDevelop());
				System.out
						.println("Successful major development! " + this.getName() + " has now been fully developed!");
			} else {
				System.out.println("You do not have sufficient funds to complete this action.");
			}
		} else {
			System.out.println(this.getName() + " is already fully developed");
		}

	}

	/**
	 * Method offers the square ownership to the other players in the game.
	 * 
	 * @param player
	 */
	public void offerSquare(Player player) {
		String playerOption = "";

		for (Player player2 : Game.players) {
			List<Square> systems = player2.getPropertiesOwned();
			for (Square sq : systems) {
				if (this.system.equals(sq.getSystem()) && player2.getName() != player.getName()
						&& this.getOwner() == null) {
					System.out.println("\nWarning : This element is in a system owned by " + player2.getName() + ".");
					System.out.println("If all elements are not controlled by the same player it is");
					System.out.println("not possible to develop all systems and win the game\n");
					break;
				}
			}
		}

		System.out.println(player.getName() + ", your current balance is " + player.getResources()
				+ " resource tokens.\nWould you like to purchase " + this.getName() + " for a price of "
				+ this.getPriceToAcquire() + " resource tokens? Y/N");

		do {
			playerOption = Game.scanner.next();
			if (playerOption.trim().equalsIgnoreCase("y")) {
				// bought it
				player.deductResources(this.getPriceToAcquire());
				player.addProperty(this);
				this.setOwner(player);
				System.out.println(player.getName() + " has purchased " + this.getName() + ". \n" + player.getName()
						+ " your new balance is " + player.getResources() + " resource tokens.");

			} else if (playerOption.trim().equalsIgnoreCase("n")) {
				System.out.println(player.getName() + " does not wish to buy " + this.getName() + ".");

			} else {
				System.out.println("Invalid input. Please enter Y or N.");
			}
		} while (!playerOption.trim().equalsIgnoreCase("y") && !playerOption.trim().equalsIgnoreCase("n"));

	}
}