/**
 * 
 */

/* Shift + Alt + J to comment */

/**
 * @author guiping
 *
 */
public class Board {
  
  /* Board to hold the pieces, y-value then x-value */
  private char[][] board;
  
  
  /**
   * Constructor for the Board class
   * Initializes the board to all empty characters
   */
  public Board() {
    board = new char[6][7];
        
    for (int i = 0; i < 6; ++i) {
      for (int j = 0; j < 7; ++j)
        board[i][j] = ' ';
    }
  }
	
  
  /**
   * Function to place a move onto the board
   * 
   * @param pos: The position the player wants to put their piece (0 - 6), x-value
   * @param player: The player, X or Y
   * @return int: encodes the index of the piece and if the player won
   */
  public int placePiece(int pos, char player) {
    int idx = 0;
    for (int i = 5; i >= 0; --i) {
      if (board[i][pos] == ' ') {
        idx = i;
        board[i][pos] = player;
        break;    
      }  
    }
    
    /* If the player won we add 10 to the index of the piece */
    if (checkWin(pos, idx, player))
      return 10 + idx;
    return idx;
  }

  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, X or Y
   * @return boolean to indicate if the player won or not
   */
  private boolean checkWin(int pos, int idx, char player) {
    if (checkHoriz(pos, idx, player)) {
      return true;
    }
    
    if (checkVert(pos, idx, player)) {
      return true;
    }
    
    if (checkDiagRight(pos, idx, player)) {
      return true;
    }
    
    if (checkDiagLeft(pos, idx, player)) {
      return true;
    }
    
    return false;
  }
  
  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   * Helper for checkWin, checks the horizontal direction
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, X or Y
   * @return boolean to indicate if the player won or not
   */
  private boolean checkHoriz(int pos, int idx, char player) {
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
      
      if (count == 4)
        return true;
      
      ++start;
    }
    
    return false;
  }

  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   * Helper for checkWin, checks the vertical direction
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, X or Y
   * @return boolean to indicate if the player won or not
   */
  private boolean checkVert(int pos, int idx, char player) {
    if (idx <= 2) {
      int start = idx + 3;
      for (int i = start; i >= idx; --i) {
        if (board[i][pos] != player)
          return false;
      }
      
      return true; 
    }
    
    return false;
  }
  
  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   * Helper for checkWin, checks the right diagonal direction: /
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, X or Y
   * @return boolean to indicate if the player won or not
   */
  private boolean checkDiagRight(int pos, int idx, char player) {
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
        
        if (count == 4)
          return true;
        
        ++start;
      }
    }
    
    return false;
  }
  
  
  /**
   * Function to check whether a player has won or not
   * Position and player passed in so we do not have to check everything
   * Helper for checkWin, checks the left diagonal direction: \
   *
   * @param pos: The position the player put their piece (0 - 6), x-value
   * @param idx: The index the player put their piece (0-5), y-value
   * @param player: The player, X or Y
   * @return boolean to indicate if the player won or not
   */
  private boolean checkDiagLeft(int pos, int idx, char player) {
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
        
        if (count == 4)
          return true;
        
        ++start;
      }
    }
    
    return false; 
  }
}
