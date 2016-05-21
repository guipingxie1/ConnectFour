import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author guiping
 *
 */
public class Controller {
  /* Constaints */
  private static final int BOARD_HEIGHT = 6;
  private static final int BOARD_WIDTH = 7;
  
  /* Required objects to run the game */
  static Board board;
  static Interface window;
  
  /* Player one: 'X', alternates to 'Y' */
  private static char player;

  
  /**
   * @param args
   */
  public static void main(String[] args) {
    window = new Interface();
    board = new Board();
    player = 'X';
    
    addActionListeners();
  }

  
  /**
   * Helper to create the action listeners required for the buttons
   */
  private static void addActionListeners() {
    for (int i = 0; i < BOARD_WIDTH; ++i) {
      final int temp = i;
      window.addButtonActionListener(i, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          int ret = board.placePiece(temp, player);     
          int idx = ret % 10;
          window.setPiecePanel(temp, idx, player);
          
          System.out.println(ret);
          System.out.println(temp);
          System.out.println(idx);
          
          if (idx == 0)
            window.disableButton(temp);
          
          /* Player won the game */
          if (ret > 10) {
            for (int j = 0; j < BOARD_WIDTH; ++j)
              window.disableButton(j);
            
            JOptionPane.showMessageDialog(null, "Game Over", "Game Over", 
                JOptionPane.INFORMATION_MESSAGE); 
          }
          
          if (player == 'X') 
            player = 'Y';
          else player = 'X';
        }
      });
    }
  }
  
}
