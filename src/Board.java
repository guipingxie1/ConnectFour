/**
 * 
 */

/* Shift + Alt + J to comment */

/**
 * @author guiping
 *
 */
public class Board {
  
  /* Board to hold the pieces */
  private char[][] board = new char[6][7];

  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, true is player one
   */
  private static void checkWin(int pos, int idx, boolean player) {
    
    
  }
  
  /**
   * Constructor for the Board class
   * Initializes the board to all empty characters
   */
  public Board() {
    for (int i = 0; i < 6; ++i) {
      for (int j = 0; j < 7; ++j)
        board[i][j] = ' ';
    }
  }
	
  /**
   * Function to place a move onto the board
   * 
   * @param pos: The position the player wants to put their piece (0 - 6)
   * @param player: The player, true is player one
   */
  public void placePiece(int pos, boolean player) {
    int idx = 0;
    for (int i = 5; i >= 0; --i) {
      if (board[i][pos] == ' ') {
        idx = i;
        if (player)
          board[i][pos] = 'X';
        else board[i][pos] = 'Y'; 
        
        break;    
      }  
    }
    
    checkWin(pos, idx, player);
  }

}
