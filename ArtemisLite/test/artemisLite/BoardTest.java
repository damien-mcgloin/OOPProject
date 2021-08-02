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
class BoardTest {

	List<Square> aList;
	Square sq1,sq2;
	Board board;
	int playerPosition;
	
	@BeforeEach
	void setUp() throws Exception {
		board = new Board();
		aList = new ArrayList<Square>();
		sq1 = new Square("validSquare", SquareType.GOVERNMENT_GRANT);
		sq2 = new Square("validSquare2", SquareType.EXTERNAL_INVESTIGATION);
	}

	@Test
	void testDefaultConstructor() {
		Board board = new Board();
		assertNotNull(board);
	}

	@Test
	void testConstuctorWithArgs() {
		Board board = new Board(aList);
		assertEquals(aList, board.getCurrentBoard());
	}


	@Test
	void testInitialiseBoard() {
		board.initialiseBoard();
		assertEquals(12, board.getCurrentBoard().size());
	}

	@Test
	void testPlaySquare() {
		board.addSquare(sq1);
		assertEquals(sq1,board.playSquare(playerPosition));
	}

	@Test
	void testAddSquare() {
		board.addSquare(sq1);
		board.addSquare(sq2);
		assertEquals(2,board.getCurrentBoard().size());
	}

}
