package swen221.tetris.logic;

import java.util.Arrays;
import java.util.Iterator;

import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.O_Tetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * A Board instance represent a board configuration for a game of Tetris. It is
 * represented as an array of rows, where every row contains a given number of
 * columns.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Board {
	/**
	 * The width of the board in columns.
	 */
	private final int width;
	/**
	 * The height of the board in rows.
	 */
	private final int height;
	/**
	 * A row-major representation of the board. Each location contains a reference
	 * to the tetromino located there.
	 */
	private final Tetromino[] cells;

	/**
	 * The active tetromino is the one currently being controlled.
	 */
	private ActiveTetromino activeTetromino;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Tetromino[width * height];
	}

	/**
	 * Create an identical copy of a given board.
	 *
	 * @param other
	 *            The board being copied.
	 */
	public Board(Board other) {
		this.width = other.width;
		this.height = other.height;
		this.cells = Arrays.copyOf(other.cells, other.cells.length);
		this.activeTetromino = other.activeTetromino;
	}

	/**
	 * Get the width of this board.
	 *
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height of this board.
	 *
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the active tetromino. This is the tetromino currently being manipulated
	 * on the board.
	 *
	 * @return
	 */
	public ActiveTetromino getTetromino() {
		return activeTetromino;
	}

	/**
	 * Get any tetromino (including the active one) located at a given position on
	 * the board. If the position is out of bounds, an exception is raised.
	 * Likewise, if no Tetromino exists at that position then <code>null</code> is
	 * returned.
	 *
	 * @param x
	 *            The x-coordinate of the cell to check
	 * @param y
	 *            The y-coordinate of the cell to check
	 *
	 * @return is null if x and/or y points out of the board.
	 */
	public Tetromino getTetrominoAt(int x, int y) {
		if (activeTetromino != null && activeTetromino.isWithin(x, y)) {
			return activeTetromino;
		} else {
			return getPlacedTetrominoAt(x, y);
		}
	}
	
	/**
	 * 
	 * checks the row to see if it is full
	 * 
	 * @return returns false if the row is not full and true if it is
	 */
	
	public boolean checkRow() {
		
		for(int i =0; i < width; i ++) {
			if(getPlacedTetrominoAt(i, 0) == null) {
				return false;
			}
		}
		return true;
		
		
	}
	
	/**
	 * moves the tetromino pieces down to clear the bottom of the board 
	 * 
	 */
	
	public void moveDown() {
		
		for(int i =0; i < height-1; i++) {
			for(int k = 0; k < width; k++) {
				setPlacedTetromino(k, i, getPlacedTetrominoAt(k,i+1));
			}
		}
		for(int i =0; i < width; i++) {
			setPlacedTetromino(i,height-1 , null);
		}
		
		
	}

	/**
	 * Get the placed tetromino (if any) located at a given position on the board.
	 * If the position is out of bounds, an exception is raised. Likewise, if no
	 * tetromino exists at that position then <code>null</code> is returned.
	 *
	 * @param x
	 *            The x-coordinate of the cell to check
	 * @param y
	 *            The y-coordinate of the cell to check
	 * @return is null if x and/or y points out of the board. *
	 */
	public Tetromino getPlacedTetrominoAt(int x, int y) {
		if (x < 0 || x >= width) {
			throw new IllegalArgumentException("Invalid column (" + x + ")");
		}
		if (y < 0 || y >= height) {
			throw new IllegalArgumentException("Invalid row (" + y + ")");
		}
		// Not part of active tetromino, so try placed ones.
		return cells[(y * width) + x];
	}

	/**
	 * Set the active tetromino for this board.
	 *
	 * @param tetromino
	 */
	public void updateTetromino(ActiveTetromino tetromino) {
		this.activeTetromino = tetromino;
	}

	/**
	 * Place a given Tetromino on the board by filling out each square it contains
	 * on the board.
	 *
	 * @param t
	 *            Tetromino to place; cannot be null
	 */
  public void put(Tetromino t) {
    Rectangle r = t.getBoundingBox();
    //
    for (int x = r.getMinX(); x <= r.getMaxX(); ++x) {
      for (int y = r.getMinY(); y <= r.getMaxY(); ++y) {
        if (t.isWithin(x, y)) {
          cells[(y * width) + x] = t;
        }
      }
    }
  }

	/**
	 * Set the placed tetromino at a given position on the board. If the position is
	 * out of bounds, an exception is raised.
	 *
	 * @param x
	 *            The x-coordinate of the cell to check
	 * @param y
	 *            The y-coordinate of the cell to check
	 * @param t
	 *            The tetromino to place, which can be <code>null</code> if the cell
	 *            is to be cleared.
	 */
	public void setPlacedTetromino(int x, int y, Tetromino t) {
		if (x < 0 || x >= width) {
			throw new IllegalArgumentException("Invalid column (" + x + ")");
		}
		if (y < 0 || y >= height) {
			throw new IllegalArgumentException("Invalid row (" + y + ")");
		}
		cells[(y * width) + x] = t;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		for (int y = height - 1; y >= 0; y -= 1) {
			res.append("|");
			for (int x = 0; x < width; x += 1) {
				Tetromino tetromino = getTetrominoAt(x, y);
				if (tetromino == null) {
					res.append("_");
				} else {
					res.append(tetromino.getColor().toString().charAt(0));
				}
				res.append("|");
			}
			res.append("\n");
		}
		return res.toString();
	}
}
