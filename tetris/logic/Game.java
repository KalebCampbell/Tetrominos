package swen221.tetris.logic;

import java.util.ArrayList;

import swen221.tetris.moves.LandingMove;
import swen221.tetris.moves.Move;
import swen221.tetris.moves.NextMove;
import swen221.tetris.moves.RotationMove;
import swen221.tetris.moves.TranslationMove;
import swen221.tetris.tetromino.*;

/**
 * A Game instance represents a running game of Tetris. It accepts game moves
 * and updates the board accordingly. Likewise, it provides an API to access the
 * board itself. Finally, it determines when the game is over (i.e. because the
 * board is full).
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Game {

	/**
	 * The current state of the game board.
	 */
	private ArrayList<Board> boards = new ArrayList<>();
	
	public Game(int width, int height) {
		// Initial boards list with an empty board.
		Board board = new Board(width, height);
		this.boards.add(board);
	}

	/**
	 * Get the current board being acted upon.
	 *
	 * @return
	 */
	public Board getActiveBoard() {
		return boards.get(boards.size() - 1);
	}

	/**
	 * Apply a given move to the board. This will update the board if the move is
	 * valid, otherwise it will be ignored.
	 *
	 * @param move
	 */
	public boolean apply(Move move) {
		Board board = getActiveBoard();
		// Check whether the move was valid as, if not, then it's ignored.
		if (move.isValid(board)) {
			// Yes, move is valid therefore apply it for real.
			Board newBoard = move.apply(board);
			boards.add(newBoard);
			return true;
		}
		{
			// This move was ignored.
			return false;
		}
	}

	/**
	 * <pre>
	 * Create a game from a list of moves expressed using a simple notation. The
	 * following illustrates a simple game:
	 * </pre>
	 *
	 * <pre>
	 * (T; rotate 1; left 2; drop 3+)
	 * </pre>
	 *
	 * <pre>
	 * For this game, the initial piece is a "T". This is the rotate clockwise one
	 * turn, moved left 2 positions and then dropped 3 positions where it results in
	 * a line being won.
	 * </pre>
	 *
	 * @param moves
	 * @return
	 */
	public static Game fromString(int width, int height, String input) {
		// Sanitize input a little
		input = input.replaceAll("\\(", "");
		input = input.replaceAll("\n", "");
		input = input.replaceAll("\r", "");
		input = input.replaceAll("; ", ";");
		//
		String[] sequences = input.split("\\)");
		Game g = new Game(width, height);
		for (int i = 0; i != sequences.length; ++i) {
			Move[] moves = extractMoveSequence(sequences[i]);
			for (int j = 0; j != moves.length; ++j) {
				g.apply(moves[j]);
			}
		}
		return g;
	}

	/**
	 * Extract a move sequence from a sequence of move atoms combined together using
	 * semi-colons (e.g. "drop 1; land 2", etc).
	 *
	 * @param input
	 * @return
	 */
	private static Move[] extractMoveSequence(String input) {
		String[] atoms = input.split(";");
		Move[] moves = new Move[atoms.length];
		for (int i = 0; i != atoms.length; ++i) {
			moves[i] = extractMove(atoms[i]);
		}
		return moves;
	}

	/**
	 * Extract a move from a given move string of the form e.g. "land 3" or "left
	 * 2", etc.
	 *
	 * @param atom
	 * @return
	 */
	private static Move extractMove(String atom) {
		String[] components = atom.split(" ");
		switch (components[0]) {
		case "rotate": {
			int number = Integer.parseInt(components[1]);
			return new RotationMove(number);
		}
		case "drop": {
			int number = Integer.parseInt(components[1]);
			return new TranslationMove(0, -number);
		}
		case "left": {
			int number = Integer.parseInt(components[1]);
			return new TranslationMove(-number, 0);
		}
		case "right": {
			int number = Integer.parseInt(components[1]);
			return new TranslationMove(number, 0);
		}
		case "land": {
			int number = Integer.parseInt(components[1]);
			return new LandingMove(number);
		}
		default: {
			// This is the tetromino selection move
			Tetromino.Color c = extractColor(components[1]);
			return new NextMove(extractTetromino(components[0], c));
		}
		}
	}

	/**
	 * Extract the color object from a given color string (e.g. "red").
	 *
	 * @param input
	 * @return
	 */
	private static Tetromino.Color extractColor(String input) {
		if (input.equals("black")) {
			throw new IllegalArgumentException("Black is reserved for stuck tetromino!");
		} else {
			for (Tetromino.Color c : Tetromino.Color.values()) {
				if (c.toString().toLowerCase().equals(input)) {
					return c;
				}
			}
		}
		throw new IllegalArgumentException("invalid color \"" + input + "\"");
	}

	/**
	 * Construct a tetromino from a given descriptor string (e.g. "T red", "O blue",
	 * etc).
	 *
	 * @param input
	 * @param c
	 * @return
	 */
	private static Tetromino extractTetromino(String input, Tetromino.Color c) {
		switch (input) {
		case "I":
			return new I_Tetromino(Tetromino.Orientation.NORTH, c);
		case "J":
			return new J_Tetromino(Tetromino.Orientation.NORTH, c);
		case "L":
			return new L_Tetromino(Tetromino.Orientation.NORTH, c);
		case "O":
			return new O_Tetromino(c);
		case "S":
			return new S_Tetromino(Tetromino.Orientation.NORTH, c);
		case "T":
			return new T_Tetromino(Tetromino.Orientation.NORTH, c);
		case "Z":
			return new Z_Tetromino(Tetromino.Orientation.NORTH, c);
		}
		// Check whether this is a sticky tetromino or not.
		if (input.startsWith("*")) {
			return new StickyTetromino(3, extractTetromino(input.substring(1), c));
		} else {
			throw new IllegalArgumentException("invalid tetromino \"" + input + "\"");
		}
	}
}
