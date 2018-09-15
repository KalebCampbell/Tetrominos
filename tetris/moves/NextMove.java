package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

public class NextMove implements Move {
	private final Tetromino tetromino;

	public NextMove(Tetromino tetromino) {
		this.tetromino = tetromino;
	}

	/**
	 * Get the underlying tetromino on which this is based.
	 *
	 * @return
	 */
	public Tetromino getTetromino() {
		return tetromino;
	}

	@Override
	public boolean isValid(Board board) {
		// This rule is only active if the active tetromino has already been placed.
		return board.getTetromino() == null;
	}

	@Override
	public Board apply(Board board) {
		board = new Board(board);
		// Determine center for next tetromino
		int cx = board.getWidth() / 2;
		int cy = board.getHeight() - 2;
		// Set next tetromino
		board.updateTetromino(new ActiveTetromino(cx, cy, tetromino));
		// Done!
		return board;
	}

	@Override
	public String toString() {
		// Determine first character of tetromino name
		char c = tetromino.getClass().getSimpleName().charAt(0);
		// Get color name in lowercase
		String color = tetromino.getColor().toString().toLowerCase();
		// Done
		return c + " " + color;
	}
}
