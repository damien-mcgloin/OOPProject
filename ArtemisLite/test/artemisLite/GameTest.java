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
class GameTest {

	// test data
	List<Player> players;
	Game game;
	Player activePlayer;
	Player testPlayer;
	Player testPlayer2;
	Square startSquare;
	Square currentSquare;
	Board board;
	int goMoney;
	int numOfPlayers;
	int minPlayers;
	int maxPlayers;
	int startPosition;
	int spacesToMove;
	int newPosition;
	int finalPosition;
	int boardSize;
	boolean victory;
	String player1Name;
	String player2Name;
	String player3Name;
	String player4Name;

	@BeforeEach
	void setup() {

		players = new ArrayList<Player>();
		goMoney = 200;
		game = new Game(goMoney);
		activePlayer = new Player();
		testPlayer = new Player(player1Name, goMoney, 0);
		testPlayer2 = new Player(player2Name, goMoney, 0);
		board = new Board();
		
		victory = false;
		spacesToMove = 3;

	}

	@Test
	void testGameDefaultConstructor() {
		assertNotNull(game);
	}

	@Test
	void testGameConstructorWithArgs() {

		game = new Game(goMoney);

		assertEquals(goMoney, game.getGoMoney());

	}

	@Test
	void testGetSetGoMoney() {
		game.setGoMoney(goMoney);

		assertEquals(goMoney, game.getGoMoney());
	}

	@Test // if victory is set to true only this test is run and passes - others ignored
	void testIsSetVictory() {
		game.setVictory(victory);

		assertEquals(victory, game.isVictory());
	}

	@Test // I tried to make this as close to the code in game class as possible - a loop and switch case statement
	// didn't seem to work and made my laptop overheat and I had to shut it down.
	void testSetUpPlayersValid() {
		
		player1Name = "validName1";
		player2Name = "validName2";
		player3Name = "validName3";
		player4Name = "validName4";
		

				Player player1 = new Player(player1Name, 0, 0);
				players.add(player1);

			if (!player2Name.equals(players.get(0).getName())) {
				Player player2 = new Player(player2Name, 0, 0);
				players.add(player2);
			} 
			
			if (!player3Name.equals(players.get(0).getName()) || !player3Name.equals(players.get(1).getName())) {
				Player player3 = new Player(player3Name, 0, 0);
				players.add(player3);
			}
			
			if (!player4Name.equals(players.get(0).getName()) || !player4Name.equals(players.get(1).getName())
					|| !player4Name.equals(players.get(2).getName())) {
				Player player4 = new Player(player4Name, 0, 0);
				players.add(player4);
			}
		
		
		assertEquals(player1Name, players.get(0).getName());
		assertEquals(player2Name, players.get(1).getName());
		assertEquals(player3Name, players.get(2).getName());
		assertEquals(player4Name, players.get(3).getName());
	
	}
	
	void testSetUpPlayersInvalid() {
		
		player1Name = "validName1";
		player2Name = "validName2";
		player3Name = "validName3";
		player4Name = "validName3";
		

				Player player1 = new Player(player1Name, 0, 0);
				players.add(player1);

			if (!player2Name.equals(players.get(0).getName())) {
				Player player2 = new Player(player2Name, 0, 0);
				players.add(player2);
			} 
			
			if (!player3Name.equals(players.get(0).getName()) || !player3Name.equals(players.get(1).getName())) {
				Player player3 = new Player(player3Name, 0, 0);
				players.add(player3);
			}
			
			if (!player4Name.equals(players.get(0).getName()) || !player4Name.equals(players.get(1).getName())
					|| !player4Name.equals(players.get(2).getName())) {
				Player player4 = new Player(player4Name, 0, 0);
				players.add(player4);
			}
		
		
		assertEquals(player1Name, players.get(0).getName());
		assertEquals(player2Name, players.get(1).getName());
		assertEquals(player3Name, players.get(2).getName());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			assertEquals(player4Name, players.get(3).getName());
		});
	
	}

	@Test
	void testMovePlayer() {
		testPlayer.movePosition(spacesToMove);
				
		assertEquals(3, testPlayer.getPosition());
		
	}

	@Test
	void testPassGo() {
		activePlayer.addResources(goMoney);
		
		assertEquals(goMoney, activePlayer.getResources());
	}
	
	@Test
	void testGetMenuOptions() {
		Square sq = new Square();
		Square sq2 = new Square();
		
		testPlayer.addProperty(sq);
		testPlayer.addProperty(sq2);
		
		game.getMenuOptions(sq2);
	}

}
