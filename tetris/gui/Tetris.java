package swen221.tetris.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;

import javax.swing.*;

import swen221.tetris.logic.Game;
import swen221.tetris.moves.*;
import swen221.tetris.tetromino.*;

/**
 * Tetris Define a Gui allowing to play. This code is quite advanced and uses
 * features that you will learn in the later part of Swen221; do no worry if
 * there are certain parts that you can not understand.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
@SuppressWarnings("serial")
public class Tetris extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Tetris t = new Tetris();
			ArrayList<Move> moves = new ArrayList<>();
			t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			t.getRootPane().setLayout(new BorderLayout());
			JPanel display = createDisplayCanvas(moves);
			t.getRootPane().add(display, BorderLayout.CENTER);
			t.addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					display.requestFocus();
				}
			});
			t.pack();
			t.setVisible(true);
			// to make the cells update their color
			display.revalidate();
		});
	}

	public static JPanel createDisplayCanvas(List<Move> moves) {
		// Initialise the game
		TetrominoList tetrominos = new TetrominoList();
		Game g = new Game(10, 20);
		// Set the first tetromino!
		nextTetromino(g, moves, tetrominos);
		// Create the display itself
		JPanel display = new JPanel();
		display.setLayout(new GridLayout(20, 10, 1, 1));
		for (int row = 0; row < 20; row += 1) {
			for (int col = 0; col < 10; col += 1) {
				display.add(cell(col, 19 - row, g));
			}
		}
		display.setFocusable(true);
		// Add key listeners
		display.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					applyMove(g, new RotationMove(1), moves, tetrominos);
					break;
				case KeyEvent.VK_DOWN:
					applyMove(g, new TranslationMove(0, -1), moves, tetrominos);
					break;
				case KeyEvent.VK_LEFT:
					applyMove(g, new TranslationMove(-1, 0), moves, tetrominos);
					break;
				case KeyEvent.VK_RIGHT:
					applyMove(g, new TranslationMove(+1, 0), moves, tetrominos);
					break;
				case KeyEvent.VK_SPACE:
					applyMove(g, new LandingMove(), moves, tetrominos);
					break;
				}
				display.revalidate();
			}
		});
		return display;
	}

	public static void applyMove(Game g, Move m, List<Move> moves, TetrominoList tetrominos) {
		if (g.apply(m)) {
			// If move was applied then add it to list of moves
			moves.add(m);
			// Check whether we have landed and need the next tetromino.
			nextTetromino(g, moves, tetrominos);
		}
	}

	public static void nextTetromino(Game g, List<Move> moves, TetrominoList tetrominos) {
		Move next = new NextMove(tetrominos.top());
		if (g.apply(next)) {
			moves.add(next);
			tetrominos.pop();
		}
	}

	/**
	 * Create cells in the Tetris visualization. They use the Game to chose their
	 * color.
	 */
	public static JPanel cell(int col, int row, Game g) {
		return new JPanel() {
			@Override
			public void validate() {
				Tetromino t = g.getActiveBoard().getTetrominoAt(col, row);
				this.setBackground(toAwtColor(t));
				super.validate();
			}

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(30, 30);
			}
		};
	}

	/**
	 * Convert a TetrominoColor to an AWT color.
	 *
	 * @param color
	 * @return
	 */
	private static Color toAwtColor(Tetromino tetromino) {
		if (tetromino == null) {
			return java.awt.Color.WHITE;
		} else {
			switch (tetromino.getColor()) {
			case RED:
				return java.awt.Color.RED;
			case ORANGE:
				return java.awt.Color.ORANGE;
			case YELLOW:
				return java.awt.Color.YELLOW;
			case GREEN:
				return java.awt.Color.GREEN;
			case BLUE:
				return java.awt.Color.BLUE;
			case MAGENTA:
				return java.awt.Color.MAGENTA;
			case DARK_GRAY:
			default:
				return java.awt.Color.DARK_GRAY;
			}
		}
	}

	private static class TetrominoList {
		private Random random = new Random(System.currentTimeMillis());
		private ArrayList<Tetromino> tetrominos = new ArrayList<>();
		private int index = 0;

		public Tetromino top() {
			while (index >= tetrominos.size()) {
				tetrominos.add(next());
			}
			return tetrominos.get(index);
		}

		public void pop() {
			index = index + 1;
		}

		private Tetromino next() {
			Tetromino.Color[] colors = Tetromino.Color.values();
			int tetromino = random.nextInt(10);
			// NOTE: -1 here because BLACK is reserved for being stuck.
			int color = random.nextInt(colors.length - 1);
			switch (tetromino) {
			case 0:
				return new Z_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 1:
				return new S_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 2:
				return new T_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 3:
				return new J_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 4:
				return new L_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 5:
				return new O_Tetromino(colors[color]);
			case 6:
				return new I_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			default:
				StickyTetromino t = new StickyTetromino(3, next());
				if(t.getBoundingBox() == null) {
					// NOTE: this is a little trick to ensure we don't try to create sticky
					// tetromno's before they have actually been implemented (otherwise the game
					// crashes a lot :)
					return next();
				} else {
					return t;
				}
			}
		}
	}
}