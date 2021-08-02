/**
 * Class holds the scripts for the ArtemisLite game.
 */
package artemisLite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class Script {

	public static List<String> text = new ArrayList<String>();
	public static ReadScript readScript = new ReadScript();

	/**
	 * Method adds intro text to a list and starts a thread to read through the
	 * text. Method does not finish while thread is still alive.
	 */
	public static void displayIntro() {
		String playerNames = "";
		for (Player p : Game.players) {
			playerNames += p.getName() + ", ";
		}
		Collections.addAll(text, "Welcome to our game brave heroes of space, " + playerNames,
				"It is a period of great turmoil,", "Our home planet,", "ravaged by climate change,",
				"diseases running rife", "is becoming nigh on uninhabitable.", "On earth a group of scientists",
				"the best, the brightest,", "undertake a crucial mission:", "push the boundaries",
				"of space exploration.", "Humanity is on a journey to Mars,", "first stop: the Moon,",
				"only through collective effort,", "will this great goal be fulfilled,", "welcome, human,",
				"to your ArtemisLite quest.\n");
		Thread readIntroThread = new Thread(readScript);
		readIntroThread.start();
		while (readIntroThread.isAlive()) {

		}

	}

	/**
	 * Method adds instructions text to a list and starts a thread to read through
	 * the text. Method does not finish while thread is still alive.
	 */
	public static void displayInstructions() {
		Collections.addAll(text, "Your task is to develop a total of four systems.",
				"First, there is the space launch system,", "which consists of two elements,",
				"the engines and the boosters.", "Second, the orion spacecraft,", "which consists of three elements,",
				"the service module, crew module and launch abort system.",
				"Third, the gateway (an outpost for further exploration),", "which consists of two elements,",
				"the power and propulsion element and,", "the habitation and logistics outpost (HALO).",
				"Finally, the Artemis Generation Spacesuits,", "which consists of three elements,",
				"the primary life support systems, communication carrier assembly,",
				"and the display and control module.", "First you will roll two dice,",
				"then after landing on a square you may purchase its element,",
				"or if you own each element in a system,", "then you may begin developing the elements of that system.",
				"Once the three minor developments have been completed you may begin a major development.",
				"However... if one player owns part of a system,", "and another player owns the other part...",
				"Development will be impossible and your mission will fail.",
				"Purchasing elements and developing systems will require resources.",
				"These can be collected after landing on or passing the go square.",
				"However, if another player lands on a square you own,", "then you may charge them rent.",
				"Be careful though as they may charge you in the future as well,",
				"and if one player runs out of resources then the mission fails,", "and the game will end.",
				"You may also land on a research paused square.",
				"In this case your actions will be limited for one turn.",
				"Once all systems have been fully completed you have accomplished your mission.",
				"Good luck in your quest brave heroes.", "Humanity is counting on you.\n");
		Thread readIntroThread = new Thread(readScript);
		readIntroThread.start();
		while (readIntroThread.isAlive()) {

		}
	}

	/**
	 * Method adds losing outro text to a list and starts a thread to read through
	 * the text. Method does not finish while thread is still alive.
	 */
	public static void displayLosingOutro() {
		String playerNames = "";
		for (Player p : Game.players) {
			playerNames += p.getName() + ", ";
		}
		Collections.addAll(text, "Brave heroes, " + playerNames, "your mission has been unsuccessful.",
				"With no way to escape the planet and colonise Mars.", "Your failure is humanity's failure,",
				"the consequences will be felt by every man,", "woman and child on Earth. Nothing can save us now.\n");
		Thread readLoserOutroThread = new Thread(readScript);
		readLoserOutroThread.start();
		while (readLoserOutroThread.isAlive()) {

		}
	}

	/**
	 * Method adds winning outro text to a list and starts a thread to read through
	 * the text. Method does not finish while thread is still alive.
	 */
	public static void displayWinningOutro() {
		String playerNames = "";
		for (Player p : Game.players) {
			playerNames += p.getName() + ", ";
		}
		Collections.addAll(text,

				"The story of this project and humanity's salvation,",
				"is now taught in schools to inspire the next generation of heroes.",
				"In the year 2022...Artemis lands on the moon.",
				"In 2024 we saw the first woman walk on the moon and the next man.",
				"In 2030 the first settlement on the moon was established.",
				"Six years after this mankind reached Mars.", "In 2040 the first settlements were constructed.",
				"The process of evacuating Earth could then begin.", "It would take a decade to complete.",
				"During this time the people of Earth suffered.", "Conditions on the planet were too harsh for many.",
				"Truly this was humanity's darkest hour.", "But we raged against the dying of the light",
				"and the evacuation was complete,", "mankind saved.",
				"this would not have been possible without the brave heroes,", "of project ArtemisLite.",
				"Humanity extends its thanks to, " + playerNames, "your work will not be forgotten.\n");
		Thread readWinnerOutroThread = new Thread(readScript);
		readWinnerOutroThread.start();
		while (readWinnerOutroThread.isAlive()) {

		}
	}

}
