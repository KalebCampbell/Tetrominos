package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import swen221.tetris.logic.Game;

public class Part3Tests {
  @Test
  void testInvalid_01() {
    String input =
         "(L red; left 3; left 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|R|_|_|\n" + // 4
      "|R|R|R|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_02() {
    String input =
         "(L red; right 3; left 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|R|_|_|\n" + // 4
      "|R|R|R|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_03() {
    String input =
         "(T blue; drop 4; right 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|B|_|\n" + // 4
      "|_|_|B|B|B|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|_|_|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_04() {
    String input =
         "(T blue; drop 3; rotate 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|_|_|B|_|_|\n" + // 1
      "|_|B|B|B|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_05() {
    String input =
         "(I blue; left 1; rotate 1; rotate 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|B|_|_|_|\n" + // 4
      "|_|B|_|_|_|\n" + // 3
      "|_|B|_|_|_|\n" + // 2
      "|_|B|_|_|_|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_06() {
    String input =
         "(O blue; drop 3; land 0)"+
         "(J red; drop 3)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|R|_|_|_|\n" + // 4
      "|_|R|R|R|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|_|_|B|B|_|\n" + // 1
      "|_|_|B|B|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_07() {
    String input =
        "(J red; right 1; drop 3; land 0)"+
        "(O blue; left 2; drop 3; right 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|B|B|R|_|_|\n" + // 1
      "|B|B|R|R|R|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_08() {
    String input =
        "(J red; right 1; drop 3; land 0)"+
        "(Z blue; rotate 1; left 1; drop 1; rotate 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|B|_|_|\n" + // 3
      "|_|B|B|_|_|\n" + // 2
      "|_|B|R|_|_|\n" + // 1
      "|_|_|R|R|R|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_09() {
    String input =
        "(J red; right 1; drop 2)"+
        "(Z blue)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|R|_|_|\n" + // 2
      "|_|_|R|R|R|\n" + // 1
      "|_|_|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_10() {
    String input =
         "(O blue; left 2; drop 3; land 1)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|B|B|_|_|_|\n" + // 1
      "|B|B|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_11() {
    String input =
         "(O blue; left 2; drop 3; land 0)" +
          "(L red; right 1; drop 3; land 2)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|B|B|_|_|R|\n" + // 1
      "|B|B|R|R|R|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_12() {
    String input =
        "(T blue; drop 3; land 0)" +
        "(T red; rotate 1; left 2; drop 2; land 0)" +
        "(T yellow; rotate 3; right 2; drop 2; land 1)" ;

    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|R|_|_|_|Y|\n" + // 2
      "|R|R|B|Y|Y|\n" + // 1
      "|R|B|B|B|Y|\n",  // 0
      game.getActiveBoard().toString());
  }

  @Test
  void testInvalid_13() {
    String input =
         "(O blue; left 2; drop 3; land 1; left 2)";
    Game game = Game.fromString(5,5, input);
    //
    assertEquals(
      "|_|_|_|_|_|\n" + // 4
      "|_|_|_|_|_|\n" + // 3
      "|_|_|_|_|_|\n" + // 2
      "|B|B|_|_|_|\n" + // 1
      "|B|B|_|_|_|\n",  // 0
      game.getActiveBoard().toString());
  }
}
