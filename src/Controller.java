import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * @author guiping
 *
 */
public class Controller {
	/* Constaints */
	private static final int BOARD_HEIGHT = 6;
	private static final int BOARD_WIDTH = 7;

	/* Required objects to run the game */
	Board board;
	Interface window;

	/* Player one: 'X', alternates to 'Y' */
	private char player;
	
	/* Used for undo, stores the previous position and index */
	private Stack<Integer> allPositions;
	private Stack<Integer> allIndices;
	
	
	/**
	 * Constructor for the controller
	 * Initializes everything
	 */
	public Controller() {
		window = new Interface();
		board = new Board();
		allPositions = new Stack<Integer>();
    allIndices = new Stack<Integer>();
		player = 'X';
	}
	
	
	/**
	 * Runs the game
	 * Sets all the action listeners
	 */
	public void runGame() {
	  addActionListeners();
    addUndoAction();
	}

	
	/**
	 * Helper to create the action listeners required for the buttons
	 */
	private void addActionListeners() {
		for (int i = 0; i < BOARD_WIDTH; ++i) {
			final int temp = i;
			window.addButtonActionListener(i, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String ret = board.placePiece(temp, player);

					int idx = Character.getNumericValue(ret.charAt(0));
					window.setPiecePanel(temp, idx, player);
					
					/* Only enable the undo button when necessary */
					if (allPositions.empty())
					  window.enableUndoButton();
					
					allPositions.push(temp);
					allIndices.push(idx);

					if (idx == 0)
						window.disableButton(temp);
					
					/* The game is tied */
					if (ret.length() == 1 && window.gameTied()) {
					  int option;
					  
					  option = JOptionPane.showConfirmDialog(null, "Game Tied. Play Again?", 
					      null, JOptionPane.YES_NO_OPTION);
					  
					  if (option == JOptionPane.YES_OPTION) {
              board.clearBoard();
              window.clearBoard();
              window.enableButtons();
            }
					}
					
					/* Player won the game */
					if (ret.length() > 1) {
						/* Disable all the buttons */
						for (int j = 0; j < BOARD_WIDTH; ++j)
							window.disableButton(j);
						
						window.disableUndoButton();

						/* Highlight the winning pieces */
						for (int j = 0; j < 4; ++j) {
							int x = Character.getNumericValue(ret.charAt(2 * j + 1));
							int y = Character.getNumericValue(ret.charAt(2 * j + 2));
							window.highlightPiece(x, y);
						}

						int option;

						if (player == 'X') {
							option = JOptionPane.showConfirmDialog(null, 
							    "Game Over, Blue wins. Play Again?", 
							    null, JOptionPane.YES_NO_OPTION);
						} else {
							option = JOptionPane.showConfirmDialog(null, 
							    "Game Over, Red wins. Play Again?",
							    null, JOptionPane.YES_NO_OPTION);
						}

						/* If the user wants to play again */
						if (option == JOptionPane.YES_OPTION) {
							board.clearBoard();
							window.clearBoard();
							window.enableButtons();
						}
					}

					if (player == 'X')
						player = 'Y';
					else
						player = 'X';
				}
			});
		}
	}

	
	/**
	 * Sets up the undo action listener
	 */
	private void addUndoAction() {
	  window.addUndoActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        int pos = allPositions.pop();
        int idx = allIndices.pop();
        
        window.undoMove(pos, idx);
        board.undoMove(pos, idx);
        
        if (player == 'X')
          player = 'Y';
        else
          player = 'X';
        
        /* Disable the undo button if the user cannot undo any more */
        if (allPositions.empty())
          window.disableUndoButton();
      }	    
	  });
	}
}
