/* Shift + Alt + J to comment */

/**
 * Our board (model)
 * 
 * @author guiping
 *
 */
public class Board {

	/* Constants */
	private static final int BOARD_HEIGHT = 6;
	private static final int BOARD_WIDTH = 7;

	/* Board to hold the pieces, y-value then x-value */
	private char[][] board;

	
	/**
	 * Constructor for the Board class 
	 * Initializes the board to all empty characters
	 */
	public Board() {
		board = new char[BOARD_HEIGHT][BOARD_WIDTH];

		for (int i = 0; i < BOARD_HEIGHT; ++i) {
			for (int j = 0; j < BOARD_WIDTH; ++j)
				board[i][j] = ' ';
		}
	}

	
	/**
	 * Function to place a move onto the board
	 * 
	 * @param pos:
	 *            The position the player wants to put their piece (0 - 6),
	 *            x-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: encodes the index of the piece and the coordinates if the
	 *         player won
	 */
	public String placePiece(int pos, char player) {
		int idx = -1;
		for (int i = 5; i >= 0; --i) {
			if (board[i][pos] == ' ') {
				idx = i;
				board[i][pos] = player;
				break;
			}
		}

		/* If the player wins we return the coordinates of the piece */
		String ret;
		if ((ret = checkWin(pos, idx, player)) != "") 
		  return idx + ret;

		/* Else we return the index */
		return Integer.toString(idx);
	}

	
	/**
	 * Clears the board (sets everything to the space character) 
	 * Called if the user wants to play again
	 */
	public void clearBoard() {
		for (int i = 0; i < BOARD_HEIGHT; ++i) {
			for (int j = 0; j < BOARD_WIDTH; ++j)
				board[i][j] = ' ';
		}
	}
	
	
	/**
   * Called when a player undoes a move 
   * Clears the piece at the provided coordinates
   * 
   * @param pos:
   *            The position the player put their piece (0 - 6), x-value
   * @param idx:
   *            The index the player put their piece (0-5), y-value
   */
  public void undoMove(int pos, int idx) {
    board[idx][pos] = ' ';
  }

	
	/**
	 * Function to check whether a player has won or not 
	 * Position and player passed in so we do not have to check everything
	 *
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: The coordinates of the four pieces or 0 if the player
	 *         does not win
	 */
	private String checkWin(int pos, int idx, char player) {
		String ret = "";
		if ((ret = checkHoriz(pos, idx, player)) != "")
			return ret;

		if ((ret = checkVert(pos, idx, player)) != "")
			return ret;

		if ((ret = checkDiagRight(pos, idx, player)) != "")
			return ret;

		if ((ret = checkDiagLeft(pos, idx, player)) != "")
			return ret;

		return ret;
	}

	
	/**
	 * Function to check whether a player has won or not 
	 * Position and player passed in so we do not have to check everything 
	 * Helper for checkWin, checks the horizontal direction
	 *
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: The coordinates of the four pieces or 0 if the player
	 *         does not win
	 */
	private String checkHoriz(int pos, int idx, char player) {
		/* Start index x-axis */
		int start = Math.max(0, pos - 3);

		/* End index x-axis */
		int end = Math.min(4, pos + 1);

		/* Go through the loop until start equals end */
		while (start != end) {
			int count = 0;
			for (int i = 0; i < 4; ++i) {
				if (board[idx][i + start] == player)
					++count;
			}

			if (count == 4) {
				String ret = "";
				for (int i = 0; i < 4; ++i) {
					ret += Integer.toString(idx);
					ret += Integer.toString(i + start);
				}

				return ret;
			}

			++start;
		}

		return "";
	}

	
	/**
	 * Function to check whether a player has won or not 
	 * Position and player passed in so we do not have to check everything 
	 * Helper for checkWin, checks the vertical direction
	 *
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: The coordinates of the four pieces or 0 if the player
	 *         does not win
	 */
	private String checkVert(int pos, int idx, char player) {
		if (idx <= 2) {
			int start = idx + 3;
			for (int i = start; i >= idx; --i) {
				if (board[i][pos] != player)
					return "";
			}

			String ret = "";

			for (int i = start; i >= idx; --i) {
				ret += Integer.toString(i);
				ret += Integer.toString(pos);
			}

			return ret;
		}

		return "";
	}

	
	/**
	 * Function to check whether a player has won or not 
	 * Position and player passed in so we do not have to check everything 
	 * Helper for checkWin, checks the right diagonal direction: /
	 *
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: The coordinates of the four pieces or 0 if the player
	 *         does not win
	 */
	private String checkDiagRight(int pos, int idx, char player) {
		int diagSum = pos + idx;
		if ((diagSum > 2) && (diagSum < 9)) {
			int before = Math.min(3, Math.min(5 - idx, pos));
			int after = Math.min(3, Math.min(idx, 6 - pos));
			int squares = before + after + 1;

			int start = 0;
			int end = squares - 3;

			while (start != end) {
				int count = 0;
				for (int i = 0; i < 4; ++i) {
					if (board[idx + before - start - i][pos - before + start + i] == player)
						++count;
				}

				if (count == 4) {
					String ret = "";

					for (int i = 0; i < 4; ++i) {
						ret += Integer.toString(idx + before - start - i);
						ret += Integer.toString(pos - before + start + i);
					}

					return ret;
				}

				++start;
			}
		}

		return "";
	}

	
	/**
	 * Function to check whether a player has won or not 
	 * Position and player passed in so we do not have to check everything 
	 * Helper for checkWin, checks the left diagonal direction: \
	 *
	 * @param pos:
	 *            The position the player put their piece (0 - 6), x-value
	 * @param idx:
	 *            The index the player put their piece (0-5), y-value
	 * @param player:
	 *            The player, X or Y
	 * @return String: The coordinates of the four pieces or 0 if the player
	 *         does not win
	 */
	private String checkDiagLeft(int pos, int idx, char player) {
		int diagSum = pos + 5 - idx;
		if ((diagSum > 2) && (diagSum < 9)) {
			int before = Math.min(3, Math.min(idx, pos));
			int after = Math.min(3, Math.min(5 - idx, 6 - pos));
			int squares = before + after + 1;

			int start = 0;
			int end = squares - 3;

			while (start != end) {
				int count = 0;
				for (int i = 0; i < 4; ++i) {
					if (board[idx - before + start + i][pos - before + start + i] == player)
						++count;
				}

				if (count == 4) {
					String ret = "";

					for (int i = 0; i < 4; ++i) {					
						ret += Integer.toString(idx - before + start + i);
						ret += Integer.toString(pos - before + start + i);
					}

					return ret;
				}

				++start;
			}
		}

		return "";
	}
}
