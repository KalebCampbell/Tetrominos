package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a rotation move which is either clockwise or anti-clockwise.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class RotationMove implements Move {
	/**
	 * Rotate a given number of steps in a clockwise direction (if positive), or an
	 * anti-clockwise direction (if negative).
	 */
	private final int rotation;

	public RotationMove(int steps) {
		this.rotation = steps;
	}


	/**
	 * Check whether this move is valid or not for a given tetromino on a given board.
	 * @param board
	 * @return true if it is valid, and false if not
	 */
	public boolean isValid(Board board) {

		try {
			ActiveTetromino t = board.getTetromino();

			Rectangle r = t.getBoundingBox(rotation);
			for (int x = r.getMinX(); x <= r.getMaxX(); ++x) {
				for (int y = r.getMinY(); y <= r.getMaxY(); ++y) {
					if (y >= board.getHeight()) {
						continue;
					}
					if (t.isWithin(x, y, rotation) && board.getPlacedTetrominoAt(x, y) != null) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	/**
	 * Get the number of rotation steps in this move.
	 *
	 * @return number of rotations
	 */
	public int getRotation() {
		return rotation;
	}

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Create a copy of this board which will be updated.
		ActiveTetromino tetromino = board.getTetromino().rotate(rotation);
		// Apply the move to the new board, rather than to this board.
		board.updateTetromino(tetromino);
		// Return updated version of this board.
		return board;
	}

	@Override
	public String toString() {
		return "rotate " + rotation;
	}

}
