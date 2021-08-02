/**
 * This class acts as a manager class for the ArtemisLite game.
 */
package artemisLite;

import java.util.Scanner;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class AppManager {

	/**
	 * start point of application - kicks off the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner mainScanner = new Scanner(System.in);
		System.out.println("Press ENTER to begin your Artemis adventure");
		mainScanner.nextLine();

		Game game = new Game(200);
		game.startGame();
		game.continueGame();

		mainScanner.close();


	}

}
