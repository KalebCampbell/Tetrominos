package swen221.tetris.tetromino;

/**
 * Provides a base implementation from which all concrete tetromino's extend.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractTetromino implements Tetromino {

	/**
	 * The orientation of this Tetromino.
	 */
	protected Orientation orientation;

	/**
	 * color of the Tetromino cells
	 */
	protected Color color;

	AbstractTetromino(Orientation orientation, Color color) {
		this.orientation = orientation;
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Orientation getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return "(" + getClass().getSimpleName() + ";" + orientation + ";" + color.toString() + ")";
	}
}
