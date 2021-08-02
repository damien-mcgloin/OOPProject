/**
 * Class uses threads to read the scripts of the ArtemisLite game.
 */
package artemisLite;

/**
 * @author Emma Deane (40170069)
 * @author Damien McGloin (40000631)
 * @author Lia Grogan (40313320)
 * @author Natasha McCabe (40028027)
 */
public class ReadScript implements Runnable {

	@Override
	public void run() {
		readLineByLine();

	}

	/**
	 * Method uses threads to read through the text provided.
	 */
	private void readLineByLine() {
		for (String line : Script.text) {
			System.out.println(line);
			try {
				Thread.currentThread();
				Thread.sleep(1300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Script.text.clear();

	}

}
