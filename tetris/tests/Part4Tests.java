package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import swen221.tetris.logic.Game;

public class Part4Tests {
  @Test
  void testSticky_01() {
    String input =
         "(*L red; rotate 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|R|_|_|\n" + // 4
      "|_|_|R|_|_|\n" + // 3
      "|_|_|R|R|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testSticky_02() {
    String input =
         "(*T blue; rotate 2)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|B|B|B|_|\n" + // 3
      "|_|_|B|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testSticky_03() {
    String input =
         "(*T blue; rotate 3)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|D|_|_|\n" + // 4
      "|_|D|D|_|_|\n" + // 3
      "|_|_|D|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testSticky_04() {
    String input =
         "(*T blue; rotate 4)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|D|_|_|\n" + // 4
      "|_|D|D|_|_|\n" + // 3
      "|_|_|D|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testSticky_05() {
	  String input = "(*T blue; rotate 1; rotate 1; rotate 1; rotate 1)";
	  Game game = Game.fromString(5, 5, input);
	  //
	  assertEquals("|_|_|D|_|_|\n" + // 4
			  "|_|D|D|_|_|\n" + // 3
			  "|_|_|D|_|_|\n" + // 2
			  "|_|_|_|_|_|\n" + // 1
			  "|_|_|_|_|_|\n", // 0
			  game.getActiveBoard().toString());
  }

  void testSticky_06() {
	  String input = "(*T blue; rotate 2; rotate 1; rotate 1)";
	  Game game = Game.fromString(5, 5, input);
	  //
	  assertEquals("|_|_|D|_|_|\n" + // 4
			  "|_|D|D|_|_|\n" + // 3
			  "|_|_|D|_|_|\n" + // 2
			  "|_|_|_|_|_|\n" + // 1
			  "|_|_|_|_|_|\n", // 0
			  game.getActiveBoard().toString());
  }

  @Test
  void testSticky_07() {
	  String input = "(*T blue; rotate 2; rotate 2)";
	  Game game = Game.fromString(5, 5, input);
	  //
	  assertEquals("|_|_|D|_|_|\n" + // 4
			  "|_|D|D|_|_|\n" + // 3
			  "|_|_|D|_|_|\n" + // 2
			  "|_|_|_|_|_|\n" + // 1
			  "|_|_|_|_|_|\n", // 0
			  game.getActiveBoard().toString());
  }

  @Test
  void testSticky_08() {
	  String input = "(*T blue; rotate 3; rotate 1)";
	  Game game = Game.fromString(5, 5, input);
	  //
	  assertEquals("|_|_|D|_|_|\n" + // 4
			  "|_|D|D|_|_|\n" + // 3
			  "|_|_|D|_|_|\n" + // 2
			  "|_|_|_|_|_|\n" + // 1
			  "|_|_|_|_|_|\n", // 0
			  game.getActiveBoard().toString());
  }

  @Test
  void testSticky_09() {
    String input =
         "(*I blue; rotate 5)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|D|_|_|\n" + // 4
      "|_|_|D|_|_|\n" + // 3
      "|_|_|D|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testSticky_10() {
    String input =
         "(*I blue; rotate 1; rotate 1; rotate 1; rotate 1; rotate 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|D|_|_|\n" + // 4
      "|_|_|D|_|_|\n" + // 3
      "|_|_|D|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }
}
