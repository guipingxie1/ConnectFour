import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

  
  /**
   * Constructor for the controller 
   */
  public Controller() {
    window = new Interface();
    board = new Board();
    player = 'X';
    
    addActionListeners();
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
          int idx = ret % 10;
          window.setPiecePanel(temp, idx, player);
        
          if (idx == 0)
            window.disableButton(temp);
          
          /* Player won the game */
          if (ret >= 10) {
            for (int j = 0; j < BOARD_WIDTH; ++j)
              window.disableButton(j);
            
            int option;
            
            if (player == 'X') {
              option = JOptionPane.showConfirmDialog(null, "Game Over, Blue wins. Play Again?", 
                  null, JOptionPane.YES_NO_OPTION); 
            }
            else {
              option = JOptionPane.showConfirmDialog(null, "Game Over, Red wins. Play Again?", 
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
          else player = 'X';
        }
      });
    }
  }
  
}
