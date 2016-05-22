import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {

	/* Constants */
	private static final int BOARD_HEIGHT = 6;
	private static final int BOARD_WIDTH = 7;
	private static final int BORDER_WIDTH = 3;
	private static final int GRID_WIDTH = 1;
	private static final int SQUARE_SIZE = 100;
	private static final int BUTTON_SIZE = 50;
	private static final int PIECE_SIZE = 25;
	private static final int OFFSET = 16;

	/* Interface Objects */
	private JFrame frame;
	private JPanel window;
	private JPanel buttons;
	private JPanel board;

	private JButton[] buttonPanels;
	private JPanel[][] boardPanels;
	private JPanel[][] piecePanels;

	
	/**
	 * Create the application
	 */
	public Interface() {
		frame = new JFrame("Connect Four");

		/* Size includes the border so we have to account for it */
		frame.setSize(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH + OFFSET,
				BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + OFFSET);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initWindow();
		initButtons();
		initBoard();

		window.add(buttons);
		window.add(board);

		frame.setContentPane(window);
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * Creates the main window
	 */
	private void initWindow() {
		window = new JPanel();
		window.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH + OFFSET,
				BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + OFFSET));
		window.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH + OFFSET,
				BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + OFFSET));
		window.setBackground(Color.WHITE);
		window.setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
	}

	
	/**
	 * Initialize the buttons at the top for placing pieces
	 */
	private void initButtons() {
		buttons = new JPanel();
		buttons.setBorder(null);
		buttons.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BUTTON_SIZE));
		buttons.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BUTTON_SIZE));
		buttons.setBackground(new Color(240, 248, 255));

		buttons.setLayout(new GridLayout(1, BOARD_WIDTH));
		buttonPanels = new JButton[BOARD_WIDTH];

		for (int i = 0; i < BOARD_WIDTH; ++i) {
			buttonPanels[i] = new JButton();
			buttonPanels[i].setPreferredSize(new Dimension(SQUARE_SIZE, BUTTON_SIZE));
			buttonPanels[i].setMinimumSize(new Dimension(SQUARE_SIZE, BUTTON_SIZE));
			buttonPanels[i].setOpaque(true);
			buttons.add(buttonPanels[i]);
		}
	}

	
	/**
	 * Initialize the board and the pieces
	 */
	private void initBoard() {
		board = new JPanel();
		board.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BOARD_HEIGHT * SQUARE_SIZE));
		board.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BOARD_HEIGHT * SQUARE_SIZE));
		board.setBackground(Color.WHITE);

		/* Initialize the arrays */
		board.setLayout(new GridLayout(BOARD_HEIGHT, BOARD_WIDTH));
		boardPanels = new JPanel[BOARD_HEIGHT][BOARD_WIDTH];
		piecePanels = new JPanel[BOARD_HEIGHT][BOARD_WIDTH];

		for (int i = 0; i < BOARD_HEIGHT; ++i) {
			for (int j = 0; j < BOARD_WIDTH; ++j) {
				/* Centers everything with the grid bag layout */
				boardPanels[i][j] = new JPanel(new GridBagLayout());
				boardPanels[i][j].setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
				boardPanels[i][j].setMinimumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
				boardPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GRID_WIDTH));
				boardPanels[i][j].setOpaque(true);
				boardPanels[i][j].setBackground(Color.WHITE);
				
				/*
				 * JLabel label1 = new JLabel(i + " " + j);
				 * boardPanels[i][j].add(label1);
				 */
				
				/* Pieces */
				piecePanels[i][j] = new JPanel();
				piecePanels[i][j].setPreferredSize(new Dimension(PIECE_SIZE, PIECE_SIZE));
				piecePanels[i][j].setMinimumSize(new Dimension(PIECE_SIZE, PIECE_SIZE));
				piecePanels[i][j].setBackground(Color.WHITE);

				boardPanels[i][j].add(piecePanels[i][j]);
				board.add(boardPanels[i][j]);
			}
		}
	}

	
	/**
	 * Adds the action listener to the buttons
	 * 
	 * @param pos:
	 *            The position of the button (0-6)
	 * @param a:
	 *            The action listener
	 */
	public void addButtonActionListener(int pos, ActionListener a) {
		buttonPanels[pos].addActionListener(a);
	}

	
	/**
	 * Disable the button at the position provided
	 * 
	 * @param pos:
	 *            The position of the button (0-6)
	 */
	public void disableButton(int pos) {
		buttonPanels[pos].setEnabled(false);
	}

	
	/**
	 * Enables all the buttons Called if the user wants to play again
	 */
	public void enableButtons() {
		for (int i = 0; i < BOARD_WIDTH; ++i)
			buttonPanels[i].setEnabled(true);
	}

	
	/**
	 * Called when a player makes a move Changes the piecePanels array to the
	 * corresponding players color
	 * 
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 */
	public void setPiecePanel(int pos, int idx, char player) {
		if (player == 'X')
			piecePanels[idx][pos].setBackground(Color.BLUE);
		else
			piecePanels[idx][pos].setBackground(Color.RED);
	}

	
	/**
	 * Highlights the position on the board Used to indicate the winning pieces
	 * 
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 */
	public void highlightPiece(int pos, int idx) {
		boardPanels[pos][idx].setBorder(BorderFactory.createLineBorder(Color.YELLOW, GRID_WIDTH));
	}

	
	/**
	 * Resets the background of the board to white Called if the user wants to
	 * play again
	 */
	public void clearBoard() {
		for (int i = 0; i < BOARD_HEIGHT; ++i) {
			for (int j = 0; j < BOARD_WIDTH; ++j) {
				piecePanels[i][j].setBackground(Color.WHITE);
				boardPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GRID_WIDTH));
			}
		}
	}
}
