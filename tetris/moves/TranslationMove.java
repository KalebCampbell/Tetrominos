package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a translation move.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class TranslationMove implements Move {
	/**
	 * Amount to translate x-coordinate.
	 */
	private int dx;
	/**
	 * Amount to translate y-coordinate.
	 */
	private int dy;

	/**
	 * Construct new TranslationMove for a given amount of horizontal and vertical
	 * translation.
	 *
	 * @param dx
	 *            Amount to translate in horizontal direction.
	 * @param dy
	 *            Amount to translate in vertical direction.
	 */
	public TranslationMove(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	/**
	 * 
	 * @param board
	 * 				
	 * @return boolean true
	 */
	public boolean isValid(Board board) {

		try {
			ActiveTetromino t = board.getTetromino();

			Rectangle r = t.getBoundingBox();
			for (int x = r.getMinX(); x <= r.getMaxX(); ++x) {
				for (int y = r.getMinY(); y <= r.getMaxY(); ++y) {
					if (t.isWithin(x, y)
							&& board.getPlacedTetrominoAt(dx + x, dy + y) != null) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Apply translation for this move
		ActiveTetromino tetromino = board.getTetromino().translate(dx, dy);
		// Apply the move to the new board.
		board.updateTetromino(tetromino);
		// Return updated version of board
		return board;
	}

	@Override
	public String toString() {
		if (dx > 0) {
			return "right " + dx;
		} else if (dx < 0) {
			return "left " + dx;
		} else {
			return "drop " + dy;
		}
	}
}
