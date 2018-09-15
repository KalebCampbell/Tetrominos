package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * Represents a tetromino which can only perform one rotation operation.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class StickyTetromino implements Tetromino {

	int count;
	Tetromino tetromino;
	
	public StickyTetromino(int count, Tetromino tetromino) {
	this.count = count;
	this.tetromino = tetromino;
	}

	@Override
	public Color getColor() {
		if (count == 0) {
			return Color.DARK_GRAY;
		}
		else return tetromino.getColor();
	}

	@Override
	public Orientation getOrientation() {
		return tetromino.getOrientation();
	}

	@Override
	public boolean isWithin(int x, int y) {
		return tetromino.isWithin(x, y);
	}

	@Override
	public Rectangle getBoundingBox() {
		return tetromino.getBoundingBox();
	}

	@Override
	public Tetromino rotate(int steps) {
		int r = 0;
		//makes sure that the sticky tetromino can't rotate more than 3 times
		if (steps < count) {
			r = steps;
			count = count - steps;
		}
		else {
			r = count;
			count = 0;
		}
		//  checks which type of tetromino it is too know which type of tetromino to return
		
		if (tetromino instanceof I_Tetromino) {
			return new StickyTetromino(count, new I_Tetromino(getOrientation(), getColor()).rotate(r));
		}
		else if (tetromino instanceof J_Tetromino) {
			return new StickyTetromino(count, new J_Tetromino(getOrientation(), getColor()).rotate(r));
		}
		else if (tetromino instanceof L_Tetromino) {
			return new StickyTetromino(count, new L_Tetromino(getOrientation(), getColor()).rotate(r));
		}
		else if (tetromino instanceof O_Tetromino) {
			return new StickyTetromino(count, new O_Tetromino(getColor()).rotate(r));
		}
		else if (tetromino instanceof S_Tetromino) {
			return new StickyTetromino(count, new S_Tetromino(getOrientation(), getColor()).rotate(r));
		}
		else if (tetromino instanceof T_Tetromino) {
			return new StickyTetromino(count, new T_Tetromino(getOrientation(), getColor()).rotate(r));
		}
		else {
			return new StickyTetromino(count, new Z_Tetromino(getOrientation(), getColor()).rotate(r));
		}
	}
}
