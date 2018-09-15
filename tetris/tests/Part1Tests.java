package swen221.tetris.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import swen221.tetris.logic.Game;

public class Part1Tests {
   @Test
   void testValid_00() {
     String input =
          "(O red)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|R|R|_|\n" + // 4
       "|_|_|R|R|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_01() {
     String input =
          "(O green)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|G|G|_|\n" + // 4
       "|_|_|G|G|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_02() {
     String input =
          "(S orange)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|O|O|_|\n" + // 4
       "|_|O|O|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_03() {
     String input =
          "(L magenta)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|M|_|\n" + // 4
       "|_|M|M|M|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_04() {
     String input =
          "(Z yellow)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|Y|Y|_|_|\n" + // 4
       "|_|_|Y|Y|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_05() {
     String input =
          "(Z green)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|G|G|_|_|\n" + // 4
       "|_|_|G|G|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_06() {
     String input =
          "(J green)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|G|_|_|_|\n" + // 4
       "|_|G|G|G|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_07() {
     String input =
          "(O magenta)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|M|M|_|\n" + // 4
       "|_|_|M|M|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_08() {
     String input =
          "(L orange)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|O|_|\n" + // 4
       "|_|O|O|O|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_09() {
     String input =
          "(S magenta)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|M|M|_|\n" + // 4
       "|_|M|M|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_10() {
     String input =
          "(S red; left 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|R|R|_|_|\n" + // 4
       "|R|R|_|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_11() {
     String input =
          "(O blue; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|B|B|_|\n" + // 4
       "|_|_|B|B|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_12() {
     String input =
          "(L magenta; rotate 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|M|_|\n" + // 4
       "|_|M|M|M|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_13() {
     String input =
          "(S yellow; drop 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|Y|Y|_|\n" + // 3
       "|_|Y|Y|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_14() {
     String input =
          "(S red; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|R|R|_|\n" + // 4
       "|_|R|R|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_15() {
     String input =
          "(L red; left 1)";
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
   void testValid_16() {
     String input =
          "(Z green; drop 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|G|G|_|_|\n" + // 3
       "|_|_|G|G|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_17() {
     String input =
          "(L red; drop 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|_|R|_|\n" + // 3
       "|_|R|R|R|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_18() {
     String input =
          "(T yellow; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|Y|_|_|\n" + // 4
       "|_|Y|Y|Y|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_19() {
     String input =
          "(J yellow; drop 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|Y|_|_|_|\n" + // 3
       "|_|Y|Y|Y|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_20() {
     String input =
          "(I yellow; rotate 2)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|Y|Y|Y|Y|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_21() {
     String input =
          "(L green; drop 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|_|G|_|\n" + // 3
       "|_|G|G|G|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_22() {
     String input =
          "(J yellow; rotate 1)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|Y|Y|_|\n" + // 4
       "|_|_|Y|_|_|\n" + // 3
       "|_|_|Y|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_23() {
     String input =
          "(L blue; drop 0; rotate 2)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|B|B|B|_|\n" + // 3
       "|_|B|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_24() {
     String input =
          "(L yellow; rotate 1; rotate 3)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|Y|_|\n" + // 4
       "|_|Y|Y|Y|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_25() {
     String input =
          "(I yellow; rotate 2; rotate 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|Y|Y|Y|Y|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_26() {
     String input =
          "(I green; rotate 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|G|G|G|G|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_27() {
     String input =
          "(T green; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|G|_|_|\n" + // 4
       "|_|G|G|G|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_28() {
     String input =
          "(O orange; drop 0; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|O|O|_|\n" + // 4
       "|_|_|O|O|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_29() {
     String input =
          "(L magenta; drop 0; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|M|_|\n" + // 4
       "|_|M|M|M|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   // GOT HERE
   void testValid_30() {
     String input =
          "(I green; drop 3)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|_|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|G|G|G|G|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_31() {
     String input =
          "(T green; left 1; drop 3)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|_|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|G|_|_|_|\n" + // 1
       "|G|G|G|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_32() {
     String input =
          "(O orange; drop 1; drop 2)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|_|_|\n" + // 4
       "|_|_|_|_|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|O|O|_|\n" + // 1
       "|_|_|O|O|_|\n",  // 0
       game.getActiveBoard().toString());
   }
   @Test
   void testValid_33() {
     String input =
          "(L magenta; drop 0; drop 0)";
     Game game = Game.fromString(5,5, input);
     //
     assertEquals(
       "|_|_|_|M|_|\n" + // 4
       "|_|M|M|M|_|\n" + // 3
       "|_|_|_|_|_|\n" + // 2
       "|_|_|_|_|_|\n" + // 1
       "|_|_|_|_|_|\n",  // 0
       game.getActiveBoard().toString());
   }
}