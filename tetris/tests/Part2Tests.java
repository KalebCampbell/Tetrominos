package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import swen221.tetris.logic.Game;

public class Part2Tests {

	@Test
	void testLanding_01() {
		String input = "(L magenta; drop 3; land 0)" +
	                   "(O red; left 1; drop 2)";
		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|R|R|_|_|\n" + // 2
				"|_|R|R|M|_|\n" + // 1
				"|_|M|M|M|_|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_02() {
		String input = "(I magenta; drop 3; land 0)" +
	                   "(S red; right 1; rotate 1; drop 1)";
		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|R|_|\n" + // 3
				"|_|_|_|R|R|\n" + // 2
				"|_|_|_|_|R|\n" + // 1
				"|_|M|M|M|M|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_03() {
		String input = "(J blue; left 1; drop 3; land 0)" +
	                   "(O red; right 1; rotate 2; drop 3)";
		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|B|_|_|R|R|\n" + // 1
				"|B|B|B|R|R|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_04() {
		String input = "(T blue; drop 3; land 0)" +
	                   "(S red; rotate 1; right 1; drop 2; land 0)" +
				       "(Z magenta; rotate 1; left 1; drop 1; land 0)";

		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|M|_|_|\n" + // 3
				"|_|M|M|R|_|\n" + // 2
				"|_|M|B|R|R|\n" + // 1
				"|_|B|B|B|R|\n", // 0
				game.getActiveBoard().toString());
	}
	@Test
	void testLanding_05() {
		String input = "(O blue; left 2; drop 3; land 0)" +
	                   "(L red; right 1; drop 3; land 1)";
		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|_|_|_|_|_|\n" + // 1
				"|B|B|_|_|R|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_06() {
		String input = "(I yellow; right 0; drop 3; land 0)" +
	                   "(Z red; rotate 1; left 2; drop 2; land 1)";
		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|_|R|_|_|_|\n" + // 1
				"|R|R|_|_|_|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_07() {
		String input = "(I blue; rotate 1; left 2; drop 1; land 0)" +
	                   "(O yellow; right 1; drop 3; land 0)" +
				       "(O red; left 1; drop 3; land 2)";

		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|B|_|_|_|_|\n" + // 1
				"|B|_|_|_|_|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_08() {
		String input = "(I blue; drop 3; land 0)" + "(I red; drop 2; land 0)" +
	                   "(J yellow; rotate 1; left 2; drop 2; land 2)";

		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|_|_|_|_|_|\n" + // 1
				"|Y|Y|_|_|_|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_09() {
		String input = "(T blue; drop 3; land 0)" +
				   "(T red; rotate 1; left 2; drop 2; land 0)" +
				   "(T yellow; rotate 3; right 2; drop 2; land 2)";

		Game game = Game.fromString(5, 5, input);
		//
		assertEquals("|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|_|_|_|_|_|\n" + // 1
				"|R|_|_|_|Y|\n", // 0
				game.getActiveBoard().toString());
	}

	@Test
	void testLanding_10() {
		String input =
				"(T blue; drop 3; land 0)" +
				"(S red; rotate 1; right 1; drop 2; land 0)" +
				"(Z magenta; rotate 1; left 2; drop 2; land 2)";

		Game game = Game.fromString(5,5, input);
		//
		assertEquals(
				"|_|_|_|_|_|\n" + // 4
				"|_|_|_|_|_|\n" + // 3
				"|_|_|_|_|_|\n" + // 2
				"|_|_|_|_|_|\n" + // 1
				"|_|M|_|R|_|\n",  // 0
				game.getActiveBoard().toString());
	}
}
